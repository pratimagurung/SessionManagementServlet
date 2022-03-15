package com.example.loginservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SecondServlet", urlPatterns = "/dashboard")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        Cookie cookie[] = request.getCookies();
        if (cookie != null){
            for (int i = 0; i < cookie.length; i++){
                String name = cookie[i].getName();
                String value = cookie[i].getValue();
                writer.println("AttributeName is : " + name + " and ");
                writer.println(" AttributeValue is : " + value);
            }
        }else{
            writer.println("Cookies Not Found");
        }
        writer.close();
    }
}
