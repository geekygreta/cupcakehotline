'use strict';

// Declare app level module which depends on views, and components
angular.module('cupcakeHotline', [
  'ngRoute',
  'mgcrea.ngStrap',
  'pascalprecht.translate',

  'cupcakeHotline.view1',
  'cupcakeHotline.view2',
  'cupcakeHotline.version',
])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/view1'});
}])

.config(function($translateProvider) {
  $translateProvider.preferredLanguage('en_US');
  $translateProvider.useStaticFilesLoader({
    prefix: '/locale/',
    suffix: '.json'
  });
});