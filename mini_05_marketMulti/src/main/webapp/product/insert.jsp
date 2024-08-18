<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>상품 등록 페이지</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>

<body>
<jsp:include page="../top_menu.jsp"/>
<div>
  <h1><%= "상품 등록 페이지"%></h1>
  <form action="p_insertOK.do" method="post">
    <table id="insertTable">
      <tr>
        <td><label for="pname">상품명</label></td>
        <td><input type="text" id="pname" name="pname" value="" placeholder="상품명을 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="content">내용</label></td>
        <td><input type="text" id="content" name="content" value="" placeholder="내용을 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="price">가격</label></td>
        <td><input type="text" id="price" name="price" value="" placeholder="가격을 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="company">회사</label></td>
        <td><input type="text" id="company" name="company" value="" placeholder="회사를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="img">이미지</label></td>
        <td><input type="text" id="img" name="img" value="" placeholder="이미지 URL을 입력하세요"></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="상품 등록 완료"></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>

