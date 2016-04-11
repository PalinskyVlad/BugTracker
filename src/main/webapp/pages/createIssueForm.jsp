<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>Create Issue</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/dropdowns-enhancement.css" />" rel="stylesheet">
    <script src="/pages/js/dropdowns-enhancement.js"></script>
    <script src="/pages/js/bootstrap.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>


</head>
<body>

<form class="form-horizontal" action = "/createIssue" method = "post" commandName = "issue">
    <div class="modal fate" id="createIssue" tabindex="-1" role="dialog" aria-labelledby="createIssueLabel" aria-hidden="true">
        <div class="modal-header">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h3 class="modal-title" id="createIssueLabel"><spring:message code="create.issue"/></h3>
                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <label class="col-lg-3 control-label"><spring:message code ="create.issue.issue.name"/></label>
                            <div class="col-lg-8">
                                <input type="text" class="form-control" id="name" name ="name">
                            </div>
                        </div>

                        <div class = "form-group">
                            <label class="col-lg-3 control-label"><spring:message code ="create.issue.project"/></label>
                            <div class="col-lg-6">
                            <select class="form-control" id="showProjects" name = "projectName" style="width: auto;margin-top: 2%">
                                <option>1Test1</option>
                                <option>2Test2</option>
                            </select>
                            </div>
                        </div>

                        <div class = "form-group">
                            <label class="col-lg-3 control-label"><spring:message code ="create.issue.issue.type"/></label>
                            <div class="col-lg-6">
                            <div class="btn-group">
                                <button data-toggle="dropdown" class="btn btn-default dropdown-toggle"> <spring:message code="create.issue.issue.type.please.select"/> <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><input type="radio" id="BUG" name="issueType" value="BUG"><label for="BUG"><img src="pages/images/Issue/IssueType/bug.png"> <spring:message code ="create.issue.issue.type.bug"/></label></li>
                                    <li><input type="radio" id="NEW_FEATURE" name="issueType" value="NEW_FEATURE"><label for="NEW_FEATURE"><img src="pages/images/Issue/IssueType/newfeature.png"> <spring:message code ="create.issue.issue.type.new.feature"/></label></li>
                                    <li><input type="radio" id="TASK" name="issueType" value="TASK"><label for="TASK"><img src="pages/images/Issue/IssueType/task.png"> <spring:message code ="create.issue.issue.type.task"/></label></li>
                                    <li><input type="radio" id="IMPROVEMENT" name="issueType" value="IMPROVEMENT"><label for="IMPROVEMENT"><img src="pages/images/Issue/IssueType/improvement.png"> <spring:message code ="create.issue.issue.type.improvement"/></label></li>
                                    <li><input type="radio" id="REFACTORING" name="issueType" value="REFACTORING"><label for="REFACTORING"><img src="pages/images/Issue/IssueType/refactoring.png"> <spring:message code ="create.issue.issue.type.refactoring"/></label></li>
                                    <li><input type="radio" id="DEFECT" name="issueType" value="DEFECT"><label for="DEFECT"><img src="pages/images/Issue/IssueType/bug.png"> <spring:message code ="create.issue.issue.type.defect"/></label></li>
                                    <li><input type="radio" id="STORY" name="issueType" value="STORY"><label for="STORY"><img src="pages/images/Issue/IssueType/story.png"> <spring:message code ="create.issue.issue.type.story"/></label></li>
                                    <li><input type="radio" id="EPIC" name="issueType" value="EPIC"><label for="EPIC"><img src="pages/images/Issue/IssueType/epic.png"> <spring:message code ="create.issue.issue.type.epic"/></label></li>
                                    <li><input type="radio" id="SUPPORT" name="issueType" value="SUPPORT"><label for="SUPPORT"><img src="pages/images/Issue/IssueType/sales.png"> <spring:message code ="create.issue.issue.type.support"/></label></li>
                                    <li><input type="radio" id="PRUNING" name="issueType" value="PRUNING"><label for="PRUNING"><img src="pages/images/Issue/IssueType/pruning.png"> <spring:message code ="create.issue.issue.type.pruning"/></label></li>
                                </ul>
                            </div>
                            </div>
                        </div>

                        <hr style="width: 95%">

                        <div class="form-group">
                            <label class="col-lg-3 control-label"><spring:message code ="create.issue.summary"/></label>
                            <div class="col-lg-8">
                            <input type="text" class="form-control" id="summary" name ="summary">
                            </div>
                        </div>

                        <div class = "form-group">
                            <label class="col-lg-3 control-label"><spring:message code ="create.issue.priority"/></label>
                            <div class="col-lg-6">
                                <button data-toggle="dropdown" class="btn btn-default dropdown-toggle"><spring:message code ="create.issue.priority.please.select"/> <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><input type="radio" id="BLOCKER" name="priority" value="BLOCKER"><label for="BLOCKER"><img src="pages/images/Issue/IssuePriority/blocker.png"> <spring:message code ="create.issue.priority.blocker"/></label></li>
                                    <li><input type="radio" id="CRITICAL" name="priority" value="CRITICAL"><label for="CRITICAL"><img src="pages/images/Issue/IssuePriority/critical.png"> <spring:message code ="create.issue.priority.critical"/></label></li>
                                    <li><input type="radio" id="MAJOR" name="priority" value="MAJOR"><label for="MAJOR"><img src="pages/images/Issue/IssuePriority/major.png"> <spring:message code ="create.issue.priority.major"/></label></li>
                                    <li><input type="radio" id="MINOR" name="priority" value="MINOR"><label for="MINOR"><img src="pages/images/Issue/IssuePriority/minor.png"> <spring:message code ="create.issue.priority.minor"/></label></li>
                                    <li><input type="radio" id="TRIVIAL" name="priority" value="TRIVIAL"><label for="TRIVIAL"><img src="pages/images/Issue/IssuePriority/trivial.png"> <spring:message code ="create.issue.priority.trivial"/></label></li>
                                </ul>
                            </div>
                        </div>


                        <div class = "form-group">
                            <label class="col-lg-3 control-label"><spring:message code ="create.issue.component.s"/></label>
                            <div class="col-lg-6">
                                <button data-toggle="dropdown" class="btn btn-default dropdown-toggle"  data-placeholder="Please select"><spring:message code ="create.issue.component.s.please.select"/> <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><input type="checkbox" id="ID" name="NAME" value="Core"><label for="ID">Core</label></li>
                                    <li><input type="checkbox" id="ID2" name="NAME" value="Documentation"><label for="ID2">Documentation</label></li>
                                    <li><input type="checkbox" id="ID3" name="NAME" value="Infrastructure"><label for="ID3">Infrastructure</label></li>
                                </ul>
                            </div>
                        </div>

                        <div class = "form-group">
                            <label class="col-lg-3 control-label"><spring:message code ="create.issue.affects.version.s"/></label>
                            <div class="col-lg-6">
                                <button data-toggle="dropdown" class="btn btn-default dropdown-toggle"  data-placeholder="Please select"><spring:message code ="create.issue.affects.please.select"/> <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><input type="checkbox" id="ID4" name="NAME" value="Core"><label for="ID">1.0.0</label></li>
                                    <li><input type="checkbox" id="ID5" name="NAME" value="Documentation"><label for="ID2">1.0.1</label></li>
                                    <li><input type="checkbox" id="ID6" name="NAME" value="Infrastructure"><label for="ID3">1.0.2</label></li>
                                </ul>
                            </div>
                        </div>

                        <div class="form-group" style="height: 100px">
                            <label class="col-lg-3 control-label"><spring:message code ="create.issue.environment"/></label>
                            <div class="col-lg-8">
                                <textarea name="environment" class="form-control" style="height: 100px"></textarea>
                            </div>
                        </div>

                        <div class="form-group" style="height: 100px">
                            <label class="col-lg-3 control-label"><spring:message code ="create.issue.description"/></label>
                            <div class="col-lg-8">
                                <textarea name="environment" class="form-control" style="height: 100px"></textarea>
                            </div>
                        </div>


                    <div class="modal-footer">
                        <button class="btn btn-primary" type = "submit"><spring:message code ="create.issue.save.changes"/></button>
                        <button class="btn" data-dismiss="modal" aria-hidden="true"><spring:message code ="create.issue.close"/></button>
                    </div>


                </div>
            </div>
        </div>
    </div>
    </div>
</form>

</body>
</html>
