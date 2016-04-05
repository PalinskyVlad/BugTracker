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
    <title>Log in BugHunter</title>
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
</head>

<body>

<jsp:include page='navigation.jsp' />
    <div class = "container">
    <div class="jumbotron" style="width: 50%;margin-top: 20px; margin: 0 auto">

        <h2 class="form-signin-heading"><spring:message code="log.in.welcome"/></h2>
        <c:url value="/j_spring_security_check" var="loginUrl" />
        <form action="${loginUrl}" method="post">

            <div class="field-group">
                 <label accesskey="u" for="login-form-username"><spring:message code="log.in.username"/></label></td>
                 <td><input  style="width: 60%;" type="text" id = "login-form-username"class="form-control" name="j_username">
            </div>
             <div class="field-group">
                <label accesskey="p" for="login-form-password" id="passwordlabel"><spring:message code="log.in.password"/></label>
                <input style="width: 60%;" type="password" id = "login-form-password" class="form-control" name="j_password">
            </div>

            <div style = "margin-left:10px" class="field-group">
                <label  class="checkbox">
                <input type="checkbox" value="remember-me">
                    <spring:message code="log.in.message.remember.me"/>
            </label>
            </div>
            <spring:message code="log.in.message.not.member"/> <a href="/signup"> <spring:message code="log.in.sign.up"/></a>
            <div class = "button">
                <button class="btn btn-sm btn-primary btn-primary" type="submit" style="margin-top: 10px"><spring:message code="log.in.log.in"/></button>
                <a href="/signup"> <spring:message code="log.in.message.forgot.password"/></a>
            </div>

        </form>

    </div>


    <div class="footer">
        <p>© BugHunter 2016</p>
    </div>



</div>
</body>
</html>




