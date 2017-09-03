<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>彩票系统管理 登陆</title>
<link rel="stylesheet"
	href="${contextPath }/lottery/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${contextPath }/lottery/css/login.css"
	media="all" />
</head>
<body>

	<div class="video_mask"></div>
	<div class="login">
		<h1>layuiCMS-管理登录</h1>

		<div
			class="layui-form">
			<div class="layui-form-item">
				<input class="layui-input" id="account"value="admin" name="account"
					placeholder="用户名" lay-verify="required" type="text"
					autocomplete="off">
			</div>
			<div class="layui-form-item">
				<input class="layui-input"  id="pw"value="admin" name="pw" placeholder="密码"
					lay-verify="required" type="password" autocomplete="off">
			</div>
			
			<button class="layui-btn login-btn" lay-submit=""  id="login-btn" lay-filter="login">登录</button>
		</div>
	</div>

	<script type="text/javascript"
		src="${contextPath}/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath}/lottery/layui/layui.js"></script>
	<script type="text/javascript" src="${contextPath}/lottery/js/login.js"></script>
</body>
</html>