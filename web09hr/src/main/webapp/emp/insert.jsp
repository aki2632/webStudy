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
  <h1>사원등록 페이지</h1>
  <form action="e_insertOK.do" method="post">
    <table id="insertTable">
      <tr>
        <td><label for="first_name">first_name</label></td>
        <td><input type="text" id="first_name" name="first_name" value="GilDong"
                   placeholder="first_name을 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="last_name">last_name</label></td>
        <td><input type="text" id="last_name" name="last_name" value="Hong"
                   placeholder="last_name을 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="email">email</label></td>
        <td><input type="text" id="email" name="email" value="Hong@aaa.com"
                   placeholder="email를 입력하세요"></td>
      </tr>
      <tr>
      <tr>
        <td><label for="phone_number">phone_number</label></td>
        <td><input type="text" id="phone_number" name="phone_number" value="010-0000-0000"
                   placeholder="phone_number를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="hire_date">hire_date</label></td>
        <td><input type="date" id="hire_date" name="hire_date" value=""
                   placeholder="hire_date를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="job_id">job_id</label></td>
        <td><input type="text" id="job_id" name="job_id" value="IT_PROG"
                   placeholder="job_id를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="salary">salary</label></td>
        <td><input type="number" id="salary" name="salary" value="6000"
                   placeholder="salary를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="commission_pct">commission_pct</label></td>
        <td><input type="number" id="commission_pct" name="commission_pct" value="0.1"
                   placeholder="commission_pct를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="manager_id">manager_id</label></td>
        <td><input type="number" id="manager_id" name="manager_id" value="200"
                   placeholder="manager_id를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="department_id">department_id</label></td>
        <td><input type="number" id="department_id" name="department_id" value="30"
                   placeholder="department_id를 입력하세요"></td>
      </tr>
        <td colspan="2"><input type="submit" value="등록완료"></td>
      </tr>
    </table>
  </form>
</div>
</body>

</html>