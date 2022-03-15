package com.example.loginservlet;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

        System.out.println("Username is : " + UserName + " Password is: " + PassWord);

        if (PassWord.equals("Java") && UserName.equals("Admin")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
            Cookie cookie = new Cookie("cookieUsername", UserName);
            response.addCookie(cookie);
            Cookie cookie1 = new Cookie("cookiePassword", PassWord);
            response.addCookie(cookie1);
            requestDispatcher.forward(request, response);
        } else {

            writer.println("Incorrect Username or Password.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.include(request, response);
        }
    }

    public void destroy() {
    }
}