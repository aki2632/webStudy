package com.example.mini_05_marketmulti.wish.controller;

import com.example.mini_05_marketmulti.wish.model.WishDAO;
import com.example.mini_05_marketmulti.wish.model.WishDAOimpl;
import com.example.mini_05_marketmulti.wish.model.WishVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet({"/wish_insertOK.do", "/wish_deleteOK.do", "/wish_selectAll.do"})
public class WishController extends HttpServlet {

    private WishDAO wdao = new WishDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath: " + sPath);

        HttpSession session = request.getSession();
        Integer mnum = (Integer) session.getAttribute("mnum"); // 세션에서 사용자 번호 가져오기

        if (mnum == null) {
            response.sendRedirect("login.do");
            return;
        }

        if (sPath.equals("/wish_insertOK.do")) {
            // 위시리스트에 상품 추가
            String pnum = request.getParameter("pnum");

            WishVO vo = new WishVO();
            vo.setPnum(Integer.parseInt(pnum));
            vo.setMnum(mnum);  // 세션에서 가져온 mnum 사용

            int result = wdao.insert(vo);
            System.out.println("Insert result: " + result);

            response.sendRedirect("wish_selectAll.do");

        } else if (sPath.equals("/wish_deleteOK.do")) {
            // 위시리스트에서 상품 삭제
            String num = request.getParameter("num");

            WishVO vo = new WishVO();
            vo.setNum(Integer.parseInt(num));

            int result = wdao.delete(vo);
            System.out.println("Delete result: " + result);

            response.sendRedirect("wish_selectAll.do");

        } else if (sPath.equals("/wish_selectAll.do")) {
            // 위시리스트 조회
            List<WishVO> wishList = wdao.selectAll();

            request.setAttribute("wishList", wishList);

            request.getRequestDispatcher("wish/selectAll.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }

    @Override
    public void destroy() {
        // 리소스 정리 작업이 필요하면 여기에 작성
    }
}

