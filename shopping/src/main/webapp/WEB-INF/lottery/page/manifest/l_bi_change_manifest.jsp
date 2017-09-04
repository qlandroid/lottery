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

	<div>
		<button class="layui-btn" data-url="${changeListUrl }" id="btn-search">查詢</button>
		</dir>

		<div class="content-tab-body">
			<table class="layui-table" lay-filter="expendList"
				lay-data="{ url:'${changeListUrl }', page:true, id:'changeList'}">
				<thead>
					<tr>
						<th lay-data="{field:'id', width:80, sort: true}">ID</th>
						<th
							lay-data="{field:'docNo', width:260, sort: true,templet:'#fdocNo'}">订单号</th>
						<th lay-data="{field:'type', width:135, sort: true,templet:'#typeStr'}">类型</th>
						<th
							lay-data="{field:'createTime', width:180,templet:'#fCreateDate'}">操作时间</th>

						<th lay-data="{field:'account', width: 90}">所属用户</th>
						<th
							lay-data="{field:'operateType', width:120, sort: true ,templet:'#operateTypeStr'}">创建类型</th>
						<th lay-data="{field:'afterQty', width:120, sort: true,templet:'#changeQty'}">消费前积分</th>
						<th
							lay-data="{field:'remark', width:120,style:'background-color: #990033; color: #fff;' ,sort: true}">备注</th>
					</tr>
				</thead>
			</table>
		</div>
</body>
<script type="text/html" id="fCreateDate">
  		{{# var date = formatDateTime(d.operateDate) ; }}
		{{ date}}
</script>
<script type="text/html" id="fdocNo">
  		{{# if(d.type == 1){ }}
			{{ d.incomeDocNo}}
		{{# }else if(d.type == 0 ){ }}
			{{ d.expendDocNo}}
		{{# }}}
</script>
<script type="text/html" id="changQty">
  		{{# if(d.type == 1){ }}
			{{ d.incomeQty}}
		{{# }else if(d.type == 0 ){ }}
			{{ d.expendQty}}
		{{# }}}
</script>
<script type="text/html" id="typeStr">
  		{{# if(d.type == 1){ }}
			收入
		{{# }else if(d.type == 0 ){ }}
			支出
		{{# }}}
</script>
<script type="text/html" id="operateTypeStr">
  		{{# if(d.operateType == 1){ }}
			收入单创建
		{{# }else if(d.operateType == 0 ){ }}
			支出单创建
		{{# }else{ }}
			其他操作
		{{# } }}
</script>
<script type="text/javascript"
	src="${contextPath }/lottery/js/jquery.js"></script>
<script type="text/javascript"
	src="${contextPath }/lottery/layui/layui.js"></script>
<script type="text/javascript"
	src="${contextPath }/lottery/js/page/manifest/l_bi_change_manfiest.js"></script>
</html>