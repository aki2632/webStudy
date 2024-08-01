<%@ page import="com.example.web03board.BoardVO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "게시글 목록 페이지" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<form action="b_searchList.do">
  <select name="searchKey">
    <option value="title">title</option>
    <option value="content">content</option>
  </select>
  <input type="text" name="searchWord" value="java">
  <input type="submit" value="검색">
</form>
<table border="1">
  <thead>
    <tr>
      <th>글번호</th>
      <th>글제목</th>
      <th>작성자</th>
      <th>작성일자</th>
    </tr>
  </thead>
  <tbody>
  <%  //스크립스릿 태그- 자바코딩영역
    List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
    for (int i = 0; i < list.size(); i++) {
  %>
    <tr>
      <td><a href="b_selectOne.do?num=<%= list.get(i).getNum()%>"><%= list.get(i).getNum()%></a></td>
      <td><a href="b_selectOne.do?num=<%= list.get(i).getNum()%>"><%= list.get(i).getTitle()%></a></td>
      <td><%= list.get(i).getWriter()%></td>
      <td><%= list.get(i).getWdate()%></td>
    </tr>
  <%
    }
  %>

  </tbody>
  <tfoot>
    <tr>
      <td colspan="4">1 2 3 4</td>
    </tr>
  </tfoot>
</table>
</body>
</html>