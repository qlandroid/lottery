<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>积分变化列表</title>
<link rel="stylesheet" href="${contextPath}/lottery/layui/css/layui.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/add_user.css">
<link rel="stylesheet"
	href="${contextPath}/lottery/css/page/user_service_manager.css">
<script src="${contextPath}/lottery/js/base.js"></script>
</head>
<body>

	<table class="layui-table" lay-data="{height:313, url:'${listUrl }'}">
        <thead>
        <tr>
            <th lay-data="{field:'id', width:80, sort: true}">ID</th>
            <th lay-data="{field:'username', width:80}">用户名</th>
            <th lay-data="{field:'sex', width:80, sort: true}">性别</th>
            <th lay-data="{field:'city', width:80}">城市</th>
            <th lay-data="{field:'sign', width:177}">签名</th>
            <th lay-data="{field:'experience', width:80, sort: true}">积分</th>
            <th lay-data="{field:'score', width:80, sort: true}">评分</th>
            <th lay-data="{field:'classify', width:80}">职业</th>
            <th lay-data="{field:'wealth', width:135, sort: true}">财富</th>
        </tr>
        </thead>
    </table>
</body>
<script type="text/html" id="account">
<a class="layui-btn" href="#">{{d.account}}</a>
	</script>

<script type="text/html" id="operateType">
	{{# if(d.type == '0'){ }}
		收入
	{{# } else if(d.type == '1') {}}
		支出
	{{# }}}
	</script>
<script type="text/html" id="inQty">
		{{# if(d.type == '0'){ }}
		{{# d.incomeInQty}}
	{{# } else if(d.type == '1') {}}
		-{{# d.expendOutQty}}
	{{# }}}
	</script>
<script type="text/html" id="manifest">
	<a href="#" class="btn-docNo">
		{{# if(d.type == '0'){ }}
			{{# d.incomeDocNo}}
		{{# } else if(d.type == '1') {}}
			{{# d.incomeDocNo}}
		{{# }}}
	</a>
</script>
<script type="text/html" id="afterQty">
	{{# if(d.type == '0'){ }}
		{{# d.incomeAfterQty}}
	{{# } else if(d.type == '1') {}}
		{{# d.expendAfterQty}}
	{{# }}}
	</script>

<script type="text/html" id="beforQty">
{{# if(d.type == '0'){ }}
		{{# d.incomeBeforeQty}}
	{{# } else if(d.type == '1') {}}
		{{# d.expendBeforeQty}}
	{{# }}}
	</script>
<script type="text/html" id="operateType">
	{{# if(d.v == '0'){ }}
		收入单
	{{# } else if(d.operateType == '1') {}}
		支出单
	{{# } else if(d.operateType == '2') {}}
		其他
	{{# }}}
	</script>
<script type="text/javascript"
	src="${contextPath }/lottery/js/jquery.js"></script>
<script type="text/javascript"
	src="${contextPath }/lottery/layui/layui.js"></script>
<script type="text/javascript"
	src="${contextPath }/lottery/js/page/manifest/l_bi_change_manfiest.js"></script>
</html>