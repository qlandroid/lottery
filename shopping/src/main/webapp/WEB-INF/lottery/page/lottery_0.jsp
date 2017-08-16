<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>彩票1</title>
    <link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
    <link rel="stylesheet" href="${contextPath}/lottery/css/page/lottery_0.css">
</head>
<body>
<div class="layui-side-scroll table-body" id="table">

</div>

<div class=" layui-side-scroll table-body index-nav" id="pageNav"></div>

<script src="${contextPath}/lottery/js/jquery.js"></script>
<script src="${contextPath}/lottery/js/base.js"></script>
<script src="${contextPath}/lottery/layui/layui.js"></script>
<script id="tableH" type="text/html">
    <table class="layui-table" lay-even>
        <colgroup>
            <col width="70">
            <col width="120">
            <col width="200">
            <col width="200">
            <col width="70">
            <col width="200">
            <col width="200">
            <col width="130">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>id</th>
            <th>单据号</th>
            <th>彩票</th>
            <th>开奖号码</th>
            <th>购买数量</th>
            <th>购买日期</th>
            <th>开奖日期</th>
            <th>用户</th>
        </tr>
        </thead>
        <tbody>


        {{# layui.each(d, function(index, data){ }}
        <tr>
            <td>{{ data.id }}</td>
            <td>{{ data.manifest }}</td>
            <td>{{ data.number }}</td>
            <td>{{ data.openLottery }}</td>
            <td>{{ data.payData }}</td>
            <td>{{ data.openData }}</td>
            <td>{{ data.userName }}</td>
        </tr>
        {{# }); }}

        {{# if(d.length === 0){ }}
        当前无数据
        {{# }; }}
        </tbody>
    </table>
</script>

<script type="text/javascript" src="${contextPath}/lottery/js/page/lottery_0.js"></script>
</body>
</html>