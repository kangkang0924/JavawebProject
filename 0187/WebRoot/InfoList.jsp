<%@ page language="java" import="java.util.*,domain.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>信息列表</title>
    
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
  <c:forEach var="info" items="${sessionScope.AllInformation }">
  		<div class="news-list-item clearfix">
            <div class="col-xs-8">
              <a href="UserInfoServlet?username=${info[3] }" target="_blank" style="color: black;font-size: 30px">${info[3] }:</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <a style="color: red;font-size: 20px">${info[1] }</a>&nbsp;&nbsp;
              <a style="color: red;font-size: 20px">${info[2] }</a>&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <a style="color: black;font-size: 20px">${info[6] }</a>
              <div class="info" align="right" style="width: 701px; ">
                <span style="color: red">999</span>留言 ⋅
                <span style="color: black">${info[5] }</span>
              </div>
            </div>
             <%
					User user = (User)request.getSession().getAttribute("existUser");
				%>
            <form action="DiscussAddServlet?uid=<%=user.getUid()  %>&iid=${info[0] }" method="post">
            <div class="row">
            <div class="col-sm-5 col-sm-offset-3">
             <input type="text" class="form-control"  placeholder="发布评论" name="comm">
             </div>
             <a href="FindDiscussServlet?iid=${info[0] }" target="_blank" class="btn btn-danger">查看留言</a>
             <button class="btn btn-success col-sm-1" type="submit" >留言</button>
             </div>
            </form>
          </div>
             <HR align=center width=800 color=#987cb9 SIZE=1>
			
  </c:forEach>
             
  </body>
</html>
