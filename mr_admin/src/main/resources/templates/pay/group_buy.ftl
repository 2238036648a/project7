<!DOCTYPE html>
<html>

<head>
	<title>软件购买页面-夏冰软件</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script src="/common/js/jquery.min.1.8.2.js" type="text/javascript"></script>

	<style type="text/css">
		html {
			color: #000;
			background: #eaeaea;
			-webkit-text-size-adjust: 100%;
			-ms-text-size-adjust: 100%
		}

		body {
			overflow-y: scroll;
			*overflow-y: visible;
		}

		body {
			background: #e7e8eb;
			font: 13px/2em Helvetica Neue, Hiragino Sans GB, Microsoft YaHei, 微软雅黑, 黑体, Arial, sans-serif;
			margin: 0;
			padding: 0
		}

		.header {
			width: 100%;
			font-family: "Helvetica Neue", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", "黑体", Arial, sans-serif;
			height: 60px;
			padding-top: 10px;
			border-bottom: 2px solid #ccc;
			background: #fff;
			border-top: 3px #87ba67 solid;
		}

		.container {
			width: 980px;
		}

		#nav {
			background: #FFF;
			height: 60px;
			margin: 0 auto;
			position: relative;
			z-index: 99;
		}

		#logo {
			background: url(images/logo.png);
			height: 49px;
			left: 10px;
			position: absolute;
			top: 0;
			width: 300px;
		}

		#login-area {
			float: right;
			position: relative;
			text-align: center;
			height: 49px;
			width: 500px;
		}

		#login-area .text {
			font-size: 18px;
			width: 300px;
			float: left;
			height: 49px;
		}

		#login-area .image-area {
			width: 152px;
			float: right;
		}

		#main {
			width: 100%;
			padding-top: 20px;
		}

		.ue-main-wrap {
			background: rgb(255, 255, 255);
			margin: 0px auto;
			padding: 0px;
			width: 980px;
			box-shadow: 2px 0px 5px rgba(214, 214, 215, 0.9), -2px 0px 5px rgba(214, 214, 215, 0.9);
			overflow: hidden
		}

		.ue-videoList-box {
			padding: 20px;
			width: 940px;
		}

		.ue-studyPath-box {
			width: 940px;
			padding: 10px 0 20px;
		}

		.ue-foot {
			background: rgb(74, 74, 74);
			margin: 0px auto;
			width: 980px;
		}

		.ue-foot-link {
			width: 100%;
			padding-bottom: 10px;
		}

		.ue-foot-link-t {
			width: 100%;
			margin-top: -4px;
		}

		.ue-foot-link-t * {
			background: rgb(21, 21, 21);
			padding: 0.2em 1em;
			color: rgb(255, 255, 255);
			line-height: 28px;
			font-size: 14px;
			font-weight: bold;
			vertical-align: top;
			display: inline-block;
		}

		.ue-foot-link-l {
			padding: 0px 0px 0px 1.2em;
			width: 610px;
			float: left;
		}

		.ue-foot-link-c {
			padding: 10px 0px 0px;
			width: 100%;
			overflow: hidden;
		}

		.ue-foot-link-l ul {
			width: 110%;
			font-size: 0px;
			display: inline-block;
		}

		.ue-foot-link-l li {
			width: 300px;
			height: 20px;
			overflow: hidden;
			font-size: 12px;
			margin-right: 4%;
			float: left;
		}

		.ue-foot-link-l li a {
			background: url("images/ue-dat-ico-01.png") no-repeat 0.5em 0.5em;
			margin: 0.2em 0px;
			color: rgb(247, 255, 247);
			line-height: 16px;
			overflow: hidden;
			padding-left: 2em;
			vertical-align: top;
			display: inline-block;
		}

		.ue-foot-link-r {
			width: 320px;
			float: right;
		}

		.ue-foot-link-text {
			padding: 10px 0px 0px;
			font-size: 0px;
		}

		.ue-foot-link-text * {
			height: 20px;
			color: rgb(247, 255, 247);
			line-height: 20px;
			font-size: 12px;
			margin-right: 1em;
			vertical-align: top;
			display: inline-block;
		}

		.ue-foot-subNav {
			padding: 0.8em 1em;
		}

		.ue-foot-subNav-l {
			float: left;
		}

		.ue-foot-subNav-l * {
			color: rgb(255, 255, 255);
			line-height: 20px;
		}

		.ue-foot-subNav-r {
			text-align: right;
			color: rgb(255, 255, 255);
			float: right;
			text-align: left;
		}

		.ue-foot-subNav-nav {
			padding: 0px;
			font-size: 0px;
		}

		.ue-foot-subNav-nav * {
			color: rgb(255, 255, 255);
			line-height: 18px;
			font-size: 12px;
		}

		.ue-foot-subNav-nav em {
			padding: 0px 0.6em;
			font-size: 10px;
		}

		.ue-foot-subNav-text {}

		.ue-foot-subNav-text a {
			color: rgb(255, 255, 255);
			overflow: hidden;
			display: inline-block;
		}

		.ue-studyPath-info {
			border-bottom: 3px solid #00cadf;
			padding: 0 0 0 20px;
			margin-bottom: 10px;
		}

		.ue-studyPath-info-img {
			float: left;
			width: 90px;
			height: 90px;
		}

		.ue-studyPath-info-text {
			margin-left: 100px;
			_margin-left: 130px;
		}

		.ue-studyPath-info-name {
			font-size: 14px;
			padding: 0 0 0 0;
		}

		.ue-studyPath-info-desc {
			list-style: 20px;
			color: #666;
		}

		.blue {
			border-bottom: 3px solid #87ba67
		}

		.ue-index-join {
			background: #87ba67;
			padding: 1em;
			text-align: center;
			margin-top: 10px;
			margin-bottom: 10px;
		}

		.ue-index-join-name {
			font-weight: bold;
			font-size: 18px;
			color: #FFF;
			padding-bottom: 0.7em;
		}

		.ue-index-join-desc {
			line-height: 20px;
		}

		.ue-index-join-btn {
			font-size: 0;
			padding-top: 15px;
		}

		.ue-index-join-btn * {
			display: inline-block;
			vertical-align: top;
			color: #000;
			font-size: 12px;
		}

		.ue-index-join-btn a {
			border: 1px solid #979797;
			padding: 0.4em 2em;
			margin: 0 10px;
		}

		.ue-index-join-btn span {
			font-size: 16px;
			font-weight: bold;
		}

		.ue-index-join-btn a.orange {
			background: #f5a623;
		}

		.ue-index-join-btn a.gray {
			background: #d2c6b2;
		}

		.ue-index-vip {
			margin-bottom: 20px;
			margin-top: 10px;
		}

		.ue-index-vip .ue-block-box-c {
			overflow: hidden;
		}

		.ue-index-vip .ue-index-vip-box {
			width: 110%;
			padding-top: 15px;
			margin-top: -17px;
		}

		.ue-index-vip-list {
			float: left;
			width: 190px;
			height: 120px;
			margin: 17px 17px 0 0;
			overflow: hidden;
			border: 1px solid #87ba67;
			padding: 15px;
			text-align: center;
			position: relative;
		}

		.ue-index-vip-list-img {
			width: 40px;
			height: 40px;
			margin: 0 auto;
		}

		.ue-index-vip-list-name {
			height: 18px;
			font-size: 14px;
			color: #333;
			font-weight: bold;
			padding: 0.5em 0;
		}

		.ue-index-vip-list-desc {
			color: #666;
			text-align: left;
		}

		.ue-index-vip-list-hide {
			width: 190px;
			padding: 15px;
			height: 90px;
			position: absolute;
			bottom: -130px;
			left: -1px;
			background-color: #87ba67;
			border: 1px solid #87ba67;
			color: #fff;
			box-shadow: 0 0 3px #666;
			text-align: center;
		}

		.ue-index-vip-list-hide td {
			width: 190px;
			height: 90px;
		}

		.ue-index-vip-box .bg .ue-index-vip-list-hide {
			bottom: -1px;
		}

		.ue-boxShadow {
			overflow: hidden;
		}

		.ue-boxShadow .ue-block-box-t {
			/*border-bottom: 1px solid #979797;*/
		}

		.ue-block-box {}

		.ue-block-box-course {
			padding-top: 15px;
		}

		.ue-block-box-t {
			/*border-bottom: 1px solid #e0e0e0;*/
			padding: 0 0 0.5em;
		}

		.ue-block-box-t-l {
			float: left;
			padding: 0 0 0 8px;
		}

		.ue-block-box-t-l-course {
			float: left;
			padding: 0 0 0 8px;
			border-left: 3px solid #82ce05;
			width: 100%;
		}

		.ue-block-box-t-l-answer {
			float: left;
			padding: 0 0 0 8px;
			width: 100%;
		}

		.ue-block-box-t-i {
			float: left;
			padding: 0 0 0 0px;
		}

		.ue-block-box-t-c {
			font-size: 16px;
			color: #333;
			padding: 0.2em 0;
			line-height: 18px;
		}

		.ue-block-box-t-desc {
			color: #999;
		}

		.ue-block-box-t-r {
			float: right;
		}

		.ue-block-box-t-c .more {
			float: right;
			font-size: 10px;
			font-weight: normal;
			margin-right: 10px;
		}

		.ue-index-onlinejike {
			width: 100%;
			margin-bottom: 20px;
		}

		.ue-index-onlinejike .ue-block-box-c {
			overflow: hidden;
			padding: 1em 0 0;
		}

		.ue-onlinejike-list-box {
			width: 110%;
		}

		.ue-onlinejike-list {
			width: 21%;
			margin-right: 20px;
			float: left;
		}

		.ue-onlinejike-list-t {
			border-bottom: 1px solid #4a4a4a;
		}

		.ue-onlinejike-list-t * {
			display: inline-block;
			vertical-align: top;
		}

		.ue-onlinejike-list-t span {
			width: 25px;
			height: 29px;
			color: #fff;
			background: #f60;
			text-align: center;
			line-height: 29px;
			font-size: 15px;
		}

		.ue-onlinejike-list-t em {
			line-height: 29px;
			font-size: 15px;
			margin-left: 0.6em;
		}

		.ue-onlinejike-list-subt {
			padding-left: 25px;
			height: 30px;
			overflow: hidden;
			padding-top: 0.8em;
		}

		.ue-onlinejike-list-subt * {
			display: inline-block;
			vertical-align: top;
			line-height: 26px;
			font-size: 13px;
			color: #417505;
		}

		.ue-onlinejike-list-subt em {
			font-size: 40px;
			color: #9b9b9b;
			font-weight: bold;
			font-family: 'Arial';
			line-height: 30px;
			margin-top: 8px;
			*margin-top: 6px;
		}

		.ue-onlinejike-list-desc {
			font-size: 12px;
			padding-top: 5px;
			line-height: 24px;
			height: 66px;
			overflow: hidden;
		}

		a.ue-btn-gray,
		a.ue-btn-gray span,
		a.ue-btn-orange,
		a.ue-btn-orange span,
		a.ue-btn-green span,
		a.ue-btn-green,
		a.ue-btn-blue span,
		a.ue-btn-blue {
			display: inline-block;
			vertical-align: top;
			border-radius: 2px;
		}

		a.ue-btn-gray span,
		a.ue-btn-orange span,
		a.ue-btn-green span,
		a.ue-btn-blue span {
			cursor: pointer;
			height: 1.25em;
			line-height: 1.25em;
			padding: 0.5em 1.5em;
			*padding: 0.4em 1.5em 0.6em;
		}

		a.ue-btn-gray em,
		a.ue-btn-orange em,
		a.ue-btn-green em,
		a.ue-btn-blue em {
			font-size: 1em;
			display: inline-block;
			font-size: 1em;
			line-height: 1.25em;
			cursor: pointer;
			vertical-align: top;
		}

		a.ue-btn-3em span {
			padding: 0.5em 4em;
			*padding: 0.4em 4em 0.6em;
		}

		a.ue-btn-gray {
			background-color: #e4e4e4;
			color: #666;
		}

		a.ue-btn-gray:hover {
			background-color: #f3f3f3;
			color: #000;
		}

		a.ue-btn-orange {
			background-color: #f60;
			color: #fff;
			margin-right: 10px;
		}

		a.ue-btn-orange:hover {
			background-color: #ff8400;
		}

		a.ue-btn-green {
			background-color: #82ce05;
			color: #fff;
		}

		a.ue-btn-green:hover {
			background-color: #8fe205;
		}

		a.ue-btn-blue {
			background-color: #0087cb;
			color: #fff;
		}

		a.ue-btn-blue:hover {
			background-color: #0690d6;
		}

		.clear {
			height: 0px;
			overflow: hidden;
			clear: both;
			visibility: hidden;
		}

		td {
			color: #090909;
			word-break: break-all;
			padding-left: 10px;
		}

		.title {
			font-size: 14px;
		}

		.bignum {
			font-size: 16px;
		}

		.boxblue {
			margin: 0px 0px 9px;
			padding: 1px;
			border: 1px solid #526E8C;
		}

		a.none:link {
			text-decoration: none;
			color: #0000AA;
		}

		a.none:visited {
			text-decoration: none;
			color: #0000AA;
		}

		a.none:hover {
			text-decoration: underline;
			color: #FF0000;
		}

		a.comm:link {
			text-decoration: underline;
			color: #1A1AD1;
		}

		a.comm:visited {
			text-decoration: underline;
			color: #1A1AD1;
		}

		a.comm:hover {
			text-decoration: underline;
			color: #1A1AD1;
		}

		.boxblueu {
			margin: 0px 0px 9px;
			padding: 0px 2px 2px;
			border-top: 1px none #526E8C;
			border-right: 1px solid #526E8C;
			border-bottom: 1px solid #526E8C;
			border-left: 1px solid #526E8C;
		}

		.boxgray {
			border: 1px solid #FFCC66;
			background-color: #FFFDF0;
		}

		.box_blue {
			border: 1px solid #B4D0DC;
			background-color: #F2FBFF;
		}

		.box_gray {
			border: 1px solid #C4C4C4;
			background-color: #FCFCFC;
			padding: 6px;
			word-break: break-all;
			cursor: hand
		}

		.line110 {
			line-height: 17px;
		}

		.boxtgray {
			margin: 0px 0px 15px;
			padding: 2px;
			border-top: 3px solid #8C8C8C;
			border-right: 1px solid #8C8C8C;
			border-bottom: 1px solid #8C8C8C;
			border-left: 1px solid #8C8C8C;
		}

		.inputfmt {
			font-size: 12px;
			border: 1px solid #A5A5A5;
			height: 20px;
			padding-top: 3px;
			padding-left: 3px;
			color: #090909;
		}

		.menuinputfmt {
			font-size: 12px;
			border: 1px solid #A5A5A5;
			height: 18px;
			color: #333333;
			padding: 2px;
		}

		.font12 {
			font-size: 12px;
			color: #333333;
		}

		.formfmt {
			margin: 0px;
			padding: 0px;
		}

		.btnfmt {
			background-color: #DDDDDD;
			border: 1px ridge #9C9C9C;
			font-size: 12px;
			padding-top: 2px;
			padding-right: 0px;
			padding-bottom: 0px;
			padding-left: 0px;
			color: #090909;
			height: 20px;
		}

		a.menu:link {
			text-decoration: none;
			color: #333333;
		}

		a.menu:visited {
			text-decoration: none;
			color: #333333;
		}

		a.menu:hover {
			text-decoration: none;
			color: #FF0000;
		}

		a.text:link {
			text-decoration: none;
			color: #090909;
		}

		a.text:visited {
			text-decoration: none;
			color: #090909;
		}

		a.text:hover {
			color: #FF0000;
		}

		.line120 {
			line-height: 19px;
		}

		a.text2:link {
			color: #666666;
			text-decoration: none;
		}

		a.text2:visited {
			color: #666666;
			text-decoration: none;
		}

		a.text2:hover {
			color: #333333;
			text-decoration: underline;
		}

		.boxupline {
			padding-top: 15px;
			border-top: 1px solid #969696;
			border-right: #969696;
			border-bottom: #969696;
			border-left: #969696;
			padding-bottom: 5px;
		}

		.boxblue2 {
			margin: 0px 0px 9px;
			padding: 1px;
			border: 1px solid #D2DFEA;
			line-height: 19px;
		}

		.tip {
			margin-left: 30px;
			margin-right: 25px;
			margin-bottom: 10px;
			margin-top: 10px;
			padding: 10px;
			background-color: #FFFFFA;
			border: 1px solid #CCCCCC;
			color: #666666;
			line-height: 19px;
		}

		.tip_layer {
			position: absolute;
			visibility: hidden;
			overflow: auto;
			width: 200px;
			padding: 5px;
			background-color: #FFFFE1;
			border: 1px solid #333333;
			line-height: 16px;
			margin-left: 150px;
		}

		.btnfmt2 {
			background-image: url(images/btn_back_01.gif);
			color: #FFFFFF;
			border: 0px;
			height: 21px;
			width: 65px;
			font-size: 12px;
			padding-top: 2px;
		}

		.btnfmt4 {
			background-image: url(images/btn_back_02.gif);
			color: #FFFFFF;
			border: 0px;
			height: 21px;
			width: 75px;
			padding-top: 2px;
			font-size: 12px;
		}

		.inputfmt2 {
			font-size: 12px;
			border: 1px solid #A5A5A5;
			padding-top: 3px;
			padding-left: 3px;
			background-color: #FFFFFF;
			color: #090909;
		}

		.kuang7 {
			border: 1px solid #A6C0DA;
		}

		.u_kuang_D1D3D4 {
			border-right-width: 1px;
			border-bottom-width: 1px;
			border-left-width: 1px;
			border-right-style: solid;
			border-bottom-style: solid;
			border-left-style: solid;
			border-right-color: #D1D3D4;
			border-bottom-color: #D1D3D4;
			border-left-color: #D1D3D4;
		}

		.shadow_blak {
			font-size: 14px;
			filter: DropShadow(Color=#333333, OffX=1, OffY=1, Positive=1);
			color: #FFFFFF;
		}

		.shadow {
			filter: DropShadow(Color=#333333, OffX=1, OffY=1, Positive=1);
			color: #FFFFFF;
		}

		.shadow_white {
			font-size: 14px;
			filter: DropShadow(Color=#ffffff, OffX=1, OffY=1, Positive=1);
			color: #333333;
		}

		.shadow_image {
			filter: DropShadow(Color=#c2c2c2, Direction=135);
		}

		.glow_text {
			filter: Glow(Color=#ffffff, Strength=2);
		}

		.line_th {
			text-decoration: line-through;
		}

		.imgbox {
			border-top: 1px solid #CCC;
			border-right: 1px solid #666;
			border-bottom: 1px solid #666;
			border-left: 1px solid #CCC;
		}

		H1 {
			FONT-WEIGHT: normal;
			FONT-SIZE: 26px;
			COLOR: #000000;
			FONT-FAMILY: "黑体", Arial;
			margin: 3px;
			padding: 3px;
		}

		.Shadow_table {
			filter: progid:DXImageTransform.Microsoft.DropShadow(color=#efefef, offX=3, offY=5, positives=false);
			background-color: #FFFFFF;
			border: 1px solid #C0C0C0;
		}

		#idnum {
			MARGIN: 110px 0px 0px 87px;
		}

		UL {
			LIST-STYLE-TYPE: none
		}

		UL {
			MARGIN: 0px;
			PADDING: 0px;
		}

		LI {
			MARGIN: 0px;
			PADDING: 0px;
		}
	</style>
</head>

<body>

<div class="header">
	<div class="container" id="nav">
		<div id="logo"></div>
		<div id="login-area"><img src="images/untitled.png" width="518" height="30"></div>
	</div>
</div>

<div id="main">
	<DIV class="ue-main-wrap">
		<div class="ue-videoList-box">
			<div class="ue-studyPath-info blue">
			</div>
			<form action="payapi.php" method="post" name="orderform" target="_top" class="formfmt" onSubmit="return VerifyData();">

				<table width="100%" border="0" cellpadding="2" cellspacing="1" class="line110">

					<tr>
						<td height="35" colspan="2" bgcolor="#F1F1F1"><strong>
								<font color="#333333">1 请选择您需要购买的软件和填写购买的数量</font>
							</strong></td>
					</tr>

					<tr>
						<td width="20%" height="30" align="center" bgcolor="#F8F8F8">软件名称:</td>
						<td> <label><select name="soft_id" size="1" onChange="change_payment()"><option value="BFE0001">${productBuy.pdName}
									<#--</option><option value="UE00002">U盘超级加密3000</option><option value="MTS0003">定时关机3000
									</option><option value="BSE0004">超级加密3000</option><option value="ASF0006">超级秘密文件夹</option>
									<option value="BDL0007">磁盘加锁专家</option><option value="EFG0008">文件夹保护3000</option>
									<option value="CFR0009">CHK文件夹恢复专家</option><option value="ASD0010">超级秘密磁盘3000</option>
									<option value="OTH0011">其他软件或服务购买</option><option value="SFE0012">共享文件夹加密超级大师</option>
									<option value="MCE0012">U盘内存卡批量加密专家</option><option value="FRE0015">文件夹只读加密专家</option>
									<option value="MTS0013">定时关机3000一年版</option><option value="MTS0023">定时关机3000三月版</option>-->
								</select></label>                        </tr>
					<tr>
						<td width="20%" height="30" align="center" bgcolor="#F8F8F8">订单价格:</td>
						<td><input name="total_fee" class="inputfmt" id="totalRealPrice" value="${productBuy.totalPrice}" size="10" maxlength="10">元</td>
					</tr>
					<tr>
						<td height="30" align="center" bgcolor="#F8F8F8">购买数量:</td>
						<td><input name="orsoqty" type="text" id="buyNum" class="inputfmt" value="${productBuy.buyNum}" size="5" maxlength="5" onkeypress='return /^\d$/.test(String.fromCharCode(event.keyCode||event.keycode||event.which))' oninput='this.value = this.value.replace(/\D+/g, "")' onpropertychange='if(!/\D+/.test(this.value)){return;};this.value=this.value.replace(/\D+/g, "")' onblur='this.value = this.value.replace(/\D+/g, "")'>件 &nbsp;&nbsp;</td>
						<!--购买数量-->
					</tr>
					<tr style="display:">
						<td height="50" colspan="2">&nbsp;<input name="orinvoice" type="checkbox" id="orinvoice" value="是" onClick="showinvoice();"> <label for="orinvoice">需要发票: 邮寄费 <font color="#FF0000">10</font>元（新疆、西藏、内蒙古 邮寄费<font color="#FF0000"> 25</font>元），发票金额包含发票邮寄费。</label></td>
					</tr>
					<tr id="invoice" style="display:none">
						<td height="25" align="center" bgcolor="#F8F8F8">发票抬头:</td>
						<td> <input name="orinvoicehead" type="text" class="inputfmt" id="orinvoicehead" value="" size="40">
							<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr id="postinfo0" style="display:none">
						<td height="25" align="center" bgcolor="#F8F8F8">税号:</td>
						<td><input name="shuihao" type="text" class="inputfmt" id="shuihao" value="" size="32">
							<font color="#FF0000">如果需要机打发票请填写税号。</font>
						</td>
					</tr>
					<tr id="postinfo1" style="display:none">
						<td height="25" align="center" bgcolor="#F8F8F8">真实姓名:</td>
						<td><input name="username" type="text" class="inputfmt" id="username" value="" size="15">
							<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr id="postinfo2" style="display:none">
						<td height="25" align="center" bgcolor="#F8F8F8">联系电话:</td>
						<td><input name="usertel" value="" type="text" class="inputfmt" id="usertel" size="15">
							<font color="#FF0000">*</font>
						</td>
					</tr>

					<tr id="postinfo3" style="display:none">
						<td height="25" align="center" bgcolor="#F8F8F8">省份/自治区:</td>
						<td><select id="province" name="province" class="inputfmt" onfocus="MM_showHideLayers('layadd','show')" onblur="MM_showHideLayers('layadd','hide')" onClick="show_price();"></select>
							<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr id="postinfo4" style="display:none">
						<td height="25" align="center" bgcolor="#F8F8F8">城市/地区:</td>
						<td><select id="city" name="city" class="inputfmt" onfocus="MM_showHideLayers('layadd','show')" onblur="MM_showHideLayers('layadd','hide')"></select>
							<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr id="postinfo5" style="display:none">
						<td height="25" align="center" bgcolor="#F8F8F8">区/县:</td>
						<td><select id="county" name="county" class="inputfmt" onfocus="MM_showHideLayers('layadd','show')" onblur="MM_showHideLayers('layadd','hide')"></select>
							<font color="#FF0000">*</font>
						</td>
					</tr>

					<tr id="postinfo6" style="display:none">
						<td height="25" align="center" bgcolor="#F8F8F8">详细地址:</td>
						<td><input name="address" value="" type="text" class="inputfmt" id="address" size="50" onFocus="MM_showHideLayers('layadd','','show')" onBlur="MM_showHideLayers('layadd','','hide')">
							<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr id="postinfo7" style="display:none">
						<td height="25" align="center" bgcolor="#F8F8F8">邮政编码:</td>
						<td><input name="post" type="text" class="inputfmt" id="post" value="" size="15" style="ime-mode:disabled;">
							<font color="#FF0000">*</font>
							<span id="layadd" class="tip_layer" style="width:280px;">详细地址，乡镇或城区，路名或街道名称，门牌号</span>
						</td>
					</tr>
					<tr>
						<td height="35" colspan="2" bgcolor="#F1F1F1">
							<font color="#333333"><strong>2 请选择您方便的付款方式，然后点击下方的提交订单按钮</strong></font>
						</td>
					</tr>
					<tr>
						<td height="35" colspan="2">&nbsp;
							<input name="paymode" type="radio" id="paymode1" value="1" onClick="showpaymode(1);" checked>
							<label for="paymode1"><strong>
									<font color="#003399">支 付 宝</font>
								</strong>: 使用支付宝支付。<font color="#FF0000">推荐!</font></label></td>
					</tr>
					<tr id="alipay" style="display:;">
						<td colspan="2">
							<div class="tip"><img src="/common/images/111.jpg" alt="支付宝" align="absmiddle"> </div>
						</td>
					</tr>
					<tr>
						<!--支付方式-->
						<td height="35" colspan="2">&nbsp;
							<input name="paymode" type="radio" id="paymode1" value="2" onClick="showpaymode(2);" >
							<label for="paymode2"><strong>
									<font color="#003399">网银支付</font>
								</strong>: 适合已开通网上银行的用户。<font color="#FF0000">推荐!</font></label></td>
					</tr>
					<tr id="netpay" style="display:none;">
						<td colspan="2">
							<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1">
								<tr align="center">
									<td height="45"><label for="lab_ICBC"><input type="radio" name="bankId" value="ICBCB2C" class="banking" id="lab_ICBC" checked><img src="../softstore/images/bank_icbc.jpg" alt="工商银行" vspace="5" align="absmiddle"></label></td>
									<td><label for="lab_CMB"><input type="radio" name="bankId" value="CMB" class="banking" id="lab_CMB"><img src="../softstore/images/bank_cmb.jpg" alt="招商银行" align="absmiddle"></label></td>
									<td height="45"><label for="lab_CCB"><input type="radio" name="bankId" value="CCB" class="banking" id="lab_CCB"><img src="../softstore/images/bank_ccb.jpg" alt="建设银行" align="absmiddle"></label></td>
									<td><label for="lab_ABC"><input type="radio" name="bankId" value="ABC" class="banking" id="lab_ABC"><img src="../softstore/images/bank_abc.jpg" alt="农业银行" align="absmiddle"></label></td>
									<td><label for="lab_BOC"><input type="radio" name="bankId" value="BOCB2C" class="banking" id="lab_BOC"><img src="../softstore/images/bank_boc.jpg" alt="中国银行" align="absmiddle"></label></td>
								</tr>
								<tr align="center">
									<td height="45"><label for="lab_SPDB"><input type="radio" name="bankId" value="SPDB" class="banking" id="lab_SPDB"><img src="../softstore/images/bank_spdb.jpg" alt="上海浦东发展银行" align="absmiddle"></label></td>
									<td><label for="lab_CIB"><input type="radio" name="bankId" value="CIB" class="banking" id="lab_CIB"><img src="../softstore/images/bank_cib.jpg" alt="兴业银行" align="absmiddle"></a></label></td>
									<td><label for="lab_GDB"><input type="radio" name="bankId" value="GDB" class="banking" id="lab_GDB"><img src="../softstore/images/bank_gdb.jpg" alt="广发银行" align="absmiddle"></label></td>
									<td height="45"><label for="lab_FDB"><input type="radio" name="bankId" value="FDB" class="banking" id="lab_FDB"><img src="../softstore/images/FDB_OUT.jpg" alt="富滇银行" align="absmiddle"></label></td>
									<td><label for="lab_CITIC"><input type="radio" name="bankId" value="CITIC" class="banking" id="lab_CITIC"><img src="../softstore/images/bank_citic.jpg" alt="中信银行" align="absmiddle"></label></td>
								</tr>
								<tr align="center">
									<td height="45"><label for="lab_HZCBB2C"><input type="radio" name="bankId" value="HZCBB2C" class="banking" id="lab_HZCBB2C"><img src="../softstore/images/bank_hzb.jpg" alt="杭州银行" align="absmiddle"></label></td>
									<td height="45"><label for="lab_SHBANK"><input type="radio" name="bankId" value="SHBANK" class="banking" id="lab_SHBANK"><img src="../softstore/images/bank_shb.jpg" alt="上海银行" align="absmiddle"></label></td>
									<td><label for="lab_NBBANK"><input type="radio" name="bankId" value="NBBANK" class="banking" id="lab_NBBANK"><img src="../softstore/images/bank_nbcb.jpg" alt="宁波银行" align="absmiddle"></label></td>
									<td><label for="lab_SPABANK"><input type="radio" name="bankId" value="SPABANK" class="banking" id="lab_SPABANK"><img src="../softstore/images/bank_pab.jpg" alt="平安银行" align="absmiddle"></label></td>
									<td><label for="lab_POSTGC"><input type="radio" name="bankId" value="POSTGC" class="banking" id="lab_POSTGC"><img src="../softstore/images/bank_psbc.jpg" alt="中国邮政储存" align="texttop"></label></td>
								</tr>
								<tr align="center">
									<td height="45"><label for="lab_COMM-DEBIT"><input type="radio" name="bankId" value="COMM-DEBIT" class="banking" id="lab_COMM-DEBIT"><img src="../softstore/images/bank_bcom.jpg" alt="交通银行" align="absmiddle"></label></td>
									<td><label for="lab_CEB-DEBIT"><input type="radio" name="bankId" value="CEB-DEBIT" class="banking" id="lab_CEB-DEBIT"><img src="../softstore/images/bank_ceb.jpg" alt="光大银行" align="absmiddle"></label></td>
									<td><label for="lab_BJBANK"><input type="radio" name="bankId" value="BJBANK" class="banking" id="lab_BJBANK"><img src="../softstore/images/bank_bob.jpg" alt="北京银行" align="absmiddle"></label></td>
									<td><label for="lab_SHRCB"><input type="radio" name="bankId" value="SHRCB" class="banking" id="lab_SHRCB"><img src="../softstore/images/bank_srcb.jpg" alt="上海农商银行" align="absmiddle"></label></td>
									<td><label for="lab_CMBC"><input type="radio" name="bankId" value="CMBC" class="banking" id="lab_CMBC"><img src="../softstore/images/CMBC_OUT.jpg" alt="民生银行" align="absmiddle"></label></td>
								</tr>
								<tr align="center">
									<td height="45"><label for="lab_BJRCB"><input type="radio" name="bankId" value="BJRCB" class="banking" id="lab_BJRCB"><img src="../softstore/images/bank_bjrcb.jpg" alt="北京农商银行" align="absmiddle"></label></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr align="center">
									<td height="45"><label for="lab_BOCBTB"><input type="radio" name="bankId" value="BOCBTB" class="banking" id="lab_BOCBTB"><img src="../softstore/images/bank_bocB2B.jpg" alt="中国银行企业" align="absmiddle"></label></td>
									<td><label for="lab_CMBBTB"><input type="radio" name="bankId" value="CMBBTB" class="banking" id="lab_CMBBTB"><img src="../softstore/images/bank_cmbB2B.jpg" alt="招商银行" align="absmiddle"></label></td>
									<td><label for="lab_ICBCBTB"><input type="radio" name="bankId" value="ICBCBTB" class="banking" id="lab_ICBCBTB"><img src="../softstore/images/bank_icbcB2B.jpg" alt="工商银行企业" vspace="5" align="absmiddle"></label></td>
									<td><label for="lab_ABCBTB"><input type="radio" name="bankId" value="ABCBTB" class="banking" id="lab_ABCBTB"><img src="../softstore/images/bank_abcB2B.jpg" alt="农业银行企业" align="absmiddle"></label></td>
									<td><label for="lab_CCBBTB"><input type="radio" name="bankId" value="CCBBTB" class="banking" id="lab_CCBBTB"><img src="../softstore/images/bank_ccbB2B.jpg" alt="建设银行企业" align="absmiddle"></label></td>
								</tr>
								<tr align="center">
									<td><label for="lab_SPDBB2B"><input type="radio" name="bankId" value="SPDBB2B" class="banking" id="lab_SPDBB2B"><img src="../softstore/images/bank_spdbB2B.jpg" alt="上海浦东发展银行企业" align="absmiddle"></label></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="35" colspan="2">&nbsp;
							<input type="radio" name="paymode" id="paymode4" value="4" onClick="showpaymode(4);" >
							<label for="paymode4"><strong>
									<font color="#003399">手机扫码付款</font>
								</strong>: 您可以使用手机支付宝、微信扫码付款。</label></td>
					</tr>
					<tr id="saomapay" style="display:none;">
						<td colspan="2">
							<div class="tip">
								<strong>支付宝转账：</strong><br>&nbsp;&nbsp;支付宝帐号：admin@cksis.com&nbsp;&nbsp;账户姓名：洛阳夏冰软件技术有限公司<br><br>
								<strong>微信扫码：</strong><br>&nbsp;&nbsp;微信公众号：jiamisoft&nbsp;&nbsp;账户姓名：夏冰软件<br><br>
							</div>
						</td>
					</tr>
					<tr>
						<td height="35" colspan="2">&nbsp;
							<input type="radio" name="paymode" id="paymode3" value="3" onClick="showpaymode(3);" >
							<label for="paymode3"><strong>
									<font color="#003399">银行转账付款</font>
								</strong>: 您可以直接通过银行转账付款。</label></td>
					</tr>
					<tr id="bankpay" style="display:none;">
						<td colspan="2">
							<div class="tip">
								<strong>银行对公汇款</strong>(1-2个工作日到帐)<br>
								&nbsp;&nbsp;建设银行股份有限公司孟津支行&nbsp;&nbsp;帐号: 4100 1593 1100 5020 5058&nbsp;&nbsp;户名: 洛阳夏冰软件技术有限公司<br>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<br><#--<input name="buyway" id="ensure1" type="radio" height="60" border="0" onclick="">确定
								<input  name="buyway" id="quxiao" type="radio" height="60" border="0">取消-->
							<input type="text" style="background-color: brown;height: 50px ;text-align: center;font-weight: 900;" readonly value="提交订单" height="120px" onclick="ensure1()">
							<input type="text"  style="background-color: turquoise; text-align: center;font-weight: 900;height: 50px" readonly value="取消订单" height="120px" onclick="quxiao()">
							<input type="hidden" id="cpId" value="${userCoupon.cpId}">
						</td>
					</tr>
				</table>


			</form>
			<script type="text/javascript">
				function quxiao() {
					var cpId = $('#cpId').val();
					$.ajax({
						url:'/product/quxiao-buy',
						type:"GET",
						data:{cpId:cpId},
						contentType: 'application/json;charset=UTF-8',
						dataType:"json",
						success:function (data1) {
							if(data1.errCode == 0){
									location.href="/product/list"
							}
						},
						error:function (err) {

							alert("系统异常 请联系管理员111111111")
						}
					})

				}

				function ensure1() {
				var totalPrice = $('#totalRealPrice').val();
				var smg = "确定支付"+totalPrice+"元";
					if(confirm(smg) == true){
						location.href="/product/order/info?pdId="+2 +"&num="+1
					}

				}
			</script>
			<div class="ue-index-join">
				<div class="ue-index-join-name">您对产品和服务的满意是我们工作中的唯一标准。</div>
			</div>
			<div class="ue-index-vip ue-block-box">
				<!--title-->
				<div class="ue-block-box-t">
					<div class="ue-block-box-t-i">
						<div class="ue-block-box-t-c">我们的优势</div>
						<div class="ue-block-box-t-desc">专业、安全、成熟、卓越</div>
					</div>
					<div class="ue-block-box-t-r"></div>
					<div class="clear"></div>
				</div>
				<!--title end-->
				<!--content-->
				<div class="ue-block-box-c">
					<div class="ue-index-vip-box">
						<!--list-->
						<div class="ue-index-vip-list">
							<div class="ue-index-vip-list-show">
								<div class="ue-index-vip-list-img"><img src="../softshop/images/major.png" width="40" height="40" /></div>
								<div class="ue-index-vip-list-name">专业的软件开发商</div>
								<div class="ue-index-vip-list-desc">我们是专业的安全工具软件开发商</div>
							</div>

						</div>
						<!--list end-->
						<!--list-->
						<div class="ue-index-vip-list">
							<div class="ue-index-vip-list-show">
								<div class="ue-index-vip-list-img"><img src="../softshop/images/safe.png" width="40" height="40" /></div>
								<div class="ue-index-vip-list-name">安全认证</div>
								<div class="ue-index-vip-list-desc">我们已经获得国内外多家知名安全厂商的安全认证</div>
							</div>

						</div>
						<!--list end-->
						<!--list-->
						<div class="ue-index-vip-list">
							<div class="ue-index-vip-list-show">
								<div class="ue-index-vip-list-img"><img src="../softshop/images/ripe.png" width="40" height="40" /></div>
								<div class="ue-index-vip-list-name">成熟、稳定、易用</div>
								<div class="ue-index-vip-list-desc">我们有10余年的成长历史和有上千万的用户</div>
							</div>

						</div>
						<!--list end-->
						<!--list-->
						<div class="ue-index-vip-list">
							<div class="ue-index-vip-list-show">
								<div class="ue-index-vip-list-img"><img src="../softshop/images/rem.png" width="40" height="40" /></div>
								<div class="ue-index-vip-list-name">卓越的服务和技术支持</div>
								<div class="ue-index-vip-list-desc">优质的电话、在线客服、邮件服务和专业的技术支持</div>
							</div>
						</div>
						<!--list end-->
						<div class="clear"></div>
					</div>
				</div>
				<!--content end-->
			</div>
			<DIV class="clear"></DIV>
		</div>
	</div>
</div>


<DIV class="ue-foot">
	<DIV class="ue-foot-subNav">
		<!--版权-->
		<DIV class="ue-foot-subNav-l">
			<P>Copyright © 2009 - 2014 jiamisoft.com All Rights Reversed.</P>
			<P>豫ICP备12018107号-2</P>
			<P>版权所有：洛阳夏冰软件技术有限公司</P>
		</DIV>
		<!--版权 结束-->
		<!--导航-->
		<DIV class="ue-foot-subNav-r">
			<P>服务邮箱：fuwu@jiamisoft.com</P>
			<P>客服电话：400 825 9908</P>
			<P>客服&nbsp;QQ：819500691 (查找时请选择找服务)</P>
		</DIV>
		<!--导航 结束-->
		<DIV class="clear"></DIV>
	</DIV>
</DIV>
<script charset="gb2312" language="JavaScript" src="https://css.jiamisoft.com/jiamisoft/style/green/js/checkdata.js"></script>
<script charset="gb2312" language="JavaScript" type="text/JavaScript">
	function MM_findObj(n, d) { //v4.01
		var p,i,x;

		if(!d) d=document;

		if((p=n.indexOf("?"))>0&&parent.frames.length)
		{
			d=parent.frames[n.substring(p+1)].document;
			n=n.substring(0,p);
		}

		if(!(x=d[n])&&d.all) x=d.all[n];

		for (i=0;!x&&i<d.forms.length;i++)
			x=d.forms[i][n];

		for(i=0;!x&&d.layers&&i<d.layers.length;i++)
			x=MM_findObj(n,d.layers[i].document);

		if(!x && d.getElementById)
			x=d.getElementById(n);

		return x;
	}

	function MM_showHideLayers() { //v6.0
		var i,p,v,obj,args=MM_showHideLayers.arguments;
		for (i=0; i<(args.length-2); i+=3)
			if ((obj=MM_findObj(args[i]))!=null)
			{
				v=args[i+2];
				if (obj.style)
				{
					obj=obj.style;
					v=(v=='show')?'visible':(v=='hide')?'hidden':v;
				}
				obj.visibility=v;
			}
	}

	function MM_openBrWindow(theURL,winName,features) { //v2.0
		window.open(theURL,winName,features);
	}

	function showinvoice() //--显示发票抬头
	{
		if (orderform.orinvoice.checked){
			postinfo0.style.display="";
			postinfo1.style.display="";
			postinfo2.style.display="";
			postinfo3.style.display="";
			postinfo4.style.display="";
			postinfo5.style.display="";
			postinfo6.style.display="";
			postinfo7.style.display="";
			invoice.style.display="";
		}else{
			invoice.style.display="none";
			postinfo0.style.display="none";
			postinfo1.style.display="none";
			postinfo2.style.display="none";
			postinfo3.style.display="none";
			postinfo4.style.display="none";
			postinfo5.style.display="none";
			postinfo6.style.display="none";
			postinfo7.style.display="none";
		}
	}

	//格式化函数
	function FormatNumber(srcStr,nAfterDot){
		var srcStr,nAfterDot;
		var resultStr,nTen;
		srcStr = ""+srcStr+"";
		strLen = srcStr.length;
		dotPos = srcStr.indexOf(".",0);
		if (dotPos == -1)
		{
			resultStr = srcStr+".";
			for (i=0;i<nAfterDot;i++)
			{
				resultStr = resultStr+"0";
			}
			return resultStr;
		}
		else
		{
			if ((strLen - dotPos - 1) >= nAfterDot)
			{
				nAfter = dotPos + nAfterDot + 1;
				nTen =1;
				for(j=0;j<nAfterDot;j++)
				{
					nTen = nTen*10;
				}
				resultStr = Math.round(parseFloat(srcStr)*nTen)/nTen;
				return resultStr;
			}
			else
			{
				resultStr = srcStr;
				for (i=0;i<(nAfterDot - strLen + dotPos + 1);i++)
				{
					resultStr = resultStr+"0";
				}
				return resultStr;
			}
		}
	}


	// 验证表单数据
	function VerifyData()
	{
		if (!CheckData("注册数量",orderform.orsoqty.value,"number",true)) 	// 验证注册数量,(必填项)
		{
			orderform.orsoqty.focus();
			return false;
		}

		if (orderform.orinvoice.checked)			//需要发票
		{
			if (orderform.orinvoice.checked)			//需要发票
			{
				if (orderform.orinvoicehead.value == "")
				{alert ("请填写发票抬头。");orderform.orinvoicehead.focus();return false;}
			}

			if (!CheckData("真实姓名",orderform.username.value,"pname",true)) 	// 验证真实姓名,(必填项)
			{	orderform.username.focus();return false;}

			if (orderform.usertel.value == "")
			{alert ("请填写您的联系电话。");orderform.usertel.focus();return false;}   //验证联系电话

			if (orderform.address.value == "")
			{alert ("请填写您的联系地址。");orderform.address.focus();return false;}   //联系地址

			if (!CheckData("邮政编码",orderform.post.value,"postcode",true))		// 验证邮政编码
			{	orderform.post.focus();return false;}


			if (orderform.province.value === "省份")
			{ alert("请选择省份。"); return false; }

			if (orderform.city.value === "地级市")
			{alert("请选择地级市。");return false;}
		}

		return true;
	}

	function orderinit() //--修改订单初始化
	{
		showpaymode(1);
		orderform.useremail.focus();
	}

	function showpaymode(paymode) //--显示支付方式
	{
		bankpay.style.display="none";
		alipay.style.display="none";
		netpay.style.display="none";
		saomapay.style.display="none";
		switch (paymode) {
			case 2: //--网银
				netpay.style.display="";
				break;
			case 1://--支付宝
				alipay.style.display="";
				break;
			case 3: //--显示银行支付
				bankpay.style.display="";
				break;
			case 4: //--显示银行支付
				saomapay.style.display="";
				break;

		}
	}

	function change_payment()
	{
		switch(document.orderform.soft_id.value)
		{
			case "BFE0001":   document.orderform.total_fee.value = 188.00;break;case "UE00002":   document.orderform.total_fee.value = 98.00;break;case "MTS0003":   document.orderform.total_fee.value = 158.00;break;case "BSE0004":   document.orderform.total_fee.value = 168.00;break;case "ASF0006":   document.orderform.total_fee.value = 98.00;break;case "BDL0007":   document.orderform.total_fee.value = 98.00;break;case "EFG0008":   document.orderform.total_fee.value = 98.00;break;case "CFR0009":   document.orderform.total_fee.value = 98.00;break;case "ASD0010":   document.orderform.total_fee.value = 98.00;break;case "OTH0011":   document.orderform.total_fee.value = 15.00;break;case "SFE0012":   document.orderform.total_fee.value = 898.00;break;case "MCE0012":   document.orderform.total_fee.value = 1598.00;break;case "FRE0015":   document.orderform.total_fee.value = 688.00;break;case "MTS0013":   document.orderform.total_fee.value = 98.00;break;case "MTS0023":   document.orderform.total_fee.value = 50.00;break;	}
	}
</script>
<script type="text/javascript" src="https://css.jiamisoft.com/jiamisoft/style/green/js/area.js"></script>
<script type="text/javascript">
	_init_area();
</script>
</body>

</html>