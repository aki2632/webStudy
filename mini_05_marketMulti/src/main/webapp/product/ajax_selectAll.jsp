<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>상품 목록</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script>
    $(function(){
      console.log("ready....");

      let url2 = "http://localhost:8090/mini_05_marketMulti_war_exploded/ajax_p_selectAll.do";
      $.ajax({
        url: url2,
        type: "get",
        data: {},
        dataType: "json",
        success: function(response){
          console.log(response);
          let tag = '';

          for (let i = 0; i < response.length; i++) {
            tag += `<tr>
                      <td><a href="ajax_p_selectOne.do?num=${response[i].num}">${response[i].num}</a></td>
                      <td>${response[i].pname}</td>
                      <td>${response[i].content}</td>
                      <td>${response[i].price}</td>
                      <td>${response[i].company}</td>
                      <td>${response[i].img}</td>
                  </tr>`;
          }

          $("#result").html(tag);
        },
        error: function(ex){
          console.log(ex);
        }
      });

    });

  </script>
</head>
<body>
<h1><%= "상품 목록 페이지" %></h1>
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
  <tbody id="result">
  </tbody>
  <tfoot>
  <tr>
    <td colspan="6">1 2 3 4</td>
  </tr>
  </tfoot>
</table>
</body>
</html>
