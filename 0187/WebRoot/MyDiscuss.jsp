<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>我的评论</title>
    
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
		  		<td>评论编号</td>
		  		<td>信息类型</td>
		  		<td>信息</td>
		  		<td>发布人</td>
		  		<td>评论</td>
		  		<td>评论时间</td>
		  		<td>操作</td>
		  	</tr>
		  	<c:forEach var="mydiscuss" items="${requestScope.myDiscuss }">
		  	<tr>
		  	  	<td>${mydiscuss[0] }</td>
		  		<td>${mydiscuss[3] }</td>
		  		<td>${mydiscuss[4] }</td>
		  		<td><a href="UserInfoServlet?username=${mydiscuss[5] }" target="_blank">${mydiscuss[5] }</a></td>
		  		<td>${mydiscuss[1] }</td>
		  		<td>${mydiscuss[2] }</td>
		  		<td><a href="DiscussDelete?did=${mydiscuss[0] }">删除</a></td>
		  	</tr>
		  	</c:forEach>
		  </table>
		  	</div>
  
  </body>
</html>
