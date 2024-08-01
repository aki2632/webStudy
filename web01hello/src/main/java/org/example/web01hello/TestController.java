package org.example.web01hello;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/test1", "/test2", "/test3", "/test4"})
public class TestController extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(request.getContextPath());
        System.out.println(request.getServletPath());

        String sPath = request.getServletPath();

        RequestDispatcher rd = null;
        if (sPath.equals("/test1")) {
            rd = request.getRequestDispatcher("test1.jsp");
        } else if (sPath.equals("/test2")) {
            rd = request.getRequestDispatcher("test2.jsp");
        } else if (sPath.equals("/test3")) {
            rd = request.getRequestDispatcher("test3.jsp");
        } else if (sPath.equals("/test4")) {
            rd = request.getRequestDispatcher("test4.jsp");
        }

        if (rd != null) {
            rd.forward(request, response);
        }
    }

    public void destroy() {
    }
}
