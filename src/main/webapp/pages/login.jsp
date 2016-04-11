<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Log in IT</title>
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
</head>

<body>

<jsp:include page='navigation.jsp' />
    <div class = "container" style="margin-top: 2%">
    <div class="jumbotron" style="width: 50%; margin: auto">

        <h2 class="form-signin-heading" style="margin-top: 0"><spring:message code="log.in.welcome"/></h2>
        <c:url value="/j_spring_security_check" var="loginUrl" />
        <form class="form-horizontal" action="${loginUrl}" method="post">

            <div class="form-group">
                <label class="col-lg-3 control-label" accesskey="u" for="login-form-username"><spring:message code="log.in.username"/></label>
                <div class="col-lg-7">
                    <input  style="width: 80%;" type="text" id = "login-form-username"class="form-control" name="j_username">
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-3 control-label" accesskey="p" for="login-form-password" id="passwordlabel"><spring:message code="log.in.password"/></label>
                <div class="col-lg-7">
                    <input style="width: 80%;" type="password" id = "login-form-password" class="form-control" name="j_password">
                </div>
            </div>

            <div class="form-group" style="margin-top: 0; margin-bottom: 1%;">
                <label class="col-lg-3 control-label"></label>
                <div class="checkbox col-lg-7">
                    <label >
                        <input type="checkbox" value="remember-me">
                        <spring:message code="log.in.message.remember.me"/>
                    </label>
                </div>
            </div>

            <div class="form-group" style="margin-top: 0; margin-bottom: 1%;">
                <label class="col-lg-3 control-label"></label>
                <div class="col-lg-7">
                    <spring:message code="log.in.message.not.member"/> <a href="/signup"> <spring:message code="log.in.sign.up"/></a>
                </div>
            </div>

            <div class="form-group" style="margin-top: 0; margin-bottom: 1%;">
                <label class="col-lg-3 control-label"></label>
                <div class = "button col-lg-7">
                    <button class="btn btn-sm btn-primary btn-primary" type="submit"><spring:message code="log.in.log.in"/></button>
                    <a href="/signup"> <spring:message code="log.in.message.forgot.password"/></a>
                </div>
            </div>

        </form>
    </div>


    <div class="footer">
        <p>© BugHunter 2016</p>
    </div>



</div>
</body>
</html>




