<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <title>Add Project</title>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/jasny-bootstrap/3.1.3/css/jasny-bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link href="<c:url value="/pages/css/dropdowns-enhancement.css" />" rel="stylesheet">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jasny-bootstrap/3.1.3/js/jasny-bootstrap.min.js"></script>
    <script src="/pages/js/dropdowns-enhancement.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    <script type="text/javascript">
        $('.fileinput').fileinput()
    </script>
</head>
<body>

    <div class="modal fate" id="addProject" role="dialog">
        <form class="form-horizontal" enctype="multipart/form-data" action = "/addProject" method = "post" commandName = "project">

        <div class="modal-header">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h3 class="modal-title" id="addProjectLabel"><spring:message code="add.project"/></h3>
                    </div>

                    <div class="modal-body">

                    <div class = "form-group">
                        <label class="col-lg-3 control-label"><spring:message code ="add.project.team"/></label>
                        <div class="col-lg-6">
                        <button data-toggle="dropdown" class="btn btn-default dropdown-toggle"><spring:message code ="add.project.team.please.select"/> <span class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <li><input type="radio" id="BLOCKER" name="priority" value="BLOCKER"><label for="BLOCKER">Team1</label></li>
                                <li><input type="radio" id="MINOR" name="priority" value="MINOR"><label for="MINOR">Team2</label></li>
                            </ul>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label"><spring:message code ="add.project.name"/></label>
                            <div class="col-lg-8">
                                <input type="text" class="form-control" id="name" name ="name" title="<spring:message code="error.project.name"/>" value="${project.name}" required pattern="\w+">
                            </div>
                    </div>

                    <div class="form-group" style="height: 100px">
                         <label class="col-lg-3 control-label"><spring:message code ="add.project.description"/></label>
                            <div class="col-lg-8">
                                <textarea name="description" class="form-control" style="height: 100px"></textarea>
                            </div>
                    </div>

                    <div class="form-group">
                         <label class="col-lg-3 control-label"><spring:message code ="add.project.privacy"/></label>
                         <div class="col-lg-8">
                             <div class="checkbox">
                                 <label>
                                 <input type="checkbox" value=""><spring:message code="add.project.private.project"/>
                                 </label>
                             </div>
                             <p class="help-block"><spring:message code ="add.project.private.project.description"/></p>
                         </div>
                    </div>

                        <div class="form-group">
                            <label class="col-lg-3 control-label"><spring:message code ="add.project.project.avatar"/></label>
                            <div class="col-lg-8">
                                <div class="fileinput fileinput-new" data-provides="fileinput">
                                    <div class="fileinput-new thumbnail" style="width: 150px; height: 150px;">
                                        <img data-src="holder.js/100%x100%" class="img-circle" alt="100%x100%" src="/pages/images/project-default.png" style="height: 100%; width: 100%; display: block;">
                                    </div>
                                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                                        <div>
                                            <span class="btn btn-default btn-file"><span class="fileinput-new"><spring:message code="add.project.project.avatar.change.avatar"/></span><span class="fileinput-exists"><spring:message code="add.project.project.avatar.change"/></span><input type="file" name="image"></span>
                                             <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput"><spring:message code="add.project.project.avatar.remove"/></a>
                                     </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary" type = "sumbit"><spring:message code="add.project.save.project"/></button>
                        <button class="btn btn-default" data-dismiss="modal" aria-hidden="true"><spring:message code="add.project.close"/></button>
                    </div>
                </div>
            </div>
        </div>
        </form>
    </div>

</body>
</html>
