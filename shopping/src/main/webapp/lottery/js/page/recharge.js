$(document).ready(function() {
	layui.use('layer', function() {
		var layer = layui.layer;
		var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
		// 关闭iframe
		$('.btn—cancel').click(function() {
			parent.layer.close(index);
		});
		//进行提交
		$('.btn-yes').on('click', function() {
			var data = getParams();
			var url = $(this).data("url");
			console.log(data);
			//加载层-风格4
			var loadingDialog =layer.msg('加载中', {
			  icon: 16
			  ,shade: 0.01
			});
			$.ajax({
				url : url,
				data : data,
				dataType : "json",
				type : "post",
				error : function() {
					layer.msg("連接失敗");
				},
				success : function(data) {
					
						if (data.code == 200) {
							layer.close(loadingDialog);
							layer.msg("添加成功");
							parent.window.location.reload();
							parent.layer.close(index);
						} else {
							layer.close(loadingDialog);
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

function getParams(){
	var payMoney = $("#payMoney").val();
	var inQty = $("#inQty").val();
	var docNo = $("#docNo").val();
	var userId = $(".btn-yes").data("id");
	var remark = $("#remark").val();
	var data ={
			payMoney:payMoney
			,inQty:inQty
			,zhifubaoDoc:docNo
			,userId:userId
			,remark:remark
	}
	return data;
	
}

