<%--
  Created by IntelliJ IDEA.
  User: Vlados
  Date: 3/31/2016
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Issue</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#myModal").modal('show');
        });
    </script>
    <script src="js/msdropdown/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="js/msdropdown/jquery.dd.min.js" type="text/javascript"></script>
</head>
<body>

<form action = "/createIssue" method = "post" commandName = "issue">
    <div class="modal fate" id="createIssue" tabindex="-1" role="dialog" aria-labelledby="createIssueLabel" aria-hidden="true">
        <div class="modal-header">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h3 class="modal-title" id="createIssueLabel">Create Issue</h3>
                    </div>
                    <div class="modal-body">
                        <img src="pages/images/Issue/IssueType/bug.png">
                        <div class = "field-group">
                            <label style = "margin-right: 2%">Project</label>
                            <select class="selectpicker" data-live-search="true" name = "name" style="margin-right: 40%;margin-top: 2%">
                                <option>FirstProject</option>
                                <option>Second Project</option>
                                <option>Third Project</option>
                            </select>
                        </div>

                        <div class = "field-group" style="margin-right: 40%; margin-top: 2%">
                            <label style = "margin-right: 2%">Issue Type</label>
                            <select style="font-family: 'FontAwesome', Helvetica;" class="selectpicker" data-live-search="true" name = "name">
                                <option>   BUG</option>
                                <option data-image= "pages/images/Issue/IssueType/newfeature.png">   NEW_FEATURE</option>
                                <option><img src="pages/images/Issue/IssueType/task.png">TASK</option>
                                <option><img src="pages/images/Issue/IssueType/improvement.png">IMPROVEMENT</option>
                                <option><img src="pages/images/Issue/IssueType/refactoring.png">REFACTORING</option>
                                <option><img src="pages/images/Issue/IssueType/bug.png">DEFECT</option>
                                <option><img src="pages/images/Issue/IssueType/story.png">STORY</option>
                                <option><img src="pages/images/Issue/IssueType/epic.png">EPIC</option>
                                <option><img src="pages/images/Issue/IssueType/sales.png">SUPPORT</option>
                                <option><img src="pages/images/Issue/IssueType/pruning.png">PRUNING</option>
                            </select>
                        </div>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>
                        <p>One fine body…</p>

                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary" type = "submit">Save changes</button>
                        <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

</body>
</html>
