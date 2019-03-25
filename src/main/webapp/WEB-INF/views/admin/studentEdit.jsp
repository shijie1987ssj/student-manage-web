<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title></title>

<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/import.jsp"%>
<script type="text/javascript">
$(function() {
	$('#stusex').combobox('setValue', '${student.stusex}');
	$('#stuclub').combobox('setValue', '${student.stuclub}');
	$('#stugrade').combobox('setValue', '${student.stugrade}');
	$('#stuclass').combobox('setValue', '${student.stuclass}');

});
	//保存方法
	function save() {
		update_url = '${ctx}/student/studentEdit.do';
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
				<input type="hidden" id="stuid" name="stuid" value="${student.stuid}">
			<input type="hidden" id="formToken" name="formToken" value="${formToken}" />
			<table class="datagrid-body" width="100%"> 
					<tr>
						<th width="100px;" class="datagrid-header">学生编号: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="stuid" id="stuid" value="${student.stuid}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入学生编号，主键"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">学生姓名: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="stuname" id="stuname" value="${student.stuname}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入学生姓名"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">密码: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="stupass" id="stupass"  type="password"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入密码" 
								  />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">年龄: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="stuage" id="stuage" value="${student.stuage}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入年龄"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">性别: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<select class="easyui-combobox" 
									id="stusex" name="stusex"  required="true" missingMessage="请选择性别">
									<option selected="selected" value="">请选择</option> 
									<option  value="男">男</option>
									<option value="女">女</option>
								</select>
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">所在院系: <span style="color: red;">*</span>
						</th>
						<td colspan="3"> 
							<select class="easyui-combobox" 
									id="stuclub" name="stuclub"  required="true" missingMessage="请选择所在院系">
									<option selected="selected" value="">请选择</option> 
									    <c:forEach var="item" items="${clubList}">    
									    	<option value="${item.clubname}">${item.clubname}</option> 
									    </c:forEach>
								</select>
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">所在年级: <span style="color: red;">*</span>
						</th>
						<td colspan="3"> 
							<select class="easyui-combobox"  
									id="stugrade" name="stugrade"  required="true" missingMessage="请选择所在年级">
									<option selected="selected" value="">请选择</option> 
									    <c:forEach var="item" items="${gradeList}">    
									    	<option value="${item.gradename}">${item.gradename}</option> 
									    </c:forEach>
								</select>
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">所在班级: <span style="color: red;">*</span>
						</th>
						<td colspan="3"> 
							<select class="easyui-combobox" 
									id="stuclass" name="stuclass"  required="true" missingMessage="请选择所在班级">
									<option selected="selected" value="">请选择</option> 
									    <c:forEach var="item" items="${classInfoList}">    
									    	<option value="${item.classname}">${item.classname}</option> 
									    </c:forEach>
								</select>
						</td>
					</tr> 
					<tr>
						<th width="100px;" class="datagrid-header">QQ号: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="stuqq" id="stuqq" value="${student.stuqq}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入QQ号"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">电话号码: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="stutelephone" id="stutelephone" value="${student.stutelephone}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入电话号码"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">邮箱: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="stuemail" id="stuemail" value="${student.stuemail}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入邮箱"
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
