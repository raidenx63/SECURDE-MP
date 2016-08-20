package Controller;

import Model.Customer;
import Model.DB.CustomerDAO;
import Model.User;
import java.beans.Statement;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterProcess {

    public static void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {

        System.out.println("entered registration processessss");

        String fname = request.getParameter("fname");
        String mname = request.getParameter("mname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String billing_address = request.getParameter("billing_address");
        String shipping_address = request.getParameter("shipping_address");

        if (fname.isEmpty() || mname.isEmpty() || lname.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || billing_address.isEmpty() || shipping_address.isEmpty()) {

//            RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
//            out.println("<font color=red>Please fill all the fields</font>");
//            rd.include(request, response);
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        } else {

            Customer user = new Customer();
            user.setAccType(0);
            user.setEmail(email);
            user.setName(fname + " " + mname + " " + lname);
            user.setUsername(username);
            user.setPassword(password);
            user.setBillAdd(billing_address);
            user.setShipAdd(shipping_address);

            CustomerDAO.insertCustomer(user);

            request.getRequestDispatcher("index.jsp").forward(request, response);
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con;
//            try {
//                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/securde",
//                        "root", "");
//
//                PreparedStatement ps;
//                ResultSet rs;
//                ps = con.prepareStatement("SELECT MAX(user_id) FROM user");
//                int last_user_id;
//                // get last user_id
//                rs = ps.executeQuery();
//                last_user_id = rs.getByte(1); //gets the max      
//                last_user_id += 1;
//
//                // for customer table
//                int customer_id = last_user_id;
//
//                // combine to make full name
//                String fullName = fname + " " + mname + " " + lname;
//
//                //ResultSet rs;
//                int i, j; // for the user credentials AND billing adress/shipping address
//                ps = con.prepareStatement("INSERT INTO user(user_id, username, password, email, name, acc_type) VALUES ('" + last_user_id + "','" + username + "','" + password + "','" + email + "','" + fullName + "','" + 1 + ")");
//                i = ps.executeUpdate();
//                if (i > 0) {
//                    // if successful, register billing address & shipping address
//                    ps = con.prepareStatement("INSERT INTO customer(customer_id, user_id, bill_add, ship_add) VALUES ('" + customer_id + "','" + last_user_id + "','" + billing_address + "','" + shipping_address + ")");
//                    j = ps.executeUpdate();
//
//                    if (j > 0) {
//
//                        //session.setAttribute("userid", user);
//                        out.print("Registration Successful!");
//                        //setTimeout("document.location.href='index.jsp'",2000);
//                        con.close();
//
//                        response.sendRedirect("index.jsp");
//
//                    } else {
//
//                        out.print("Registration Failed...");
//                        con.close();
//                        response.sendRedirect("registration.jsp"); // return to registration page or...    
//                    }
//
//                } else {
//                    out.print("Registration Failed...");
//                    con.close();
//
//                    response.sendRedirect("registration.jsp"); // return to registration page or...
//                }
//
//            } catch (SQLException ex) {
//                Logger.getLogger(RegisterProcess.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
    }
}
