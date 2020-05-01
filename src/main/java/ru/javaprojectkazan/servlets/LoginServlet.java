package ru.javaprojectkazan.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.javaprojectkazan.beans.User;
import ru.javaprojectkazan.dao.UserDAO;
import ru.javaprojectkazan.enums.UserCredential;
import ru.javaprojectkazan.utilities.SessionUtility;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@WebServlet (name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {

        String login = request.getParameter("login");
        String psswd = request.getParameter("psswd");

        UserDAO userDAO = new UserDAO();
        User user = null;
        try {
            user = userDAO.get(login, psswd);
            if (user == null) {
                log.error("Сбой при получении учётных данных клиента");
            }
        } catch (Exception e) { }

        HttpSession httpSession = request.getSession();
        SessionUtility.fillSession(httpSession, user);

        response.sendRedirect(request.getContextPath() + "/views/createClaim.jsp");
    }
}
