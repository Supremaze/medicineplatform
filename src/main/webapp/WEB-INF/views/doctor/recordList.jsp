<<<<<<< HEAD
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>诊断单列表</title>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success">
			<button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div style="width:96%; padding:15px 2% 0px;">
	<div class="row" style="float:left; width: 100%;background-color: rgb(248,248,248);margin-left:0px;margin-bottom:15px">
		<div class="span4 offset7" style="margin: 5px 5px 5px 5px;">
			<form class="form-search" action="#">
				<label style="font-weight: bold">姓名：</label> <input type="text"
					name="search_LIKE_title" class="input-medium"
					value="${param.search_LIKE_customer}">
				<label style="font-weight: bold">分诊编号：</label> <input type="text"
					name="search_LIKE_title" class="input-medium"
					value="${param.search_LIKE_res_sn}">
				<button type="submit" class="btn" id="search_btn">查找</button>
			</form>
		</div>
		<tags:sort />
	</div>

	<table id="contentTable" class="table table-striped table-bordered table-condensed" style="margin-bottom:10px">
		<thead>
			<tr>
				<th>分诊编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>身高/cm</th>
				<th>体重/kg</th>
				<th>管理操作</th>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${not empty rresultList}">
			
				<tbody>
					<c:forEach items="${rresultList.customer}" var="rresult">
						<tr>
							<td>${rresult.res_sn}</td>
							<td>${rresult.customer}</td>
							<td>${rresult.cus.sex}</td>
							<td>${rresult.cus.age}</td>
							<td>${rresult.cus.weight}</td>
							<td>${rresult.cus.height}</td>
							<td><a href="${ctx}/doctor/delete/${rresult.id}">诊断</a>|<a href="${ctx}/task/delete/${task.id}">查看档案</a></td>
						</tr>
					</c:forEach>
				</tbody>
		</c:when>
	</c:choose>
	</table>

	<tags:pagination page="${tasks}" paginationSize="5" />
	</div>
</body>
</html>

=======
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>诊断单列表</title>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success">
			<button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div style="width:96%; padding:15px 2% 0px;">
	<div class="row" style="float:left; width: 100%;background-color: rgb(248,248,248);margin-left:0px;margin-bottom:15px">
		<div class="span4 offset7" style="margin: 5px 5px 5px 5px;">
			<form class="form-search" action="#">
				<label style="font-weight: bold">姓名：</label> <input type="text"
					name="search_LIKE_title" class="input-medium"
					value="${param.search_LIKE_customer}">
				<label style="font-weight: bold">分诊编号：</label> <input type="text"
					name="search_LIKE_title" class="input-medium"
					value="${param.search_LIKE_res_sn}">
				<button type="submit" class="btn" id="search_btn">查找</button>
			</form>
		</div>
		<tags:sort />
	</div>

	<table id="contentTable" class="table table-striped table-bordered table-condensed" style="margin-bottom:10px">
		<thead>
			<tr>
				<th>分诊编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>身高/cm</th>
				<th>体重/kg</th>
				<c:if test="${not empty diagnose}"><th>诊断时间</th></c:if>
				<th>管理操作</th>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${not empty rresultList}">
				<tbody>
			<c:forEach items="${rresultList.customer}" var="rresult">
				<tr>
					<td>${rresult.res_sn}</td>
					<td>${rresult.customer}</td>
					<td>${rresult.cus.sex}</td>
					<td>${rresult.cus.age}</td>
					<td>${rresult.cus.weight}</td>
					<td>${rresult.cus.height}</td>
					<c:if test="${not empty diagnose}"><td>${rresult.res_time}</td></c:if>
					<td><c:if test="${empty diagnose}"><a href="${ctx}/doctor/giveDiagnose/${rresult.id}">诊断</a>|<a href="${ctx}/record/showRecord/${rresult.id}">查看档案</a></c:if>
					<c:otherwise><a href="${ctx}/record/showDiagnose/${rresult.id}">查看诊断</a></c:otherwise>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		</c:when>
		<c:otherwise>
			</tbody>
			</table>
			<div style="margin:0px auto;width:100%;text-align:center;">
				<a style="color:#aaa;font-size:18px">未存在数据！</a>
			</div>
			</c:otherwise>
		</c:choose>
	</table>

	
	</div>
</body>
</html>

>>>>>>> 6eeb41c6e67c258a811a302f42766b6495f660a7
</html>