/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Stewrat
 */
public class OperatorProcess {
    public static void operate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int choice = Integer.parseInt(request.getParameter("choice"));
        
        System.out.println("choice: " + choice);
        
        switch (choice) {
            case 0:
                request.getRequestDispatcher("registration.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }
}
