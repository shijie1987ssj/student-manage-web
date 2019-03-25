<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title></title>
	
	<%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/import.jsp" %>
<body>

			<div id="tip">
				<form id="saveForm" name="saveForm" method="post"
					action="">
					<table class="datagrid-body">
						<tr>
							<td class="datagrid-header" width="13%">
								学生编号，主键:
							</td>
							<td colspan="3">
							    $!{student.stuid}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								学生姓名:
							</td>
							<td colspan="3">
							    $!{student.stuname}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								密码:
							</td>
							<td colspan="3">
							    $!{student.stupass}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								年龄:
							</td>
							<td colspan="3">
							    $!{student.stuage}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								性别:
							</td>
							<td colspan="3">
							    $!{student.stusex}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								所在班级，外键:
							</td>
							<td colspan="3">
							    $!{student.stuclass}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								所在院系，外键:
							</td>
							<td colspan="3">
							    $!{student.stuclub}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								QQ号:
							</td>
							<td colspan="3">
							    $!{student.stuqq}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								电话号码:
							</td>
							<td colspan="3">
							    $!{student.stutelephone}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								邮箱:
							</td>
							<td colspan="3">
							    $!{student.stuemail}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								所在年级，外键:
							</td>
							<td colspan="3">
							    $!{student.stugrade}
							</td>
						</tr> 
					</table>
				</form>
				<center>
					<a href="#" class="easyui-linkbutton" iconCls="icon-back"
						id="btn-back" onclick="parent.closeDialog();">关闭</a>
				</center>
			</div>
		</body>
</html>
