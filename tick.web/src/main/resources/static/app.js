(function () {
    var app = angular.module('tick', []);

    app.controller("ScheduleController", function ($rootScope, $scope, $http, scheduleService) {
        var firstStation = "SDS";
        var lastStation = "LVL";
        $http.get('schedule?firstStation=' + firstStation + '&lastStation=' + lastStation).
            success(function (data, status, headers, config) {
                console.log("From ScheduleController " + scheduleService.getSchedule());
                $rootScope.$broadcast('XChanged', data);
            }).
            error(function (data, status, headers, config) {
                // log error
            });

        $scope.$on('XChanged', function (event, x) {
            $scope.schedule = x;
            console.log("From XChanged " + x);
        });
    });

    app.controller("RouteController", function ($rootScope, $scope, $http) {
        $scope.begin = '';
        $scope.end = '';

        this.findRoute = function () {
            $http.get('schedule?firstStation=' + $scope.begin + '&lastStation=' + $scope.end).
                success(function (data, status, headers, config) {
                    $rootScope.$broadcast('XChanged', data);
                }).
                error(function (data, status, headers, config) {
                    console.log(status);
                    console.log(data);
                });
        };

        $scope.$on('AChanged', function (event, x) {
            console.log("AChanged=", x);
            $scope.begin = x;
        });

        $scope.$on('DChanged', function (event, x) {
            console.log("DChanged=", x);
            $scope.end = x;
        });
    });

    app.controller("StationController", function ($rootScope, $scope, $http, stationService) {

        $scope.criteria = {arrivalsCriteria: "st1", departuresCriteria: "st2"};

        this.findArrivals = function () {
            $http.get('station/arrivals/' + $scope.criteria.arrivalsCriteria).
                success(function (data, status, headers, config) {
                    $scope.arrivals = data;
                    $rootScope.$broadcast('ArrivalsChanged', data);
                }).
                error(function (data, status, headers, config) {
                    console.log(status);
                    console.log(data);
                });
        };

        this.findDepartures = function () {
            $http.get('station/departures/' + $scope.criteria.departuresCriteria,
                {
                    headers: {
                        "Accept": "application/json;charset=utf-8"
                    }
                }).
                success(function (data, status, headers, config) {
                    $scope.departures = data;
                    $rootScope.$broadcast('DeparturesChanged', data);
                }).
                error(function (data, status, headers, config) {
                    console.log(status);
                    console.log(data);
                });
        };

        this.setDeparture = function (stationName) {
            console.log(stationName);
            //stationService.setDeparture(stationName);
            $rootScope.$broadcast('DChanged', stationName);
        };

        this.setArrival = function (stationName) {
            console.log(stationName);
            //stationService.setArrival(stationName);
            $rootScope.$broadcast('AChanged', stationName);
        };

        $scope.$on('ArrivalsChanged', function (event, x) {
            $scope.arrivals = x;
            console.log("From XChanged " + x);
        });

        $scope.$on('DeparturesChanged', function (event, x) {
            $scope.departures = x;
            console.log("From XChanged " + x);
        });

    });

    app.factory('scheduleService', function () {
        var schedule = {};
        return {
            setSchedule: function (sched) {
                schedule = sched;
            },
            getSchedule: function () {
                return schedule;
            }
        };
    });

    app.factory('stationService', function () {
        var departure = "";
        var arrival = "";
        return {
            setDeparture: function (station) {
                departure = station;
            },
            getDeparture: function () {
                return departure;
            },
            setArrival: function (station) {
                arrival = station;
            },
            getArrival: function () {
                return arrival;
            }
        };
    });

})();