/* global CONTEXT */

(function () {
    'use strict';
    angular
            .module('app')
            .controller('loginController', loginController)
            .factory('loginService', loginService)
            .factory('iInterface', iInterface)
            .factory('iPopUp', iPopUp)
            .constant('loginConstant', {
                SERVICE_CANDIDATOS:  'registroCandidatos/',

                M_CLOSE:0,
                M_USER_CREATE:1,
                M_PASS_FORGOT:2,
                M_PASS_CHANGE:3
                
                
            });
    loginController.$inject = ['$timeout', '$scope', 'loginConstant', 'loginService','$location', 'iPopUp', 'iInterface'];
    function loginController($timeout, $scope, iConstant, Service, $location, iPopUp, Interface) {

        var self = this;
        self.const = iConstant;

        self.iEvent = iEvent;
        self.iModal = iModal;
        self.iSubmit = iSubmit;


        
        function iModal(type){
            switch (type) {
                case iConstant.M_USER_CREATE:
                    self.user = Interface.IUser();
                    iPopUp.open($scope, "createUser");
                    break;
                case iConstant.M_PASS_FORGOT:
                    iPopUp.open($scope, "forgotPassword");
                    break;
                case iConstant.M_PASS_CHANGE:
                    iPopUp.open($scope, "changePassword");
                    break;
                case iConstant.M_CLOSE:
                    iPopUp.close();
                    break;                    
            }            
        }

        function iSubmit(type){
            switch (type) {
                case iConstant.M_USER_CREATE:
                    break;
                case iConstant.M_PASS_FORGOT:

                    break;
                case iConstant.M_PASS_CHANGE:

                    break;
                case iConstant.M_CLOSE:

                    break;                    
            }                
            
        }
        
        function iEvent(type, form, param){
            if(type === iConstant.M_USER_CREATE){
                if(param.length>0 && self.user.palabraClave){
                    if(param === self.user.palabraClave){
                        form.word2.$error.validationError = false;                     
                    }else{
                        form.word2.$error.validationError = true;
                    }     
                }else{
                    form.word2.$error.validationError = false;
                }
            }
        }

    }

    iPopUp.$inject = ['$mdDialog', 'loginConstant'];
    function iPopUp($mdDialog, IConstants) {        
        return {
            open: function ($scope, template) {
                $mdDialog.show({            
                    templateUrl: 'popup/'+template,
                    parent: angular.element(document.body),
                    targetEvent: null,
                    scope: $scope,
                    preserveScope: true,
                    fullscreen: false,
                    clickOutsideToClose: false,
                    escapeToClose: false

                }).then(function (adjunto) {

                }, function () {

                });
            },            
            close: function () {
                $mdDialog.cancel();
            }
        };        
    };    

    iInterface.$inject = ['loginConstant'];
    function iInterface(IConstants) {

        return {
            IUser: function () {
                var temp = {
                    id:null,
                    apellidos:"",
                    nombres:"",
                    correo:"",
                    codigo:"",
                    palabraClave:""
                };                  
                return temp;
            },
            IUserEx: function () {
                var temp = {
                    id:null,
                    apellidos:"",
                    nombres:"",
                    correo:"",
                    codigo:"",
                    palabraClave:""
                };                  
                return temp;
            }           
        };

    };        
    
    loginService.$inject = ['$http', '$q', 'loginConstant'];
    function loginService($http, $q, Constant) {

        var context = Constant.SERVER + 'services/';
        return {
            getListData: function (code) {
                var deferred = $q.defer();
                $http({
                    url: context + 'data',
                    method: 'POST',
                    data: code,                    
                    headers: {'Content-Type': 'application/json'}
                }).then(
                    function (response) {
                        deferred.resolve(response.data);
                    },
                    function (errResponse) {
                        console.error('Error: Service.');
                        deferred.reject(errResponse);
                    }
                );
                return deferred.promise;
            },

            submiData: function (params) {
                var deferred = $q.defer();
                $http({
                    url: context + 'data/save',
                    method: 'POST',
                    data: params,                    
                    headers: {'Content-Type': 'application/json'}
                }).then(
                    function (response) {
                        deferred.resolve(response.data);
                    },
                    function (errResponse) {
                        console.error('Error: Service.');
                        deferred.reject(errResponse);
                    }
                );
                return deferred.promise;
            },

            removeData: function (params) {
                var deferred = $q.defer();
                $http({
                    url: context + 'data/remove',
                    method: 'POST',
                    data: params,                    
                    headers: {'Content-Type': 'application/json'}
                }).then(
                    function (response) {
                        deferred.resolve(response.data);
                    },
                    function (errResponse) {
                        console.error('Error: Service.');
                        deferred.reject(errResponse);
                    }
                );
                return deferred.promise;
            }              
        };
    }


})();