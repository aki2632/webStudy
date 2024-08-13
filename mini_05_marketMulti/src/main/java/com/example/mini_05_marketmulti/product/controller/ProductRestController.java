package com.example.mini_05_marketmulti.product.controller;

import com.example.web07total.member.model.MemberDAO;
import com.example.web07total.member.model.MemberDAOimpl;
import com.example.web07total.member.model.MemberVO;
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

@WebServlet({"/m_idCheck.do", "/json_m_selectAll.do", "/json_m_selectOne.do"})
public class ProductRestController extends HttpServlet {

    MemberDAO dao = new MemberDAOimpl();

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath:" + sPath);
        
        if (sPath.equals("/m_idCheck.do")) {
            String id = request.getParameter("id");
            System.out.println(id);

            MemberVO vo = new MemberVO();
            vo.setId(id);

            MemberVO vo2 = dao.idCheck(vo);
            Map<String, String> map = new HashMap<>();
            if (vo2 == null) map.put("result", "OK");
            else map.put("result", "Not OK");
            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(map));
        } else if (sPath.equals("/json_m_selectAll.do")) {
            //회원목록 rest api 구현하기.

            List<MemberVO> list = dao.selectAll();

            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(list));
        } else if (sPath.equals("/json_m_selectOne.do")) {
            //회원정보 rest api 구현하기.
            String num = request.getParameter("num");

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));

            MemberVO vo2 = dao.selectOne(vo);

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