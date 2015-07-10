angular.module('stationController', ['stationService']).controller("StationController", function ($rootScope, $scope, $http, stationService) {
    $scope.arrivals = stationService.getArrivals();
    $scope.departures = stationService.getDepartures();

    $scope.criteria = {departuresCriteria: "Ки", arrivalsCriteria: "Ль"};

    this.findArrivals = function () {
        $http.get('station/arrivals/' + $scope.criteria.arrivalsCriteria).
            success(function (data, status, headers, config) {
                $scope.arrivals = data;
                stationService.setArrivals(data);
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
                stationService.setDepartures(data);
                $rootScope.$broadcast('DeparturesChanged', data);
            }).
            error(function (data, status, headers, config) {
                console.log(status);
                console.log(data);
            });
    };

    this.setDeparture = function (station) {
        console.log(station.name);
        stationService.setFrom(station);
        $rootScope.$broadcast('DChanged', station);
    };

    this.setArrival = function (station) {
        console.log(station.name);
        stationService.setTo(station);
        $rootScope.$broadcast('AChanged', station);
    };

    $scope.$on('ArrivalsChanged', function (event, x) {
        $scope.arrivals = stationService.getArrivals();
        console.log("From XChanged " + x);
    });

    $scope.$on('DeparturesChanged', function (event, x) {
        $scope.departures = stationService.getDepartures();
        console.log("From XChanged " + x);
    });

});
