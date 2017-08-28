<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>彩票系统管理 登陆</title>
<meta name="keywords" content="">
	<meta name="content" content="">
	<meta http-equiv="Content-Type" content="textml; charset=UTF-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
<link rel="stylesheet"
	href="${contextPath }/lottery/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${contextPath }/lottery/css/login.css"
	media="all" />
</head>
<body>
<div class="login-content">
		<div>
			<div class="layui-form-item">
				<label class="layui-form-label">账号</label>
				<div class="layui-input-block">
					<input type="text" id="account" name="title" lay-verify="title"
						autocomplete="off" placeholder="账号" class="layui-input">
				</div>
			</div>
		</div>
		<div>
			<div class="layui-form-item">
				<label class="layui-form-label">密码</label>
				<div class="layui-input-block">
					<input type="password" id="pw" name="pw" lay-verify="title"
						autocomplete="off" placeholder="密码" class="layui-input">
				</div>
			</div>
		</div>
		<div>
			<button class="layui-btn btn-login">登陆</button>
		</div>
	</div>
	<script src="${contextPath }/lottery/layui/layui.js"></script>
	<script src="${contextPath }/lottery/js/jquery.js"></script>
	<script type="text/javascript">
    $(document).ready(function(){
        layui.use(['layer'],function(){
            var layer = layui.layer;

            $(".btn-login").on("click",function(){
                var account =$("#account").val();
                var pw = $("#pw").val();
                alert("登陆中");
                if(!account){
                    $("#account").focus();
                    layer.msg("请填写账号");
                    return false;
                }

                if(!pw){
                    $("#pw").focus();
                    layer.msg("请填写密码");
                    return false;
                }
                $.ajax({
                		url:"http://localhost:8080/lottery/userClient/operate/login",
               	 	data:{
                        account:account,
                        pw:pw
                    },
                    type:"post",
                    dataType:"json",
                    success:function(data){
                    		layer.msg(data);
                    },
                    error:function()
                    {
                    		layer.msg("错误了");
                    
                    }
                })
            })

        })
    });
    </script>
</body>
</html>