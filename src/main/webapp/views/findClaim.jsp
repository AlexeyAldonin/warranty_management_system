<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>findClaim</title>
</head>
<body>
<jsp:include page="./headers/systemHeader.jsp"></jsp:include>
<p style="color: red; font: -moz-info">${message}</p>
    <h2>Укажите интервал дат</h2>
    <form action="" method="get">
        <label for="initial_date">Начальная дата</label>
        <input id="initial_date" type="date" required max="<%=java.sql.Date.valueOf(LocalDate.now())%>" name="initialDate">
        <label for="final_date">Конечная дата</label>
        <input id="final_date" type="date" required max="<%=java.sql.Date.valueOf(LocalDate.now())%>" name="finalDate" >
        <input type="submit" value="Выполнить запрос">
    </form>
</body>
</html>
