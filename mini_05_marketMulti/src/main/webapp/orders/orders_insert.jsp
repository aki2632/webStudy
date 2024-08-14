<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>결제 화면</title>
</head>
<body>
<h1>결제 화면</h1>
<jsp:include page="../top_menu.jsp"/>

<h2>카트 목록</h2>

<table border="1">
    <thead>
    <tr>
        <th>상품번호</th>
        <th>수량</th>
        <th>가격</th>
        <th>합계</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cartItem" items="${cartList}">
        <tr>
            <td>${cartItem.pnum}</td>
            <td>${cartItem.amountCount}</td>
            <td>${cartItem.priceCount}</td>
            <td>${cartItem.amountCount * cartItem.priceCount}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p>총 합계: <c:out value="${totalPrice}"/> 원</p>

<h2>결제 정보 입력</h2>
<form action="orders_insertOK.do" method="post">
    <!-- 상품 번호를 숨겨진 필드로 추가 -->
    <input type="hidden" name="pnum" value="${cartList[0].pnum}"/> <!-- 첫 번째 상품의 번호 사용 -->
    <input type="hidden" name="mnum" value="${sessionScope.mnum}"/> <!-- 세션에서 사용자 번호 가져오기 -->
    <input type="hidden" name="odate" value="<%= new java.sql.Date(System.currentTimeMillis()) %>"/> <!-- 현재 날짜 -->

    <label for="address">배송 주소:</label>
    <input type="text" id="address" name="address" value="${sessionScope.address}" required/><br/><br/>

    <button type="submit">주문하기</button>
</form>

</body>
</html>
