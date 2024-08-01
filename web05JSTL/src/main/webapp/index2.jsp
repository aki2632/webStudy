<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>Hello World!</h1>
<br/>
<a href="index.jsp">index.do</a>
<hr>

<c:forEach var="i" begin="1" end="10">
  반복문
</c:forEach>
<hr>

<c:forEach var="i" begin="1" end="10">
  ${i}
</c:forEach>
<hr>

<c:forEach var="i" begin="1" end="10" step="2">
  ${i}
</c:forEach>
<hr>

<c:forEach var="i" begin="1" end="10">
  <c:if test="${i>5}">${i}</c:if>
</c:forEach>
<hr>

<c:set var="start" value="1"/>
<c:set var="stop" value="5"/>
<c:forEach var="i" begin="${start}" end="${stop}">
  <a href="b_selectAll.do?cpage=${i}">${i}</a>
</c:forEach>
<hr>

<c:set var="result" value="1"/>
<c:choose>
  <c:when test="${result==1}">Good</c:when>
  <c:when test="${result==2}">Hello</c:when>
  <c:when test="${result==3}">Bye</c:when>
  <c:otherwise>otherwise</c:otherwise>
</c:choose>
<hr>

</body>
</html>