<%@ page import="com.example.web03board.BoardVO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "게시글 상세 페이지" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<table border="1">
  <thead>
  <tr>
    <th>글번호</th>
    <th>글제목</th>
    <th>글내용</th>
    <th>작성자</th>
    <th>작성일자</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td>${vo2.num}</td>
    <td>${vo2.title}</td>
    <td>${vo2.content}</td>
    <td>${vo2.writer}</td>
    <td>${vo2.wdate}</td>
  </tr>
  </tbody>
</table>
<a href="b_update.do?num=${vo2.num}">게시글수정</a>
<a href="b_delete.do?num=${vo2.num}">게시글삭제</a>
</body>
</html>