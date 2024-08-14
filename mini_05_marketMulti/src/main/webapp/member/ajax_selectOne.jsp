<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <script>
        $(function () {
            console.log("ready....");

            let url2 = "http://localhost:8090/mini_05_marketMulti_war_exploded/json_m_selectOne.do";
            $.ajax({
                url: url2,
                type: "get",
                data: {num:${param.num}}, // 필요하다면 여기에 파라미터를 추가
                dataType: "json",
                success: function (response) {
                    console.log(response);

                    let tag = `<tr>
                      <td>\${response.num}</td>
                      <td>\${response.id}</td>
                      <td>\${response.pw}</td>
                      <td>\${response.name}</td>
                      <td>\${response.tel}</td>
                      <td>\${response.address}</td>
                    </tr>`;

                    $("#result").html(tag);
                },
                error: function (ex) {
                    console.log(ex);
                }
            });

        });
    </script>
</head>
<body>
<h1>회원 정보 페이지</h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
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
</table>
<a href="m_update.do?num=${vo2.num}">회원수정</a>
<a href="m_delete.do?num=${vo2.num}">회원삭제</a>
</body>
</html>
