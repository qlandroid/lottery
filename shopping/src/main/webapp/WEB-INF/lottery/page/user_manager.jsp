<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/user_manager.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>
	<div class="search-btn">
		<button class="layui-btn">查询</button>
		<button class="layui-btn">添加用户</button>
		<button class="layui-btn layui-btn-danger" id="del-all-user">删除全部用户</button>
	</div>
	<div class="layui-side-scroll table-body" id="table"></div>

	<div class="index-nav" id="pageNav"></div>
	<script src="${contextPath}/lottery/layui/layui.js"></script>
	<script id="demo" type="text/html">
    <table class="layui-table" lay-even>
        <colgroup>
            <col width="70">
            <col width="200">
            <col width="70">
            <col width="50">
            <col width="120">
            <col width="70">
            <col width="70">
            <col width="70">
            <col width="70">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>序号</th>
            <th>账号</th>
            <th>姓名</th>
            <th>联系电话</th>
            <th>已消费积分</th>
            <th>剩余积分</th>
            <th>中奖次数</th>
            <th>购买次数</th>
            <th>购买种类</th>
			<th>操作</th>
        </tr>
        </thead>
        <tbody>


        {{# layui.each(d, function(index, data){ }}
        <tr>
            <td>{{ index+1 }}</td>
            <td>{{ data.account }}</td>
            <td>{{ data.name }}</td>
            <td>{{ data.phone }}</td>
            <td>{{ data.overL }}</td>
            <td>{{ data.residualL }}</td>
            <td>{{ data.winQty }}</td>
            <td>{{ data.buyQty }}</td>
            <td>
                <button>种类</button>
            </td>
<td><button data-id="{{data.id}}" class="layui-btn layui-btn-danger btn-del-user">删除</button>
        </tr>
        {{# }); }}

        {{# if(d.length === 0){ }}
        当前无数据
        {{# }; }}
        </tbody>
    </table>
</script>
	<script src="${contextPath}/lottery/js/jquery.js"></script>
	<script src="${contextPath}/lottery/js/page/user-manager.js"></script>

</body>
</html>