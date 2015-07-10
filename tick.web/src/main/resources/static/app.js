var app = angular.module('tick', ['ngRoute', 'stationController', 'routeController', 'scheduleController', 'calendarDirective']);

app.config(function ($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                controller: 'StationController',
                templateUrl: 'scripts/views/station.html'
            }).when('/schedule', {
                controller: 'RouteController',
                templateUrl: 'scripts/views/schedule.html'
            })
            .otherwise({
                redirectTo: '/'
            });
    });

