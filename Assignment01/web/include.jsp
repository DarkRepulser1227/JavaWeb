<%--
  Created by IntelliJ IDEA.
  User: Employer Gao
  Date: 2019/4/22
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+
            request.getServerPort()+request.getContextPath();
%>
<script src="<%=basePath%>/js/jquery-3.4.0.min.js"></script>