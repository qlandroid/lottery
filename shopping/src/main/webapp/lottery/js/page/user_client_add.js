$(document).ready(function(){
	layui.use("layer",function(){
		var layer = layui.layer;
		
		var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
		// 关闭iframe
		$('.btn-cancel').click(function() {
			parent.layer.close(index);
		});
		
		$(".btn-yes").on("click",function(){
			var account = $("#account").val(),
			pw =$("#pw").val(),
			name = $("#name").val(),
			zhifubao = $("#zhifubao").val(),
			clientId = $("#clientId").val(),
			phone = $("#phone").val();
			
			if(account == ""){
				layer.msg("请输入账号");
				$("#account").focus();
				return;
			}
			if(pw == ""){
				layer.msg("请输入密码");
				$("#pw").focus();
				return;
			}
			var url = $(this).data("url"),
			id = $(this).data("id");
			$.ajax({

				url : url,
				data : {
					account : account,
					pw : pw,
					name : name,
					zhifubao : zhifubao,
					phone : phone,
					clientId,clientId
					
				},
				dataType : "json",
				type : "post",
				error : function() {
					layer.msg("連接失敗");
				},
				success : function(data) {
						if (data.code == 200) {
							layer.msg("添加成功");
							parent.window.location.href = data.data.url;
							parent.layer.close(index);
						} else {
							// 墨绿深蓝风
							var index = layer.alert(data.message, {
								skin : 'layui-layer-molv' // 样式类名
								,
								closeBtn : 0
							}, function() {
								layer.close(index);
							});

						}
					

				}
			});
			
		})
	})
})