var laypage;
var layer;
var isFirstLoad = true;
$(document).ready(layui.use([ 'laypage','tree', 'layer' ], function() {
	laypage = layui.laypage;
	layer = layui.layer;
	
	
	$.get($("#clazzTree").data("url"),function(data){
		layui.tree({
			  elem: '#clazzTree' //传入元素选择器
			  ,nodes: data.list
			});
	});
	
	
	$(".btn-add").on("click", function() {
		var url = $(this).attr('url');
		// iframe层
		layer.open({
			tips : [ 1, '#c00' ],
			type : 2,
			move : false,
			title : '添加大类',
			shadeClose : true,
			shade : 0.8,
			area : [ '60%', '80%' ],
			content : url
		// iframe的url
		});
	});

}));


