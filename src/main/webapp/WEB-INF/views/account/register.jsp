<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>用户注册</title>
	
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#userame").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate({
				rules: {
					username: {
						remote: "${ctx}/register/checkLoginName"
					}
				},
				messages: {
					username: {
						remote: "用户登录名已存在"
					}
				}
			});
		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/register" method="post" class="form-horizontal">
		<fieldset style="margin-left: 25%;width: 41%;float:left">
			<legend><small>用户注册</small></legend>
			<div class="control-group">
				<label for="username" class="control-label">登录名:</label>
				<div class="controls">
					<input type="text" id="username" name="username" class="input-large required" minlength="3"/>
				</div>
			</div>
			<div class="control-group">
				<label for="realname" class="control-label">真实姓名:</label>
				<div class="controls">
					<input type="text" id="realname" name="realname" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="plainPassword" class="control-label">密码:</label>
				<div class="controls">
					<input type="password" id="plainPassword" name="plainPassword" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="confirmPassword" class="control-label">确认密码:</label>
				<div class="controls">
					<input type="password" id="confirmPassword" name="confirmPassword" class="input-large required" equalTo="#plainPassword"/>
				</div>
			</div>
			<div class="control-group">
				<label for="roles" class="control-label">注册角色:</label>
				<div class="controls">
					<input id="roles" name="roles" type="radio" value="doctor" /> 医生
					<input id="roles" name="roles" type="radio" value="user" /> 用户
				</div>
			</div>
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
</body>
</html>
