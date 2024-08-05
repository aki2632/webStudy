<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "HOME" %></h1>
<br/>
<jsp:include page="top_menu.jsp"/>
<h1>${user_id}</h1>
<h1>${name}</h1>
</body>
</html>