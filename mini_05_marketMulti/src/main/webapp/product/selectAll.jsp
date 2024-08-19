<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>상품 목록 페이지</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h1>상품 목록 페이지</h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<form action="p_searchList.do" method="get">
    <select name="searchKey">
        <option value="pname" <c:if test="${param.searchKey == 'pname'}">selected</c:if>>상품명</option>
        <option value="company" <c:if test="${param.searchKey == 'company'}">selected</c:if>>회사</option>
    </select>
    <input type="text" name="searchWord" value="${param.searchWord}">
    <input type="submit" value="검색">
</form>
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
    <c:forEach var="vo" items="${list}">
        <tr>
            <td><a href="p_selectOne.do?num=${vo.num}">${vo.num}</a></td>
            <td><a href="p_selectOne.do?num=${vo.num}">${vo.pname}</a></td>
            <td>${vo.content}</td>
            <td>${vo.price}</td>
            <td>${vo.company}</td>
            <td><img src="${pageContext.request.contextPath}/${vo.img}" alt="상품 이미지" width="100"></td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="6">
            <c:forEach var="page" begin="1" end="${totalPages}">
                <a href="p_searchList.do?page=${page}&searchKey=${param.searchKey}&searchWord=${param.searchWord}">${page}</a>
            </c:forEach>
        </td>
    </tr>
    </tfoot>
</table>
</body>
</html>
