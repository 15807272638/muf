<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/common/sub_header.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!doctype html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>后台管理</title>
	<link rel="stylesheet" href="/css/main.css" type="text/css">
</head>
<body>

<jsp:include page="/top.jsp"></jsp:include>
<div class="container clearfix">

	<jsp:include page="/left.jsp"></jsp:include>
	<!--/sidebar-->
	<div class="main-wrap">
		<div class="crumb-wrap">
			<div class="crumb-list">
				<i class="icon-font">&#xe06b;</i><span>欢迎使用管理系统。</span>
			</div>
		</div>

		<div class="result-wrap">
			<div class="result-title">
				<h1>
					系统基本信息
				</h1>
			</div>
			<div class="result-content">
				<ul class="sys-info-list">
					<li>
						<label class="res-lab">
							操作系统
						</label>
						<span class="res-info">WINNT</span>
					</li>
					<li>
						<label class="res-lab">
							运行环境
						</label>
						<span class="res-info">Apache Tomcat</span>
					</li>

					<li>
						<label class="res-lab">
							版本
						</label>
						<span class="res-info">v-0.1</span>
					</li>

					<li>
						<label class="res-lab">
							北京时间
						</label>
						<%
							request.setAttribute("nowtime",new Date());
						%>
						<span class="res-info"><fmt:formatDate value="${requestScope.nowtime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate> </span>
					</li>
					<li>
						<label class="res-lab">
							服务器域名/IP
						</label>
						<span class="res-info"><%=request.getRemoteAddr()%></span>
					</li>
					<li>
						<label class="res-lab">
							Host
						</label>
						<span class="res-info"><%=request.getRemoteHost()%></span>
					</li>
					<li>
						<label class="res-lab">
							技术支持
						</label>
						<span class="res-info"><a href="https://www.guazi.com/dl/" target="_blank">停车管理系统</a></span>
					</li>
				</ul>
			</div>
		</div>

	</div>
	<!--/main-->
</div>
</body>
</html>