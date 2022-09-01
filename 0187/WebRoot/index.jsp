<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
	<script language="javascript" type="text/javascript">
				var i = 3;      /*这里不写5,写成4,是为了读秒视觉效果*/
				var res;
				res = setInterval("jump()", 1000);
			function jump()
				{
				if(i == 0){
					window.location.href ="Login.jsp";
					clearInterval(res);
				}
					document.getElementById("mes").innerHTML = i;
					i--;
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
<div align="center">
	<h1 style="color: red"><%=msg %></h1>

<%// response.setHeader("Refresh", "1,url=Login.jsp"); %>
<h1 >将在<span id="mes" style="color: red; font-weight: bold">3</span>秒后跳转...</h1>
</div>
  </body>
</html>
