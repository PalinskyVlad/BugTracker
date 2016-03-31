<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlados
  Date: 3/24/2016
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Navigation</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/i18n/defaults-*.min.js"></script>

</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"><img src="pages/images/Bug_Fixing-512.png" alt = "Brand" width="60" height="60"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"> Projects <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header"><li class="dropdown-header">CURRENT PROJECT</li></li>
                        <li><a href="#">____</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header"><li class="dropdown-header">RECENT PROJECTS</li></li>
                        <li><a href="#">____</a></li>
                        <li><a href="#">____</a></li>
                        <li class="divider"></li>
                        <li><a href="#">View all projects</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"> Issues <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Search for issues</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header"><li class="dropdown-header">Filters</li></li>
                        <li><a href="#">___</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Filters</li>
                        <li><a href="#">Reported by Me</a></li>

                    </ul>
                </li>

                <form class ="navbar-form navbar-left" >
                    <div class = "form-group">
                <sec:authorize access="isAuthenticated()">
                    <ul class = "nav nav-tabs">
                    <il><a class="btn btn-sm btn-primary" href="#addProject" role="button" data-toggle="modal">Add Project</a></il>
                    <il><a class="btn btn-sm btn-primary" href="#createIssue" role="button" data-toggle="modal">Create Issue</a></il>
                    </ul>
                </sec:authorize>
                </div>
                </form>
            </ul>

            <div class = "nav navbar-btn navbar-right" >
                    <sec:authorize access="isAuthenticated()">
                        <a href="#">username</a>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <a class="btn btn-sm btn-success" href="<c:url value="/login" />" role="button">Log In</a>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <a class="btn btn-sm btn-danger" href="<c:url value="/logout" />" role="button">Log Out</a>
                    </sec:authorize>
            </div>
            <form class="navbar-form navbar-right" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>

            </form>
        </div><!-- /.navbar-collapse -->


    </div><!-- /.container-fluid -->
</nav>


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

<form action = "/createIssue" method = "post" commandName = "issue">
<div class="modal fate" id="createIssue" tabindex="-1" role="dialog" aria-labelledby="createIssueLabel" aria-hidden="true">
    <div class="modal-header">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title" id="createIssueLabel">Create Issue</h3>
                </div>
                <div class="modal-body" style="margin-left: 10%">

                    <div class = "field-group">
                        <label style = "margin-right: 2%">Project</label>
                        <select class="selectpicker" data-live-search="true" name = "name">
                            <option>FirstProject</option>
                            <option>Second Project</option>
                            <option>Third Project</option>
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




































