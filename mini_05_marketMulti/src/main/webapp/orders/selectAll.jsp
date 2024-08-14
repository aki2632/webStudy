<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>주문 목록</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>주문 목록</h1>
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
    <c:forEach var="order" items="${orderList}">
        <tr>
            <!-- 주문번호를 클릭하면 주문 상세 페이지로 이동 -->
            <td><a href="orders_selectOne.do?num=${order.num}">${order.num}</a></td>
            <td>${order.pnum}</td>
            <td>${order.mnum}</td>
            <td>${order.odate}</td>
            <td>${order.address}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p><a href="orders_insert.do">주문 추가</a></p>

</body>
</html>

