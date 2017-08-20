<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/user_manager.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>
	<div class="body-content">
		<div class="layui-form-item">
			<label class="layui-form-label">充值账号</label>
			<div class="layui-input-inline">
				<input type="text" name="username" lay-verify="required"
					disabled="disabled" placeholder="${user.account }"
					autocomplete="off" class="layui-input">
			</div>
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-inline">
				<input type="text" disabled="disabled" name="username"
					lay-verify="required" placeholder="${user.name }"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">当前积分值</label>
			<div class="layui-input-inline">
				<input type="text" disabled="disabled" name="username"
					lay-verify="required" placeholder="${user.lBi }" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<hr class="layui-bg-orange">
		<div class="layui-form-item">
			<label class="layui-form-label">充值金额</label>
			<div class="layui-input-inline">
				<input type="text" id="payMoney" lay-verify="required"
					placeholder="请输入交易金额" autocomplete="off" class="layui-input">
			</div>
			<label class="layui-form-label">交易单号</label>
			<div class="layui-input-inline">
				<input type="text" id="docNo" lay-verify="required"
					placeholder="请输入交易单号" autocomplete="off" class="layui-input">
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">充值积分</label>
			<div class="layui-input-inline">
				<input type="text" id="inQty" lay-verify="required"
					placeholder="请输入要充值积分数量" autocomplete="off" class="layui-input">
			</div>
			<label class="layui-form-label">充值后积分</label>
			<div class="layui-input-inline">
				<input type="text" name="username" lay-verify="required"
					disabled="disabled" placeholder="${user.lBi }" autocomplete="off"
					class="layui-input">
			</div>
		</div>

		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">补充说明</label>
			<div class="layui-input-block">
				<textarea id="remark" placeholder="请输入为何要充值，充值理由"
					class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="btn-center">
			<button class="layui-btn layui-btn-warm btn-yes fl"
				data-url="${submitUrl }" data-id="${user.id }">确定充值</button>
			<button class="layui-btn fl btn—cancel">取消</button>
		</div>

	</div>


	<script src="${contextPath}/lottery/layui/layui.js"></script>
	<script src="${contextPath}/lottery/js/jquery.js"></script>
	<script src="${contextPath}/lottery/js/page/recharge.js"></script>

</body>
</html>