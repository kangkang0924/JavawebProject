<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>信息类型查询与修改</title>
    
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
  		<tr style="width: 701px; ">
  			<td>信息编号</td>
  			<td>信息类型</td>
  		</tr>
  	<c:forEach var="infoType" items="${requestScope.infoTypeAll}">
  		<tr>
  			<td>${infoType.info_typeid }</td>
  			<td>${infoType.info_typename }</td>
  		</tr>
  		</c:forEach>
  	</table>
  		<form class="form-horizontal" action="InfoTypeDeleteServlet" method="post">
		<div class="form-group" >
		<div class="row">
			    <label class="col-sm-5 control-label">信息类型编号</label>
			    </div>
			    <div class="col-sm-5 col-sm-offset-4">
			      <input type="text" class="form-control" placeholder="请输入信息类型编号" name="iid">
			    </div>
			    <div class="col-sm-1">
			      <input type="submit" class="btn btn-success" value="删除"/>
			      </div>
			</div>
	</form>
	
  </div>
  </body>
</html>
