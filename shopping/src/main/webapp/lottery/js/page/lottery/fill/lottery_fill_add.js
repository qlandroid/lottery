$(document).ready(function(){
layui.use(['form','tree','layer', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate
  ,layer = layui.layer;
  
  
  $.post($("#clazzTree").data("url"),{userName:"ceshi"},function(data){
	  console.log(data);
	  layui.tree({
		  elem: '#clazzTree' //传入元素选择器
		  ,nodes: data.list
		  ,click:function(nodes){
			  console.log("nodes = " + nodes);
			  if(nodes.type == 1){
				  $("#clazzParentName").data("id",nodes.id);
				  $("#clazzParentName").val(nodes.name);
			  }else{
				  layer.msg("不能为当前彩票类型" ,function(){});
			  }
			  
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
  $("#btnAdd").on('click', function(data){
	  
	  var url = $(this).data("url");
	  var rule = $("#rule").val();
	  var clazzName = $("#clazzParentName").val();
	  if(isEmpty(clazzName)){
		  layer.msg("请选择大类",function(){});
		  return false;
	  }
	  var name = $("#lotteryName").val();
	  if(isEmpty(name)){
		  $("#lotteryName").focus();
		  layer.msg("请填写名称",function(){});
		  return false;
	  }
	  var fillQty = $("#fillQty").val();
	  if(isEmpty(fillQty)){
		  $("#fillQty").focus();
		  layer.msg("请填写满数量，后进行抽奖",function(){});
		  return false;
	  }
	  
	  var awardQty = $("#awardQty").val();
	  if(isEmpty(fillQty)){
		  $("#awardQty").focus();
		  layer.msg("请填写中奖奖金金额",function(){});
		  return false;
	  }
	  
	  var unitPrice = $("#unitPrice").val();
	  if(isEmpty(fillQty)){
		  $("#unitPrice").focus();
		  layer.msg("购买单价",function(){});
		  return false;
	  }
	 
	  $.ajax({
		  data:{
			  fillLBi:$("#fillQty").val(),
			  awardLBi:$("#awardQty").val(),
			  lotteryFillUnitPrice:$("#unitPrice").val(),
			  lotteryTypeId:$("#clazzParentName").data("id"),
			  lotteryFillName:$("#lotteryName").val()
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
	  });
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