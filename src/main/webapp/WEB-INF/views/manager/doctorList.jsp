<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>医生注册审核</title>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success">
			<button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div style="width:96%; padding:15px 2% 0px;">
	<div class="daohanglink" style="float:left;">
		<span class="daohang"></span> <span>首页</span><span>></span> <span>医生注册审核</span>
	</div>
	<div class="row" style="float:left; width: 100%;background-color: rgb(248,248,248);margin-left:0px;margin-bottom:15px">
		<div class="span4 offset7" style="margin: 5px 5px 5px 5px;">
			<form class="form-search" action="#">
				<label style="font-weight: bold">姓名：</label> <input type="text"
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
				<th>姓名</th>
				<th>性别</th>
				<th>单位</th>				
				<th>电话</th>
				<th>身份证号</th>
				<th>注册时间</th>
				<th>审核状态</th>
				<th>管理</th>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${not empty members}">
				<tbody>
					<c:forEach items="${members}" var="mem">
						<tr>
							<td>${mem.realname}</td>
							<td>${mem.sex}</td>
							<td>${mem.danwei}</td>
							<td>${mem.phone}</td>
							<td>${mem.sfz}</td>
							<td>${mem.regtime}</td>
							<td>${mem.status}</td>
							<td><a href="${ctx}/manager/updateDoc/${mem.id}">更新</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</c:when>
			<c:otherwise>
			目前没有受检者
			</c:otherwise>
	 	</c:choose>
	</table> 

	</div>
</body>
</html>
