<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/common/css/style.css" rel="stylesheet" type="text/css" />
<link href="/common/css/common.css" rel="stylesheet" tyle="text/css" />
<link href="/common/css/Orders.css" rel="stylesheet" type="text/css" />
<script src="/common/js/jquery.min.1.8.2.js" type="text/javascript"></script>
<script src="/common/js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script src="/common/js/jquery.reveal.js" type="text/javascript"></script>
<script src="/common/js/jquery.sumoselect.min.js" type="text/javascript"></script>
<script src="/common/js/common_js.js" type="text/javascript"></script>
<script src="/common/js/footer.js" type="text/javascript"></script>
<script src="/common/js/jquery.jumpto.js" type="text/javascript"></script>
<title>确认订单界面</title>
</head>
 <script type="text/javascript">
        $(document).ready(function () {
            window.asd = $('.SlectBox').SumoSelect({ csvDispCount: 3 });
            window.test = $('.testsel').SumoSelect({okCancelInMulti:true });
        });
    </script>
<body>
<!--顶部样式-->
 <div id="header_top">
  <div id="top">
    <div class="Inside_pages">
      <div class="Collection">下午好，欢迎光临520私库商城！<em></em><a href="#">收藏我们</a></div>
	<div class="hd_top_manu clearfix">
	  <ul class="clearfix">
	   <li class="hd_menu_tit zhuce" data-addclass="hd_menu_hover">欢迎光临本店！<a href="#" class="red">[请登录]</a> 新用户<a href="#" class="red">[免费注册]</a></li>
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="#">我的订单</a></li> 
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"> <a href="#">购物车(<b>0</b>)</a> </li>
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="#">联系我们</a></li>
	   <li class="hd_menu_tit list_name" data-addclass="hd_menu_hover"><a href="#" class="hd_menu">客户服务</a>
	    <div class="hd_menu_list">
		   <ul>
		    <li><a href="#">常见问题</a></li>
			<li><a href="#">在线退换货</a></li>
		    <li><a href="#">在线投诉</a></li>
			<li><a href="#">配送范围</a></li>
		   </ul>
		</div>	   
	   </li>
       <li class="hd_menu_tit phone_c" data-addclass="hd_menu_hover"><a href="#" class="hd_menu "><em class="iconfont icon-phone"></em>手机版</a>
	    <div class="hd_menu_list erweima">
		   <ul>
            <img src="/common/images/erweima.png"  width="100px" height="100"/>
		   </ul>
		</div>	   
	   </li>
	  </ul>
	</div>
    </div>
  </div>
   <!--样式-->
<!--顶部样式2-->
<div id="header "  class="header page_style">
  <div class="logo"><a href="index.html"><img src="/common/images/logo.png" /></a></div>
  <!--可修改图层-->
  <div class="festival"><a href="#"><img src="/common/images/logo_yd.png" /></a></div>
  <!--结束图层-->
  <div class="Search">
    <p><input name="" type="text"  class="text"/><input name="" type="submit" value="搜 索"  class="Search_btn"/></p>
	<p class="Words"><a href="#">苹果</a><a href="#">香蕉</a><a href="#">菠萝</a><a href="#">西红柿</a><a href="#">橙子</a><a href="#">苹果</a></p>
</div>
<!--可修改图层2-->
  <!--<div class="festival1"><a href="#"><img src="/common/images/logo_sd.png" /></a></div>--><!--结束-->
 <!--购物车样式-->
 <div class="hd_Shopping_list" id="Shopping_list">
   <div class="s_cart"><em></em><a href="#">我的购物车</a> <i class="ci-right">&gt;</i><i class="ci-count" id="shopping-amount">0</i></div>
   <div class="dorpdown-layer">
    <div class="spacer"></div>
	 <!--<div class="prompt"></div><div class="nogoods"><b></b>购物车中还没有商品，赶紧选购吧！</div>-->
	 <ul class="p_s_list">	   
		<li>
		    <div class="img"><img src="/common/images/tianma.png"></div>
		    <div class="content"><p><a href="#">产品名称</a></p><p>颜色分类:紫花8255尺码:XL</p></div>
			<div class="Operations">
			<p class="Price">￥55.00</p>
			<p><a href="#">删除</a></p></div>
		  </li>
		</ul>		
	 <div class="Shopping_style">
	 <div class="p-total">共<b>1</b>件商品　共计<strong>￥ 515.00</strong></div>
	  <a href="#" title="去购物车结算" id="btn-payforgoods" class="Shopping">去购物车结算</a>
	 </div>	 
   </div>
 </div>
</div>
<!--菜单导航样式-->
<div id="Menu" class="clearfix">
<div class="Inside_pages">
  <div id="allSortOuterbox" class="display">
    <div class="t_menu_img"></div>
    <div class="Category"><a href="#"><em></em>所有产品分类</a></div>
    <div class="hd_allsort_out_box_new">
	 <!--左侧栏目开始-->
	 <ul class="Menu_list">	
	    <li class="name">
		<div class="Menu_name"><a href="#" >男装女装</a> <span>&lt;</span></div>
		<div class="link_name">
		  <p><a href="#">茅台</a>  <a href="#">五粮液</a>  <a href="#">郎酒</a>  <a  href="#">剑南春</a></p>
          <p><a href="#">酱香型</a>  <a href="#">四川</a>  <a href="#">贵州</a>  <a  href="#">养生酒</a></p>
		</div>
		<div class="menv_Detail">
		 <div class="cat_pannel clearfix">
		   <div class="hd_sort_list">
		    <dl class="clearfix" data-tpc="1">
			 <dt>白酒</dt>
			 <dd><a href="#">酱香型</a></dd> 
			 <dd><a href="#">浓香型</a></dd> 
			 <dd><a href="#">清香型</a></dd> 
			 <dd><a href="#">绵柔香型</a></dd> 
			 <dd><a href="#">老白干香型</a></dd> 
			 <dd><a href="#">凤香型</a></dd> 
			 <dd><a href="#">馥香型</a></dd> 
			 <dd><a href="#">米香型</a></dd> 
			 <dd><a href="#">青稞清香型</a></dd> 
			 <dd><a href="#">董香型</a></dd> 
			 <dd><a href="#">特香型</a></dd> 
			 <dd><a href="#">芝麻香型</a></dd>
			</dl>
			 <dl class="clearfix" data-tpc="2">
			 <dt>葡萄酒</dt>
			 <dd><a href="#">酱香型</a></dd> 
			 <dd><a href="#">浓香型</a></dd> 
			 <dd><a href="#">清香型</a></dd> 
			 <dd><a href="#">绵柔香型</a></dd> 
			 <dd><a href="#">老白干香型</a></dd> 
			 <dd><a href="#">凤香型</a></dd> 
			 <dd><a href="#">馥香型</a></dd> 
			 <dd><a href="#">米香型</a></dd> 
			 <dd><a href="#">青稞清香型</a></dd> 
			 <dd><a href="#">董香型</a></dd> 
			 <dd><a href="#">特香型</a></dd> 
			 <dd><a href="#">芝麻香型</a></dd>
			</dl>
			 <dl class="clearfix" data-tpc="3">
			 <dt>洋酒</dt>
			 <dd><a href="#">酱香型</a></dd> 
			 <dd><a href="#">浓香型</a></dd> 
			 <dd><a href="#">清香型</a></dd> 
			 <dd><a href="#">绵柔香型</a></dd> 
			 <dd><a href="#">老白干香型</a></dd> 
			 <dd><a href="#">凤香型</a></dd> 
			 <dd><a href="#">馥香型</a></dd> 
			 <dd><a href="#">米香型</a></dd> 
			 <dd><a href="#">青稞清香型</a></dd> 
			 <dd><a href="#">董香型</a></dd> 
			 <dd><a href="#">特香型</a></dd> 
			 <dd><a href="#">芝麻香型</a></dd>
			</dl>
			 <dl class="clearfix" data-tpc="4">
			 <dt>啤酒/养生酒</dt>
			 <dd><a href="#">酱香型</a></dd> 
			 <dd><a href="#">浓香型</a></dd> 
			 <dd><a href="#">清香型</a></dd> 
			 <dd><a href="#">绵柔香型</a></dd> 
			 <dd><a href="#">老白干香型</a></dd> 
			 <dd><a href="#">凤香型</a></dd> 
			 <dd><a href="#">馥香型</a></dd> 
			 <dd><a href="#">米香型</a></dd> 
			 <dd><a href="#">青稞清香型</a></dd> 
			 <dd><a href="#">董香型</a></dd> 
			 <dd><a href="#">特香型</a></dd> 
			 <dd><a href="#">芝麻香型</a></dd>
			</dl>
		   </div><div class="Brands">
		   <a href="#"><img src="/common/Products/p_logo_1.jpg" /></a>
		   <a href="#"><img src="/common/Products/p_logo_2.jpg" /></a>
		   <a href="#"><img src="/common/Products/p_logo_3.jpg" /></a>
		   <a href="#"><img src="/common/Products/p_logo_4.jpg" /></a>
		   <a href="#"><img src="/common/Products/p_logo_5.jpg" /></a>
		  </div>
		  </div>
		  <!--品牌-->		  
		</div>		 
		</li>
		<li class="name">
		<div class="Menu_name"><a href="#" >个性护理</a><span>&lt;</span></div>
		<div class="link_name">
		 <a href="#">饼干蛋糕</a><a href="#">糖果</a><a href="#">巧克力</a><a href="#">坚果</a>
         <a href="#">饼干蛋糕</a><a href="#">糖果</a><a href="#">巧克力</a><a href="#">坚果</a>
		</div>
		<div class="menv_Detail">
		 <div class="cat_pannel clearfix">		   
		  </div>
		</div>		
		</li>
		<li class="name">
		<div class="Menu_name"><a href="#" >鞋子箱包</a><span>&lt;</span></div>
		<div class="link_name">
		<a href="#">休闲零食</a><a href="#">坚果炒货</a><a href="#">饼干蛋糕</a>
        <a href="#">饼干蛋糕</a><a href="#">糖果</a><a href="#">巧克力</a><a href="#">坚果</a>
		</div>
		<div class="menv_Detail">
		 <div class="cat_pannel clearfix">		   
		  </div>
		</div>	
		</li>
		<li class="name">
		<div class="Menu_name"><a href="#" >食品保健</a><span>&lt;</span></div>
		<div class="link_name">
		<a href="#">休闲零食</a><a href="#">坚果炒货</a><a href="#">饼干蛋糕</a>
        <a href="#">饼干蛋糕</a><a href="#">糖果</a><a href="#">巧克力</a><a href="#">坚果</a>
		</div>
		<div class="menv_Detail">
		 <div class="cat_pannel clearfix">		    
		  </div>
		</div>	
		</li>
		<li class="name">
		<div class="Menu_name"><a href="#" >综合百货</a><span>&lt;</span></div>
		<div class="link_name">
		<a href="#">休闲零食</a><a href="#">坚果炒货</a><a href="#">饼干蛋糕</a>
        <a href="#">饼干蛋糕</a><a href="#">糖果</a><a href="#">巧克力</a><a href="#">坚果</a>
		</div>
		<div class="menv_Detail">
		 <div class="cat_pannel clearfix">		    
		  </div>
		</div>	
		</li>
		<li class="name customize">
		<div class="Menu_name"><a href="#" >私人定制</a><span>&lt;</span></div>		
		</li>			
	</ul>	
	</div>		
	</div>
	<script>$("#allSortOuterbox").slide({ titCell:".Menu_list li",mainCell:".menv_Detail",	});</script>
	<!--菜单栏-->
	<div class="Navigation" id="Navigation">
		 <ul class="Navigation_name">
			<li><a href="#">美食</a></li>
			<li><a href="#">美妆</a></li>
			<li><a href="#">服饰</a></li>
			<li><a href="#">产品预订</a></li>
			<li><a href="#">积分商城</a></li>
			<li><a href="#">礼品DIY</a></li>
			<li><a href="#">区域合作</a></li>
			<li><a href="#">联系我们</a></li>
			<li><a href="#">购物车</a></li>
		 </ul>			 
		</div>
	<script>$("#Navigation").slide({titCell:".Navigation_name li"});</script>		
  </div>
</div>
</div>
</div>
<div id="Orders" class="Inside_pages  clearfix">
<div class="Process"></div>
  <div class="Orders_style clearfix">

     <div class="address clearfix">

       <div class="title">收货人信息</div>

          <div class="adderss_list clearfix">

            <div class="title_name">选择收货地址 <a href="#">+添加地址</a></div>
              <#list addr.data as addr>
            <div class="list" id="select">
            <ul class="confirm active">
            <div class="default">默认地址</div>

            <div class="adderss_operating">
             <div class="Operate"><a href="#" class="delete_btn"></a> <a href="#" class="modify_btn"></a></div>
            </div>
            <div class="user_address">
            <li>${addr.consignee}</li>
            <li>${addr.sheng}-${addr.shi}-${addr.xian}-${addr.street}</li>
            <#--<li class="Postcode">${addr.street}</li>-->
            <li>${addr.umTelephone}</li>
            </div>
            </ul>
          </div>
         </#list>
           </div>


     </div>

     	<form class="form" method="post">  
		<fieldset> 
     <!--快递选择-->
     <div class="express_delivery">
       <div class="title_name">选择快递方式</div>
    
        <ul class="dowebok">
	    <li><input type="radio" name="radio" data-labelauty="圆通快递">
          <div class="description">
           <em class="arrow"></em>
           <p>到付价格=现付价格*1.25 ，不足1元按1元收取，到付最低15元起。此价格供参考，详情请咨询圆通当地营业网点</p>
           <p>资费：15元</p>
           <p class="Note">满68元包邮</p>
           <p><a href="#">点击查看是否在配送范围内</a></p>
          </div>
        </li>
	    <li><input type="radio" name="radio" data-labelauty="中通快递">
         <div class="description">
           <em class="arrow"></em>
           <p>到付价格=现付价格*1.25 ，不足1元按1元收取，到付最低15元起。此价格供参考，详情请咨询圆通当地营业网点</p>
           <p>资费：15元</p>
           <p class="Note">满68元包邮</p>
          </div>
        </li>
	    <li><input type="radio" name="radio" data-labelauty="申通快递">
         <div class="description">
           <em class="arrow"></em>
           <p>到付价格=现付价格*1.25 ，不足1元按1元收取，到付最低15元起。此价格供参考，详情请咨询圆通当地营业网点</p>
           <p>资费：15元</p>
           <p class="Note">满68元包邮</p>
          </div>
        </li>
	    <li><input type="radio" name="radio" data-labelauty="邮政EMS">
         <div class="description">
           <em class="arrow"></em>
           <p>到付价格=现付价格*1.25 ，不足1元按1元收取，到付最低15元起。此价格供参考，详情请咨询圆通当地营业网点</p>
           <p>资费：15元</p>
           <p class="Note">满68元包邮</p>
          </div>
        </li>
        <li><input type="radio" name="radio" data-labelauty="城际快递">
         <div class="description">
           <em class="arrow"></em>
           <p>到付价格=现付价格*1.25 ，不足1元按1元收取，到付最低15元起。此价格供参考，详情请咨询圆通当地营业网点</p>
           <p>资费：同城包邮</p>
   
          </div>
        </li>
        <li><input type="radio" name="radio" data-labelauty="韵达快递">
         <div class="description">
           <em class="arrow"></em>
           <p>到付价格=现付价格*1.25 ，不足1元按1元收取，到付最低15元起。此价格供参考，详情请咨询圆通当地营业网点</p>
           <p>资费：15元</p>
           <p class="Note">满68元包邮</p>
          </div>
        </li>
	    <li><input type="radio" name="radio" data-labelauty="国通快递">
         <div class="description">
           <em class="arrow"></em>
           <p>到付价格=现付价格*1.25 ，不足1元按1元收取，到付最低15元起。此价格供参考，详情请咨询圆通当地营业网点</p>
           <p>资费：15元</p>
           <p class="Note">满68元包邮</p>
          </div>
        </li>
	    <li><input type="radio" name="radio" data-labelauty="顺丰快递">
         <div class="description">
           <em class="arrow"></em>
           <p>到付价格=现付价格*1.25 ，不足1元按1元收取，到付最低15元起。此价格供参考，详情请咨询圆通当地营业网点</p>
           <p>资费：15元</p>
           <p class="Note">满88元包邮</p>
          </div>
        </li>
	    <li><input type="radio" name="radio" data-labelauty="邮政小包">
         <div class="description">
           <em class="arrow"></em>
           <p>到付价格=现付价格*1.25 ，不足1元按1元收取，到付最低15元起。此价格供参考，详情请咨询圆通当地营业网点</p>
           <p>资费：15元</p>
           <p class="Note">满68元包邮</p>
          </div>
        </li>
        <li><input type="radio" name="radio" data-labelauty="天天快递">
         <div class="description">
           <em class="arrow"></em>
           <p>到付价格=现付价格*1.25 ，不足1元按1元收取，到付最低15元起。此价格供参考，详情请咨询圆通当地营业网点</p>
           <p>资费：15元</p>
           <p class="Note">满68元包邮</p>
          </div>
        </li>
        </ul>       
      
     </div>
    
     <!--付款方式-->
     <div class="payment">
      <div class="title_name">支付方式</div>
       <ul>
        <li><input type="radio" name="radio1" data-labelauty="余额支付"></li>
        <li><input type="radio" name="radio1" data-labelauty="支付宝"></li>
        <li><input type="radio" name="radio1" data-labelauty="财付通"></li>
        <li><input type="radio" name="radio1" data-labelauty="银联支付"></li>
         <li><input type="radio" name="radio1" data-labelauty="货到付款"></li>
       </ul>
     </div>
      <!--发票样式-->
     <div class="invoice_style">
       <ul>
         <li class="invoice_left"><input name="" type="checkbox" value="" data-labelauty="是否开发票"/> </li>
         <li class="invoice_left"><select name="somename" class="SlectBox" onclick="console.log($(this).val())" onchange="console.log('change is firing')">
              <option disabled="disabled" selected="selected">发票类型</option>
              <option value="办公用品">办公用品</option>
              <option value="食品">食品</option>
              <option value="20元红包">20元红包</option>
              <option value="50元红包">50元红包</option>
              <option value="100元红包">100元红包</option>
              <option value="200元红包">200元红包</option>
            </select>
         </li>
         <li class="invoice_left">发票抬头
         <input name="" type="text" class="text_info" /></li>
         <li class="invoice_left">
         <select name="somename" class="SlectBox" onclick="console.log($(this).val())" onchange="console.log('change is firing')">
              <option disabled="disabled" selected="selected">发票内容</option>
              <option value="办公用品">办公用品</option>
              <option value="食品">食品</option>
              <option value="数码配件">数码配件</option>
              <option value="电脑">电脑</option>
              <option value="手机">手机</option>
              <option value="200元红包">200元红包</option>
            </select>
         
         </li>
        </ul>
     </div>
     <!--产品列表-->

     <div class="Product_List">
         <div id="coupon_box" class="Coupon_box">
             <div id="coupon_banner" class="Coupon_banner">
                 <div class="Choose" onclick="changeBanner(this)">优惠券</div>
                 <div class="UnChoose" onclick="changeBanner(this)">礼品卡</div>
                 <div class="UnChoose" onclick="changeBanner(this)">兑换码</div>
             </div>
             <div id="coupon_tainner" class="Coupon_tainnner">
                 <#list data.data as list>
                    <#if (list.isAvilable ==0)>
                        <div class="Aviliable" onclick="choseCoupon(this,${list.cpReduce})">
                            <input type="hidden" id="orderCpId" value="${list.cpId}"/>
                            <div class="TopDiv">
                                <font size="5">满${list.cpAhieve}</font>
                                <font size="2">减${list.cpReduce}</font>
                            </div>

                            <div class="BottomDiv">
                                类型:${list.cpTypeName}
                            </div>
                        </div>
                    </#if>
                     <#if (list.isAvilable !=0)>
                         <div class="UnAviliable">
                             <div class="TopDiv">
                                 <font size="5">满${list.cpAhieve}</font>
                                 <font size="2">减${list.cpReduce}</font>
                             </div>
                             <div class="BottomDiv">
                                 类型:${list.cpTypeName}
                             </div>
                             <span>
                                 <font color="red">不可用原因:${list.msg}</font>
                             </span>
                         </div>
                     </#if>
                 </#list>
             </div>
         </div>


      <table>
       <thead><tr class="title">
           <td class="name">商品名称</td><td class="price">商品价格</td>
           <td class="Preferential">优惠价</td><td class="Quantity">购买数量</td>
           <td class="Money">金额</td></tr></thead>
       <tbody>
       <tr>
        <td class="Product_info">
         <a href="#"><img src="${product.data.pdPicUrl}"  width="100px" height="100px"/></a>
         <a href="#" class="product_name" id="productName">${product.data.pdName}</a>
         </td>
        <td><i>￥</i>${product.data.pdPrice}</td>
        <td><i id="youhuijia">0</i></td>
        <td>${product.data.num}</td>
         <td class="Moneys"><i id="orderTotal">￥${product.data.pdPrice * product.data.num }</i></td>
       </tr>
       </tbody>
      </table>
      <div class="Pay_info">
       <label>订单留言</label><input name="" type="text"  onkeyup="checkLength(this);" class="text_name " />  <span class="wordage">剩余字数：<span id="sy" style="color:Red;">50</span></span>  
      </div>
      <!--价格-->
      <div class="price_style">
      <div class="right_direction">
        <ul>
         <li><label>商品总价</label><i>￥</i><span>${product.data.pdPrice * product.data.num }
               <input type="hidden" id="totalPrice" value="${product.data.pdPrice?string(".00") } "/>
                 <input type="hidden" id="buy-num" value="${product.data.num}"/>
                 <input type="hidden" id="pd-id" value="${product.data.pdId}"/>
             </span></li>
         <li><label>优惠金额</label><i>￥</i><span id="reducePrice">-${priceInfo.reducePrice}</span></li>
         <li><label>配&nbsp;&nbsp;送&nbsp;&nbsp;费</label><i>￥</i><span>0</span></li>
         <li class="shiji_price"><label>实&nbsp;&nbsp;付&nbsp;&nbsp;款</label><i>￥</i><span id="realPrice">${product.data.pdPrice * product.data.num }</span></li>
        </ul>   
        <div class="btn"><input id="submit" type="button" value="提交订单" class="submit_btn" onclick="orderDetail()"/> <input name="" type="button" value="返回购物车"  class="return_btn"/></div>
         <div class="integral right">待订单确认后，你将获得<span>345</span>积分</div>
      </div>
      </div>
     </div>  
     </fieldset>
        </form>
  </div>
  </div>
</div>
</div>
  <!--底部样式-->
 <div class="ft_footer_service" id="footer">
  <div class="footerbox" >
  <!--底部-->
  <div class="Menu_style ensure ">
    <div class="phone">
      400-3456-333
    </div>
    <div class="icon_en">
     <a href="#" class="icon_link"><img src="/common/images/footer_icon_31.png" /><span class="left"><h2>退换货</h2>7天无理由退换货</span></a>
     <a href="#" class="icon_link"><img src="/common/images/footer_icon_33.png" /><span class="left"><h2>正品保障</h2>企业认证产品</span></a>
     <a href="#" class="icon_link"><img src="/common/images/footer_icon_35.png" /><span class="left"><h2>满包邮</h2>满68元包邮</span></a>
     <a href="#" class="icon_link"><img src="/common/images/footer_icon_37.png" /><span class="left"><h2>直供产品</h2>厂家直销平台</span></a>
    </div>
   </div>
  </div>
 </div>

<script type="text/javascript">

    function orderDetail() {

         var pdId = $('#pd-id').val();
         var num = parseFloat($('#buy-num').val());
         var cpId = $('#orderCpId').val();

         //商品价格
        var pdPrice = $('#totalPrice').val();
         //获取商品总价
        var productTotalPrice = parseFloat($('#totalPrice').val()) * parseFloat($('#buy-num').val());
         //优惠券价格
        var reducePrice = $('#reducePrice').text();
         //实际价格
        var realPrice = productTotalPrice - parseFloat(reducePrice);
        //商品名称
        var pdName = $('#productName').text();
        var data = {pdId:pdId,
                    num:num,
                    cpId:cpId,
                    productTotalPrice:productTotalPrice,
                    reducePrice:reducePrice,
                    realPrice:realPrice}

        /*var data = {"pdId":pdId,
            "num":num,
            "cpId":cpId,
            "productTotalPrice":productTotalPrice,
            "reducePrice":reducePrice,
            "realPrice":realPrice} json.stringify(data) */
        $.ajax({
            url:'/product/jian',
            type:"GET",
            data:data,
            contentType: 'application/json;charset=UTF-8',
            dataType:"json",
            success:function (data1) {
                 if(data1.errCode == 0){
                    var smg = "是否去支付页面"
                    if(confirm(smg) == true){
                        location.href="/product/group-buy?pdName="+pdName+"&num="+num +"&pdPrice="+pdPrice+"&cpId="+cpId+"&realPrice="+realPrice
                    }else{
                        location.href="/login/login-error"
                    }
               }
            },
            error:function (err) {

                alert("系统异常 请联系管理员111111111")
            }
        })

    }


    function choseCoupon(obj,reduce) {

       $(obj).css({"border":"3px solid aqua"})

        //获取商品价格
        var productPrice = parseFloat($('#totalPrice').val());
        //获取商品数量
        var num = parseFloat($('#buy-num').val());
        //获取商品总价
       var totalPrice = productPrice * num
        //满减
        $('#reducePrice').text("-"+reduce);
       var productPrice = productPrice - reduce;
        //实际付款 并赋值
         var realPrice = totalPrice - parseFloat(reduce);
         $('#realPrice').text(realPrice);
         //优惠价
         $('#youhuijia').text(productPrice)
        //总价
        $('#orderTotal').text(realPrice)


    }


    function changeBanner(obj) {
        //更新未选中
        $(".Choose").attr({"class":"UnChoose"});
        //选择
        $(obj).attr({"class":"Choose"});

    }
</script>

 <!--底部样式-->
 <div class="footer">
  <div class="footerbox clearfix">
  <div class="clearfix">
   <div class="left help_link">
    <dl>
	 <dt>投保指南</dt>
	 <dd><a href="#">保险需求测试</a></dd>
     <dd><a href="#">专题及活动</a></dd>
     <dd><a href="#">挑选保险产品</a> </dd>
     <dd><a href="#">常见问题 </a></dd>
	</dl>
	<dl>
	 <dt>保险服务</dt>
	 <dd><a href="#">保险需求测试</a></dd>
     <dd><a href="#">专题及活动</a></dd>
     <dd><a href="#">挑选保险产品</a> </dd>
     <dd><a href="#">常见问题 </a></dd>
	</dl>
	<dl>
	 <dt>支付方式</dt>
	 <dd><a href="#">保险需求测试</a></dd>
     <dd><a href="#">专题及活动</a></dd>
     <dd><a href="#">挑选保险产品</a> </dd>
     <dd><a href="#">常见问题 </a></dd>
	</dl>
	<dl>
	 <dt>帮助中心</dt>
	 <dd><a href="#">保险需求测试</a></dd>
     <dd><a href="#">专题及活动</a></dd>
     <dd><a href="#">挑选保险产品</a> </dd>
     <dd><a href="#">常见问题 </a></dd>
	</dl>	   
   </div>
   <!--信息内容-->

  <!--认证-->
 <!--认证展示样式-->
<div class="Authenticate left clearfix" id="Authenticate_show">
  <div class="Authenticate_show">
  <div class="picMarquee-left">
			<div class="hd">
				<a class="next">&lt;</a>
				<a class="prev">&gt;</a>
			</div>
			<div class="bd">
				<ul class="picList">
					<li>
						<div class="pic"><a href="" target="_blank"><img src="/common/images/pic1.jpg" /></a></div>
                          <!--<div class="title"><a href="http://www.SuperSlide2.com" target="_blank">效果图1</a></div>-->					
                    </li>
					<li>
						<div class="pic"><a href="" target="_blank"><img src="/common/images/pic2.jpg" /></a></div>
						<!--<div class="title"><a href="http://www.SuperSlide2.com" target="_blank">效果图2</a></div>-->
					</li>
					<li>
						<div class="pic"><a href="" target="_blank"><img src="/common/images/pic3.jpg" /></a></div>
						
					</li>
					<li>
						<div class="pic"><a href="" target="_blank"><img src="/common/images/pic4.jpg" /></a></div>
						
					</li>
					<li>
						<div class="pic"><a href="" target="_blank"><img src="/common/images/pic5.jpg" /></a></div>
						
					</li>
					<li>
						<div class="pic"><a href="" target="_blank"><img src="/common/images/pic6.jpg" /></a></div>
						
					</li>
                    <li>
						<div class="pic"><a href="" target="_blank"><img src="/common/images/pic6.jpg" /></a></div>
						
					</li>
                    <li>
						<div class="pic"><a href="" target="_blank"><img src="/common/images/pic6.jpg" /></a></div>
						
					</li>
				</ul>
			</div>
		</div>


		<script type="text/javascript">
		jQuery(".picMarquee-left").slide({mainCell:".bd ul",autoPlay:true,effect:"leftMarquee",vis:2,interTime:50});
		</script>
  </div>
</div>
  </div>
 <div class="text_link">
   <p>
  <a href="#">关于我们</a>｜ <a href="#">公开信息披露</a>｜ <a href="#">加入我们</a>｜ <a href="#">联系我们</a>｜ <a href="#">版权声明</a>｜ <a href="#">隐私声明</a>｜ <a href="#">网站地图</a></p>
	 <p>蜀ICP备11017033号 Copyright ©2011 成都福际生物技术有限公司 All Rights Reserved. Technical support:CDDGG Group</p>
  </div>
  </div>
 </div>
<script type="text/javascript">
function checkLength(which) {
	var maxChars = 50; //
	if(which.value.length > maxChars){
		alert("您出入的字数超多限制!");
		// 超过限制的字数了就将 文本框中的内容按规定的字数 截取
		which.value = which.value.substring(0,maxChars);
		return false;
	}else{
		var curr = maxChars - which.value.length; //250 减去 当前输入的
		document.getElementById("sy").innerHTML = curr.toString();
		return true;
	}
}
</script>
<script>
$(function(){
	$(':input').labelauty();
});
</script>
</body>
</html>
