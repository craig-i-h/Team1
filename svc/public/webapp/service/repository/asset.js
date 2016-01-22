"use strict";

(function () {


    angular.module("app").service("assetRepository", ["$q", "$log", "assetDal", AssetRepo]);

    function AssetRepo($q, $log, assetDal) {

        var assetCache = [];
        console.log("This is asset cache");


        this.getAsset = function (criteria) {
            $log.debug("Repository:Asset getAsset");

            var deferred = $q.defer();
            assetDal.getAsset(criteria).then(function (results) {
            console.log("***Repository in success the value of results is***");
                    console.log(results);
                assetCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };


        this.saveAsset = function (assetToSave) {
            $log.debug("Repository:Asset - saveAsset");

            var deferred = $q.defer();
            var isUpdate = assetToSave.hasOwnProperty("id");


            $log.debug("isUpdate = " + isUpdate);
            $log.debug(JSON.stringify(assetToSave));

            assetDal.saveAsset(assetToSave).then(function (asset) {

                if (!isUpdate) {
                    assetCache.push(asset);
                }
                deferred.resolve(asset);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };

        this.deleteAsset = function (assetToDelete) {
            $log.debug("Repository:Asset - deleteAsset");

            var deferred = $q.defer();
            assetDal.deleteAsset(assetToDelete).then(function (assets) {
                _.remove(assetCache, {
                    id: assetToDelete.id
                });

                deferred.resolve(assetCache);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };

        $log.debug("Repository:Asset Instantiated");
    }
}());