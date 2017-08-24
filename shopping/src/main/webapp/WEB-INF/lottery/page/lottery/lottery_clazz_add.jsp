<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>添加彩票大类</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/add_user.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/user_service_manager.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>

	<div class="layui-form" action="">
	
		
		<div class="layui-form-item">
			<label class="layui-form-label">大类名称</label>
			<div class="layui-input-block">
				<input type="text" id="clazzName" name="title" lay-verify="title"
					autocomplete="off" placeholder="大类名称" class="layui-input">
			</div>
		</div>


		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入内容" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<button class="layui-btn" id="btnAdd"data-url="${addUrl }"lay-submit="" lay-filter="demo1">添加大类</button>
			<button class="layui-btn" id="btnCancel""lay-submit="">取消</button>
		</div>
	</div>
<ul id="clazzTree" data-url="${clazzUrl }"></ul>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/page/lottery/lottery_clazz_add.js"></script>
</body>
</html>