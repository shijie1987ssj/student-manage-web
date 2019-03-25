<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title></title>
	
	<%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/import.jsp" %>
<script  type="text/javascript">
	//保存方法
	function save() {
		add_url = '${ctx}/stuscore/stuscoreAdd.do';
		/*******************设置form参数********************************/
		common.ajaxApi.Form($('#saveForm'),add_url,false,true,null,function() { 
			parent.closeDialog();
			parent.reload(); 
		}); 
		/*************************form提交*********************/
	}
</script>
<body>
			<div id="tip">
				<form id="saveForm" name="saveForm" method="post"
					action=""> 
					<table class="searchTable" cellspacing="1" cellpadding="5" align="center">
						<tr> 
							 <td  width="13%">
								学生编号主键:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="stuid" id="stuid" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入学生编号主键" invalidMessage="最多不超过字符" validType="idlenth" required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								英语成绩:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="english" id="english" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入英语成绩" invalidMessage="最多不超过字符" validType="idlenth" required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								数学成绩:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="math" id="math" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入数学成绩" invalidMessage="最多不超过字符" validType="idlenth" required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								语文成绩:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="chinese" id="chinese" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入语文成绩" invalidMessage="最多不超过字符" validType="idlenth" required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								计算机成绩:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="computer" id="computer" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入计算机成绩" invalidMessage="最多不超过字符" validType="idlenth" required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								总分:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="sumscore" id="sumscore" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入总分" invalidMessage="最多不超过字符" validType="idlenth" required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								排名:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="rank" id="rank" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入排名" invalidMessage="最多不超过字符" validType="idlenth" required="true"/>
							</td>
						</tr>
					</table>
				</form>
				<center>
					<a href="#" class="easyui-linkbutton" iconCls="icon-save"
						id="btn_submit" onClick="save();">提交</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-back"
						id="btn-back" onclick="parent.closeDialog();">返回</a>
				</center>
			</div>
		</body>
</html>
