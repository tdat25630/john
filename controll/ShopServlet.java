package controll;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

//import model.*;
import java.util.*;
import java.sql.Date;
import entity.*;
import dao.*;

public class ShopServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        CartDAO c = new CartDAO();
        ProductDAO u = new ProductDAO();
        int id = Integer.parseInt(request.getParameter("id")) ;
        int pid = Integer.parseInt(request.getParameter("pid")) ;
        
        int amount = 1;
        c.insertProductToCart(id, pid, amount);
        List<Cart> listc = c.getAllOrderbyAID(id);
        List<Product> lsp = new ArrayList<>() ;
        Product p;
        for (Cart o : listc) {
           p = u.getProductByID(o.getPid());
           lsp.add(p);
        }
        request.setAttribute("lsp", lsp);
//        int pid = Integer.parseInt("raw");
        List<Cart> list = c.getAllOrderbyAID(id);
        request.setAttribute("listcart", list);
        request.getRequestDispatcher("shopping.jsp").forward(request, response);
        
        
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

