<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Vehicle</title>
</head>
<body>
<jsp:include page="./headers/systemHeader.jsp"></jsp:include>
    <p style="color: red; font: -moz-info">${message}</p>
    <h2>Введите VIN автомобиля для запроса</h2><br>
    <form action="${pageContext.request.contextPath}/findVehicle" method="get">
        <label for="VIN">VIN: </label>
        <input type="text" maxlength="6" name="VIN" id="VIN" required><br><br>
        <input type="submit" value="Запросить" title="Отправить запрос">
    </form>
    <input type="button" onclick="history.back();" value="Назад"/>
</body>
</html>
