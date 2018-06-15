<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="java.util.*,com.dbEntity.Subjects,com.dbEntity.NationalEconomy"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新建需求征集表</title>
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

	<form
		action="${pageContext.request.contextPath }/xuqiuServlet?method=reg"
		id="form1" method="post">
		<center>

			<table class="table" border="2" cellpadding="10">
				<caption>
					<h2>技术需求申请表</h2>
				</caption>

				<tr>
					<td colspan="1">*机构全称</td>
					<td colspan="2"><input type="text" name="name"
						value="${xuqiubean.name}" required onfocus></td>
						<td colspan="1">归口管理部门</td>
					<td colspan="2"><input type="text" name="gguan"
						value="${xuqiubean.gguan}"  ></td>
				</tr>
				<tr>
					<td>*通讯地址</td>
					<td colspan="2"><input type="text" name="address"
						value="${xuqiubean.address}" required></td>
					<td>*所在地域</td>
					<td colspan="2"><input type="text" name="saddress"
						value="${xuqiubean.saddress}" required></td>
				</tr>
				<tr class='tr1'>
					<td colspan="1">*网址</td>
					<td colspan="2"><input type="text" name="web"
						value="${xuqiubean.web}" required></td>
					<td>电子邮箱</td>
					<td colspan="2"><input type="text" value="${xuqiubean.email}" name="email"></td>
				</tr>
				<tr>
					<td>*法人代表</td>
					<td><input type="text" name="represent"
						value="${xuqiubean.represent}" required></td>
					<td >邮政编码</td>
					<td colspan="2"><input type="text" name="zipcode"></td>
				</tr>
				<tr>
					<td rowspan="2">*联系人</td>
					<td rowspan="2"><input type="text" name="lianxiren"
						value="${xuqiubean.lianxiren}" required></td>
					<td>电话</td>
					<td colspan="5">1、 固定<input size="13" type='text' name="phone"><br>
						*2、手机<input size="13" type='text' name="telephone"
						value="${xuqiubean.telephone}" required></td>
				</tr>
				<tr>

					<td>传真</td>
					<td colspan="5"><input type='text' name="chuanzhen"></td>
				</tr>
				<tr>
					<td>机构属性</td>
					<td colspan="5"><label><input type="checkbox"
							name="shuxing" value="企业" onClick="Close('otherServics')">企业</label>
						<label><input type="checkbox" name="shuxing" value="高等院校"
							onClick="Close('otherServics')">高等院校</label> <label><input
							type="checkbox" name="shuxing" value="研究机构"
							onClick="Close('otherServics')">研究机构</label> <label><input
							type="checkbox" name="shuxing" value="其他"
							onClick="Close('otherServics')">其他</label></td>
				</tr>
				<tr class="tr2">
					<td class="td5" colspan="4">1、机构简介(需要解决的重大技术问题，限500字以内)</td>
					<td class="td6" id="text2">0/200</td>
				</tr>
				<tr class="tr3">
					<td colspan="5"><textarea class="textarea"
							onkeyup="showTextLength('text2','jianjie')" style="width: 800px"
							id="jianjie" name="jianjie" cols=100 rows=6 maxlength="200"></textarea></td>
				</tr>
				<tr>
					<td width="170">*技术需求名称</td>
					<td><input type="text" name="xuming" required></td>
					<td width="100">需求时限</td>
					<td colspan="5"><input type="date" name="xushi"
						id="StartTime" onchange="isValidityYear()">年至<input
						type="date" name="xushi" id="EndTime" onchange="isValidityYear()"></td>
				</tr>
				<tr class="tr1">
					<td colspan="5">*重大科技需求概述</td>
				</tr>
				<tr class="tr2">
					<td class="td5" colspan="4">1、主要问题(需要解决的重大技术问题，限500字以内)</td>
					<td class="td6" id="text1">0/500</td>
				</tr>

				<tr class="tr3">
					<td colspan="5"><textarea required class="textarea"
							onkeyup="showTextLength('text1','theme')" style="width: 800px"
							id="theme" name="theme" cols=100 rows=10 maxlength="500"></textarea></td>
				</tr>



				<tr>
					<td>投入资金额:</td>
					<td colspan="5"><input type="text" name="money" id="money">万元</td>
				  
				<tr>
					<td>关键字:</td>
					<td colspan="4"><input class="input3" type="text" id="key1"
						name="key1"> <input class="input3" readonly="readonly"
						type="text" id="key2" name="key2" onkeyup="ChangeState()">
						<input class="input3" readonly="readonly" type="text" id="key3"
						name="key3" onkeyup="ChangeState()"> <input class="input3"
						readonly="readonly" type="text" id="key4" name="key4"
						onkeyup="ChangeState()"> <input class="input3"
						readonly="readonly" type="text" id="key5" name="key5"
						onkeyup="ChangeState()"></td>
				</tr>

				</td>
				</tr>
				<tr>
					<td class="td1">研究类型</td>
					<td colspan="4"><label> <input type="radio"
							name="type" value="基础研究" id="for" onclick="getUI()">基础研究
					</label> <label> <input type="radio" name="type" id="for"
							value="应用研究" onclick="getUI()">应用研究
					</label> <label> <input type="radio" name="type" value="试验发展"
							onclick="getUI()">试验发展
					</label> <br> <label> <input type="radio" name="type"
							value="研究发展与应用成果" id="form1" onclick="getUI()">研究发展与应用成果
					</label> <label> <input type="radio" name="type" value="技术推广与科技服务"
							onclick="getUI()">技术推广与科技服务
					</label> <label> <input type="radio" name="type" id="form1"
							value="生产性活动" onclick="getUI()">生产性活动
					</label></td>
				</tr>
				<tr id="sub" style="display: none;">
					<td class="td1">学科分类</td>
					<td colspan="4"><select name="firstSubjects"
						id="firstSubjects" onchange="changeSelect(this);">
							<option value="请选择">请选择</option>

					</select> <select name="secondSubjects" id="secondSubjects"
						onchange="changeSelect(this);">
							<option value="请选择">请选择</option>

					</select> <select name="thirdSubjects" id="thirdSubjects"
						onchange="changeSelect(this);">
							<option value="请选择">请选择</option>

					</select></td>
				</tr>
				<tr>
					<td class="td1">*技术需求解决方式</td>
					<td colspan="4"><label><input type="radio"
							name="model" value="基础研究" onClick="Close('otherModel')">独立开发</label>
						<label><input type="radio" name="model" value="应用研究"
							onClick="Close('otherModel')">技术转让</label> <label><input
							type="radio" name="model" value="试验发展"
							onClick="Close('otherModel')">技术入股</label> <label><input
							type="radio" name="model" value="研究发展与应用成果"
							onClick="Close('otherModel')">合作开发</label> <label><input
							type="radio" name="model" value="技术推广与科技服务"
							onClick="Show('otherModel')">其他<input class="input5"
							type="text" id="otherModel" name="model" style="display: none;"></label>
					</td>
				</tr>
				<tr>
				<tr id="servics" style="display: none;">
					<td class="td1">需求技术所属领域</td>
					<td colspan="4"><label><input type="checkbox"
							name="servics" value="电子信息技术" onClick="Close('otherServics')">电子信息技术</label>
						<label><input type="checkbox" name="servics"
							value="光机电一体化" onClick="Close('otherServics')">光机电一体化 </label> <label><input
							type="checkbox" name="servics" value="软件"
							onClick="Close('otherServics')">软件</label> <label><input
							type="checkbox" name="servics" value="生物制药技术"
							onClick="Close('otherServics')">生物制药技术</label> <label><input
							type="checkbox" name="servics" value="新材料及应用技术"
							onClick="Close('otherServics')">新材料及应用技术</label> <br> <label><input
							type="checkbox" name="servics" value="先进制造技术"
							onClick="Close('otherServics')">先进制造技术</label> <label><input
							type="checkbox" name="servics" value="现代农业技术"
							onClick="Close('otherServics')">现代农业技术</label> <label><input
							type="checkbox" name="servics" value="新能源与高效节能技术"
							onClick="Close('otherServics')">新能源与高效节能技术</label> <br> <label><input
							type="checkbox" name="servics" value="资源与环境保护新技术"
							onClick="Close('otherServics')">资源与环境保护新技术</label> <label><input
							type="checkbox" name="servics" value="其他技术"
							onClick="Show('otherServics')">其他技术</label> <label><input
							class="input5" type="text" id="otherServics" name="otherServics"
							style="display: none;"></label></td>
				</tr>
				<tr id="industry" style="display: none;">
					<td id="td1">需求技术应用行业</td>
					<td colspan="4"><select name="firstIndustry"
						id="firstIndustry">
							<option value="请选择">请选择</option>
							<option value="文科">文科</option>
							<option value="理科">理科</option>
					</select> <select name="secondIndustry" id="secondIndustry"
						onchange="Changdus()">
							<option value="请选择">请选择</option>
							<option value="土木">土木</option>
							<option value="计算机">计算机</option>
							<option value="法律">法律</option>
					</select> <select name="thirdIndustry" id="thirdIndustry"
						onchange="Changdus()">
							<option value="请选择">请选择</option>
							<option value="软件">软件</option>
							<option value="法律">法律</option>
					</select></td>
				</tr>

				<tr>
					<td colspan="5" align="center"><input type="submit"
						style="width: 100px; height: 30px; font-size: 16px" value="保存"
						name="save"> <input type="submit"
						style="width: 100px; height: 30px; font-size: 16px" value="提交"
						name="add"></td>
				</tr>
			</table>

		</center>

	</form>

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
		
		<c:if test="${param.status == 3}">
			<script type="text/javascript">
				alert("更新成功");
			</script>
		</c:if>
	</div>
	<script src="${pageContext.request.contextPath}/index/css/address.js"
		type="text/javascript"></script>
</body>
</html>