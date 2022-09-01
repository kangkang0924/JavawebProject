<%@ page language="java" import="java.util.*,domain.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>校园生活信息平台</title>
 
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="JS/jquery-1.11.3.min.js"></script>
    <script src="JS/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/main.css">
    
    <script type="text/javascript">
    
    </script>
  </head>
  
  <body>
	  <div class="title">
			<p>欢迎登录校园信息管理平台</p>
		</div>
  		<%@include file="Banner.jsp" %>
  		<%if(existUser.getLim() == 1  ){ %>
    <div class="row">
      <div class="col-sm-2">
  		<div class="hidden-xs list-group side-bar">
  		 <a  class="list-group-item active">管理员功能</a>
          <a href="QueryAllUserServlet" class="list-group-item ">用户查询</a>
          <a href="register.jsp" target="_blank" class="list-group-item">用户添加</a>
<!--           <a href="QueryAllNumServlet" class="list-group-item ">成绩查询</a> -->
          <a href="InformationAllServlet" class="list-group-item">信息查询</a>
           <a href="FindAllDiscuss" class="list-group-item">评论查询</a>
          <a href="InfoTypeJumpServlet" class="list-group-item" >信息类型添加</a>
           <a href="InfoTypeAllServlet" class="list-group-item">信息类型查询</a>
          <a href="/0187/LogoutServlet" class="list-group-item">退出</a>
        </div>
     </div>
       	<div class="col-sm-9" >
       	
    		<!-- 查看用户信息 -->
 			<% if(!(request.getAttribute("allUsers") == null)){ %>
 			<div class="row text-center">
 				<h3>所有用户信息</h3>
 			</div>
 				<%@include file="AllUser.jsp" %>
 			<%} %>
 			
 			<!-- 查看评论信息 -->
 			<% if(!(request.getAttribute("allDiscuss") == null)){ %>
 			<div class="row text-center">
 				<h3>所有评论信息</h3>
 			</div>
 				<%@include file="AllDiscuss.jsp" %>
 			<%} %>
 			
 			<!-- 查看成绩信息 -->
<!--  			<% if(!(request.getAttribute("AllExam") == null)){ %> -->
<!--  			<div class="row text-center"> -->
<!--  				<h3>所有成绩信息</h3> -->
<!--  			</div> -->
<!--  				<%@include file="AllExam.jsp" %> -->
<!--  			<%} %> -->
 			
 			<!-- 信息类型添加 -->
 			<% if(!(request.getAttribute("infotype") == null)){ %>
 			<div class="row text-center">
 				<h3>添加信息类型</h3>
 			</div>
 			<div class="row text-center">
 				<%@include file="InfoTypeAdd.jsp" %>
 				</div>
 			<%} %>
 			
 			<!-- 信息类型查询 -->
 			<% if(!(request.getAttribute("infoTypeAll") == null)){ %>
 			<div class="row text-center">
 				<h3>信息类型查询</h3>
 			</div>
 			<div class="row text-center">
 				<%@include file="InfoTypeAll.jsp" %>
 				</div>
 			<%} %>
 			
 			<!-- 信息查询 -->
 			<% if(!(request.getAttribute("informationAll") == null)){ %>
 			<div class="row text-center">
 				<h3>信息查询</h3>
 			</div>
 			<div class="row text-center">
 				<%@include file="InformationAll.jsp" %>
 				</div>
 			<%} %>
 			
 		</div>
        
        
        
        
 	    </div>
    <% }else{ %>
      <div class="col-sm-2">
  		<div class="hidden-xs list-group side-bar">
  		<a  class="list-group-item active">用户功能</a>
          <a href="InformationAllServlet" class="list-group-item ">信息查看</a>
          <a href="InfoJumpServlet" class="list-group-item">信息发布</a>
           <a href="MyPubInfoServlet?uid=<%=existUser.getUid() %>" class="list-group-item">我的发布</a>
           <a href="MyDiscussServlet?uid=<%=existUser.getUid() %>" class="list-group-item">我的评论</a>
           <a href="DiscussMyServlet?uid=<%=existUser.getUid() %>" class="list-group-item">我的回复</a>
          <a href="InfoTypeJumpServlet" class="list-group-item">我的资料</a>
          <a href="/0187/LogoutServlet" class="list-group-item">退出</a>
        </div>
 	    </div>
 		 <!-- 第二模块 -->
 		<div class="col-sm-9" >
 			
 			<!-- 自我信息查看 -->
	 		<% if(!(request.getAttribute("myinfo") == null)){ %>
	 			<div class="row text-center">
	 				<h3>我的信息</h3>
	 			</div>
	 			<div class="row text-center">
	 				<%@include file="MyInfo.jsp" %>
	 				</div>
	 			<%} %>
	 			
	 		<!-- 我的评论查看 -->
	 		<% if(!(request.getAttribute("myDiscuss") == null)){ %>
	 			<div class="row text-center">
	 				<h3>我的评论</h3>
	 			</div>
	 			<div class="row text-center">
	 				<%@include file="MyDiscuss.jsp" %>
	 				</div>
	 			<%} %>
	 			
	 			<!-- 谁评论了我查看 -->
	 		<% if(!(request.getAttribute("discussMy") == null)){ %>
	 			<div class="row text-center">
	 				<h3>我的回复</h3>
	 			</div>
	 			<div class="row text-center">
	 				<%@include file="DiscussMy.jsp" %>
	 				</div>
	 			<%}%>
	 			<!-- 信息列表查看 -->
	 		<% if(!(request.getAttribute("informationAll") == null)){ %>
	 			<div class="row text-center">
	 				<h3>信息公告版</h3>
	 			</div>
	 			<div class="row text-center">
	 			<form class="navbar-form navbar-right" role="search" method="post" action="InfoFindByTypeServlet">
			        <div class="form-group">
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
			        <button type="submit" class="btn btn-default">Submit</button>
			      </form>
	 			</div>
	 			<% if(!(request.getAttribute("infoFindByType") == null)) {%>
		 			<div class="row ">
		 				<%@include file="infoFindByType.jsp" %>
		 			</div>
	 			<% }else{ %>
	 				<div class="row ">
	 				<%@include file="InfoList.jsp" %>
	 				<%} %>
	 			<%} %>
	 			
	 			<!-- 本人发布信息查看 -->
	 		<% if(!(request.getAttribute("myPubInfo") == null)){ %>
	 			<div class="row text-center">
	 				<h3>我发布的信息</h3>
	 			</div>
	 			<div class="row ">
	 				<%@include file="MyPubInfo.jsp" %>
	 				</div>
	 			<%} %>
	 			
	 		<!-- 信息发布 -->
	 		<% if(!(request.getAttribute("InfoAdd") == null)){ %>
	 			<div class="row text-center">
	 				<h3>信息发布</h3>
	 			</div>
	 			<div class="row text-center">
	 				<%@include file="InfoAdd.jsp" %>
	 				</div>
	 			<%} %>
 		
 		</div>
 		 <%} %>
 		 
 		</div>
  </body>
</html>
