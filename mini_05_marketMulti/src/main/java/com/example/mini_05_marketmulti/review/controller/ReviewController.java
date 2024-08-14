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

@WebServlet({"/r_insertOK.do", "/r_deleteOK.do"})
public class ReviewController extends HttpServlet {

    ReviewDAO rdao = new ReviewDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath:" + sPath);

        if (sPath.equals("/r_insertOK.do")) {
            String content = request.getParameter("content");
            String writer = request.getParameter("writer");
            String pnum = request.getParameter("pnum");
            String img = request.getParameter("img"); // 추가된 필드
            String rate = request.getParameter("rate"); // 추가된 필드

            System.out.println(content);
            System.out.println(writer);
            System.out.println(pnum);
            System.out.println(img); // 추가된 필드
            System.out.println(rate); // 추가된 필드

            ReviewVO vo = new ReviewVO();
            vo.setContent(content);
            vo.setWriter(writer);
            vo.setPnum(Integer.parseInt(pnum));
            vo.setImg(img); // 추가된 필드
            vo.setRate(Integer.parseInt(rate)); // 추가된 필드

            int result = rdao.insert(vo);
            System.out.println("result:" + result);
            response.sendRedirect("p_selectOne.do?num=" + pnum);
        } else if (sPath.equals("/r_deleteOK.do")) {
            String num = request.getParameter("num");
            String pnum = request.getParameter("pnum");
            System.out.println(num);
            System.out.println(pnum);

            ReviewVO vo = new ReviewVO();
            vo.setNum(Integer.parseInt(num));

            int result = rdao.delete(vo);
            System.out.println("result:" + result);
            response.sendRedirect("p_selectOne.do?num=" + pnum);
        }
    }
    public void destroy() {
    }
}
