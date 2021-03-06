var laypage;
var layer;
var isFirstLoad = true;
$(document).ready(
		layui.use([ 'laypage', 'tree', 'layer' ], function() {
			laypage = layui.laypage;
			layer = layui.layer;

			function addMsg(msg) {
				layer.msg(msg);
			}
			reloadTree();
			function reloadTree() {
				$.get($("#clazzTree").data("url"), function(data) {
					layui.tree({
						elem : '#clazzTree' // 传入元素选择器
						,
						nodes : data.list,
						click : function(nodes) {
							console.log(nodes);
							if (nodes.type == 1) {
								$("#clazzFrame").attr(
										"src",
										nodes.url + "?lotteryTypeId="
												+ nodes.id);
							}
						}
					});
				});
			}

			$(".btn-add").on("click", function() {
				var url = $(this).attr('url');
				var title = $(this).attr('title');
				// iframe层
				layer.open({
					tips : [ 1, '#c00' ],
					type : 2,
					move : false,
					title : title,
					shadeClose : true,
					shade : 0.8,
					area : [ '60%', '80%' ],
					content : url
				// iframe的url
				});
			});

		}));
