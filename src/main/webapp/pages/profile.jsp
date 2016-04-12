<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>BugHunter</title>
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
</head>

<body>

<jsp:include page='navigation.jsp' />
    <div style="height: 15%; margin-left: 2%">
        <h2 style="color:#2e6da4"> <span class="glyphicon glyphicon-user" aria-hidden="true"></span> <spring:message code="profile"/>: <security:authentication property="principal.username" /></h2>
    </div>
    <hr>
    <div style="margin-left: 2%">
        <h3>Summary</h3>
    </div>

    <div class="row" style="margin-right: 0">
        <div class="col-lg-6">

            <form class="form-horizontal">
            <div class="form-group">
                <div class ="col-lg-3"><h4><spring:message code ="profile.summary.details"/></h4></div>
                <div class="col-lg-8">
                    <div class="dropdown navbar-right" style="margin-right: 10px">
                        <button type="button" class="btn btn-default btn-sm" aria-label="Left Align" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="<c:url value="/profile" />"><spring:message code="profile.summary.edit"/></a></li>
                        </ul>
                    </div>
                </div>
            </div>




                <div class="form-group">
                    <label class="col-lg-3 control-label"><spring:message code ="profile.username"/></label>
                    <div class="col-lg-8">
                        <h5>${user.username}</h5>
                    </div>
                </div>

            <div class="form-group">
                <label class="col-lg-3 control-label"><spring:message code ="profile.full.name"/></label>
                <div class="col-lg-8">
                    <h5>${user.lastName} ${user.firstName}</h5>
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-3 control-label"><spring:message code ="profile.email"/></label>
                <div class="col-lg-8">
                    <h5>${user.email}</h5>
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-3 control-label"><spring:message code ="profile.password"/></label>
                <div class="col-lg-8">
                    <h5>Change Password</h5>
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-3 control-label"><spring:message code ="profile.groups"/></label>
                <div class="col-lg-8">
                    <h5>BugHunter-users</h5>
                </div>
            </div>

            </form>

            <hr>

            <form class="form-horizontal">
                <div class="form-group">
                    <div class ="col-lg-3"><h4><spring:message code ="profile.summary.details"/></h4></div>
                    <div class="col-lg-8">
                        <div class="dropdown navbar-right" style="margin-right: 10px">
                            <button type="button" class="btn btn-default btn-sm" aria-label="Left Align" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="<c:url value="/profile" />"><spring:message code="profile.summary.edit"/></a></li>
                            </ul>
                        </div>
                    </div>
                </div>




                <div class="form-group">
                    <label class="col-lg-3 control-label"><spring:message code ="profile.username"/></label>
                    <div class="col-lg-8">
                        <h5>PalinskyVlad</h5>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label"><spring:message code ="profile.full.name"/></label>
                    <div class="col-lg-8">
                        <h5>Palinsky Vlad</h5>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label"><spring:message code ="profile.email"/></label>
                    <div class="col-lg-8">
                        <h5>palinskyvlad at gmail dot com</h5>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label"><spring:message code ="profile.password"/></label>
                    <div class="col-lg-8">
                        <h5>Change Password</h5>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label"><spring:message code ="profile.groups"/></label>
                    <div class="col-lg-8">
                        <h5>BugHunter-users</h5>
                    </div>
                </div>

            </form>
        </div>
        <div class="col-lg-6">
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
            <p><h4>Activity Stream</h4></p>
        </div>
    </div>






    <div class="footer">
        <p>© BugHunter 2016</p>
</div>
</body>
</html>
