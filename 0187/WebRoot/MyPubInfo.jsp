<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>自己发布的信息界面</title>
    
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
  			  <div align="center">
  	 <table border="1px"  style="color: black" class="gridtable">
  	<tr>
  		<td>信息编号</td>
  		<td>信息类型</td>
  		<td style="width: 59px; ">信 息 </td>
  		
  		<td>联系电话</td>
  		<td>发布时间</td>
  		<td style="width: 68px; ">信息详情</td>
  	</tr>
  		<c:forEach var="info" items="${requestScope.myPubInfo }">
  	<tr>
  		
  		<td>${info[0] }</td>
  		<td>${info[1] }</td>
  		<td>${info[2] }</td>
  		<td>${info[5] }</td>
  		<td>${info[6] }</td>
  		<td><a href="InfoDetailServlet?iid=${info[0] }" target="_blank">查看详情</a><td>
  		<td><a href="InfoDeleteServlet?iid=${info[0] }">删除</a><td>
  	</tr>
  		</c:forEach>
  	</table>
  	
  </div>
  		</div>
  
  </body>
</html>
