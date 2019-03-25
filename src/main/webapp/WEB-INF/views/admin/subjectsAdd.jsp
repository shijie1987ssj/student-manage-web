<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title></title>
	
	<%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/import.jsp" %>
<script  type="text/javascript">
	//保存方法
	function save() {
		add_url = '${ctx}/subjects/subjectsAdd.do';
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
								课程名称:
								<span style="color: red;">*</span>
							</td>
							<td width="20%"> 
                                <input name="subjectname" id="subjectname" value="" class="easyui-textbox easyui-validatebox" 
								missingMessage="请输入课程名称" invalidMessage="最多不超过字符" validType="idlenth" required="true"/>
							</td>
						</tr>
						<tr> 
							 <td  width="13%">
								院系名称:
								<span style="color: red;">*</span>
							</td>
							<td width="20%">  
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
						id="btn_submit" onClick="save();">提交</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-back"
						id="btn-back" onclick="parent.closeDialog();">返回</a>
				</center>
			</div>
		</body>
</html>
