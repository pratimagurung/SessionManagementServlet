package com.example.loginform;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       //return type k ho define gareko
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        String UserName = request.getParameter("username");
        String PassWord = request.getParameter("password");
        PrintWriter writer = response.getWriter();
        System.out.println("Username is : " + UserName + "Password is: " + PassWord);

        if (PassWord.equals("Java") && UserName.equals("Admin")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Dashboard.jsp");
            requestDispatcher.forward(request, response);
        }else{

            writer.println("Incorrect Username or Password.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.include(request, response);
        }
    }

    public void destroy() {
    }
}