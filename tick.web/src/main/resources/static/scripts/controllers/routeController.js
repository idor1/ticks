angular.module('routeController', ['stationService']).controller("RouteController", function ($rootScope, $scope, $http, $location, stationService) {
    $scope.bookingRequest = {
        from: {
            name: "",
            idx: ""
        },
        to: {
            name: "",
            idx: ""
        },
        trainId : "724",
        email: "igor.doroshenko@gmail.com",
        passengers: [
            {
                firstName: "Игорь",
                lastName: "Дорошенко"
            },
            {
                firstName: "",
                lastName: ""
            },
            {
                firstName: "",
                lastName: ""
            },
            {
                firstName: "",
                lastName: ""
            }
        ]
    };

    $scope.referenceNumber = "123";

        this.booking = function () {
        $http.post('booking', $scope.bookingRequest).
            success(function (data, status, headers, config) {
                console.log('Schedule called');
                $scope.go('schedule');
                $rootScope.$broadcast('SChanged', data);
            }).
            error(function (data, status, headers, config) {
                console.log(status);
                console.log(data);
            });
    };

    $scope.$on('DChanged', function (event, x) {
        console.log("DChanged=", x);
        $scope.bookingRequest.from.idx = x.idx;
        $scope.bookingRequest.from.name = x.name;
    });

    $scope.$on('AChanged', function (event, x) {
        console.log("AChanged=", x);
        $scope.bookingRequest.to.idx = x.idx;
        $scope.bookingRequest.to.name = x.name;
    });

    $scope.go = function (path) {
        console.log('Go called');
        $location.path("/" + path);
    };
});
