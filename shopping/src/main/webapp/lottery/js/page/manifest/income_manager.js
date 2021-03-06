var laypage;
var layer;
var isFirstLoad = true;
$(document).ready(layui.use([ 'laypage', 'layer' ], function() {
	laypage = layui.laypage;
	layer = layui.layer;

	var d = getParams();
	http(d);

	$("#btn-search").on("click", function() {
		var url = $(this).data('url');
		// iframe层
		layer.open({

			tips : [ 1, '#c00' ],
			type : 2,
			move : false,
			title : '按条件查询用户',
			shadeClose : true,
			shade : 0.8,
			area : [ '100%', '90%' ],
			content : $("#btn-search").data("url")
		// iframe的url
		});
	});

}));

function loadSuccess(data) {
	if (data.code == 200) {
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

function loadListDate(params) {
	replaceParams(params);
	
	isFirstLoad = true;
	params.page = $('#tabelList').data("page");
	params.pageSize = $("#tabelList").data('size');
	
	http(params);
}
function replaceParams(params) {
	$('#tabelList').attr("data-incomeDocNo", params.incomeDoc);
	$('#tabelList').attr("data-account", params.account);
	$('#tabelList').attr("data-payMoney", params.payMoney);
	$('#tabelList').attr("data-incomeInQty", params.inQty);
	$('#tabelList').attr("data-status",params.status);
	$('#tabelList').attr("data-incomeCreateDate", params.incomeCreateDate);
	$('#tabelList').attr("data-incomeEndDate", params.incomeEndDate);
	
}

function getParams() {
	var p = {};
	p.incomeDocNo = $("#tabelList").data("incomeDocNo");
	p.account = $("#tabelList").data("account");
	p.payMoney = $("#tabelList").data("payMoney");
	p.inQty = $("#tabelList").data("inQty");
	
	p.status = document.getElementById("tabelList").getAttribute("data-status");
	p.incomeCreateDate = $("#tabelList").data("incomeCreateDate");
	p.page = $("#tabelList").data("page");
	p.pageSize = $("#tabelList").data("size");
	return p;
}

function navIndex(count, layer) {
	return {
		elem : 'navIndex',
		count : count,
		groups : 10,
		layout : [ 'count', 'prev', 'page', 'next', 'limit', 'skip' ],
		jump : function(obj, first) {
			// 第一次不执行
			if (!first) {
				$("#tabelList").attr("data-page", obj.curr);
				$("#tabelList").attr("data-size", obj.limit);
				var p = getParams();
				p.page = obj.curr;
				p.pageSize = obj.limit;
				http(p);
			}
		}
	}
}

/**
 * var p ={ incomeDocNo:incomeDoc ,account:account ,payMoney:payMoney
 * ,incomeInQty:inQty ,status:status } ;
 * 
 * @param params
 */
function http(params) {
	var url = $("#tabelList").data("url");
	var p = {};
	
	p.status = params.status;
	p.incomeDoc = params.incomDoc;
	p.account = params.account;
	p.payMoney = params.payMoney;
	p.incomeInQty = params.incomeInQty;
	p.incomeCreateDate = params.incomeCreateDate;
	p.incomeEndDate = params.incomeEndDate;
	p.pageSize = params.pageSize;
	p.page = params.page;
	
	console.log(p)
	$.ajax({
		url : url,
		type : 'POST',
		dataType : 'json',
		data : p,
		success : function(data) {
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
	// '当前交易状态0-未支付，1-支付完成，2-订单超时，3-取消订单'
	if (data.status == '0') {
		line = line + "<td>" + "未完成" + "</td>"
	} else if (data.status == '1') {
		line = line + "<td>" + "支付完成" + "</td>"
	} else if (data.status == '2') {
		line = line + "<td>" + "订单超时" + "</td>"
	} else if (data.status == '3') {
		line = line + "<td>" + "取消订单" + "</td>"
	} else {
		line = line + "<td>" + "+" + data.status + "</td>"
	}
	line = line + "<td>" + data.zhifubaoDoc + "</td>"
	line = line + "<td>" + "<span class='color-afterqty'>"
			+ formatDateTime(data.incomeCreateDate) + "</span></td>"
	return line;
}
