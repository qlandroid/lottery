$(document).ready(function() {
	var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
	// 关闭iframe
	$('.btn-cancel').click(function() {
		parent.layer.close(index);
	});
	// 给父页面传值
	$('.btn-yes').on('click', function() {
		var url = $(this).data("url");
		layui.use('layer', function() {
			var layer = layui.layer;
		$.ajax({
			url : url,
			data : params(),
			dataType : "json",
			type : "post",
			error : function() {
				layer.msg("連接失敗");
			},
			success : function(data) {
					if (data.code == 200) {
						layer.msg("修改成功");
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
		});
		})
	});
})
 function params(){
	var id = $("#account").data("id");
	var pw = $("#pw").val();
	var name = $("#name").val();
	var phone = $("#phone").val();
	var zhifubao = $("#zhifubao").val();
	var clientId = $("#clientId").val(); 
	
	return {id:id,pw:pw,name:name,phone:phone,zhifubao:zhifubao,clientId:clientId};
 }
