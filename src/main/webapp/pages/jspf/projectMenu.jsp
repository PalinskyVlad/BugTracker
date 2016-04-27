<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <jsp:include page="addProjectVersionForm.jsp"/>
    <jsp:include page="createProjectComponentForm.jsp"/>

    <div class="col-lg-2" style="background-color: #eeeeee; padding-right: 0; height: 100%">


    <img src="/projectImageDisplay?name=${project.name}" class="img-rounded" width="80%" style="margin: 10%;">

    <b><h4 style="padding-left: 15px; color: #333333; margin-bottom: 10%">${project.name}</h4></b>

    <div class="list-group">
        <ul class="nav">
            <li>
                <strong style="color: #707070; margin-left: 15px"> <spring:message code="project.actions"/></strong>
            </li>
            <li>

            <a href="#createProjectComponent" class="menu-item" role="button" data-toggle="modal">
                    <span class="glyphicon glyphicon-plus" style="color: #707070; padding-right: 3%;"></span> <spring:message code="project.create.component"/>
                </a>
            </li>
            <li>
                <a href="#addProjectVersion" class="menu-item" role="button" data-toggle="modal">
                    <span class="glyphicon glyphicon-folder-open" style="color: #707070; padding-right: 3%;"></span>  <spring:message code="project.add.version"/>
                </a>
            </li>
            <hr style="width: 95%">
            <li>
                <strong style="color: #707070; margin-left: 15px"> <spring:message code="project.navigation"/></strong>
            </li>
            <li>
                <a href="/${project.name}/issues" class="menu-item">
                    <span class="glyphicon glyphicon-info-sign" style="color: #707070; padding-right: 3%;"></span>  <spring:message code="project.issues"/>
                </a>
            </li>
            <li>
                <a href="/${project.name}/versions" class="menu-item">
                    <span class="glyphicon glyphicon-sort" style="color: #707070; padding-right: 3%;"></span>  <spring:message code="project.versions"/>
                </a>
            </li>
            <li>
                <a href="/${project.name}/components" class="menu-item">
                    <span class="glyphicon glyphicon-book" style="color: #707070; padding-right: 3%;"></span> <spring:message code="project.components"/>
                </a>
            </li>
            <hr style="width: 95%">

            <li>
                <a href="/${project.name}/settings" class="menu-item">
                    <span class="glyphicon glyphicon-cog" style="color: #707070; padding-right: 3%;"></span>  <spring:message code="project.settings"/>
                </a>
            </li>
        </ul>
    </div>


</div>


</body>
</html>
