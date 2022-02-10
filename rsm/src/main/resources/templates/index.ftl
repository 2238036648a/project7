<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/js/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">后台管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    1906
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>



    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <#list data as list>
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="menu" style="margin-right: 10px;">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;">${list.mName}</a>
                        <dl class="layui-nav-child">
                            <#list list.childList as child>                         <!-- &ndash;&gt;-->
                                <dd><a class="layui-nav-child1" href="javascript:;" lay-event="${child.mUri} " lay-id="${child.mId}">${child.mName}</a></dd>
                            </#list>
                        </dl>
                    </li>
                </ul>
            </#list>
        </div>
    </div>



    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <div class="layui-tab layui-tab-card" lay-filter="demo">
                <ul class="layui-tab-title">
                    <li class="layui-this">欢迎</li>
                </ul>
                <div class="layui-tab-content" style="height: 500px;">
                    <div class="layui-tab-item">
                        welcome
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script type="text/javascript" src="/js/layui.js"></script>
<script>

    layui.use('element', function(){
        var $ = layui.jquery,
            element = layui.element;

        element.on('nav(menu)',function (data) {

            var id = data[0].attributes['lay-id'].value
             var uri = data[0].attributes['lay-event'].value;
            //新增一个Tab项
            console.log(data)
            element.tabAdd('demo', {
                title: data.text()
                , content: '<iframe scrolling="yes" frameborder="0" src="'+ uri +
                    '" style="width: 100%;min-height: 550px;"></iframe>'
                , id: id
            })
            element.tabChange('demo',id)

        })
    });
</script>

</body>
</html>