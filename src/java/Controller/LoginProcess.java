/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DB.UserDAO;
import Model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Stewrat
 */
public class LoginProcess {

    public static void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = UserDAO.getUser(username);

        if (user != null && username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            Cookie userCookie = new Cookie("username", username);

            request.getSession().setAttribute("user", user);

            userCookie.setMaxAge(6000);

            response.addCookie(userCookie);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public static void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookieList = request.getCookies();

        if (cookieList != null) {
            for (Cookie cookie : cookieList) {
                if (cookie.getName().equals("username")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    
                    break;
                } 
            }
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
