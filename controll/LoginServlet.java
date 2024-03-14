package controll;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import entity.*;
import dao.*;
//import model.*;


public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        request.getRequestDispatcher("Login.html").forward(request, response);
        
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
            HttpSession session = request.getSession();
            session.setAttribute("acc", a);
            response.sendRedirect("home");
//request.getRequestDispatcher("home");
        }
        
        

    }
}
