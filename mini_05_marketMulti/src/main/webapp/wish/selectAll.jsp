<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>위시리스트</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h1>위시리스트</h1>
<jsp:include page="../top_menu.jsp"/>

<c:choose>
    <c:when test="${user_id != null}">
        <!-- 로그인한 사용자만 위시리스트를 볼 수 있도록 -->
        <table border="1">
            <thead>
            <tr>
                <th>상품번호</th> <!-- 상품번호 표시 -->
                <th>삭제</th> <!-- 삭제 열 추가 -->
            </tr>
            </thead>
            <tbody>
            <c:forEach var="wishItem" items="${wishList}">
                <!-- 로그인한 사용자의 위시리스트만 필터링 -->
                <c:if test="${wishItem.mnum == sessionScope.mnum}">
                    <tr>
                        <td>
                            <a href="p_selectOne.do?num=${wishItem.pnum}">${wishItem.pnum}</a> <!-- 상품번호를 클릭하면 상품 상세 페이지로 이동 -->
                        </td>
                        <td>
                            <!-- 삭제 버튼 추가 -->
                            <form action="wish_deleteOK.do" method="post" style="display:inline;">
                                <input type="hidden" name="num" value="${wishItem.num}"/>
                                <button type="submit">삭제</button>
                            </form>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <!-- 로그인하지 않은 사용자는 위시리스트를 볼 수 없음을 알림 -->
        <p>로그인 후 위시리스트를 확인할 수 있습니다.</p>
    </c:otherwise>
</c:choose>
</body>
</html>


