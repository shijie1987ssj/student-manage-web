<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/import.jsp"%>
<script type="text/javascript">
	var listUrl = '${ctx}/leader/leaderListData.do'; 
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
							{field:'leadername',title:'领导用户名',align : 'center',width:50},  
						{field:'op',title:'操作',align : 'center',width:50,
								formatter:function(value,rec){
									var txt2 = "<a href='javascript:void(0)' onclick='editData(\""+rec.leadername+"\");'>修改</a>";
									var txt3 = "<a href='javascript:void(0)' onclick='delData(\""+rec.leadername+"\");'>删除</a>";
									return txt2 + " | " + txt3;
								}
							}
				]],
				toolbar:[{		        	  
	              	text:'增加',
	              	iconCls:'icon-add',
              		handler:function(){
              			addData();
              		}
		        } ,'-', {
	              	text:'修改',
	              	iconCls:'icon-edit',
              		handler:function(){
              			editData();
              		}
	          	} ,'-', {
	              	text:'删除',
	              	iconCls:'icon-remove',
	              	handler:function(){
	              		delData();
 					}
	          	}],
				onDblClickRow:function(row){
					//viewProject();
				}
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
		var url = '${ctx}/leader/toAdd.do';
		showDialog('添加信息',url,'moresmall',true);
	}
	function editData(id){
		if(id!=null){
			var url = '${ctx}/leader/toEdit.do?leadername='+id;
			showDialog('信息修改',url,'moresmall',true);
		}else{
			var node = getSelected();
			if(node){
				var url = '${ctx}/leader/toEdit.do?leadername='+node.leadername;
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
				delId = node.id;
			}
		}
		$.messager.confirm("操作提示", "您确定要删除吗？", function (data) { 
			if (data) {  
				var url ="${ctx}/leader/leaderDelete.do?leadername="+delId;
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
			queryParams.leadername = $('#leadername').val(); 
			$('#dataListDiv').datagrid("load");
	}
	
	function clearSearch() {	 
			$('#leadername').val(''); 
			var queryParams = $('#dataListDiv').datagrid('options').queryParams;
		
			queryParams.leadername = ''; 
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
							<td class="datagrid-header">领导用户名：</td>
							<td><input type="text" class="easyui-textbox" id="leadername" name="leadername" /></td> 
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