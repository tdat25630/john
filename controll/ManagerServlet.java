package controll;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import entity.*;
import dao.*;
//import model.*;


public class ManagerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
       HttpSession session = request.getSession();
        Account a = (Account)session.getAttribute("acc");
        int id = a.getId();
        ProductDAO u = new ProductDAO();
        CategoryDAO uc = new CategoryDAO();
        List<Product> list = u.getAllProductBySellID(id);
        List<Category> listc = uc.getAllCategory();
        
        request.setAttribute("lsc", listc);
        request.setAttribute("lsp", list);
        request.getRequestDispatcher("ManageProduct.jsp").forward(request, response);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Account a = (Account)session.getAttribute("acc");
        int id = a.getId();
        ProductDAO u = new ProductDAO();
        List<Product> list = u.getAllProductBySellID(id);
        request.setAttribute("lsp", list);
        request.getRequestDispatcher("ManageProduct.jsp").forward(request, response);
//request.getRequestDispatcher("home");
        }
        
        

    }

