package com.example.mini_05_marketmulti.orders.controller;

import com.example.mini_05_marketmulti.cart.model.CartDAO;
import com.example.mini_05_marketmulti.cart.model.CartDAOimpl;
import com.example.mini_05_marketmulti.cart.model.CartVO;
import com.example.mini_05_marketmulti.orders.model.OrdersDAO;
import com.example.mini_05_marketmulti.orders.model.OrdersDAOimpl;
import com.example.mini_05_marketmulti.orders.model.OrdersVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet({"/orders_insertOK.do", "/orders_deleteOK.do", "/orders_selectOne.do", "/orders_selectAll.do", "/orders_insert.do"})
public class OrdersController extends HttpServlet {

    OrdersDAO odao = new OrdersDAOimpl();
    CartDAO cdao = new CartDAOimpl();  // CartDAO 추가

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath: " + sPath);

        if (sPath.equals("/orders_insert.do")) {
            // 결제 화면으로 이동
            HttpSession session = request.getSession();
            Integer mnum = (Integer) session.getAttribute("mnum"); // 사용자 번호 가져오기

            if (mnum == null) {
                response.sendRedirect("login.do");
                return;
            }

            // 카트에서 상품 목록 조회
            List<CartVO> cartList = cdao.selectByMember(mnum); // 회원에 따라 상품 리스트 조회
            int totalPrice = 0;
            for (CartVO item : cartList) {
                totalPrice += item.getAmountCount() * item.getPriceCount();
            }

            request.setAttribute("cartList", cartList);
            request.setAttribute("totalPrice", totalPrice);

            request.getRequestDispatcher("orders/orders_insert.jsp").forward(request, response);
        } else if (sPath.equals("/orders_insertOK.do")) {
            // 주문 생성 로직
            String pnum = request.getParameter("pnum");
            String mnum = request.getParameter("mnum");
            String address = request.getParameter("address");
            Date odate = Date.valueOf(request.getParameter("odate"));  // yyyy-mm-dd 형식

            OrdersVO vo = new OrdersVO();
            vo.setPnum(Integer.parseInt(pnum));
            vo.setMnum(Integer.parseInt(mnum));
            vo.setOdate(odate);
            vo.setAddress(address);

            int result = odao.insert(vo);
            System.out.println("Insert result: " + result);

            response.sendRedirect("orders_selectAll.do");

        } else if (sPath.equals("/orders_deleteOK.do")) {
            // 주문 삭제 로직
            String num = request.getParameter("num");

            OrdersVO vo = new OrdersVO();
            vo.setNum(Integer.parseInt(num));

            int result = odao.delete(vo);
            System.out.println("Delete result: " + result);

            response.sendRedirect("orders_selectAll.do");

        } else if (sPath.equals("/orders_selectOne.do")) {
            // 특정 주문 조회 로직
            String num = request.getParameter("num");

            OrdersVO vo = new OrdersVO();
            vo.setNum(Integer.parseInt(num));

            OrdersVO resultVO = odao.selectOne(vo);
            request.setAttribute("order", resultVO);

            request.getRequestDispatcher("orders/selectOne.jsp").forward(request, response);

        } else if (sPath.equals("/orders_selectAll.do")) {
            // 모든 주문 조회 로직
            List<OrdersVO> orderList = odao.selectAll();
            request.setAttribute("orderList", orderList); // 속성 이름을 orderList로 설정

            request.getRequestDispatcher("orders/selectAll.jsp").forward(request, response);
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