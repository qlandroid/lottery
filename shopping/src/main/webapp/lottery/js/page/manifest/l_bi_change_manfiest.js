$(document).ready(layui.use("table", function() {
	var table = layui.table;// 跳转页面是page=1&limit=30;分别代表当前页码和呈现的数据量
	console.log($("#tabelList").data("url"));
	var operate = {
		id : 'tabelList',// 显示控件的Id;
		url : $("#tabelList").data("url"),
		limit : 10,// 默认采用60
		method : "post",
		page : true,// 是否开启分页
		even : true,// 是否开启隔行颜色
		skin : 'line',// 设置行样式 line row nob
		loading : true,// 显示加载进度框
		cols : [ {
			field : 'account',
			title : '用户名',
			width : 120,
			templet : '#account',
			sort : true
		}, {
			fixed : 'operateDate',
			title : '操作时间',
			width : 150,
			align : 'center',
			templet : '#operateDate'
		}, {
			fixed : 'payMoney',
			title : '支付金额',
			width : 150,
			align : 'center',
			templet : '#payMoney'
		}, {
			fixed : 'type',
			title : '类型',
			width : 150,
			align : 'center',
			templet : '#type'
		}, {
			fixed : 'inQty',
			title : '操作积分',
			width : 150,
			align : 'center',
			templet : '#inQty'
		}, {
			fixed : 'manifest',
			title : '任务单据号',
			width : 150,
			align : 'center',
			templet : '#manifest'
		}, {
			fixed : 'afterQty',
			title : '变化后',
			width : 150,
			align : 'center',
			templet : '#afterQty'
		}, {
			fixed : 'beforQty',
			title : '变化前',
			width : 150,
			align : 'center',
			templet : '#beforQty'
		}, {
			fixed : 'operate',
			title : '任务单据号来源',
			width : 150,
			align : 'center',
			templet : '#operate'
		} ]
	};
	console.log(table);
	var tableList = table.render(operate);
	tableList.reload();
	table.on('tool(tableList)', function(obj) {
		var data = obj.data; // 获得当前行数据
		var layEvent = obj.event; // 获得 lay-event 对应的值
		var tr = obj.tr; // 获得当前行 tr 的DOM对象

		if (layEvent === 'detail') { // 查看
			// do somehing
		} else if (layEvent === 'del') { // 删除
			layer.confirm('真的删除行么', function(index) {
				obj.del(); // 删除对应行（tr）的DOM结构
				layer.close(index);
				// 向服务端发送删除指令
			});
		} else if (layEvent === 'edit') { // 编辑
			// do something

			// 同步更新缓存对应的值
			obj.update({
				username : '123',
				title : 'xxx'
			});
		}
	})
}));