<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>积分变化列表</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/add_user.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/user_service_manager.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>

	<div class="content-tab-body">
		<table class="layui-table" id="tabelList" data-url="${listUrl }" data-account=""
			data-operateDate="" data-type="" data-docNo="" data-page="1" data-size="10" data-opereateType>
			<colgroup>
				<col width="50">
				<col width="130">
				<col width="130">
				<col width="100">
				<col width="50">
				<col width="70">
				<col width="150">
				<col width="110">
			</colgroup>
			<thead>
				<tr>
					<th>序号</th>
					<th>用户名</th>
					<th>操作时间</th>
					<th>支付金额</th>
					<th>类型</th>
					<th>操作积分</th>
					<th>任务单据号</th>
					<th>变化后</th>
					<th>变化前</th>
					<th>任务单局来源</th>
				</tr>
			</thead>
			<tbody id="tabelBody" style="height:500px">
				
			</tbody>
		</table>
	</div>
	<div id="navIndex" ></div>
</body>

<script type="text/javascript"
	src="${contextPath }/lottery/js/jquery.js"></script>
<script type="text/javascript"
	src="${contextPath }/lottery/layui/layui.js"></script>
<script type="text/javascript"
	src="${contextPath }/lottery/js/page/manifest/l_bi_change_manfiest.js"></script>
</html>