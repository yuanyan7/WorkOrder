<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统登录--企业工单管理系统首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

  <body>
	<form  action="<%=request.getContextPath()+"/workOrder/add.html"%>" method="post">
		<h1>企业工单管理系统</h1>
		<span>选择项目</span>
			<select name="proId" >
		  		<c:forEach var="project" items="${proList}">
					<option value="${project.id}">${project.projectName}</option>
				</c:forEach>
		  	</select>
		  		<input type="submit" value="确认"/>
	</form>
  </body>
</html>
