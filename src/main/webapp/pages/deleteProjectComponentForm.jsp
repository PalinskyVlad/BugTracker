<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><spring:message code="project.component.delete"/></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
</head>
<body>

<div class="modal fade" id="deleteProjectComponent" role="dialog">
    <form action="/deleteProjectComponent/${projectComponent.id}" method="post">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header" style="background-color: #d04437; color: white">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title"><spring:message code="project.component.delete"/></h4>
                </div>
                <div class="modal-body">
                    <p><spring:message code="project.component.delete.message"/></p>
                </div>
                <div class="modal-footer" style="background-color: #eeeeee">
                    <button class="btn btn-primary" type = "submit"><spring:message code ="delete"/></button>
                    <button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code ="close"/></button>
                </div>
            </div>

        </div>
    </form>
</div>

</body>
</html>
