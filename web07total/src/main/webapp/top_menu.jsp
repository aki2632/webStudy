<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="home.do">HOME</a>
<c:choose>
    <c:when test="${not empty sessionScope.user_id}">
        <a href="m_logout.do">logout</a>
        <a href="m_selectAll.do">회원목록</a>
        <a href="b_insert.do">게시글 작성</a>
    </c:when>
    <c:otherwise>
        <a href="m_login.do">login</a>
        <a href="m_insert.do">회원가입</a>
    </c:otherwise>
</c:choose>
<a href="b_selectAll.do">게시글 목록</a>