<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заполнениее рекламации</title>
    <style>
        td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <p style="color: red; font: -moz-info">${message}</p>
    <form id="repairForm" action="${pageContext.request.contextPath}/createClaim" method="POST">
        <table style="table-layout: fixed; border-collapse: collapse; border: 3px solid black">
            <%--<tr>
                <td colspan="2"><label>Номер рекламации</label><input type="number" name="claimNumber"></td>
            </tr>--%>
            <tr>
                <td><label>VIN </label><input type="text" required="required" name="vin"></td>
                <td><label>Пробег </label>
                    <input type="number" required="required" pattern="^[ 0-9]+$" min="0" name="mileage"></td>
            </tr>
            <tr>
                <td colspan="2"><label>Дата ремонта </label>
                    <input type="date" required="required" max="<%=java.sql.Date.valueOf(LocalDate.now())%>"
                           name="repairDate"></td>
            </tr>
            <tr>
                <td><label>Заменённая деталь </label><input type="number" required="required" name="partNumber"></td>
                <td><label>Количество деталей </label><input type="number" required="required" name="quantity"></td>
            </tr>
            <tr>
                <td><label>Код работы </label><input type="number" required="required" name="repairOperation"></td>
                <td><label>Трудоёмкость </label><input type="number" required="required" name="hours"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Подтвердить отправку"></td>
            </tr>
        </table>
    </form>

</body>
</html>
