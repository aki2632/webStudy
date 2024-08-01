package com.example.web04member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/m_insert.do","/m_update.do","/m_delete.do",
        "/m_selectOne.do","/m_selectAll.do","/m_searchList.do",
"/m_insertOK.do","/m_updateOK.do","/m_deleteOK.do"})
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

            String num = request.getParameter("num");
            System.out.println(num);

            MemberVO vo2 = new MemberVO();
            vo2.setNum(Integer.parseInt(num));
            vo2.setId("admin11");
            vo2.setPw("hi1111");
            vo2.setName("kim11");
            vo2.setTel("011");

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("member/update.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/m_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/delete.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/m_selectOne.do")){

            String num = request.getParameter("num");
            System.out.println(num);

            MemberVO vo2 = new MemberVO();
            vo2.setNum(Integer.parseInt(num));
            vo2.setId("admin11");
            vo2.setPw("hi1111");
            vo2.setName("kim11");
            vo2.setTel("011");

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("member/selectOne.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/m_selectAll.do")){


            List<MemberVO> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                MemberVO vo2 = new MemberVO();
                vo2.setNum(10+i);
                vo2.setId("admin11"+i);
                vo2.setPw("hi1111"+i);
                vo2.setName("kim11"+i);
                vo2.setTel("011"+i);
                list.add(vo2);
            }

            request.setAttribute("list",list);


            RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/m_searchList.do")){

            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<MemberVO> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                MemberVO vo2 = new MemberVO();
                vo2.setNum(10+i);
                vo2.setId("admin11"+i);
                vo2.setPw("hi1111"+i);
                vo2.setName("kim11"+i);
                vo2.setTel("011"+i);
                list.add(vo2);
            }

            request.setAttribute("list",list);


            RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/m_insertOK.do")){
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");
            System.out.println(id);
            System.out.println(pw);
            System.out.println(name);
            System.out.println(tel);


            int result = 1;
            if(result ==1 ){
                System.out.println("insert successed...");
                response.sendRedirect("m_selectAll.do");//서블릿패스
            }else{
                System.out.println("insert failed...");
                response.sendRedirect("m_insert.do");//서블릿패스
            }

        }else if(sPath.equals("/m_updateOK.do")){
            String num = request.getParameter("num");
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");
            System.out.println(num);
            System.out.println(id);
            System.out.println(pw);
            System.out.println(name);
            System.out.println(tel);


            int result = 1;
            if(result ==1 ){
                System.out.println("update successed...");
                response.sendRedirect("m_selectOne.do?num="+num);//서블릿패스
            }else{
                System.out.println("update failed...");
                response.sendRedirect("m_update.do?num="+num);//서블릿패스
            }

        }else if(sPath.equals("/m_deleteOK.do")){
            String num = request.getParameter("num");
            System.out.println(num);

            int result = 1;
            if(result ==1 ){
                System.out.println("delete successed...");
                response.sendRedirect("m_selectAll.do");//서블릿패스
            }else{
                System.out.println("delete failed...");
                response.sendRedirect("m_delete.do?num="+num);//서블릿패스
            }
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