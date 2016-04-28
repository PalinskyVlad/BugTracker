<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Vlados
  Date: 4/28/2016
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code = "administration"/></title>
</head>
<body>

    <jsp:include page='../../jspf/navigation.jsp' />

    <div style="margin-left: 2%; margin-right: 2%">

    <h2><spring:message code="users"/></h2>

    <table class="table table-striped">
    <thead>
    <tr>
        <th><spring:message code="username"/></th>
        <th><spring:message code="email"/></th>
        <th><spring:message code="firstName"/></th>
        <th><spring:message code="lastName"/></th>
        <th><spring:message code="role"/></th>
        <th><spring:message code="confirmed"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="item">
        <tr>
            <td><a href="/admin/users/${item.id}"><c:out value="${item.username}"/></a></td>
            <td><c:out value="${item.email}"/></td>
            <td><c:out value="${item.firstName}"/></td>
            <td><c:out value="${item.lastName}"/></td>
            <td><c:out value="${item.role}"/></td>
            <td><c:out value="${item.confirmed}"/></td>
            <td>
                <form action="/admin/users/${item.id}?delete" method="post">
            <button type="submit" class="btn btn-default btn-sm">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
            </button>
                    </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</div>


</body>
</html>
