var table, layer;
$(document).ready(
		function() {

			layui.use([ 'table', 'layer' ], function() {
				table = layui.table, layer = layui.layer;
				var tableD = { // 其它参数在此省略
					page : true,
					limit : 10,
					cols : [ [ {
						field : 'id',
						title : '序号',
						width : 80,
						sort : true
					}, {
						field : 'lotteryStage',
						title : '期号',
						width : 170,
						sort : true,
						templet : '#fLotteryStage'
					}, {
						field : 'lotteryFillName',
						title : '彩票名称',
						width : 135,
						sort : true
					}, {
						field : 'number',
						title : '开奖号码',
						width : 120,
						templet : '#fNumber'
					}, {
						field : 'createUserName',
						title : '创建人',
						width : 90
					}, {
						field : 'fillLBi',
						title : '满',
						width : 80,
						sort : true,
						style : 'background-color: #e2e2e2;'
					}, {
						field : 'awardLBi',
						title : '奖金',
						width : 120,
						sort : true
					}, {
						field : 'overBuyQty',
						title : '购买数量',
						width : 120,
						style : 'background-color: #990033; color: #fff;',
						sort : true
					}, {
						field : 'sendStatus',
						title : '发放奖金',
						width : 120,
						style : 'background-color: #5FB878; color: #fff;',
						templet : '#fSendStatus'
					}, {
						field : 'lotteryFillUnitPrice',
						title : '倍数',
						width : 135,
						sort : true
					}, {
						field : 'lotteryFillCreaterDate',
						title : '创建时间',
						width : 180,
						sort : true,
						templet : '#fCreateDate'
					}, {
						field : 'lotteryFillEndDate',
						title : '结束时间',
						width : 180,
						sort : true,
						templet : '#fEndDate'
					}, {
						fixed : 'right',
						title : '操作',
						width : 260,
						align : 'center',
						toolbar : '#barDemo'
					} ] ],
					elem : '#lotteryList',
					id : 'lotteryList',

					url : $("#params").attr("url")
				// where: {token: 'sasasas', id: 123} //如果无需传递额外参数，可不加该参数
				// method: 'post' //如果无需自定义HTTP类型，可不加该参数
				// request: {} //如果无需自定义请求参数，可不加该参数
				// response: {} //如果无需自定义数据响应名称，可不加该参数
				};
				table.render(tableD);

				$(".btn-reload").on('click', function() {
					var type = $(this).data("type");
					active[type] ? active[type].call(this) : '';
				})

				var active = {
					all : function() {
						tableReload();
					},
					// 查看不可以开奖
					notAward : function() {
						tableReload({
							canSendAward : '0'
						});
					},
					// 查看可以开奖
					canAward : function() {
						tableReload({
							canSendAward : '1'
						});
					},
					addLottery : function() {
						// 用于添加彩票
						layer.open({
							type : 2,
							title : '购买彩票用户列表',
							shadeClose : true,
							shade : 0.8,
							area : [ '100%', '100%' ],
							content : $("#params").attr("add-lottery")
									+ "?lotteryTypeId="
									+ $(this).attr('type-id') // iframe的url
						});
					}
				}

				function tableReload(params) {
					/*
					 * params.sendStatus params.lotteryFillName
					 * params.lotteryStage params.createUserName
					 */
					console.log(params);
					if (params) {
						tableD.where = params;
					} else {
						tableD.where = {};
					}

					table.render(tableD);

				}

				// 监听单元格事件
				table.on('tool(lotteryList)', function(obj) {
					var data = obj.data;
					console.log(obj);
					if (obj.event == "openAward") {
						if (obj.data.status == 1) {
							layer.open({
								type : 2,
								title : '开奖',
								shadeClose : true,
								shade : 0.8,
								area : [ '100%', '100%' ],
								content : $("#params").attr("open-award")
										+ "?lotteryFillOpenId="
										+ obj.data.lotteryFillOpenId // iframe的url
							});
						}
					} else if (obj.event == "sendAward") {
						// 发放奖金
						if (data.sendStatus == 1) {
							return false;
						}
						layer.msg("可以发放奖金");
					} else if (obj.event == "seeAwardUser") {
						if (obj.data.sendStatus != 1) {
							layer.open({
								type : 2,
								title : '购买彩票用户列表',
								shadeClose : true,
								shade : 0.8,
								area : [ '100%', '100%' ],
								content : $("#params").attr("see-award")
										+ "?lotteryFillOpenId="
										+ obj.data.lotteryFillOpenId // iframe的url
							});
						} else {
							layer.msg("奖励积分已经发放", function() {
							});
						}

					} else if (obj.event == "seeBugUser") {
						layer.open({
							type : 2,
							title : '购买彩票用户列表',
							shadeClose : true,
							shade : 0.8,
							area : [ '100%', '100%' ],
							content : $("#params").attr("see-user")
									+ "?lotteryFillOpenId="
									+ obj.data.lotteryFillOpenId // iframe的url
						});
					}
				});
			})
		})
