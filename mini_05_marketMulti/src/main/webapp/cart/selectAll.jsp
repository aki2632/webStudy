<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>카트 목록</title>
</head>
<body>
<h1>카트 목록</h1>
<jsp:include page="../top_menu.jsp"/>

<table border="1">
    <thead>
    <tr>
        <th>상품번호</th> <!-- 상품명 대신 상품번호 표시 -->
        <th>수량</th>
        <th>가격</th>
        <th>합계</th>
        <th>삭제</th> <!-- 삭제 열 추가 -->
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cartItem" items="${cartList}">
        <tr>
            <td>
                <a href="p_selectOne.do?num=${cartItem.pnum}">${cartItem.pnum}</a> <!-- 상품번호를 클릭하면 상품 상세 페이지로 이동 -->
            </td>
            <td>${cartItem.amountCount}</td>
            <td>${cartItem.priceCount}</td>
            <td>${cartItem.amountCount * cartItem.priceCount}</td>
            <td>
                <!-- 삭제 버튼 추가 -->
                <form action="cart_deleteOK.do" method="post" style="display:inline;">
                    <input type="hidden" name="num" value="${cartItem.num}"/>
                    <button type="submit">삭제</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- 합계 -->
<p>총 합계: <c:out value="${totalPrice}"/></p>

<a href="orders_insert.do">구매하기</a>
</body>
</html>