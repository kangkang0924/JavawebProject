<%@ page language="java" import="java.util.*,domain.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'Info.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="JS/jquery-1.11.3.min.js"></script>
    <script src="JS/bootstrap.min.js"></script>
    	<link rel="stylesheet" type="text/css" href="./css/success.css">
  </head>
  
  <body>
  <div class="title">
		<p>用户信息</p>
	</div>
  	<% User user = (User)request.getAttribute("user"); %>
	  <div class="row"> 
	 <label class="col-sm-3 control-label col-sm-offset-2">用户名：
	 </label> <div class="col-sm-5"><input class="form-control" type="text" readonly="readonly" value="<%=user.getNickname()%>" name="uid"></div><br>
		</div>
		  <div class="row"> 
	 <label class="col-sm-3 control-label col-sm-offset-2">真实姓名：
	 </label> <div class="col-sm-5"><input class="form-control" type="text" readonly="readonly" value="<%=user.getUsername()%>" name="uid"></div><br>
		</div>
		  <div class="row"> 
	 <label class="col-sm-3 control-label col-sm-offset-2">联系电话：
	 </label> <div class="col-sm-5"><input class="form-control" type="text" readonly="readonly" value="<%=user.getPhone()%>" name="uid"></div><br>
		</div>
		  <div class="row"> 
	 <label class="col-sm-3 control-label col-sm-offset-2">性别：
	 </label> <div class="col-sm-5"><input class="form-control" type="text" readonly="readonly" value="<%=user.getSex()%>" name="uid"></div><br>
		</div>
		  <div class="row"> 
	 <label class="col-sm-3 control-label col-sm-offset-2">地址：
	 </label> <div class="col-sm-5"><input class="form-control" type="text" readonly="readonly" value="<%=user.getAddress()%>" name="uid"></div><br>
		</div>
  
  </body>
</html>
