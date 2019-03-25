<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title></title>

<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/import.jsp"%>
<script type="text/javascript">
	//保存方法
	function save() {
		update_url = '${ctx}/leader/leaderEdit.do';
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
				<input type="hidden" id="leadername" name="leadername" value="${leader.leadername}">
			<input type="hidden" id="formToken" name="formToken" value="${formToken}" />
			<table class="datagrid-body" width="100%"> 
					<tr>
						<th width="100px;" class="datagrid-header">领导用户名: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="leadername" id="leadername" value="${leader.leadername}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入领导用户名"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">密码: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="leaderpass" id="leaderpass" value="${leader.leaderpass}" type="password"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入密码"
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
