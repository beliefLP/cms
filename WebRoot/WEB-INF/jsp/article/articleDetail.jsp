<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章详情</title>
</head>
<body>
	<div style="float: right">
		<c:if test="${username!=null }">
			用户: ${username } 
		</c:if>
		<a href="${pageContext.request.contextPath }/logout.action">登出</a>
	</div><br/>
		<form
			action="${pageContext.request.contextPath }/details/doCreate.action?id=${article.id }"
			method="post">
			<div style="text-align: center">
				<h1>${article.title }</h1>
			</div>
			<div style="text-align: center; color: #999">${article.timeDifference }</div>
			<div style="text-align: center; color: #999">
				<h3>${article.subTitle }</h3>
			</div>
			<div>${article.content }</div>
			<button type="submit">编辑文章</button>
		</form>
</body>
</html>