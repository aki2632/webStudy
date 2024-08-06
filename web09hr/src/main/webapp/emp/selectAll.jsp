<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "부서 목록 페이지" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<form action="e_searchList.do">
  <select name="searchKey">
    <option value="first_name">first_name</option>
    <option value="phone_number">phone_number</option>
    <option value="job_id">job_id</option>
  </select>
  <input type="text" name="searchWord" value="Do">
  <input type="submit" value="검색">
</form>
<table border="1">
  <thead>
  <tr>
    <th>employee_id</th>
    <th>first_name</th>
    <th>last_name</th>
    <th>email</th>
    <th>phone_number</th>
    <th>hire_date</th>
    <th>job_id</th>
    <th>salary</th>
    <th>commission_pct</th>
    <th>manager_id</th>
    <th>department_id</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="vo" items="${list}">
    <tr>
      <td><a href="e_selectOne.do?employee_id=${vo.employee_id}">${vo.employee_id}</a></td>
      <td><a href="e_selectOne.do?employee_id=${vo.employee_id}">${vo.first_name}</a></td>
      <td>${vo.last_name}</td>
      <td>${vo.email}</td>
      <td>${vo.phone_number}</td>
      <td>${vo.hire_date}</td>
      <td>${vo.job_id}</td>
      <td>${vo.salary}</td>
      <td>${vo.commission_pct}</td>
      <td>${vo.manager_id}</td>
      <td>${vo.department_id}</td>
    </tr>
  </c:forEach>

  </tbody>
  <tfoot>
  <tr>
    <td colspan="11">1 2 3 4</td>
  </tr>
  </tfoot>
</table>
</body>
</html>