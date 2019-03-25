<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title></title>

<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/import.jsp"%>
<script type="text/javascript">
	//保存方法
	function save() {
		update_url = '${ctx}/stuscore/stuscoreEdit.do';
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
				<input type="hidden" id="stuid" name="stuid" value="${stuscore.stuid}">
			<input type="hidden" id="formToken" name="formToken" value="${formToken}" />
			<table class="datagrid-body" width="100%"> 
					<tr>
						<th width="100px;" class="datagrid-header">学生编号: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="stuid" id="stuid" value="${stuscore.stuid}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入学生编号"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">英语成绩: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="english" id="english" value="${stuscore.english}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入英语成绩"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">数学成绩: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="math" id="math" value="${stuscore.math}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入数学成绩"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">语文成绩: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="chinese" id="chinese" value="${stuscore.chinese}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入语文成绩"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">计算机成绩: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="computer" id="computer" value="${stuscore.computer}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入计算机成绩"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">总分: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="sumscore" id="sumscore" value="${stuscore.sumscore}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入总分"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">排名: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="rank" id="rank" value="${stuscore.rank}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入排名"
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
