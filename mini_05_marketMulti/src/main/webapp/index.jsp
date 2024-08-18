<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h1><%= "HOME" %></h1>
<br/>
<jsp:include page="top_menu.jsp"/>
<h1>${user_id}</h1>
</body>
</html>