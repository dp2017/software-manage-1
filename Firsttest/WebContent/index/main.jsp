<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />
</head>

	<frameset frameborder="no" rows="85px,*">
		<frame src="${pageContext.request.contextPath}/index/head.jsp" />	
		<frameset cols="150px,*">
			<frameset  rows="300px,*">
			<frame src="${pageContext.request.contextPath}/index/left.jsp" />
			<frame src="${pageContext.request.contextPath}/index/jsp/index.jsp" />
			</frameset>
			<frameset rows="40px,*">
			<frame src="${pageContext.request.contextPath }/index/time.jsp" />
			<frame name="mainAction" />
			</frameset>
		</frameset>
	</frameset>
</html>