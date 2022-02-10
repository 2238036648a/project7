<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>优惠券列表</title>
    <link rel="stylesheet" href="/js/css/layui.css">
</head>
<body>
<table id="CouponTab" lay-filter="CouponTable"></table>
来呀来呀 优惠券
<script src="/js/layui.js"></script>
<script src="/jquery/jquery-1.11.3.min.js"></script>
<script type="text/html" id="switchTpl">
    <!-- 这里的 checked 的状态只是演示 -->

    <input type="checkbox" name="cpStatusOpera" value="{{d.cpStatus}}-{{d.cpId}}" lay-skin="switch"
           lay-text="开|关" lay-filter="cpStatusOpera" {{ d.cpStatus == 0 ? 'checked':'' }}>

</script>
<#--<script type="text/html" id="switchTpl">-->
<#--    <!-- 这里的 checked 的状态只是演示 &ndash;&gt;-->
<#--    <input type="checkbox" name="lock"  value="{{d.cpStatus}}-{{d.cpId}}" title="锁定" lay-filter="lockDemo" {{ d.cpStatus == 0 ? 'checked' : '' }}>-->
<#--</script>-->
    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
        <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
        <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
        </div>
    </script>
<script>
    var topTable;
    layui.use('table', function(){
        var table = layui.table,
            form = layui.form,
            $ =layui.jquery
        //第一个实例
        table.render({
            elem: '#CouponTab'
            ,height: 700
            //,toolbar:'#barDemo'
            ,toolbar:'#toolbarDemo'//开启头部工具栏，并为其绑定左侧模板
            ,url: '/coupon/list' //数据接口

            ,method:"POST"

            ,page: true //开启分页

            ,parseData: function(res) { //res 即为原始返回的数据
                return {
                    "code": res.errCode, //解析接口状态
                    "msg": res.errMassage, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data": res.data //解析数据列表
                }
            }
            ,cols: [[ //表头
                {type:"checkbox",fixed:"left"},
                {field: 'cpId', title: 'id', width:80}
                ,{field: 'cpName', title: '优惠券名称', width:80, sort: true}
                ,{field: 'cpCode', title: '优惠券编码', width:110, sort: true}
                ,{field: 'cpAhieve', title: '使用最低金额', width:80, sort: true}
                ,{field: 'cpReduce', title: '抵扣金额', width:80, sort: true}
                ,{field: 'cpStorage', title: '库存', width:90, sort: true}
                ,{field: 'createTime', title: '创建时间', width:130, sort: true}
                 ,{field: 'cpStatus', title: '是否开启', width:80, sort: true,templet: function(d){
                        if (d.cpStatus == 0){
                            return  '<span style="color: #0CCC24;">是</span>'
                        }else if(d.cpStatus == 1){
                            return '<span style="color: #c00;">否</span>'
                        }
                    }
                 },
                ,{field: 'typeName', title: '优惠券类型', width:100, sort: true}
                ,{field: 'typeCode', title: '类型编码', width:130, sort: true}
                // ,{field: 'right',field: 'cpStatus', title: '操作',templet: function(d){
                //             if (d.cpStatus == 0){
                //                 return  '<button type="button" class="layui-btn layui-btn-danger" lay-event="'+ d.cpStatus+'"><i class="layui-icon"></i></button>'
                //             }else if(d.cpStatus == 1){
                //                 return '<button type="button" class="layui-btn" lay-event="'+ d.cpStatus+'"><i class="layui-icon"></i></button>'
                //             }
                //         }
                //     }

               ,{field: 'cpStatus', title: '是否开启', width:90, templet: '#switchTpl', unresize: true}
            ]]
        });

        table.on('toolbar(CouponTable)', function(obj){
           var eventParam = obj.event;
            switch(eventParam){
                case 'add':
                   layer.open({
                       type:2,
                       content:"/coupon/add/page",
                       area:["700px","500px"]
                   })
                    break;
                case 'delete':
                    layer.msg('删除');
                    break;
                case 'update':
                    layer.msg('编辑');
                    break;
            };
        })
        //格式不正确，没有对齐，重载一下就OK
            table.reload('CouponTab')
    // //监听锁定操作
   form.on('switch(cpStatusOpera)', function(obj){
        var data1 = obj.value.split('-');
        var data = {
            cpId:data1[1],
            cpStatus:data1[0]==0?1:0
        };

        $.ajax({
            url:'/coupon/update',
            type:"PUT",
            contentType:'application/json',
            data:decodeURIComponent(JSON.stringify(data)),
            success:function (data) {

                if(data.errCode==0){
                    table.reload('CouponTab');
                }

            },
            error: function (err) {
                table.reload('CouponTab');
            }
        });
       })
        topTable = table;
    })
    </script>
</body>
</html>