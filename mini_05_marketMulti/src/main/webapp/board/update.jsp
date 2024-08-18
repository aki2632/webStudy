<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<jsp:include page="../top_menu.jsp"/>
<div>
  <h1><%= "공지사항 수정 페이지" %></h1>
  <form action="b_updateOK.do" method="post">
    <table id="insertTable">
      <tr>
        <td><label for="num">글번호</label></td>
        <td>${param.num}<input type="hidden" id="num" name="num" value="${param.num}" ></td>
      </tr>
      <tr>
        <td><label for="title">제목</label></td>
        <td><input type="text" id="title" name="title" value="${vo2.title}" placeholder="제목을 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="content">내용</label></td>
        <td><textarea name="content" id="content" cols="30" rows="10">${vo2.content}</textarea></td>
      </tr>
      <tr>
        <td><label for="writer">작성자</label></td>
        <td>admin1<input type="hidden" id="writer" name="writer" value="${vo2.writer}"></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="수정완료"></td>
      </tr>
    </table>
  </form>
</div>

</body>
</html>