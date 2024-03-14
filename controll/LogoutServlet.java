package controll;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import entity.*;
import dao.*;
//import model.*;


public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        HttpSession session = request.getSession();
        session.removeAttribute("acc");
        response.sendRedirect("home");
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        AccountDAO u = new AccountDAO();
        Account a = u.login(user, pass);
        if(a== null){
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }else{
            response.sendRedirect("home");
//request.getRequestDispatcher("home");
        }
        
        

    }
}
