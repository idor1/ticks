angular.module('trainController', ['stationService']).controller("TrainController", function ($rootScope, $scope, $http, $location, stationService) {

    $scope.bookingRequest = stationService.getBookingRequest();
    console.log($scope.bookingRequest);

    $scope.referenceNumber = "";

        this.booking = function () {
        $http.post('booking', $scope.bookingRequest).
            success(function (data, status, headers, config) {
                console.log('Schedule called');
                console.log(data);
                $scope.referenceNumber = data;
                $scope.go('schedule');
                $rootScope.$broadcast('SChanged', data);
            }).
            error(function (data, status, headers, config) {
                console.log(status);
                console.log(data);
            });
    };

    $scope.go = function (path) {
        console.log('Go called');
        $location.path("/" + path);
    };
});