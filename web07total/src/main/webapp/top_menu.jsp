<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="home.do">HOME</a>
<a href="m_insert.do">회원가입</a>
<c:if test="${user_id!=null}">
    <a href="m_selectAll.do">회원목록</a>
    <a href="ajax_m_selectAll.do">회원목록(비동기통신)</a>
</c:if>
<c:if test="${user_id!=null}"><a href="b_insert.do">게시글 작성</a></c:if>
<a href="b_selectAll.do">게시글 목록</a>
<c:if test="${user_id==null}"><a href="login.do">login</a></c:if>
<c:if test="${user_id!=null}"><a href="logout.do">logout</a></c:if>
${user_id}