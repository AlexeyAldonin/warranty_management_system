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

@WebServlet (name = "claimDetails", urlPatterns = "/claimDetails")
public class ClaimDetailsServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int claimNumber = Integer.parseInt(request.getParameter("claimNumber"));

        RepairDAO repairDAO = new RepairDAO();
        Repair repair = repairDAO.get(claimNumber);

        request.setAttribute("repair", repair);
        getServletContext().getRequestDispatcher(Page.CLAIM_DETAILS.getPath()).forward(request, response);;
    }
}
