<%--
  Created by IntelliJ IDEA.
  User: Employer Gao
  Date: 2019/4/22
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <%@include file="include.jsp" %>
    <title>注册页面</title>
  </head>
  <script>

    $(function () {


      $("#reset").click(function () {
        location.href="index.jsp";
      });
      $("#agree").click(function () {
        if($(this).is(':checked')){
          // alert("选中了")
          $("#submit").attr("disabled",false);

        }else{
          // alert("没有选中")
          $("#submit").attr("disabled",true);

        }
      });
      $("#submit").click(function () {
        var uname =$("#uname").val();
        var upwd = $("#confirmUpwd").val();
        var gander = $('input:radio[name="gander"]:checked').val();
        var date = $('#birthdate').val();
        var email = $('#email').val();
        $.ajax({
          url:"enrollServlet",
          type:"post",
          data:{
            UNAME:uname,
            UPWD:upwd,
            GANDER:gander,
            DATE:date,
            EMAIL:email
          },
          success:function (res) {
            alert(res);
          }
        });
      });


    });
    
    function isEqule() {
      var pwd1 = $("#upwd").val();
      var pwd2 = $("#confirmUpwd").val();
      if(pwd1 == pwd2)
      {
        $("#tishi").html("两次密码相同");
        $("#tishi").css("color","green");
        $("#xiugai").removeAttr("disabled");
      }
      else {
        $("#tishi").html("两次密码不相同");
        $("#tishi").css("color","red")
        $("#submit").attr("disabled",true);
      }
    }

  </script>
    <body>
    <table align="center">
      <p>用户信息注册</p>
      <tr>
        <td>用户名:</td>
        <td><input type="text" value="" id="uname"></td>
      </tr>
      <tr>
        <td>密码:</td>
        <td><input type="password" value="" id="upwd"></td>
      </tr>
      <tr>
        <td>再次输入密码:</td>
        <td><input type="password" value="" id="confirmUpwd" placeholder="请再次填写密码" onkeyup="isEqule()"><span id="tishi"></span></td>
      </tr>
      <tr>
        <td>性别:</td>
        <td>
          <input type="radio" name="gander" value="1"/>男
          <input type="radio" name="gander" value="2"/>女
        </td>
      </tr>
      <tr>
        <td>出生日期:</td>
        <td>
          <input type="date" id="birthdate"/>
        </td>
      </tr>
      <tr>
        <td>电子邮箱:</td>
        <td><input type="email" value="" id="email"></td>
      </tr>
      <tr>
        <td colspan="2"><input type="checkbox" value="" id="agree">我同意遵守<a href="#">会员协议</a></td>
      </tr>
      <tr>
        <td colspan="2">
          <button id="submit" disabled="disabled">注册</button>
          <button id="reset">清空</button>
        </td>
      </tr>
    </table>
  </body>
</html>
