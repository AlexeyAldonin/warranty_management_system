<jsp:useBean id="vehicle" scope="request" type="ru.javaprojectkazan.beans.Vehicle"/>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vehicle Details</title>
</head>
<body>
    <h2>Сводная информация об автомобиле:</h2>
    <p>VIN: ${vehicle.vin}</p>
    <p>Model: ${vehicle.model}</p>
    <p>Dispatch Date: ${vehicle.dispatchDate}</p>
    <p>Date of sale: ${vehicle.soldDate}</p>
    <p>Warranty expire date: ${vehicle.warrantyExpireDate}</p>
    <p>Mileage at last claim: ${vehicle.mileageAtLastClaim}</p>
    <input type="button" onclick="history.back();" value="Назад"/>
</body>
</html>
