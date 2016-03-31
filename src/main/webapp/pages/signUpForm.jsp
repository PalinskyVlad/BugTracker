<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--
  Created by IntelliJ IDEA.
  User: Vlados
  Date: 3/25/2016
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .error {
            color: #ff0000;
        }

    </style>

    <title>Sign up for BugHunter</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">
    <script src="https://www.google.com/recaptcha/api.js?hl=en">
        $('#myModal').on('shown.bs.modal', function () {
            $('#myInput').focus()
        })
        document.addEventListener("DOMContentLoaded", function() {

            // JavaScript form validation

            var checkPassword = function(str)
            {
                var re = /^\w{6,}$/;
                return re.test(str);
            };

            var checkForm = function(e)
            {
                if(this.username.value == "") {
                    alert("Error: Username cannot be blank!");
                    this.username.focus();
                    e.preventDefault(); // equivalent to return false
                    return;
                }
                re = /^\w+$/;
                if(!re.test(this.username.value)) {
                    alert("Error: Username must contain only letters, numbers and underscores!");
                    this.username.focus();
                    e.preventDefault();
                    return;
                }
                if(this.password.value != "" && this.password.value == this.confirmPassword.value) {
                    if(!checkPassword(this.password.value)) {
                        alert("The password you have entered is not valid!");
                        this.password.focus();
                        e.preventDefault();
                        return;
                    }
                } else {
                    alert("Error: Please check that you've entered and confirmed your password!");
                    this.password.focus();
                    e.preventDefault();
                    return;
                }
                alert("Both username and password are VALID!");
            };

            var myForm = document.getElementById("signUpForm");
            myForm.addEventListener("submit", checkForm, true);

            // HTML5 form validation

            var supports_input_validity = function()
            {
                var i = document.createElement("input");
                return "setCustomValidity" in i;
            }

            if(supports_input_validity()) {
                var usernameInput = document.getElementById("signup-username");
                usernameInput.setCustomValidity(usernameInput.title);

                var pwd1Input = document.getElementById("signup-password");
                pwd1Input.setCustomValidity(pwd1Input.title);

                var pwd2Input = document.getElementById("signup-confirm-password");

                // input key handlers

                usernameInput.addEventListener("keyup", function() {
                    usernameInput.setCustomValidity(this.validity.patternMismatch ? usernameInput.title : "");
                }, false);

                pwd1Input.addEventListener("keyup", function() {
                    this.setCustomValidity(this.validity.patternMismatch ? pwd1Input.title : "");
                    if(this.checkValidity()) {
                        pwd2Input.pattern = this.value;
                        pwd2Input.setCustomValidity(pwd2Input.title);
                    } else {
                        pwd2Input.pattern = this.pattern;
                        pwd2Input.setCustomValidity("");
                    }
                }, false);

                pwd2Input.addEventListener("keyup", function() {
                    this.setCustomValidity(this.validity.patternMismatch ? pwd2Input.title : "");
                }, false);

            }

        }, false);

    </script>
</head>
<body>
    <jsp:include page='navigation.jsp' />
    <div class = "container">
        <div class="jumbotron" style="width: 50%;margin-top: 20px; margin: 0 auto">

    <h2>Sign up</h2>
    <form:form id = "signUpForm" action="/signup" commandName="user" method="post" onsubmit="return checkForm(this);">


        <div class="field-group">
            <label accesskey="f" for="signup-firstName">First Name</label>
            <input  class = "form-control" style="width: 60%;" type="text" id = "signup-firstName" name="firstName" maxlength="255" title = "First name must not be blank" required pattern = "\w+">
        </div>
        <div class="field-group">
            <label accesskey="f" for="signup-lastName">Last Name</label>
            <input  class = "form-control" style="width: 60%;" type="text" id = "signup-lastName" name="lastName" maxlength="255" title = "Last name must not be blank" required pattern = "\w+">
        </div>
        <div class="field-group">
            <label accesskey="e" for="signup-email">E-mail</label>
            <div style = "color: #ff0000">${emailError}</div>
            <input class="form-control" style="width: 60%;" type="text" id = "signup-email" name="email" maxlength="255" title = "Error e-mail format" required pattern = "[\w-]+@\w+\.\w+">
        </div>
        <div class="field-group">
            <label accesskey="u" for="signup-username">Username</label>
            <div style="color: #ff0000">${usernameError}</div>

            <input class="form-control" style="width: 60%;" type="text" id = "signup-username" name="username" maxlength="255" title="Username must not be blank and contain only letters, numbers and underscores." required pattern="\w+">
        </div>


        <div class="field-group">
            <label accesskey="p" for="signup-password">Password</label>
            <input class="form-control" style="width: 60%;" type="password" id = "signup-password" name="password" maxlength="255" title="Password must contain at least 6 characters" required pattern="\w{6,}" onchange="
  this.setCustomValidity(this.validity.patternMismatch ? this.title : '');   if(this.checkValidity()) form.confirmPassword.pattern = this.value;">
        </div>
        <div class="field-group">
            <label accesskey="p" for="signup-confirm-password">Confirm Password</label>
            <input class="form-control" style="width: 60%;" type="password" id = "signup-confirm-password" name="confirmPassword" maxlength="255" title="Please enter the same Password as above." required pattern="\w{6,}"  onchange="
  this.setCustomValidity(this.validity.patternMismatch ? this.title : '');">
        </div>

        <tr style="color: #ff0000">${captchaError}</tr>
        <div class="g-recaptcha" style = "margin-top: 10px" data-sitekey="6Ld-zBsTAAAAANcUPiaRORRxn9LeS9ep64PbpH9-"></div>
        <br/>

        <button class="btn btn-sm btn-primary btn-primary" style="margin-top: 10px" type="submit">Sign up</button>
    </form:form>
</div>

    <div class="footer">
    <p>© BugHunter 2016</p>
    </div>
    </div>
</body>
</html>
