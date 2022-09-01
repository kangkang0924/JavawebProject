<%@ page language="java" import="java.util.*,model.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<% 
	    request.setCharacterEncoding("utf-8"); 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
      <title>查询全部读者信息</title>
      <style>
        .nav {
          width: 768px;
          text-align: center;       
        }
        .nav tr th {         
          background-color: rgba(249, 209, 107);
          font-size: 12px;
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
      <link href="CSS/style.css" rel="stylesheet">
      <script>
      	function delete_onclick(){
      var bln = confirm("是否删除该笔资料？");
      //直接返回
      return bln;
    }
      </script>
     
    </head>

    <body>
      <%@include file="banner.jsp" %>

        <%@include file="navigation.jsp" %>

          <table width="778" height="510" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"
            class="tableBorder_gray">
            <tr>
              <td align="center" valign="top" style="padding:5px;">
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="20" align="left" valign="middle" class="word_orange">当前位置：读者管理信息&gt;读者档案管理&gt;&gt;&gt;
                    </td>
                  </tr>
                  <tr>
                    <td><a href="readerinfo_add.jsp">添加读者档案信息</a><br></td>
                  </tr>
                  <table align="center" cellpadding="7" cellspacing="2" class="nav">
                    <tr>
                      <th>读者编号</th>
                      <th>读者类型</th>
                      <th>读者姓名</th>
                      <th>身份证</th>
                      <th>可借数量</th>
                      <th>已借数量</th>                    
                      <th>修改</th>
                      <th>删除</th>
                    </tr>            
                    <%
     					ArrayList allReaderInfo=(ArrayList)session.getAttribute("allReaderInfo");
     					for(int i=0;i<allReaderInfo.size();i++){
     					ReaderInfo readerinfo=(ReaderInfo)allReaderInfo.get(i);
					%> 
                      <tr>
                        <td><%=readerinfo.getReaderid() %></td>
                        <td><%=readerinfo.getReadertypename() %></td>  
                        <td><%=readerinfo.getReadername() %></td>                     
                        <td><%=readerinfo.getIdcard() %></td>
                        <td><%=readerinfo.getNumber() %></td>                       
                        <td><%=readerinfo.getBorrownumber() %></td>                                            
                        <td><a href="ReaderInfoFindByIdServlet?readerid=<%=readerinfo.getReaderid()%>" >修改</a></td>
                        <td><a onclick="return delete_onclick()" href="ReaderInfoDeleteServlet?readerid=<%=readerinfo.getReaderid()%>" >删除</a></td>
                      </tr>
                      <% } %>
                  </table>
                </table>
              </td>

            </tr>
          </table>

          <%@ include file="copyright.jsp" %>
    </body>

    </html>