<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/4/22
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="jquery-3.4.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            init();

            $("#myreg").click(function () {
                var name=$("#uname").val();
                var pwd1=$("#upwd").val();
                var pwd2=$("#reupwd").val();
                var sex=$("input:radio[name='sex']:checked").val();
                var date=$("#year")+"-"+$("#month")+"-"+$("#day");
                var mail=$("#uemal").val();

                $.ajax({
                    url:"",
                    type:"post",
                    data:{
                        
                    },
                    success:function (res) {
                        
                    }
                });

            });
            
            $("#mycls").click(function () {
                location.href="index.jsp";
            });


            $("#year").on("change",function () {
                mychange();
            });

            $("#month").on("change",function () {
                mychange();
            });

            $("#day").on("change",function () {
                mychange();
            });
            
            $("#agree").click(function () {
                if($(this).is(':checked')){
                    // alert("选中了")
                    $("#myreg").attr("disabled",false);

                }else{
                    // alert("没有选中")
                    $("#myreg").attr("disabled",true);

                }

            });

        });

        function mychange() {
            //日期的判定
            var y=$("#year").val();
            var m=$("#month").val();

            var isLeapYear=false;
            var daycount=0;

            if((y%4==0 && y%100!=0) || (y%400==0)){
                isLeapYear=true;
            }

            if (m==2 && isLeapYear==true){
                if (isLeapYear==true){
                    daycount=29;
                } else{
                    daycount=29;
                }
            }else{
                if (m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12){
                    daycount=31;
                } else{
                    daycount=30;
                }
            }

            $("#day").empty();

            for (var i=1;i<=daycount;i++){
                $("#day").append("<option value='"+i+"'>"+i+"日</option>");
            }

        }

        function init() {
            $("#year").empty();
            for (var i=2000;i<=2019;i++){
                $("#year").append("<option value='"+i+"'>"+i+"年</option>");
            }

            $("#month").empty();
            for (var i=1;i<=12;i++){
                $("#month").append("<option value='"+i+"'>"+i+"月</option>");
            }

            //日期的判定
            var y=$("#year").val();
            var m=$("#month").val();

            var isLeapYear=false;
            var daycount=0;

            if((y%4==0 && y%100!=0) || (y%400==0)){
                isLeapYear=true;
            }

            if (m==2 && isLeapYear==true){
                daycount=29;
            }
            if (m==2 && isLeapYear==false){
                daycount=28;
            }

            if (m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12){
                daycount=31;
            } else{
                daycount=30;
            }

            $("#day").empty();

            for (var i=1;i<=daycount;i++){
                $("#day").append("<option value='"+i+"'>"+i+"日</option>");
            }



        }
    </script>
    <title></title>
</head>
<body>
<table align="center">
    <tr>
        <td>账户:</td>
        <td><input type="text" value="" id="uname"></td>
    </tr>
    <tr>
        <td>密码:</td>
        <td><input type="password" value="" id="upwd"></td>
    </tr>
    <tr>
        <td>确认密码:</td>
        <td><input type="password" value="" id="reupwd"></td>
    </tr>
    <tr>
        <td>性别:</td>
        <td>
            <input type="radio" name="sex" value="1"/>男
            <input type="radio" name="sex" value="2"/>女
        </td>
    </tr>
    <tr>
        <td>出生年月日:</td>
        <td>
            <select id="year"></select>年
            <select id="month"></select>月
            <select id="day"></select>日
        </td>
    </tr>
    <tr>
        <td>电子邮箱:</td>
        <td><input type="text" value="" id="uemal"></td>
    </tr>
    <tr>
        <td colspan="2"><input type="checkbox" value="" id="agree">朕知道了</td>
    </tr>
    <tr>
        <td colspan="2">
            <button id="myreg" disabled="disabled">注册</button>
            <button id="mycls">清空</button>
        </td>
    </tr>
</table>
</body>
</html>
