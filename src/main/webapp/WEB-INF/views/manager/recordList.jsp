<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>听诊单列表</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<style type="text/css">
        .container div {
            border: solid 1px black;
        }
        .col-xs-4 {
            font-weight: bold;
        }
    </style>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success">
			<button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div style="width:96%; padding:15px 2% 0px;">
	<div class="daohanglink" style="float:left;">
		<span class="daohang"></span> <span>首页</span><span>></span> <span>听诊单管理</span>
	</div>
	<div class="row" style="float:left; width: 100%;background-color: rgb(248,248,248);margin-left:0px;margin-bottom:15px">
		<div class="span4 offset7" style="margin: 5px 5px 5px 5px;width:264px">
			<form class="form-search" action="#">
				<label style="font-weight: bold">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label> <input type="text"
					name="search_LIKE_title" class="input-medium"
					value="${param.search_LIKE_title}">
					<p></p>
			</form>
			</div>
			<div class="span4 offset7" style="margin: 5px 5px 5px 5px;">
			<form>
				<label style="font-weight: bold">分诊编号：</label> <input type="text"
					name="search_LIKE_title" class="input-medium"
					value="${param.search_LIKE_title}">
				<button type="submit" class="btn" id="search_btn">查询</button>
			</form>
		</div>
		<tags:sort />
	</div>
	<div class="row">
  		<div class="col-md-9 col-md-push-3">.col-md-9 .col-md-push-3</div>
  		<div class="col-md-3 col-md-pull-9">.col-md-3 .col-md-pull-9</div>
	</div>

     <div class="test"></div>
        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col-md-1">col-md-1</div>
                    <div class="col-md-1">col-md-1</div>
                    <div class="col-md-1">col-md-1</div>
                    <div class="col-md-1">col-md-1</div>
                    <div class="col-md-1">col-md-1</div>
                    <div class="col-md-1">col-md-1</div>
                    <div class="col-md-1">col-md-1</div>
                    <div class="col-md-1">col-md-1</div>
                    <div class="col-md-1">col-md-1</div>
                    <div class="col-md-1">col-md-1</div>
                    <div class="col-md-1">col-md-1</div>
                    <div class="col-md-1">col-md-1</div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-sm-8">col-sm-6</div>
                    <div class="col-md-6 col-sm-4">col-sm-6</div>
                </div>
                <div class="row">
                    <div class="col-xs-4">col-xs-4</div>
                    <div class="col-xs-4">col-xs-4</div>
                    <div class="col-xs-4">col-xs-4</div>
                </div>
            </div>
        </div>  
	
	
	<%-- <table id="contentTable" class="table table-striped table-bordered table-condensed" style="margin-bottom:10px">
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${not empty customers}">
				<tbody>
					<c:forEach items="${customers}" var="cus">
						<tr>
							<td>${cus.realname}</td>
							<td>${cus.sex}</td>
							<td>${cus.age}</td>
						</tr>
					</c:forEach>
				</tbody>
			</c:when>
			<c:otherwise>
			目前没有受检者
			</c:otherwise>
	 	</c:choose>
	</table> --%>
</body>
</html>