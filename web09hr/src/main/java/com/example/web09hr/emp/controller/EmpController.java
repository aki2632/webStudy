package com.example.web09hr.emp.controller;

import com.example.web09hr.emp.model.EmpDAO;
import com.example.web09hr.emp.model.EmpDAOimpl;
import com.example.web09hr.emp.model.EmpVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

@WebServlet({"/e_insert.do","/e_insertOK.do","/e_update.do","/e_updateOK.do",
        "/e_delete.do","/e_deleteOK.do","/e_selectOne.do","/e_selectAll.do",
        "/e_searchList.do"})
public class EmpController extends HttpServlet {

    EmpDAO dao = new EmpDAOimpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String sPath = request.getServletPath();

        System.out.println("sPath:"+sPath);

        if(sPath.equals("/e_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("emp/insert.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/e_insertOK.do")){


            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String email = request.getParameter("email");
            String phone_number = request.getParameter("phone_number");
            String str_hire_date = request.getParameter("hire_date");
            System.out.println(str_hire_date);
            String[] arr = str_hire_date.split("-");
            GregorianCalendar cal = new GregorianCalendar(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])-1,Integer.parseInt(arr[2]));
            System.out.println(new Date(cal.getTimeInMillis()));
            Date hire_date = new Date(cal.getTimeInMillis());
            String job_id = request.getParameter("job_id");
            System.out.println(first_name);
            System.out.println(last_name);
            System.out.println(email);
            System.out.println(phone_number);
            System.out.println(hire_date);
            System.out.println(job_id);

            int salary = Integer.parseInt(request.getParameter("salary"));
            double commission_pct = Double.parseDouble(request.getParameter("commission_pct"));
            int manager_id = Integer.parseInt(request.getParameter("manager_id"));
            int department_id = Integer.parseInt(request.getParameter("department_id"));

            System.out.println(salary);
            System.out.println(commission_pct);
            System.out.println(manager_id);
            System.out.println(department_id);

            EmpVO vo = new EmpVO();
            vo.setFirst_name(first_name);
            vo.setLast_name(last_name);
            vo.setEmail(email);
            vo.setPhone_number(phone_number);
            vo.setHire_date(hire_date);
            vo.setJob_id(job_id);
            vo.setSalary(salary);
            vo.setCommission_pct(commission_pct);
            vo.setManager_id(manager_id);
            vo.setDepartment_id(department_id);

            int result = dao.insert(vo);
            System.out.println("result:"+result);
            if(result==1){
                System.out.println("insert successed");
                response.sendRedirect("e_selectAll.do");
            }else{
                System.out.println("insert failed");
                response.sendRedirect("e_insert.do");
            }

        }else if(sPath.equals("/e_selectAll.do")){

            List<EmpVO> list = dao.selectAll();

            request.setAttribute("list",list);

            RequestDispatcher rd = request.getRequestDispatcher("emp/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/e_searchList.do")){
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<EmpVO> list = dao.searchList(searchKey,searchWord);

            request.setAttribute("list",list);

            RequestDispatcher rd = request.getRequestDispatcher("emp/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/e_selectOne.do")){
            int employee_id = Integer.parseInt(request.getParameter("employee_id"));

            EmpVO vo = new EmpVO();
            vo.setEmployee_id(employee_id);

            EmpVO vo2 = dao.selectOne(vo);
            System.out.println(vo2);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("emp/selectOne.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/e_update.do")){
            int employee_id = Integer.parseInt(request.getParameter("employee_id"));

            EmpVO vo = new EmpVO();
            vo.setEmployee_id(employee_id);

            EmpVO vo2 = dao.selectOne(vo);
            System.out.println(vo2);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("emp/update.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/e_updateOK.do")){
            int employee_id = Integer.parseInt(request.getParameter("employee_id"));
            int manager_id = Integer.parseInt(request.getParameter("manager_id"));
            System.out.println(employee_id);
            System.out.println(manager_id);


            EmpVO vo = new EmpVO();
            vo.setEmployee_id(employee_id);
            vo.setManager_id(manager_id);

            int result = dao.update(vo);
            System.out.println("result:"+result);
            if(result==1){
                System.out.println("update successed");
                response.sendRedirect("e_selectOne.do?employee_id="+employee_id);
            }else{
                System.out.println("update failed");
                response.sendRedirect("e_update.do?employee_id="+employee_id);
            }

        }else if(sPath.equals("/e_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("emp/delete.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/e_deleteOK.do")){
            int employee_id = Integer.parseInt(request.getParameter("employee_id"));
            System.out.println(employee_id);


            EmpVO vo = new EmpVO();
            vo.setEmployee_id(employee_id);

            int result = dao.delete(vo);
            System.out.println("result:"+result);
            if(result==1){
                System.out.println("delete successed");
                response.sendRedirect("e_selectAll.do");
            }else{
                System.out.println("delete failed");
                response.sendRedirect("e_delete.do?employee_id="+employee_id);
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