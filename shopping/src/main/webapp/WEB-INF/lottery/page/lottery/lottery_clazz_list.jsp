<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>添加用户</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/add_user.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/user_service_manager.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>

	<div class="table-top-body">
		<div class="total-count-body">
			<div class="label-content layui-bg-red">
				<div class="label-content-1">
					总充值<span class="label-content-content">积分:${params.totalIncomeInQty }</span>
				</div>
			</div>
			<div class="label-content layui-bg-red">
				<div class="label-content-1">
					总充值<span class="label-content-content">金额:${params.totalPayMoney }</span>元
				</div>
			</div>
		</div>
		<div class="total-count-body">
			<div class="label-content layui-bg-green">
				<div class="label-content-1 ">
					筛选后积分:<span class="label-content-content ">${params.totalSelectInQty }</span>
				</div>
			</div>
			<div class="label-content layui-bg-green">
				<div class="label-content-1 ">
					筛选后金额:<span class="label-content-content ">${params.totalSelectPayMoney }</span>元
				</div>
			</div>
		</div>
	</div>
	
	<div>
		<button class="layui-btn" data-url="${serachViewUrl }" id="btn-search">查詢</button>
	</dir>

	<div class="content-tab-body">
		<table class="layui-table" data-page='1' data-status='' data-size="10" id="tabelList" data-url="${listUrl }">
			<colgroup>
				<col width="50">
				<col width="150">
				<col width="70">
				<col width="70">
				<col width="70">
				<col width="70">
				<col width="150">
				<col width="110">
			</colgroup>
			<thead>

				<tr>
					<th>序号</th>
					<th>充值订单</th>
					<th>账号</th>
					<th>支付金额</th>
					<th>充值积分</th>
					<th>订单状态</th>
					<th>支付宝订单号</th>
					<th>充值日期</th>
				</tr>

			</thead>
			<tbody id="tabelBody">
			</tbody>
		</table>
	</div>
	<div id="navIndex"></div>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/page/manifest/income_manager.js"></script>
</body>
</html>