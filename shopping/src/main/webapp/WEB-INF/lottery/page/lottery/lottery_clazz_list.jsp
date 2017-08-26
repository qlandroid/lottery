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
<link rel="stylesheet" href="${contextPath}/lottery/css/base.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/user_service_manager.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>
	<button class="layui-btn btn-add" title="添加大类" url="${addClassUrl}">添加大类</button>
	<button class="layui-btn btn-add" title="添加彩票类型" url="${addTypeUrl}">添加彩票类型</button>
	<button class="layui-btn btn-add" title="添加满积分彩票" url="${addFillUrl}">添加满积分彩票</button>
	<ul id="clazzTree" data-url="${treeAll }"></ul>

	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/page/lottery/lottery_clazz_list.js"></script>
</body>
</html>