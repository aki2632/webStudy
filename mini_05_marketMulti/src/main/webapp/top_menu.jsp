<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>탑다운 메뉴</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/top_menu_styles.css">
</head>
<body>
<header>
    <nav>
        <ul class="menu">
            <li><a href="home.do">HOME</a></li>
            <li><a href="b_selectAll.do">공지사항 목록</a></li>
            <li><a href="p_selectAll.do">상품 목록</a></li>
            <li><a href="cart_selectAll.do">장바구니</a></li>
            <li><a href="orders_selectAll.do">주문내역</a></li>
            <li><a href="wish_selectAll.do">찜목록</a></li>
            <c:if test="${user_id != null}">
                <c:if test="${user_id == 'admin'}">
                    <li><a href="m_selectAll.do">회원목록</a></li>
                    <li><a href="b_insert.do">공지사항 작성</a></li>
                    <li><a href="p_insert.do">상품등록</a></li>
                </c:if>
                <li><a href="logout.do">logout</a></li>
            </c:if>
            <c:if test="${user_id == null}">
                <li><a href="login.do">login</a></li>
                <li><a href="m_insert.do">회원가입</a></li>
            </c:if>
        </ul>
    </nav>
</header>
<main>
    <!-- 페이지 내용 -->
    ${user_id}
</main>
</body>
</html>
