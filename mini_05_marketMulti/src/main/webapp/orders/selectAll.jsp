<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>주문 목록</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h1>주문 목록</h1>
<jsp:include page="../top_menu.jsp"/>

<c:choose>
    <c:when test="${user_id != null}">
        <!-- 로그인한 사용자만 주문 목록을 볼 수 있도록 -->
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
                <!-- 로그인한 사용자의 주문만 필터링 -->
                <c:if test="${order.mnum == sessionScope.mnum}">
                    <tr>
                        <!-- 주문번호를 클릭하면 주문 상세 페이지로 이동 -->
                        <td><a href="orders_selectOne.do?num=${order.num}">${order.num}</a></td>
                        <td>${order.pnum}</td>
                        <td>${order.mnum}</td>
                        <td>${order.odate}</td>
                        <td>${order.address}</td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>

        <p><a href="orders_insert.do">주문 추가</a></p>
    </c:when>
    <c:otherwise>
        <!-- 로그인하지 않은 사용자는 주문 목록을 볼 수 없음을 알림 -->
        <p>로그인 후 주문 목록을 확인할 수 있습니다.</p>
    </c:otherwise>
</c:choose>

</body>
</html>
