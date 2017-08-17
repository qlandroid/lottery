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
	<div class="search-btn">
		<button class="layui-btn">查询</button>
		<button class="layui-btn">添加用户</button>
		<button class="layui-btn layui-btn-danger" id="del-all-user">删除全部用户</button>
	</div>
	<div class="layui-side-scroll table-body" id="table">
		<table class="layui-table" style="width=500px" lay-even>
			<colgroup>
				<col width="70">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="70">
				<col width="70">
				<col width="70">
			</colgroup>
			<thead>

				<tr>
					<th>序号</th>
					<th>账号</th>
					<th>姓名</th>
					<th>联系电话</th>
					<th>地址</th>
					<th>密码</th>
					<th>权限</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList }" var="item" varStatus="i">
					<tr>
						<td>${i.index }</td>
						<td>${item.account}</td>
						<td>${item.name}</td>
						<td>${item.phone}</td>
						<td>${item.address}</td>
						<td>${item.pw}</td>
						<td>${item.power}</td>
						<td>
							<button>种类</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="index-nav" id="pageNav"></div>
	<script src="${contextPath}/lottery/layui/layui.js"></script>
	<script src="${contextPath}/lottery/js/jquery.js"></script>
	<script src="${contextPath}/lottery/js/page/user-manager.js"></script>

</body>
</html>