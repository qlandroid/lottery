$(document).ready(function(){
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	//关闭iframe
	$('.btn-cancel').click(function(){
	    parent.layer.close(index);
	});
	//给父页面传值
	$('.btn-yes').on('click', function(){
		var url = $(this).data("url");
	    parent.window.location.href = url +params();
	    	parent.layer.close(index);
	});
})


function params(){
	var account = $("#account").val();
	var name = $("#name").val();
	var zhifubao=$("#zhifubao").val();
	var phone = $("#phone").val();
	 var p =new String() ;
	 if(account != null && account !=""){
		 p = p +"&account="+account
	 }
	 if(name != null && name !=""){
		 p = p +"&name="+name
	 }
	 if(zhifubao != null && zhifubao !=""){
		 p = p +"&zhifubao="+zhifubao
	 }
	 if(phone != null && phone !=""){
		 p = p +"&phone="+phone
	 }
	 if(p!=null|| p!=""){
		 p = p.slice(1);
	 }
	 
	 return "?" + p;
}