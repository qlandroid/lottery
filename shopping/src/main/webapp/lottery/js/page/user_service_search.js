$(document).ready(function(){
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	//关闭iframe
	$('.btn-cancel').click(function(){
	    parent.layer.close(index);
	});
	//给父页面传值
	$('.btn-yes').on('click', function(){
		var account = $("#account").val();
		var name = $("#name").val();
		var power=$("#power").val();
		var phone = $("#phone").val();
		var url = base_url+"/userServiceManager.do?account="+account+"&name="+name+"&power="+power+"&phone="+phone
	    parent.window.location.href =url;
	    	parent.layer.close(index);
	});
})
