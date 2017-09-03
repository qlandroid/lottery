$(document).ready(function(){
	
	layui.use(['table','layer'],function(){
		var table = layui.table,
		layer = layui.layer;
		layer.msg("加载成功");
		//监听单元格事件
		  table.on('tool(lotteryList)', function(obj){
		    var data = obj.data;
		    console.log(obj);
		    if(obj.event == "openAward"){
		    		if(data.number){
		    			if(d.overBuyQty != d.fillLBi){
		    				return false;
		    			}else{
		    				layer.msg("可以开奖了");
		    			}
		    		}
		    }else if(obj.event == "sendAward"){
		    		//发放奖金
		    		if(data.sendStatus == 1){
		    			return false;
		    		}
		    		layer.msg("可以发放奖金");
		    }else if(obj.event == "seeAwardUser"){
		    		//查看中奖用户
		    		if(!data.number){
		    			return false; 
		    		}
		    		
		    		layer.msg("可以查看中奖用户")
		    }
		  });
	})
})
