$(document).ready(function(){
	
	layui.use(['layer'],function(){
		
		var layer = layui.layer;
		var getModelUrl = $("#params").attr("model-url");
		
		$.post(getModelUrl,{
			lotteryTypeId:$("#params").attr("type-id")
		},function(d){
			if(d.code == 200){
				var data = d.data;
				$("#name").val(data.lotteryFillName);
				$("#fillLBi").val(data.fillLBi);
				$("#awardLBi").val(data.awardLBi);
			}else{
				layer.msg(d.code + "---" + d.message,function(){});
			}
		})
		
		$("#btnCreate").on('click',function(){
			var p = {};
			var name = $("#name").val();
			if(name){
				p.lotteryFillName = name;
			}
			p.lotteryTypeId = $("#params").attr("type-id");
			var createUrl = $("#params").attr("create-url");
			$.post(createUrl,p,function(d){
				if(d.code ==200){
					var data = d.data;
					console.log("返回参数",JSON.stringify(data));
					$("#name").val(data.lotteryFillName);
					$("#name").attr("disabled","disabled");
					$("#lotteryStage").val(data.lotteryStage);
					$("#fillLBi").val(data.fillLBi);
					$("#awardLBi").val(data.awardLBi);
					$("#btnClose").attr("class","layui-btn");
					$("#btnCreate").attr("class","layui-btn layui-hide");
				}else{
					layer.msg(d.code + "---" + d.message ,function(){});
				}
			})
		});
		$("#btnClose").on('click',function(){
			  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			  parent.location.reload();
			  parent.layer.close(index);
		})
		
	})
})