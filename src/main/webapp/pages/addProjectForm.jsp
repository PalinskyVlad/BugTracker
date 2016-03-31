<%--
  Created by IntelliJ IDEA.
  User: Vlados
  Date: 3/31/2016
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Project</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#myModal").modal('show');
        });
    </script>
</head>
<body>

<form action = "/addProject" method = "post" commandName = "project">
    <div class="modal fate" id="addProject" tabindex="-1" role="dialog" aria-labelledby="addProjectLabel" aria-hidden="true">
        <div class="modal-header">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h3 class="modal-title" id="addProjectLabel">Add Project</h3>
                    </div>
                    <div class="modal-body" style="margin-left: 10%">

                        <div class = "field-group">
                            <label style = "margin-right: 2%">Project name</label>
                            <select class="selectpicker" data-live-search="true" name = "name">
                                <option>FirstProject</option>
                                <option>Second Project</option>
                                <option>Third Project</option>
                            </select>
                        </div>

                        <div class = "field-group">
                            <p>One fine body…</p>
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

                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary" type = "sumbit">Save changes</button>
                        <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

</body>
</html>
