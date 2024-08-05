<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Login" %></h1>
<br/>
<jsp:include page="/top_menu.jsp"/>
<form action="loginOK.do" method="post">
    <label for="id">아이디:</label>
    <input type="text" id="id" name="id" value="test01"><br>
    <label for="pw">비밀번호:</label>
    <input type="password" id="pw" name="pw" value="pw1234"><br>
    <input type="submit" value="로그인">
</form>
</body>
</html>