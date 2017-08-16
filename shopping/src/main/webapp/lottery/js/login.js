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

})