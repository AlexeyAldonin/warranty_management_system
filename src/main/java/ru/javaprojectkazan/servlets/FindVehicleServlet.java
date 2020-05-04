package ru.javaprojectkazan.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.javaprojectkazan.beans.Vehicle;
import ru.javaprojectkazan.dao.VehicleDAO;
import ru.javaprojectkazan.enums.Message;
import ru.javaprojectkazan.enums.Page;
import ru.javaprojectkazan.utilities.ServletUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet (name = "findVehicle", urlPatterns = "/findVehicle")
public class FindVehicleServlet extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String vin = request.getParameter("VIN");

        VehicleDAO vehicleDAO = new VehicleDAO();
        Vehicle vehicle = vehicleDAO.get(vin);
        if (vehicle == null) {
            ServletUtilities.redirectToContextPageWithMessage(
                    request, response, "message", Message.MISSING_VIN.getMessage(), Page.FIND_VEHICLE.getPath());
            return;
        }

        request.setAttribute("vehicle", vehicle);
        getServletContext().getRequestDispatcher(Page.VEHICLE_DETAILS.getPath()).forward(request, response);



    }

}
