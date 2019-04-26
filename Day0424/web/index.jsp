<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/4/24
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <form method="post" action="uploadServlet" enctype="multipart/form-data">
      <input type="file" name="uploadFile">
      <input type="submit" value="上传"/>
    </form>
    <a href="downloadServlet?ID=cf9ce7c06d70435c979b738ad4d925c7">JavaMail.jar</a>
  </body>
</html>
