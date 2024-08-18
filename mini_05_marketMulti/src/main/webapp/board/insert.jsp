<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>

<body>
<jsp:include page="../top_menu.jsp"/>
<div>
  <h1><%= "공지사항 작성 페이지"%></h1>
  <form action="b_insertOK.do" method="post">
    <table id="insertTable">
      <tr>
        <td><label for="title">제목</label></td>
        <td><input type="text" id="title" name="title" value="Serlvet...제목" placeholder="제목을 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="content">내용</label></td>
        <td><textarea name="content" id="content" cols="30" rows="10">Hello java내용</textarea></td>
      </tr>
      <tr>
        <td><label for="writer">작성자</label></td>
        <td>${user_id}<input type="hidden" id="writer" name="writer" value="${user_id}"></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="글쓰기 완료"></td>
      </tr>
    </table>
  </form>
</div>
</body>

</html>