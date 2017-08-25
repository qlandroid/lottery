$(document).ready(function(){
layui.use(['form','tree','layer','layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  
  $.post($("#clazzTree").data("url"),{userName:"ceshi"},function(data){
	  console.log(data);
	  layui.tree({
		  elem: '#clazzTree' //传入元素选择器
		  ,nodes: data.list
		  ,click:function(nodes){
			  console.log(nodes);
			  $("#clazzParentName").data("id",nodes.id);
			  $("#clazzParentName").val(nodes.name);
		  },
		  skin: 'shihuang'
		});
  })
  
  $("#clearParent").on('click',function(){
	  $("#clazzParentName").data("id",'');
	  $("#clazzParentName").val("");
  })
  
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
			  lotteryClazzName:$("#clazzName").val(),
			  lotteryClazzParentId:$("#clazzParentName").data("id"),
			  lotteryClazzRemark:$("#remark").val()
		  }
	  ,url:url
	  ,type:"post",
	  dataType:"json",
	  success:function(data){
				  console.log(data);
				  if(data.code == 200){
					  layer.msg("提交成功");
					  parent.layer.msg("添加成功");
					  parent.layer.close(index);
					  
				  }else{
					  layer.msg(data.message);
				  }
			  },
	  error:function(){
		  layer.msg("连接异常");
	  }
	  })
    return false;
  });
  
})
});

