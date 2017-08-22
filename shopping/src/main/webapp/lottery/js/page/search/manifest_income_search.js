$(document).ready(function(){
	
	layui.use(['laydate','layer'],function(){
		var laydate = layui.laydate,layer = layui.layer;
		 //日期时间范围
		  laydate.render({
		    elem: '#createDate'
		    ,type: 'datetime'
		  
		  });
		//日期时间范围
		  laydate.render({
		    elem: '#endDate'
		    ,type: 'datetime'
		  });
	})
	
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	//关闭iframe
	$('.btn-cancel').click(function(){
	    parent.layer.close(index);
	});
	//给父页面传值
	$('.btn-yes').on('click', function(){
	    parent.loadListDate(params());
	    parent.layer.close(index);
	});
	
})



function params(){
	var incomeDoc = $("#incomeDoc").val();
	var account = $("#account").val();
	var payMoney=$("#payMoney").val();
	var inQty = $("#inQty").val();
	var status = $("#status").val();
	var createDate = $("#createDate").val();
	var endDate = $("#endDate").val();
	console.log(createDate);
	console.log(endDate);
	 var p ={
			 incomeDoc:incomeDoc
			 ,account:account
			 ,payMoney:payMoney
			 ,inQty:inQty
			 ,status:status
	 } ;
	 if(createDate != null && createDate.trim() != "")
	 {
		 p.createDate = createDate;
	 }
	 if(endDate != null && endDate.trim() != "")
	 {
		 p.endDate = endDate;
	 }
	 
	 
	 
	 return p;
}