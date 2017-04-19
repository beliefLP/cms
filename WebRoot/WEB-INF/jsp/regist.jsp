<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.4.4.min.js">
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/regist.js">
</script>
</head>
<body>
	<div>
		<div>
			<h3>用户注册</h3>
		</div>
		<div>
			<form action="${pageContext.request.contextPath }/registUser.action" method="post" id="registForm">
				<table id="tableForm">
					<tr>
						<td>用户名：</td>
						<td>
							<input class="inputClass" type="text" name="username" id="username"/>
							<span id="username_msg"></span>
						</td>
					</tr>
					<tr>
						<td>登录密码：</td>
						<td>
							<input class="inputClass" type="password" name="password" id="password"/>
							<span id="password_msg"></span>
						</td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td>
							<input class="inputClass" type="password" name="confirmPass" id="confirmPass"/>
							<span id="confirmPass_msg"></span>
						</td>
					</tr>
				</table>
				<input type="button" id="regist" value="注册"/><br/>
				<a href="${pageContext.request.contextPath }/doLogin.action">使用已有账号登录</a>
			</form>
		</div>
	</div>
</body>
</html>