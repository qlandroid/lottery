<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>添加彩票</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet" href="${contextPath}/lottery/css/base.css">

<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/user_service_manager.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/lottery/lottery_clazz_add.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>

	<input class="layui-hide" id="params" type-id="${typeId }" model-url="${modelUrl }"
		create-url="${createUrl }">
	<div>
		<div>
			名称:<input class="layui-input" id="name" type="text">
		</div>
		<div>
			期数:<input class="layui-input" id="lotteryStage" disabled="disabled" type="text">
		</div>
		<div>
			满:<input class="layui-input" id="fillLBi" disabled="disabled"
				type="text">
		</div>
		<div>
			奖金:<input class="layui-input" id="awardLBi" disabled="disabled"
				type="text">
		</div>
	</div>
	<div id="btn-group">
		<button class="layui-btn" id="btnCreate">创建</button>
		<button class="layui-btn layui-hide" id="btnClose">创建</button>
	</div>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/page/lottery/fill/create_fill_open.js"></script>
</body>
</html>