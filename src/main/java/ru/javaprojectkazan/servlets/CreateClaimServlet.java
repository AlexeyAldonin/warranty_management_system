package ru.javaprojectkazan.servlets;

import ru.javaprojectkazan.beans.Part;
import ru.javaprojectkazan.beans.Repair;
import ru.javaprojectkazan.beans.RepairOperation;
import ru.javaprojectkazan.beans.Vehicle;
import ru.javaprojectkazan.dao.PartDAO;
import ru.javaprojectkazan.dao.RepairDAO;
import ru.javaprojectkazan.dao.RepairOperationDAO;
import ru.javaprojectkazan.dao.VehicleDAO;
import ru.javaprojectkazan.enums.Message;
import ru.javaprojectkazan.enums.Page;
import ru.javaprojectkazan.utilities.ServletUtilities;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "createClaim", urlPatterns = "/createClaim")
public class CreateClaimServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String vin = request.getParameter("vin");
        String mileage = request.getParameter("mileage");
        Date repairDate = Date.valueOf((request.getParameter("repairDate")));
        String partNumber = request.getParameter("partNumber");
        String partQuantity = request.getParameter("quantity");
        String repairOperationId = request.getParameter("repairOperation");
        String hours = request.getParameter("hours");

        PartDAO replacedPart = new PartDAO();
        Part part = replacedPart.get(Integer.parseInt(partNumber));
        if (part == null) {
            ServletUtilities.redirectToContextPageWithMessage(
                    request, response, "message", Message.MISSING_PART.getMessage(), Page.CREATE_CLAIM.getPath());
            return;
        }

        VehicleDAO repairedVehicle = new VehicleDAO();
        Vehicle vehicle = repairedVehicle.get(vin);
        if (vehicle == null) {
            ServletUtilities.redirectToContextPageWithMessage(
                    request, response, "message", Message.MISSING_VIN.getMessage(), Page.CREATE_CLAIM.getPath());
            return;
        }
        if (vehicle.getMileageAtLastClaim() > Integer.parseInt(mileage)) {
            ServletUtilities.redirectToContextPageWithMessage(
                    request, response, "message",
                    Message.INCORRECT_MILEAGE.getMessage() + vehicle.getMileageAtLastClaim(), Page.CREATE_CLAIM.getPath());
            return;
        }

        RepairOperationDAO operation = new RepairOperationDAO();
        RepairOperation repairOperation = operation.get(Integer.parseInt(repairOperationId));
        if (repairOperation == null) {
            ServletUtilities.redirectToContextPageWithMessage(
                    request, response, "message", Message.MISSING_OPERATION.getMessage(), Page.CREATE_CLAIM.getPath());
            return;
        }

        Repair newRepair = new Repair(repairDate, vehicle, Integer.parseInt(mileage), part, Integer.parseInt(partQuantity),
                repairOperation, Integer.parseInt(hours));

        RepairDAO currentRepair = new RepairDAO();
        currentRepair.insert(newRepair);
        currentRepair.update(newRepair); //обновление пробега для автомобиля


        response.sendRedirect(request.getContextPath() + Page.HOME.getPath());


    }
}
