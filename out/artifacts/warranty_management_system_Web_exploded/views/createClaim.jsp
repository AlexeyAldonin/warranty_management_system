<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заполнениее рекламации</title>
</head>
<body>
    <form id="repairForm" action="${pageContext.request.contextPath}/createClaim" method="POST">
        <table>
            <tr>
                <td colspan="2"><label>Номер рекламации </label><input type="number" name="claimNumber"></td>
            </tr>
            <tr>
                <td><label>VIN </label><input type="text" required="required" name="vin"></td>
                <td><label>Mileage </label><input type="number" required="required" name="mileage"></td>
            </tr>
            <tr>
                <td colspan="2"><label>Дата ремонта </label><input type="date" required="required" name="repairDate"></td>
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
