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
</head>

<body>
<jsp:include page="../top_menu.jsp"/>
<div>
  <h1>부서등록 페이지</h1>
  <form action="d_insertOK.do" method="post">
    <table id="insertTable">
      <tr>
        <td><label for="department_name">department_name</label></td>
        <td><input type="text" id="department_name" name="department_name" value="IT Helpdesk2"
                   placeholder="부서명을 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="manager_id">manager_id</label></td>
        <td><input type="text" id="manager_id" name="manager_id" value="200"
                   placeholder="메니저ID를 입력하세요"></td>
      </tr>
      <tr>
      <tr>
        <td><label for="location_id">location_id</label></td>
        <td><input type="text" id="location_id" name="location_id" value="1200"
                   placeholder="location_id를 입력하세요"></td>
      </tr>
        <td colspan="2"><input type="submit" value="등록완료"></td>
      </tr>
    </table>
  </form>
</div>
</body>

</html>