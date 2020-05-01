<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>System Login</title>
</head>
<body>
    <form id="loginForm" action="${pageContext.request.contextPath}/login" method="POST">
        <p><b>User Login:</b></p>
        <label>
            <input type="text" required="required" name="login">
        </label>
        <p><b>Password:</b></p>
        <label>
            <input type="password" required="required" name="psswd">
        </label><br><br>
        <input type="submit" value="Sign in">
    </form>


</body>
</html>
