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


	<div>
		<button class="layui-btn" data-url="${serachViewUrl }" id="btn-search">查詢</button>
		</dir>

		<div class="content-tab-body">
			<table class="layui-table" lay-filter="expendList"
				lay-data="{ url:'${expendList }', page:true, id:'expendList'}">
				<thead>
					<tr>
						<th lay-data="{field:'id', width:80, sort: true}">ID</th>
						<th
							lay-data="{field:'docNo', width:260, sort: true}">订单号</th>
						<th lay-data="{field:'status', width:135, sort: true}">订单状态</th>
						<th lay-data="{field:'createTime', width:180,templet:'#fCreateDate'}">创建时间</th>

						<th lay-data="{field:'account', width: 90}">所属用户</th>
						<th
							lay-data="{field:'lotteryTypeId', width:120, sort: true, style:'background-color: #fff;'}">购买彩票类型</th>
						<th lay-data="{field:'afterQty', width:120, sort: true}">消费前积分</th>
						<th
							lay-data="{field:'beforeQty', width:120,style:'background-color: #990033; color: #fff;' ,sort: true}">消费后积分</th>
						<th
							lay-data="{field:'expendQty', width:120, style:'background-color: #5FB878; color: #fff;', templet:'#fSendStatus'}">消费积分</th>
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
			src="${contextPath }/lottery/js/page/manifest/expend_manager.js"></script>
</body>
</html>