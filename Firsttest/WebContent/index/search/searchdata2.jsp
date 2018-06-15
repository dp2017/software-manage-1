<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />
<link href="${pageContext.request.contextPath}/index/search/123_files/magsearch.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/index/search/123_files/adv.css" type="text/css" rel="stylesheet">
<title></title>
<script type="text/javascript">
	function show() {
		//alert(document.getElementById("div").style.display)
		for (id = 2; id < 6; id++) {
			if (document.getElementById(id).style.display == "none") {
				document.getElementById(id).style.display = "";
				document.getElementById("i").value = id;
				break;
			}
		}
	}
	function notshow() {
		for (id = 5; id >= 1; id--) {
			if (document.getElementById(id).style.display == "") {
				document.getElementById(id).style.display = "none";
				document.getElementById("i").value = id - 1;
				break;
			}
		}
	}
</script>
</head>

<body>
<style type="text/css">
td {font-weight:bold;}
</style>
	<script
		src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js"
		type="text/javascript"></script>

	<form
		action="${pageContext.request.contextPath }/shenheServlet?method=checklist"
		id="form1" method="post">
     <input type="hidden" name="i" id="i" value=1>
		<div class="sFormBox" style="width:600px;  position:relative; left:-80px;">
			<div class="sFormTit">
				<ul>
					<li id="firstAdvId" class="cur"><a id="showorhideAdvId">高级检索</a></li>
				</ul>
				<div class="clearfix"></div>
			</div>

			<div class="sForm_exact"  style="float: none; margin: 0 auto;">
				<div style="font-size:18px" id="advDivId" class="highSearch">
					<div style="margin-bottom: 12px">
						<p style="margin-bottom: 12px">输入检索条件：</p>
						时效状态： <select name="shenhe" id="shenhe">
							<option value="1">已审核</option>
							<option value="0">未审核</option>
						</select>
						 <select name="tongguo" id="shengguo">
							<option value="1">已通过</option>
							<option value="0">未通过</option>
						</select>
					</div>
					<div class="searchForm"  style="" >
						<div id="1" style="margin-bottom: 12px">
						<select name="han1" id="">
								<option value="and">并含</option>
								<option value="or">包含</option>
								<option value="NOT">不含</option>
							</select>
							->检索类型： <select name="leixing1" id="leixing1">
								<option value="xuming">需求名称</option>
								<option value="theme">主要问题</option>
								<option value="key1">关键字</option>
								<option value="firstSubjects">学科分类</option>
							</select> :<input style="" name="inputlx1" id="han1" />  <!-- input style="" name="inputh1" id="" /--><select name="jingmo1"id="">
								<option value="=">精确</option>
								<option value="like">模糊</option>
							</select> <input id="tianjia" type="button" onclick="show()" value="添加"></input>
							<input id="shanchu" type="button" onclick="notshow()" value="删除"></input>
						</div>
						<div id="2" style="display: none; margin-bottom: 12px">
						<select name="han2" id="">
								<option value="and">并含</option>
								<option value="or">包含</option>
								<option value="NOT">不含</option>
							</select>
							->检索类型： <select name="leixing2" id="">
								<option value="xuming">需求名称</option>
								<option value="theme">主要问题</option>
								<option value="key1">关键字</option>
								<option value="firstSubjects">学科分类</option>
							</select> :<input style="" name="inputlx2" id="" />  <!-- input style="" name="inputh2" id="" /--><select name="jingmo2" id="">
								<option value="=">精确</option>
								<option value="like">模糊</option>
							</select>
						</div>
						<div id="3" style="display: none; margin-bottom: 12px"><select name="han3" id="">
								<option value="and">并含</option>
								<option value="or">包含</option>
								<option value="NOT">不含</option>
							</select>
							->检索类型： <select name="leixing3" id="">
								<option value="xuming">需求名称</option>
								<option value="theme">主要问题</option>
								<option value="key1">关键字</option>
								<option value="firstSubjects">学科分类</option>
							</select> :<input style="" name="inputlx3" id="" />  <!-- input style="" name="inputh3" id="" /--><select name="jingmo3" id="">
								<option value="=">精确</option>
								<option value="like">模糊</option>
							</select>
						</div>
						<div id="4" style="display: none; margin-bottom: 12px">
						<select name="han4" id="">
								<option value="and">并含</option>
								<option value="or">包含</option>
								<option value="NOT">不含</option>
							</select>
							->检索类型： <select name="leixing4" id="">
								<option value="xuming">需求名称</option>
								<option value="theme">主要问题</option>
								<option value="key1">关键字</option>
								<option value="firstSubjects">学科分类</option>
							</select> :<input style="" name="inputlx4" id="" />  <!-- input style="" name="inputh4" id="" /--><select name="jingmo4" id="">
								<option value="=">精确</option>
								<option value="like">模糊</option>
							</select>
						</div>
						<div id="5" style="display: none; margin-bottom: 12px">
						 <select name="han5" id="">
								<option value="and">并含</option>
								<option value="or">包含</option>
								<option value="NOT">不含</option>
							</select> 
							->检索类型： <select name="leixing5" id="">
								<option value="xuming">需求名称</option>
								<option value="theme">主要问题</option>
								<option value="key1">关键字</option>
								<option value="firstSubjects">学科分类</option>
							</select> :<input style="" name="inputlx5" id="" /><!-- input style="" name="inputh5" id="" /--><select name="jingmo5" id="">
								<option value="=">精确</option>
								<option value="like">模糊</option>
							</select>
						</div>
					</div>
				</div>
				<div class="Btn">
					<input type="submit"  style="margin-left: 600px;"class="highBtn" value="高级搜索">
				</div>
			</div>
		</div>
	</form>

	<div class="container-fluid">
		<div class="row-fluid">
			<c:if test="${adminBeans!=null}">
				<div class="col-md-10 col-md-offset-1">
					<table class="table">
						<tr>
							<td>序号</td>
							<td>需求名称</a></td>
							<td>机构全称</td>
							<td>填报时间</td>
							<td  style="padding-left:1cm;">状态</td>
							<td  style="padding-left:0.4cm;">操     作</td>
						</tr>
						<c:forEach items="${adminBeans }" var="item" varStatus="status">
							<tr>
								<!-- td><a
									href="${pageContext.request.contextPath}/userServlet?method=listDetails&id=${item.username }">${item.username }</a></td-->
								<td>${status.index+1}</td>
					            <td><a href="${pageContext.request.contextPath}/xuqiuServlet?method=listxu&id=${item.id }">${item.xuming}</td>
								<td>${item.name }</td>
								<td>${item.createDate }</td>
								<td> 
								<c:if test="${item.status.equals('1') }">
								   已审核 
								</c:if>
								<c:if test="${item.status.equals('0') }">
								   未审核 
								</c:if>
								<c:if test="${item.pass.equals('1') }">
								  已通过 
								</c:if>
								<c:if test="${item.pass.equals('0') }">
								   未通过
								</c:if>
								</td>							
								<td style="font-color:#123456">
								<a href="${pageContext.request.contextPath}/xuqiuServlet?method=listxu&button=chakan&id=${item.id }"><font size="3" color="red"><font size="3" color="red">&nbsp;审核</font></a></td>
						
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>
		</div>
		<div class="row-fluid">
			<div class="col-md-12">
				<c:if test="${param.status.equals('2')}">
					<div class="alert alert-success" role="alert">删除成功</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>