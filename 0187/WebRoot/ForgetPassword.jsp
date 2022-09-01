<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>忘记密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./css/login.css">
  </head>
  <body>
  <div class="title">
		<p>找回密码</p>
		</div>
		<div id="index">
		<form action="ForgetPasswordServlet" method="post">
		
		<p>真实姓名 
			<input type="text" name="username">
		</p>
		<p>
			预留手机号码
			<input type="text" name="phone">
		</p>
		<p>
			地址
			<input type="text" name="address"> 
		</p>
		 <input id="btn_login" type="submit" value="提交" >
		</form>
	</div>
  </body>
</html>
