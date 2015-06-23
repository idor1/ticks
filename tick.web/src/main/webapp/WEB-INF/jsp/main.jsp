<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html ng-app="tick">
<head>
    <title>Main</title>
    <meta charset="utf-8">
</head>
<body>

<div ng-controller="StationController as stationController">
    Arrivals first letters: <input type="text" ng-model="criteria.arrivalsCriteria"/>
    <button ng-click="stationController.findArrivals()">Arrivals Search</button>
    <br/>
    Departures first letters: <input type="text" ng-model="criteria.departuresCriteria"/>
    <button ng-click="stationController.findDepartures()">Departures Search</button>
    <br/>
    <%--<button ng-click="routeController.findRoute()">Search</button>--%>

    <%--<div ng-controller="ScheduleController as scheduleController">--%>
    <br/>
    Departures:<br/>

    <div ng-repeat="station in departures">
        <a href="" ng-click="stationController.setDeparture(station.name)">{{station.name}}</a><br/>
    </div>
    Arrivals:<br/>

    <div ng-repeat="station in arrivals">
        <a href="" ng-click="stationController.setArrival(station.name)">{{station.name}}</a><br/>
    </div>
</div>

<br/><br/>

<div ng-controller="RouteController as routeController">
    First station: {{begin}}<br/>
    Last station: {{end}}<br/>
    <button ng-click="routeController.findRoute()">Search route</button>
</div>

<script type="text/javascript" src="angular.js"></script>
<script type="text/javascript" src="app.js"></script>

</body>
</html>
