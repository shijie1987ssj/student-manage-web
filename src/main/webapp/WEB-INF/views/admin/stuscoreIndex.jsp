<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/import.jsp"%>
<script type="text/javascript">
	var listUrl = '${ctx}/stuscore/stuscoreListData.do'; 
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
							{field:'stuid',title:'学生编号',align : 'center',width:50}, 
							{field:'stuname',title:'学生姓名',align : 'center',width:50}, 
							{field:'stusex',title:'性别',align : 'center',width:50}, 
							{field:'stuclass',title:'所在班级',align : 'center',width:50}, 
							{field:'stuclub',title:'所在院系',align : 'center',width:50}, 
							{field:'english',title:'英语成绩',align : 'center',width:50}, 
							{field:'math',title:'数学成绩',align : 'center',width:50}, 
							{field:'chinese',title:'语文成绩',align : 'center',width:50}, 
							{field:'computer',title:'计算机成绩',align : 'center',width:50}, 
							{field:'sumscore',title:'总分',align : 'center',width:50}, 
							{field:'rank',title:'排名',align : 'center',width:50}, 
						{field:'op',title:'操作',align : 'center',width:50,
								formatter:function(value,rec){
									var txt2 = "<a href='javascript:void(0)' onclick='editData(\""+rec.stuid+"\");'>修改</a>";
									var txt3 = "<a href='javascript:void(0)' onclick='delData(\""+rec.stuid+"\");'>删除</a>";
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
		var url = '${ctx}/auditDict/toAdd.do';
		showDialog('添加信息',url,'moremiddle',true);
	}
	function editData(id){
		if(id!=null){
			var url = '${ctx}/stuscore/toEdit.do?stuid='+id;
			showDialog('信息修改',url,'moremiddle',true);
		}else{
			var node = getSelected();
			if(node){
				var url = '${ctx}/stuscore/toEdit.do?stuid='+node.stuid;
				showDialog('信息修改',url,'moremiddle',true);
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
				delId = node.stuid;
			}
		}
		$.messager.confirm("操作提示", "您确定要删除吗？", function (data) { 
			if (data) {  
				var url ="${ctx}/stuscore/stuscoreDelete.do?stuid="+delId;
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
			queryParams.stuid = $('#stuid').val(); 
			$('#dataListDiv').datagrid("load");
	}
	
	function clearSearch() {	 
			$('#stuid').val(''); 
			var queryParams = $('#dataListDiv').datagrid('options').queryParams;
		
			queryParams.stuid = ''; 
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
							<td class="datagrid-header">学生编号/姓名：</td>
							<td><input type="text" class="easyui-textbox" id="stuid" name="stuid" /></td>
							 
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