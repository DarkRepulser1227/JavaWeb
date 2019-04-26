<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/4/15
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
    <form action="usersServlet" method="get">
        账户:    <input type="text" value="" name="uname"><br/>
        密码:    <input type="password" value="" name="pwd"><br/>
        确认密码：<input type="password" value="" name="repwd"><br/>
                <input type="submit" value="注册" ><br/>
    </form>
</head>
<body>

</body>
</html>
