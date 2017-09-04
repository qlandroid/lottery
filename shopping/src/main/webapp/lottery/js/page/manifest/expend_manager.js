var laypage;
var layer;
var isFirstLoad = true;
$(document).ready(layui.use([ 'laypage', 'layer','table' ], function() {
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
