package controll;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

//import model.*;
import java.util.*;
import java.sql.Date;
import entity.*;
import dao.*;

public class CategoryControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String cateID = request.getParameter("cid");
        int cid = Integer.parseInt(cateID);
        ProductDAO u = new ProductDAO();
        CategoryDAO uc = new CategoryDAO();
        
        List<Category> listc = uc.getAllCategory();
        List<Product> list = u.getAllProductByCID(cid);
        Product recent = u.getNewest();
        
        request.setAttribute("tag", cid);
        request.setAttribute("recent", recent);
        request.setAttribute("lsc", listc);
        request.setAttribute("lsp", list);
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

