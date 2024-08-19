package com.example.mini_05_marketmulti.product.controller;


import com.example.mini_05_marketmulti.product.model.ProductDAO;
import com.example.mini_05_marketmulti.product.model.ProductDAOimpl;
import com.example.mini_05_marketmulti.product.model.ProductVO;
import com.example.mini_05_marketmulti.review.model.ReviewDAO;
import com.example.mini_05_marketmulti.review.model.ReviewDAOimpl;
import com.example.mini_05_marketmulti.review.model.ReviewVO;
import com.example.mini_05_marketmulti.cart.model.CartVO; // CartVO 클래스 import
import com.example.mini_05_marketmulti.cart.model.CartDAO; // CartDAO 인터페이스 import
import com.example.mini_05_marketmulti.cart.model.CartDAOimpl; // CartDAOimpl 클래스 import
import com.example.mini_05_marketmulti.wish.model.WishDAO;
import com.example.mini_05_marketmulti.wish.model.WishDAOimpl;
import com.example.mini_05_marketmulti.wish.model.WishVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.annotation.MultipartConfig;

@MultipartConfig
@WebServlet({"/p_insert.do","/p_update.do","/p_delete.do",
        "/p_selectOne.do","/p_selectAll.do","/ajax_p_selectAll.do","/ajax_p_selectOne.do","/p_searchList.do",
        "/p_insertOK.do","/p_updateOK.do","/p_deleteOK.do"})
public class ProductController extends HttpServlet {
    ProductDAO dao = new ProductDAOimpl();
    ReviewDAO rdao = new ReviewDAOimpl();


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath:" + sPath);

        // 분기 처리
        // product 폴더를 만드시고 관련 jsp 파일을 이동시킨 후 경로 변경해주세요
        if (sPath.equals("/p_insert.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("product/insert.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/p_update.do")) {

            String num = request.getParameter("num");
            System.out.println(num);

            ProductVO vo = new ProductVO();
            vo.setNum(Integer.parseInt(num));

            ProductVO vo2 = dao.selectOne(vo);

            request.setAttribute("vo2", vo2);

            RequestDispatcher rd = request.getRequestDispatcher("product/update.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/p_delete.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("product/delete.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/p_selectOne.do")) {
            int num = Integer.parseInt(request.getParameter("num"));
            System.out.println(num);

            ProductVO vo = new ProductVO();
            vo.setNum(num);

            ProductVO vo2 = dao.selectOne(vo);

            request.setAttribute("vo2", vo2);

            List<ReviewVO> rlist = rdao.selectAll(num);
            request.setAttribute("rlist", rlist);

            // "카트에 담기" 버튼 클릭 시 카트에 상품을 추가하는 로직
            String action = request.getParameter("action");
            if ("addToCart".equals(action)) {
                int mnum = Integer.parseInt(request.getParameter("mnum"));
                int amountCount = 1;  // 기본 수량 1로 설정
                int priceCount = vo2.getPrice();  // 상품 가격

                CartVO cartVo = new CartVO();
                cartVo.setPnum(vo2.getNum());
                cartVo.setMnum(mnum);
                cartVo.setAmountCount(amountCount);
                cartVo.setPriceCount(priceCount);

                CartDAO cartDao = new CartDAOimpl();
                cartDao.insert(cartVo);

                // 카트 목록 페이지로 리다이렉트
                response.sendRedirect("cart_selectAll.do");
                return;
            }

            // "위시리스트에 담기" 버튼 클릭 시 위시리스트에 상품을 추가하는 로직
            if ("addToWish".equals(action)) {
                int mnum = Integer.parseInt(request.getParameter("mnum"));

                WishVO wishVo = new WishVO();
                wishVo.setPnum(vo2.getNum());
                wishVo.setMnum(mnum);

                WishDAO wishDao = new WishDAOimpl();
                wishDao.insert(wishVo);

                // 위시리스트 목록 페이지로 리다이렉트
                response.sendRedirect("wish_selectAll.do");
                return;
            }

            RequestDispatcher rd = request.getRequestDispatcher("product/selectOne.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/ajax_p_selectOne.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("product/ajax_selectOne.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/p_selectAll.do")) {

            List<ProductVO> list = dao.selectAll();

            request.setAttribute("list", list);

            RequestDispatcher rd = request.getRequestDispatcher("product/selectAll.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/ajax_p_selectAll.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("product/ajax_selectAll.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/p_searchList.do")) {

            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<ProductVO> list = dao.searchList(searchKey, searchWord);

            request.setAttribute("list", list);

            RequestDispatcher rd = request.getRequestDispatcher("product/selectAll.jsp");
            rd.forward(request, response);
        }else if (sPath.equals("/p_insertOK.do")) {
            String pname = request.getParameter("pname");
            String content = request.getParameter("content");
            String price = request.getParameter("price");
            String company = request.getParameter("company");

            System.out.println(pname);
            System.out.println(content);
            System.out.println(price);
            System.out.println(company);

            // 이미지 파일 처리
            Part filePart = request.getPart("img");
            String imgPath = null;
            if (filePart != null && filePart.getSize() > 0) {
                String fileName = filePart.getSubmittedFileName();
                String uploadPath = getServletContext().getRealPath("/") + "upload/";
                java.io.File fileSaveDir = new java.io.File(uploadPath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }
                filePart.write(uploadPath + fileName);
                imgPath = "upload/" + fileName;
            }

            ProductVO vo = new ProductVO();
            vo.setPname(pname);
            vo.setContent(content);
            vo.setPrice(Integer.parseInt(price));
            vo.setCompany(company);
            vo.setImg(imgPath);

            int result = dao.insert(vo);
            if (result == 1) {
                System.out.println("insert succeeded...");
                response.sendRedirect("p_selectAll.do");
            } else {
                System.out.println("insert failed...");
                response.sendRedirect("p_insert.do");
            }

        } else if (sPath.equals("/p_updateOK.do")) {
            String num = request.getParameter("num");
            String pname = request.getParameter("pname");
            String content = request.getParameter("content");
            String price = request.getParameter("price");
            String company = request.getParameter("company");

            System.out.println(pname);
            System.out.println(content);
            System.out.println(price);
            System.out.println(company);

            // 이미지 파일 처리
            Part filePart = request.getPart("img");
            String imgPath = null;
            if (filePart != null && filePart.getSize() > 0) {
                String fileName = filePart.getSubmittedFileName();
                String uploadPath = getServletContext().getRealPath("/") + "upload/";
                java.io.File fileSaveDir = new java.io.File(uploadPath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }
                filePart.write(uploadPath + fileName);
                imgPath = "upload/" + fileName;
            }

            ProductVO vo = new ProductVO();
            vo.setNum(Integer.parseInt(num));
            vo.setPname(pname);
            vo.setContent(content);
            vo.setPrice(Integer.parseInt(price));
            vo.setCompany(company);
            vo.setImg(imgPath);

            int result = dao.update(vo);
            if (result == 1) {
                System.out.println("update succeeded...");
                response.sendRedirect("p_selectOne.do?num=" + num);
            } else {
                System.out.println("update failed...");
                response.sendRedirect("p_update.do?num=" + num);
            }
        } else if (sPath.equals("/p_deleteOK.do")) {
            String num = request.getParameter("num");
            System.out.println(num);

            ProductVO vo = new ProductVO();
            vo.setNum(Integer.parseInt(num));

            int result = dao.delete(vo);
            if (result == 1) {
                System.out.println("delete successed...");
                response.sendRedirect("p_selectAll.do"); // 서블릿 패스
            } else {
                System.out.println("delete failed...");
                response.sendRedirect("p_delete.do?num=" + num); // 서블릿 패스
            }
        }
    } // end doGet()....

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }


    public void destroy() {
    }
}
