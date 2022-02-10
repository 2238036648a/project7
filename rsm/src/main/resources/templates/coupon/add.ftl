<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/js/css/layui.css">
</head>
<body>
<script src="/js/layui.js"></script>

<form class="layui-form" lay-filter="stuForm">
    <div class="layui-form-item">
        <label class="layui-form-label">优惠券名称</label>
        <div class="layui-input-block">
            <input type="text" name="cpName"  autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">使用最低金额</label>
        <div class="layui-input-block">
            <input type="text" name="cpAhieve"  autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">抵扣金额</label>
        <div class="layui-input-block">
            <input type="text" name="cpReduce" autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">库存</label>
        <div class="layui-input-block">
            <input type="text" name="cpStorage"  autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">是否开启</label>
        <div class="layui-input-block">
            <input type="radio" name="cpStatus" value="0" title="是" checked>
            <input type="radio" name="cpStatus" value="1" title="否" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">优惠券类型</label>
        <div class="layui-input-block">
            <select id="cpTypeId" name="cpTypeId" lay-filter="couponInfo">

            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>
    //Demo
    layui.use(['table', 'form', 'upload', 'layer', 'laydate', 'jquery'], function(){
        var table = layui.table,
            laydate = layui.laydate,
            form = layui.form,
            layer = layui.layer,
            upload = layui.upload,
            $ = layui.jquery;
        $.ajax({
            url:"/coupon/type/list",
            data:{},
            type:"GET",
            dataType:"json",
            success:function (data) {
                if(data.errCode == 0){
                    var typeOption="<option value='0'>请选择优惠券类型</option>";
                    var recData = data.data;
                    for(var i in recData){
                        typeOption +="<option value='"+ recData[i].cpTypeId+"'>"+recData[i].typeName+"</option>";
                    }
                    $("#cpTypeId").html(typeOption);
                    form.render('select');
                }
            },
            error:function (err) {
                layer.msg("新增失败")
            }
        })
        //监听提交
        form.on('submit(formDemo)', function(data){
            // console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
            // parent.layer.close(parent.layer.getFrameIndex(window.name));
            $.ajax({
                url:'/coupon/info',
                data:JSON.stringify(data.field),
                type:'POST',
                dataType:'json',
                contentType:'application/json',
                success:function (data) {
                    parent.topTable.reload('CouponTab')
                    parent.layer.close(parent.layer.getFrameIndex(window.name));
                },
                error:function (err) {
                    parent.topTable.reload('CouponTab')
                    parent.layer.close(parent.layer.getFrameIndex(window.name));
                }

            })

            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        });
    });
</script>
</body>
</html>