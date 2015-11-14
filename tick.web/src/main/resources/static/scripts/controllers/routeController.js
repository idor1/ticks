angular.module('routeController', ['stationService']).controller("RouteController", function ($rootScope, $scope, $http, $location, stationService) {
    $rootScope.bookingRequest = {
        from: {
            name: "",
            idx: ""
        },
        to: {
            name: "",
            idx: ""
        },
        vars : {},
        date : "",
        trainId : "",
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

        this.searchTrainNumbers = function () {
        $http.get('variants?from=' + $rootScope.bookingRequest.from.idx +
            '&to=' + $rootScope.bookingRequest.to.idx + '&date=' + $rootScope.bookingRequest.date).
            success(function (data, status, headers, config) {
                console.log('Variants called');
                console.log(data);
                $scope.bookingRequest.vars = data.vars;
                stationService.setBookingRequest($rootScope.bookingRequest);
                $scope.go('trains');
            }).
            error(function (data, status, headers, config) {
                console.log(status);
                console.log(data);
            });
    };

    $scope.$on('DChanged', function (event, x) {
        console.log("DChanged=", x);
        $rootScope.bookingRequest.from.idx = x.idx;
        $rootScope.bookingRequest.from.name = x.name;
    });

    $scope.$on('AChanged', function (event, x) {
        console.log("AChanged=", x);
        $rootScope.bookingRequest.to.idx = x.idx;
        $rootScope.bookingRequest.to.name = x.name;
    });

    $scope.go = function (path) {
        console.log('Go called');
        $location.path("/" + path);
    };
});
