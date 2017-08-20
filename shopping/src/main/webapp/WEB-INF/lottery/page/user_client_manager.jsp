<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>用户端管理</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/add_user.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/user_service_manager.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>
	<input type="text" id="params"  data-total="${total }"
		data-page="${page}" 
		data-url="${contextPath }"
		data-name="${params.name }" 
		data-phone="${params.phone }"
		data-zhifubao="${params.zhifubao }"
		data-clientId="${params.clientId }"
		class="layui-hide">
	<div class="btn-group">
		<input class="layui-input fl" id="searchContent" placeholder="账号搜索"
			type="text">
		<button class="layui-btn" data-url="${url }" id="search">搜索</button>
		<button class="layui-btn" data-url="${searchViewUrl }" id="btn-search">条件查询</button>
		<button class="layui-btn layui-btn-warm" data-url="${addViewUrl }" id="btn-add">添加用户</button>
		<button class=" layui-btn layui-btn-dange" id="btn-del">批量删除</button>
	</div>
	<div class="content-tab-body">
		<table class="layui-table">
			<colgroup>
				<col width="50">
				<col width="150">
				<col width="150">
				<col width="100">
				<col width="100">
				<col>
			</colgroup>
			<thead>

				<tr>
					<th><input type="checkbox" name="" lay-skin="primary"
						lay-filter="allChoose"></th>
					<th>账号</th>
					<th>姓名</th>
					<th>电话</th>
					<th>积分</th>
					<th>消费积分</th>
					<th>操作</th>
				</tr>

			</thead>
			<tbody>
				<c:forEach items="${userList }" var="user" varStatus="i">
					<tr>
						<td><input type="checkbox" name="" lay-skin="primary"></td>
						<td><a href="javascrip:;" class="a-user"
							data-id="${user.id }">${user.account }</a></td>
						<td>${user.name }</td>
						<td>${user.phone }</td>
						<td>${user.lBi }</td>
						<td>${user.expendLBi }</td>
						<td>
							<button class="layui-btn layui-btn-mini" id="btnDecode"
								type="changePw"  data-id="${user.id }">消费记录</button>
							<button class="layui-btn layui-btn-mini btn-change-pw"
							id="btnIncome"
								type="changePw" data-url="${incomeViewUrl } data-id="${user.id }">充值</button>
							<button class="layui-btn layui-btn-mini btn-change-pw"
							id="btnChange"
							data-url="${changeViewUrl }"
								type="changePw" data-id="${user.id }">修改</button>
							<button
							id="btnDel"
								class="layui-btn  layui-btn-mini layui-btn-danger btn-del-user"
								data-url="${deleteViewUrl }"
								type="del" data-id="${user.id }">删除</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="navIndex" data-total="${pageTotal }"
	data-url="${url }"
	data-page="${page }"
	 class="nav-left"></div>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/page/user_client_manager.js"></script>
</body>
</html>