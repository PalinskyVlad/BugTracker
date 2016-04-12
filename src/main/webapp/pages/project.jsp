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


    </div>


</div>


</body>
</html>
