<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>生成中奖用户</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet" href="${contextPath}/lottery/css/base.css">

<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/user_service_manager.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/lottery/lottery_clazz_add.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>
<input class="layui-hide" data-id="${fillOpenId}">
	<div class="content-tab-body">
		<table class="layui-table" lay-filter="lotteryList"
			lay-data="{ url:'${fillUserList }?lotteryFillOpenId=${fillOpenId }', page:true, id:'lotteryList'}">
			<thead>
				<tr>
					<th lay-data="{field:'id', width:80, sort: true}">ID</th>
					<th
						lay-data="{field:'account', width:170, sort: true}">账号</th>
					<th lay-data="{field:'lotteryFillBuyQty', width:135, sort: true}">购买数量</th>
					<th lay-data="{field:'createTime', width:180,templet:'#fCreateDate'}">购买时间</th>

					<th lay-data="{field:'docNo', width: 240}">订单号</th>
				</tr>
			</thead>
		</table>
	</div>
	
	<script type="text/html" id="fCreateDate">
  		{{# var date = formatDateTime(d.createTime) ; }}
		{{ date}}
</script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/page/lottery/fill/fill_user_list.js"></script>
</body>
</html>