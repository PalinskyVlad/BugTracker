<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sping" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Navigation</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script type="text/javascript">
        function getProjects() {
            var showProjects = $('#showProjects');
            showProjects.empty();
            $.get("/projects", function (data) {
                for (var i in data) {
                    showProjects.append("<option value='" + data[i] + "'>" + data[i] + "</option>");
                }
            });
        }



    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/i18n/defaults-*.min.js"></script>
    <link href="<c:url value="/pages/css/dropdowns-enhancement.css" />" rel="stylesheet">
    <script src="/pages/js/dropdowns-enhancement.js.js"></script>

</head>
<body>
<jsp:include page='createIssueForm.jsp' />
<jsp:include page='addProjectForm.jsp' />
<nav class="navbar bg-primary" role="navigation" style="margin-bottom: 0">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"><span><img src="/pages/images/repairer.png" alt = "Brand" width="30" height="30"></span> <b alt="Brand" style="color: white;"><spring:message code="brand"/></b></a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle label-primary bg-primary" data-toggle="dropdown" style="color: white;"> <spring:message code="navigation.projects"/> <b class="caret" style="color: white;"></b></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header"><li class="dropdown-header"><spring:message code="navigation.projects.current.projects" text="default text" /></li></li>
                        <li><a href="#">____</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header"><li class="dropdown-header"><spring:message code="navigation.projects.recent.projects"/></li></li>
                        <li><a href="#">____</a></li>
                        <li><a href="#">____</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><spring:message code="navigation.projects.view.all.projects"/></a></li>
                        <sec:authorize access="isAuthenticated()">
                            <li class="divider"></li>
                            <li><a href="#addProject" role="button" data-toggle="modal"><spring:message code="navigation.create.project"/></a></li>
                        </sec:authorize>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle label-primary" data-toggle="dropdown" style="color: white;"><spring:message code="navigation.issues"/> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header"><li class="dropdown-header"><spring:message code="navigation.issues.recent.issues"/></li></li>
                        <li><a href="#">___</a></li>
                        <li><a href="#">___</a></li>
                        <li><a href="#">___</a></li>
                        <li><a href="#">___</a></li>
                        <li><a href="#">___</a></li>
                        <li><a href="#"><spring:message code="navigation.issues.more"/></a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header"><spring:message code="navigation.issues.filters"/></li>
                        <li><a href="#"><spring:message code="navigation.issues.my.open.issues"/></a></li>
                        <li><a href="#"><spring:message code="navigation.issues.reported.by.me"/></a></li>
                        <sec:authorize access="isAuthenticated()">
                            <li class="divider"></li>
                            <li><a href="#createIssue" onclick="getProjects()" role="button" data-toggle="modal"><spring:message code="navigation.create.issue"/></a></li>
                        </sec:authorize>
                    </ul>
                </li>

            </ul>





            <div class = "nav navbar-btn navbar-right" >

                <div class="dropdown navbar-left" style="margin-right: 10px">
                    <button class="btn btn-sm btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><spring:message code="language"/>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value='?lang=de'/>">Deutsch</a></li>
                        <li><a href="<c:url value='?lang=en'/>">English</a></li>
                        <li><a href="<c:url value='?lang=ru'/>">Русский</a></li>
                    </ul>
                </div>

                    <sec:authorize access="!isAuthenticated()">
                        <a class="btn btn-sm btn-success" href="<c:url value="/login" />" role="button"><spring:message code="navigation.log.in"/></a>
                    </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                        <div class="dropdown navbar-left" style="margin-right: 10px">
                            <button type="button" class="btn btn-default" aria-label="Left Align" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="<c:url value="/profile" />"><spring:message code="navigation.user.profile"/></a></li>
                                <li class="divider"></li>
                                <li><a href="<c:url value="/logout" />"><spring:message code="navigation.user.log.out"/></a></li>
                            </ul>
                        </div>
                    </sec:authorize>
            </div>
            <form class="navbar-form navbar-right" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="<spring:message code="navigation.search"/>">
                </div>

            </form>
        </div><!-- /.navbar-collapse -->


    </div><!-- /.container-fluid -->
</nav>

</body>
</html>




































