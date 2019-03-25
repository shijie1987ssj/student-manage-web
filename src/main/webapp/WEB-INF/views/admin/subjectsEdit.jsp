<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title></title>

<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/import.jsp"%>
<script type="text/javascript">
$(function() {
	$('#clubname').combobox('setValue', '${subjects.clubname}'); 

});
	//保存方法
	function save() {
		update_url = '${ctx}/subjects/subjectsEdit.do';
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
				<input type="hidden" id="subjectname" name="subjectname" value="${subjects.subjectname}">
			<input type="hidden" id="formToken" name="formToken" value="${formToken}" />
			<table class="datagrid-body" width="100%"> 
					<tr>
						<th width="100px;" class="datagrid-header">课程名称: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="subjectname" id="subjectname" value="${subjects.subjectname}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入课程名称"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">院系名称: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<select class="easyui-combobox"
									id="clubname" name="clubname"  required="true" missingMessage="请选择院系名称">
									<option selected="selected" value="">请选择</option> 
									    <c:forEach var="item" items="${clubList}">    
									    	<option value="${item.clubname}">${item.clubname}</option> 
									    </c:forEach>
								</select>
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
