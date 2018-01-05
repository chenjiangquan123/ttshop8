<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--当前页面的HTML部分--%>
<table id="itemListDg"></table>
<%--当前页面js部分--%>
<script>
    $(function () {
        $('#itemListDg').datagrid({
            //这是表格属性
            url: 'items',
            striped: true,
            pagination: true,
            pageSize: 20,
            pageList: [20,50,100],
            fit: true,
            columns: [[
                {field: 'id', title: '商品编号'},
                {field: 'title', title: '商品标题'},
                {field: 'status', title: '商品状态',formatter:function(v,r,i){
//                    console.group();
//                    console.log(v);
//                    console.log(r);
//                    console.log(i);
//                    console.groupEnd();
                    switch (v){
                        case 1:
                            return '正常';
                            break;
                        case 2:
                            return '下架';
                            break;
                        case 3:
                            return '删除';
                            break;
                        default:
                            return '未知';
                            break;
                    }
                }},
                {field: 'sellPoint', title: '商品卖点'},
                {field: 'catName', title: '分类名称'}
            ]]
        });
    });
</script>