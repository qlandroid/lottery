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
<link rel="stylesheet" href="${contextPath}/lottery/css/main.css">
<link rel="stylesheet" href="${contextPath}/lottery/css/base.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/lottery/lottery_clazz_list.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>
	<div class="layui-side layui-bg-blac">
		<div class="nav-btn-group">
			<div class="layui-container">
				<button class="layui-btn layui-bg-cyan btn-add nav-btn layui-show"
					title="彩票类型" url="${staticTypeUrl}">彩票类型</button>
			</div>
			<div class="layui-container">
				<button class="layui-btn layui-bg-cyan btn-add nav-btn layui-show"
					title="添加大类" url="${addClassUrl}">添加大类</button>
			</div>
			<div class="layui-container">
				<button class="layui-btn btn-add nav-btn layui-show" title="添加彩票类型"
					url="${addTypeUrl}">添加彩票类型</button>
			</div>
			<div class="layui-container">
				<button class="layui-btn layui-bg-orange btn-add nav-btn layui-show"
					title="添加满积分彩票" url="${addFillUrl}">添加满积分彩票</button>
			</div>
		</div>
		<div class="nav-tree">
			<ul id="clazzTree" data-url="${treeAll }"></ul>
		</div>
	</div>
	<div class="layui-body layui-form">
		<iframe id="clazzFrame" style="width:100%;height:100%"></iframe>
	</div>


	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/page/lottery/lottery_clazz_list.js"></script>
</body>
</html>