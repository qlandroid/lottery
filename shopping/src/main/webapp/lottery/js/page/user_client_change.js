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
			
		console.log(params());
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
	var p = {};
	if(id){
		p.userId = id;
	}
	var pw = $("#pw").val();
	if(pw){
		p.pw = pw;
	}
	var name = $("#name").val();
	if(name){
		p.name = name;
	}
	var phone = $("#phone").val();
	if(phone){
		p.phone = phone;
	}
	var zhifubao = $("#zhifubao").val();
	if(zhifubao){
		p.zhifubao = zhifubao;
	}
	var clientId = $("#clientId").val(); 
	if(clientId){
		p.clientId = clientId;
	}
	return p;
 }
