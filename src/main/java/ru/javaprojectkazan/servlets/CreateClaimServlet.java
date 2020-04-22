package ru.javaprojectkazan.servlets;

import lombok.SneakyThrows;
import ru.javaprojectkazan.beans.Part;
import ru.javaprojectkazan.beans.Repair;
import ru.javaprojectkazan.beans.RepairOperation;
import ru.javaprojectkazan.beans.Vehicle;
import ru.javaprojectkazan.dao.PartDAO;
import ru.javaprojectkazan.dao.RepairDAO;
import ru.javaprojectkazan.dao.RepairOperationDAO;
import ru.javaprojectkazan.dao.VehicleDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "createClaim", urlPatterns = "/createClaim")
public class CreateClaimServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        int claimNumber = Integer.parseInt(request.getParameter("claimNumber"));
        Date repairDate = new SimpleDateFormat("dd.MM.yyyy").parse(request.getParameter("repairDate"));
        String vin = request.getParameter("vin");
        int mileage = Integer.parseInt(request.getParameter("mileage"));
        int partNumber = Integer.parseInt(request.getParameter("partNumber"));
        int partQuantity = Integer.parseInt(request.getParameter("quantity"));
        int repairOperationId = Integer.parseInt(request.getParameter("repairOperation"));
        double hours = Integer.parseInt(request.getParameter("hours"));

        PartDAO replacedPart = new PartDAO();
        Part part = replacedPart.get(partNumber);

        VehicleDAO repairedVehicle = new VehicleDAO();
        Vehicle vehicle = repairedVehicle.get(vin);

        RepairOperationDAO operation = new RepairOperationDAO();
        RepairOperation repairOperation = operation.get(repairOperationId);


        Repair newRepair = new Repair(claimNumber, repairDate, vehicle, mileage, part, partQuantity,
                repairOperation, hours);

        RepairDAO currentRepair = new RepairDAO();
        currentRepair.insert(newRepair);

        response.sendRedirect(request.getContextPath() + "index.jsp");


    }
}
