<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>카트 목록</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h1>카트 목록</h1>
<jsp:include page="../top_menu.jsp"/>

<c:choose>
    <c:when test="${user_id != null}">
        <!-- 로그인한 사용자만 카트 목록을 볼 수 있도록 -->
        <table border="1">
            <thead>
            <tr>
                <th>상품번호</th> <!-- 상품번호 표시 -->
                <th>가격</th>
                <th>합계</th>
                <th>수량</th> <!-- 수량 수정 열 추가 -->
                <th>삭제</th> <!-- 삭제 열 추가 -->
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cartItem" items="${cartList}">
                <!-- 로그인한 사용자의 카트 항목만 필터링 -->
                <c:if test="${cartItem.mnum == sessionScope.mnum}">
                    <tr>
                        <td>
                            <a href="p_selectOne.do?num=${cartItem.pnum}">${cartItem.pnum}</a> <!-- 상품번호를 클릭하면 상품 상세 페이지로 이동 -->
                        </td>
                        <td>${cartItem.priceCount}</td>
                        <td>${cartItem.amountCount * cartItem.priceCount}</td>
                        <td>
                            <!-- 수량 수정 폼 추가 -->
                            <form action="cart_updateOK.do" method="post" style="display:inline;">
                                <input type="hidden" name="num" value="${cartItem.num}"/>
                                <input type="hidden" name="pnum" value="${cartItem.pnum}"/>
                                <input type="number" name="amountCount" value="${cartItem.amountCount}" min="1" style="width:50px;"/>
                                <input type="hidden" name="priceCount" value="${cartItem.priceCount}"/>
                                <button type="submit">수량 수정</button>
                            </form>
                        </td>
                        <td>
                            <!-- 삭제 버튼 추가 -->
                            <form action="cart_deleteOK.do" method="post" style="display:inline;">
                                <input type="hidden" name="num" value="${cartItem.num}"/>
                                <button type="submit">삭제</button>
                            </form>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>

        <!-- 합계 -->
        <p>총 합계: <c:out value="${totalPrice}"/></p>

        <a href="orders_insert.do">구매하기</a>
    </c:when>
    <c:otherwise>
        <!-- 로그인하지 않은 사용자는 카트 목록을 볼 수 없음을 알림 -->
        <p>로그인 후 카트 목록을 확인할 수 있습니다.</p>
    </c:otherwise>
</c:choose>

</body>
</html>
