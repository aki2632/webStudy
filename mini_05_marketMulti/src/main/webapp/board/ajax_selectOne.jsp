<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script>
    $(function(){
      console.log("ready....");

      console.log(${param.num});

      let url2 = "http://localhost:8090/web07total_war_exploded/json_b_selectOne.do";
      $.ajax({
        url:url2,
        type:"get",
        data:{num:${param.num}},
        dataType:"json",
        success:function(response){
          console.log(response);
          let tag = `<tr>
                      <td>\${response.num}</td>
                      <td>\${response.title}</td>
                      <td>\${response.content}</td>
                      <td>\${response.writer}</td>
                      <td>\${response.wdate}</td>
                  </tr>`;
          $("#result").html(tag);
        },
        error:function(ex){
          console.log(ex);
        }
      });

    });

  </script>
</head>
<body>
<h1><%= "게시글 상세 페이지" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<table border="1">
  <thead>
  <tr>
    <th>글번호</th>
    <th>글제목</th>
    <th>글내용</th>
    <th>작성자</th>
    <th>작성일자</th>
  </tr>
  </thead>
  <tbody id="result">
  </tbody>
</table>
<a href="b_update.do?num=${vo2.num}">게시글수정</a>
<a href="b_delete.do?num=${vo2.num}">게시글삭제</a>
<hr>
<form action="c_insertOK.do">
  <input type="hidden" id="bnum" name="bnum" value="${vo2.num}">
  <input type="text" id="content" name="content" value="comment1">
  ${user_id}
  <input type="hidden" id="writer" name="writer" value="${user_id}">
  <input type="submit" value="댓글입력">
</form>
<hr>

<table border="1">
<c:forEach var="cvo" items="${clist}">
  <tr>
    <td>${cvo.num}</td>
    <td>${cvo.content}</td>
    <td>${cvo.writer}</td>
    <td>${cvo.wdate}</td>
    <td>
      <c:if test="${cvo.writer == user_id}">
        <a href="c_deleteOK.do?num=${cvo.num}&bnum=${vo2.num}">댓글삭제</a>
      </c:if>
    </td>
  </tr>
</c:forEach>
</table>
</body>
</html>