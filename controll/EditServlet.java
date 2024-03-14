package controll;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

//import model.*;
import java.util.*;
import java.sql.Date;
import entity.*;
import dao.*;

public class EditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        ProductDAO u = new ProductDAO();
        CategoryDAO uc = new CategoryDAO();
        int id = Integer.parseInt(request.getParameter("pid"));
        List<Category> listc = uc.getAllCategory();
        
        Product p = u.getProductByID(id);
        request.setAttribute("lsc", listc);
        request.setAttribute("product", p);
        request.getRequestDispatcher("Edit.jsp").forward(request, response);
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        ProductDAO u = new ProductDAO();
        
         String name = request.getParameter("name");
         String image = request.getParameter("image");
         double price = Double.parseDouble(request.getParameter("price"));
         String title = request.getParameter("title");
         String description = request.getParameter("description");
         int cateID = Integer.parseInt(request.getParameter("category"));
         int id = Integer.parseInt(request.getParameter("id"));
         
         u.updateProduct(name, image, price, title, description, cateID, id);
         response.sendRedirect("manager");
         
         
    }

}

