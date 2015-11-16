angular.module('scheduleService', []).factory('scheduleService', function () {
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
