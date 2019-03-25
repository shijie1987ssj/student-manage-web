function checkName(assetName,ctx,originName){
	if(!assetName){
		isDup = false;
		return;
	}
	if(assetName==originName){
		isDup = false;
		return;
	}
	$.ajax( {
         url : ctx+"/project/checkDuplicateName.do?assetName="+assetName,
         type : "POST",
         async : false,
         dataType: "json",
         success: function(data) {
        	var result = data;
        	if (data.code == 'SYS00000') {
				isDup = false;
			} else if (data.code == 'SYS10006') {
				isDup = true;
				$.messager.alert('提交结果', "该标的名称已存在", "error");
			} else {
				//$.messager.alert('提交结果', result.message, "error");
				$.messager.alert('提交结果', "检查重名遇到错误", "error");
			}
         },
         error : function() {
        	console.info("网络错误");
		}
     });
}