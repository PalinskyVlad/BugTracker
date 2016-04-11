<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project Name</title>
</head>
<body>

<jsp:include page='navigation.jsp' />

<div class="row" style="margin-top: 0; padding-top: -20px">
    <div class="col-lg-2" style="background-color: #eeeeee; height: 100%; padding-right: 0">
        <img src="/pages/images/project-default.png" class="img-circle" alt="60%x60%" width="60%" style="margin-right: 20%; margin-left: 20%; margin-top: 5%">
        <b><h4 style="padding-left: 15px">Project Name</h4></b>

        <div class="list-group">
            <ul class="nav">
            <li>
                <strong style="color: #707070; margin-left: 15px"> <spring:message code="project.actions"/></strong>
            </li>
            <li>
                    <a href="#" class="menu-item">
                        <span class="glyphicon glyphicon-plus" style="color: #707070"></span> <spring:message code="project.create.component"/><span class="badge" style="margin-left: 5%">0</span>
                    </a>
            </li>
            <li>
                    <a href="#" class="menu-item">
                        <span class="glyphicon glyphicon-folder-open" style="color: #707070"></span>  <spring:message code="project.add.version"/><span class="badge" style="margin-left: 5%">0</span>
                    </a>
            </li>
                    <hr style="width: 95%">
            <li>
                    <strong style="color: #707070; margin-left: 15px"> <spring:message code="project.navigation"/></strong>
            </li>
            <li>
                    <a href="#" class="menu-item">
                        <span class="glyphicon glyphicon-info-sign" style="color: #707070"></span>  <spring:message code="project.issues"/><span class="badge" style="margin-left: 5%">0</span>
                    </a>
            </li>
            <li>
                    <a href="#" class="menu-item">
                        <span class="glyphicon glyphicon-sort" style="color: #707070"></span>  <spring:message code="project.versions"/><span class="badge" style="margin-left: 5%">0</span>
                    </a>
            </li>
            <li>
                    <a href="#" class="menu-item">
                        <span class="glyphicon glyphicon-book" style="color: #707070"></span>  <spring:message code="project.components"/><span class="badge" style="margin-left: 5%">0</span>
                    </a>
            </li>
                    <hr style="width: 95%">

            <li>
                    <a href="#" class="menu-item">
                        <span class="glyphicon glyphicon-cog" style="color: #707070"></span>  <spring:message code="project.settings"/>
                    </a>
            </li>
            </ul>
        </div>


    </div>

    <div class="col-lg-10">

    </div>
</div>



</body>
</html>
