package controll;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import entity.*;
import dao.*;
//import model.*;


public class SigninServlet extends HttpServlet {

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
        String username = request.getParameter("username2");
        String password = request.getParameter("pass2");
        String repassword = request.getParameter("repass");
        if(!password.equals(repassword)){
            
            response.sendRedirect("Login.html");
        }else{
            AccountDAO u = new AccountDAO();
            Account a = u.getAccount(username);
            if(a==null){
                u.signup(username, password);
                response.sendRedirect("home");
            }else{
                HttpSession session = request.getSession();
                session.setAttribute("acc", a);
                response.sendRedirect("Login.html");
            }
        }
        
        

    }
}
