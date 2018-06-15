<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="css/main.css">
<div class="mainBar">
	<div>
	 你好${adminBean.username}
		今天是
		<script>
             var weekDayLabels = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
             var now = new Date();
             var year = now.getFullYear();
             var month = now.getMonth() + 1;
             var day = now.getDate()
             var currentime = year + "年" + month + "月" + day + "日 " + weekDayLabels[now.getDay()]
             document.write(currentime)
                                       
             </script>       
             </div>
</div>
