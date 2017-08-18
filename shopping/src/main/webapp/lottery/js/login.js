/**
 * Created by mrqiu on 2017/8/13.
 */
layui.config({
    base : "js/"
}).use(['form','layer'],function(){
	
    var form = layui.form(),
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        $ = layui.jquery;
    $(window).resize(function(){
        if($(".video-player").width() > $(window).width()){
            $(".video-player").css({"height":$(window).height(),"width":"auto","left":-($(".video-player").width()-$(window).width())/2});
        }else{
            $(".video-player").css({"width":$(window).width(),"height":"auto","left":-($(".video-player").width()-$(window).width())/2});
        }
    }).resize();
   
    //监听提交
   $("#login-btn").click(function(){
    	//加载层
    	var index = layer.load();
    	
    	 $.ajax( {
   		  url:"http://localhost:8080/lottery/toLogin"
   		  ,type:"POST"
   			  ,data: {account:$("#account").val(),pw:$("#pw").val()}
   			  ,
			dataType:"json"
   			 ,
   			 success:function(data){
   				console.log(data);
   				if(200 === data.code){
   					
   					  layer.close(index);
   					window.location.href = data.data.url;
   				}else {
   				 layer.close(index);
   					layer.msg(data.message);
				}
   			 },
   			 error:function(data){
   				layer.close(index);
   				 console.log("error"  + JSON.stringify(data));
   				layer.msg("连接失败");
   			 }
   	  });
    	 
    	  });
     
})