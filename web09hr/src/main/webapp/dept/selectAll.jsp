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
<form action="d_searchList.do">
  <select name="searchKey">
    <option value="department_name">department_name</option>
    <option value="manager_id">manager_id</option>
  </select>
  <input type="text" name="searchWord" value="Sal">
  <input type="submit" value="검색">
</form>
<table border="1">
  <thead>
  <tr>
    <th>department_id</th>
    <th>department_name</th>
    <th>manager_id</th>
    <th>location_id</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="vo" items="${list}">
    <tr>
      <td><a href="d_selectOne.do?department_id=${vo.department_id}">${vo.department_id}</a></td>
      <td><a href="d_selectOne.do?department_id=${vo.department_id}">${vo.department_name}</a></td>
      <td>${vo.manager_id}</td>
      <td>${vo.location_id}</td>
    </tr>
  </c:forEach>

  </tbody>
  <tfoot>
  <tr>
    <td colspan="4">1 2 3 4</td>
  </tr>
  </tfoot>
</table>
</body>
</html>