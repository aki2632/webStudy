package com.example.mini_05_marketmulti.member.controller;

import com.example.mini_05_marketmulti.member.model.MemberDAO;
import com.example.mini_05_marketmulti.member.model.MemberDAOimpl;
import com.example.mini_05_marketmulti.member.model.MemberVO;

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
public class MemberRestController extends HttpServlet {

    MemberDAO dao = new MemberDAOimpl();

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath:" + sPath);
        
        if (sPath.equals("/m_idCheck.do")) {
            String member_id = request.getParameter("member_id");
            System.out.println(member_id);

            MemberVO vo = new MemberVO();
            vo.setMemberId(member_id);

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
            String member_num = request.getParameter("member_num");

            MemberVO vo = new MemberVO();
            vo.setMemberNum(Integer.parseInt(member_num));

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