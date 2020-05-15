<jsp:useBean id="repair" scope="request" type="ru.javaprojectkazan.beans.Repair"/>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Claim Details</title>
</head>
<body>
<jsp:include page="./headers/systemHeader.jsp"></jsp:include>
    <h2>Details of Claim # ${repair.claimNumber}</h2>
    <p>Repair Date: ${repair.dateOfRepair}</p><br><br>
    <h3>Vehicle Summary</h3>
    <p>Vehicle VIN: ${repair.vehicle.vin}</p>
    <p>Mileage: ${repair.vehicleMileage}</p><br>
    <h3>Parts Summary</h3>
    <table>
        <tr>
            <th>Part Number </th><th>Part name </th><th>Price </th><th>Quantity </th><th>Parts cost</th>
        </tr>
        <tr>
            <td>${repair.causalPart.catalogueNumber}</td>
            <td>${repair.causalPart.partName}</td>
            <td>${repair.causalPart.price}</td>
            <td>${repair.partQuantity}</td>
            <td>${repair.partsTotalCost}</td>
        </tr>
    </table><br>
    <h3>Repair Operations Summary</h3>
    <table>
        <tr>
            <th>Operation Number </th><th>Operation name </th><th>Price </th>
            <th>Repair Hours </th><th>Operations cost</th>
        </tr>
        <tr>
            <td>${repair.repairOperation.code}</td>
            <td>${repair.repairOperation.name}</td>
            <td>${repair.repairOperation.hourPrice}</td>
            <td>${repair.repairTime}</td>
            <td>${repair.repairOperationsTotalCost}</td>
        </tr>
    </table><br>
    <h3>Repair total cost: ${repair.totalRepairCost}</h3><br>
    <input type="button" onclick="history.back();" value="Назад"/>
</body>
</html>
