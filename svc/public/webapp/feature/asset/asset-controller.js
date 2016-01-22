"use strict";

(function () {

    angular.module('app')
        .controller("assetController",
        ["assetRepository", AssetCtrl]);

    function AssetCtrl(assetRepository ) {
        var vm = this;

        vm.controllerName = "assetController";

        assetRepository.getAsset().then(function (results) {
        console.log("***CONTROLLER in success the value of results is***");
                            console.log(results);
             vm.asset = results;
         }, function (error) {
             vm.error = true;
             vm.errorMessage = error;
         });
    }
}());