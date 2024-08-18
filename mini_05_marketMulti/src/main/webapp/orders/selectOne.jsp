<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>주문 상세 정보</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h1>주문 상세 정보</h1>
<jsp:include page="../top_menu.jsp"/>

<table>
    <thead>
    <tr>
        <th>주문번호</th>
        <th>상품번호</th>
        <th>회원번호</th>
        <th>주문일자</th>
        <th>배송 주소</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${order.num}</td>
        <td>${order.pnum}</td>
        <td>${order.mnum}</td>
        <td>${order.odate}</td>
        <td>${order.address}</td>
    </tr>
    </tbody>
</table>

<form action="orders_deleteOK.do" method="post">
    <input type="hidden" name="num" value="${order.num}"/>
    <button type="submit">주문 삭제</button>
</form>

<p><a href="orders_selectAll.do">주문 목록으로 돌아가기</a></p>

</body>
</html>
