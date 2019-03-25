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
								学生编号:
							</td>
							<td colspan="3">
							    ${stuscore.stuid}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								学生姓名:
							</td>
							<td colspan="3">
							    ${stuscore.stuname}
							</td>
						</tr>    
						<tr>
							<td class="datagrid-header" width="13%">
								性别:
							</td>
							<td colspan="3">
							    ${stuscore.stusex}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								所在班级:
							</td>
							<td colspan="3">
							    ${stuscore.stuclass}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								所在院系:
							</td>
							<td colspan="3">
							    ${stuscore.stuclub}
							</td>
						</tr>  
						<tr>
							<td class="datagrid-header" width="13%">
								英语成绩:
							</td>
							<td colspan="3">
							    ${stuscore.english}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								数学成绩:
							</td>
							<td colspan="3">
							    ${stuscore.math}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								语文成绩:
							</td>
							<td colspan="3">
							    ${stuscore.chinese}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								计算机成绩:
							</td>
							<td colspan="3">
							    ${stuscore.computer}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								总分:
							</td>
							<td colspan="3">
							    ${stuscore.sumscore}
							</td>
						</tr> 
						<tr>
							<td class="datagrid-header" width="13%">
								排名:
							</td>
							<td colspan="3">
							    ${stuscore.rank}
							</td>
						</tr> 
					</table>
				</form> 
			</div>
		</body>
</html>
