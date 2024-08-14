<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>상품 상세 페이지</title>
</head>
<body>
<h1>상품 상세 페이지</h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
${mnum}
<table border="1">
    <thead>
    <tr>
        <th>상품번호</th>
        <th>상품명</th>
        <th>내용</th>
        <th>가격</th>
        <th>회사</th>
        <th>이미지</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${vo2.num}</td>
        <td>${vo2.pname}</td>
        <td>${vo2.content}</td>
        <td>${vo2.price}</td>
        <td>${vo2.company}</td>
        <td><img src="${vo2.img}" alt="상품 이미지" width="100"></td>
    </tr>
    </tbody>
</table>

<!-- 카트에 담기 버튼 -->
<form action="cart_insertOK.do" method="get">
    <input type="hidden" name="pnum" value="${vo2.num}">
    <input type="hidden" name="mnum" value="${sessionScope.mnum}"> <!-- 세션에서 로그인된 사용자 번호 가져오기 -->
    <input type="hidden" name="amountCount" value="1"> <!-- 기본값 설정, 필요에 따라 수정 -->
    <input type="hidden" name="priceCount" value="${vo2.price}"> <!-- 상품 가격, 필요에 따라 수정 -->
    <input type="submit" value="카트에 담기">
</form>

<a href="p_update.do?num=${vo2.num}">상품수정</a>
<a href="p_delete.do?num=${vo2.num}">상품삭제</a>
<hr>
<form action="r_insertOK.do" method="get">
    <input type="hidden" id="pnum" name="pnum" value="${vo2.num}">
    <input type="text" id="content" name="content" value="review1">
    <input type="hidden" id="writer" name="writer" value="${sessionScope.user_id}"> <!-- 세션에서 사용자 ID 가져오기 -->
    <input type="text" id="img" name="img" value="default.jpg"> <!-- 이미지 URL 입력 -->
    <input type="number" id="rate" name="rate" min="1" max="5" value="5"> <!-- 평점 입력 -->
    <input type="submit" value="리뷰 입력">
</form>
<hr>

<table border="1">
    <c:forEach var="rvo" items="${rlist}">
        <tr>
            <td>${rvo.num}</td>
            <td>${rvo.content}</td>
            <td>${rvo.writer}</td>
            <td>${rvo.rdate}</td>
            <td><img src="${rvo.img}" alt="리뷰 이미지" width="100"></td>
            <td>${rvo.rate}</td> <!-- 평점 출력 -->
            <td>
                <c:if test="${rvo.writer == sessionScope.user_id}">
                    <a href="r_deleteOK.do?num=${rvo.num}&pnum=${vo2.num}">리뷰 삭제</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>