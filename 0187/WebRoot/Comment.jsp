<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>评论信息</title>
    
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
  <% ArrayList<Object[]> arrayList = (ArrayList)request.getAttribute("discuss");
  	for(int i=0;i<arrayList.size();i++){
  	Object[] o = arrayList.get(i);
   %>

    <div class="news-list-item clearfix">
            <div class="col-xs-6">
             <a href="UserInfoServlet?username=<%=o[3] %>" target="_blank" style="color: black;font-size: 25px"><%=o[3] %>:</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             <a style="color: red;font-size: 20px"><%=o[1] %></a>
             
             <a style="color: black"><%=o[2] %></a></div>
     </div>
     <%} %>
  </body>
</html>
