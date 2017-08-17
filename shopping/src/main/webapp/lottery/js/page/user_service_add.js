$(document).ready(function() {
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
		$.ajax({

			url : base_url + "/userService/add.do",
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

			},
			success : function(data) {
				layui.use('layer', function() {
					var layer = layui.layer;
					if (data.code == 200) {
						var url = base_url + "/userServiceManager.do"
						layer.msg("添加成功");
						parent.window.location.href = url;
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
				});

			}
		})
	});
})
