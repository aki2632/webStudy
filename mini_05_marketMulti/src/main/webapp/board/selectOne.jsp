<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h1><%= "공지사항 상세 페이지" %></h1>
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
<c:if test="${user_id == 'admin'}">
  <a href="b_update.do?num=${vo2.num}">공지사항 수정</a>
  <a href="b_delete.do?num=${vo2.num}">공지사항 삭제</a>
</c:if>
<hr>
<c:if test="${user_id == 'admin'}">
  <form action="c_insertOK.do">
    <input type="hidden" id="bnum" name="bnum" value="${vo2.num}">
    <input type="text" id="content" name="content" value="comment1">
      ${user_id}
    <input type="hidden" id="writer" name="writer" value="${user_id}">
    <input type="submit" value="댓글입력">
  </form>
</c:if>
<hr>

<table border="1">
<c:forEach var="cvo" items="${clist}">
  <tr>
    <td>${cvo.num}</td>
    <td>${cvo.content}</td>
    <td>${cvo.writer}</td>
    <td>${cvo.wdate}</td>
    <td>
      <c:if test="${cvo.writer == user_id}">
        <a href="c_deleteOK.do?num=${cvo.num}&bnum=${vo2.num}">댓글삭제</a>
      </c:if>
    </td>
  </tr>
</c:forEach>
</table>
</body>
</html>