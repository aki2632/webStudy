<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

  <script>
    $(function(){
      console.log("ready....");

      let url2 = "http://localhost:8090/mini_05_marketMulti_war_exploded/json_m_selectAll.do";
      $.ajax({
        url:url2,
        type:"get",
        data:{},
        dataType:"json",
        success:function(response){
          console.log(response);
          let tag = '';

          for (let i = 0; i < response.length; i++) {
            tag += `<tr>
                      <td><a href="ajax_m_selectOne.do?num=\${response[i].num}">\${response[i].num}</a></td>
                      <td>\${response[i].id}</td>
                      <td>\${response[i].pw}</td>
                      <td>\${response[i].name}</td>
                      <td>\${response[i].tel}</td>
                      <td>\${response[i].address}</td>
                  </tr>`;
          }

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
<h1><%= "회원 목록 페이지" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<form action="m_searchList.do">
  <select name="searchKey">
    <option value="id">id</option>
    <option value="name">name</option>
  </select>
  <input type="text" name="searchWord" value="ad">
  <input type="submit" value="검색">
</form>
<table border="1">
  <thead>
  <tr>
    <th>NUM</th>
    <th>ID</th>
    <th>PW</th>
    <th>NAME</th>
    <th>TEL</th>
    <th>ADDRESS</th>
  </tr>
  </thead>
  <tbody id="result">
  </tbody>
  <tfoot>
  <tr>
    <td colspan="5">1 2 3 4</td>
  </tr>
  </tfoot>
</table>
</body>
</html>