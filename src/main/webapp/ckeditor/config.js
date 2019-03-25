/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights
 *          reserved. For licensing, see LICENSE.md or
 *          http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	// 界面语言，默认为 'en'
	config.language = 'zh-cn';
	// 设置宽高
	//config.width = 400;
	config.height = 400;
	config.toolbar =
		[
		{ name: 'document', items: ['Source', '-', 'Save', 'NewPage', 'DocProps', 'Preview', 'Print','-', 'Templates'] },
		{ name: 'clipboard', items: ['Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo'] },
		{ name: 'basicstyles', items: ['Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat'] },
		{ name: 'links', items: ['Link', 'Unlink', 'Anchor'] },
		'/',
		//{ name: 'forms', items: ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'] },
		{ name: 'paragraph', items: ['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', 'CreateDiv', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl'] },
		{ name: 'editing', items: ['Find', 'Replace', '-', 'SelectAll', '-', 'SpellChecker', 'Scayt'] },
		{ name: 'insert', items: ['Image', 'Flash', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak', 'Iframe'] },
		'/',
		{ name: 'styles', items: ['Styles', 'Format', 'Font', 'FontSize'] },
		{ name: 'colors', items: ['TextColor', 'BGColor'] },
		{ name: 'tools', items: ['Maximize', 'ShowBlocks', '-', 'About'] }
		];
	// 工具栏是否可以被收缩
	config.toolbarCanCollapse = true;
	// 工具栏的位置
	config.toolbarLocation = 'top';// 可选：bottom
	// 工具栏默认是否展开
	config.toolbarStartupExpanded = true;
	// 取消 “拖拽以改变尺寸”功能 plugins/resize/plugin.js
	config.resize_enabled = false;
	//下面两行,是关掉拼写检查的,不然加载整个文本框时,会很慢.
	config.disableNativeSpellChecker = false ;
	config.scayt_autoStartup = false;
	// 当提交包含有此编辑器的表单时，是否自动更新元素内的数据
	config.autoUpdateElement = true;
	// 默认的字体名 plugins/font/plugin.js
	//config.font_defaultLabel = 'Arial';
	config.image_previewText = "预览图片的位置 ";
	//其他一些配置
    filebrowserBrowseUrl = 'ckfinder/ckfinder.html';
    filebrowserImageBrowseUrl = 'ckfinder/ckfinder.html?type=Images';
    filebrowserFlashBrowseUrl = 'ckfinder/ckfinder.html?type=Flash';
	filebrowserUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
	filebrowserImageUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';
	filebrowserFlashUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash';
};
