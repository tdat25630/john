package controll;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

//import model.*;
import java.util.*;
import java.sql.Date;
import entity.*;
import dao.*;

public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        ProductDAO u = new ProductDAO();
        CategoryDAO uc = new CategoryDAO();
        Category c;
        Product p;
        List<Category> listc = uc.getAllCategory();
        List<Product> list = u.getAllProduct();
        Product recent = u.getNewest();
        
        
        
        request.setAttribute("lsc", listc);
        request.setAttribute("lsp", list);
        request.setAttribute("recent", recent);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
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

