angular.module('scheduleController', ['scheduleService']).controller("ScheduleController", function ($rootScope, $scope, $http, scheduleService) {
    var firstStation = "SDS";
    var lastStation = "LVL";
    $http.get('schedule?start=' + firstStation + '&destination=' + lastStation).
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
