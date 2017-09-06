<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>修改個人詳情</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/lottery_0.css">
</head>
<body>
	<div class="layui-form">
		<div class="layui-form-item">
			<label class="layui-form-label">账号</label>
			<div class="layui-input-block">
				<span type="text" id="account" name="title" required lay-verify="required"
					class="layui-input" data-id="${user.userId }"> ${user.account }</span>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密碼</label>
			<div class="layui-input-block">
				<input type="text" name="title" id="pw" required lay-verify="required"
					placeholder="${user.pw }" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-block">
				<input type="text" name="title" id="name" required lay-verify="required"
					placeholder="${user.name }" autocomplete="off" class="layui-input">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">电话</label>
			<div class="layui-input-block">
				<input type="text" name="title" id="phone" required lay-verify="required"
					placeholder="${user.phone }" autocomplete="off" class="layui-input">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">支付宝账号</label>
			<div class="layui-input-block">
				<input type="text" name="title" id="zhifubao" required lay-verify="required"
					placeholder="${user.zhifubao }" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">身份证号</label>
			<div class="layui-input-block">
				<input type="text" name="title" id="clientId" required lay-verify="required"
					placeholder="${user.clientId }" autocomplete="off" class="layui-input">
			</div>
		</div>
		<button class="layui-btn btn-yes" data-url="${changeUrl }">确认</button><button class="layui-btn btn-cancel">取消</button>
	</div>

	<script src="${contextPath}/lottery/js/jquery.js"></script>
	<script src="${contextPath}/lottery/js/base.js"></script>
	<script src="${contextPath}/lottery/layui/layui.js"></script>


	<script type="text/javascript"
		src="${contextPath}/lottery/js/page/user_client_change.js"></script>
</body>
</html>