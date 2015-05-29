(function () {
    var app = angular.module('tick', []);

    app.controller('TickController', function () {
        this.product = prod;
    });

    app.controller("ScheduleController", function ($scope, $http) {
        var firstStation = "KBP";
        var lastStation = "LVL";
        $http.get('schedule?firstStation=' + firstStation + '&lastStation=' + lastStation).
            success(function (data, status, headers, config) {
                $scope.schedule = data;
            }).
            error(function (data, status, headers, config) {
                // log error
            });
    });

    var prod = {
        name: 'Prod111',
        price: 2.95,
        description: '...'
    }
})();