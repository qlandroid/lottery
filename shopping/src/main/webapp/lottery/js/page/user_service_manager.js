
 layui.use(['laypage', 'layer'], function(){
	 var laypage = layui.laypage,layer =layui.layer;
	 layer.closeAll();
	 laypage({
		    cont: 'demo7'
		    ,pages: $("#params").data("total")
		    ,skip: true
		    ,jump: function(obj, first){
		        //得到了当前页，用于向服务端请求对应数据
		    		if(!first) {
		    			var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
		    			window.location.href = "userServiceManager.do?page="+shade;
		    		}
		       
		      }
		  });
	 
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
		   content: $("#params").data("url")+'/userService/userServiceManagerSearch.do' //iframe的url
		 });
	 });
	 
	 $("#btn-add").on("click",function(){
		//iframe层
		 layer.open({
			 
			 tips: [1, '#c00'],
		   type: 2,
		   move:false,
		   title: '添加用户',
		   shadeClose: true,
		   shade: 0.8,
		   area: ['100%', '100%'],
		   content: $("#params").data("url")+'/userService/userServiceManagerAdd.do' //iframe的url
		 });
	 })
	 
 });