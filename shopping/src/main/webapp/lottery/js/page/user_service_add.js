$(document).ready(function() {
	layui.use('layer', function() {
		var layer = layui.layer;
		var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
		// 关闭iframe
		$('.btn-cancel').click(function() {
			parent.layer.close(index);
		});
		// 给父页面传值
		$('.btn-yes').on('click', function() {
			var account = $("#account").val();
			var name = $("#name").val();
			var power = $("#power").val();
			var phone = $("#phone").val();
			var pw = $("#pw").val();
			if(account == null || account =="" ){
				$("#account").focus();
				layer.msg("账号不能为空");
				return;
			}
			if(account.length <8){
				layer.msg("账号长度不能小于8");
				return ;
			}
			if(pw == null || pw==""){
				$("#pw").focus();
				layer.msg("密码不能为空");
				return;
			}
			var url = $(this).data("url");
			$.ajax({
	
				url : url,
				data : {
					account : account,
					pw : pw,
					name : name,
					power : power,
					phone : phone
				},
				dataType : "json",
				type : "post",
				error : function() {
					layer.msg("連接失敗");
				},
				success : function(data) {
						if (data.code == 200) {
							layer.msg("添加成功");
							parent.window.location.reload();
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
			
			})
		});
	});
})
