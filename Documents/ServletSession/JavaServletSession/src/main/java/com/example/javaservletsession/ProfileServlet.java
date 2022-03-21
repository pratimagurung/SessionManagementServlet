package com.example.javaservletsession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession(false);
        if(session != null) {
            String name = (String) session.getAttribute("username");
            writer.println("Welcome " + name);
            writer.println("<form action = 'logout' method = 'post'>");
            /*writer.println("<input type = 'hidden' name = 'username' value = ' " +name+ " '>");*/
            writer.println("<input type ='submit' value = 'Logout' >");
            writer.println("</form>");

        }else{
            writer.println("Please Login Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.include(request,response);
        }
    }
}
