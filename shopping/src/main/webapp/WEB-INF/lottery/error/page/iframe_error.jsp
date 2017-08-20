<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>添加用户</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet" href="${contextPath}/lottery/css/page/add_user.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>
	<h1>出错了</h1>
	<button class="layui-btn">返回</button>
	<script src="${contextPath}/lottery/js/jquery.js"></script>
	<script>
		$(document).ready(function() {
			$(".layui-btn").click(function() {
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);
			});

		});
	</script>
</body>
</html>