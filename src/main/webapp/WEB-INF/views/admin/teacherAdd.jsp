<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title></title>
	
	<%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/import.jsp" %>
<script  type="text/javascript">
	//保存方法
	function save() {
		add_url = '${ctx}/teacher/teacherAdd.do';
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
								教师编号:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="teacherid" id="teacherid" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入教师编号" invalidMessage="最多不超过字符" validType="idlenth" required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								教师姓名:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="teachername" id="teachername" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入教师姓名" invalidMessage="最多不超过字符" validType="idlenth" required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								年龄:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="teacherage" id="teacherage" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入年龄" invalidMessage="最多不超过字符" validType="idlenth" required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								性别:
								<span style="color: red;">*</span>
							</td>
							<td width="20%">  
								<select class="easyui-combobox"  
									id="teachersex" name="teachersex"  required="true" missingMessage="请选择性别">
									<option selected="selected" value="">请选择</option> 
									<option  value="男">男</option>
									<option value="女">女</option>
								</select>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								密码:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="teacherpass" id="teacherpass" value="" type="password" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入密码" invalidMessage="最多不超过字符" validType="idlenth" required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								授课班级:
								<span style="color: red;">*</span>
							</td>
							<td width="20%">  
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
							 <td  width="13%">
								所在院系:
								<span style="color: red;">*</span>
							</td>
							<td width="20%">  
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
							 <td  width="13%">
								所带课程:
								<span style="color: red;">*</span>
							</td>
							<td width="20%">  
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
							 <td  width="13%">
								毕业院校:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="school" id="school" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入毕业院校" invalidMessage="最多不超过字符" validType="idlenth" required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								教师邮箱:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="teacheremail" id="teacheremail" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入教师邮箱" invalidMessage="最多不超过字符" validType="idlenth" required="true"/>
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
