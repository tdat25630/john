package controll;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import entity.*;
import dao.*;
//import model.*;


public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter pr = response.getWriter();
        ProductDAO u = new ProductDAO();
        CategoryDAO uc = new CategoryDAO();
        String name = request.getParameter("name");
        
        Category c;
        Product p;
        List<Category> listc = uc.getAllCategory();
        List<Product> list = u.getAllProductByName(name);
        Product recent = u.getNewest();
        
        
        
        request.setAttribute("lsc", listc);
        request.setAttribute("lsp", list);
        request.setAttribute("recent", recent);
        request.setAttribute("txtsearch", name);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
        
        

    }
}
