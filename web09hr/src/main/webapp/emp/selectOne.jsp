<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>부서 정보 페이지</h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
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
  <tr>
    <td>${vo2.department_id}</td>
    <td>${vo2.department_name}</td>
    <td>${vo2.manager_id}</td>
    <td>${vo2.location_id}</td>
  </tr>
  </tbody>
</table>
<a href="d_update.do?department_id=${vo2.department_id}">부서수정</a>
<a href="d_delete.do?department_id=${vo2.department_id}">부서삭제</a>
</body>
</html>