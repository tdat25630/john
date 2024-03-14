package controll;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

//import model.*;
import java.util.*;
import java.sql.Date;
import entity.*;
import dao.*;

public class DeleteControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String pid =  request.getParameter("pid");
//        int pid = Integer.parseInt("raw");
        ProductDAO u = new ProductDAO();
        u.deleteProduct(pid);
        response.sendRedirect("manager");
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
         ProductDAO u = new ProductDAO();
        Product p;
        List<Product> list = u.getAllProduct();
        request.setAttribute("lsp", list);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }

}

