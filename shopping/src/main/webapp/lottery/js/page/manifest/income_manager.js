$(document).ready(layui.use([ 'laypage', 'layer' ], function() {
	var laypage = layui.laypage;
	var layer = layui.layer;
	var isFirstLoad = true;
	var d = params();
	http(layer, d, function(data) {
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

}));

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
				http(layer, d, function(data) {
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

function http(layer, d, success) {
	var url = $("#tabelList").data("url");

	$.ajax({
		url : url,
		type : 'POST',
		dataType : 'json',
		data : d,
		success : success,
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
