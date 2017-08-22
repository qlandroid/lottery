var laypage;
var layer;
var isFirstLoad = true;
$(document).ready(layui.use([ 'laypage', 'layer' ], function() {
	 laypage = layui.laypage;
	 layer = layui.layer;
	
	var d = getParams();
	http( d);
	
	$("#btn-search").on("click",function(){
		var url = $(this).data('url');
		// iframe层
		 layer.open({
			 
			 tips: [1, '#c00'],
		   type: 2,
		   move:false,
		   title: '按条件查询用户',
		   shadeClose: true,
		   shade: 0.8,
		   area: ['100%', '90%'],
		   content: $("#btn-search").data("url") // iframe的url
		 });
	});

}));

function loadSuccess(data){
	if (data.code == 200) {
		console.log(data);
		var tBody = addTrTbody(data.data);
		$("#tabelBody").html(tBody);
		if (isFirstLoad) {
			isFirstLoad = false;
			var nav = navIndex(data.count, layer);
			laypage.render(nav);
		}
	} else {
		layer.alert("错误编码:" + data.code + ",错误信息:" + data.msg);
	}
}

function loadListDate(params){
	isFirstLoad = true;
	params.page = $('#tabelList').data("page");
	params.pageSize = $("#tabelList").data('size');
	replaceParams(params);
	 var p =JSON.stringify(params)
	http(params,function (data){
		if (data.code == 200) {
			console.log(data);
			var tBody = addTrTbody(data.data);
			$("#tabelBody").html(tBody);
			if (isFirstLoad) {
				isFirstLoad = false;
				var nav = navIndex(data.count, layer);
				laypage.render(nav);
			}
		} else {
			layer.alert("错误编码:" + data.code + ",错误信息:" + data.msg);
		}
	});
}

function getParams(){
	return {
		incomeDocNo:$("#tabelList").data("incomeDocNo")
		,account:$("#tabelList").data("account")
		,payMoney:$("#tabelList").data("payMoney")
		,inQty:$("#tabelList").data("inQty")
		,status:$("#tabelList").data("status")
		,incomeCreateDate:$("#tabelList").data("incomeCreateDate")
		,page:$("#tabelList").data("page")
		,pageSize:$("#tabelList").data("size")
	}
}

function replaceParams(params){
	$('#tabelList').attr("data-incomeDocNo",params.incomeDoc);
	$('#tabelList').attr("data-account",params.account);
	$('#tabelList').attr("data-payMoney",params.payMoney);
	$('#tabelList').attr("data-incomeInQty",params.inQty);
	$('#tabelList').attr("data-status",params.status);
	$('#tabelList').attr("data-incomeCreateDate",params.incomeCreateDate);
	$('#tabelList').attr("data-incomeEndDate",params.incomeEndDate);
}

function navIndex(count, layer) {
	return {
		elem : 'navIndex',
		count : count,
		groups : 10,
		layout : [ 'count', 'prev', 'page', 'next', 'limit', 'skip' ],
		jump : function(obj, first) {
			console.log(obj)
			// 第一次不执行
			if (!first) {
				$("#tabelList").attr("page", obj.curr);
				$("#tabelList").attr("size", obj.limit);
				var d = getParams();
				d.page = obj.curr;
				d.pageSize = obj.limit;
				http( d, function(data) {
					if (data.code == 200) {
						console.log(data);
						var tBody = addTrTbody(data.data);
						$("#tabelBody").html(tBody);
					} else {
						layer.alert("错误编码:" + data.code + ",错误信息:" + data.msg);
					}
				});
			}
		}
	}
}

function http( d) {
	var url = $("#tabelList").data("url");
	console.log(url);
	$.ajax({
		url : url,
		type : 'POST',
		dataType : 'json',
		data : d,
		success : function(data){
			loadSuccess(data)
		},
		error : function() {
			layer.msg("连接异常");
		}
	});
}

function addTrTbody(dataList) {
	var tBody = "";
	for (var i = 0; i < dataList.length; i++) {
		tBody = tBody + "<tr>";
		tBody = tBody + addLine(i + 1, dataList[i]);
		tBody = tBody + "</tr>";
	}
	return tBody;
}
function addLine(index, data) {
	var line = "<td>" + index + "</td>"
	line = line + "<td>" + data.incomeDocNo + "</td>"
	line = line + "<td>" + data.account + "</td>"
	line = line + "<td>" + data.payMoney + "</td>"
	line = line + "<td>" + data.incomeInQty + "</td>"
	//'当前交易状态0-未支付，1-支付完成，2-订单超时，3-取消订单'
	if(data.status == '0'){
		line = line + "<td>" + "未完成" + "</td>"
	}else if(data.status == '1'){
		line = line + "<td>" + "支付完成"  + "</td>"
	}else if(data.status == '2'){
		line = line + "<td>" + "订单超时" + "</td>"
	}else if(data.status == '3'){
		line = line + "<td>" + "取消订单"+ "</td>"
	}else{
		line = line + "<td>" + "+" + data.status + "</td>"
	}
	line = line + "<td>" + data.zhifubaoDoc + "</td>"
	line = line + "<td>" + "<span class='color-afterqty'>"
			+ formatDateTime(data.incomeCreateDate) + "</span></td>"
	return line;
}
