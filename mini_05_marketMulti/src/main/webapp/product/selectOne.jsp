<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>상품 상세 페이지</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
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
        <td><img src="${pageContext.request.contextPath}/${vo2.img}" alt="상품 이미지" width="100"></td>
    </tr>
    </tbody>
</table>

<c:if test="${sessionScope.user_id != null}">
    <!-- 카트에 담기 버튼 -->
    <form action="p_selectOne.do" method="get">
        <input type="hidden" name="num" value="${vo2.num}">
        <input type="hidden" name="mnum" value="${sessionScope.mnum}">
        <input type="hidden" name="action" value="addToCart">
        <input type="submit" value="카트에 담기">
    </form>

    <!-- 위시리스트에 담기 버튼 -->
    <form action="p_selectOne.do" method="get">
        <input type="hidden" name="num" value="${vo2.num}">
        <input type="hidden" name="mnum" value="${sessionScope.mnum}">
        <input type="hidden" name="action" value="addToWish">
        <input type="submit" value="위시리스트에 담기">
    </form>
</c:if>

<!-- 상품수정 및 삭제 버튼 -->
<c:if test="${sessionScope.user_id == 'admin'}">
    <a href="p_update.do?num=${vo2.num}">상품수정</a>
    <a href="p_delete.do?num=${vo2.num}">상품삭제</a>
</c:if>
<hr>

<!-- 리뷰 입력 폼 -->
<c:if test="${sessionScope.user_id != null}">
    <form action="r_insertOK.do" method="post" enctype="multipart/form-data">
        <input type="hidden" id="pnum" name="pnum" value="${vo2.num}">
        <input type="text" id="content" name="content" placeholder="리뷰 내용을 입력하세요" required>
        <input type="hidden" id="writer" name="writer" value="${sessionScope.user_id}">
        <input type="file" id="img" name="img" accept="image/*"> <!-- 이미지 파일 선택 사항으로 변경 -->
        <input type="number" id="rate" name="rate" min="1" max="5" value="5" required>
        <input type="submit" value="리뷰 입력">
    </form>
</c:if>
<hr>

<!-- 리뷰 목록 표시 -->
<table border="1">
    <c:forEach var="rvo" items="${rlist}">
        <tr>
            <td>${rvo.num}</td>
            <td>${rvo.content}</td>
            <td>${rvo.writer}</td>
            <td>${rvo.rdate}</td>
            <td><img src="${pageContext.request.contextPath}/${rvo.img}" alt="리뷰 이미지" width="100"></td>
            <td>${rvo.rate}</td>
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
