<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title></title>

<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/import.jsp"%>
<script type="text/javascript">

$(function() {
	$('#teachersex').combobox('setValue', '${teacher.teachersex}');
	$('#teacherclass').combobox('setValue', '${teacher.teacherclass}');
	$('#teacherclub').combobox('setValue', '${teacher.teacherclub}');
	$('#subject').combobox('setValue', '${teacher.subject}');

});
	//保存方法
	function save() {
		update_url = '${ctx}/teacher/teacherEdit.do';
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
				<input type="hidden" id="teacherid" name="teacherid" value="${teacher.teacherid}">
			<input type="hidden" id="formToken" name="formToken" value="${formToken}" />
			<table class="datagrid-body" width="100%"> 
					<tr>
						<th width="100px;" class="datagrid-header">教师编号: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="teacherid" id="teacherid" value="${teacher.teacherid}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入教师编号"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">教师姓名: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="teachername" id="teachername" value="${teacher.teachername}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入教师姓名"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">年龄: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="teacherage" id="teacherage" value="${teacher.teacherage}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入年龄"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">性别: <span style="color: red;">*</span>
						</th>
						<td colspan="3"> 							
							<select class="easyui-combobox"  
									id="teachersex" name="teachersex"  required="true" missingMessage="请选择性别">
									<option selected="selected" value="">请选择</option> 
									<option  value="男">男</option>
									<option value="女">女</option>
								</select>
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">密码: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="teacherpass" id="teacherpass"  type="password"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入密码"
								 />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">授课班级: <span style="color: red;">*</span>
						</th>
						<td colspan="3"> 
							<select class="easyui-combobox"
									id="teacherclass" name="teacherclass"  required="true" missingMessage="请选择授课班级">
									<option selected="selected" value="">请选择</option> 
									    <c:forEach var="item" items="${classInfoList}">    
									    	<option value="${item.classname}">${item.classname}</option> 
									    </c:forEach>
								</select>
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">所在院系: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<select class="easyui-combobox"
									id="teacherclub" name="teacherclub"  required="true" missingMessage="请选择所在院系">
									<option selected="selected" value="">请选择</option> 
									    <c:forEach var="item" items="${clubList}">    
									    	<option value="${item.clubname}">${item.clubname}</option> 
									    </c:forEach>
								</select>
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">所带课程: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<select class="easyui-combobox"
									id="subject" name="subject"  required="true" missingMessage="请选择所带课程">
									<option selected="selected" value="">请选择</option> 
									    <c:forEach var="item" items="${subjectsList}">    
									    	<option value="${item.subjectname}">${item.subjectname}</option> 
									    </c:forEach>
								</select>
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">毕业院校: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="school" id="school" value="${teacher.school}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入毕业院校"
								required="true" />
						</td>
					</tr>
					<tr>
						<th width="100px;" class="datagrid-header">教师邮箱: <span style="color: red;">*</span>
						</th>
						<td colspan="3">
							<input type="text" name="teacheremail" id="teacheremail" value="${teacher.teacheremail}"
								class="easyui-textbox easyui-validatebox" missingMessage="请输入教师邮箱"
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
