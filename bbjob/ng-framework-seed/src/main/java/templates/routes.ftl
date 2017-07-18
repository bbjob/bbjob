(function() {
    'use strict';

    angular
        .module('app.routes')
        .config(routesConfig);

    routesConfig.$inject = ['$stateProvider', '$locationProvider', '$urlRouterProvider', 'RouteHelpersProvider'];
    function routesConfig($stateProvider, $locationProvider, $urlRouterProvider, helper){
        
        // Set the following to true to enable the HTML5 Mode
        // You may have to set <base> tag in index and a routing configuration in your server
        $locationProvider.html5Mode(false);

        // defaults to dashboard
        $urlRouterProvider.otherwise('/app/sysuser');

        // 
        // Application Routes
        // -----------------------------------   
        $stateProvider
          .state('app', {
              url: '/app',
              abstract: true,
              templateUrl: helper.basicpath('app.html'),
              resolve: helper.resolveFor('modernizr', 'icons',
									'toaster', 'loaders.css', 'app.css',
									'spinkit', 'animo', 'sparklines',
									'classyloader', 'whirl', 'ngDialog')
          })
          
          
          //定制信息从此开始
          ${customRoutes};

    } // routesConfig

})();

