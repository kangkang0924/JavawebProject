<%@ page language="java" import="java.util.*,domain.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>所有用户信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
			table.gridtable {
				font-family: verdana,arial,sans-serif;
				font-size:11px;
				color:#333333;
				border-width: 1px;
				border-color: #666666;
				border-collapse: collapse;
			}
			table.gridtable th {
				border-width: 1px;
				padding: 8px;
				border-style: solid;
				border-color: #666666;
				background-color: #dedede;
			}
			table.gridtable td {
				border-width: 1px;
				padding: 8px;
				border-style: solid;
				border-color: #666666;
				background-color: #ffffff;
			}
</style>
  </head>
  
  <body>
  <div align="center">
  <table border="1px"  style="color: black" class="gridtable">
  	<tr>
  		<td>用户编号</td>
  		<td>用户名</td>
  		<td>真实姓名</td>
  		<td>密码</td>
  		<td>电话号码</td>
  		<td>性别</td>
  		<td>地址</td>
  		<td>权限</td>
  	</tr>
  	<c:forEach var="user" items="${requestScope.allUsers }">
  	<tr>
  	  	<td>${user.uid }</td>
  		<td>${user.nickname }</td>
  		<td>${user.username }</td>
  		<td>${user.password }</td>
  		<td>${user.phone }</td>
  		<td>${user.sex }</td>
  		<td>${user.address }</td>
  		<td>${user.lim }</td>
  	</tr>
  	</c:forEach>
  </table>
  	</div>
  </body>
</html>
