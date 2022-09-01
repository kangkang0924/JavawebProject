<%@ page language="java" import="java.util.*,model.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<% 
	    request.setCharacterEncoding("utf-8"); 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
      <title>查询全部读者类型信息</title>
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
                    <td height="20" align="left" valign="middle" class="word_orange">当前位置：读者管理&gt;读者类型管理&gt;&gt;&gt;
                    </td>
                  </tr>
                  <tr>
                    <td><a href="readertype_add.jsp">添加读者类型信息</a><br></td>
                  </tr>
                  <table align="center" cellpadding="7" cellspacing="2" class="nav">
                    <tr>
                      <th>读者类型编号</th>
                      <th>读者类型名称</th>
                      <th>可借数量</th>
                      <th>修改</th>
                      <th>删除</th>
                    </tr>            
                    <%
     					ArrayList allReaderType=(ArrayList)session.getAttribute("allReaderType");
     					for(int i=0;i<allReaderType.size();i++){
     					ReaderType readertype=(ReaderType)allReaderType.get(i);
					%> 
                      <tr>
                        <td><%=readertype.getReadertypeid() %></td>
                        <td><%=readertype.getReadertypename() %></td>  
                        <td><%=readertype.getNumber() %></td>                                       
                        <td><a href="ReaderTypeFindByIdServlet?readertypeid=<%=readertype.getReadertypeid()%>" >修改</a></td>
                        <td><a onclick="return delete_onclick()" href="ReaderTypeDeleteServlet?readertypeid=<%=readertype.getReadertypeid()%>" >删除</a></td>
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