<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>게시글 제출 결과</title>
</head>
<body>
<h1>게시글 제출 결과</h1>
<br/>
<jsp:include page="../../top_menu.jsp"/>

<div class="result-container">
  <p>제목: <%= request.getParameter("title") %></p>
  <p>내용: <%= request.getParameter("content") %></p>
  <p>작성자: <%= request.getParameter("author") %></p>
</div>
</body>
</html>
