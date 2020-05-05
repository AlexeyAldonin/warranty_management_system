<jsp:useBean id="repairs" scope="request" type="java.util.ArrayList"/>
<%--
<jsp:useBean id="vehicle" scope="request" type="ru.javaprojectkazan.beans.Vehicle"/>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vehicle Claim History</title>
    <style>
        td, th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <h2>Сводная таблица ремонтов для автомобиля: ${repairs.get(0).vehicle.vin}</h2>
    <table id="repairsList" style="table-layout: fixed; border-collapse: collapse; border: 3px solid black">
        <tr>
            <th>Claim Number</th>
            <th>Repair Date</th>
            <th>Vehicle Mileage</th>
            <th>Causal Part</th>
            <th>Total Cost</th>
        </tr>
        <c:forEach items="${repairs}" var="repair">
            <tr>
                <td>${repair.claimNumber}</td>
                <td>${repair.dateOfRepair}</td>
                <td>${repair.vehicleMileage}</td>
                <td>${repair.causalPart.catalogueNumber}</td>
                <td>${repair.totalRepairCost}</td>
            </tr>
        </c:forEach>
    </table>
    <input type="button" onclick="history.back();" value="Назад"/>
</body>
</html>
