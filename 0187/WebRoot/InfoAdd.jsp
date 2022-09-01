<%@page import="model.InfoModel"%>
<%@ page language="java" import="java.util.*,domain.*,java.text.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>信息添加</title>
    
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
  		<form class="form-horizontal" method="post" action="InfoAddServlet">
			  <div class="form-group">
			    <label class="col-sm-3 control-label">信息名：</label>
			    <div class="col-sm-5">
			      <input type="text" class="form-control" placeholder="请输入信息名" name="information">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-3 control-label">信息类型：</label>
			    <div class="col-sm-5">
			      <select name="itype" class="form-control" >
			      <option>请选择信息类型</option>
			      <%
			     	 InfoModel infoModel = new InfoModel();
			   		 List<InfoType> list = infoModel.infoTypeAll();
			       for(int i=0;i<list.size();i++){
			       InfoType infoType = list.get(i);
			      %>
			      <option value="<%=infoType.getInfo_typename()%>"><%=infoType.getInfo_typename()%></option>
			      <%} %>
			      </select>
			    </div>
			  </div>
			   <div class="form-group">
			    <label class="col-sm-3 control-label">信息详情：</label>
			    <div class="col-sm-5">
			      <textarea class="form-control"  name="detail" id="inputPassword3" placeholder="请输入信息详情"></textarea>
			    </div>
			  </div>
			  <div class="form-group">
			   <%
					User u = (User)request.getSession().getAttribute("existUser");
				%>
			    <label class="col-sm-3 control-label">发布人：</label>
			    <div class="col-sm-5">
			    <input type="text" class="form-control" readonly="readonly" value="<%=u.getUsername()%>" name="username">
			    </div>
			  </div>
			    <div class="form-group">
			    <label class="col-sm-3 control-label">联系电话：</label>
			    <div class="col-sm-5">
			    <input type="text" class="form-control" value="<%=u.getPhone() %>" readonly="readonly" name="phone">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-3 control-label">发布时间：</label>
			    <div class="col-sm-5">
			    <% 
			    Date date = new Date();
			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");%>
			    
			    <input type="text" class="form-control"  name="pubtime" value="<%=formatter.format(date) %>" readonly="readonly">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <div class="col-sm-offset-3 col-sm-1">
			      <input type="submit" class="btn btn-default" value="提交"/>
			    </div>
			  </div>
			</form>
  </body>
</html>
