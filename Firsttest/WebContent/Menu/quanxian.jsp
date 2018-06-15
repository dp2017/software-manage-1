<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看需求</title>
<script
	src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />
</head>
<body>
<c:if test="${param.modal==1}">
	<script language="javascript">
		$(function(){
			$("#mymodal").modal("toggle");
		});
	</script>
</c:if>
	<div class="row-fluid">
		<div class="col-md-1 "></div>
			<div class="col-md-10 ">
				<table class="table table-striped">
					<tr>
						<td>角色</td>
						<td>需求管理</td>
						<td>密码修改</td>
						<td>介绍</td>
						<td>审核</td>
						<td>需求查询</td>
						<td>权限管理</td>
						<td>图表统计</td>
						<td align="center" colspan="2">操作</td>
					</tr>
					
					<c:forEach items="${jueseBeans}" var="item" varStatus="status">
						<tr>
							<td>${item.age }</td>
							<td>${item.xuguan}</td>
							<td>${item.mima }</td>
							<td>${item.jieshao }</td>
							<td>${item.shenhe }</td>
							<td>${item.chaxun }</td>
							<td>${item.quanxian }</td>
							<td>${item.tubiao}</td>
							<td><a href="${pageContext.request.contextPath }/Menu/quanxian.jsp?modal=1&name=${item.age }">修改</a></td>
							<td><a href="#">删除</a></td>
							
						</tr>
					</c:forEach>
				</table>
			</div>
		<div class=" col-md-1"></div>
	</div>
	
	<div class="modal" id="mymodal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" id="close1"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title">权限修改</h4>
			</div>
			<div class="modal-body" >
				<form action="${pageContext.request.contextPath }/QuanxianServlet?method=update&name=${param.age }" method="post">
				<c:forEach items="${jueseBeans}" var="item" varStatus="status">
						<c:if test="${item.age == param.age}">
						
						<center><h4>${item.age }</h4><br>
						
							
					           需求管理：<c:if test="${item.xuguan==1 }"><input type="checkbox" name="quanxian" value="tianbao" checked="checked"></c:if>
							<c:if test="${item.xuguan==0 }"><input type="checkbox" name="quanxian" value="tianbao"></c:if><br>
						
						密码修改：<c:if test="${item.mima==1 }"><input type="checkbox" name="quanxian" value="shenhe" checked="checked"></c:if>
							<c:if test="${item.mima==0 }"><input type="checkbox" name="quanxian" value="shenhe"></c:if><br>
						
						系统介绍：<c:if test="${item.jieshao==1 }"><input type="checkbox" name="quanxian" value="liulan" checked="checked"></c:if>
							<c:if test="${item.jieshao==0 }"><input type="checkbox" name="quanxian" value="liulan"></c:if><br>
						
						系统审核：<c:if test="${item.shenhe==1 }"><input type="checkbox" name="quanxian" value="chaxun" checked="checked"></c:if>
							<c:if test="${item.shenhe==0 }"><input type="checkbox" name="quanxian" value="chaxun"></c:if><br>
						
						查询：<c:if test="${item.chaxun==1 }"><input type="checkbox" name="quanxian" value="xiugaimima" checked="checked"></c:if>
							<c:if test="${item.chaxun==0 }"><input type="checkbox" name="quanxian" value="xiugaimima"></c:if><br>
						
						权限管理：<c:if test="${item.quanxian==1 }"><input type="checkbox" name="quanxian" value="gerenxinxi" checked="checked"></c:if>
							<c:if test="${item.quanxian==0 }"><input type="checkbox" name="quanxian" value="gerenxinxi"></c:if><br>
						
						图表管理：<c:if test="${item.tubiao==1 }"><input type="checkbox" name="quanxian" value="quanxianguanli" checked="checked"></c:if>
							<c:if test="${item.tubiao==0 }"><input type="checkbox" name="quanxian" value="quanxianguanli"></c:if><br>
						</center>
							<td></td>
							<%-- <td>${item.tianbao }</td>
							<td>${item.shenhe }</td>
							<td>${item.liulan }</td>
							<td>${item.chaxun }</td>
							<td>${item.xiugaimima }</td>
							<td>${item.gerenxinxi }</td>
							<td>${item.quanxianguanli }</td>
							<td>${item.yonghuguanli }</td>
							<td>${item.tongji }</td> --%>
						</c:if>
					</c:forEach>
					<br><br><br>
				<center><button style="width:100px ;height:30px;"class='btn btn-primary btn-block'>确定</button></center>
				</form>
				
			</div>
			
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</body>
</html>