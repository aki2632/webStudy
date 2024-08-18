<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h1><%= "공지사항 삭제 페이지" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<form action="b_deleteOK.do" method="post">
  <table border="1">
    <tbody>
    <tr>
      <th>${param.num} 번글을 정말삭제하시겠습니까?</th>
      <td><input type="hidden" name="num" value="${param.num}"></td>
    </tr>
    </tbody>
    <tfoot>
    <tr>
      <td colspan="6">
        <input type="submit" value="삭제완료">
      </td>
    </tr>
    </tfoot>
  </table>
</form>
</body>
</html>