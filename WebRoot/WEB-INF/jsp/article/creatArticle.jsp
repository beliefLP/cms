<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function queryArticle(){
	document.createArticle.action = "${pageContext.request.contextPath }/details/queryArticle.action";
	document.createArticle.submit();
}
function doCreate(){
	document.createArticle.action = "${pageContext.request.contextPath }/details/doCreate.action";
	document.createArticle.submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建文章</title>
</head>
<body>
	<div style="float: right">
		<c:if test="${username!=null }">
			用户: ${username } 
		</c:if>
		<a href="${pageContext.request.contextPath }/logout.action">登出</a>
	</div>
	<form name="createArticle" action="${pageContext.request.contextPath }/details/createArticle.action?id=${article.id }" method="post">
		<button type="submit" onclick="queryArticle()">查看文章</button>
		<button type="submit" onclick="doCreate()">创建文章</button><br/>
		<span>文章标题</span> <input type="text" name="title" value="${article.title }"/> <br> 
		<span>副标题</span>  <input type="text" name="subTitle" value="${article.subTitle }"/>
		<!-- 加载编辑器的容器 -->
		<script id="container" name="content"  style="width:800px;height:500px;" 
			type="text/plain">${article.content }</script>
		<button type="submit">提交</button>
	</form>
	
	
	<!-- 配置文件 -->
	<script type="text/javascript" src="../ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript" src="../ueditor.all.js"></script>
	<!-- 实例化编辑器 -->
	<script type="text/javascript">
        var editor = UE.getEditor('container');
        //editor.setHeight(1024);
        
        function getContent(){
        	var ue = UE.getEditor('container')
    	      //对编辑器的操作最好在编辑器ready之后再做
    	      ue.ready(function() {
    	          //设置编辑器的内容
    	          ue.setContent('hello');
    	          //获取html内容，返回: <p>hello</p>
    	          var html = ue.getContent();
    	          //获取纯文本内容，返回: hello
    	          var txt = ue.getContentTxt();
    	          alert(txt);
    	      });
        }
        
    </script>
</body>
</html>