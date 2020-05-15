<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>System Home Page</title>
</head>
<body>
<jsp:include page="./headers/systemHeader.jsp"></jsp:include>
    <div>
        <table align="center">
            <tr>
                <th>Claim menu:</th>
                <th>Vehicle menu:</th>
            </tr>
            <tr>
                <td><a href="#">Find claim</a></td>
                <td><a href="findVehicle.jsp">Find vehicle</a></td>
            </tr>
            <tr>
                <td><a href="createClaim.jsp">Create claim</a></td>
                <td><a href="historyRequest.jsp">Vehicle claim history</a></td>
            </tr>
        </table>
    </div>
</body>
</html>
