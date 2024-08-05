<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="home.do">HOME</a>
<c:choose>
    <c:when test="${not empty sessionScope.user_id}">
        <a href="logout.do">logout</a>
    </c:when>
    <c:otherwise>
        <a href="login.do">login</a>
    </c:otherwise>
</c:choose>