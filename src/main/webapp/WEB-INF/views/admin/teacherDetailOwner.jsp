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
								教师编号:
							</td>
							<td colspan="3">
							    ${teacher.teacherid}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								教师姓名:
							</td>
							<td colspan="3">
							    ${teacher.teachername}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								年龄:
							</td>
							<td colspan="3">
							    ${teacher.teacherage}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								性别:
							</td>
							<td colspan="3">
							    ${teacher.teachersex}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								授课班级:
							</td>
							<td colspan="3">
							    ${teacher.teacherclass}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								所在院系:
							</td>
							<td colspan="3">
							    ${teacher.teacherclub}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								所带课程:
							</td>
							<td colspan="3">
							    ${teacher.subject}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								毕业院校:
							</td>
							<td colspan="3">
							    ${teacher.school}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								教师邮箱:
							</td>
							<td colspan="3">
							    ${teacher.teacheremail}
							</td>
						</tr>   
						<tr>
							<td class="datagrid-header" width="13%">
								评分:
							</td>
							<td colspan="3">
							    ${teacherscore.teacherscore}
							</td>
						</tr>    
					</table>
				</form> 
			</div>
		</body>
</html>
