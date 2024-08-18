<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script>
    console.log("hello...");
    //http://localhost:8090/web10REST_API_war_exploded/json_object2.do
    window.onload = function(){
      console.log("onload.....");

      document.querySelector("#btn_idCheck").onclick = function(){
        console.log("btn_idCheck....");

        //2.제이쿼리 비동기통신 방법으로 구현하세요
        let url2 = "http://localhost:8090/mini_05_marketMulti_war_exploded/m_idCheck.do";
        $.ajax({
          url:url2,
          type:"get",
          data:{id:$("#id").val()},
          dataType:"json",
          success:function(response){
            console.log(response);
            let message = '';
            if(response.result === 'OK'){
              message = '사용가능';
            }else{
              message = '중복된 아이디';
            }
            $("#result").html(message);
          },
          error:function(ex){
            console.log(ex);
          }
        });

      };//end onclick....

    };
  </script>
</head>

<body>
<jsp:include page="../top_menu.jsp"/>
<div>
  <h1>회원가입 페이지</h1>
  <form action="m_insertOK.do" method="post">
    <table id="insertTable">
      <tr>
        <td><label for="id">ID</label></td>
        <td>
          <input type="text" id="id" name="id" value="admin" placeholder="ID를 입력하세요">
          <input type="button" id="btn_idCheck" value="idCheck">
          <span id="result">사용가능 or 중복된 아이디</span>
        </td>
      </tr>
      <tr>
        <td><label for="pw">PW</label></td>
        <td><input type="text" id="pw" name="pw" value="hi1111" placeholder="PW를 입력하세요"></td>
      </tr>
      <tr>
      <tr>
        <td><label for="name">NAME</label></td>
        <td><input type="text" id="name" name="name" value="kim" placeholder="NAME를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="tel">TEL</label></td>
        <td><input type="text" id="tel" name="tel" value="010" placeholder="TEL를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="address">ADDRESS</label></td>
        <td><input type="text" id="address" name="address" value="seoul" placeholder="ADDRESS를 입력하세요"></td>
      </tr>
      <td colspan="2"><input type="submit" value="가입완료"></td>
      </tr>
    </table>
  </form>
</div>
</body>

</html>