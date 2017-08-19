
 layui.use(['laypage', 'layer'], function(){
	 var laypage = layui.laypage,layer =layui.layer;
	 layer.closeAll();
	 laypage({
		    cont: 'demo7'
		    ,pages: $("#params").data("total")
		    ,skip: true
		    ,curr:$("#params").data("page")
		    ,jump: function(obj, first){
		        //得到了当前页，用于向服务端请求对应数据
		    		if(!first) {
		    			console.log(obj);
		    			var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
		    			window.location.href = "userServiceManager?page="+obj.curr;
		    		}
		       
		      }
		  });
	 $("#search").on("click",function(){
		 var searchContent = $("#searchContent").val();
			 window.location.href = base_url + "/userService/userServiceManager?account="+searchContent
	 })
	 $("#btn-search").on("click",function(){
		//iframe层
		 layer.open({
			 
			 tips: [1, '#c00'],
		   type: 2,
		   move:false,
		   title: '按条件查询用户',
		   shadeClose: true,
		   shade: 0.8,
		   area: ['100%', '90%'],
		   content: $("#params").data("url")+'/userService/userServiceManagerSearch' //iframe的url
		 });
	 });
	 
	 $("#btn-add").on("click",function(){
		 var addUrl = $(this).data("url");
		//iframe层
		 layer.open({
			 
			 tips: [1, '#c00'],
		   type: 2,
		   move:false,
		   title: '添加客户端用户',
		   shadeClose: true,
		   shade: 0.8,
		   area: ['100%', '100%'],
		   content: addUrl
		 });
	 })
	 
	 $(".btn-del-user").on("click",function(){
		 //刪除
		 var id = $(this).data("id");
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
				,url:base_url +"/userService/deleteUser"
				,type:"post"
					,dataType:"json"
						,success:function(data){
							layer.close(loding);
							if(data.code == 200){
								window.location.href = base_url +"/userService/userServiceManager"
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
		   content: $("#params").data("url")+'/userService/userServiceManagerChange?id='+id //iframe的url
		 });
	 });
	 
	 
	 
 });