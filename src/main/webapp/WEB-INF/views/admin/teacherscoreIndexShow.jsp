<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/import.jsp"%>
<script type="text/javascript">
	var uflag = '${uflag}';
	var listUrl = '${ctx}/teacherscore/teacherscoreListData.do'; 
	$(function(){
			$('#dataListDiv').datagrid({
				title:'查询结果',
				iconCls:'icon-ok',
				url:listUrl,
				nowrap: false,
				striped: true,
				collapsible:false,				
				fitColumns: true,
				pagination:true,
				singleSelect:true,
				rownumbers:true,
				remoteSort: false,
				pageList:[10,15,30,50],
				idField:'id',
				columns:[[
							{field:'teacherid',title:'教师编号',align : 'center',width:50}, 
							{field:'teachername',title:'教师姓名',align : 'center',width:50}, 
							{field:'teacherage',title:'年龄',align : 'center',width:50}, 
							{field:'teachersex',title:'性别',align : 'center',width:50},  
							{field:'teacherclass',title:'授课班级',align : 'center',width:50}, 
							{field:'teacherclub',title:'所在院系',align : 'center',width:50}, 
							{field:'subject',title:'所带课程',align : 'center',width:50}, 
							{field:'school',title:'毕业院校',align : 'center',width:50}, 
							{field:'teacherscore',title:'教师评价得分',align : 'center',width:50}
				]]
			});
		});
	function reload(){
		  $('#dataListDiv').datagrid('reload');
    }
	function getSelected(){
		var selected = $('#dataListDiv').datagrid('getSelected');
		if (selected){
			return selected;
		}else{
			$.messager.alert('提示', '请选择要操作的记录', 'info');
		}
	} 
	function addData(){
		var url = '${ctx}/teacherscore/toAdd.do';
		showDialog('添加信息',url,'moresmall',true);
	}
	function editData(id){
		if(id!=null){
			var url = '${ctx}/teacherscore/toEdit.do?teacherid='+id;
			showDialog('信息修改',url,'moresmall',true);
		}else{
			var node = getSelected();
			if(node){
				var url = '${ctx}/teacherscore/toEdit.do?teacherid='+node.teacherid;
				showDialog('信息修改',url,'moresmall',true);
			}
		}
	}
	function delData(id){
		var delId = "";
		if(id!=null){
			delId = id;
		}else{
			var node = getSelected();
			if(node){
				delId = node.teacherid;
			}
		}
		$.messager.confirm("操作提示", "您确定要删除吗？", function (data) { 
			if (data) {  
				var url ="${ctx}/teacherscore/teacherscoreDelete.do?teacherid="+delId;
				function getFormToken(){
					return $("#formToken").val();
				}
				var fromToken = getFormToken();
				var data = {"id":node.id,"formToken":fromToken};
				common.ajaxApi.Post(url,data,null,false,function(){ 
					$('#dataListDiv').datagrid('reload'); 
				});  
			}
		});
	}
	
	function doQuery() {
			var queryParams = $('#dataListDiv').datagrid('options').queryParams;
			queryParams.teacherid = $('#teacherid').val();  
			queryParams.uflag = uflag;  
			$('#dataListDiv').datagrid("load");
	}
	
	function clearSearch() {	 
			$('#teacherid').val('');  
			var queryParams = $('#dataListDiv').datagrid('options').queryParams;
		
			queryParams.teacherid = '';  
			queryParams.uflag = uflag; 
			$('#dataListDiv').datagrid("load");
	}
</script>
</head>
<body>
	<!-- 查询条件窗口 -->
<div title="查询条件" id="sellerUnitList" class="easyui-panel"
	iconCls="icon-search" collapsed="false" collapsible="true">
	<form  id="searchform" name="searchform" method="post">		
		<table class="datagrid-body" width="100%">
			<tr>
							<td class="datagrid-header">教师编号：</td>
							<td><input type="text" class="easyui-textbox" id="teacherid" name="teacherid" /></td>  
			</tr>
			<tr>
				<td colspan="4" align="center"><a class="easyui-linkbutton"
					iconcls="icon-search" onclick="doQuery();">查 询</a> &nbsp;
					<a class="easyui-linkbutton" iconCls="icon-redo" onclick="clearSearch();">重置</a></td>
			</tr>
		</table>
	</form>
</div>
<br />
<div id="testresultlist" class="easyui-panel" >
	<table id="dataListDiv"></table>
</div>
<%@include file="/common/showDialog/showDialog_middle.jsp"%> 
</body>
</html>