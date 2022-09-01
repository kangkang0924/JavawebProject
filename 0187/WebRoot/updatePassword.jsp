<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改密码界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./css/login.css">
	  <script type="text/javascript"  src="JS/jquery-1.7.2.js"></script>
    <script type="text/javascript">
    $(function(){
    	$("#password1").blur(function(){
    	var password = $("#password").val();
    	var password1 = $(this).val();
    	if(password==password1){
    		$("#s1").text("✔").css("color", "green");
    		}else{
    		$("#s1").text("密码不一致").css("color", "red");
    		$(this).focus();
    		}
    	});
    	
	});
	</script>
  </head>
  
  <body>
  <div class="title">
		<p>修改密码界面</p>
	</div>
	<div id="index">
  <form action="UpdatePasswordServlet" method="post">
  <%
  	String name =(String)request.getAttribute("user");
   %>
    <p>姓&nbsp;&nbsp;名&nbsp;&nbsp;<input type="text" name="username" value="<%=name%>"></p>
    <p>密&nbsp;&nbsp;码&nbsp;&nbsp;<input type="password" name="password" id="password"></p>
   <p>确认密码<input type="password" name="password" id="password1"><span id="s1"></span></p>
    <input type="submit" id="btn_login" value="提交">
    <input type="reset" id="btn_login" value="重置">
  </form>
  </div>
  </body>
</html>
