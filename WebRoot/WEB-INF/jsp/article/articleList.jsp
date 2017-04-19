<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询文章列表</title>
<style type="text/css">
.kr_article_list ul li .inner_li {
	border-top-left-radius: 2px;
	border-bottom-left-radius: 2px;
	border-top-right-radius: 2px;
	border-bottom-right-radius: 2px;
	height: 9.5rem;
	overflow: hidden;
	padding: 1rem 10;
	position: relative;
	width: 700px;
}

a {
	color: #366df0;
	-webkit-transition: all .2s ease;
	transition: all .2s ease;
	text-decoration: none;
	cursor: pointer;
}

.kr_article_list ul {
	margin-bottom: 0;
}

ul {
	list-style: none;
	padding: 10px 5px 15px 50px;
}

.kr_article_list .img_box {
	float: left;
	width: 13rem;
	height: 7.5rem;
	background-color: #c3c3c3;
	position: relative;
	overflow: hidden;
}

.kr_article_list .img_box img {
	width: 100%;
	height: 100%;
}

.kr_article_list .intro {
	margin-left: 14rem;
	font-size: .65rem;
	line-height: 1.5;
	word-break: break-all;
	color: #828a92;
	height: 100%;
	position: relative;
}

.kr_article_list .intro h3 {
	font-size: 1.5rem;
	max-height: 2.8em;
	font-weight: 600;
	margin-bottom: .25rem;
	line-height: 1.4em;
	color: #3d464d;
	display: block;
	overflow: hidden;
	text-overflow: ellipsis;
	-webkit-box-orient: vertical;
	display: -webkit-box;
	-webkit-line-clamp: 2;
}

h3 {
	margin: 0 0 1.6rem;
	font-weight: 600;
	font-size: 100%;
}

.kr_article_list .intro .abstract {
	position: relative;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 3;
	overflow: hidden;
	line-height: 1.1rem;
	max-height: 3.3rem;
	font-size: .8rem;
}

.kr_article_list .info {
	font-size: .8rem;
	word-break: break-all;
	color: #828a92;
	position: absolute;
	line-height: 1.2;
	vertical-align: middle;
	bottom: 1rem;
	width: 100%;
	padding-left: 14rem;
}

.kr_article_list .info .time-div {
	vertical-align: middle;
	display: inline-block;
	margin-top: -40px;
}
</style>
</head>
<body>
	<div style="float: right">
		<c:if test="${username!=null }">
			用户: ${username } 
		</c:if>
		<a href="${pageContext.request.contextPath }/logout.action">登出</a>
	</div>
	<div>
		<div class="kr_article_list">
			<div>
				<ul class="feed_ul">
					<c:forEach items="${articleList}" var="article">
						<li>
							<div class="am-cf inner_li inner_li_abtest">
								<a
									href="${pageContext.request.contextPath }/details/articleDetail.action?id=${article.id}"  target="_blank">
									<div class="img_box">
										<div
											href="${pageContext.request.contextPath }/details/articleDetail.action?id=${article.id}"
											target="_blank">
											<img alt="${article.title}" class="load-img fade"
												src="${article.picPath}" width=260 height=150>
										</div>
									</div>
									<div class="intro">
										<h3>${article.title}</h3>
										<div class="abstract">${article.subTitle}</div>
									</div>
								</a>
								<div class="info">
									<div class="info-list info-list-abtest">
										<div class="time-div">
											<span title="2017-04-11 20:46">
												${article.timeDifference} </span>
										</div>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>