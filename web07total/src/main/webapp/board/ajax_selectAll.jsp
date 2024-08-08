<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script>
    $(function(){
      console.log("ready....");

      let url2 = "http://localhost:8090/web07total_war_exploded/json_b_selectAll.do";
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
                      <td><a href="ajax_b_selectOne.do?num=\${response[i].num}">\${response[i].num}</a></td>
                      <td>\${response[i].title}</td>
                      <td>\${response[i].writer}</td>
                      <td>\${response[i].wdate}</td>
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
<h1><%= "게시글 목록 페이지" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<form action="b_searchList.do">
  <select name="searchKey">
    <option value="title">title</option>
    <option value="content">content</option>
  </select>
  <input type="text" name="searchWord" value="java">
  <input type="submit" value="검색">
</form>
<table border="1">
  <thead>
    <tr>
      <th>글번호</th>
      <th>글제목</th>
      <th>작성자</th>
      <th>작성일자</th>
    </tr>
  </thead>
  <tbody id="result">
  </tbody>
  <tfoot>
    <tr>
      <td colspan="4">1 2 3 4</td>
    </tr>
  </tfoot>
</table>
</body>
</html>