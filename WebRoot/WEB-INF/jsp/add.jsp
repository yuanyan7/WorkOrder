<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加工单</title>
    
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
   	<form action="<%=request.getContextPath()+"/workOrder/work.html"%>" method="post">
		<h1>添加工单</h1>
		<input type="hidden" value="${proId}" name="proId"/>
   				执行人:<input name="executor" type="text" />
   				任务描述:<textarea name="showText" rows="2" cols="15"></textarea>
   				级别:<select name="orderLevel">
   					<option value="1">一级</option>
   					<option value="2">二级</option>
   					<option value="3">三级</option>
   				</select>
   		<input type="submit" name="but" value="提交"/>
   		
   		<%-- 
   		 	<table class="worktable"  cellpadding="1" cellspacing="1">
		<tr >
			<th width="10%">执行人</th>
			<th width="70%">任务描述</th>
			<th width="20%">级别</th>
		</tr>
   		<c:forEach var="work" items="${workList}" varStatus="status">
   			<tr><td><span>${work.executor}</span></td></tr>
   			<tr><td><span>${work.description}</span></td></tr>
   			<tr>
   				<td>
   					<span>
   						<c:if test="${work.orderLecel==1 }"> 一级</c:if>
						<c:if test="${work.orderLecel==2 }"> 二级</c:if>
						<c:if test="${work.orderLecel==3 }"> 三级</c:if>
   					</span>
   				</td>
   			</tr>
   		</c:forEach>
   		</table>    --%>
   	</form>
  </body>
</html>
