"use strict";

(function () {

    angular.module('app')
        .controller("assetItemController",
        ["$state", "assetRepository", AssetItemCtrl]);

    function AssetItemCtrl($state, assetRepository) {
        var vm = this;

        vm.controllerName = "assetItemController";

        vm.delete = function (asset) {
            var waitingDialog;
            BootstrapDialog.confirm({
                message: 'Are you sure that you want to delete this asset?',
                type: BootstrapDialog.TYPE_WARNING,
                btnOKLabel: 'Delete!',
                btnOKClass: 'btn-warning',
                callback: function (confirmed) {
                    if (confirmed) {
                        waitingDialog = BootstrapDialog.show({
                            message: 'Please wait - Deleting asset'
                        });
                        assetRepository.deleteAsset(asset).then(function () {
                            waitingDialog.close();
                        }, function (error) {

                        });
                    }
                }
            })
        };

        vm.amend = function (asset) {
			vm.error = true;
            vm.errorMessage = error;
        };
    }

}());