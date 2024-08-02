package com.example.web07total.controller;

import java.io.*;
import java.util.List;

import com.example.web07total.model.board.BoardDAOimpl;
import com.example.web07total.model.board.BoardVO;
import com.example.web07total.model.board.BoardDAO;

import com.example.web07total.model.member.MemberDAOimpl;
import com.example.web07total.model.member.MemberVO;
import com.example.web07total.model.member.MemberDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({"/m_insert.do","/m_update.do","/m_delete.do","/m_selectOne.do","/m_selectAll.do","/m_searchList.do","/m_insertOK.do","/m_updateOK.do","/m_deleteOK.do",
        "/b_insert.do","/b_update.do","/b_delete.do","/b_selectOne.do","/b_selectAll.do","/b_searchList.do","/b_insertOK.do","/b_updateOK.do","/b_deleteOK.do"})
public class TotalController extends HttpServlet {
    MemberDAO mdao = new MemberDAOimpl();
    BoardDAO bdao = new BoardDAOimpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));

            MemberVO vo2 = mdao.selectOne(vo);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("member/update.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/m_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/delete.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/m_selectOne.do")){

            String num = request.getParameter("num");
            System.out.println(num);

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));

            MemberVO vo2 = mdao.selectOne(vo);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("member/selectOne.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/m_selectAll.do")){


            List<MemberVO> list = mdao.selectAll();

            request.setAttribute("list",list);


            RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/m_searchList.do")){

            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<MemberVO> list = mdao.searchList(searchKey,searchWord);

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

            MemberVO vo = new MemberVO();
            vo.setId(id);
            vo.setPw(pw);
            vo.setName(name);
            vo.setTel(tel);

            int result = mdao.insert(vo);
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


            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));
            vo.setId(id);
            vo.setPw(pw);
            vo.setName(name);
            vo.setTel(tel);

            int result = mdao.update(vo);
            if(result ==1 ){
                System.out.println("update successed...");
                response.sendRedirect("m_selectOne.do?num=" + num);//서블릿패스
            }else{
                System.out.println("update failed...");
                response.sendRedirect("m_update.do?num=" + num);//서블릿패스
            }

        }else if(sPath.equals("/m_deleteOK.do")){
            String num = request.getParameter("num");
            System.out.println(num);

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));

            int result = mdao.delete(vo);
            if(result ==1 ){
                System.out.println("delete successed...");
                response.sendRedirect("m_selectAll.do");//서블릿패스
            }else{
                System.out.println("delete failed...");
                response.sendRedirect("m_delete.do?num=" + num);//서블릿패스
            }
        }else if(sPath.equals("/b_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/insert.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/b_update.do")){

            int num = Integer.parseInt(request.getParameter("num"));
            System.out.println(num);

            BoardVO vo = new BoardVO();
            vo.setNum(num);

            BoardVO vo2 = bdao.selectOne(vo);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("board/update.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/b_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/delete.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/b_selectOne.do")){

            int num = Integer.parseInt(request.getParameter("num"));
            System.out.println(num);

            BoardVO vo = new BoardVO();
            vo.setNum(num);

            BoardVO vo2 = bdao.selectOne(vo);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("board/selectOne.jsp");
            rd.forward(request,response);

        }else if(sPath.equals("/b_selectAll.do")){


            List<BoardVO> list = bdao.selectAll();

            request.setAttribute("list",list);

            RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/b_searchList.do")){
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<BoardVO> list = bdao.searchList(searchKey,searchWord);
            request.setAttribute("list",list);

            RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/b_insertOK.do")){
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String writer = request.getParameter("writer");
            System.out.println(title);
            System.out.println(content);
            System.out.println(writer);

            BoardVO vo = new BoardVO();
            vo.setTitle(title);
            vo.setContent(content);
            vo.setWriter(writer);

            int result = bdao.insert(vo);
            if(result ==1 ){
                System.out.println("insert successed...");
                response.sendRedirect("b_selectAll.do");//서블릿패스
            }else{
                System.out.println("insert failed...");
                response.sendRedirect("b_insert.do");//서블릿패스
            }


        }else if(sPath.equals("/b_updateOK.do")){
            String num = request.getParameter("num");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String writer = request.getParameter("writer");
            System.out.println(num);
            System.out.println(title);
            System.out.println(content);
            System.out.println(writer);

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));
            vo.setTitle(title);
            vo.setContent(content);
            vo.setWriter(writer);

            int result = bdao.update(vo);

            if(result ==1 ){
                System.out.println("update successed...");
                response.sendRedirect("b_selectOne.do?num="+num);//서블릿패스
            }else{
                System.out.println("update failed...");
                response.sendRedirect("b_update.do?num="+num);//서블릿패스
            }

        }else if(sPath.equals("/b_deleteOK.do")){
            String num = request.getParameter("num");
            System.out.println(num);

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));

            int result = bdao.delete(vo);
            if(result ==1 ){
                System.out.println("delete successed...");
                response.sendRedirect("b_selectAll.do");//서블릿패스
            }else{
                System.out.println("delete failed...");
                response.sendRedirect("b_delete.do?num="+num);//서블릿패스
            }

        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request,response);
    }

    public void destroy() {
    }
}