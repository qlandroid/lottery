$(document).ready(layui.use("table", function() {
	var table = layui.table;// 跳转页面是page=1&limit=30;分别代表当前页码和呈现的数据量
	console.log($("#tabelList").data("url"));
	
}));

function insertTabelTbody(list){
	var html = "";
	for(list in data){
		
	}
}
