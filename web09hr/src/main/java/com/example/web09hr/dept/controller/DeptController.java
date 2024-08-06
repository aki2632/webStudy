package com.example.web09hr.dept.controller;

import com.example.web09hr.dept.model.DeptDAO;
import com.example.web09hr.dept.model.DeptDAOimpl;
import com.example.web09hr.dept.model.DeptVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({"/d_insert.do","/d_insertOK.do","/d_update.do","/d_updateOK.do",
        "/d_delete.do","/d_deleteOK.do","/d_selectOne.do","/d_selectAll.do",
        "/d_searchList.do"})
public class DeptController extends HttpServlet {

    DeptDAO dao = new DeptDAOimpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String sPath = request.getServletPath();

        System.out.println("sPath:"+sPath);

        if(sPath.equals("/d_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("dept/insert.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/d_insertOK.do")){

            String department_name = request.getParameter("department_name");
            int manager_id = Integer.parseInt(request.getParameter("manager_id"));
            int location_id = Integer.parseInt(request.getParameter("location_id"));
            System.out.println(department_name);
            System.out.println(manager_id);
            System.out.println(location_id);


            DeptVO vo = new DeptVO();
            vo.setDepartment_name(department_name);
            vo.setManager_id(manager_id);
            vo.setLocation_id(location_id);

            int result = dao.insert(vo);
            System.out.println("result:"+result);
            if(result==1){
                System.out.println("insert successed");
                response.sendRedirect("d_selectAll.do");
            }else{
                System.out.println("insert failed");
                response.sendRedirect("d_insert.do");
            }

        }else if(sPath.equals("/d_selectAll.do")){

            List<DeptVO> list = dao.selectAll();

            request.setAttribute("list",list);

            RequestDispatcher rd = request.getRequestDispatcher("dept/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/d_searchList.do")){
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<DeptVO> list = dao.searchList(searchKey,searchWord);

            request.setAttribute("list",list);

            RequestDispatcher rd = request.getRequestDispatcher("dept/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/d_selectOne.do")){
            int department_id = Integer.parseInt(request.getParameter("department_id"));

            DeptVO vo = new DeptVO();
            vo.setDepartment_id(department_id);

            DeptVO vo2 = dao.selectOne(vo);
            System.out.println(vo2);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("dept/selectOne.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/d_update.do")){
            int department_id = Integer.parseInt(request.getParameter("department_id"));

            DeptVO vo = new DeptVO();
            vo.setDepartment_id(department_id);

            DeptVO vo2 = dao.selectOne(vo);
            System.out.println(vo2);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("dept/update.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/d_updateOK.do")){
            int department_id = Integer.parseInt(request.getParameter("department_id"));
            String department_name = request.getParameter("department_name");
            int manager_id = Integer.parseInt(request.getParameter("manager_id"));
            int location_id = Integer.parseInt(request.getParameter("location_id"));
            System.out.println(department_name);
            System.out.println(manager_id);
            System.out.println(location_id);


            DeptVO vo = new DeptVO();
            vo.setDepartment_id(department_id);
            vo.setDepartment_name(department_name);
            vo.setManager_id(manager_id);
            vo.setLocation_id(location_id);

            int result = dao.update(vo);
            System.out.println("result:"+result);
            if(result==1){
                System.out.println("update successed");
                response.sendRedirect("d_selectOne.do?department_id="+department_id);
            }else{
                System.out.println("update failed");
                response.sendRedirect("d_update.do?department_id="+department_id);
            }

        }else if(sPath.equals("/d_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("dept/delete.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/d_deleteOK.do")){
            int department_id = Integer.parseInt(request.getParameter("department_id"));
            System.out.println(department_id);


            DeptVO vo = new DeptVO();
            vo.setDepartment_id(department_id);

            int result = dao.delete(vo);
            System.out.println("result:"+result);
            if(result==1){
                System.out.println("delete successed");
                response.sendRedirect("d_selectAll.do");
            }else{
                System.out.println("delete failed");
                response.sendRedirect("d_delete.do?department_id="+department_id);
            }
        }

    }//end doGet()....

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request,response);
    }

    public void destroy() {
    }
}