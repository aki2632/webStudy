<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="home.do">HOME</a>
<a href="m_insert.do">회원가입</a>
<c:if test="${user_id!=null}">
    <a href="m_selectAll.do">회원목록</a>
</c:if>
<c:if test="${user_id!=null}">
    <a href="b_insert.do">게시글 작성</a>
    <a href="p_insert.do">상품등록</a>
    <a href="cart_selectAll.do">장바구니</a>
    <a href="orders_selectAll.do">주문내역</a>
</c:if>
<a href="b_selectAll.do">게시글 목록</a>
<a href="p_selectAll.do">상품 목록</a> <!-- 상품 목록 추가 -->
<c:if test="${user_id==null}"><a href="login.do">login</a></c:if>
<c:if test="${user_id!=null}"><a href="logout.do">logout</a></c:if>
${user_id}
