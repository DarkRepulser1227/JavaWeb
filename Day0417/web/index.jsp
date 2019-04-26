<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="include.jsp" %>
    <title>Hello</title>
    <script>
        //jquery入口函数
        $(function () {
            $("#btncls").click(function () {
                $("#uname").val("");
                $("#upwd").val("");//清空
            });
            $("#btn").click(function () {
                var name = $("#uname").val();
                var pwd = $("#upwd").val();
                //json {"key","value",}
                $.ajax({
                    url:"loginServlet",//将数据发送到哪里去
                    type:"get",//数据的提交方式
                    dataType:"json",
                    data:{
                        N:name,
                        P:pwd
                    },
                    success:function (res) {
                        alert(res.message);
                    }
                });


            });
        });

        function login() {
            var name = document.getElementById("uname").value;
            var pwd = document.getElementById("upwd").value;

            alert(name);
        }
    </script>
</head>
<body>
账号：<input type="text" value="" id="uname"/><br/>
密码：<input type="text" value="" id="upwd"/><br/>
<button id="btn">登录测试</button>
<button id="btncls">清空</button>
</body>
</html>
