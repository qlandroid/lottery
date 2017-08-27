$(document).ready(function(){
	layui.use(['layer'],function(){
		var layer = layui.layer;
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		//关闭iframe
		$('#btnCancel').click(function(){
		    parent.layer.close(index);
		});
		$("#btnAdd").on("click",function(){
			var typeName = $("#typeName").val();
			var type =$("#type").val();
			var ramark = $("#remark").val();
			if(isEmpty(typeName)){
				$("#typeName").fouces();
				layer.msg("必须填写类型名称");
				return false;
			}
			if(isEmpty(type)){
				$("#type").fouces();
				layer.msg("必须填写标记");
				return false;
			}
			if(isEmpty(ramark)){
				$("#remark").fouces();
				layer.msg("必须填描述信息");
				return false;
			}
			var url = $(this).data("url");
			$.post(url,{
				name:$("#typeName").val(),
				type:$("#type").val(),
				ramark:$("#remark").val()
			},function(data){
				if(data.code == 200){
					parent.layer.msg("添加成功");
					parent.layer.close(index);
				}else{
					layer.msg(data.message,function(){});
				}
			})
		})
	})
})