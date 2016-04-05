<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Congratulations!</title>
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">
</head>
<body>
<jsp:include page='navigation.jsp' />
<div class = "contatiner">

    <div class="jumbotron" style="width: 50%;margin-top: 20px; margin: 0 auto">
        <div></div>
        <h1>Congratulations!</h1>
    </div>

    <div>
        You have successfully signed up. If you forget your password, you can have it emailed to you.
    </div>
    <div>
        <a href="login">Click here to login in.</a>
    </div>

    <div class="footer">
        <p>© BugHunter 2016</p>
    </div>
</div>
</body>
</html>
