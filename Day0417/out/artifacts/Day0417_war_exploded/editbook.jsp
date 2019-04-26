<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/4/18
  Time: 10:34
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

            //1.先获取数据，就是书id，通过形参传入
            //2.得到id以后，将数据发送给后台，得到这个书的对象的json串
            //2.1$.get，也是ajax种的一种，第一个参数，是url路径和传入的参数
            $.get("bookServlet?M=searchBook&ID="+bid,function (r) {
                json=JSON.parse(r);
                $("#bid").val(json.bid);
                $("#bname").val(json.bname);
                $("#bauthor").val(json.author);
                $("#bprice").val(json.price);

            });

            $("#btnsave").click(function () {
                bid=$("#bid").val();
                bname=$("#bname").val();
                bauthor=$("#bauthor").val();
                bprice=$("#bprice").val();

                $.ajax({
                    url:"bookServlet",
                    type:"post",
                    data:{
                        M:"upBook",
                        ID:bid,
                        N:bname,
                        A:bauthor,
                        P:bprice
                    },
                    success:function () {

                    }

                });
            });
        });

    </script>
</head>
<body>
    <table align="center" border="1px solid blue">
        <tr>
            <td>书籍编号</td>
            <td><input type="text" readonly="readonly" id="bid" value=""/></td>
        </tr>
        <tr>
            <td>书籍名称</td>
            <td><input type="text" id="bname" value=""/></td>
        </tr>
        <tr>
            <td>书籍作者</td>
            <td><input type="text" id="bauthor" value=""/></td>
        </tr>
        <tr>
            <td>书籍单价</td>
            <td><input type="text" id="bprice" value=""/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><button id="btnsave">保存修改</button></td>
        </tr>
    </table>
</body>
</html>
