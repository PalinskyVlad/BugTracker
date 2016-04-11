<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>IT</title>
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script type="text/javascript">
        function getProjectsList() {
            var showProjectsList = $('#showProjectsList');
            showProjectsList.empty();
            $.get("/projects", function (data) {
                for (var i in data) {
                    showProjectsList.append("<li>" +  data[i] + "</li>");
                   // showProjectsList.append("<li><a href='/project/" + data[i] + "' class='menu-item'><span><img src='/pages/images/project-default.png'></span>" + data[i] + "</a></li>");
                }
            });
        }


    </script>
</head>

<body onload="getProjectsList()">

    <jsp:include page='navigation.jsp' />
        <h2 style="color: #2e6da4; margin-left: 1%"><spring:message code="dashboard.system.dashboard"/></h2>
        <div class="row">
            <div class="col-lg-6" style="margin-left: 2%">

                <div class = "panel panel-primary">
                    <div class = "panel-heading">
                        <h5 style="margin: 0;"> <spring:message code="dashboard.introduction"/></h5>
                    </div>
                    <div class = "panel-body">
                        <p><h4><b><spring:message code="dashboard.introduction.welcome"/></b></h4></p>
                        <p><spring:message code="dashboard.introduction.text"/></p>
                    </div>
                </div>


                <div class = "panel panel-primary">
                    <div class = "panel-heading">
                        <h5 style="margin: 0;"> <spring:message code="dashboard.projects"/></h5>
                    </div>
                    <div class = "panel-body">
                        <div class="list-group">
                            <ul class="nav" id="showProjectsList">

                            </ul>

                     </div>

                    </div>
                </div>

            </div>

            <div class="col-lg-5" style="margin-left: 2%">

                <sec:authorize access="!isAuthenticated()">
                <div class = "panel panel-primary">
                    <div class = "panel-heading">
                        <h5 style="margin: 0;"> <spring:message code="dashboard.login"/></h5>
                    </div>
                    <div class = "panel-body">
                        <c:url value="/j_spring_security_check" var="loginUrl" />
                        <form class="form-horizontal" action="${loginUrl}" method="post">

                            <div class="form-group">
                                <label class="col-lg-4 control-label" accesskey="u" for="login-form-username"><spring:message code="log.in.username"/></label>
                                <div class="col-lg-7">
                                    <input  style="width: 60%;" type="text" id = "login-form-username"class="form-control" name="j_username">
                                </div>
                            </div>

                            <div class="form-group" style="margin-bottom: 1%;">
                                <label class="col-lg-4 control-label" accesskey="p" for="login-form-password" id="passwordlabel"><spring:message code="log.in.password"/></label>
                                <div class="col-lg-7">
                                    <input style="width: 60%;" type="password" id = "login-form-password" class="form-control" name="j_password">
                                </div>
                            </div>

                            <div class="form-group" style="margin-top: 0; margin-bottom: 1%">
                                <label class="col-lg-4 control-label"></label>
                                <div class="checkbox col-lg-7">
                                    <label >
                                        <input type="checkbox" value="remember-me">
                                        <spring:message code="log.in.message.remember.me"/>
                                    </label>
                                </div>
                            </div>

                            <div class="form-group" style="margin-top: 0; margin-bottom: 1%">
                                <label class="col-lg-4 control-label"></label>
                                <div class="col-lg-7">
                                    <spring:message code="log.in.message.not.member"/> <a href="/signup"> <spring:message code="log.in.sign.up"/></a>
                                </div>
                            </div>

                            <div class="form-group" style="margin-top: 0; margin-bottom: 1%">
                                <label class="col-lg-4 control-label"></label>
                                <div class = "button col-lg-7">
                                    <button class="btn btn-sm btn-primary btn-primary" type="submit"><spring:message code="log.in.log.in"/></button>
                                    <a href="/signup"> <spring:message code="log.in.message.forgot.password"/></a>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
                </sec:authorize>


                <sec:authorize access="isAuthenticated()">
                <div class = "panel panel-primary">
                    <div class = "panel-heading">
                        <h5 style="margin: 0;"> <spring:message code="dashboard.issues.in.progress"/></h5>
                    </div>
                    <div class = "panel-body">
                    </div>
                </div>
                </sec:authorize>


                <div class = "panel panel-primary">
                    <div class = "panel-heading">
                        <h5 style="margin: 0;"> <spring:message code="dashboard.activity.stream"/></h5>
                    </div>
                    <div class = "panel-body">
                    </div>
                </div>


            </div>

        </div>


        <div class="footer">
            <p>© BugHunter 2016</p>
        </div>
</body>
</html>
