package com.example.web08session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/login.do", "/loginOK.do", "/logout.do"})
public class TestController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String sPath = request.getServletPath();
        System.out.println(sPath);

        if (sPath.equals("/login.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }else if (sPath.equals("/loginOK.do")) {
            String id =request.getParameter("id");
            String pw =request.getParameter("pw");
            System.out.println(id);
            System.out.println(pw);

            HttpSession session = request.getSession();
            session.setAttribute("user_id", id); // EL${user_id}
            session.setAttribute("name", "kim"); // EL${name}
            session.setMaxInactiveInterval(5*60); // 세션만료 시간: 5분

            /*
            // 로그아웃에 사용되어지는 메소드
            session.removeAttribute("name"); // 속성제거
            session.invalidate(); // 세션제거
            */

            response.sendRedirect("home.do");
        }else if (sPath.equals("/logout.do")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("home.do");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String sPath = request.getServletPath();
        System.out.println(sPath);
        doGet(request, response);
    }

    public void destroy() {
    }
}