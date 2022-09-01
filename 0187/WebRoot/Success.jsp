<%@ page language="java" import="java.util.*,domain.*" pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登陆成功界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./css/success.css">
  </head>
  
  <body>
  <div class="title">
		<p>欢迎登录校园信息管理平台</p>
	</div>
  <%
	if(request.getSession().getAttribute("existUser") == null){
%>		
	<h1>您还没有登录！请先去<a href="/0187/Login.jsp">登录</a>！</h1>
<%	
	}else{
%>

	<h1 style="color: red">${param.lim}登陆成功!</h1>
	
<%
	response.setHeader("Refresh", "2,url=main.jsp");
 %>
<%			
	}
%>
  </body>
</html>
