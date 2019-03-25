<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title></title>
	
	<%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/import.jsp" %>
<script  type="text/javascript">

	//保存方法
	function save() {
		add_url = '${ctx}/stuPingjiaTeacher/stuPingjiaTeacherUpsert.do';
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
					<input type="hidden" id="teacherid" name="teacherid" value="${teacherid}">
					<table class="searchTable" cellspacing="1" cellpadding="5" align="center">
						<tr> 
							 <td  width="10%">
								题号
							</td>
							<td  width="10%">
								题目分值
							</td>
							<td  width="43%">
								问题
							</td>
							<td  width="23%">
								评价
							</td>
						</tr> 
						<c:forEach var="item" items="${questionList}"  varStatus="status">    
							<tr> 
								 <td  width="10%">
									${item.questionid}
								</td>
								<td  width="10%">
									${item.questionscore}
								</td>
								<td  width="43%">
									${item.question}
								</td>
								<td  width="23%">
									 <select class="easyui-combobox"  editable="false"
										id="score${ status.index + 1}" name="score${ status.index }"  required="true" missingMessage="请选择分值">  
										<option selected="selected" value="1">1</option>
										<option  value="2">2</option>
										<option  value="3">3</option>
										<option  value="4">4</option>
										<option  value="5">5</option>
										<option  value="6">6</option>
										<option  value="7">7</option>
										<option  value="8">8</option>
										<option  value="9">9</option>
										<option  value="10">10</option>
									</select>
									分
								</td>
							</tr> 
						</c:forEach>
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
