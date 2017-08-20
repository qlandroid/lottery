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


	<div class="content-tab-body">
		<table class="layui-table">
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
			<tbody>
				<c:forEach items="${dcoList }" var="doc" varStatus="i">
					<tr>
						<td>${i.index +1 }</td>
						<td>${doc.incomeDocNo }</td>
						<td><a href="#">${doc.account }</a></td>
						<td>${doc.payMoney }</td>
						<td>${doc.inQty }</td>
						<td><c:if test="${doc.status== 0 } ">
								<span style="color: #ff0;">未支付</span>
							</c:if> <c:if test="${doc.status  == 1}">
								<span>支付完成</span>
							</c:if> <c:if test="${doc.status  == 2}">
								<span style="color: red;">订单超时</span>
							</c:if> <c:if test="${doc.status == 3} ">
								<span style="color: red;">取消订单</span>

							</c:if></td>
						<td>${doc.zhifubaoDoc }</td>
						<td><fmt:formatDate value="${doc.createDate}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="navIndex" data-total="${doc.totalPage }" data-url="${url }"
		data-page="${params.page}" class="nav-left"></div>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/page/user_service_manager.js"></script>
</body>
</html>