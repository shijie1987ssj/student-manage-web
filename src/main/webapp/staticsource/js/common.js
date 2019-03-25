var common={};
common.ajaxApi = function() {
	var ajaxApi = {};
	var PATH = '';
	var doSuccess = function(data, callback, postfunc) {
		var success, fail;
		if(!callback){
			success = function (){
				
				$.messager.alert('提交结果', '操作成功', 'info', postfunc);
			};
			fail = function (){
				
				$.messager.alert('错误信息', data.message, 'info');
			};
		}else if ($.isFunction(callback)) {
			success = callback;
		} else if ($.isPlainObject(callback)) {
			success = callback.success;
			fail = callback.fail;
		}
		if (!data) {
			data = {};
		}
		if($.isPlainObject(data)){
			if(typeof(data.formToken)!="undefined" && data.formToken!=null && data.formToken!=""){
				$("input[name='formToken']").val(data.formToken) ;
			}
		}else{
			data = jQuery.parseJSON(data);
			if(typeof(data.formToken)!="undefined" && data.formToken!=null && data.formToken!=""){
				$("input[name='formToken']").val(data.formToken) ;
			}
		}

		if (data.code !== undefined) {
			if (data.code == 'SYS99993')//登录超时,跳转登录页
			{
				var contextPath;
				 if (typeof(contextPath) == "undefined")
				{
					 contextPath="";
				}
				 else
				{
					 contextPath=web_contextPath;
				}
				window.location.href =contextPath +'/login.jsp';
				return;
			}
			if (fail !== undefined) {
				if (data.code == 'SYS00000') {
					if ($.isFunction(success)) {
						success(data);
					}

				} else {
					var ret;
					if ($.isFunction(fail)) {
						ret = fail(data);
					}else{
					//if (!ret) {
						$.messager.alert('错误信息：', data.message, 'error');
					}
				}
			} else {
				if ($.isFunction(success)) {
					success(data);
				}
			}
		}
	};

	var doFail = function(data, callback) {
		data.errorCode = 'HTTP-' + data.errorCode;
		var fail;
		if ($.isPlainObject(callback)) {
			fail = callback.fail;
		}
		if ($.isFunction(fail)) {
			fail(data);
		} else {
			if (data.errorCode != 'HTTP-0' && data.errorMessage != "") {
				$.messager.alert('错误信息：', data.errorMessage, 'info');
			}
		}
	};

	var request = function(method, url, params, callback, async, getfunc) {
		if (async !== false)
			async = true;

		if (params) {
			if ($.isPlainObject(params)) {
				$.each(params, function(key, value) {
					if (value === null || value === undefined) {
						delete params[key];
					}
				});
			}
		}
		url = PATH + url;
		return $.ajax({
			url : url,
			data : params,
			async : async,
			type : method,
			dataType : "json",
			cache : false,
			traditional : true,
			success : function(data, textStatus, jqXHR) {
				doSuccess(data, callback, getfunc);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				var errorCode = jqXHR.status, errorMessage = errorThrown;
				doFail({
					errorCode : errorCode,
					errorMessage : errorMessage
				}, callback);
			}
		});
	};
	
	var formRequest = function($myform, method, url, callback, async, validate, postfunc) {

		if (async !== false)
			async = true;
		
		url = PATH + url;
		
		$myform.form({
			url : url,
			async : async,
			type : method,
			dataType : "json",
			cache : false,
			traditional : true,
			onSubmit : function() {
/*				debugger;*/
				if(validate){
					return $myform.form("validate");
				}else{
					return true;
				}
			},
			success : function(data, textStatus, jqXHR) {
				doSuccess(data, callback, postfunc);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				var errorCode = jqXHR.status, errorMessage = errorThrown;
				doFail({
					errorCode : errorCode,
					errorMessage : errorMessage
				}, callback);
			}
		});
		return $myform.submit();
	};
	

	/* 通用Get方法 */
	ajaxApi.Get = function(url, params, callback) {

		return request('GET', url, params, callback, true, null);
	};
	
	/* 通用Get方法 */
	ajaxApi.Get = function(url, params, callback, getfunc) {

		return request('GET', url, params, callback, true, getfunc);
	};

	/* 通用Get方法 */
	ajaxApi.Get = function(url, params, callback, async, getfunc) {

		return request('GET', url, params, callback, async, getfunc);
	};

	/* 通用Post方法 */
	ajaxApi.Post = function(url, params, callback) {

		return request('POST', url, params, callback, true, null);
	};
	ajaxApi.Post = function(url, params, callback, postfunc) {

		return request('POST', url, params, callback, true, postfunc);
	};

	/* 通用Post方法 */
	ajaxApi.Post = function(url, params, callback, async, postfunc) {

		return request('POST', url, params, callback, async, postfunc);
	};
	
	/* 通用form Post方法 */
	ajaxApi.Form = function($myform, url, async, validate, callback, postfunc) {
		
		return formRequest($myform, 'POST', url, callback, async, validate, postfunc);
	};

	return ajaxApi;

}();

    