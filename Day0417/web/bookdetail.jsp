<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/4/18
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="include.jsp" %>
    <title>Title</title>
    <script>
        $(function () {
            var query=window.location.search.substring(1);
            var bid=query.split("=")[1];


            $.get("bookServlet?M=searchBook&ID="+bid,function (res) {
                json=JSON.parse(res);
                //JSON.parse注意大写小，这个方法将json格式的字符串，变成一个json对象
                var str="<table>";
                str+="<tr><td>书名</td><td>"+json.bname+"</td></tr>";
                str+="</<table>";

                $("#bd").html(str);
            });
        })
    </script>
</head>
<body>
    <div id="bd"></div>
</body>
</html>
