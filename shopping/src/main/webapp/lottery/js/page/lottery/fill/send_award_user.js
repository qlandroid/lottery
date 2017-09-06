$(document).ready(function(){
	layui.use(['layer'],function(){
		
		var layer = layui.layer;
		
		$("#sendLBi").on("click",function(){
			var id = $(this).data("id"),
			url = $(this).data("url");
			if(!$("#inputPw").val()){
				layer.msg("请输入密码",function(){});
				$("#inputPw").focus();
				return false;
			}
			console.log($("#inputPw").val());
			$.post(url,{
				lotteryFillOpenId:id,
				pw:$("#inputPw").val()
			},function(d){
				if(d.code == 200){
					
				}else{
					layer.msg(d.code +"----" +d.message ,function(){});
				}
			})
		})
	})
})