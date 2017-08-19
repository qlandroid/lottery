<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<input type="text"  id="params" 
		data-account="${params.account }"
		data-power="${params.power }"
		data-page=""
		 class="layui-hide">
	<div class="btn-group">
		<input class="layui-input fl" id="searchContent" placeholder="账号搜索"  type="text">
		<button class="layui-btn" data-url="${searchUrl }" id="btnSearchContent">搜索</button>
		<button class="layui-btn" data-url="${searchViewUrl }" id="btn-search">条件查询</button>
		<button class="layui-btn   layui-btn-warm"  data-url="${addUserViewUrl }"id="btn-add">添加用户</button>
		<button class=" layui-btn layui-btn-dange" data-url=""  id="btn-del">批量删除</button>
		<div class="rf">
			<span>用户是总数${totalUser }</span>
		</div>
	</div>
	<div class="content-tab-body">
		<table class="layui-table">
			<colgroup>
				<col width="50">
				<col width="150">
				<col width="150">
				<col width="200">
				<col width="50">
				<col>
			</colgroup>
			<thead>

				<tr>
					<th><input type="checkbox" name="" lay-skin="primary"
						lay-filter="allChoose"></th>
					<th>账号</th>
					<th>姓名</th>
					<th>电话</th>
					<th>权限</th>
					<th>操作</th>
				</tr>

			</thead>
			<tbody>
				<c:forEach items="${userList }" var="user" varStatus="i">
					<tr>
						<td><input type="checkbox" name="" lay-skin="primary"></td>
						<td>${user.account }</td>
						<td>${user.name }</td>
						<td>${user.phone }</td>
						<td>${user.power }</td>
						<td><button
								class="layui-btn  layui-btn-mini layui-btn-danger btn-del-user" data-url="${deleteUrl }"
								data-id="${user.id }">删除</button>
							<button class="layui-btn layui-btn-mini btn-change-pw" data-url="${changeViewUrl }"
								data-id="${user.id }">修改密码</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="navIndex" data-total="${total }" data-url="${searchUrl }"data-page="${page}" class="nav-left"></div>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/page/user_service_manager.js"></script>
</body>
</html>