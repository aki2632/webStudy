<%@ page import="java.util.List" %>
<%@ page import="com.example.web04member.MemberVO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "회원 목록 페이지" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<form action="m_searchList.do">
  <select name="searchKey">
    <option value="id">id</option>
    <option value="name">name</option>
  </select>
  <input type="text" name="searchWord" value="ad">
  <input type="submit" value="검색">
</form>
<table border="1">
  <thead>
  <tr>
    <th>NUM</th>
    <th>ID</th>
    <th>PW</th>
    <th>NAME</th>
    <th>TEL</th>
  </tr>
  </thead>
  <tbody>
  <%  //스크립스릿 태그- 자바코딩영역
    List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
    for (int i = 0; i < list.size(); i++) {
  %>
  <tr>
    <td><a href="m_selectOne.do?num=<%= list.get(i).getNum()%>"><%= list.get(i).getNum()%></a></td>
    <td><a href="m_selectOne.do?num=<%= list.get(i).getNum()%>"><%= list.get(i).getId()%></a></td>
    <td><%= list.get(i).getPw()%></td>
    <td><%= list.get(i).getName()%></td>
    <td><%= list.get(i).getTel()%></td>
  </tr>
  <%
    }
  %>

  </tbody>
  <tfoot>
  <tr>
    <td colspan="5">1 2 3 4</td>
  </tr>
  </tfoot>
</table>
</body>
</html>