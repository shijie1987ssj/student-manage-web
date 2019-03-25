<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/import.jsp"%>
<script type="text/javascript">
	var listUrl = '${ctx}/teacherscore/teacherscoreListDataSum.do'; 
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
							{field:'sumnum',title:'总人数',align : 'center',width:50}, 
							{field:'teacherclub',title:'系部',align : 'center',width:50}, 
							{field:'teacherclass',title:'班级',align : 'center',width:50}, 
							{field:'maxscore',title:'最高分',align : 'center',width:50},  
							{field:'minscore',title:'最低分',align : 'center',width:50}, 
							{field:'avgscore',title:'平均分',align : 'center',width:50}, 
							{field:'pass',title:'及格人数',align : 'center',width:50}, 
							{field:'nopass',title:'不及格人数',align : 'center',width:50}, 
							{field:'gradec',title:'60~75分人数',align : 'center',width:50}, 
							{field:'gradeb',title:'75分~85分人数',align : 'center',width:50}, 
							{field:'gradea',title:'85~100分人数',align : 'center',width:50}
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
	
	function doQuery() {
			var queryParams = $('#dataListDiv').datagrid('options').queryParams;
			queryParams.teacherid = $('#teacherid').val();  
			$('#dataListDiv').datagrid("load");
	}
	
	function clearSearch() {	 
			$('#teacherid').val('');  
			var queryParams = $('#dataListDiv').datagrid('options').queryParams;
		
			queryParams.teacherid = '';  
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
				<td colspan="4" align="center"><a class="easyui-linkbutton"
					iconcls="icon-search" onclick="doQuery();">查 询</a> </td>
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