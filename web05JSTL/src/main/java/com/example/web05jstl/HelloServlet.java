package com.example.web05jstl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({"/hello-servlet","/index.do","/index2.do"})
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String sPath = request.getServletPath();
        if(sPath.equals("/hello-servlet")){
            response.setContentType("text/html");

            // Hello
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + message + "</h1>");
            out.println("</body></html>");
        }else if(sPath.equals("/index.do")){

            List<TestVO> list = new ArrayList<>();


            for (int i = 0; i < 5; i++) {
                TestVO vo = new TestVO();
                vo.setName("kim"+i);
                vo.setAge(10+i);
                list.add(vo);
            }

            request.setAttribute("list",list);

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/index2.do")){

            RequestDispatcher rd = request.getRequestDispatcher("index2.jsp");
            rd.forward(request,response);
        }
    }

    public void destroy() {
    }
}