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
	<input class="layui-hide" id="params" see-user="${seeUserList }" url='${fillOpenList }'>
	
	<div class="">
		<div class="">
			<button class="layui-btn btn-reload" data-type="all">查看全部</button>
			<button class="layui-btn btn-reload" data-type="notAward">未开奖</button>
			<button class="layui-btn btn-reload" data-type="canAward">可开奖</button>
		</div>
	</div>
	<div class="content-tab-body">
		<table id="lotteryList" class="layui-table" lay-filter="lotteryList"
			lay-data="{ even: true  ,page:true, id:'lotteryList'}">
			<thead>
				<tr>
					<th lay-data="{field:'id', width:80, sort: true}">ID</th>
					<th
						lay-data="{field:'lotteryStage', width:170, sort: true,templet: '#fLotteryStage'}">期号</th>
					<th lay-data="{field:'lotteryFillName', width:135, sort: true}">彩票名称</th>
					<th lay-data="{field:'number', width:120,templet:'#fNumber'}">开奖号码</th>

					<th lay-data="{field:'createUserName', width: 90}">创建人</th>
					<th
						lay-data="{field:'fillLBi', width:80, sort: true, style:'background-color: #e2e2e2;'}">满</th>
					<th lay-data="{field:'awardLBi', width:80, sort: true}">奖金</th>
					<th
						lay-data="{field:'overBuyQty', width:80,style:'background-color: #990033; color: #fff;' ,sort: true}">购买数量</th>
					<th
						lay-data="{field:'sendStatus', width:80, style:'background-color: #5FB878; color: #fff;', templet:'#fSendStatus'}">是否发放奖金</th>
					<th
						lay-data="{field:'lotteryFillUnitPrice', width:135, sort: true}">倍数</th>
					<th
						lay-data="{field:'lotteryFillCreaterDate', width:180, sort: true,templet:'#fCreateDate'}">创建时间</th>
					<th lay-data="{field:'lotteryFillEndDate', width:180}">结束时间</th>
					<th
						lay-data="{fixed: 'right', width:260, align:'center', toolbar: '#barDemo'}">操作</th>
				</tr>
			</thead>
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
	<script type="text/html" id="fNumber">
  		{{# if(!d.number) { }}
		<a class="layui-btn layui-btn-mini btn-start-award 
			{{# if(d.overBuyQty != d.fillLBi){ }}
			layui-btn-disabled
			{{# } }}
			" data-id="{{ d.lotteryFillOpenId}}" lay-event="openAward">开奖</a>
		

{{# }else { }}
			<button class="btn-award-user" >{{d.number}}</button>
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
			<button class="layui-btn layui-btn-mini" data-id="{{ d.lotteryFillOpenId}}" lay-event="sendAward">发放奖金</button>
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