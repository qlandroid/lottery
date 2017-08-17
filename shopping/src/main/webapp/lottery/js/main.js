/**
 * Created by mrqiu on 2017/8/12.
 */
$(document).ready(function(){
	layui.use(['element',"layer"], function () {
		
        var element = layui.element(),layer = layui.layer;
        
        //触发事件
        var active = {
            tabAdd: function (othis) {
            		
                //删除指定Tab项
                var clickId = this.getAttribute("tab-id");
                var isHasId = false;
                $(".layui-tab-title li").each(function(){
   
                		var clickTabId =this.getAttribute("lay-id");
                		if(clickTabId === clickId){
                			isHasId = true;
                			return false;
                		}
                }); 	
                if(!isHasId){
                	//新增一个Tab项
                    element.tabAdd('tab', {
                        title: this.getAttribute("title")
                        ,
                        content: "<iframe id='fmContent' src=" + this.getAttribute("data-url") + " name='ifrname' class='body-fm' marginwidth='0'marginheight='0'frameborder='0' scrolling='auto' width='100%'></iframe>"
                        ,
                        id: clickId //实际使用一般是规定好的id，这里以时间戳模拟下
                    });
                }
                	//切换到指定Tab项
                    element.tabChange('tab', clickId); //切换到：用户管理
                
            }
        };
        

        $('.site-demo-nav li a').on('click', function () {
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });
        
        $('#label-main i').html("");
      

    });
	
	
	
});

