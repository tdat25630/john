package controll;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

//import model.*;
import java.util.*;
import java.sql.Date;
import entity.*;
import dao.*;

public class AddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String raw =  request.getParameter("pid");
        int pid = Integer.parseInt("raw");
        ProductDAO u = new ProductDAO();
//        u.deleteProduct(pid);
        response.sendRedirect("manager");
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter pr = response.getWriter();
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price")) ;
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int category = Integer.parseInt(request.getParameter("category"));
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int sid = a.getId();
        ProductDAO u = new ProductDAO();
        u.insertProduct(name, image, price, title, description, category, sid);
        response.sendRedirect("manager");
    }

}

