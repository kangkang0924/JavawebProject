<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'InfoTypeAdd.jsp' starting page</title>
    
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
  
  <body>
  	<form class="form-horizontal" action="InfoTypeAddServlet" method="post">
		<div class="form-group" >
		<div class="row">
			    <label class="col-sm-2 control-label">信息类型</label>
			    </div>
			    <div class="col-sm-5 col-sm-offset-1">
			      <input type="text" class="form-control" placeholder="请输入信息类型" name="typename">
			    </div>
			    <div class="col-sm-1">
			      <input type="submit" class="btn btn-success" value="提交"/>
			      </div>
		</div>
	</form>
  </body>
</html>
