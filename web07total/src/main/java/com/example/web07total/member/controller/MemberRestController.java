package com.example.web07total.member.controller;

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
import java.util.Map;

@WebServlet({"/m_idCheck.do"})
public class MemberRestController extends HttpServlet {

    MemberDAO dao = new MemberDAOimpl();

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);
        
        if(sPath.equals("/m_idCheck.do")){
            String id = request.getParameter("id");
            System.out.println(id);

            MemberVO vo = new MemberVO();
            vo.setId(id);

            MemberVO vo2 = dao.idCheck(vo);
            Map<String,String> map = new HashMap<>();
            if(vo2 == null)  map.put("result","OK");
            else  map.put("result","Not OK");
            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(map));
        }



    }//end doGet()....


    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request,response);
    }


    public void destroy() {
    }
}