<%@page import="dao.factory.DAOFactory"%>
<%@ page language="java" import="java.util.*,model.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<% 
	    request.setCharacterEncoding("gb2312"); 
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
  <base href="<%=basePath%>">

  <title>修改图书档案信息</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link href="CSS/style.css" rel="stylesheet">
</head>

<body>
  <%@ include file="banner.jsp" %>
    <table width="778" border="0" cellspacing="0" cellpadding="0" align="center">
      <tr>
        <td valign="top" bgcolor="#FFFFFF">
          <table width="99%" height="510" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"
            class="tableBorder_gray">
            <tr>
              <td height="510" valign="top" style="padding:5px;">
                <table width="98%" height="487" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="22" valign="top" class="word_orange">当前位置：图书管理 &gt; 图书档案管理 &gt; 修改图书信息 &gt;&gt;&gt;</td>
                  </tr>
                  <tr>
                    <td align="center" valign="top">
                      <table width="100%" height="493" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td align="center" valign="top">
                            <% BookInfo bookinfo=(BookInfo)session.getAttribute("bookinfo"); %>

                              <form name="form1" method="post" action="BookInfoUpdateServlet">
                                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                  <tr>
                                    <td height="50" align="center">图书名称：</td>
                                    <td><input name="bookname" type="text" value="<%=bookinfo.getBookname() %>" /></td>
                                  </tr>
                                  <tr>
                                    <td align="center">图书类型：</td>
                                    <td><select name="booktypeid" class="wenbenkuang" id="booktypeid">
                                    	<% /* ArrayList allBookType=(ArrayList)session.getAttribute("allBookType"); */
                                        ArrayList<BookType> allBookType=DAOFactory.getBookTypeDAOInstance().findAllBookType();
                                        int booktypeid = bookinfo.getBooktypeid() ;
                                        for(int i=0;i<allBookType.size();i++){ 
                                          BookType booktype=(BookType)allBookType.get(i);
                                          if(bookinfo.getBooktypeid()==booktype.getBooktypeid()){ 
                                          %>
                                            <option value="<%=booktypeid%>" selected="selected">
                                              <%=booktype.getBooktypename()%>
                                                </option>
                                              <% }else{ %>
                                                <option value="<%=booktype.getBooktypeid()%>">
                                                    <%=booktype.getBooktypename()%>
                                                </option>
                                            <% } %>
                                        <% } %>
                                    	</select></td>
                                  </tr>
                                  <tr>
                                    <td height="50" align="center">作者：</td>
                                    <td><input name="author" type="text" value="<%=bookinfo.getAuthor() %>" /></td>
                                  </tr>
                                  <tr>
                                    <td height="50" align="center"> 价格：</td>
                                    <td><input name="price" type="text" value="<%=bookinfo.getPrice() %>" /></td>
                                  </tr>
                                  <tr>
                                    <td height="50" align="center"> ISBN：</td>
                                    <td>
                                      <input name="isb
                                      n" type="text" value="<%=bookinfo.getIsbn() %>" />
                                    </td>
                                  </tr>
                                  <tr>
                                    <td height="50" align="center"> 现存量：</td>
                                    <td>
                                      <input name="nownumber" type="text" value="<%=bookinfo.getNownumber() %>" />
                                    </td>
                                  </tr>
                                  <tr>
                                    <td height="50" align="center"> 总库存：</td>
                                    <td>
                                      <input name="total" type="text" value="<%=bookinfo.getTotal() %>" />
                                    </td>
                                  </tr>
                                  <tr>
                                    <td height="50" align="center"> 出版社：</td>
                                    <%-- <td>
                                      <input name="pubname" type="text" value="<%=bookinfo.getPubname() %>" />
                                    </td> --%>
                                    <td><select name="pubname" class="wenbenkuang">
                                    			<option value="<%=bookinfo.getPubname() %>" selected="selected"><%=bookinfo.getPubname() %></option>
                                    			<option disabled="disabled" value="">-请选择-</option>
                                              	<option value="清华大学出版社">清华大学出版社</option>
                                              	<option value="人民邮电出版社">人民邮电出版社</option>
                                              	<option value="北京理工大学出版社">北京理工大学出版社</option>
                                        </select></td>
                                  </tr>
                                  <tr>
                                    <td height="50" align="center"> 书架：</td>
                                    <%-- <td>
                                      <input name="pubname" type="text" value="<%=bookinfo.getPubname() %>" />
                                    </td> --%>
                                    <td><select name="casename" class="wenbenkuang">
                                    			<option value="<%=bookinfo.getCasename() %>" selected="selected"><%=bookinfo.getCasename() %></option>
                                    			<option disabled="disabled" value="">-请选择-</option>
                                              	<option value="TP">TP</option>
                                              <option value="CM">CM</option>
                                              <option value="B">B</option>                                     
                                            </select><br></td>
                                  </tr>
                                  <tr>
                                    <td height="35" align="center"><input name="Submit" type="submit" class="btn_grey"
                                        value="保存">
                                      &nbsp;
                                      <input name="Submit2" type="reset" class="btn_grey" value="重置">
                                      &nbsp;
                                      <input name="Submit3" type="button" class="btn_grey" onClick="window.close()"
                                        value="关闭">
                                    </td>
                                  </tr>
                                </table>
                              </form>
                          </td>
                        </tr>
                      </table>
                    </td>
                  </tr>
                </table>
              </td>
            </tr>
          </table>
          <%@ include file="copyright.jsp" %>
        </td>
      </tr>
    </table>
</body>

</html>
