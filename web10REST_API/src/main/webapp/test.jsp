<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        console.log("hello...");
        //http://localhost:8090/web10REST_API_war_exploded/json_object2.do
        window.onload = function(){
            console.log("onload.....");
            const xhttp = new XMLHttpRequest();
            xhttp.onload = function(){
                console.log(this.responseText);//문자열 : {"name":"kim","age":22}

                let obj = JSON.parse(this.responseText);//객체로 변환해준다.
                console.log(obj.name,obj.age);

                document.querySelector("#data").innerHTML = this.responseText;
                document.querySelector("#name").innerHTML = obj.name;
                document.querySelector("#age").innerHTML = obj.age;
            };
            xhttp.open("GET","http://localhost:8090/web10REST_API_war_exploded/json_object2.do");
            xhttp.send();

            // idCheck 비동기 로직 구현하기

        };
    </script>
</head>
<body>
<h1>javascript AJAX</h1>
<h1 id="data"></h1>
<h1 id="name"></h1>
<h1 id="age"></h1>
<hr>
<input type="text" name="id" id="id" value="admin">
<button id="btn_idCheck">idCheck</button>
<span id="result">OK and Not OK</span>
</body>
</html>