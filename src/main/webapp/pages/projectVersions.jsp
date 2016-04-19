<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlados
  Date: 4/18/2016
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project versions</title>
</head>
<body>
<jsp:include page='navigation.jsp' />
<div class="row" style="margin-right: 0; margin-top: 0; padding-top: -20px; height: 100%">

    <jsp:include page='projectMenu.jsp'/>

    <div class="col-lg-9" style="margin-left: 1%; margin-top: 1%">
        <span><a href="#">Team name </a>/<a href="/project/${project.name}"> ${project.name}</a></span>

        <h2><spring:message code="project.project.versions"/></h2>

        <table class="table table-striped">
            <thead>
            <tr>
                <th><spring:message code="version"/></th>
                <th><spring:message code="description"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${projectVersions}" var="item">
                <tr>
                    <td><a href="/projectVersion/${item.id}"><c:out value="${item.name}"/></a></td>
                    <td><c:out value="${item.description}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>





    </div>
</div>


</body>
</html>
