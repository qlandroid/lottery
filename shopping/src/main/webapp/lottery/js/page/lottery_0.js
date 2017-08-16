/**
 * Created by mrqiu on 2017/8/13.
 */
layui.use(['laypage','laytpl'], function () {
    var laytpl = layui.laytpl,laypage = layui.laypage;

    var innerHtml = tableH.innerHTML;

    loadMore(1,laytpl,innerHtml,laypage);
});

function loadMore(index, laytpl, innerHtml, laypage) {
    $.ajax({
        data: {page: index, pageSize: 20},
        dataType: "JSON",
        url: base_url + "/user/findAll.do",
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