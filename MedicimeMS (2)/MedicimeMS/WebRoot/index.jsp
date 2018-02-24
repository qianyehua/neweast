<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

session.removeAttribute("uname");
session.removeAttribute("rand");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>业务经理客户访问系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="<%=basePath%>/icon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="<%=basePath%>/icon.ico" type="image/x-icon">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css"  http://www.hfmes.com/SupplyChain5/>
	-->
	<link  rel="stylesheet" href="index.css">
    <script type="text/javascript" src="JS/easyui/jquery.min.js"></script>
  </head>
  
  <body>
        <div class="title">业务经理客户访问系统</div>
        <div class="logindiv" >
           <form id="login" action="servlet/LoginServ">
               <table>
                 
                  <tr><td>账号：</td><td><input type="text" id="Uname" name="uname"/></td><td rowspan="2"><img src="img/login1.png" ></td></tr>
                  <tr><td>密码：</td><td><input type="password" id="Upwd" name="upwd"/></td></tr>
                  <tr><td>验证码：</td><td><input type="text" id="Verify" name="verify"/></td><td><img id="codeimg" src="servlet/getVerifyCode" alt="验证码"></td></tr>
         
               </table>
           </form>
           <div class="btndiv"><input  id="loginbtn" type="button" value="登录" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  id="resetbtn" type="button" value="重置" /></div>
        </div>
      
  </body>
  
  <script>
     $("#loginbtn").click(function(){$("#login").submit();});
     $("#resetbtn").click(function(){$("#Uname").val("");$("#Upwd").val("");$("#Verify").val("");});

  </script>
</html>
