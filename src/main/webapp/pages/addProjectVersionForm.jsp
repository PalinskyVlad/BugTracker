<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
</head>
<body>

<div class="modal fade" id="addProjectVersion" role="dialog">
    <form class="form-horizontal" action="/${project.name}/addProjectVersion" method="post">
        <div class="modal-dialog">

            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title"><spring:message code="project.add.project.version"/></h4>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <label class="col-lg-3 control-label"><spring:message code ="project.add.project.version.name"/></label>
                        <div class="col-lg-8">
                            <input type="text" class="form-control" id="name" name ="name">
                        </div>
                    </div>

                    <div class="form-group" style="height: 100px">
                        <label class="col-lg-3 control-label"><spring:message code ="project.add.project.version.description"/></label>
                        <div class="col-lg-8">
                            <textarea name="description" class="form-control" style="height: 100px"></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label"><spring:message code ="project.add.project.version.release"/></label>
                        <div class="col-lg-8">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value=""><spring:message code="project.add.project.version.release.message"/>
                                </label>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type = "submit"><spring:message code ="project.save.version"/></button>
                    <button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code ="project.close"/></button>
                </div>
            </div>

        </div>
    </form>
</div>

</body>
</html>
