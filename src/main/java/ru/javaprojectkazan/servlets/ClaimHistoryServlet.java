package ru.javaprojectkazan.servlets;

import ru.javaprojectkazan.beans.Repair;
import ru.javaprojectkazan.dao.RepairDAO;
import ru.javaprojectkazan.enums.Page;
import ru.javaprojectkazan.utilities.ServletUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "claimHistory", urlPatterns = "/claimHistory")
public class ClaimHistoryServlet extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String vin = request.getParameter("VIN");

        RepairDAO repairDAO = new RepairDAO();
        List<Repair> repairs = repairDAO.getAll(vin);

        request.setAttribute("repairs", repairs);
        getServletContext().getRequestDispatcher(Page.CLAIM_HISTORY.getPath()).forward(request, response);
    }
}
