<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>获取图书信息</title>
    <style>
        .box {
          margin: 25 auto;
          padding-right: 300px;
          float:center;
        }
      </style>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<div>
        <jsp:include page="banner.jsp"></jsp:include>
      </div>
      <div class="box">
        <form action="bookinfo_resultOld.jsp" method="post">
          <table border="0" align="center" cellpadding="0" cellspacing="20">
            <tr>
              <td>图书编号：</td>
              <td>${param.bookid}<br></td>
            </tr>
            <tr>
              <td>图书名称：</td>
              <td>${param.bookname}<br></td>
            </tr>
            <tr>
              <td>图书类型：</td>
              <td>${param.typename}<br>
              </td>
            </tr>
            <tr>
              <td>作者：</td>
              <td>${param.author}<br></td>
            </tr>
            <tr>
              <td>出版社：</td>
              <td>${param.pubname}<br></td>
            </tr>
            <tr>
              <td>价格：</td>
              <td>${param.price}（元）<br></td>
            </tr>
            <tr>
              <td>适用人群：</td>
              <td>${paramValues.crowd[0]}
				${paramValues.crowd[1]}
				${paramValues.crowd[2]}
				${paramValues.crowd[3]}<br>
              </td>
            </tr>
            <tr>
              <td>备注：</td>
              <td>${param.content}<br></td>
            </tr>
            <tr>
              <td></td>
              <td><input type="submit" value="确认">
                <input type="reset" value="返回">
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div>
        <jsp:include page="copyright.jsp"></jsp:include>
      </div>
  </body>
</html>
