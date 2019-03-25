<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title></title>
	
	<%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/import.jsp" %>
<script  type="text/javascript">
	//保存方法
	function save() {
		add_url = '${ctx}/student/studentAdd.do';
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
								学生编号:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="stuid" id="stuid" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入学生编号" invalidMessage="最多不超过字符"  required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								学生姓名:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="stuname" id="stuname" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入学生姓名" invalidMessage="最多不超过字符"  required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								密码:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="stupass" id="stupass" value="" type="password" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入密码" invalidMessage="最多不超过字符"  required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								年龄:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="stuage" id="stuage" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入年龄" invalidMessage="最多不超过字符"  required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								性别:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                               <select class="easyui-combobox"  
									id="stusex" name="stusex"  required="true" missingMessage="请选择性别">
									<option selected="selected" value="">请选择</option> 
									<option  value="男">男</option>
									<option value="女">女</option>
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
									id="stuclub" name="stuclub"  required="true" missingMessage="请选择所在院系">
									<option selected="selected" value="">请选择</option> 
									    <c:forEach var="item" items="${clubList}">    
									    	<option value="${item.clubname}">${item.clubname}</option> 
									    </c:forEach>
								</select>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								所在年级:
								<span style="color: red;">*</span>
							</td>
							<td width="20%">  
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
							 <td  width="13%">
								所在班级:
								<span style="color: red;">*</span>
							</td>
							<td width="20%">  
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
							 <td  width="13%">
								QQ号:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="stuqq" id="stuqq" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入QQ号" invalidMessage="最多不超过字符"  required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								电话号码:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="stutelephone" id="stutelephone" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入电话号码" invalidMessage="最多不超过字符"  required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								邮箱:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="stuemail" id="stuemail" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入邮箱" invalidMessage="最多不超过字符"  required="true"/>
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
