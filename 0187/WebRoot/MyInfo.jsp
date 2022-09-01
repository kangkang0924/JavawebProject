<%@ page language="java" import="java.util.*,domain.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>个人信息</title>
    
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
  </head>
  
  <%
	User user = (User)request.getSession().getAttribute("existUser");
%>
  <body>
  <form action="UpdateInfoServlet" method="post">
   <div class="row"> 
 <label class="col-sm-3 control-label">用户编号：
 </label> <div class="col-sm-5"><input class="form-control" type="text" readonly="readonly" value="<%=user.getUid()%>" name="uid"></div><br>
	</div>
  <div class="row"> 
 <label class="col-sm-3 control-label">用户名：
 </label> <div class="col-sm-5"><input class="form-control" type="text"  value="<%=user.getNickname()%>" name="nickname"></div><br>
	</div>
	<div class="row">
<label class="col-sm-3 control-label">真实姓名：</label> <div class="col-sm-5"><input class="form-control" type="text" readonly="readonly" value="<%=user.getUsername()%>"></div><br>
	</div>
	 <div class="row"> 
 <label class="col-sm-3 control-label">密码：
 </label> <div class="col-sm-5"><input class="form-control" type="password"  value="<%=user.getPassword()%>" name="password"></div><br>
	</div>
<div class="row">
<label class="col-sm-3 control-label">联系电话：</label> <div class="col-sm-5"><input class="form-control" type="text"  value="<%=user.getPhone()%>" name="phone"></div><br>
</div>
<div class="row">
<label class="col-sm-3 control-label">性别：</label> <div class="col-sm-5"><input class="form-control" type="text"  value="<%=user.getSex()%>" name="sex"></div><br>
</div>
<div class="row">
<label class="col-sm-3 control-label">地址：</label> <div class="col-sm-5"> <input class="form-control" type="text"  value="<%=user.getAddress()%>" name="address"></div><br>
  </div>
  <% 
  	if(user.getLim() == 2){
  	%>
  	<div class="row">
 <label class="col-sm-3 control-label">身份：</label> <div class="col-sm-5"><input  class="form-control" type="text" readonly="readonly" value="学生"></div><br>  </div>
  	<% }else{%>
  <div class="row"><label class="col-sm-3 control-label">身份：</label><div class="col-sm-5"> <input class="form-control" type="text" readonly="readonly" value="老师"></div><br></div>
  	<%} %>
  	<div class="col-sm-9">
  	<button type="submit" class="btn btn-danger">更改信息</button>
  	<a href="ForgetPassword.jsp" target="_blank" class="btn btn-danger">修改密码</a>
  	</div>
  	</form>
  </body>
</html>
