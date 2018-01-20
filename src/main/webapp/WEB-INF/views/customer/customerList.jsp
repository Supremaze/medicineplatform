
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>受检者管理</title>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success">
			<button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div style="width:96%; padding:15px 2% 0px;">
	<div class="daohanglink" style="float:left;">
		<span class="daohang"></span> <span>首页</span><span>></span> <span>项目列表</span>
		<a href="${ctx}/customer/create" class="label label-warning"
			style="float: right; margin: 8px;">添加项目</a>
	</div>
	<div class="row" style="float:left; width: 100%;background-color: rgb(248,248,248);margin-left:0px;margin-bottom:15px">
		<div class="span4 offset7" style="margin: 5px 5px 5px 5px;">
			<form class="form-search" action="#">
				<label style="font-weight: bold">名称：</label> <input type="text"
					name="search_LIKE_title" class="input-medium"
					value="${param.search_LIKE_title}">
				<button type="submit" class="btn" id="search_btn">查找</button>
			</form>
		</div>
		<tags:sort />
	</div>

	<table id="contentTable" class="table table-striped table-bordered table-condensed" style="margin-bottom:10px">
		<thead>
			<tr>
				<th>任务</th>
				<th>管理</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers.content}" var="customer">
				<tr>
					<td><a href="${ctx}/customer/update/${customer.id}">${customer.address}</a></td>
					<td><a href="${ctx}/customer/delete/${customer.id}">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<tags:pagination page="${customers}" paginationSize="5" />
	</div>
</body>
</html>
