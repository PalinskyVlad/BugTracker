<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in BugHunter</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<jsp:include page='navigation.jsp' />
    <div class = "container">
    <div class="jumbotron" style="width: 50%;margin-top: 20px; margin: 0 auto">

        <h2 class="form-signin-heading">Welcome to BugHunter</h2>
        <c:url value="/j_spring_security_check" var="loginUrl" />
        <form action="${loginUrl}" method="post">

            <div class="field-group">
                 <label accesskey="u" for="login-form-username"><u>U</u>sername</label></td>
                 <td><input  style="width: 60%;" type="text" id = "login-form-username"class="form-control" name="j_username">
            </div>
             <div class="field-group">
                <label accesskey="p" for="login-form-password" id="passwordlabel"><u>P</u>assword</label>
                <input style="width: 60%;" type="password" id = "login-form-password" class="form-control" name="j_password">
            </div>

            <div style = "margin-left:10px" class="field-group">
                <label  class="checkbox">
                <input type="checkbox" value="remember-me">
                    Remember my login on this computer
            </label>
            </div>
            Not a member? <a href="/signup">Sign up</a> for an account
            <div class = "button">
                <button class="btn btn-sm btn-primary btn-primary" type="submit" style="margin-top: 10px">Log In</button>
                <a href="/signup"> Can't access your account?</a>
            </div>

        </form>

    </div>


    <div class="footer">
        <p>© BugHunter 2016</p>
    </div>



</div>
</body>
</html>




