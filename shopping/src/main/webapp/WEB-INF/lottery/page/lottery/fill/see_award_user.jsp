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
			<h1 style="font-size: 20px; color: black; margin: 10px">彩票信息</h1>
			<hr class="layui-bg-red" width="100px">
			<div class="layui-form-item">
				<label class="layui-form-label">开奖号码</label>
				<div class="layui-input-block">
					<c:if test="${fillOpen.status  == 1}">
						<input type="text" required lay-verify="required"
							value="${fillOpen.number }" autocomplete="off"
							disabled="disabled" class="layui-input">
					</c:if>
					<c:if test="${fillOpen.status  == 0}">

						<input type="text" required lay-verify="required" value="还没有开奖"
							style="color: red" autocomplete="off" disabled="disabled"
							class="layui-input">
					</c:if>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">期数:</label>
				<div class="layui-input-block">
					<input type="text" disabled="disabled" lay-verify="required"
						value="${fillOpen.lotteryStage }" autocomplete="
						off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">奖金积分:</label>
				<div class="layui-input-block">
					<input type="text" disabled="disabled" lay-verify="required"
						value="${fillOpen.awardLBi }" autocomplete="
						off"
						class="layui-input">
				</div>
			</div>
			<div></div>
		</div>
		<br> <br> <br>
		<c:if test="${fillOPen.sendStatus } == 1">
			<H1>奖金已经发放</H1>
		</c:if>
		<c:if test="${fillOpen.status ==1 }">
			<div>
				<h1 style="font-size: 20px; color: black; margin: 10px">中奖人信息</h1>
				<hr class="layui-bg-red" width="100px">
				<div class="layui-form-item">
					<label class="layui-form-label">账号:</label>
					<div class="layui-input-block">
						<input type="text" disabled="disabled" lay-verify="required"
							value="${awardUser.account }" autocomplete="
						off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">姓名:</label>
					<div class="layui-input-block">
						<input type="text" disabled="disabled" lay-verify="required"
							value="${awardUser.name }" autocomplete="
						off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">当前积分数量:</label>
					<div class="layui-input-block">
						<input type="text" disabled="disabled" lay-verify="required"
							value="${awardUser.lBi }" autocomplete="
						off"
							class="layui-input">
					</div>
				</div>
			</div>
		</c:if>
	</div>
	<br>
	<br>

	<c:if test="${fillOpen.status } != 1">
		<div>
			支付密码:<input class="layui-input" type="password" id="inputPw">
		</div>

		<div>
			<button id="sendLBi" class="layui-btn"
				data-id="${fillOpen.lotteryFillOpenId }" data-url="${sendLBi }">发放奖金</button>
		</div>
	</c:if>

	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/page/lottery/fill/send_award_user.js"></script>
</body>
</html>