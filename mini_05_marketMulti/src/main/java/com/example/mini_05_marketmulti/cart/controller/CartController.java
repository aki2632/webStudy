package com.example.mini_05_marketmulti.cart.controller;

import com.example.mini_05_marketmulti.cart.model.CartDAO;
import com.example.mini_05_marketmulti.cart.model.CartDAOimpl;
import com.example.mini_05_marketmulti.cart.model.CartVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet({"/cart_insertOK.do", "/cart_deleteOK.do", "/cart_updateOK.do", "/cart_selectAll.do"})
public class CartController extends HttpServlet {

    private CartDAO cdao = new CartDAOimpl();

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

        if (sPath.equals("/cart_insertOK.do")) {
            // 카트에 상품 추가
            String pnum = request.getParameter("pnum");
            String amountCount = request.getParameter("amountCount");
            String priceCount = request.getParameter("priceCount");

            CartVO vo = new CartVO();
            vo.setPnum(Integer.parseInt(pnum));
            vo.setMnum(mnum);  // 세션에서 가져온 mnum 사용
            vo.setAmountCount(Integer.parseInt(amountCount));
            vo.setPriceCount(Integer.parseInt(priceCount));

            int result = cdao.insert(vo);
            System.out.println("Insert result: " + result);

            response.sendRedirect("cart_selectAll.do");

        } else if (sPath.equals("/cart_deleteOK.do")) {
            // 카트에서 상품 삭제
            String num = request.getParameter("num");

            CartVO vo = new CartVO();
            vo.setNum(Integer.parseInt(num));

            int result = cdao.delete(vo);
            System.out.println("Delete result: " + result);

            response.sendRedirect("cart_selectAll.do");

        } else if (sPath.equals("/cart_updateOK.do")) {
            // 카트 상품 정보 업데이트
            String num = request.getParameter("num");
            String pnum = request.getParameter("pnum");
            String amountCount = request.getParameter("amountCount");
            String priceCount = request.getParameter("priceCount");

            CartVO vo = new CartVO();
            vo.setNum(Integer.parseInt(num));
            vo.setPnum(Integer.parseInt(pnum));
            vo.setMnum(mnum);  // 세션에서 가져온 mnum 사용
            vo.setAmountCount(Integer.parseInt(amountCount));
            vo.setPriceCount(Integer.parseInt(priceCount));

            int result = cdao.update(vo);
            System.out.println("Update result: " + result);

            response.sendRedirect("cart_selectAll.do");

        } else if (sPath.equals("/cart_selectAll.do")) {
            // 카트에 담긴 모든 상품 조회
            List<CartVO> cartList = cdao.selectAll();

            int totalPrice = 0;
            for (CartVO item : cartList) {
                totalPrice += item.getAmountCount() * item.getPriceCount();
            }

            request.setAttribute("cartList", cartList);
            request.setAttribute("totalPrice", totalPrice);

            request.getRequestDispatcher("cart/selectAll.jsp").forward(request, response);
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
