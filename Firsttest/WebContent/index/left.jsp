<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	font-size: 12px;
	font-family: "Microsoft Yahei", Verdana, Arial, Helvetica, scans-serif
}

.leftMenu {
	min-width: 150px;
	width: 150px;
	margin: 40px auto 0 auto;
}

.menu {
	border: #bdd7f2 1px solid;
	border-top: #0080c4 4px solid;
	border-bottom: #0080c4 4px solid;
	background: #f4f9ff repeat-y right;
	margin-left: 10px;
}

.menu .ListTitle {
	border-bottom: 1px #98c9ee solid;
	display: block;
	text-align: center;
	/* 		position:relative; */
	height: 38px;
	line-height: 38px;
	cursor: pointer;
	/* 		+min-width:220px; */ +
	min-width: 220px;
}

.ListTitlePanel {
	position: relative;
}

.leftbgbt {
	position: absolute;
	background: no-repeat;
	width: 11px;
	height: 52px;
	left: -11px;
	top: -4px;
}

.leftbgbt2 {
	position: absolute;
	background: no-repeat;
	width: 11px;
	height: 49px;
	left: -11px;
	top: -1px;
}

.menuList {
	display: block;
	height: auto;
}

.menuList div {
	height: 28px;
	line-height: 24px;
	border-bottom: 1px #98c9ee botted;
}

.menuList div a {
	display: block;
	background: #ccffff;
	line-height: 28px;
	height: 28px;
	text-align: center;
	color: #185698;
	text-decoration: none;
}

.menuList div a:hover {
	color: #f30;
	background: #0080c4;
	color: #fff;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<script type="text/javascript">
	// 不明白
	$(document).ready(
			function() {
				var menuParent = $('.menu > .ListTitlePanel > div');//获取menu下的父层div
				var menuList = $('.menuList');
				$('.menu > .menuParent > .ListTitlePanel > .ListTitle').each(
						function(i) {
							$(this).click(function() {
								if ($(menuList[i]).css('display') == 'none') {
									$(menuList[i]).slideDown(300);
								} else {
									$(menuList[i]).slideUp(300);
								}
							});
						});
			});
</script>
</head>

<body style="margin-top: -43px;margin-left: -7px">

	<div class="leftMenu">
		<div class="menu">
			<div class="menuParent" setVisible(true)>
				<div class="ListTitlePanel">
					<div class="ListTitle" style="height: 34px; background-color: #44A2EF">
						<strong >系统菜单</strong>
						<div class="leftbgbt"></div>
					</div>
				</div>
				<div class="menuList">
					
					
					<c:if test="${power.age == 0}">
					<div>
						<a target="mainAction"
							href="${pageContext.request.contextPath }/index/CreateDemand.jsp">需求填报</a>
					</div>
		            </c:if>
					
					<c:if test="${power.shenhe == 1}">
					<div >
						<a target="mainAction"
							href="${pageContext.request.contextPath }/shenheServlet?method=shenhe">审核统计
						</a>
					</div>
					</c:if>
					
					
					<c:if test="${power.xuguan == 1}">
					<div >
						<a target="mainAction"
							href="${pageContext.request.contextPath }/xuqiuServlet?method=list">需求管理
						</a>
					</div>
					</c:if>
					
					
					<c:if test="${power.tubiao == 1}">
					<div>
						<a target="mainAction"
							href="${pageContext.request.contextPath }/Rxuqiu/jsp/index.html">生成图表</a>
					</div>
					</c:if>
					
					
					<c:if test="${power.quanxian == 1}">
					<div>
						<a target="mainAction"
							href="${pageContext.request.contextPath }/QuanxianServlet?method=list">权限管理
						</a>
					</div>
					</c:if>
					
					<c:if test="${power.mima == 1}">
					<div>
						<a target="mainAction"
							href="${pageContext.request.contextPath}/index/User/updatepassword.jsp">修改密码</a>
							
					</div>
					</c:if>
					
					<c:if test="${power.jieshao == 1}">
					<div>
						<a target="mainAction"
							href="${pageContext.request.contextPath }/index/xtjs.html">系统介绍
						</a>
					</div>
					</c:if>
					
					
					<div>
						<a 
							href="${pageContext.request.contextPath }/login/login.jsp">安全退出</a>
					</div>				
				</div>
			</div>


		
			
		</div>
	</div>
	<div style="text-align: center"></div>
</body>
</html>