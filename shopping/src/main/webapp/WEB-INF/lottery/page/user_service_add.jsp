<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>服务端用户条件查询</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/lottery_0.css">
</head>
<body>
	<div class="layui-form">
	<h1>添加用户</h1>
		<div class="layui-form-item">
			<label class="layui-form-label">账号</label>
			<div class="layui-input-block">
				<input type="text" id="account" name="title" required lay-verify="required"
					placeholder="账号" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-block">
				<input type="text" id="pw" name="title" required lay-verify="required"
					placeholder="密码" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">电话</label>
			<div class="layui-input-block">
				<input type="text" name="title" id="phone" required lay-verify="required"
					placeholder="电话" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-block">
				<input type="text" name="title" id="name" required lay-verify="required"
					placeholder="姓名" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">权限</label>
			<div class="layui-input-block">
				<input type="text" name="title" id="power" required lay-verify="required"
					placeholder="权限" autocomplete="off" class="layui-input">
			</div>
		</div>
		<button class="layui-btn btn-yes">确认</button><button class="layui-btn btn-cancel">取消</button>
	</div>

	<script src="${contextPath}/lottery/js/jquery.js"></script>
	<script src="${contextPath}/lottery/js/base.js"></script>
	<script src="${contextPath}/lottery/layui/layui.js"></script>


	<script type="text/javascript"
		src="${contextPath}/lottery/js/page/user_service_add.js"></script>
</body>
</html>