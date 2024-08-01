package com.example.web02servletpath;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/insert.do","/update.do","/delete.do",
        "/selectOne.do","/selectAll.do","/searchList.do"})
public class MemberController extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);
        
        //분기 처리
        //member 폴더를 만드시고 관련jsp파일을 이동시킨후 경로 변경해주세요
        if(sPath.equals("/insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/insert.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/update.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/update.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/delete.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/selectOne.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/selectOne.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/selectAll.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/searchList.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/searchList.jsp");
            rd.forward(request,response);
        }

        //MemberController 만드시고
        //서블릿경로는 아래와 같아요.
        ///insert.do,/update.do,/delete.do,/selectOne.do,/selectAll.do,/searchList.do
        //각 서블릿 경로별 아래페이지가 열리도록 구현하세요
        //insert.jsp,update.jsp,delete.jsp,selectOne.jsp,selectAll.jsp,searchList.jsp

        //web03board 프로젝트생성
        //BoardController 추가생성
        //b_insert.do,/b_update.do,/b_delete.do,/b_selectOne.do,/b_selectAll.do,/b_searchList.do
        //각 서블릿 경로별 board폴더안에  아래페이지가 열리도록 구현하세요
        //insert.jsp,update.jsp,delete.jsp,selectOne.jsp,selectAll.jsp,searchList.jsp
        
        //top_menu.jsp도 구현하세요
        //글쓰기,글수정,글삭제,글번호검색,전체글목록,검색어검색
        

    }//end doGet()....

    public void destroy() {
    }
}