package com.example.mini_05_marketmulti.product.controller;

import com.example.mini_05_marketmulti.product.model.ProductDAO;
import com.example.mini_05_marketmulti.product.model.ProductDAOimpl;
import com.example.mini_05_marketmulti.product.model.ProductVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({"/p_insert.do", "/p_update.do", "/p_delete.do",
        "/p_selectOne.do", "/p_selectAll.do", "/ajax_p_selectAll.do", "/ajax_p_selectOne.do", "/p_searchList.do",
        "/p_insertOK.do", "/p_updateOK.do", "/p_deleteOK.do"})
public class ProductController extends HttpServlet {

    ProductDAO dao = new ProductDAOimpl();

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath:" + sPath);

        // 분기 처리
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

            String num = request.getParameter("num");
            System.out.println(num);

            ProductVO vo = new ProductVO();
            vo.setNum(Integer.parseInt(num));

            ProductVO vo2 = dao.selectOne(vo);

            request.setAttribute("vo2", vo2);

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
        } else if (sPath.equals("/p_insertOK.do")) {
            String pname = request.getParameter("pname");
            String model = request.getParameter("model");
            int price = Integer.parseInt(request.getParameter("price"));
            int count = Integer.parseInt(request.getParameter("count"));
            String user_id = request.getParameter("user_id");

            ProductVO vo = new ProductVO();
            vo.setPname(pname);
            vo.setModel(model);
            vo.setPrice(price);
            vo.setCount(count);
            vo.setUser_id(user_id);

            int result = dao.insert(vo);
            if (result == 1) {
                System.out.println("insert successed...");
                response.sendRedirect("p_selectAll.do");
            } else {
                System.out.println("insert failed...");
                response.sendRedirect("p_insert.do");
            }

        } else if (sPath.equals("/p_updateOK.do")) {
            String num = request.getParameter("num");
            String pname = request.getParameter("pname");
            String model = request.getParameter("model");
            int price = Integer.parseInt(request.getParameter("price"));
            int count = Integer.parseInt(request.getParameter("count"));
            String user_id = request.getParameter("user_id");

            ProductVO vo = new ProductVO();
            vo.setNum(Integer.parseInt(num));
            vo.setPname(pname);
            vo.setModel(model);
            vo.setPrice(price);
            vo.setCount(count);
            vo.setUser_id(user_id);

            int result = dao.update(vo);
            if (result == 1) {
                System.out.println("update successed...");
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
                response.sendRedirect("p_selectAll.do");
            } else {
                System.out.println("delete failed...");
                response.sendRedirect("p_delete.do?num=" + num);
            }
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }

    public void destroy() {
    }
}