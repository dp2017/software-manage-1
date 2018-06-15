<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css" />
<title>注册</title>

<script type="text/javascript">
	var code; //在全局定义验证码
	function createCode() {
		code = "";
		var codeLength = 6;//验证码的长度
		var checkCode = document.getElementById("checkCode");
		var selectChar = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C',
				'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
				'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');//所有候选组成验证码的字符，当然也可以用中文的
		for (var i = 0; i < codeLength; i++) {
			var charIndex = Math.floor(Math.random() * 36);
			code += selectChar[charIndex];
		}
		// alert(code);
		if (checkCode) {
			checkCode.className = "code";
			checkCode.value = code;
		}
	}
</script>
 <script type="text/javascript">
    //刷新验证码
    function changeImg(){
        document.getElementById("validateCodeImg").src="${pageContext.request.contextPath}/servlet/DrawImage?"+Math.random();
    }
    </script>
  <script>
          function validate() {
              var pwd1 = document.getElementById("pwd1").value;
              var pwd2 = document.getElementById("pwd2").value;
              if(pwd1 == pwd2) {
                  document.getElementById("tishi").innerHTML="<font color='green'></font>";
                  document.getElementById("submit").disabled = false;
              }
              else {
                  document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
                document.getElementById("submit").disabled = true;
              }
             
          }
      </script> 
<script src="${pageContext.request.contextPath}/static/js/myValidate.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/css/address.js" type="text/javascript"></script>
</head>
<body  leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" style="text-align: center;background-color: #DCEEFC;">

	
		
		<form role="form" class="form-horizontal"
					action="${pageContext.request.contextPath }/userServlet?method=reg"
					method="post" id="checkForm" >
		
			<table style="border-collapse: separate;font-size: 16px;border-spacing:0px 5px;" id="checkForm">
				<tr><td colspan="2" style="text-align: left;color:blue;">填写说明：红色*为必须填写的注册信息，建议你填写更多详细信息，以便获得更多资源信息服务</td></tr>
				<tr height=20px></tr>
 				<tr><td style="text-align: left;"><strong style="color: red;">*</strong>用户名：</td><td><input type="text"  name="username" value="${adminBean.username}" required="true" autofocus></td></tr>
				 <tr><td style="text-align: left;"><strong style="color: red;">*</strong>用户密码：</td><td><input class="easyui-validatebox" required="true" missingMessage="密码必须填写" size="20" type="password"  name="password" value="${adminBean.password}" id="pwd1"></td>			
				<tr><td  style="text-align: left;"><strong style="color: red;">*</strong>确认密码：</td><td><input class="easyui-validatebox" required="true" missingMessage="密码必须填写" size="20" type="password" onkeyup="validate()" name="password2"id="pwd2" ><span id="tishi"></span></td></tr>	
				<tr><td style="text-align: left;">姓名：</td><td><input id="name" type="text" name="name"value="${adminBean.name}"></td><td style="text-align: left;">请填写真实姓名，以便与您取得联系</td></tr>
				<tr><td style="text-align: left;">性别：</td><td><input type="radio" name="sex" value="男">男<input type="radio" name="sex" value="女">女</td></tr>
				<%-- <tr><td style="text-align: left;"><strong style="color: red;">*</strong>国家/省市：</td><td><select name='Gshi' class='form-control'>
						<c:forEach var="addr" items="${bookBeans}">
							<option value="${addr.id}">省份</option>
						</c:forEach>
					</select>
					<select name='Gshi' class='form-control'>
						<c:forEach var="addr" items="${bookBeans}">
							<option value="">省份</option>
						</c:forEach>
					</select></td></tr>--%>
		        <tr><td style="text-align: left;"><strong style="color: red;">*</strong>省市：</td>
				<td>
				<select name="Gshi" id="province" onchange="changeSelect(this);">  
    			   <option value="000000" style="color:#999;" disabled="disabled" >-请选择省-</option>  
				</select>  
				<select id="city" onchange="changeSelect(this);">  
   	 			   <option value="000000" style="color:#999;" disabled="disabled" >-请选择市-</option>  
				</select>  
				<select id="district">  
    			   <option value="000000" style="color:#999;" disabled="disabled">-请选区-</option>  
				</select>   
                </td>
                </tr>
				<tr><td  style="text-align: left;"><strong style="color: red;">*</strong>工作单位：</td><td><input type="text" name="danwei" required="true"value="${adminBean.danwei}" ></td></tr>
				<tr><td style="text-align: left;"><strong style="color: red;">*</strong>专业方向：</td><td><input type="text" name="zhuanye" required="true"value="${adminBean.zhuanye}"></td></tr>
				<tr><td  style="text-align: left;"><strong style="color: red;">*</strong>所在行业：</td><td><input type="text" name="hangye" required="true"value="${adminBean.hangye}"></td></tr>
				<tr><td  style="text-align: left;">教育程度：</td><td><input type="text" name="jiaoyu"value="${adminBean.jiaoyu}"></td></tr>
				<tr><td style="text-align: left;">职称：</td><td><input type="text" name="zhicheng"></td></tr>
				<tr><td style="text-align: left;">通讯地址：</td><td><input type="text" name="tongxun"value="${adminBean.tongxun}"></td><td style="text-align: left;">请您填写详细，以便与您取得联系</td></tr>
				<tr><td style="text-align: left;">邮政编码：</td><td><input type="text" name="youbian"value="${adminBean.youbian}"></td></tr>
				<tr><td  style="text-align: left;">手机：</td><td><input type="text" name="id" id="phone" onblur="checkPhone()"></td></tr>
				<tr><td  style="text-align: left;">固定电话：</td><td><input type="tel" name="guhua"value="${adminBean.guhua}"></td></tr>
				<tr><td  style="text-align: left;">邮箱：</td><td><input type="email" name="youxiang"value="${adminBean.youxiang}"></td></tr>
				<tr><td  style="text-align: left;">QQ：</td><td><input type="text" name="qq"value="${adminBean.qq}"></td></tr>
				<tr><td  style="text-align: left;">MSN：</td><td><input type="text" name="msn"value="${adminBean.msn}"></td></tr>
				<tr><td  style="text-align: left;">验证码：</td><td><input type="text" name="yanzhengma"></td><td style="text-align: left;"><img alt="更新" src="${pageContext.request.contextPath}/servlet/DrawImage" id="validateCodeImg" onclick="changeImg()"></td>
				<tr height=40px></tr>

			</table>


		<div class="row-fluid">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<button  type="submit" class="btn btn-default" style="width:100px;height:30px; font-size:16px">提交</button> 
				<input id="clear" type="reset" value="重置" style="width:100px;height:30px; font-size:16px"/>
			</div>
			
				<input type="button" value="返回登录" class="btn btn-default" style="width:100px;height:30px; font-size:16px" onclick="window.location.href('login.jsp')"></a>
			
		</div>
	</form>

	<div>
		<c:if test="${param.status == 1}">
			<script type="text/javascript">
				alert("用户名为空或已存在！");
			</script>
		</c:if>
		<c:if test="${param.status == 2}">
			<script type="text/javascript">
				alert("工作单位不能为空");
			</script>
		</c:if>
			<c:if test="${param.status == 4}">
			<script type="text/javascript">
				alert("专业不能为空");
			</script>
		</c:if>
			<c:if test="${param.status == 5}">
			<script type="text/javascript">
				alert("行业不能为空");
			</script>
		</c:if>
			<c:if test="${param.status == 6}">
			<script type="text/javascript">
				alert("二次输入密码不一致");
			</script>
		</c:if>
		<c:if test="${param.status == 3}">
			<script type="text/javascript">
				alert("注册成功");
			</script>
		</c:if>
	</div>
	<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/yanzheng.js"></script>
</body>
</html>