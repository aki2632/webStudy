<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    input[type=text],
    textarea,
    select {
      width: 100%;
      padding: 8px 8px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ff8f8f;
      border-radius: 14px;
      box-sizing: border-box;
    }

    input[type=submit] {
      width: 30%;
      background-color: #4CAF50;
      color: white;
      padding: 8px 8px;
      margin: 8px 0;
      border: none;
      border-radius: 14px;
      cursor: pointer;
    }

    input[type=submit]:hover {
      background-color: #b7e5b9;
    }

    div {
      border-radius: 15px;
      background-color: #f0f0f0;
      padding: 20px;
    }

    #insertTable {
      font-family: Arial, Helvetica, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }

    #insertTable td {
      border: 1px solid #ddd;
      padding: 8px;
    }

    #insertTable tr:nth-child(even) {
      background-color: #ebebeb;
    }

    #insertTable tr:hover {
      background-color: #ffc6c6;
    }
  </style>

  <script>
    console.log("hello...");
    //http://localhost:8090/web10REST_API_war_exploded/json_object2.do
    window.onload = function(){
      console.log("onload.....");

      document.querySelector("#btn_idCheck").onclick = function(){
        console.log("btn_idCheck....");

        let id = document.querySelector("#id").value;
        console.log(id);

        const xhttp = new XMLHttpRequest();
        xhttp.onload = function(){
          console.log(this.responseText);//문자열 :{"result":"Not OK"}

          let obj = JSON.parse(this.responseText);//객체로 변환해준다.
          console.log(obj.result);

          let message = '';
          if(obj.result === 'OK'){
            message = '사용가능';
          }else{
            message = '중복된 아이디';
          }

          document.querySelector("#result").innerHTML = message;
        };
        xhttp.open("GET","http://localhost:8090/web07total_war_exploded/m_idCheck.do?id="+id);
        xhttp.send();



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
        <td colspan="2"><input type="submit" value="가입완료"></td>
      </tr>
    </table>
  </form>
</div>
</body>

</html>