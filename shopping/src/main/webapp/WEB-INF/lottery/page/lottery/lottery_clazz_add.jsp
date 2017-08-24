<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>添加彩票大类</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/add_user.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/user_service_manager.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>

	<form class="layui-form" action="">
		<div data-url="${clazzUrl }" id="cc" class="layui-form-item">
			<label class="layui-form-label">联动选择框</label>
			<div class="layui-input-inline">
				<select name="quiz1">
					<option value="">请选择省</option>
					<option value="浙江" selected="">浙江省</option>
					<option value="你的工号">江西省</option>
					<option value="你最喜欢的老师">福建省</option>
				</select>
			</div>
			<div class="layui-input-inline">
				<select name="quiz2">
					<option value="">请选择市</option>
					<option value="杭州">杭州</option>
					<option value="宁波" disabled="">宁波</option>
					<option value="温州">温州</option>
					<option value="温州">台州</option>
					<option value="温州">绍兴</option>
				</select>
			</div>
			<div class="layui-input-inline">
				<select name="quiz3">
					<option value="">请选择县/区</option>
					<option value="西湖区">西湖区</option>
					<option value="余杭区">余杭区</option>
					<option value="拱墅区">临安市</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">大类名称</label>
			<div class="layui-input-block">
				<input type="text" name="title" lay-verify="title"
					autocomplete="off" placeholder="大类名称" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">验证必填项</label>
			<div class="layui-input-block">
				<input type="text" name="username" lay-verify="required"
					placeholder="请输入" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">验证手机</label>
				<div class="layui-input-inline">
					<input type="tel" name="phone" lay-verify="phone"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">验证邮箱</label>
				<div class="layui-input-inline">
					<input type="text" name="email" lay-verify="email"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">多规则验证</label>
				<div class="layui-input-inline">
					<input type="text" name="number" lay-verify="required|number"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">验证日期</label>
				<div class="layui-input-inline">
					<input type="text" name="date" id="date" lay-verify="date"
						placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">验证链接</label>
				<div class="layui-input-inline">
					<input type="tel" name="url" lay-verify="url" autocomplete="off"
						class="layui-input">
				</div>
			</div>
		</div>

		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入内容" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<button class="layui-btn" lay-submit="" lay-filter="demo2">跳转式提交</button>
		</div>
	</form>


	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/page/lottery/lottery_clazz_add.js"></script>
</body>
</html>