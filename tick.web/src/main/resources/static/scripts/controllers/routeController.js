angular.module('routeController', ['stationService']).controller("RouteController", function ($rootScope, $scope, $http, $location, stationService) {
    $scope.from = '';
    $scope.to = '';

    this.findRoute = function () {
        $http.get('schedule?start=' + $scope.from + '&destination=' + $scope.to).
            success(function (data, status, headers, config) {
                $rootScope.$broadcast('XChanged', data);
                $scope.go('schedule');
            }).
            error(function (data, status, headers, config) {
                console.log(status);
                console.log(data);
            });
    };

    $scope.$on('AChanged', function (event, x) {
        console.log("AChanged=", x);
        $scope.to = x;
    });

    $scope.$on('DChanged', function (event, x) {
        console.log("DChanged=", x);
        $scope.from = x;
    });

    $scope.go = function (path) {
        $location.path("/" + path);
    };
});
