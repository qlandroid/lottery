var table, layer;
$(document).ready(
		function() {

			layui.use([ 'table', 'layer' ], function() {
				table = layui.table, layer = layui.layer;
				var tableD = { // 其它参数在此省略
					cols : [ [ {
						field : 'id',
						title : '序号',
						width : 80,
						sort : true
					}, {
						field : 'account',
						title : '购买账号',
						width : 170,
						sort : true
					}, {
						field : 'number',
						title : '中奖号码',
						width : 135,
						sort : true
					}, {
						field : 'lotteryFillBuyQty',
						title : '购买数量',
						width : 120
					} ] ],
					elem : '#userList',
					id : 'userList',
					url : $("#params").data("url")+"?lotteryFillOpenId=" +$("#params").data("id")
				// where: {token: 'sasasas', id: 123} //如果无需传递额外参数，可不加该参数
				// method: 'post' //如果无需自定义HTTP类型，可不加该参数
				// request: {} //如果无需自定义请求参数，可不加该参数
				// response: {} //如果无需自定义数据响应名称，可不加该参数
				};
				table.render(tableD);

				$(".btn-reload").on('click', function() {
					var type = $(this).data("type");
					active[type] ? active[type].call(this) : '';
				});

				$("#btnOpenAward").on("click",function(){
					var url = $(this).data("url");
					var fillOpenId = $(this).data("id");
					$.post(url,{lotteryFillOpenId:fillOpenId},function(d){
						if(d.code == 200){
							window.location.reload();
						}else{
							layer.msg(d.code + "---" + d.message,function(){});
						}
					})
				});
				
				var active = {
					all : function() {
						tableReload();
					},
					notAward : function() {
						tableReload({
							canSendAward : '0'
						});
					},
					canAward : function() {
						tableReload({
							canSendAward : '1'
						});
					}
				}

				function tableReload(params) {
					/*
					 * params.sendStatus params.lotteryFillName
					 * params.lotteryStage params.createUserName
					 */
					console.log(params);
					if(params){
						tableD.where = params;
					}else{
						tableD.where = {};
					}
					
					table.render(tableD);

				}

			})
		})
