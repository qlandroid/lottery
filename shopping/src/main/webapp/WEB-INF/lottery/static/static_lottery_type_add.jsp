<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>添加彩票类型</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet" href="${contextPath}/lottery/css/base.css">

<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/user_service_manager.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/lottery/lottery_clazz_add.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>

	<div class="form-content fl">
		<div class="layui-form">
			<div class="layui-form-item">
				<label class="layui-form-label">类型名称</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input" id="typeName" data-id>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">类型标记</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input" id="type" data-id>
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">类型描述</label>
				<div class="layui-input-block">
					<textarea placeholder="类型描述" id="remark"class="layui-textarea"></textarea>
				</div>
			</div>
			<div class="layui-form-item btn-group">
				<button class="layui-btn layui-btn-warm" id="btnAdd"
					data-url="${addUrl }" lay-submit="" lay-filter="formDemo">添加类型</button>
				<button class="layui-btn" id="btnCancel" "lay-submit="">取消</button>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/static/static_lottery_type_add.js"></script>
</body>
</html>