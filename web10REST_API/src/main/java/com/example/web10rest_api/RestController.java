package com.example.web10rest_api;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({"/text.do",
        "/json_object.do","/json_object2.do","/json_object3.do",
        "/json_array.do","/json_array2.do"})
public class RestController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        //크로스도메인 설정
        response.setHeader("Access-Control-Allow-Origin","*");

        if(sPath.equals("/text.do")){
            PrintWriter out = response.getWriter();
            //out.println("hello world안녕");
            out.append("hello world안녕");
            out.append("hello world안녕");
            out.append("hello world안녕");
        }else if(sPath.equals("/json_object.do")){
            //json object >>{"name":"kim","age":22}

            PrintWriter out = response.getWriter();
            //out.println("{\"name\":\"kim\",\"age\":22}");
            //out.println("{\"result\":\"OK\"}");
            //out.println("{\"result\":\"Not OK\"}");
            //out.println("{\"result\":1}");
            out.println("{\"arr\":[11,22,33],\"person\":{\"name\":\"kim\",\"age\":22}}");
        }else if(sPath.equals("/json_object2.do")){
            String name = "lee";
            int age = 33;

            TestVO vo = new TestVO();
            vo.setName(name);
            vo.setAge(age);

            //Gson사용하면 편리하다.
            String json_txt = new Gson().toJson(vo);
            System.out.println(json_txt);

            PrintWriter out = response.getWriter();
            //out.println("{\"name\":\""+vo.getName()+"\",\"age\":"+vo.getAge()+"}");
            out.println(json_txt);
        }else if(sPath.equals("/json_object3.do")){
            Map<String,String> map = new HashMap<>();
            map.put("result","OK");
            map.put("result","Not OK");
            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(map));
        }else if(sPath.equals("/json_array.do")){
            //json array >>
            // [11,22,33],
            // ["kim","lee","han"],
            // [{"name":"kim","age":22},{"name":"kim","age":22}]

            PrintWriter out = response.getWriter();
            //out.println("[11,22,33]");
            //out.println("[\"kim\",\"lee\",\"han\"]");
            out.println("[{\"name\":\"kim\",\"age\":22},{\"name\":\"kim\",\"age\":22}]");
        }else if(sPath.equals("/json_array2.do")){

            List<TestVO> list = new ArrayList<>();
            for (int i = 0; i <3; i++) {
                String name = "kim"+i;
                int age = 20+i;

                TestVO vo = new TestVO();
                vo.setName(name);
                vo.setAge(age);
                list.add(vo);
            }

            response.getWriter().println(new Gson().toJson(list));
        }
    }//end doGet.....

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doPost()...");
        doGet(request, response);
    }

    public void destroy() {
    }
}