<%@ page contentType="text/html;charset=UTF-8" %>
<link href="../staticsource/css/popup.css" rel="stylesheet" type="text/css" />
<script>
$(function() {
		$("#provinceText").click(function(e) {
			/*$("#provinceText").val("");
			$("#provinceCode").val("");
			$("#province").val("");
			$("#city").val("");
			$("#cityCode").val("");*/
			e.stopPropagation();
			showCity();
		});
	});

	var $last_panel = 1;
	function showCity() {
		// $("#popContainer").animate({top: '+50px'}, "fast"); 
		$("#popContainer").css({"display": "block"});

	}
	function hideCity() {
		$("#popContainer").css("display", "none");
	}

	function showTab(obj, index) {

		$("#tab" + $last_panel).toggleClass("active");
		$(obj).toggleClass("active");
		$("#TG_PANEL_" + $last_panel).css('display', 'none');
		$("#TG_PANEL_" + index).css('display', 'block');
		$last_panel = index;
	}
	function setCityName(obj) {

		var $province = $(obj).attr("pname");
		var $city = $(obj).attr("name");
		$("#province").val($province);
		$("#provinceText").val($province + $city);
		$("#provinceCode").val($(obj).attr("pcode"));
		$("#city").val($city);
		$("#cityCode").val($(obj).attr("citycode"));
		$("#popContainer").css("display", "none");
		/*Blurprovince();*/
	}
	
	function getCityNameByCityCode(cityCode) {
		if (cityCode==null ||cityCode=="")
			return;
		var obj= $('li[citycode="'+cityCode +'"]');
		if (obj && obj.length==0)
		{
			 obj= $('li[pcode="'+cityCode +'"]');
		}	
		if (obj==null)	
			return;
		setCityName(obj);
	
	}
	
	function getCityNameByCityCodeNew(cityCode) {
		if (cityCode==null ||cityCode=="")
			return;
		var obj= $('li[citycode="'+cityCode +'"]');
		if (obj && obj.length==0)
		{
			 obj= $('li[pcode="'+cityCode +'"]');
		}
		
		if (obj==null)
			return;
		
		var $province = $(obj).attr("pname");
		var $city = $(obj).attr("name");

        return ($province + $city);
	}
</script>
<div class="qcbox qcity" style="display: none;text-indent:0px" id="popContainer">
		<div class="popContainer">
			<div class="popPanel">
				<div class="cityinput" hotcitytype="1">
					<div class="hint">
						<span id="closeXI1" class="closeImg" onclick="hideCity()"></span>
						<span id="titleXI1">选择城市</span> <span>(<span id="descXI1"
							class="CIunderline">请点击省份并选取城市</span>)
						</span>
						<hr>
						<div class="hotCityNav">
								<span id="tab1" key="Hot" class="active" title="" 
									onclick="showTab(this,1)">热门</span>
								<span id="tab2" key="A-G" title="广东"  
									onclick="showTab(this,2)">广东</span>
								<span id="tab3" key="A-G" title="山东"  
									onclick="showTab(this,3)">山东</span>
								<span id="tab4" key="H-L" title="河南"  
									onclick="showTab(this,4)">河南</span>	
								<span id="tab5" key="H-L" title="山西"  
									onclick="showTab(this,5)">山西</span>
								<span id="tab6" key="M-T" title="湖北"  
									onclick="showTab(this,6)">湖北</span>
								<span id="tab7" key="M-T" title="湖南"  
									onclick="showTab(this,7)">湖南</span>
								<span id="tab8" key="W-Z" title="河北"  
									onclick="showTab(this,8)">河北</span>
								<span id="tab9" key="W-Z" title="广西"  
									onclick="showTab(this,9)">广西</span>
								<span id="tab10" key="W-Z" title="浙江"  
									onclick="showTab(this,10)">浙江</span>
								<span id="tab11" key="W-Z" title="甘肃"  
									onclick="showTab(this,11)">甘肃</span>								
								<span id="tab12" key="W-Z" title="宁夏"  
									onclick="showTab(this,12)">宁夏</span>
								<span id="tab13" key="W-Z" title="青海"  
									onclick="showTab(this,13)">青海</span>
								<span id="tab14" key="W-Z" title="新疆"  
									onclick="showTab(this,14)">新疆</span>
								<span id="tab15" key="W-Z" title="辽宁"  
									onclick="showTab(this,15)">辽宁</span>
								<span id="tab16" key="W-Z" title="吉林"  
									onclick="showTab(this,16)">吉林</span>
								<span id="tab17" key="W-Z" title="陕西"  
									onclick="showTab(this,17)">陕西</span>								
								<span id="tab18" key="W-Z" title="福建"  
									onclick="showTab(this,18)">福建</span>
								<span id="tab19" key="W-Z" title="福建"  
									onclick="showTab(this,19)">海南</span>
								<span id="tab20" key="W-Z" title="江苏"  
									onclick="showTab(this,20)">江苏</span>
								<span id="tab21" key="W-Z" title="江西"  
									onclick="showTab(this,21)">江西</span>
								<span id="tab22" key="W-Z" title="云南"  
									onclick="showTab(this,22)">云南</span>
								<span id="tab23" key="W-Z" title="贵州"  
									onclick="showTab(this,23)">贵州</span>
								<span id="tab24" key="W-Z" title="四川"  
									onclick="showTab(this,24)">四川</span>
								<span id="tab25" key="W-Z" title="西藏"  
									onclick="showTab(this,25)">西藏</span>								
								<span id="tab26" key="W-Z" title="内蒙"  
									onclick="showTab(this,26)">内蒙</span>
								<span id="tab28" key="W-Z" title="安徽"  
									onclick="showTab(this,28)">安徽</span>
								<span id="tab27" key="W-Z" title="黑龙江"  
									onclick="showTab(this,27)">黑龙江</span>
								<span id="tab29" key="W-Z" title="其他"  
									onclick="showTab(this,99)">其他</span>	
							<div class="clear"></div>
						</div>
						<div id="__flightcitybox_1">
							<div id="TG_PANEL_1" style="display: block;">
								<ul>
									<li pname="" name="北京市" pcode="110000" citycode="110101" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 北京</a></li>
									<li pname="" name="上海市" pcode="310000" citycode="310101" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 上海</a></li>
									<li pname="" name="天津市" pcode="120000" citycode="120101" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 天津</a></li>
									<li pname="" name="重庆市" pcode="500000" citycode="500101" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 重庆</a></li>
								</ul>
							</div>
							<div id="TG_PANEL_2" style="display: none;">
								<ul>
									<li pname="广东省" name="广州市" pcode="440000" citycode="440100"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">G</span> 广州</a></li>
									<li pname="广东省" name="韶关市" pcode="440000" citycode="440200"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 韶关</a></li>
									<li pname="广东省" name="珠海市" pcode="440000" citycode="440400"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 珠海</a></li>
									<li pname="广东省" name="佛山市" pcode="440000" citycode="440600"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">F</span> 佛山</a></li>
									<li pname="广东省" name="江门市" pcode="440000" citycode="440700"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 江门</a></li>
									<li pname="广东省" name="肇庆市" pcode="440000" citycode="441200"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 肇庆</a></li>
									<li pname="广东省" name="惠州市" pcode="440000" citycode="441300"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 惠州</a></li>
									<li pname="广东省" name="汕尾市" pcode="440000" citycode="441500"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 汕尾</a></li>
									<li pname="广东省" name="河源市" pcode="440000" citycode="441600"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 河源</a></li>
									<li pname="广东省" name="清远市" pcode="440000" citycode="441800"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Q</span> 清远</a></li>
									<li pname="广东省" name="东莞市" pcode="440000" citycode="441900"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">D</span> 东莞</a></li>
									<li pname="广东省" name="中山市" pcode="440000" citycode="442000"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 中山</a></li>
									<li pname="广东省" name="潮州市" pcode="440000" citycode="445100"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 潮州</a></li>
									<li pname="广东省" name="云浮市" pcode="440000" citycode="445300"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 云浮</a></li>
									<li pname="广东省" name="深圳市" pcode="440000" citycode="440300"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 深圳</a></li>
									<li pname="广东省" name="梅州市" pcode="440000" citycode="441400"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">M</span> 梅州</a></li>
									<li pname="广东省" name="汕头市" pcode="440000" citycode="440500"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 汕头</a></li>
									<li pname="广东省" name="阳江市" pcode="440000" citycode="441700"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 阳江</a></li>
									<li pname="广东省" name="揭阳市" pcode="440000" citycode="445200"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 揭阳</a></li>
									<li pname="广东省" name="湛江市" pcode="440000" citycode="440800"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 湛江</a></li>
									<li pname="广东省" name="茂名市" pcode="440000" citycode="440900"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">M</span> 茂名</a></li>
								</ul>
							</div>
							<div id="TG_PANEL_3" style="display: none;">
								<ul>
								<li pname="山东省" name="聊城市" pcode="370000" citycode="371500"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 聊城</a></li>
								<li pname="山东省" name="菏泽市" pcode="370000" citycode="371700"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 菏泽</a></li>
								<li pname="山东省" name="济南市" pcode="370000" citycode="370100"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 济南</a></li>
								<li pname="山东省" name="青岛市" pcode="370000" citycode="370200"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Q</span> 青岛</a></li>
								<li pname="山东省" name="淄博市" pcode="370000" citycode="370300"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 淄博</a></li>
								<li pname="山东省" name="枣庄市" pcode="370000" citycode="370400"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 枣庄</a></li>
								<li pname="山东省" name="东营市" pcode="370000" citycode="370500"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">D</span> 东营</a></li>
								<li pname="山东省" name="潍坊市" pcode="370000" citycode="370700"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">W</span> 潍坊</a></li>
								<li pname="山东省" name="济宁市" pcode="370000" citycode="370800"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 济宁</a></li>
								<li pname="山东省" name="泰安市" pcode="370000" citycode="370900"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 泰安</a></li>
								<li pname="山东省" name="威海市" pcode="370000" citycode="371000"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">W</span> 威海</a></li>
								<li pname="山东省" name="日照市" pcode="370000" citycode="371100"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">R</span> 日照</a></li>
								<li pname="山东省" name="临沂市" pcode="370000" citycode="371300"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 临沂</a></li>
								<li pname="山东省" name="德州市" pcode="370000" citycode="371400"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">D</span> 德州</a></li>
								<li pname="山东省" name="滨州市" pcode="370000" citycode="371600"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 滨州</a></li>
								<li pname="山东省" name="烟台市" pcode="370000" citycode="370600"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 烟台</a></li>
								<li pname="山东省" name="莱芜市" pcode="370000" citycode="371200"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 莱芜</a></li>																
								</ul>
							</div>
							<div id="TG_PANEL_4" style="display: none;">
								<ul>
									<li pname="河南省" name="洛阳市" pcode="410000" citycode="410300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 洛阳</a></li>
									<li pname="河南省" name="平顶山市" pcode="410000" citycode="410400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">P</span> 平顶山</a></li>
									<li pname="河南省" name="鹤壁市" pcode="410000" citycode="410600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 鹤壁</a></li>
									<li pname="河南省" name="新乡市" pcode="410000" citycode="410700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 新乡</a></li>
									<li pname="河南省" name="焦作市" pcode="410000" citycode="410800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 焦作</a></li>
									<li pname="河南省" name="濮阳市" pcode="410000" citycode="410900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">P</span> 濮阳</a></li>
									<li pname="河南省" name="漯河市" pcode="410000" citycode="411100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 漯河</a></li>
									<li pname="河南省" name="南阳市" pcode="410000" citycode="411300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">N</span> 南阳</a></li>
									<li pname="河南省" name="周口市" pcode="410000" citycode="411600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 周口</a></li>
									<li pname="河南省" name="驻马店市" pcode="410000" citycode="411700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 驻马店</a></li>
									<li pname="河南省" name="郑州市" pcode="410000" citycode="410100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 郑州</a></li>
									<li pname="河南省" name="许昌市" pcode="410000" citycode="411000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 许昌</a></li>
									<li pname="河南省" name="开封市" pcode="410000" citycode="410200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">K</span> 开封</a></li>
									<li pname="河南省" name="安阳市" pcode="410000" citycode="410500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">A</span> 安阳</a></li>
									<li pname="河南省" name="三门峡市" pcode="410000" citycode="411200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 三门峡</a></li>
									<li pname="河南省" name="商丘市" pcode="410000" citycode="411400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 商丘</a></li>
									<li pname="河南省" name="信阳市" pcode="410000" citycode="411500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 信阳</a></li>																														
								</ul>
							</div>
							<div id="TG_PANEL_5" style="display: none;">
								<ul>
								<li pname="山西省" name="太原市" pcode="140000" citycode="140100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 太原</a></li>
								<li pname="山西省" name="大同市" pcode="140000" citycode="140200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">D</span> 大同</a></li>
								<li pname="山西省" name="朔州市" pcode="140000" citycode="140600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 朔州</a></li>
								<li pname="山西省" name="晋中市" pcode="140000" citycode="140700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 晋中</a></li>
								<li pname="山西省" name="运城市" pcode="140000" citycode="140800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 运城</a></li>
								<li pname="山西省" name="临汾市" pcode="140000" citycode="141000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 临汾</a></li>
								<li pname="山西省" name="吕梁市" pcode="140000" citycode="141100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 吕梁</a></li>
								<li pname="山西省" name="晋城市" pcode="140000" citycode="140500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 晋城</a></li>
								<li pname="山西省" name="阳泉市" pcode="140000" citycode="140300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 阳泉</a></li>
								<li pname="山西省" name="长治市" pcode="140000" citycode="140400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 长治</a></li>
								<li pname="山西省" name="忻州市" pcode="140000" citycode="140900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 忻州</a></li>
								</ul>
							</div>							
							<div id="TG_PANEL_6" style="display: none;">
								<ul>
									<li pname="湖北省" name="武汉市" pcode="420000" citycode="420100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">W</span> 武汉</a></li>
									<li pname="湖北省" name="十堰市" pcode="420000" citycode="420300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 十堰</a></li>
									<li pname="湖北省" name="宜昌市" pcode="420000" citycode="420500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 宜昌</a></li>
									<li pname="湖北省" name="襄阳市" pcode="420000" citycode="420600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 襄阳</a></li>
									<li pname="湖北省" name="荆门市" pcode="420000" citycode="420800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 荆门</a></li>
									<li pname="湖北省" name="孝感市" pcode="420000" citycode="420900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 孝感</a></li>
									<li pname="湖北省" name="荆州市" pcode="420000" citycode="421000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 荆州</a></li>
									<li pname="湖北省" name="黄冈市" pcode="420000" citycode="421100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 黄冈</a></li>
									<li pname="湖北省" name="随州市" pcode="420000" citycode="421300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 随州</a></li>
									<li pname="湖北省" name="恩施土家族苗族自治州" pcode="420000" citycode="422800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 恩施</a></li>
									<li pname="湖北省" name="天门市" pcode="420000" citycode="429006" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 天门</a></li>
									<li pname="湖北省" name="仙桃市" pcode="420000" citycode="429004" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 仙桃</a></li>
									<li pname="湖北省" name="潜江市" pcode="420000" citycode="429005" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Q</span> 潜江</a></li>
									<li pname="湖北省" name="黄石市" pcode="420000" citycode="420200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 黄石</a></li>
									<li pname="湖北省" name="鄂州市" pcode="420000" citycode="420700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">E</span> 鄂州</a></li>
									<li pname="湖北省" name="咸宁市" pcode="420000" citycode="421200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 咸宁</a></li>
									<li pname="湖北省" name="神农架林区" pcode="420000" citycode="429021" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 神农架</a></li>																														
								</ul>
							</div>
							<div id="TG_PANEL_7" style="display: none;">
								<ul>
									<li pname="湖南省" name="怀化市" pcode="430000" citycode="431200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 怀化</a></li>
									<li pname="湖南省" name="娄底市" pcode="430000" citycode="431300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 娄底</a></li>
									<li pname="湖南省" name="湘西土家族苗族自治州" pcode="430000" citycode="433100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 湘西</a></li>
									<li pname="湖南省" name="长沙市" pcode="430000" citycode="430100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 长沙</a></li>
									<li pname="湖南省" name="株洲市" pcode="430000" citycode="430200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 株洲</a></li>
									<li pname="湖南省" name="湘潭市" pcode="430000" citycode="430300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 湘潭</a></li>
									<li pname="湖南省" name="邵阳市" pcode="430000" citycode="430500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 邵阳</a></li>
									<li pname="湖南省" name="常德市" pcode="430000" citycode="430700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 常德</a></li>
									<li pname="湖南省" name="张家界市" pcode="430000" citycode="430800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 张家界</a></li>
									<li pname="湖南省" name="益阳市" pcode="430000" citycode="430900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 益阳</a></li>
									<li pname="湖南省" name="永州市" pcode="430000" citycode="431100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 永州</a></li>
									<li pname="湖南省" name="郴州市" pcode="430000" citycode="431000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 郴州</a></li>
									<li pname="湖南省" name="衡阳市" pcode="430000" citycode="430400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 衡阳</a></li>
									<li pname="湖南省" name="岳阳市" pcode="430000" citycode="430600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 岳阳</a></li>																															
								</ul>
							</div>
							<div id="TG_PANEL_8" style="display: none;">
								<ul>
									<li pname="河北省" name="张家口市" pcode="130000" citycode="130700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 张家口</a></li>
									<li pname="河北省" name="承德市" pcode="130000" citycode="130800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 承德</a></li>
									<li pname="河北省" name="廊坊市" pcode="130000" citycode="131000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 廊坊</a></li>
									<li pname="河北省" name="衡水市" pcode="130000" citycode="131100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 衡水</a></li>
									<li pname="河北省" name="石家庄市" pcode="130000" citycode="130100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 石家庄</a></li>
									<li pname="河北省" name="唐山市" pcode="130000" citycode="130200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 唐山</a></li>
									<li pname="河北省" name="秦皇岛市" pcode="130000" citycode="130300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Q</span> 秦皇岛</a></li>
									<li pname="河北省" name="邯郸市" pcode="130000" citycode="130400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 邯郸</a></li>
									<li pname="河北省" name="邢台市" pcode="130000" citycode="130500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 邢台</a></li>
									<li pname="河北省" name="保定市" pcode="130000" citycode="130600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 保定</a></li>
									<li pname="河北省" name="沧州市" pcode="130000" citycode="130900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 沧州</a></li>																											
								</ul>
							</div>
							<div id="TG_PANEL_9" style="display: none;">
								<ul>
									<li pname="广西壮族自治区" name="崇左市" pcode="450000" citycode="451400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 崇左</a></li>
									<li pname="广西壮族自治区" name="南宁市" pcode="450000" citycode="450100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">N</span> 南宁</a></li>
									<li pname="广西壮族自治区" name="桂林市" pcode="450000" citycode="450300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">G</span> 桂林</a></li>
									<li pname="广西壮族自治区" name="北海市" pcode="450000" citycode="450500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 北海</a></li>
									<li pname="广西壮族自治区" name="钦州市" pcode="450000" citycode="450700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Q</span> 钦州</a></li>
									<li pname="广西壮族自治区" name="贵港市" pcode="450000" citycode="450800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">G</span> 贵港</a></li>
									<li pname="广西壮族自治区" name="百色市" pcode="450000" citycode="451000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 百色</a></li>
									<li pname="广西壮族自治区" name="贺州市" pcode="450000" citycode="451100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 贺州</a></li>
									<li pname="广西壮族自治区" name="来宾市" pcode="450000" citycode="451300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 来宾</a></li>
									<li pname="广西壮族自治区" name="柳州市" pcode="450000" citycode="450200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 柳州</a></li>
									<li pname="广西壮族自治区" name="防城港市" pcode="450000" citycode="45060" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">F</span> 防城港</a></li>
									<li pname="广西壮族自治区" name="玉林市" pcode="450000" citycode="450900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 玉林</a></li>
									<li pname="广西壮族自治区" name="梧州市" pcode="450000" citycode="450400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">W</span> 梧州</a></li>
									<li pname="广西壮族自治区" name="河池市" pcode="450000" citycode="451200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 河池</a></li>																													
								</ul>
							</div>
							<div id="TG_PANEL_10" style="display: none;">
								<ul>
									<li pname="浙江省" name="宁波市" pcode="330000" citycode="330200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">N</span> 宁波</a></li>
									<li pname="浙江省" name="温州市" pcode="330000" citycode="330300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">W</span> 温州</a></li>
									<li pname="浙江省" name="嘉兴市" pcode="330000" citycode="330400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 嘉兴</a></li>
									<li pname="浙江省" name="湖州市" pcode="330000" citycode="330500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 湖州</a></li>
									<li pname="浙江省" name="绍兴市" pcode="330000" citycode="330600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 绍兴</a></li>
									<li pname="浙江省" name="衢州市" pcode="330000" citycode="330800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Q</span> 衢州</a></li>
									<li pname="浙江省" name="舟山市" pcode="330000" citycode="330900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 舟山</a></li>
									<li pname="浙江省" name="丽水市" pcode="330000" citycode="331100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 丽水</a></li>
									<li pname="浙江省" name="台州市" pcode="330000" citycode="331000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 台州</a></li>
									<li pname="浙江省" name="杭州市" pcode="330000" citycode="330100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 杭州</a></li>
									<li pname="浙江省" name="金华市" pcode="330000" citycode="330700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 金华</a></li>																																												
								</ul>
							</div>
							<div id="TG_PANEL_11" style="display: none;">
								<ul>
									<li pname="甘肃省" name="嘉峪关市" pcode="620000" citycode="620200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 嘉峪关</a></li>
									<li pname="甘肃省" name="金昌市" pcode="620000" citycode="620300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 金昌</a></li>
									<li pname="甘肃省" name="白银市" pcode="620000" citycode="620400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 白银</a></li>
									<li pname="甘肃省" name="武威市" pcode="620000" citycode="620600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">W</span> 武威</a></li>
									<li pname="甘肃省" name="张掖市" pcode="620000" citycode="620700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 张掖</a></li>
									<li pname="甘肃省" name="酒泉市" pcode="620000" citycode="620900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 酒泉</a></li>
									<li pname="甘肃省" name="庆阳市" pcode="620000" citycode="621000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Q</span> 庆阳</a></li>
									<li pname="甘肃省" name="定西市" pcode="620000" citycode="621100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">D</span> 定西</a></li>
									<li pname="甘肃省" name="陇南市" pcode="620000" citycode="621200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 陇南</a></li>
									<li pname="甘肃省" name="临夏回族自治州" pcode="620000" citycode="622900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 临夏回族</a></li>
									<li pname="甘肃省" name="甘南藏族自治州" pcode="620000" citycode="623000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">G</span> 甘南藏族</a></li>
									<li pname="甘肃省" name="兰州市" pcode="620000" citycode="620100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 兰州</a></li>
									<li pname="甘肃省" name="平凉市" pcode="620000" citycode="620800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">P</span> 平凉</a></li>
									<li pname="甘肃省" name="天水市" pcode="620000" citycode="620500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 天水</a></li>																																					
								</ul>
							</div>
							<div id="TG_PANEL_12" style="display: none;">
								<ul>
									<li pname="宁夏回族自治区" name="银川市" pcode="640000" citycode="640100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 银川</a></li>
									<li pname="宁夏回族自治区" name="吴忠市" pcode="640000" citycode="640300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">W</span> 吴忠</a></li>
									<li pname="宁夏回族自治区" name="固原市" pcode="640000" citycode="640400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">G</span> 固原</a></li>
									<li pname="宁夏回族自治区" name="中卫市" pcode="640000" citycode="640500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 中卫</a></li>
									<li pname="宁夏回族自治区" name="石嘴山市" pcode="640000" citycode="640200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 石嘴山</a></li>																									
								</ul>
							</div>
							<div id="TG_PANEL_13" style="display: none;">
								<ul>
									<li pname="青海省" name="西宁市" pcode="630000" citycode="630100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 西宁</a></li>
									<li pname="青海省" name="海东地区" pcode="630000" citycode="632100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 海东地区</a></li>
									<li pname="青海省" name="海北藏族自治州" pcode="630000" citycode="632200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 海北藏族</a></li>
									<li pname="青海省" name="黄南藏族自治州" pcode="630000" citycode="632300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 黄南藏族</a></li>
									<li pname="青海省" name="海南藏族自治州" pcode="630000" citycode="632500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 海南藏族</a></li>
									<li pname="青海省" name="果洛藏族自治州" pcode="630000" citycode="632600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">G</span> 果洛藏族</a></li>
									<li pname="青海省" name="玉树藏族自治州" pcode="630000" citycode="632700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 玉树藏族</a></li>
									<li pname="青海省" name="海西蒙古族藏族自治州" pcode="630000" citycode="632800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 海西蒙古族藏族</a></li>																				
								</ul>
							</div>
							<div id="TG_PANEL_14" style="display: none;">
								<ul>
									<li pname="新疆维吾尔自治区" name="乌鲁木齐市" pcode="650000" citycode="650100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">W</span> 乌鲁木齐</a></li>
									<li pname="新疆维吾尔自治区" name="哈密地区" pcode="650000"citycode="652200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 哈密</a></li>
									<li pname="新疆维吾尔自治区" name="巴音郭楞蒙古自治州" pcode="650000"citycode="652800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 巴音郭楞</a></li>
									<li pname="新疆维吾尔自治区" name="阿克苏地区" pcode="650000"citycode="652900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">A</span> 阿克苏</a></li>
									<li pname="新疆维吾尔自治区" name="克孜勒苏柯尔克孜自治州" pcode="650000"citycode="653000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">K</span> 克孜勒</a></li>
									<li pname="新疆维吾尔自治区" name="阿勒泰地区" pcode="650000"citycode="654300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">A</span> 阿勒泰</a></li>
									<li pname="新疆维吾尔自治区" name="图木舒克市" pcode="650000"citycode="659003" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 图木舒克</a></li>
									<li pname="新疆维吾尔自治区" name="克拉玛依市" pcode="650000"citycode="650200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">K</span> 克拉玛依</a></li>
									<li pname="新疆维吾尔自治区" name="吐鲁番地区" pcode="650000"citycode="652100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 吐鲁番</a></li>
									<li pname="新疆维吾尔自治区" name="昌吉回族自治州" pcode="650000"citycode="652300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 昌吉</a></li>
									<li pname="新疆维吾尔自治区" name="博尔塔拉蒙古自治州" pcode="650000"citycode="652700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 博尔塔拉</a></li>
									<li pname="新疆维吾尔自治区" name="和田地区" pcode="650000"citycode="653200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 和田</a></li>
									<li pname="新疆维吾尔自治区" name="五家渠市" pcode="650000"citycode="659004" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">W</span> 五家渠</a></li>
									<li pname="新疆维吾尔自治区" name="喀什地区" pcode="650000"citycode="653100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">K</span> 喀什</a></li>
									<li pname="新疆维吾尔自治区" name="伊犁哈萨克自治州" pcode="650000"citycode="654000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 伊犁</a></li>
									<li pname="新疆维吾尔自治区" name="石河子市" pcode="650000"citycode="659001" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 石河子</a></li>
									<li pname="新疆维吾尔自治区" name="塔城地区" pcode="650000"citycode="654200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 塔城</a></li>
									<li pname="新疆维吾尔自治区" name="阿拉尔市" pcode="650000"citycode="659002" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">A</span> 阿拉尔</a></li>																			
								</ul>
							</div>
							<div id="TG_PANEL_15" style="display: none;">
								<ul>
									<li pname="辽宁省" name="沈阳市" pcode="210000" citycode="210100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 沈阳市</a></li>
									<li pname="辽宁省" name="大连市" pcode="210000" citycode="210200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">D</span> 大连市</a></li>
									<li pname="辽宁省" name="抚顺市" pcode="210000" citycode="210400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">F</span> 抚顺市</a></li>
									<li pname="辽宁省" name="本溪市" pcode="210000" citycode="210500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 本溪市</a></li>
									<li pname="辽宁省" name="丹东市" pcode="210000" citycode="210600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">D</span> 丹东市</a></li>
									<li pname="辽宁省" name="锦州市" pcode="210000" citycode="210700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 锦州市</a></li>
									<li pname="辽宁省" name="营口市" pcode="210000" citycode="210800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 营口市</a></li>
									<li pname="辽宁省" name="辽阳市" pcode="210000" citycode="211000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 辽阳市</a></li>
									<li pname="辽宁省" name="盘锦市" pcode="210000" citycode="211100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">P</span> 盘锦市</a></li>
									<li pname="辽宁省" name="铁岭市" pcode="210000" citycode="211200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 铁岭市</a></li>
									<li pname="辽宁省" name="葫芦岛市" pcode="210000" citycode="211400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 葫芦岛市</a></li>
									<li pname="辽宁省" name="鞍山市" pcode="210000" citycode="210300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">A</span> 鞍山市</a></li>
									<li pname="辽宁省" name="阜新市" pcode="210000" citycode="210900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">F</span> 阜新市</a></li>
									<li pname="辽宁省" name="朝阳市" pcode="210000" citycode="211300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 朝阳市</a></li>																									
								</ul>
							</div>
							<div id="TG_PANEL_16" style="display: none;">
								<ul>
									<li pname="吉林省" name="吉林市" pcode="220000" citycode="220200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 吉林</a></li>
									<li pname="吉林省" name="四平市" pcode="220000"citycode="220300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 四平</a></li>
									<li pname="吉林省" name="辽源市" pcode="220000"citycode="220400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 辽源</a></li>
									<li pname="吉林省" name="通化市" pcode="220000"citycode="220500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 通化</a></li>
									<li pname="吉林省" name="白山市" pcode="220000"citycode="220600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 白山</a></li>
									<li pname="吉林省" name="白城市" pcode="220000"citycode="220800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 白城</a></li>
									<li pname="吉林省" name="延边朝鲜族自治州" pcode="220000"citycode="222400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 延边</a></li>
									<li pname="吉林省" name="松原市" pcode="220000"citycode="220700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 松原</a></li>
									<li pname="吉林省" name="长春市" pcode="220000"citycode="220100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 长春</a></li>																															
								</ul>
							</div>
							<div id="TG_PANEL_17" style="display: none;">
								<ul>
									<li pname="陕西省" name="西安市" pcode="610000" citycode="610100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 西安</a></li>
									<li pname="陕西省" name="宝鸡市" pcode="610000" citycode="610300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 宝鸡</a></li>
									<li pname="陕西省" name="咸阳市" pcode="610000" citycode="610400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 咸阳</a></li>
									<li pname="陕西省" name="渭南市" pcode="610000" citycode="610500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">W</span> 渭南</a></li>
									<li pname="陕西省" name="汉中市" pcode="610000" citycode="610700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 汉中</a></li>
									<li pname="陕西省" name="榆林市" pcode="610000" citycode="610800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 榆林</a></li>
									<li pname="陕西省" name="铜川市" pcode="610000" citycode="610200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 铜川</a></li>
									<li pname="陕西省" name="延安市" pcode="610000" citycode="610600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 延安</a></li>
									<li pname="陕西省" name="安康市" pcode="610000" citycode="610900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">A</span> 安康</a></li>
									<li pname="陕西省" name="商洛市" pcode="610000" citycode="611000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 商洛</a></li>																																																				
								</ul>
							</div>
							<div id="TG_PANEL_18" style="display: none;">
								<ul>
									<li pname="福建省" name="厦门市" pcode="350000" citycode="350200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 厦门</a></li>
									<li pname="福建省" name="莆田市" pcode="350000" citycode="350300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">P</span> 莆田</a></li>
									<li pname="福建省" name="三明市" pcode="350000" citycode="350400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 三明</a></li>
									<li pname="福建省" name="泉州市" pcode="350000" citycode="350500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Q</span> 泉州</a></li>
									<li pname="福建省" name="漳州市" pcode="350000" citycode="350600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 漳州</a></li>
									<li pname="福建省" name="宁德市" pcode="350000" citycode="350900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">N</span> 宁德</a></li>
									<li pname="福建省" name="龙岩市" pcode="350000" citycode="350800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 龙岩</a></li>
									<li pname="福建省" name="福州市" pcode="350000" citycode="350100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">F</span> 福州</a></li>
									<li pname="福建省" name="南平市" pcode="350000" citycode="350700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">N</span> 南平</a></li>
								</ul>
							</div>
							<div id="TG_PANEL_19" style="display: none;">
								<ul>
									<li pname="海南省" name="海口市" pcode="460000" citycode="460100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 海口</a></li>
									<li pname="海南省" name="三亚市" pcode="460000" citycode="460200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 三亚</a></li>
									<li pname="海南省" name="三沙市" pcode="460000" citycode="460300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 三沙</a></li>
									<li pname="海南省" name="省直辖县级行政单位" pcode="460000" citycode="469000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 省直辖县级行政</a></li>
																		
								</ul>
							</div>
							<div id="TG_PANEL_20" style="display: none;">
								<ul>
									<li pname="江苏省" name="南京市" pcode="320000" citycode="320100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">N</span> 南京</a></li>
									<li pname="江苏省" name="无锡市" pcode="320000" citycode="320200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">W</span> 无锡</a></li>
									<li pname="江苏省" name="徐州市" pcode="320000" citycode="320300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 徐州</a></li>
									<li pname="江苏省" name="常州市" pcode="320000" citycode="320400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 常州</a></li>
									<li pname="江苏省" name="连云港市" pcode="320000" citycode="320700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 连云港</a></li>
									<li pname="江苏省" name="淮安市" pcode="320000" citycode="320800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 淮安</a></li>
									<li pname="江苏省" name="盐城市" pcode="320000" citycode="320900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 盐城</a></li>
									<li pname="江苏省" name="扬州市" pcode="320000" citycode="321000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 扬州</a></li>
									<li pname="江苏省" name="泰州市" pcode="320000" citycode="321200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 泰州</a></li>
									<li pname="江苏省" name="南通市" pcode="320000" citycode="320600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">N</span> 南通</a></li>
									<li pname="江苏省" name="镇江市" pcode="320000" citycode="321100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 镇江</a></li>
									<li pname="江苏省" name="苏州市" pcode="320000" citycode="320500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 苏州</a></li>
									<li pname="江苏省" name="宿迁市" pcode="320000" citycode="321300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 宿迁</a></li>
								</ul>
							</div>							
							<div id="TG_PANEL_21" style="display: none;">
								<ul>
									<li pname="江西省" name="景德镇市" pcode="360000" citycode="360200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 景德镇</a></li>
									<li pname="江西省" name="萍乡市" pcode="360000" citycode="360300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">P</span> 萍乡</a></li>
									<li pname="江西省" name="九江市" pcode="360000" citycode="360400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 九江</a></li>
									<li pname="江西省" name="上饶市" pcode="360000" citycode="361100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 上饶</a></li>
									<li pname="江西省" name="新余市" pcode="360000" citycode="360500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 新余</a></li>
									<li pname="江西省" name="鹰潭市" pcode="360000" citycode="360600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 鹰潭</a></li>
									<li pname="江西省" name="吉安市" pcode="360000" citycode="360800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 吉安</a></li>
									<li pname="江西省" name="宜春市" pcode="360000" citycode="360900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 宜春</a></li>
									<li pname="江西省" name="抚州市" pcode="360000" citycode="361000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">F</span> 抚州</a></li>
									<li pname="江西省" name="南昌市" pcode="360000" citycode="360100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">N</span> 南昌</a></li>
									<li pname="江西省" name="赣州市" pcode="360000" citycode="360700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">G</span> 赣州</a></li>																																					
								</ul>
							</div>
							<div id="TG_PANEL_22" style="display: none;">
								<ul>
									<li pname="云南省" name="保山市" pcode="530000" citycode="530500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 保山</a></li>
									<li pname="云南省" name="昭通市" pcode="530000" citycode="530600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 昭通</a></li>
									<li pname="云南省" name="丽江市" pcode="530000" citycode="530700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 丽江</a></li>
									<li pname="云南省" name="思茅市" pcode="530000" citycode="530800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 思茅</a></li>
									<li pname="云南省" name="临沧市" pcode="530000" citycode="530900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 临沧</a></li>
									<li pname="云南省" name="楚雄彝族自治州" pcode="530000" citycode="532300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 楚雄</a></li>
									<li pname="云南省" name="红河哈尼族彝族自治州" pcode="530000" citycode="532500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 红河</a></li>
									<li pname="云南省" name="怒江傈僳族自治州" pcode="530000" citycode="533300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">N</span> 怒江</a></li>
									<li pname="云南省" name="迪庆藏族自治州" pcode="530000" citycode="533400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">D</span> 迪庆</a></li>
									<li pname="云南省" name="昆明市" pcode="530000" citycode="530100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">K</span> 昆明</a></li>
									<li pname="云南省" name="大理白族自治州" pcode="530000" citycode="532900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">D</span> 大理</a></li>
									<li pname="云南省" name="曲靖市" pcode="530000" citycode="530300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Q</span> 曲靖</a></li>
									<li pname="云南省" name="玉溪市" pcode="530000" citycode="530400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 玉溪</a></li>
									<li pname="云南省" name="文山壮族苗族自治州" pcode="530000" citycode="532600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">W</span> 文山</a></li>
									<li pname="云南省" name="西双版纳傣族自治州" pcode="530000" citycode="532800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 西双版纳</a></li>
									<li pname="云南省" name="德宏傣族景颇族自治州" pcode="530000" citycode="533100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">D</span> 德宏</a></li>																																														
								</ul>
							</div>
							<div id="TG_PANEL_23" style="display: none;">
								<ul>
									<li pname="贵州省" name="毕节地区" pcode="520000" citycode="522400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 毕节</a></li>
									<li pname="贵州省" name="黔东南苗族侗族自治州" pcode="520000" citycode="522600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Q</span> 黔东南</a></li>
									<li pname="贵州省" name="黔南布依族苗族自治州" pcode="520000" citycode="522700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Q</span> 黔南</a></li>
									<li pname="贵州省" name="六盘水市" pcode="520000" citycode="520200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 六盘水</a></li>
									<li pname="贵州省" name="遵义市" pcode="520000" citycode="520300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 遵义</a></li>
									<li pname="贵州省" name="安顺市" pcode="520000" citycode="520400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">A</span> 安顺</a></li>
									<li pname="贵州省" name="贵阳市" pcode="520000" citycode="520100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">G</span> 贵阳</a></li>
									<li pname="贵州省" name="铜仁地区" pcode="520000" citycode="522200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 铜仁</a></li>
									<li pname="贵州省" name="黔西南布依族苗族自治州" citycode="522300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Q</span> 黔西南</a></li>																						
								</ul>
							</div>
							<div id="TG_PANEL_24" style="display: none;">
								<ul>
									<li pname="四川省" name="达州市" pcode="510000" citycode="511700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">D</span> 达州</a></li>
									<li pname="四川省" name="雅安市" pcode="510000" citycode="511800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 雅安</a></li>
									<li pname="四川省" name="巴中市" pcode="510000" citycode="511900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 巴中</a></li>
									<li pname="四川省" name="阿坝藏族羌族自治州" pcode="510000" citycode="513200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">A</span> 阿坝</a></li>
									<li pname="四川省" name="甘孜藏族自治州" pcode="510000" citycode="513300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">G</span> 甘孜</a></li>
									<li pname="四川省" name="绵阳市" pcode="510000" citycode="510700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">M</span> 绵阳</a></li>
									<li pname="四川省" name="成都市" pcode="510000" citycode="510100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 成都</a></li>
									<li pname="四川省" name="攀枝花市" pcode="510000" citycode="510400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">P</span> 攀枝花</a></li>
									<li pname="四川省" name="泸州市" pcode="510000" citycode="510500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 泸州</a></li>
									<li pname="四川省" name="广元市" pcode="510000" citycode="510800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">G</span> 广元</a></li>
									<li pname="四川省" name="内江市" pcode="510000" citycode="511000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">N</span> 内江</a></li>
									<li pname="四川省" name="乐山市" pcode="510000" citycode="511100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 乐山</a></li>
									<li pname="四川省" name="南充市" pcode="510000" citycode="511300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">N</span> 南充</a></li>
									<li pname="四川省" name="宜宾市" pcode="510000" citycode="511500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 宜宾</a></li>
									<li pname="四川省" name="遂宁市" pcode="510000" citycode="510900" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 遂宁</a></li>
									<li pname="四川省" name="广安市" pcode="510000" citycode="511600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">G</span> 广安</a></li>
									<li pname="四川省" name="自贡市" pcode="510000" citycode="510300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 自贡</a></li>
									<li pname="四川省" name="眉山市" pcode="510000" citycode="511400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">M</span> 眉山</a></li>
									<li pname="四川省" name="资阳市" pcode="510000" citycode="512000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Z</span> 资阳</a></li>
									<li pname="四川省" name="德阳市" pcode="510000" citycode="510600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">D</span> 德阳</a></li>
									<li pname="四川省" name="凉山彝族自治州" citycode="513400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 凉山</a></li>																			
								</ul>
							</div>
							<div id="TG_PANEL_25" style="display: none;">
								<ul>
									<li pname="西藏自治区" name="拉萨市" pcode="540000" citycode="540100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 拉萨</a></li>
									<li pname="西藏自治区" name="日喀则地区" pcode="540000" citycode="542300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">R</span> 日喀则</a></li>
									<li pname="西藏自治区" name="林芝地区" pcode="540000" citycode="542600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 林芝</a></li>
									<li pname="西藏自治区" name="昌都地区" pcode="540000" citycode="542100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 昌都</a></li>
									<li pname="西藏自治区" name="山南地区" pcode="540000" citycode="542200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 山南</a></li>
									<li pname="西藏自治区" name="那曲地区" pcode="540000" citycode="542400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">N</span> 那曲</a></li>
									<li pname="西藏自治区" name="阿里地区" pcode="540000" citycode="542500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">A</span> 阿里</a></li>
								</ul>
							</div>
							<div id="TG_PANEL_26" style="display: none;">
								<ul>
								<li pname="内蒙古自治区" name="呼和浩特市" pcode="150000" citycode="150100"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 呼和浩特</a></li>
								<li pname="内蒙古自治区" name="乌海市" pcode="150000"citycode="150300"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">W</span> 乌海</a></li>
								<li pname="内蒙古自治区" name="通辽市" pcode="150000"citycode="150500"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 通辽</a></li>
								<li pname="内蒙古自治区" name="鄂尔多斯市" pcode="150000"citycode="150600"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">E</span> 鄂尔多斯</a></li>
								<li pname="内蒙古自治区" name="巴彦淖尔市" pcode="150000"citycode="150800"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 巴彦淖尔</a></li>
								<li pname="内蒙古自治区" name="乌兰察布市" pcode="150000"citycode="150900"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">W</span> 乌兰察布</a></li>
								<li pname="内蒙古自治区" name="锡林郭勒盟" pcode="150000"citycode="152500"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 锡林郭勒盟</a></li>
								<li pname="内蒙古自治区" name="阿拉善盟" pcode="150000"citycode="152900"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">A</span> 阿拉善盟</a></li>
								<li pname="内蒙古自治区" name="赤峰市" pcode="150000"citycode="150400"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 赤峰</a></li>
								<li pname="内蒙古自治区" name="兴安盟" pcode="150000"citycode="152200"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 兴安盟</a></li>
								<li pname="内蒙古自治区" name="包头市" pcode="150000"citycode="150200"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 包头</a></li>
								<li pname="内蒙古自治区" name="呼伦贝尔市" pcode="150000"citycode="150700"  onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 呼伦贝尔</a></li>																							
								</ul>
							</div>
							<div id="TG_PANEL_27" style="display: none;">
								<ul>
								<li pname="黑龙江省" name="绥化市" pcode="230000" citycode="231200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 绥化</a></li>
								<li pname="黑龙江省" name="大兴安岭地区" pcode="230000" citycode="232700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">D</span> 大兴安岭</a></li>
								<li pname="黑龙江省" name="哈尔滨市" pcode="230000" citycode="230100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 哈尔滨</a></li>
								<li pname="黑龙江省" name="齐齐哈尔市" pcode="230000" citycode="230200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Q</span> 齐齐哈尔</a></li>
								<li pname="黑龙江省" name="鸡西市" pcode="230000" citycode="230300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 鸡西</a></li>
								<li pname="黑龙江省" name="双鸭山市" pcode="230000" citycode="230500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 双鸭山</a></li>
								<li pname="黑龙江省" name="伊春市" pcode="230000" citycode="230700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Y</span> 伊春</a></li>
								<li pname="黑龙江省" name="佳木斯市" pcode="230000" citycode="230800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">J</span> 佳木斯</a></li>
								<li pname="黑龙江省" name="鹤岗市" pcode="230000" citycode="230400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 鹤岗</a></li>
								<li pname="黑龙江省" name="牡丹江市" pcode="230000" citycode="231000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">M</span> 牡丹江</a></li>
								<li pname="黑龙江省" name="大庆市" pcode="230000" citycode="230600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">D</span> 大庆</a></li>
								<li pname="黑龙江省" name="七台河市" pcode="230000" citycode="230900"onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Q</span> 七台河</a></li>
								<li pname="黑龙江省" name="黑河市" pcode="230000" citycode="231100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 黑河</a></li>																								
								</ul>
							</div>
							<div id="TG_PANEL_28" style="display: none;">
								<ul>
								<li pname="安徽省" name="宿州市" pcode="340000" citycode="341300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">S</span> 宿州</a></li>
								<li pname="安徽省" name="巢湖市" pcode="340000" citycode="341400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 巢湖</a></li>
								<li pname="安徽省" name="六安市" pcode="340000" citycode="341500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">L</span> 六安</a></li>
								<li pname="安徽省" name="池州市" pcode="340000" citycode="341700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 池州</a></li>
								<li pname="安徽省" name="宣城市" pcode="340000" citycode="341800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">X</span> 宣城</a></li>
								<li pname="安徽省" name="安庆市" pcode="340000" citycode="340800" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">A</span> 安庆</a></li>
								<li pname="安徽省" name="滁州市" pcode="340000" citycode="341100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">C</span> 滁州</a></li>
								<li pname="安徽省" name="阜阳市" pcode="340000" citycode="341200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">F</span> 阜阳</a></li>
								<li pname="安徽省" name="合肥市" pcode="340000" citycode="340100" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 合肥</a></li>
								<li pname="安徽省" name="蚌埠市" pcode="340000" citycode="340300" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">B</span> 蚌埠</a></li>
								<li pname="安徽省" name="淮南市" pcode="340000" citycode="340400" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 淮南</a></li>
								<li pname="安徽省" name="铜陵市" pcode="340000" citycode="340700" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">T</span> 铜陵</a></li>
								<li pname="安徽省" name="芜湖市" pcode="340000" citycode="340200" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">W</span> 芜湖</a></li>
								<li pname="安徽省" name="黄山市" pcode="340000" citycode="341000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 黄山</a></li>
								<li pname="安徽省" name="亳州市" pcode="340000" citycode="341600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 亳州</a></li>
								<li pname="安徽省" name="马鞍山市" pcode="340000" citycode="340500" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">M</span> 马鞍山</a></li>
								<li pname="安徽省" name="淮北市" pcode="340000" citycode="340600" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">H</span> 淮北</a></li>																								
								</ul>
							</div>
							<div id="TG_PANEL_99" style="display: none;">
								<ul>
								<li pname="" name="其他" pcode="990000" citycode="990000" onclick="setCityName(this)"><a href="#nogo#"><span class="light_red">Q</span> 其他</a></li>																						
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>