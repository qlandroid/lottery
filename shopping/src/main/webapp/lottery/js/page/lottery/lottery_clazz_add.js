$(document).ready(function(){
layui.use(['form','tree', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	//关闭iframe
	$('#btnCancel').click(function(){
	    parent.layer.close(index);
	});
  //监听提交
  form.on('submit(demo1)', function(data){
	  var url = $(this).data("url");
	  $.ajax({
		  data:{
			  lotteryClazzName:$("#clazzName").val()
		  }
	  ,url:url
	  ,type:"post"
		  ,dataType:"json"
			  ,success:function(data){
				  console.log(data);
				  if(data.code == 200){
					  layer.msg("提交成功");
					  parent.layer.msg("添加成功");
					  parent.layer.close(index);
					  
				  }else{
					  layer.msg(data.message);
				  }
			  }
	  ,error:function(){
		  layer.msg("连接异常");
	  }
	  })
    return false;
  });
  
})
});

function createNodes(list){
	var nodes = new Array();
	for(var i = 0 ; i < list.length; i++){
		var item = new Object();
		var data = list[i];
		//   ,alias: 'bb' //可选
	      //,id: '123' //可选
		item.id= data.lotteryClazzId;
		item.alias ="bb";
		item.name = data.lotteryClazzName;
		if(data.clazzList != null )
			item.children = createNodes(data.clazzList);
		nodes[i] = item;
	}
	return nodes;
}