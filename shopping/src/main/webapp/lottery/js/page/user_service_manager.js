
 layui.use(['laypage', 'layer'], function(){
	 var laypage = layui.laypage,layer =layui.layer;
	 layer.closeAll();
	 laypage.render({
		    cont: 'navIndex'
		    ,pages: $("#navIndex").data("total")
		    ,skip: true
		    ,curr:$("#navIndex").data("page")
		    ,jump: function(obj, first){
		        //得到了当前页，用于向服务端请求对应数据
		    		if(!first) {
		    			console.log(obj);
		    			var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
		    			$("#params").attr("data-page",obj.curr);
		    			window.location.href = $("#navIndex").data("url")+params();
		    		}
		       
		      }
		  });
	 $("#btnSearchContent").on("click",function(){
		 var searchContent = $("#searchContent").val();
		 clearParams();
		 $("#params").attr("data-account",searchContent);
		 var url = $("#btnSearchContent").data("url");
			 window.location.href = url+params();
	 })
	 $("#btn-search").on("click",function(){
		 var url = $(this).data("url");
		//iframe层
		 layer.open({
			 
			 tips: [1, '#c00'],
		   type: 2,
		   move:false,
		   title: '按条件查询用户',
		   shadeClose: true,
		   shade: 0.8,
		   area: ['100%', '90%'],
		   content: url //iframe的url
		 });
	 });
	 
	 $("#btn-add").on("click",function(){
		 var url = $(this).data("url");
		//iframe层
		 layer.open({
			 
			 tips: [1, '#c00'],
		   type: 2,
		   move:false,
		   title: '添加用户',
		   shadeClose: true,
		   shade: 0.8,
		   area: ['100%', '100%'],
		   content: url//iframe的url
		 });
	 })
	 
	 $(".btn-del-user").on("click",function(){
		 //刪除
		 var id = $(this).data("id");
		 var url = $(this).data("url");
		 var index = layer.confirm('請問確定刪除用戶嗎？', {
			  btn: ['確定','取消'] //按钮
		 	,title:"刪除用戶"
			}, function(index){
				//加载层
				var loding = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
				
				//確定
				$.ajax({
					data:{
						id:id
					}
				,url:url
				,type:"post"
					,dataType:"json"
						,success:function(data){
							layer.close(loding);
							if(data.code == 200){
								window.location.reload();
							}else{
								layer.msg(data.message);
							}
						}
				,error:function(){
					layer.close(loding);
					layer.msg("连接失败");
				}
				})
				
			}, function(index){
				//取消
				layer.close(index);
			});
			  
	 });
	 $(".btn-change-pw").on("click",function(){
		 var id = $(this).data("id");
		 var url = $(this).data("url");
		//修改密碼
		//iframe层
		 layer.open({
			 tips: [1, '#c00'],
		   type: 2,
		   move:false,
		   title: '修改用戶詳情',
		   shadeClose: true,
		   shade: 0.8,
		   area: ['100%', '100%'],
		   content: url+"?id="+id //iframe的url
		 });
	 });
 });
 
 function params(){
	 var account = $("#params").data("account"),
	 power = $("#params").data("power"),
	 page = $("#params").data("page");
	 pageSize = $("#params").data("pageSize");
	 var p =new String() ;
	 if(account != null && account !=""){
		 p = p +"&account="+account
	 }
	 if(power != null && power !=""){
		 p = p +"&power="+power
	 }
	 if(page != null && page !=""){
		 p = p +"&page="+page
	 }
	 if(pageSize != null && pageSize !=""){
		 p = p +"&pageSize="+pageSize
	 }
	 if(p!=null|| p!=""){
		 p = p.slice(1);
	 }
	 
	 return "?" + p;
 }
 
 function clearParams(){
	 $("#params").removeAttr("data-account");
	 $("#params").removeAttr("data-power");
	 $("#params").removeAttr("data-page");
	 $("#params").removeAttr("data-pageSize");
 }