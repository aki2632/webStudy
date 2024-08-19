package com.example.mini_05_marketmulti.review.controller;

import com.example.mini_05_marketmulti.review.model.ReviewDAO;
import com.example.mini_05_marketmulti.review.model.ReviewDAOimpl;
import com.example.mini_05_marketmulti.review.model.ReviewVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

@WebServlet({"/r_insertOK.do", "/r_deleteOK.do"})
@MultipartConfig
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
            String rate = request.getParameter("rate");

            System.out.println(content);
            System.out.println(writer);
            System.out.println(pnum);
            System.out.println(rate);

            Part filePart = request.getPart("img");
            String imgPath = null;
            if (filePart != null && filePart.getSize() > 0) {
                // 저장된 파일 경로를 설정합니다.
                String fileName = filePart.getSubmittedFileName();
                String uploadPath = getServletContext().getRealPath("/") + "upload/";
                java.io.File fileSaveDir = new java.io.File(uploadPath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }
                filePart.write(uploadPath + fileName);
                imgPath = "upload/" + fileName; // 파일 경로 설정
            }

            ReviewVO vo = new ReviewVO();
            vo.setContent(content);
            vo.setWriter(writer);
            vo.setPnum(Integer.parseInt(pnum));
            vo.setImg(imgPath); // 이미지 파일 경로 설정
            vo.setRate(Integer.parseInt(rate)); // 평점 설정

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }

    @Override
    public void destroy() {
    }
}
