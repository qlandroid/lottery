var laypage;
var layer;
var isFirstLoad = true;
$(document).ready(layui.use([ 'laypage', 'layer' ], function() {
	 laypage = layui.laypage;
	 layer = layui.layer;
	
	var d = params();
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
	$('#tabelList').attr("incomeDoc",params.incomeDoc);
	$('#tabelList').attr("account",params.account);
	$('#tabelList').attr("paymoney",params.payMoney);
	$('#tabelList').attr("inQty",params.inQty);
	$('#tabelList').attr("status",params.status);
	$('#tabelList').attr("createDate",params.createDate);
	$('#tabelList').attr("endDate",params.endDate);
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
				var d = params();
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

function params() {
	var page = $("#tabelList").data("page");
	var pageSize = $("#tabelList").data("size");

	var a = {
		page : page,
		pageSize : pageSize
	}
	console.log(a);
	return a;
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
	line = line + "<td>" + data.inQty + "</td>"
	line = line + "<td>" + "+" + data.status + "</td>"
	line = line + "<td>" + data.zhifubaoDoc + "</td>"
	line = line + "<td>" + "<span class='color-afterqty'>"
			+ formatDateTime(data.endDate) + "</span></td>"
	return line;
}
