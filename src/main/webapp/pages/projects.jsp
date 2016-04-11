<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/pages/css/bootstrap-select.css">
    <link href="<c:url value="/pages/css/bootstrap.min.css"/>" rel="stylesheet">

    <script type="text/javascript" src="/pages/js/bootstrap-select.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="/pages/js/bootstrap.min.js"></script>

    <script>
        $(document).ready(function () {
            $('.selectpicker').selectpicker();
        });
    </script>

    <script>
        $(document).ready(function(){
            $('#createIssue').click(function(){
                var showProjects = $('#showProjects');
                showProjects.empty();
                $.get("/projects", function(data){
                    for(var i in data) {
                        showProjects.append("<option>" + data[i] + "</option>");
                    }
                });
            });
        });
    </script>
</head>
<body>
<a class="btn btn-sm btn-primary" id="createIssue" role = "button">Get Projects</a>
<select class="selectpicker" id="showProjects">

</select>


<select>
    <option>ebania v rot</option>
</select>

</div>
</body>
</html>
