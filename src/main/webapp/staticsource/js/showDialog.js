/**
 * 展示窗口 (默认显示 type类型为：middle的窗口)
 * 
 * 适合 显示对话框的div独立，且div中是iframe的情况（只需引入本文件，不需另定义div）
 * 
 * 参数说明： 
 * title：窗口标题 
 * tmpurl:窗口中iframe的src
 * type:窗口大小,值为{'big','middle'}之一（可以扩展）；big:1000*600 middle:500*300 ...
 * isReloadParent:关闭窗口后，是否刷新父窗口，true:是 false:否
 * isIe6Frame 是否IE6加iframe
 */
var dialog_excend_id = 'moremiddle';
function showDialog(title, tmpurl, type, isReloadParent) {
	var ie6Flag = false;
	if ($.browser.msie) {
		if ($.browser.version == '6.0') {
			ie6Flag = true;
		}
	}
	var winWidth;
	var defaulttop = 10;
	var defaultleft=120;
	var defaultWith = 500;
	var defaultHeight = 300;
	if (type === "big") {
		defaulttop = 30;
		defaultWith = 1000;
		defaultHeight = 480;
	} else if (type === "bigheight"){
		defaulttop = 30;
		defaultWith = 1000;
		defaultHeight = 620;
	} else if (type === "morebigheight") {
		defaulttop = 30;
		defaultWith = 1100;
		defaultHeight = 650;	
	} else if (type === "morebig") {
		defaulttop = 30;
		defaultWith = 1100;
		defaultHeight = 350;
	} else if (type === "middle") {
		defaulttop = 30;
		defaultWith = 800;
		defaultHeight = 350;
	} else if (type === "small") {
		defaulttop = 30;
		defaultWith = 340;
		defaultHeight = 200;
	} else if (type === "moresmall") {
		defaulttop = 30;
		defaultWith = 440;
		defaultHeight = 300;
	} else if (type === "moremiddle") {
		defaulttop = 30;
		defaultWith = 800;
		defaultHeight = 600;
	} else if (type === "moreheight") {
		defaulttop = 30;
		defaultWith = 800;
		defaultHeight = 650;
	}else if (type === "moresmallwidth") {
		defaulttop = 30;
		defaultWith = 440;
		defaultHeight = 200;
	}else if (type === "height750") {
		defaulttop = 30;
		defaultWith = 900;
		defaultHeight = 750;	
	}else if (type === "lessmiddle") {
		defaulttop = 30;
		defaultWith = 800;
		defaultHeight = 300;
	} else {
		defaulttop = 30;
		defaultWith = 800;
		defaultHeight = 500;
	}

	var x = 0;
	try {
		x = $('#popup' + dialog_excend_id).offset().top;
	} catch (exception) {
		x = 0;
	}
	if (x < 0)
		x = 0;
	// 获取窗口宽度
	if (window.innerWidth) {
		winWidth = window.innerWidth;
	} else if ((document.documentElement) && (document.documentElement.clientHeight)) {
		winWidth = document.documentElement.clientWidth;
	}
	
	
	$('#popup' + dialog_excend_id).dialog({
		left:(winWidth-defaultWith)/2,
		top:x,
		title : title,
		width : defaultWith,
		height : defaultHeight,
		draggable : true,
		modal : true,
		onClose : function() {
			$('#framepopupmoremiddle').attr({'src':'about:blank'});
		},
		onBeforeClose : function() {
			if (isReloadParent === true) {
				reload();
			}
		}
	});

	if (tmpurl.indexOf('?') > -1) {
		tmpurl = tmpurl + "&sdfdsf=" + new Date().getTime();
	} else {
		tmpurl = tmpurl + "?sdfdsf=" + new Date().getTime();
	}
	$('#framepopupmoremiddle').attr({'src': tmpurl,'height':(defaultHeight-40)+'px'});

	$('#popup' + dialog_excend_id).dialog('open');
	if (ie6Flag) {
		ie6bug.maskSelect();
	}
}
function closeDialog() {
	$('#popup' + dialog_excend_id).dialog('close');
}