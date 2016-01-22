"use strict";

(function () {

    angular.module('app')
        .controller("assetAddController",
        ["$log", "assetRepository", "$state", AssetFormCtrl]);

    function AssetFormCtrl($log, assetRepository, $state) {
        var vm = this;

        vm.hasValidationError = false;

        vm.asset = {};

        vm.saveAsset = function (assetForm) {
            $log.debug("assetFormController: saveRequirement");

            vm.hasValidationError = false;
            vm.hasSubmitError = false;

            var waitingDialog = BootstrapDialog.show({
                message: 'Please wait - Creating New Asset'
            });

            assetRepository.saveAsset(vm.asset).then(function (asset) {
                waitingDialog.close();
                BootstrapDialog.show({
                    message: 'Asset Saved successfully',
                    buttons: [{
                        id: 'button-close',
                        label: 'Close',
                        action: function (dialogWindow) {
                            dialogWindow.close();
                            $state.go("home.asset");
                        }
                    }]
                });
            }, function (error) {
                vm.error = true;
				vm.errorMessage = error;
                waitingDialog.close();
            });

        };

        vm.cancel = function (assetForm) {
            $state.go("home.asset");
            $log.debug("In controller cancel");
        }
   }
}());
