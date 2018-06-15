<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<script type="text/javascript">
function setnum(){
	var number=2;
	
    var nam=document.getElementById(number).style.display;
	alert(nam);
    if(nam=='none'){
        document.getElementById("2").style.display='';
    }else{
        document.getElementById("2").style.display='none';
    }
}
function show(){
	//alert(document.getElementById("div").style.display)
	for(id=2;id<6;id++){
		if(document.getElementById(id).style.display=="none"){
			document.getElementById(id).style.display="";
			document.getElementById("i").value=id;
			break;
		}
	}
}
function notshow(){
	for(id=5;id>1;id--){
		if(document.getElementById(id).style.display==""){
			document.getElementById(id).style.display="none";
			document.getElementById("i").value=id-1;
			break;
		}
	}
}
</script>
</head>

<body>
	
	<link href="../123_files/magsearch.css" type="text/css" rel="stylesheet">
	<link href="./123_files/adv.css" type="text/css" rel="stylesheet">
	<form>
	
		<div class="sFormBox" style="">
			<div class="sFormTit">
				<ul>
					<li id="firstAdvId" class="cur"><a href="javascript:;"
						id="showorhideAdvId">高级检索</a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="sForm_exact" style="float: none; margin: 0 auto;">
			<div id="advDivId" class="highSearch">
				<div style="margin-bottom: 12px"><p style="margin-bottom: 12px">输入检索条件：</p>
				     时效状态： <select name="" id="">
							<option value="已审核">已审核</option>
							<option value="未审核">未审核</option>
						</select> 
				</div>
				<div class="searchForm">
					<div id="1" style="margin-bottom: 12px">
						检索类型： <select name="" id="">
							<option value="需求名称">需求名称</option>
							<option value="主要问题">主要问题</option>
							<option value="关键字">关键字</option>
							<option value="学科分类">学科分类</option>
						</select> <input style="" name="" id="" /> <select name="" id="">
							<option value="并含">并含</option>
							<option value="包含">包含</option>
							<option value="不含">不含</option>
						</select> <input style="" name="" id="" /><select name="" id="">
							<option value="精确">精确</option>
							<option value="模糊">模糊</option>	
						</select>
						<input id="tianjia" type="button" onclick="show()" value="添加"></input>
					    <input id="shanchu" type="button" onclick="notshow()" value="删除"></input>
					</div>
						<div id="2" style="display: none;margin-bottom: 12px">
						检索类型： <select name="" id="">
							<option value="需求名称">需求名称</option>
							<option value="主要问题">主要问题</option>
							<option value="关键字">关键字</option>
							<option value="学科分类">学科分类</option>
						</select> <input style="" name="" id="" /> <select name="" id="">
							<option value="并含">并含</option>
							<option value="包含">包含</option>
							<option value="不含">不含</option>
						</select> <input style="" name="" id="" /><select name="" id="">
							<option value="精确">精确</option>
							<option value="模糊">模糊</option>	
						</select>
					</div>
					<div id="3" style="display: none;margin-bottom: 12px">
						检索类型： <select name="" id="">
							<option value="需求名称">需求名称</option>
							<option value="主要问题">主要问题</option>
							<option value="关键字">关键字</option>
							<option value="学科分类">学科分类</option>
						</select> <input style="" name="" id="" /> <select name="" id="">
							<option value="并含">并含</option>
							<option value="包含">包含</option>
							<option value="不含">不含</option>
						</select> <input style="" name="" id="" /><select name="" id="">
							<option value="精确">精确</option>
							<option value="模糊">模糊</option>	
						</select>
					</div>
					<div id="4" style="display: none;margin-bottom: 12px">
						检索类型： <select name="" id="">
							<option value="需求名称">需求名称</option>
							<option value="主要问题">主要问题</option>
							<option value="关键字">关键字</option>
							<option value="学科分类">学科分类</option>
						</select> <input style="" name="" id="" /> <select name="" id="">
							<option value="并含">并含</option>
							<option value="包含">包含</option>
							<option value="不含">不含</option>
						</select> <input style="" name="" id="" /><select name="" id="">
							<option value="精确">精确</option>
							<option value="模糊">模糊</option>	
						</select>
					</div>
					<div id="5" style="display: none;margin-bottom: 12px">
						检索类型： <select name="" id="">
							<option value="需求名称">需求名称</option>
							<option value="主要问题">主要问题</option>
							<option value="关键字">关键字</option>
							<option value="学科分类">学科分类</option>
						</select> <input style="" name="" id="" /> <select name="" id="">
							<option value="并含">并含</option>
							<option value="包含">包含</option>
							<option value="不含">不含</option>
						</select> <input style="" name="" id="" /><select name="" id="">
							<option value="精确">精确</option>
							<option value="模糊">模糊</option>	
						</select>
					</div>
				</div>
			</div>
		</div>
		
	</form>
	
</body>
</html>