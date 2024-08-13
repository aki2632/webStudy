package com.example.mini_05_marketmulti.review.controller;

import com.example.mini_05_marketmulti.review.model.ReviewDAO;
import com.example.mini_05_marketmulti.review.model.ReviewDAOimpl;
import com.example.mini_05_marketmulti.review.model.ReviewVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/r_insertOK.do","/r_deleteOK.do"})
public class ReviewController extends HttpServlet {

    ReviewDAO rdao = new ReviewDAOimpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();

        System.out.println("sPath:"+sPath);

        if(sPath.equals("/r_insertOK.do")){
            String content = request.getParameter("content");
            String writer = request.getParameter("writer");
            String bnum = request.getParameter("bnum");
            System.out.println(content);
            System.out.println(writer);
            System.out.println(bnum);

            ReviewVO vo = new ReviewVO();
            vo.setContent(content);
            vo.setWriter(writer);
            vo.setProductId(Integer.parseInt(bnum));

            int result = rdao.insert(vo);
            System.out.println("result:"+result);
            response.sendRedirect("b_selectOne.do?num="+bnum);
        }else if(sPath.equals("/r_deleteOK.do")){
            String num = request.getParameter("num");
            String bnum = request.getParameter("bnum");
            System.out.println(num);
            System.out.println(bnum);

            ReviewVO vo = new ReviewVO();
            vo.setReviewId(Integer.parseInt(num));

            int result = rdao.delete(vo);
            System.out.println("result:"+result);
            response.sendRedirect("b_selectOne.do?num="+bnum);
        }

    }//end doGet()....

    public void destroy() {
    }
}