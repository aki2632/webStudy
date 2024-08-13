package com.example.mini_05_marketmulti.board.controller;

import com.example.web07total.board.model.BoardDAO;
import com.example.web07total.board.model.BoardDAOimpl;
import com.example.web07total.board.model.BoardVO;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/json_b_selectAll.do","/json_b_selectOne.do"})
public class BoardRestController extends HttpServlet {

    BoardDAO dao = new BoardDAOimpl();

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if(sPath.equals("/json_b_selectAll.do")){
            List<BoardVO> list = dao.selectAll();

            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(list));
        }else if(sPath.equals("/json_b_selectOne.do")){
            String num = request.getParameter("num");

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));

            BoardVO vo2  = dao.selectOne(vo);

            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(vo2));
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