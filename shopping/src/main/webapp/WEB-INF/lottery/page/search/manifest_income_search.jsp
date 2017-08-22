<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>收入单查询</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/lottery_0.css">
</head>
<body>
	<div class="layui-form">
		<div class="layui-form-item">
			<label class="layui-form-label">充值订单</label>
			<div class="layui-input-block">
				<input type="text" id="incomeDoc" required lay-verify="required"
					placeholder="充值订单" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">账号</label>
			<div class="layui-input-block">
				<input type="text" id="account" required lay-verify="required"
					placeholder="账号" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">支付金额</label>
			<div class="layui-input-block">
				<input type="text"  id="payMoney" required lay-verify="required"
					placeholder="支付金额" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">充值积分</label>
			<div class="layui-input-block">
				<input type="text" id="inQty" required lay-verify="required"
					placeholder="充值积分" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">订单状态</label>
			<div class="layui-input-block">
				<input type="text" name="title" id="status" required lay-verify="required"
					placeholder="订单状态" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">创建日期</label>
			<div class="layui-input-block">
				<input type="text" name="title" id="createDate" required lay-verify="required"
					placeholder="创建日期" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">充值日期</label>
			<div class="layui-input-block">
				<input type="text" name="title" id="endDate" required lay-verify="required"
					placeholder="结束日期" autocomplete="off" class="layui-input">
			</div>
		</div>
		<button class="layui-btn btn-yes" data-url="${searchUrl }">搜索</button>
		<button class="layui-btn btn-cancel">取消</button>
	</div>

	<script src="${contextPath}/lottery/js/jquery.js"></script>
	<script src="${contextPath}/lottery/js/base.js"></script>
	<script src="${contextPath}/lottery/layui/layui.js"></script>


	<script type="text/javascript"
		src="${contextPath}/lottery/js/page/search/manifest_income_search.js"></script>
</body>
</html>