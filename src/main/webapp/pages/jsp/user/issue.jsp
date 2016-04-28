<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="issue"/>: ${issue.name}</title>
</head>
<body>
<jsp:include page='../../jspf/navigation.jsp' />
<jsp:include page='../../jspf/deleteIssueForm.jsp'/>

<div class="row" style="margin-right: 0; margin-top: 0; padding-top: -20px; height: 100%">

    <jsp:include page='../../jspf/projectMenu.jsp'/>

    <div class="col-lg-9" style="margin-left: 1%; margin-top: 1%">
        <span><a href="#">Team name </a>/<a href="/${project.name}"> ${project.name}</a></span>

        <button type="button" class="btn btn-default pull-right" data-toggle="modal" data-target="#deleteIssue" style="background-color: #eeeeee"><spring:message code="project.issue.delete"/></button>

        <h2><spring:message code="issue"/>: ${issue.name}</h2>
        <hr>

        <h4><spring:message code="details"/></h4>

                <ul class="list-group">
                    <c:if test="${issue.issueType  == 'BUG'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="type"/> </strong><span> <img src="/pages/images/Issue/IssueType/bug.png"> <spring:message code ="create.issue.issue.type.bug"/></span></li></c:if>
                    <c:if test="${issue.issueType  == 'NEW_FEATURE'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="type"/> </strong><span><img src="/pages/images/Issue/IssueType/newfeature.png"> <spring:message code ="create.issue.issue.type.new.feature"/></span></li></c:if>
                    <c:if test="${issue.issueType  == 'TASK'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="type"/> </strong><span><img src="/pages/images/Issue/IssueType/task.png"> <spring:message code ="create.issue.issue.type.task"/></span></li></c:if>
                    <c:if test="${issue.issueType  == 'IMPROVEMENT'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="type"/> </strong><span><img src="/pages/images/Issue/IssueType/improvement.png"> <spring:message code ="create.issue.issue.type.improvement"/></span></li></c:if>
                    <c:if test="${issue.issueType  == 'REFACTORING'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="type"/> </strong><span><img src="/pages/images/Issue/IssueType/refactoring.png"> <spring:message code ="create.issue.issue.type.refactoring"/></span></li></c:if>
                    <c:if test="${issue.issueType  == 'DEFECT'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="type"/> </strong><span><img src="/pages/images/Issue/IssueType/bug.png"> <spring:message code ="create.issue.issue.type.defect"/></span></li></c:if>
                    <c:if test="${issue.issueType  == 'STORY'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="type"/> </strong><span><img src="/pages/images/Issue/IssueType/story.png"> <spring:message code ="create.issue.issue.type.story"/></span></li></c:if>
                    <c:if test="${issue.issueType  == 'EPIC'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="type"/> </strong><span><img src="/pages/images/Issue/IssueType/epic.png"> <spring:message code ="create.issue.issue.type.epic"/></span></li></c:if>
                    <c:if test="${issue.issueType  == 'SUPPORT'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="type"/> </strong><span><img src="/pages/images/Issue/IssueType/sales.png"> <spring:message code ="create.issue.issue.type.support"/></span></li></c:if>
                    <c:if test="${issue.issueType  == 'PRUNING'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="type"/> </strong><span><img src="/pages/images/Issue/IssueType/pruning.png"> <spring:message code ="create.issue.issue.type.pruning"/></span></li></c:if>
                    <c:if test="${issue.priority  == 'BLOCKER'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="priority"/> </strong><span><img src="/pages/images/Issue/IssuePriority/blocker.png"> <spring:message code ="create.issue.priority.blocker"/></span></li></c:if>
                    <c:if test="${issue.priority  == 'CRITICAL'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="priority"/> </strong><span><img src="/pages/images/Issue/IssuePriority/critical.png"> <spring:message code ="create.issue.priority.critical"/></span></li></c:if>
                    <c:if test="${issue.priority  == 'MAJOR'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="priority"/> </strong><span><img src="/pages/images/Issue/IssuePriority/major.png"> <spring:message code ="create.issue.priority.major"/></span></li></c:if>
                    <c:if test="${issue.priority  == 'MINOR'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="priority"/> </strong><span><img src="/pages/images/Issue/IssuePriority/minor.png"> <spring:message code ="create.issue.priority.minor"/><span/></li></c:if>
                    <c:if test="${issue.priority  == 'TRIVIAL'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="priority"/> </strong><span><img src="/pages/images/Issue/IssuePriority/trivial.png"> <spring:message code ="create.issue.priority.trivial"/></span></li></c:if>
                    <li class="list-group-item"><strong style="color: #707070"><spring:message code="versions"/></strong>
                        <c:forEach items="${projectComponents}" var="item">
                            <a href="/${project.name}/components/${item.id}"><c:out value="${item.name}"/> </a>
                        </c:forEach></li>
                    <li class="list-group-item"><strong style="color: #707070"><spring:message code="components"/></strong>
                        <c:forEach items="${projectVersions}" var="item">
                            <a href="/${project.name}/versions/${item.id}"><c:out value="${item.name}"/> </a>
                        </c:forEach></li>
                    </li>
                    <li class="list-group-item"><strong style="color: #707070"><spring:message code="environment"/></strong> ${issue.environment}</li>
                    <c:if test="${issue.status  == 'OPEN'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="status"/> </strong><span class="label label-info"><spring:message code ="status.open"/></span></li></c:if>
                    <c:if test="${issue.status  == 'IN_PROGRESS'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="status"/> </strong><span class="label"><spring:message code ="status.open"/></span></li></c:if>
                    <c:if test="${issue.status  == 'INVESTIGATING'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="status"/> </strong><span class="label"><spring:message code ="status.open"/></span></li></c:if>
                    <c:if test="${issue.status  == 'WAITING_FOR_REVIEW'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="status"/> </strong><span class="label label-warning"><spring:message code ="status.open"/></span></li></c:if>
                    <c:if test="${issue.status  == 'REOPENED'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="status"/> </strong><span class="label label-info"><spring:message code ="status.open"/></span></li></c:if>
                    <c:if test="${issue.status  == 'RESOLVED'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="status"/> </strong><span class="label label-success"><spring:message code ="status.open"/></span></li></c:if>
                    <c:if test="${issue.status  == 'CLOSED'}"><li class="list-group-item"><strong style="color: #707070"><spring:message code="status"/> </strong><span class="label label-important"><spring:message code ="status.open"/></span></li></c:if>
                    <li class="list-group-item"><strong style="color: #707070"><spring:message code="created.date"/>:</strong> ${issue.createdDate}</li>
                </ul>
        <h4><spring:message code="description"/></h4>
        <p>${issue.description}</p>
    </div>
</div>

</body>
</html>


