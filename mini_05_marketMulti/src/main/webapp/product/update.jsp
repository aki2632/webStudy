<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>상품 수정 페이지</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h1><%= "상품 수정 페이지" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<form action="p_updateOK.do" method="post" enctype="multipart/form-data">
  <div>
    <table id="updateTable">
      <tr>
        <td><label for="num">상품번호</label></td>
        <td><input type="text" id="num" name="num" value="${param.num}" readonly></td>
      </tr>
      <tr>
        <td><label for="pname">상품명</label></td>
        <td><input type="text" id="pname" name="pname" value="${param.pname}" placeholder="상품명을 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="content">내용</label></td>
        <td><input type="text" id="content" name="content" value="${param.content}" placeholder="내용을 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="price">가격</label></td>
        <td><input type="text" id="price" name="price" value="${param.price}" placeholder="가격을 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="company">회사</label></td>
        <td><input type="text" id="company" name="company" value="${param.company}" placeholder="회사를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="img">이미지</label></td>
        <td><input type="file" id="img" name="img" accept="image/*" placeholder="이미지 파일을 업로드하세요"></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="상품 수정 완료"></td>
      </tr>
    </table>
  </div>
</form>
</body>
</html>
