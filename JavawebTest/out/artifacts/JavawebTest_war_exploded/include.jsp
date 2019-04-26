<%--
  Created by IntelliJ IDEA.
  User: Employer Gao
  Date: 2019/4/11
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//    获得路径
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort();
%>
<script src="<%=basePath%>/js/bootstrap.min.js"></script>
