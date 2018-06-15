<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="java.util.*,com.dbEntity.Subjects,com.dbEntity.NationalEconomy"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>需求征集表显示</title>
<link rel="stylesheet" type="text/css" href="css/CreateDemand.css" />
<script type="text/javascript" src="../js/CreateDemand.js">
	
</script>
<style type="text/css">
html, body, div, li, form, input, th, td {
	margin: 0;
	padding: 0;
	font-family: 楷体;
	font-size: 100%;
}

ul, ol, li {
	list-style: none;
}

a:link, a:visited {
	color: #FF00FF;
	text-decoration: none;
}

a:hover {
	color: #12b7f5;
}

table {
	border-collapse: collapse;
	border: none;
	margin: 60px auto;
	width: 800px;
}

th, td {
	border: Groove #000000 2px;
	height: 20px;
	margin-bottom: 12px;
	line-height: 25px;
	opacity: 1.0;
}

div, td {
	text-align: left;
}
</style>
</head>
<script>
	alert(xuqiuBean.Name);
</script>
<body style="background-color: #E0F0F8;">

	
		<center>

			<table class="table" border="1" cellpadding="10">
				<caption>
					<h2>技术需求申请表</h2>
				</caption>

				<tr>
					<td colspan="1">*机构全称</td>
					<td colspan="2" style="font-weight:bold">${xuqiubean.name}</td>
						<td colspan="1">归口管理部门</td>
					<td colspan="2"style="font-weight:bold">${xuqiubean.gguan}</td>
				</tr>
				<tr>
					<td>*通讯地址</td>
					<td colspan="2"style="font-weight:bold">${xuqiubean.address}</td>
					<td>*所在地域</td>
					<td colspan="2"style="font-weight:bold">${xuqiubean.saddress}</td>
				</tr>
				<tr class='tr1'>
					<td colspan="1">*网址</td>
					<td colspan="2"style="font-weight:bold">${xuqiubean.web}</td>
					<td>电子邮箱</td>
					<td colspan="2"style="font-weight:bold">${xuqiubean.email}</td>
				</tr>
				<tr>
					<td>*法人代表</td>
					<td style="font-weight:bold">${xuqiubean.represent}</td>
					<td >邮政编码</td>
					<td colspan="2"style="font-weight:bold">${xuqiubean.zipcode}</td>
				</tr>
				<tr>
					<td rowspan="2">*联系人</td>
					<td rowspan="2"style="font-weight:bold">${xuqiubean.lianxiren}</td>
					<td>电话</td>
					<td colspan="5"style="font-weight:bold">1、 固定:${xuqiubean.phone}<br>
						2、 手机:${xuqiubean.telephone}</td>
				</tr>
				<tr>

					<td>传真</td>
					<td colspan="5"style="font-weight:bold">${xuqiubean.chuanzhen}</td>
				</tr>
				<tr>
					<td>机构属性</td>
					<td colspan="5"style="font-weight:bold">${xuqiubean.shuxing}</td>
				</tr>
				<tr class="tr2">
					<td class="td5" colspan="5">1、机构简介(需要解决的重大技术问题，限500字以内)</td>
					
				</tr>
				<tr class="tr3">
					<td colspan="5"style="font-weight:bold">${xuqiubean.jianjie}</td>
				</tr>
				<tr>
					<td width="170">*技术需求名称</td>
					<td style="font-weight:bold">${xuqiubean.xuming}</td>
					<td width="100">需求时限</td>
					<td colspan="5"><input type="date" name="xushi"
						id="StartTime" onchange="isValidityYear()">年至<input
						type="date" name="xushi" id="EndTime" onchange="isValidityYear()"></td>
				</tr>
				<tr class="tr1">
					<td colspan="5">*重大科技需求概述</td>
				</tr>
				<tr class="tr2">
					<td class="td5" colspan="5">1、主要问题(需要解决的重大技术问题，限500字以内)</td>
				
				</tr>

				<tr class="tr3">
					<td colspan="5" style="font-weight:bold">${xuqiubean.them}</td>
				</tr>



				<tr>
					<td>投入资金额:</td>
					<td colspan="5"style="font-weight:bold">${xuqiubean.money}万元</td>
				  
				<tr>
					<td>关键字:</td>
					<td colspan="4"style="font-weight:bold">${xuqiubean.key1}</td>
				</tr>

				
				<tr>
					<td class="td1">研究类型</td>
					<td colspan="4" id="type"style="font-weight:bold">${xuqiubean.type}</td>
				</tr>
				
				<tr>
					<td class="td1">*技术需求解决方式</td>
					<td colspan="4"style="font-weight:bold">${xuqiubean.model}
					</td>
				</tr>
				
				<c:if test="${xuqiubean.type.equals('基础研究')}">
				<tr id="sub">
					<td class="td1">学科分类代码</td>
					<td colspan="4"style="font-weight:bold">${xuqiubean.firstSubjects}</td>
				</tr>
				</c:if>
			
				
				<tr>
				
				<c:if test="${xuqiubean.type!=基础研究}">
				<tr id="servics" >
					<td class="td1">需求技术所属领域</td>
					<td colspan="4"style="font-weight:bold">${xuqiubean.servic}</td>
				</tr>
				<tr id="industry" >
					<td id="td1">需求技术应用行业</td>
					<td colspan="4"style="font-weight:bold">${xuqiubean.firstlndustry}</td>
				</tr>
                </c:if>
				<tr>
					<td colspan="5" style="text-decoration: none;
					text-align:center;
					width: 100px;
					 height: 30px; 
					font-size: 20px;
					font-weight:bold">
						<a target="mainAction"  style="color:black;"
							href="${pageContext.request.contextPath }/xuqiuServlet?method=pass&&status=1&&pass=1&&id=${xuqiubean.id}">通过
						</a>
						<a target="mainAction"  style="color:black;"
							href="${pageContext.request.contextPath }/xuqiuServlet?method=pass&&status=1&&pass=0&&id=${xuqiubean.id}">不通过
						</a>
						
						
					</td>
					
					
				
					
				</tr>
						<tr>
					<td colspan="5" style="text-decoration: none;
					text-align:center;
					width: 100px;
					 height: 30px; 
					font-size: 20px;
					font-weight:bold">
						<a target="mainAction"  style="color:black;"
							href="${pageContext.request.contextPath }/xuqiuServlet?method=list">返回
						</a>
					</td>
				</tr>
			</table>

		</center>



	<div>
		<c:if test="${param.status == 1}">
			<script type="text/javascript">
				alert("提交成功");
			</script>
		</c:if>

		<c:if test="${param.status == 2}">
			<script type="text/javascript">
				alert("提交失败");
			</script>
		</c:if>
	</div>
	<script src="${pageContext.request.contextPath}/js/address.js"
		type="text/javascript"></script>
</body>
</html>