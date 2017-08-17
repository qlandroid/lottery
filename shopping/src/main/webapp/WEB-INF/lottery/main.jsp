<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ch">
<head>
<meta charset="UTF-8">
<title>彩票管理系统</title>
<script type="text/javascript" src="${contextPath}/lottery/js/base.js"></script>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet" href="${contextPath}/lottery/css/main.css">
</head>

<div class="header-body layui-bg-black"></div>
<div class="content-body">
	<div class="layui-side layui-bg-black content-left-nav">
		<div class="layui-side-scroll">

			<ul class="layui-nav layui-nav-tree site-demo-nav">
				<li class="layui-nav-item layui-this"><a href="javascript:;"
					title="首页" tab-id="0" data-url="${contextPath}/page/index.do"
					data-type="tabAdd">首页</a></li>
				<li class="layui-nav-item layui-nav-itemed"><a
					class="javascript:;" href="javascript:;">用户管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="javascript:;" title="客户端管理" tab-id="11"
								data-url="${contextPath}/page/user/manager.do"
								data-type="tabAdd">客户端</a>
						</dd>
						<dd>
							<a href="javascript:;" title="服务端管理" tab-id="12"
								data-url="${contextPath}/manager/page/user.do"
								data-type="tabAdd">服务端管理</a>
						</dd>
					</dl></li>

				<li class="layui-nav-item layui-nav-itemed"><a
					class="javascript:;" href="javascript:;">账单管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="javascript:;" title="平台收入" tab-id="21"
								data-url="${contextPath}/manifest/income.do" data-type="tabAdd">平台收入</a>
						</dd>
						<dd>
							<a href="javascript:;" title="积分消费" tab-id="22"
								data-url="${contextPath}/manifest/expend.do" data-type="tabAdd">积分消费</a>
						</dd>
						<dd>
							<a href="javascript:;" title="积分变化" tab-id="23"
								data-url="${contextPath}/manifest/change.do" data-type="tabAdd">积分变化</a>
						</dd>
					</dl></li>

				<li class="layui-nav-item layui-nav-itemed"><a
					class="javascript:;" href="javascript:;">双色球</a>
					<dl class="layui-nav-child">
						<dd class="">
							<a href="javascript:;" title="双色球开奖" tab-id="31"
								data-url="${contextPath}/ssq/open.do"> <i class="layui-icon"
								style="top: 3px;">&#xe638;</i><cite>开奖管理</cite>
							</a>
						</dd>
						<dd class="">
							<a href="javascript:;" title="双色球用户管理" tab-id="32"
								data-url="${contextPath}/ssq/user.do"> <i class="layui-icon"
								style="top: 3px;">&#xe638;</i> <cite>用户管理 </cite></a>
						</dd>
					</dl></li>
				<li class="layui-nav-item layui-nav-itemed"><a
					class="javascript:;" href="javascript:;">公告管理</a>
					<dl class="layui-nav-child">
						<dd class="">
							<a href="#"> <i class="layui-icon" style="top: 3px;">&#xe638;</i><cite>公告管理</cite>
							</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item layui-nav-itemed"><a
					class="javascript:;" href="javascript:;">其他管理</a>
					<dl class="layui-nav-child">
						<dd class="">
							<a href="#"> <i class="layui-icon" style="top: 3px;">&#xe638;</i><cite>公告发布</cite>
							</a>
						</dd>
					</dl></li>
			</ul>
		</div>
	</div>
	<div class="content-right">
		<div class="layui-tab" lay-filter="tab" lay-allowclose="true">
			<ul class="layui-tab-title">
				<li class="layui-this" lay-id="0" id="label-main" lay-close="false">首页</li>
			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe id="fmContent" src="${contextPath}/page/index.do"
						name="ifrname" class="body-fm" marginwidth="0" marginheight="0"
						frameborder="0" scrolling="auto" width="100%"></iframe>
				</div>

			</div>
		</div>
	</div>
</div>

<script src="${contextPath}/lottery/js/jquery.js"></script>
<script src="${contextPath}/lottery/layui/layui.js"></script>
<script src="${contextPath }/lottery/js/main.js"></script>
</body>
</html>