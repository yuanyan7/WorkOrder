<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>企业工单列表</title>
    
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
    <h1 >企业工单列表</h1>
    <table class="woTable" cellpadding="0" cellspacing="0">
    	<tr class="firstTr">
	        <th width="10%">工单编号</th>
	        <th width="10%">项目名称</th>
	        <th width="20%">执行人</th>
	        <th width="10%">任务描述</th>
	        <th width="10%">工单级别</th>
	        <th width="10%">创建时间</th>
        </tr>
        <%-- <c:forEach/>实现对集合的遍历以及对条件的判断 --%>
       <!--  items——集合对象      var——集合中元素的名称     varStatus——当前循环的状态信息 -->
       <%-- <c:forEach var="每个变量名字" items="要迭代的list" varStatus="每个对象的状态"  --%>
	        	<!-- begin="循环从哪儿开始" end="循环到哪儿结束"    step="循环的步长"> 循环要输出的东西 -->
	       <%--  </c:forEach> --%>
	        
	        
        <c:forEach var="workOrder" items="${workOrderList}" varStatus="status">
			<tr>
				<td><span >${workOrder.id}</span></td>
				<td><span>${workOrder.projectName}</span></td>
				<td><span>${workOrder.executor}</span></td>
				<td><span>${workOrder.description}</span></td>
				<td><span>${workOrder.orderLevel}</span></td>
				<td><span>${workOrder.createDate}</span></td>
			</tr>
		</c:forEach>
	</table>  
  </body>
</html>
