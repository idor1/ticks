<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html lang="en">
<head>
    <title>Main jsp</title>
</head>
<body>
    <%--<c:url value="/resources/text.txt" var="url"/>--%>
    <spring:url value="main.url" htmlEscape="true" var="springUrl"/>
    Spring URL: ${springUrl} at ${time}
    <br>
        JSTL URL: ${url}
    <br>
        Message: ${message}
</body>
</html>
