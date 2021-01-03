<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
   String path = request.getContextPath();
 %>

<div class="topbar-wrap white">
			<div class="topbar-inner clearfix">
				<div class="topbar-logo-wrap clearfix">
					
					<a class="on" href="#">停车场管理系统</a>
				</div>
				<div class="top-info-wrap">
					<ul class="top-info-list clearfix">
						
						<li>
							<c:url value="/loginout.jsp" var="url" scope="page" context="/Practical"></c:url>
							<a href="${url}">退出</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
