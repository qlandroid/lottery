<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>彩票</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/add_user.css">
<link rel="stylesheet" href="${contextPath}/lottery/css/main.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>
	<input class="layui-hide" id="params" open-award="${openAwardUrl }"
		see-user="${seeUserList }" url='${fillOpenList }' add-lottery="${addLotteryUrl }" see-award="${seeAwardUserUrl }">

	<div class="">
		<div class="">
			<button class="layui-btn btn-reload" data-type="all">查看全部</button>
			
			<button class="layui-btn btn-reload" data-type="notAward">未开奖</button>
			<button class="layui-btn btn-reload" data-type="canAward">可开奖</button>
			
			<button class="layui-btn btn-reload" data-type="addLottery" type-id="${typeId }">添加彩票</button>
		</div>
	</div>
	<div class="content-tab-body">
		<table id="lotteryList" lay-data="{page:true}"class="layui-table" lay-filter="lotteryList">
		</table>
	</div>
	<div id="navIndex"></div>
	<script type="text/html" id="fLotteryStage">
		<span	
  		{{# if(d.overBuyQty == d.fillLBi){ }}
		 class="layui-bg-red"
{{# } }}
	>{{d.lotteryStage}}</span>
</script>
	<script type="text/html" id="fCreateDate">
  		{{# var date = formatDateTime(d.lotteryFillCreaterDate) ; }}
		{{ date}}
</script>
	<script type="text/html" id="fEndDate">
  		{{# var date = formatDateTime(d.lotteryFillEndDate) ; }}
		{{ date}}
</script>
	<script type="text/html" id="fNumber">
  		{{# if(!d.openNumber) { }}
			<a class="layui-btn layui-btn-mini btn-start-award 
				{{# if(d.overBuyQty != d.fillLBi){ }}
					layui-btn-disabled
				{{# } }}
			" data-id="{{ d.lotteryFillOpenId}}" lay-event="openAward">开奖</a>
		{{# }else { }}
			<button class="btn-award-user" >{{d.openNumber}}</button>
		{{# } }}
</script>
	<script type="text/html" id="fSendStatus">
  		{{# if(d.sendStatus == 0) { }}
			<span class="send-status-not">未支付</span>
		{{# }else if(d.sendStatus == 1){ }}
			<span class="send-status">已经支付</span>
			
		{{# } }}
</script>
	<script type="text/html" id="barDemo">
			<button class="layui-btn layui-btn-mini" data-id="{{ d.lotteryFillOpenId}}" lay-event="seeAwardUser">查看中奖用户</button>
			<button class="layui-btn layui-btn-mini" data-id="{{ d.lotteryFillOpenId}}" lay-event="seeBugUser">查看购买用户</button>

</script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/layui/layui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/lottery/js/page/lottery/fill/lottery_open.js"></script>
</body>
</html>