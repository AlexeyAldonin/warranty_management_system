package ru.javaprojectkazan.utilities;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletUtilities {

    public static void redirectToContextPageWithMessage (
            HttpServletRequest request, HttpServletResponse response, String pageTag, String message, String page) {

        request.setAttribute(pageTag, message);
        try {
            request.getSession().getServletContext().getRequestDispatcher(page).forward(request, response);
        } catch (ServletException | IOException e) {
            e.getMessage();
        }
    }
}
