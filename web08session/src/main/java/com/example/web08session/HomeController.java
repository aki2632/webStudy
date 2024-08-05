package com.example.web08session;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/home.do")
public class HomeController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String sPath = request.getServletPath();
        System.out.println(sPath);

        if (sPath.equals("/home.do")) {
            Cookie[] cookies = request.getCookies();
            System.out.println("Cookies: " + cookies);
            for (Cookie x:cookies) {
                System.out.println(x.getName());
                System.out.println(x.getValue());
            }

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

    public void destroy() {
    }
}