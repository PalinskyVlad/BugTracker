<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project issues</title>
</head>
<body>
<jsp:include page='../../jspf/navigation.jsp' />
<div class="row" style="margin-right: 0; margin-top: 0; padding-top: -20px; height: 100%">

    <jsp:include page='../../jspf/projectMenu.jsp'/>

    <div class="col-lg-9" style="margin-left: 1%; margin-top: 1%">
        <span><a href="#">Team name </a>/<a href="/${project.name}"> ${project.name}</a></span>

        <h2><spring:message code="project.project.issues"/></h2>


        <table class="table table-striped">
            <thead>
            <tr>
                <th><spring:message code="issue"/></th>
                <th><spring:message code="description"/></th>
                <th><spring:message code="created.date"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${issues}" var="item">
                <tr>
                    <td><a href="/${project.name}/issues/${item.id}"><c:out value="${item.name}"/></a></td>
                    <td><c:out value="${item.description}"/></td>
                    <td><c:out value="${item.createdDate}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>


</body>
</html>
