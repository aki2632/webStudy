package com.example.mini_05_marketmulti.product.controller;

import com.example.mini_05_marketmulti.product.model.ProductDAO;
import com.example.mini_05_marketmulti.product.model.ProductDAOimpl;
import com.example.mini_05_marketmulti.product.model.ProductVO;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet({"/json_p_selectAll.do", "/json_p_selectOne.do"})
public class ProductRestController extends HttpServlet {

    ProductDAO dao = new ProductDAOimpl();

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath:" + sPath);
        
        if (sPath.equals("/json_p_selectAll.do")) {
            //회원목록 rest api 구현하기.

            List<ProductVO> list = dao.selectAll();

            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(list));
        } else if (sPath.equals("/json_p_selectOne.do")) {
            //회원정보 rest api 구현하기.
            String num = request.getParameter("num");

            ProductVO vo = new ProductVO();
            vo.setNum(Integer.parseInt(num));

            ProductVO vo2 = dao.selectOne(vo);

            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(vo2));
        }


    }//end doGet()....


    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }


    public void destroy() {
    }
}