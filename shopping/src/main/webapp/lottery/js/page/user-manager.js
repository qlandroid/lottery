/**
 * Created by mrqiu on 2017/8/12.
 */

$(document).ready(function () {
    
});

//分页layer
layui.use(['laypage', 'layer', "laytpl"], function () {
	var $ = layui.jquery,
     laypage = layui.laypage
        , layer = layui.layer
        , laytpl = layui.laytpl;
    
    /**
	$(".btn-del-user").click(function(){
		var userId = this.getAttribute("data-id");
		$.post(base_url+"/page/user/deleteUser.do",{id:userId},function(data, textStatus, jqXHR){
			if(data.code == 200){
				
			}
		},"json");
	});
	**/
    loadMore(1, laytpl, demo.innerHTML, laypage)

});

var isFirstLoad = true;
function loadMore(index, laytpl, innerHtml, laypage) {
    $.ajax({
        data: {page: index, pageSize: 20},
        dataType: "JSON",
        url: base_url + "/page/user/findAll.do",
        success: function (data) {
            var code = data.code;
            if (code == 200) {
                laytpl(innerHtml).render(data.list, function (html) {
                    table.innerHTML = html;
                });
                if (isFirstLoad) {
                    isFirstLoad = false;
                    laypage({
                        cont: 'pageNav'
                        , pages: data.total
                        , skip: true
                        , jump: function (obj, first) {
                            if (!first) {
                                loadMore(obj.curr, laytpl, innerHtml, laypage);
                            }
                        }
                    });
                }
            } else {
                alert("code = " + code + "message = " + data.message);
            }
        },
        error: function () {
            alert("错误");
        },
        type: "POST"
    });
}

layui.use('layer', function(){ //独立版的layer无需执行这一句
	  var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
	  
	  //触发事件
	  var active = {
	    setTop: function(){
	      var that = this; 
	      //多窗口模式，层叠置顶
	      layer.open({
	        type: 2 //此处以iframe举例
	        ,title: '当你选择该窗体时，即会在最顶端'
	        ,area: ['390px', '260px']
	        ,shade: 0
	        ,maxmin: true
	        ,offset: [ //为了演示，随机坐标
	          Math.random()*($(window).height()-300)
	          ,Math.random()*($(window).width()-390)
	        ] 
	        ,content: 'http://layer.layui.com/test/settop.html'
	        ,btn: ['继续弹出', '全部关闭'] //只是为了演示
	        ,yes: function(){
	          $(that).click(); 
	        }
	        ,btn2: function(){
	          layer.closeAll();
	        }
	        
	        ,zIndex: layer.zIndex //重点1
	        ,success: function(layero){
	          layer.setTop(layero); //重点2
	        }
	      });
	    }
	    ,confirmTrans: function(){
	      //配置一个透明的询问框
	      layer.msg('大部分参数都是可以公用的<br>合理搭配，展示不一样的风格', {
	        time: 20000, //20s后自动关闭
	        btn: ['明白了', '知道了', '哦']
	      });
	    }
	    ,notice: function(){
	      //示范一个公告层
	      layer.open({
	        type: 1
	        ,title: false //不显示标题栏
	        ,closeBtn: false
	        ,area: '300px;'
	        ,shade: 0.8
	        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
	        ,btn: ['火速围观', '残忍拒绝']
	        ,moveType: 1 //拖拽模式，0或者1
	        ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">你知道吗？亲！<br>layer ≠ layui<br><br>layer只是作为Layui的一个弹层模块，由于其用户基数较大，所以常常会有人以为layui是layerui<br><br>layer虽然已被 Layui 收编为内置的弹层模块，但仍然会作为一个独立组件全力维护、升级。<br><br>我们此后的征途是星辰大海 ^_^</div>'
	        ,success: function(layero){
	          var btn = layero.find('.layui-layer-btn');
	          btn.css('text-align', 'center');
	          btn.find('.layui-layer-btn0').attr({
	            href: 'http://www.layui.com/'
	            ,target: '_blank'
	          });
	        }
	      });
	    }
	    ,offset: function(othis){
	      var type = othis.data('type')
	      ,text = othis.text();
	      
	      layer.open({
	        type: 1
	        ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
	        ,id: 'LAY_demo'+type //防止重复弹出
	        ,content: '<div style="padding: 20px 100px;">'+ text +'</div>'
	        ,btn: '关闭全部'
	        ,btnAlign: 'c' //按钮居中
	        ,shade: 0 //不显示遮罩
	        ,yes: function(){
	          layer.closeAll();
	        }
	      });
	    }
	  };
	  
	  $('#btn-add-user').on('click', function(){
	    var othis = $(this), method = othis.data('method');
	    active[method] ? active[method].call(this, othis) : '';
	  });
	  
	});

