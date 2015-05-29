<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html ng-app="tick">
<head>
    <title>Main</title>
</head>
<body>

<div ng-controller="TickController as tick">
    <h1> {{tick.product.name}} </h1>
    <h2> {{tick.product.price}} </h2>
    <p> {{tick.product.description}} </p>
</div>

<div ng-controller="ScheduleController as schedule">
    <div ng-repeat="train in schedule.trains">
        <h1> {{train}} </h1>
    </div>
</div>

<script type="text/javascript" src="angular.js"></script>
<script type="text/javascript" src="app.js"></script>

</body>
</html>
