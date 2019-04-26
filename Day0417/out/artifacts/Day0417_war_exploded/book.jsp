<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/4/17
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="include.jsp" %>
    <title>Title</title>
    <script>
        $(function () {
            $.ajax({
                url:"bookServlet",
                type:"post",//数据的提交方式
                dataType:"json",
                data:{
                    M:"getBook"
                },
                success:function (res) {
                    var str="<table border='1px solid blue'><tr><td>书名</td><td>作者</td><td>单价</td><td>操作</td></tr>";
                    for (var i=0;i<res.length;i++){
                        // if(i%2==0){
                        str+="<tr><td><a href='bookdetail.jsp?ID="+res[i].bid+"'>"+res[i].bname+"</a></td><td>"+res[i].author+"</td><td>"+res[i].price+
                            "</td><td><button onclick='delbook(\""+res[i].bid+"\")'>删除</button><button onclick='editbook(\""+res[i].bid+"\")'>编辑</button></td></tr>";
                        // }else{
                        //     str+="<tr><td>"+res[i].bname+"</td><td>"+res[i].author+"</td><td>"+res[i].price+"</td><td>操作</td></tr>";
                        // }

                    }
                    str+="</table>";
                    $("#book").html(str);
                }
            });
        });

        function editbook(id) {
            location.href="editbook.jsp?id="+id;



        }

        function delbook(id) {
            $.get("bookServlet?M=del&ID="+id,function (res) {
                // var str="<table border='1px solid blue'><tr><td>书名</td><td>作者</td><td>单价</td><td>操作</td></tr>";
                // for (var i=0;i<res.length;i++){
                //     // if(i%2==0){
                //     str+="<tr><td>"+res[i].bname+"</td><td>"+res[i].author+"</td><td>"+res[i].price+"</td><td><button onclick='delbook(\""+res[i].bid+"\")'>删除</button></td></tr>";
                //     // }else{
                //     //     str+="<tr><td>"+res[i].bname+"</td><td>"+res[i].author+"</td><td>"+res[i].price+"</td><td>操作</td></tr>";
                //     // }
                //
                // }
                // str+="</table>";
                // $("#book").html(str);
                location.href="book.jsp";
            });
        }
    </script>
</head>
<body>
    <div id="book"></div>
</body>
</html>
