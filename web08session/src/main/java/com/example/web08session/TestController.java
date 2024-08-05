package com.example.web08session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

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

            // 세션
            HttpSession session = request.getSession();
            session.setAttribute("user_id", id); // EL${user_id}
            session.setAttribute("name", "kim"); // EL${name}
            session.setMaxInactiveInterval(5*60); // 세션만료 시간: 5분(새로고침으로 연장됨)

            /*
            // 로그아웃에 사용되는 메소드
            session.removeAttribute("name"); // 속성제거
            session.invalidate(); // 세션제거
            */

            // 쿠키 : 클라이언트(웹 사용자) 브라우저에 저장가능
            // 쿠키 생성 후 응답객체(response)에 추가하는 방식을 사용함
            Cookie cookie = new Cookie("message", "hello"); // 쿠키 생성
            cookie.setMaxAge(5); // 5초만 유지(새로고침으로 연장안됨)
            response.addCookie(cookie); // 응답객체(response)에 추가
            Cookie cookie2 = new Cookie("isChecked", "true"); // 응답객체(response)에 추가
            cookie2.setMaxAge(10); // 5초만 유지(새로고침으로 연장안됨)
            response.addCookie(cookie2); // 응답객체(response)에 추가

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