<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品详情</title>
</head>
<body>
<a href="javascript:;" onclick="toOrder(${data.data.pdId})">立即购买</a>
    <h1></h1>
    <script type="text/javascript">
        function toOrder(id) {
            location.href="/product/order/info?pdId="+id;
        }

    </script>
</body>
</html>