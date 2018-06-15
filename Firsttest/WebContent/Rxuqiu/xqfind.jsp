<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script 
 src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js" 
 type="text/javascript"></script> 
<script 
 src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstra
p.js" 
 type="text/javascript"></script> 
<link rel="stylesheet" type="text/css" 
 href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootst
rap.css" /> 
<title>查看需求</title>
</head>
<body>
<div class="container-fluid"> 
  <div class="row-fluid"> 
   <c:if test="${adminBeans!=null}"> 
    <div class="col-md-10 col-md-offset-1"> 
     <table class="table"> 
      <tr> 
          <td>用户名</td>  <td>机构全称</td>       <td>通讯地址</td>       <td>法人代表</td>  <td>学科</td>     <td>需求名称</td>           
           <td>填报时间</td>       <td>操作</td> 
      </tr> 
      <c:forEach items="${adminBeans }" var="item" varStatus="status">
      <tr>  
      <td><a href="${pageContext.request.contextPath}/userServlet?method=listDetails&id=${item.username }">${item.username }</a></td> 
      <td>${item.name }</td> 
      <td>${item.address }</td> 
      <td>${item.represent }</td> 
       <td>${item.firstSubjects }</td>
      <td>${item.xuming}</td> 
      <td>${item.createDate }</td> 
      <td><a 
         href="${pageContext.request.contextPath}/xuqiuServlet?method=delete&id=${item.id }">删除</a></td> 
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