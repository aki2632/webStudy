<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="home.do">HOME</a>
<a href="login.do">login</a>
<form action="loginOK.do" method="post">
  ID:<input type="text" name="id" value="admin"><br>
  PW<input type="password" name="pw" value="hi1111"><br>
  <input type="submit" value="로그인">
</form>
</body>
</html>