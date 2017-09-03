$(document).ready(function() {

	layui.use([ 'table', 'layer' ], function() {
		var table = layui.table, layer = layui.layer;
		layer.msg("加载成功");
		// 监听单元格事件
		table.on('tool(lotteryList)', function(obj) {
			var data = obj.data;
			console.log(obj);
			if (obj.event == "openAward") {
				if (data.number) {
					if (d.overBuyQty != d.fillLBi) {
						return false;
					} else {
						layer.msg("可以开奖了");
					}
				}
			} else if (obj.event == "sendAward") {
				// 发放奖金
				if (data.sendStatus == 1) {
					return false;
				}
				layer.msg("可以发放奖金");
			} else if (obj.event == "seeAwardUser") {
				// 查看中奖用户
				if (!data.number) {
					return false;
				}

				layer.msg("可以查看中奖用户")
			} else if (obj.event == "seeBugUser") {
				alert("被点击了")
				layer.open({
					type : 2,
					title : 'layer mobile页',
					shadeClose : true,
					shade : 0.8,
					area : [ '100%', '100%' ],
					content : $("#params").attr("see-user")+"?lotteryFillOpenId="+obj.data.lotteryFillOpenId // iframe的url
				});
			}
		});
	})
})
