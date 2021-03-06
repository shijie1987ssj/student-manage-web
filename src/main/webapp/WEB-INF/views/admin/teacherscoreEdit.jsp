<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title></title>

<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/import.jsp"%>
<script type="text/javascript">
	//保存方法
	function save() {
		update_url = '${ctx}/teacherscore/teacherscoreEdit.do';
		/*******************设置form参数********************************/
		common.ajaxApi.Form($('#updateForm'),update_url,false,true,null,function() { 
			parent.closeDialog();
			parent.reload(); 
		}); 
		/*************************form提交*********************/
		return false;
	}
</script>
<body>
	<div id="tip">
		<form id="updateForm" name="updateForm" method="post" action="">
				<input type="hidden" id="teacherid" name="teacherid" value="${teacherscore.teacherid}">
			<input type="hidden" id="formToken" name="formToken" value="${formToken}" />
			<table class="datagrid-body" width="100%"> 
					<tr>
						<th width="100px;" class="datagrid-header">教师编号: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="teacherid" id="teacherid" value="${teacherscore.teacherid}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入教师编号"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">教师评价得分: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="teacherscore" id="teacherscore" value="${teacherscore.teacherscore}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入教师评价得分"
								required="true" />
						</td>
					</tr>
			</table>
		</form>
		<center>
			<a href="#" class="easyui-linkbutton" iconCls="icon-save"
				id="btn_submit" onClick="return save();">提交</a> <a href="#"
				class="easyui-linkbutton" iconCls="icon-back" id="btn-back"
				onclick="parent.closeDialog();">返回</a>
		</center>
	</div>
</body>
</html>
