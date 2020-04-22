<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заполнениее рекламации</title>
</head>
<body>
    <form action="/createClaim" method="POST">
        <table>
            <tr>
                <td colspan="2">Номер рекламации <input type="number" id="clamNumber"></td>
            </tr>
            <tr>
                <td>VIN <input type="text" id="vin"></td>
                <td>Mileage <input type="number" id="mileage"></td>
            </tr>
            <tr>
                <td colspan="2">Дата ремонта <input type="date" id="repairDate"></td>
            </tr>
            <tr>
                <td>Заменённая деталь <input type="number" id="partNumber"></td>
                <td>Количество деталей <input type="number" id="quantity"></td>
            </tr>
            <tr>
                <td>Код работы <input type="number" id="repairOperation"></td>
                <td>Трудоёмкость <input type="number" id="hours"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Подтвердить отправку"></td>
            </tr>
        </table>
    </form>

</body>
</html>
