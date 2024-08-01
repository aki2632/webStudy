package com.example.web04member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/m_insert.do","/m_update.do","/m_delete.do",
        "/m_selectOne.do","/m_selectAll.do","/m_searchList.do"})
public class MemberController extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);
        
        //분기 처리
        //member 폴더를 만드시고 관련jsp파일을 이동시킨후 경로 변경해주세요
        if(sPath.equals("/m_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/insert.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/m_update.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/update.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/m_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/delete.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/m_selectOne.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/selectOne.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/m_selectAll.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/m_searchList.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/searchList.jsp");
            rd.forward(request,response);
        }



    }//end doGet()....


    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request,response);
    }


    public void destroy() {
    }
}