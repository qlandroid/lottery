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
	<div>
		<div>
			<h1>彩票信息</h1>
			<div>开奖号码:${fillOpen.openNumber }</div>
			
			<div>期数:${fillOpen.lotteryStage }</div>
			<div>奖金积分:${fillOpen.awardLBi }</div>
		</div>
		<br>
		<br>
		<br>
		<div>
			<h1>中奖人信息</h1>
			<div>账号:${awardUser.account }</div>
			<div>姓名:${awardUser.name }</div>
			<div>当前积分数量:${awardUser.lBi }</div>
		</div>
	</div>
	
	<div>
		支付密码:<input class="layui-input" type="password" id="inputPw">
	</div>
	<div>
		<button id="sendLBi" class="layui-btn" data-id="${fillOpen.lotteryFillOpenId }" data-url="${sendLBi }">开奖</button>
	</div>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/page/lottery/fill/send_award_user.js"></script>
</body>
</html>