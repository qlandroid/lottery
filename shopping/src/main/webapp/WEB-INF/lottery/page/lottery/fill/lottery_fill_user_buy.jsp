<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>用户选择彩票</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet" href="${contextPath}/lottery/css/base.css">

<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/user_service_manager.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/lottery/lottery_clazz_add.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>
	<div class="tree-body fl">
		<span>点击选择上级父类</span>
		<hr class="layui-bg-red">
		<ul id="clazzTree" data-url="${clazzUrl }"></ul>
	</div>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/page/lottery/fill/lottery_fill_user_buy.js"></script>
</body>
</html>