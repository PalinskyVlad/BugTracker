<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>Create Issue</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/dropdowns-enhancement.css" />" rel="stylesheet">
    <script src="/pages/js/dropdowns-enhancement.js"></script>
    <script src="/pages/js/bootstrap.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>

<form class="form-horizontal" action = "/createIssue" method = "post" commandName = "issue">
    <div class="modal fate" id="createIssue" tabindex="-1" role="dialog" aria-labelledby="createIssueLabel" aria-hidden="true">
        <div class="modal-header">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h3 class="modal-title" id="createIssueLabel">Create Issue</h3>
                    </div>
                    <div class="modal-body">

                        <div class = "form-group">
                            <label class="col-lg-3 control-label">Project</label>
                            <div class="col-lg-6">
                            <select class="selectpicker" data-live-search="true" name = "name" style="width: 40%;margin-top: 2%">
                                <option>FirstProject</option>
                                <option>Second Project</option>
                                <option>Third Project</option>
                            </select>
                            </div>
                        </div>

                        <div class = "form-group">
                            <label class="col-lg-3 control-label">Issue Type</label>
                            <div class="col-lg-6">
                            <div class="btn-group">
                                <button data-toggle="dropdown" class="btn btn-default dropdown-toggle"> Please Select <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><input type="radio" id="BUG" name="issueType" value="BUG"><label for="BUG"><img src="pages/images/Issue/IssueType/bug.png"> Bug </label></li>
                                    <li><input type="radio" id="NEW_FEATURE" name="issueType" value="NEW_FEATURE"><label for="NEW_FEATURE"><img src="pages/images/Issue/IssueType/newfeature.png"> New Feature </label></li>
                                    <li><input type="radio" id="TASK" name="issueType" value="TASK"><label for="TASK"><img src="pages/images/Issue/IssueType/task.png"> Task </label></li>
                                    <li><input type="radio" id="IMPROVEMENT" name="issueType" value="IMPROVEMENT"><label for="IMPROVEMENT"><img src="pages/images/Issue/IssueType/improvement.png"> Improvement </label></li>
                                    <li><input type="radio" id="REFACTORING" name="issueType" value="REFACTORING"><label for="REFACTORING"><img src="pages/images/Issue/IssueType/refactoring.png"> Refactoring </label></li>
                                    <li><input type="radio" id="DEFECT" name="issueType" value="DEFECT"><label for="DEFECT"><img src="pages/images/Issue/IssueType/bug.png"> Defect </label></li>
                                    <li><input type="radio" id="STORY" name="issueType" value="STORY"><label for="STORY"><img src="pages/images/Issue/IssueType/story.png"> Story </label></li>
                                    <li><input type="radio" id="EPIC" name="issueType" value="EPIC"><label for="EPIC"><img src="pages/images/Issue/IssueType/epic.png"> Epic </label></li>
                                    <li><input type="radio" id="SUPPORT" name="issueType" value="SUPPORT"><label for="SUPPORT"><img src="pages/images/Issue/IssueType/sales.png"> Support </label></li>
                                    <li><input type="radio" id="PRUNING" name="issueType" value="PRUNING"><label for="PRUNING"><img src="pages/images/Issue/IssueType/pruning.png"> Pruning </label></li>
                                </ul>
                            </div>
                            </div>
                        </div>

                        <hr style="width: 95%">

                        <div class="form-group">
                            <label class="col-lg-3 control-label">Summary </label>
                            <div class="col-lg-8">
                            <input type="text" class="form-control" id="summary" name ="summary">
                            </div>
                        </div>

                        <div class = "form-group">
                            <label class="col-lg-3 control-label">Priority</label>
                            <div class="col-lg-6">
                                <button data-toggle="dropdown" class="btn btn-default dropdown-toggle"> Please Select <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><input type="radio" id="BLOCKER" name="priority" value="BLOCKER"><label for="BLOCKER"><img src="pages/images/Issue/IssuePriority/blocker.png"> Blocker </label></li>
                                    <li><input type="radio" id="CRITICAL" name="priority" value="CRITICAL"><label for="CRITICAL"><img src="pages/images/Issue/IssuePriority/critical.png"> Critical </label></li>
                                    <li><input type="radio" id="MAJOR" name="priority" value="MAJOR"><label for="MAJOR"><img src="pages/images/Issue/IssuePriority/major.png"> Major </label></li>
                                    <li><input type="radio" id="MINOR" name="priority" value="MINOR"><label for="MINOR"><img src="pages/images/Issue/IssuePriority/minor.png"> Minor </label></li>
                                    <li><input type="radio" id="TRIVIAL" name="priority" value="TRIVIAL"><label for="TRIVIAL"><img src="pages/images/Issue/IssuePriority/trivial.png"> Trivial </label></li>
                                </ul>
                            </div>
                        </div>


                        <div class = "form-group">
                            <label class="col-lg-3 control-label">Component/s</label>
                            <div class="col-lg-6">
                                <button data-toggle="dropdown" class="btn btn-default dropdown-toggle"  data-placeholder="Please select">Please Select <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><input type="checkbox" id="ID" name="NAME" value="Core"><label for="ID">Core</label></li>
                                    <li><input type="checkbox" id="ID2" name="NAME" value="Documentation"><label for="ID2">Documentation</label></li>
                                    <li><input type="checkbox" id="ID3" name="NAME" value="Infrastructure"><label for="ID3">Infrastructure</label></li>
                                </ul>
                            </div>
                        </div>


                    <div class="modal-footer">
                        <button class="btn btn-primary" type = "submit">Save changes</button>
                        <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                    </div>


                </div>
            </div>
        </div>
    </div>
    </div>
</form>

</body>
</html>
