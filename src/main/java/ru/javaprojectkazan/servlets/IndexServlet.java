package ru.javaprojectkazan.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.javaprojectkazan.enums.Page;
import ru.javaprojectkazan.utilities.ServletUtilities;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@WebServlet(name = "index", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    protected void doPost (HttpServletRequest request, HttpServletResponse response){

        String userEnter = request.getParameter("userLogin");
        String adminEnter = request.getParameter("adminLogin");

        if (userEnter != null) {
            ServletUtilities.redirectInsideServlet(request, response, Page.LOGIN_PAGE.getPath());
        } else if (adminEnter != null) ServletUtilities.redirectInsideServlet(request, response, Page.INDEX_PAGE.getPath());
    }
}
