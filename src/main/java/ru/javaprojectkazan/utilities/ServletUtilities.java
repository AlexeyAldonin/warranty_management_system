package ru.javaprojectkazan.utilities;

import lombok.extern.slf4j.Slf4j;
import ru.javaprojectkazan.enums.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
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

    public static void redirectInsideServlet(
            HttpServletRequest request,
            HttpServletResponse response,
            String pagePath) {
        try {
            response.sendRedirect(request.getContextPath() + pagePath);
        } catch (IOException e) {
            try {
                response.sendRedirect(request.getContextPath() + Page.HOME.getPath());
            } catch (IOException e1) {
                log.error("Ошибка при попытке перенаправить на страницу с ошибкой", e1);
            }
        }
    }
}
