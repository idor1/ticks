var app = angular.module('tick', ['ngRoute', 'stationController', 'routeController', 'scheduleController']);

app.config(function ($routeProvider) {
        $routeProvider
            .when('/schedule', {
                controller: 'ScheduleController',
                templateUrl: 'scripts/views/schedule.html'
            })
            .otherwise({
                redirectTo: '/'
            });
    });

