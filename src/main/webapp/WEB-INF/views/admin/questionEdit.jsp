<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title></title>

<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/import.jsp"%>
<script type="text/javascript">
	//保存方法
	function save() {
		update_url = '${ctx}/question/questionEdit.do';
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
				<input type="hidden" id="questionid" name="questionid" value="${question.questionid}">
			<input type="hidden" id="formToken" name="formToken" value="${formToken}" />
			<table class="datagrid-body" width="100%"> 
					<tr>
						<th width="100px;" class="datagrid-header">评价问题题号: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="questionid" id="questionid" value="${question.questionid}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入评价问题题号"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">评价问题分数: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="questionscore" id="questionscore" value="${question.questionscore}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入评价问题分数"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">评价问题: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="question" id="question" value="${question.question}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入评价问题"
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
