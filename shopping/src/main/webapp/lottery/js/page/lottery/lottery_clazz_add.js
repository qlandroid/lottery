layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  

	  $.ajax({
		url : $('#selectMainClazz').data("url"),
		type : "post",
		dataType : "json",
		success : function(data) {
				console.log(data);
		},
		error : function() {
			layer.msg("连接异常");
		}
	});
  
  //监听提交
  form.on('submit(demo1)', function(data){
    layer.alert(JSON.stringify(data.field), {
      title: '最终的提交信息'
    })
    return false;
  });
  
  
});