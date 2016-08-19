/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DB.ItemDAO;
import Model.DB.UserDAO;
import Model.Item;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Stewrat
 */
public class CategoryProcess {
//    <div class="col-sm-6 col-md-2">
//                <div class="thumbnail">
//                    <img src="assets/images/thumb253.jpg" alt="thumb01">
//                    <div class="caption">
//                        <h4>Product #12dcsdddddddddddddddd</h4>
//                        <p><a href="#" class="btn btn-primary" role="button" id="buybutton">Buy</a> <a href="#" class="btn btn-default" role="button" id="reviewbutton">Review</a></p>
//                    </div>
//                </div>
//            </div>

    public static void viewCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int type = Integer.parseInt(request.getParameter("footType"));
        ArrayList<Item> list = ItemDAO.getItemsByType(type);
        PrintWriter pw = response.getWriter();
        pw.println("<!doctype html>\n"
                + "<html lang='en'>"
                + "<head>\n"
                + "        <meta charset=\"utf-8\">\n"
                + "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                + "        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n"
                + "        <title>Category</title>\n"
                + "\n"
                + "        <!-- Bootstrap -->\n"
                + "        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/category.css\" >\n"
                + "        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n"
                + "        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n"
                + "        <!--[if lt IE 9]>\n"
                + "          <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\n"
                + "          <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n"
                + "        <![endif]-->\n"
                + "    </head>\n"
                + "<body>\n"
                + "        <div class=\"space\"><button class='btn btn-primary' onclick=\" location.href = 'checkoutServlet'\">Check Out</button></div>"
                + "<div class=\"row\">");

        for (Item item : list) {
            pw.println("<div class=\"col-sm-6 col-md-2\">\n"
                    + "                <div class=\"thumbnail\">\n"
                    + "                    <img src=\"assets/images/thumb253.jpg\" alt=\"thumb01\">\n"
                    + "                    <div class=\"caption\">\n"
                    + "                        <h4>" + item.getBrand() + "</h4>\n"
                    + "                        <p><a href=\"#\" class=\"btn btn-primary\" role=\"button\" id=\"buybutton\">Buy</a> <a href=\"#\" class=\"btn btn-default\" role=\"button\" id=\"reviewbutton\">Review</a></p>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </div>");
        }

        pw.println("</div>\n"
                + "    </body>\n"
                + "</html>");
    }
}
