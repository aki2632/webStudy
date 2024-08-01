package org.example.web01hello;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/insert.do", "/update.do", "/delete.do", "/selectOne.do", "/selectAll.do", "/searchList.do"})
public class MemberController extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(request.getContextPath());
        System.out.println(request.getServletPath());

        String sPath = request.getServletPath();

        RequestDispatcher rd = null;
        if (sPath.equals("/insert.do")) {
            rd = request.getRequestDispatcher("insert.jsp");
        } else if (sPath.equals("/update.do")) {
            rd = request.getRequestDispatcher("update.jsp");
        } else if (sPath.equals("/delete.do")) {
            rd = request.getRequestDispatcher("delete.jsp");
        } else if (sPath.equals("/selectOne.do")) {
            rd = request.getRequestDispatcher("selectOne.jsp");
        } else if (sPath.equals("/selectAll.do")) {
            rd = request.getRequestDispatcher("selectAll.jsp");
        } else if (sPath.equals("/searchList.do")) {
            rd = request.getRequestDispatcher("searchList.jsp");
        }

        if (rd != null) {
            rd.forward(request, response);
        }
    }

    public void destroy() {
    }
}
