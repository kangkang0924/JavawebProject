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
    
    <title>添加读者档案信息</title>
    
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
<%@ include file="banner.jsp"%>
   <table width="778"  border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：读者管理 &gt; 读者档案管理 &gt; 添加读者信息 &gt;&gt;&gt;</td>
      </tr>
      <tr>
         <td align="center" valign="top"><table width="100%" height="493"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top">
	<form name="form1" method="post" action="ReaderInfoAddServlet">
	<table width="600" height="432"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
	   <tr>
        <td align="center">读者编号：</td>
        <td height="39"><input name="readerid" type="text" id="readerid" size="50">
          * </td>
      </tr>   
      <tr>
        <td align="center">读者类型：</td>
        <td>
			<select name="readertypeid" class="wenbenkuang" id="readertypeid">
			<option disabled="disabled" value="">-请选择-</option>
			<%
			   /* ArrayList allBookType=(ArrayList)session.getAttribute("allBookType"); */
			   
			   
			   
			   
			   ArrayList<ReaderType> allReaderType=DAOFactory.getReaderTypeDAOInstance().findAllReaderType();
			   for(int i=0;i<allReaderType.size();i++){
			    ReaderType readertype=(ReaderType)allReaderType.get(i);
			 %>
                <option value="<%=readertype.getReadertypeid()%>">
                    <%=readertype.getReadertypename()%>
                </option>
        	<% } %>
             </select>
        </td>
      </tr>
      <tr>
        <td align="center">读者名称：</td>
        <td height="39"><input name="readername" type="text" id="readername" size="50">
          * </td>
      </tr>
      <tr>
        <td align="center">身份证：</td>
        <td><input name="idcard" type="text"  id="idcard" size="40"> * </td>
      </tr>
    	<tr>
        <td align="center">已借数量：</td>
        <td><input name="borrownumber" type="text" id="borrownumber">(元) * </td>
      </tr>
      <tr>
        <td align="center">&nbsp;</td>
        <td><input name="Submit" type="submit" class="btn_grey" value="保存" onClick="return check(form1)">
&nbsp;
<input name="Submit2" type="button" class="btn_grey" value="返回" onClick="history.back()"></td>
      </tr>
    </table>
	</form>
	</td>
  </tr>
</table></td>
      </tr>
    </table>
</td>
  </tr>
</table><%@ include file="copyright.jsp"%></td>
  </tr>
</table>
  </body>
</html>
