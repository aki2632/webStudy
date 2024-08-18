<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>상품 상세 페이지</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(function () {
            console.log("ready....");

            console.log(${param.num});

            let url2 = "http://localhost:8090/mini_05_marketMulti_war_exploded/json_p_selectOne.do";
            $.ajax({
                url: url2,
                type: "get",
                data: {num: ${param.num}},
                dataType: "json",
                success: function (response) {
                    console.log(response);
                    let tag = `<tr>
                      <td>${response.num}</td>
                      <td>${response.pname}</td>
                      <td>${response.content}</td>
                      <td>${response.price}</td>
                      <td>${response.company}</td>
                      <td>${response.img}</td>
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
<h1><%= "상품 상세 페이지" %>
</h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
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
</table>
<a href="p_update.do?num=${param.num}">상품수정</a>
<a href="p_delete.do?num=${param.num}">상품삭제</a>
<hr>
</body>
</html>
