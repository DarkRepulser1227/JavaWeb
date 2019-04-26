<%--
  Created by IntelliJ IDEA.
  User: Employer Gao
  Date: 2019/4/11
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <%@include file="include.jsp"%>
  </head>
  <body>
  <%--在jsp页面中可以添加<%  %>语句,成为scriplet--%>
    <%
      String name = "高总";
    %>
  <h1>用户的姓名是:<%=name%></h1>
  <%--action是后台目标接收数据,method选择是提交的方式--%>
  <form action="userServlet" method="get">
    <input type="text" value="" name="n"><br>
    <input type="password" value="" name="p"><br>
    <input type="submit" value="登陆">
  </form>

  </body>
</html>
