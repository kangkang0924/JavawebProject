<%@ page language="java" import="java.util.*,domain.*" pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>校园信息平台登陆界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./css/login.css">
	<script type="text/javascript">
	function changeImg(){
		document.getElementById("img1").src="/0187/CheckImgServlet?time="
		+new Date().getTime();
	}
	</script>
  </head>
  
  <body>
  <%
	String msg = "";
	// 判断是否已经存在错误信息:
	if(request.getAttribute("msg") != null){
		msg = (String)request.getAttribute("msg");
	}
%>
	<div class="title">
		<p>欢迎登录校园信息管理平台</p>
	</div>

  <div id="index">
   <form action="LoginServlet" method="post">
   <p>真实姓名
   <input type="text" name="username"  value="${cookie.remember.value }"/>
   </p>
   <p>密 &nbsp;&nbsp;码
   <input type="password" name="password"/>
   </p>
  	<p>
   验证码
   <input type="text" name="checkcode"/>
   </p>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img id="img1" src="/0187/CheckImgServlet"/>&nbsp;&nbsp;
   <a href="#" onclick ="changeImg()" style="color: red">看不清，换一张</a>
   <p>				
				<input name="lim" type="radio" value="学生" checked>学生 
				<input name="lim" type="radio" value="管理员">管理员<br>
			</p>
  <p>
  
   <input type="checkbox" name="remember" checked="checked" value="true"/> 记住用户名
    &nbsp;&nbsp; <a  style="text-decoration: none" href="register.jsp" target="_blank">注册</a>
   </p>
   <p>
   
  <input id="btn_login" type="submit" value="登陆" >
  &nbsp;&nbsp;<a  style="text-decoration: none" href="ForgetPassword.jsp" target="_blank">忘记密码</a>
  </p>
 
   </form>
     <h3><font color="red"><%= msg %></font></h3>
   </div>
  </body>
</html>
