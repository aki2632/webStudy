<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<jsp:include page="/top_menu.jsp"/>
<h1>세션정보</h1>
<h2>${user_id}</h2>
<h2>${name}</h2>
<hr>
<h1>쿠키정보</h1>
<h2>${cookie['message'].value}</h2>
<h2>${cookie['isChecked'].value}</h2>
</body>
</html>