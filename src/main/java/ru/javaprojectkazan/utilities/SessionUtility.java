package ru.javaprojectkazan.utilities;

import ru.javaprojectkazan.beans.User;
import ru.javaprojectkazan.enums.UserCredential;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SessionUtility {

   /* public static Map<String, String> readClientCredentials(HttpServletRequest httpServletRequest) {
        Map<String, String> result = new HashMap<>();
        String clientFirstName = httpServletRequest.getParameter(ClientCredential.FIRST_NAME.getClientCredential());
        String clientSecondName = httpServletRequest.getParameter(ClientCredential.SECOND_NAME.getClientCredential());
        String clientSurname = httpServletRequest.getParameter(ClientCredential.SURNAME.getClientCredential());
        String clientLogin = httpServletRequest.getParameter(ClientCredential.LOGIN.getClientCredential());
        String clientPsswd = httpServletRequest.getParameter(ClientCredential.PSSWD.getClientCredential());
        result.put(ClientCredential.FIRST_NAME.getClientCredential(), clientFirstName);
        result.put(ClientCredential.SECOND_NAME.getClientCredential(), clientSecondName);
        result.put(ClientCredential.SURNAME.getClientCredential(), clientSurname);
        result.put(ClientCredential.LOGIN.getClientCredential(), clientLogin);
        result.put(ClientCredential.PSSWD.getClientCredential(), clientPsswd);
        return result;
    }*/

    public static void fillSession(HttpSession httpSession, User user) {
        httpSession.setAttribute(UserCredential.LOGIN.getName(), user.getLogin());
        httpSession.setAttribute(UserCredential.PSSWD.getName(), user.getPsswd());
        httpSession.setAttribute(UserCredential.NAME.getName(), user.getName());
        httpSession.setAttribute(UserCredential.SURNAME.getName(), user.getSurname());
        httpSession.setAttribute(UserCredential.EMPLOYER.getName(), user.getEmployer());
        httpSession.setMaxInactiveInterval(3600);
    }
}
