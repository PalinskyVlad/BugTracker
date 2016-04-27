<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Congratulations!</title>
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
</head>
<body>
<jsp:include page='../jspf/navigation.jsp' />
<div class = "contatiner">

    <div class="jumbotron" style="width: 50%;margin-top: 20px; margin: 0 auto">
        <div></div>
        <h1>Your account confirmed!</h1>
    </div>

    <div>
        Your can log in.
    </div>
    <div>
        <a href="/login">Click here to login in.</a>
    </div>

    <div class="footer">
        <p>© BugHunter 2016</p>
    </div>
</div>
</body>
</html>
