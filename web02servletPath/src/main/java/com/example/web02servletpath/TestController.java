package com.example.web02servletpath;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/test1","/test2","/test3","/test4"})
public class TestController extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        System.out.println(request.getContextPath());
        System.out.println(request.getServletPath());
        
        String sPath = request.getServletPath();
        
        //분기 처리
        if(sPath.equals("/test1")){
            RequestDispatcher rd = request.getRequestDispatcher("test/test1.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/test2")){
            RequestDispatcher rd = request.getRequestDispatcher("test/test2.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/test3")){
            RequestDispatcher rd = request.getRequestDispatcher("test/test3.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/test4")){
            RequestDispatcher rd = request.getRequestDispatcher("test/test4.jsp");
            rd.forward(request,response);
        }

        //MemberController 만드시고
        //서블릿경로는 아래와 같아요.
        //insert.do,update.do,delete.do,selectOne.do,selectAll.do,searchList.do
        //각 서블릿 경로별 아래페이지가 열리도록 구현하세요
        //insert.jsp,update.jsp,delete.jsp,selectOne.jsp,selectAll.jsp,searchList.jsp
    }//end doGet()....

    public void destroy() {
    }
}