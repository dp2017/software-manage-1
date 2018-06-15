<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <script type="text/javascript">
    //刷新验证码
    function changeImg(){
        document.getElementById("validateCodeImg").src="${pageContext.request.contextPath}/servlet/DrawImage?"+Math.random();
    }

    </script>
<script type="text/javascript">
	var code;
	//	生成验证码
	function createCode(){
		code = "";
		var codeLength = 6;//验证码的长度
		var checkCode = document.getElementById("checkCode");
		var selectChar = new Array(
				0,1,2,3,4,5,6,7,8,9,
				'A','B','C','D','E','F','G','H','I','J','K','L',
				'M','N','O','P','Q','R','S','T','U','V','W','X',
				'Y','Z'
				);
		
		for(var i = 0; i < codeLength; i++){
			var charIndex = Math.floor(Math.random()*36);
			code += selectChar[charIndex];
		}
		
		if(checkCode){
			
			checkCode.className = "code";
			checkCode.value = code;
		}
	}
</script>
<% request.getSession().invalidate();%> 
</head>
<body onkeydown="keyLogin();"  bgcolor="#FFFFFF"
	onLoad="MM_preloadImages('images/login000_06.jpg','images/loging000_07.jpg')">

	<table  width="795" height="475" border="0" align="center"
		cellpadding="0" cellspacing="0" id="__01">
		<tr>
			<td colspan="5"><img src="images/login_01.jpg" width="795"
				height="159" alt=""></td>
		</tr>
		<tr>
			<td rowspan="2"><img src="images/login_02.jpg" width="269"
				height="174" alt=""></td>
			<td bgcolor="#CFE5F2"><img src="images/login_03.jpg" width="66"
				height="115" alt=""></td>
			<td colspan="2" bgcolor="#D0E6F3">
				<table width="100%" height="116" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td colspan="2" align="left" valign="bottom" class="lfield"><INPUT
							NAME="username" id="username" TYPE="text" CLASS="STYLE1"
							STYLE="width: 180px; height: 17px; border: #336699 1px solid"
							tabindex="1" MAXLENGTH="26"></td>
					</tr>
					<tr>
						<td height="32" colspan="2" align="left" valign="bottom"
							class="lfield"><INPUT NAME="password" id="password"
							TYPE="password" CLASS="STYLE1"
							STYLE="width: 180px; height: 17px; border: #336699 1px solid"
							tabindex="1" MAXLENGTH="26"></td>
					</tr>
					<tr>
						<td width="50%" height="29" align="left" valign="bottom"
							class="lfield"><INPUT NAME="checkCodeInput" id="checkCodeInput" TYPE="text"
							CLASS="STYLE1"
							STYLE="width: 100px; height: 17px; border: #336699 1px solid"
							tabindex="1" MAXLENGTH="26"></td>
						<td width="50%" align="left" valign="bottom">
						<img alt="更新" src="${pageContext.request.contextPath}/servlet/DrawImage" id="validateCodeImg" onclick="changeImg()"></td>			   
					</tr>
					<tr>
						<td height="30" colspan="1" align="left" valign="bottom">&nbsp;</td>
					</tr>
				</table>
			</td>
			<td rowspan="2"><img src="images/login_05.jpg" width="262"
				height="174" alt=""></td>
		</tr>
		<tr>
			<td colspan="2"><a href="#" id="input1" onclick="tiJiao();" onMouseOut="MM_swapImgRestore()"
				onMouseOver="MM_swapImage('Image12','','images/loging000_06.jpg',1)"><img
					src="images/login_06.jpg" name="Image12" width="135" height="59"
					border="0"></a></td>
			<td><a href="add.jsp" onMouseOut="MM_swapImgRestore()"
				onMouseOver="MM_swapImage('Image13','','images/loging000_07.jpg',1)">
				<img
					src="images/login_07.jpg" name="Image13" width="129" height="59"
					border="0"></a></td>
		</tr>
		<tr>
			<td colspan="5"><img src="images/login_08.jpg" width="795"
				height="141" alt=""></td>
		</tr>
		<tr>
			<td><img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="269"
				height="1" alt=""></td>
			<td><img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="66"
				height="1" alt=""></td>
			<td><img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="69"
				height="1" alt=""></td>
			<td><img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="129"
				height="1" alt=""></td>
			<td><img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="262"
				height="1" alt=""></td>
		</tr>
	</table>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/js/myvalidate.js"></script>
<script type="text/javascript">
	


	if(window != top){
		top.location.href = location.href;
	}

</script>

<script type="text/javascript">
function keyLogin(){
    if (event.keyCode==13)  //回车键的键值为13
     //document.getElementByIdx_x("input1").onclick(); //调用登录按钮的登录事件
     tiJiao();
    }

	function tiJiao(){
		var username = $("#username").val();
		var password = $("#password").val();
		var checkCodeInput = $("#checkCodeInput").val();
		var checkCode= $("#checkCode").val();
		if(username == null || username.length == 0 || password == null || password.length == 0 || checkCodeInput == null || checkCodeInput.length == 0){
			changeImg();
			alert("填写不完整");
			return false;
		}
		$.post('${pageContext.request.contextPath}/userServlet', {"method": "login","username":username,"password":password,"checkCodeInput":checkCodeInput,"checkCode":checkCode}, function(data) {
	     
			if(data != null && data.length >= 0){
				//alert(data);
				if(data == 1){
					changeImg();
					alert("用户名不存在，请注册");
				}
				else if(data == 2){
					changeImg();
					alert("密码错误");
				}
				else if(data == 3){
					changeImg();
					alert("验证码错误");
				}
				else{
					window.location.href = "${pageContext.request.contextPath}/index/main.jsp";
				}
			}
		});
	}

</script>
</body>
</html>