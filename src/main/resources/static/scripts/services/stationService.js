angular.module('stationService', []).factory('stationService', function () {
    var from = {};
    var to = {};

    var arrivals = [];
    var departures = [];

    var bookingRequest = {};

    return {
        setFrom: function (station) {
            from = station;
        },

        getFrom: function () {
            return from;
        },

        setTo: function (station) {
            to = station;
        },

        getTo: function () {
            return to;
        },

        setArrivals: function (stations) {
            arrivals = stations;
        },

        getArrivals: function () {
            return arrivals;
        },

        setDepartures: function (stations) {
            departures = stations;
        },

        getDepartures: function () {
            return departures;
        },

        setBookingRequest: function (request) {
            bookingRequest = request;
        },

        getBookingRequest: function () {
            return bookingRequest;
        }
    };
});
