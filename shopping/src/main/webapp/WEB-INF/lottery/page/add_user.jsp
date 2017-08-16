<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>添加用户</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet" href="${contextPath}/lottery/css/page/add_user.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>
	<div class="layui-form-item">
		<label class="layui-form-label">账号</label>

		<div class="layui-input-block">
			<input type="text" id="account" lay-verify="title" autocomplete="off"
				placeholder="请输入账号" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">密码</label>

		<div class="layui-input-block">
			<input type="password" id="pw" lay-verify="title" autocomplete="off"
				placeholder="请输入账号" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">手机号码</label>

		<div class="layui-input-block">
			<input type="text" id="phone" lay-verify="title" autocomplete="off"
				placeholder="手机号码" class="layui-input">
		</div>
	</div>

	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">验证手机</label>

			<div class="layui-input-inline">
				<input type="tel" name="phone" lay-verify="phone" autocomplete="off"
					class="layui-input">
			</div>
		</div>

		<button class="layui-btn layui-inline">发送验证码</button>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">邮箱</label>

		<div class="layui-input-block">
			<input type="email" id="eMail" lay-verify="title" autocomplete="off"
				placeholder="邮箱" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">验证邮箱</label>

			<div class="layui-input-inline">
				<input type="text" name="email" lay-verify="email"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<button class="layui-btn layui-inline">发送验证码</button>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">收获地址</label>

		<div class="layui-input-block">
			<input type="text" id="address" lay-verify="title" autocomplete="off"
				placeholder="请输入收获地址" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">身份证</label>

		<div class="layui-input-block">
			<input type="text" id="userId" lay-verify="title" autocomplete="off"
				placeholder="请输入身份证号" class="layui-input">
		</div>
	</div>

	<div class="layui-form-item">
		<label class="layui-form-label">身份证</label>

		<div class="layui-input-block">
			<input type="file" placeholder="请上传身份证正面"> <input type="file"
				placeholder="请上传身份证背面">
		</div>
	</div>


	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" id="btn-submit" lay-submit=""
				lay-filter="demo1">立即提交</button>
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</div>

	<script src="${contextPath}/lottery/js/jquery.js"></script>
	<script>
		$(document).ready(function() {
			$("#btn-submit").click(function() {
				var account = $("#account").val();
				var pw = $("#pw").val();
				var data = {
					account : account,
					pw : pw
				}
				$.ajax({
					data : data,
					dataType : "JSON",
					url : base_url + "/user/register.do",
					success : function(data) {
						alert(data.code);
					},
					error : function() {
						alert("错误");
					},
					type : "POST"
				})
			});

		});
	</script>
</body>
</html>