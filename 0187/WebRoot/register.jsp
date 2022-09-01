<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册界面</title>
   <script type="text/javascript"  src="JS/jquery-1.7.2.js"></script>
    <script type="text/javascript">
    $(function(){
    
		$("#uname").blur(function(){
		var uname = $(this).val();
		if(uname == null || uname==""){
		$("#unameinfo").text("姓名不能为空").css("color","red");
		}else{
		
				$("#unameinfo").text("✔").css("color","green");
				}
		});
		
		$("#nname").blur(function(){
		var nname = $(this).val();
		if(nname == null || nname ==""){
			$("#nnameinfo").text("用户名不能为空").css("color","red");
		}else{
			$("#nnameinfo").text("✔").css("color","green");
		}
		});
		
		$("#address").blur(function(){
			var address = $(this).val();
			if(address == null || address == ""){
				$("#addressinfo").text("地址不能为空").css("color","red");
			}else{
				$("#addressinfo").text("✔").css("color","green");
			}
		});
		
		$("#phone").blur(function(){
			var phone = $(this).val();
			if(!(/^1[3456789]\d{9}$/.test(phone))){
				$("#phoneInfo").text("手机号码格式不正确").css("color", "red");
	       		$(this).focus();//输入错误，重新输入
			}else{
				$("#phoneInfo").text("✔").css("color", "green");
				
			}
		});
		$("#postBtn").click(function(){
						// post请求
						var phone = $("#phone").val();
						$.post("TestServlet",{phone:phone},function (data) {
							$("#phoneInfo").html("验证码发送成功");
						},"text");
						
						});
					
	});
		</script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  <link rel="stylesheet" type="text/css" href="./css/login.css">
  <body>
  <div class="title">
		<p>注册信息表</p>
	</div>
  <div align="center"  id="index">
  <form method="post" action="RegisterServlet">
		<table >
		<tr>
			<td>
				真实姓名
			</td>
			<td>
				<input name="username"  id="uname" type="text" ><span id="unameinfo"></span>
			</td>
		</tr>
			<tr>
				<td>
					用户名
				</td>
				<td>
					<input type="text" id="nname" name="nickname"/><span id="nnameinfo"></span>
				</td>
			</tr>
			<tr>
				<td>
					密码
				</td>
				<td>
					<input type="password" name="password" />
				</td>
			</tr>
			<tr>
				<td>
					性别
				</td>
				<td>
					<input type="radio" name="sex" checked="checked" value="boy" />boy
					<input type="radio" name="sex"  value="girl" />girl
				</td>
			</tr>
			<tr>
				<td>
					地址
				</td>
				<td>
					<textarea name="address" id="address"></textarea><span id="addressinfo"></span>
				</td>
			</tr>
			<tr>
			<td>
			手机号
			</td>
			<td>
			<input type="text" name="phone" id="phone"> <input type="button" value="提交" id="postBtn">
			<span id="phoneInfo"></span>
			</td>
			</tr>
			<tr>
				<td>验证码</td>
				<td><input type="text" name="code">
				</td>
			</tr>
			<tr>
				<td>
					用户类别
				</td>
				<td>
					<input  type="checkbox" name="lim" value="2" checked="checked">普通用户
				</td>
			</tr>
			<tr>
				<td>
					<input id="btn_login" type="reset" value="重置" style="width: 91px; height: 35px"/>
				</td>
				<td>
					<input id="btn_login" type="submit" value="注册" style="width: 102px; height: 34px"/>
				</td>
			</tr>
		</table>
		</form>
		</div>
  </body>
</html>
