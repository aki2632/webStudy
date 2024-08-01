package com.example.web03board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/b_insert.do","/b_update.do","/b_delete.do","/b_selectOne.do",
        "/b_selectAll.do","/b_searchList.do","/b_insertOK.do","/b_updateOK.do",
"/b_deleteOK.do"})
public class BoardController extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();

        System.out.println("sPath:"+sPath);

        if(sPath.equals("/b_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/insert.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/b_update.do")){

            System.out.println(request.getParameter("num"));

            int num = Integer.parseInt(request.getParameter("num"));

            BoardVO vo2 = new BoardVO();
            vo2.setNum(num);
            vo2.setTitle("jsp...");
            vo2.setContent("servlet....");
            vo2.setWriter("admin1");
            vo2.setWdate(new Timestamp(System.currentTimeMillis()));

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("board/update.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/b_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/delete.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/b_selectOne.do")){
            System.out.println(request.getParameter("num"));

            int num = Integer.parseInt(request.getParameter("num"));

            BoardVO vo2 = new BoardVO();
            vo2.setNum(num);
            vo2.setTitle("jsp...");
            vo2.setContent("servlet....");
            vo2.setWriter("admin1");
            vo2.setWdate(new Timestamp(System.currentTimeMillis()));

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("board/selectOne.jsp");
            rd.forward(request,response);

        }else if(sPath.equals("/b_selectAll.do")){


            List<BoardVO> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                BoardVO vo2 = new BoardVO();
                vo2.setNum(10+i);
                vo2.setTitle("jsp..."+i);
                vo2.setContent("servlet...."+i);
                vo2.setWriter("admin"+i);
                vo2.setWdate(new Timestamp(System.currentTimeMillis()));
                list.add(vo2);
            }

            request.setAttribute("list",list);

            RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/b_searchList.do")){

            System.out.println(request.getParameter("searchKey"));
            System.out.println(request.getParameter("searchWord"));

            RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/b_insertOK.do")){
            System.out.println(request.getParameter("title"));
            System.out.println(request.getParameter("content"));
            System.out.println(request.getParameter("writer"));
        }else if(sPath.equals("/b_updateOK.do")){
            System.out.println(request.getParameter("num"));
            System.out.println(request.getParameter("title"));
            System.out.println(request.getParameter("content"));
            System.out.println(request.getParameter("writer"));
        }else if(sPath.equals("/b_deleteOK.do")){
            System.out.println(request.getParameter("num"));
        }


    }//end doGet.....

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request,response);


    }//end doPost()....

    public void destroy() {
    }
}