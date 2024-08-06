<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "부서 삭제 페이지" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<form action="d_deleteOK.do" method="post">
  <table border="1">
    <tbody>
    <tr>
      <th>${param.department_id} 번 부서를 정말 삭제하시겠습니까?</th>
      <td><input type="hidden" name="department_id" value="${param.department_id}"></td>
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