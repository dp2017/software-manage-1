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
<script src="${pageContext.request.contextPath}/static/js/showdate.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />
</head>
 <style>
    .icoFontlist:hover  
    {  
        width: 100px; 
        border: 0px solid #ddd;  
        overflow: hidden;  
        text-align: left;  
        text-overflow: ellipsis;  
        white-space: nowrap;  
        cursor:pointer;   
    }  
    .icoFontlist{  
        width: 100px;   
        border: 0px solid #ddd;  
        color:#5f5f5f;  
        overflow: hidden;  
        text-align: left;  
        text-overflow: ellipsis;  
        white-space: nowrap;  
    }  
</style>
<script type="text/javascript">
function show(){
	//alert(document.getElementById("div").style.display)
	for(id=1;id<6;id++){
		if(document.getElementById(id).style.display=="none"){
			document.getElementById(id).style.display="";
			document.getElementById("i").value=id;
			break;
		}
	}
}
function notshow(){
	for(id=5;id>0;id--){
		if(document.getElementById(id).style.display==""){
			document.getElementById(id).style.display="none";
			document.getElementById("i").value=id-1;
			break;
		}
	}
}
</script>
<body>
<form action="${pageContext.request.contextPath }/XuqiuServlet?method=select&username=${userBean.name }" method="post">
	<input type="hidden" name="i" id="i" value=1>
	<div class="container-fluid">
		<div class='form-group'> 
			<div class='col-sm-1' ></div>
			<div class='col-sm-1' >状态：</div>
				<div class='col-sm-2' >
			
				<select name='status' class='form-control'>
				<c:if test="${not empty param.type}">
					<option style="color: #b6b6b6" selected value="${param.type}">
								<c:if test="${param.type==-1}">全部</c:if>
								<c:if test="${param.type==0}">已保存</c:if>
								<c:if test="${param.type==1}">已提交</c:if>
								<c:if test="${param.type==2}">已通过审核</c:if>
								<c:if test="${param.type==3}">被退回</c:if>
					</option>
				</c:if>
					<option value="-1">全部</option>
					<option value="0">已保存</option>
					<option value="1">已提交</option>
					<option value="2">已通过审核</option>
					<option value="3">被退回</option>
				</select>
			</div>
		</div>
		
		<div class='form-group' > 
		<br>
			<div class='col-sm-1' ></div>
			<div class='col-sm-1' >查询条件：</div>
			
			<div id="1">
			<div class='col-sm-2' >
				<select name='tiaojian1' class='form-control'>
					<option value="represent">法人代表</option>
					<option value="lianxiren">联系人</option>
					<option value="xqname">需求名称</option>
					<option value="theme">主题</option>
					<option value="key">关键字</option>
				</select>
			</div>
			
			<div class='col-sm-1' >
				<select name='JM1' class='form-control'>
					<option value="精确">是</option>
					<option value="模糊">包含</option>
				</select>
			</div>
			<div class='col-sm-2' >
				<input type="text" name="select1">
			</div>
			</div>
			<div class='col-sm-2' >
			<button style="width:70px ;height:30px;display:" onclick="show();" type="button" >添加</button>
			<button style="width:70px ;height:30px;display:" onclick="notshow();" type="button" >删除</button>
			</div>
		</div>
		
		<div class='form-group' id="2" style="display: none"> 
		<br>
			<div class='col-sm-1' ></div>
			<div class='col-sm-1' >
				<select name='QH2' class='form-control'>
					<option value="and">且</option>
					<option value="or">或</option>
				</select>
			</div>
			<div class='col-sm-2' >
				<select name='tiaojian2' class='form-control'>
					<option value="represent">法人代表</option>
					<option value="lianxiren">联系人</option>
					<option value="xqname">需求名称</option>
					<option value="theme">主题</option>
					<option value="key">关键字</option>
				</select>
			</div>
			
			<div class='col-sm-1' >
				<select name='JM2' class='form-control'>
					<option value="精确">是</option>
					<option value="模糊">包含</option>
				</select>
			</div>
			
			<div class='col-sm-2' >
				<input type="text" name="select2">
			</div>
		</div>
		
		<div class='form-group' id="3" style="display: none"> 
		<br>
			<div class='col-sm-1' ></div>
			<div class='col-sm-1' >
				<select name='QH3' class='form-control'>
					<option value="and">且</option>
					<option value="or">或</option>
				</select>
			</div>
			<div class='col-sm-2' >
				<select name='tiaojian3' class='form-control'>
					<option value="represent">法人代表</option>
					<option value="lianxiren">联系人</option>
					<option value="xqname">需求名称</option>
					<option value="theme">主题</option>
					<option value="key">关键字</option>
				</select>
			</div>
			
			<div class='col-sm-1' >
				<select name='JM3' class='form-control'>
					<option value="精确">是</option>
					<option value="模糊">包含</option>
				</select>
			</div>
			
			<div class='col-sm-2' >
				<input type="text" name="select3">
			</div>
		</div>
		
		<div class='form-group' id="4" style="display: none"> 
		<br>
			<div class='col-sm-1' ></div>
			<div class='col-sm-1' >
				<select name='QH4' class='form-control'>
					<option value="and">且</option>
					<option value="or">或</option>
				</select>
			</div>
			<div class='col-sm-2' >
				<select name='tiaojian4' class='form-control'>
					<option value="represent">法人代表</option>
					<option value="lianxiren">联系人</option>
					<option value="xqname">需求名称</option>
					<option value="theme">主题</option>
					<option value="key">关键字</option>
				</select>
			</div>
			
			<div class='col-sm-1' >
				<select name='JM4' class='form-control'>
					<option value="精确">是</option>
					<option value="模糊">包含</option>
				</select>
			</div>
			
			<div class='col-sm-2' >
				<input type="text" name="select4">
			</div>
		</div>
		
		<div class='form-group' id="5" style="display: none"> 
		<br>
			<div class='col-sm-1' ></div>
			<div class='col-sm-1' >
				<select name='QH5' class='form-control'>
					<option value="and">且</option>
					<option value="or">或</option>
				</select>
			</div>
			<div class='col-sm-2' >
				<select name='tiaojian5' class='form-control'>
					<option value="represent">法人代表</option>
					<option value="lianxiren">联系人</option>
					<option value="xqname">需求名称</option>
					<option value="theme">主题</option>
					<option value="key">关键字</option>
				</select>
			</div>
			
			<div class='col-sm-1' >
				<select name='JM5' class='form-control'>
					<option value="精确">是</option>
					<option value="模糊">包含</option>
				</select>
			</div>
			
			<div class='col-sm-2' >
				<input type="text" name="select5">
			</div>
		</div>
		
		<div class='form-group'> 
		<br>
			<div class='col-sm-1' ></div>
			<div class='col-sm-1' >填报时间：</div>
			
			<div class='col-sm-2' >
			<input type="text" name="time1" id="time1" value="选择时间" onClick="return Calendar('time1');" />
			</div><div class='col-sm-1' >到</div>
			<div class='col-sm-2' >
			<input type="text" name="time2" id="time2" value="选择时间" onClick="return Calendar('time2');" />
			</div>
		</div>
		
		
		<div class='form-group'>
		<br>
		<div class='col-sm-5' ></div> 
		<button style="width:100px ;height:30px;" type="submit" class='btn btn-primary btn-block'>查询</button>
		</div>
	</div>
</form>	
		<div class="row-fluid">
			<div class="col-md-1 "></div>
			<div class="col-md-10 ">
				<table class="table table-striped">
					<tr>
						<td>需求名称</td>
						<td>主题</td>
						<td>状态</td>
						<td>法人</td>
						<td>联系人</td>
						<td>时间</td>
						<td align="center" colspan="2">操作</td>
					</tr>
					<!-- forEach遍历出xuqiuBeans -->
					<c:forEach items="${xuqiuBeans}" var="item" varStatus="status">
						<tr>
							<td>${item.xqname }</td>
							<td><div class="icoFontlist" title="${item.theme }">${item.theme }</div></td>
							<td><c:if test="${item.status==0}">已保存</c:if>
								<c:if test="${item.status==1}">已提交</c:if>
								<c:if test="${item.status==2}">已通过审核</c:if>
								<c:if test="${item.status==3}">被退回</c:if>
							</td>
							<td>${item.represent }</td>
							<td>${item.lianxiren }</td>
							<!-- 截取字符串 -->
							<td> ${fn:substring(item.createdate, 0, 16)}</td>
							<c:if test="${item.status==0}">
							<td><a href="${pageContext.request.contextPath}/XuqiuServlet?method=toUpdate&id=${item.id }&type=${param.type}">修改</a></td>
							<td><a href="${pageContext.request.contextPath}/XuqiuServlet?method=delete&username=${item.username }&id=${item.id }&type=${param.type}">删除</a></td>
							</c:if>
							
							<c:if test="${item.status!=0}">
							<td><a href="${pageContext.request.contextPath}/XuqiuServlet?method=toUpdate&id=${item.id }&type=${param.type}">查看</a></td>
							<td></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class=" col-md-1"></div>
		</div>
</body>
</html>