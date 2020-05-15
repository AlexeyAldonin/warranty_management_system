<%@ page import="ru.javaprojectkazan.enums.UserCredential" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warranty Management System</title>
</head>
<body>
    <div style="height: 60px">
        <nav><a href="${pageContext.request.contextPath}/views/appHome.jsp">Home</a> | <a href="#">Log Out</a></nav>
        <h2 style="text-align: right">Warranty Management System. Logged in as ${sessionScope.login}</h2>
    </div>
</body>
</html>
