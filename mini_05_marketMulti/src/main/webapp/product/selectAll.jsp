<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>상품 목록 페이지</title>
</head>
<body>
<h1><%= "상품 목록 페이지" %>
</h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<form action="p_searchList.do">
    <select name="searchKey">
        <option value="pname">상품명</option>
        <option value="company">회사</option>
    </select>
    <input type="text" name="searchWord" value="">
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
            <td>${vo.img}</td>
        </tr>
    </c:forEach>

    </tbody>
    <tfoot>
    <tr>
        <td colspan="6">1 2 3 4</td>
    </tr>
    </tfoot>
</table>
</body>
</html>
