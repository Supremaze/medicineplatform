<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>任务管理</title>
</head>

<body>
<div style="width:96%; padding:15px 2% 0px;">
	<div class="daohanglink" style="float:left;">
		<span class="daohang"></span> <span>首页</span><span>></span> <span><a href="${ctx}/task">项目列表</a></span>
		<span>></span><span>项目详情</span>
	</div>
	<form id="inputForm" action="${ctx}/manager/${action}/${member.id}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${member.id}"/>
		<fieldset>
			<legend><small>管理任务</small></legend>
			<div class="control-group">
				<label  class="control-label">姓名：</label>
				<div class="controls">
					<input type="text" id="xingming" name="xingming"  value="${member.realname}" class="input-large required" minlength="3" required/>
				</div>
			</div>	
			<div class="control-group">
				<label  class="control-label">电话:</label>
				<div class="controls">
					<input type="text" id="dianhua" name="dianhua"  value="${member.phone}" class="input-large required" minlength="3"/>
				</div>
			</div>	
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#task_title").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate();
		});
	</script>
	</div>
</body>
</html>
