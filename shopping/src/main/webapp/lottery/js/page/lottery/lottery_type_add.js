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
			  console.log(nodes);
			  if(nodes.type =="0"){
				  $("#clazzParentName").data("id",nodes.id);
				  $("#clazzParentName").val(nodes.name);
			  }else{
				  layer.msg("选择的彩票类型不匹配",function(){});
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
	  
	  var name = $("#lotteryName").val();
	  if(isEmpty(name)){
		  $("#lotteryName").focus();
		  layer.msg("请填写名称");
		  return false;
	  }
	  
	  var lotteryType = $("input[type='radio']:checked").val();
	  if(isEmpty(lotteryType)){
		  layer.msg("请选择类型");
		  return false;
	  }
	  
	  var rule = $("#rule").val();
	  if(isEmpty(rule)){
		  $("#rule").focus();
		  layer.msg("请填写规则明细");
		  return false;
	  }
	  var remark = $("#remark").val();
	  if(remark &&isEmpty(remark)){
		  $("#remark").focus();
		  layer.msg("请填写备注信息");
		  return false;
	  }
	  $.ajax({
		  data:{
			  lotteryName:$("#lotteryName").val().trim(),
			  lotteryRule:$("#rule").val().trim(),
			  lotteryType:$("input[type='radio']:checked").val(),
			  lotteryClazzId:$("#clazzParentName").data("id"),
			  lotteryRemark:$("#remark").val().trim()
		  }
	  ,url:url
	  ,type:"post",
	  dataType:"json",
	  success:function(data){
				  console.log(data);
				  if(data.code == 200){
					  layer.msg("提交成功");
					  parent.layer.msg("添加成功");
					  parant.reloadTree();
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
function isEmpty(str){
	if( str == null || str.trim().length == 0 ){
		  return true;
	  }
	return false;
}

function addLotteryTypeHtml(typeList) {
	var typeHtml = "";
	for (var i = 0; i < typeList.length; i++) {
		/*
		 * 
<input type="radio" name="sex" value="nv" title="女" checked>
<input type="radio" name="sex" value="" title="中性" disabled>
		 */
		//<label><input name="Fruit" type="radio" value="" />其它 </label>
		var type = typeList[i];
		typeHtml = typeHtml + "<input type='radio' name='type' value='0' title='"+type.name+"'>";
	}
	return typeHtml;
}

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