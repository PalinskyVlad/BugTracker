<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${project.name}</title>
    <script>
        $(function() {
            alert( $('textarea').val() );
        });
    </script>
</head>
<body>
<jsp:include page='navigation.jsp' />
<jsp:include page='deleteProjectForm.jsp'/>
<div class="row" style="margin-right: 0; margin-top: 0; padding-top: -20px; height: 100%">

    <jsp:include page='projectMenu.jsp'/>

    <div class="col-lg-9" style="margin-left: 1%; margin-top: 1%">

        <span><a href="#">Team name </a>/<a href="/project/${project.name}"> ${project.name}</a></span>


        <button type="button" class="btn btn-default pull-right" data-toggle="modal" data-target="#deleteProject" style="background-color: #eeeeee"><spring:message code="project.delete.project"/></button>

        <h2><spring:message code="project.project.settings"/></h2>
        <form class="form-horizontal" style="width: 70%" enctype="multipart/form-data" action = "/editProject/${project.name}" method = "post" commandName = "project">
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
                    <textarea name="description" class="form-control" style="height: 100px">${project.description}</textarea>
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
                        <div class="fileinput-new thumbnail" style="width: 150px;">
                            <img data-src="holder.js/100%x100%" src="/projectImageDisplay?name=${project.name}" class="img-rounded" style="width: 100%; display: block;">
                        </div>
                        <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px;"></div>
                        <div>
                            <span class="btn btn-default btn-file"><span class="fileinput-new"><spring:message code="add.project.project.avatar.change.avatar"/></span><span class="fileinput-exists"><spring:message code="add.project.project.avatar.change"/></span><input type="file" name="image"></span>
                            <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput"><spring:message code="add.project.project.avatar.remove"/></a>
                        </div>
                    </div>
                </div>
            </div>


            <button class="btn btn-primary" type = "sumbit"><spring:message code="add.project.save.changes"/></button>
            <button class="btn btn btn-default" data-dismiss="modal" aria-hidden="true"><spring:message code="add.project.close"/></button>



        </form>

    </div>



</div>


</body>
</html>
