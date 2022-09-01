<%@ page language="java" import="java.util.*,model.*"
         pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<% 
	    request.setCharacterEncoding("utf-8"); 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
      <title>查询全部图书信息</title>
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
                    <td height="20" align="left" valign="middle" class="word_orange">当前位置：图书管理信息&gt;图书档案管理&gt;&gt;&gt;
                    </td>
                  </tr>
                  <tr>
                    <td><a href="bookinfo_add.jsp">添加图书档案信息</a><br></td>
                  </tr>
                  <table align="center" cellpadding="7" cellspacing="2" class="nav">
                    <tr>
                      <th>图书编号</th>
                      <th>图书名称</th>
                      <th>图书类型</th>
                      <th>作者</th>
                      <th>价格</th>
                      <th>ISBN</th>
                      <th>现存量</th>
                      <th>总库存</th>
                      <th>出版社</th>               
                      <th>书架</th>                     
                      <th>修改</th>
                      <th>删除</th>
                    </tr>            
                    <%
     					ArrayList allBookInfo=(ArrayList)session.getAttribute("allBookInfo");
     					for(int i=0;i<allBookInfo.size();i++){
     					BookInfo bookinfo=(BookInfo)allBookInfo.get(i);
					%> 
                      <tr>
                        <td><%=bookinfo.getBookid() %></td>
                        <td><%=bookinfo.getBookname() %></td>  
                        <td><%=bookinfo.getBooktypename() %></td>                     
                        <td><%=bookinfo.getAuthor() %></td>
                        <td><%=bookinfo.getPrice() %></td>                       
                        <td><%=bookinfo.getIsbn() %></td>                        
                        <td><%=bookinfo.getNownumber() %></td>
                        <td><%=bookinfo.getTotal() %></td>
                        <td><%=bookinfo.getPubname() %></td>
                        <td><%=bookinfo.getCasename() %></td>                      
                        <td><a href="BookInfoFindByIdServlet?bookid=<%=bookinfo.getBookid()%>" >修改</a></td>
                        <td><a onclick="return delete_onclick()" href="BookInfoDeleteServlet?bookid=<%=bookinfo.getBookid()%>" >删除</a></td>
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