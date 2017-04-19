<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.4.4.min.js">
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/login.js">
</script>
</head>

<body>
	<div>
		<div><h3>登录</h3></div>
		<div>
			<form action="${pageContext.request.contextPath }/login.action" method="post" id="loginForm">
				<table>
					<tr>
						<td width="50">用户名</td>
						<td>
							<input class="input" type="text" name="username" id="username" />
							<span id="username_msg"></span>
						</td>
					</tr>
					<tr>
						<td>密 码</td>
						<td>
							<input class="input" type="password" name="password" id="password"/>
							<span id="password_msg"></span>
						</td>
					</tr>
				</table>
				<input type="button" id="login" value="登录"/>
				<a href="${pageContext.request.contextPath }/doRegist.action"><input type="button" value="注册"/></a>
			</form>
		</div>
	</div>
</body>
</html>
