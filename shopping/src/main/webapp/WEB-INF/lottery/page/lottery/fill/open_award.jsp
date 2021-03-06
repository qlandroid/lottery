<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>生成中奖用户</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet" href="${contextPath}/lottery/css/base.css">

<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/user_service_manager.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/lottery/lottery_clazz_add.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>
	<input class="layui-hide" id="params" data-id="${fillOpenId}" data-url="${userListUrl }" >

	<div>
		<div>
			开奖号码:<span>${fOpen.openNumber }</span>
		</div>
		<div>
			满:<span>${fOpen.fillLBi }</span>
		</div>
		<div>
			彩票名称:<span>${fOpen.lotteryFillName }</span>
		</div>
		<div>
			中奖奖金金额:<span>${fOpen.awardLBi }</span>
		</div>
		<div>
			创建日期:<span>${fOpen.lotteryFillCreaterDate }</span>
		</div>
		<div>
			创建日期:<span>${fOpen.lotteryFillCreaterDate }</span>
		</div>
		<div>
			<button class="layui-btn" data-url="${openAwardUrl }" data-id="${fillOpenId }"id="btnOpenAward">开奖</button>
		</div>
	</div>
	<div class="content-tab-body">
		<table class="layui-table" lay-filter="userList" id="userList"
			>
		</table>
	</div>

	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/page/lottery/fill/open_award.js"></script>
</body>
</html>