"use strict";

(function () {

    angular.module('app')
        .controller("assetController",
        ["assetRepository", AssetCtrl]);

    function AssetCtrl(assetRepository ) {
        var vm = this;

        vm.controllerName = "assetController";

        assetRepository.getAssets().then(function (results) {
             vm.projects = results;
         }, function (error) {
             vm.error = true;
             vm.errorMessage = error;
         });
    }
}());