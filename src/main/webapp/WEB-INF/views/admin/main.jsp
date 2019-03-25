<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.uf88.admin.utils.Auth"%> 
<%@ page import="com.uf88.admin.utils.AuthTools"%> 
<%@ page import="com.uf88.admin.web.AdminConst.*"%>
<%  
String pathT = request.getContextPath();
String basePathT = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ pathT + "/";
Auth auth= AuthTools.getAuth(request); 
if(auth == null){ 
	response.sendRedirect(basePathT+"/LogoutServlet");	
}

 %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<%@ include file="/common/meta.jsp" %>
<%@ include file="/common/import.jsp" %>
<script type="text/javascript" src="${ctx}/staticsource/js/jquery.timer.js"></script>
<script language="javascript" type="text/javascript"> 


function addTab2(title,url) {
	addTabBase(title,url);
}
function addTab(myobj,url) {
	var title = myobj.innerHTML;
	addTabBase(title,url);
}

function addTabBase(title,url) {
	if ($('#main').tabs('exists', title)) {
		$('#main').tabs('close', title);
	}
	//console.log(url);
	var content = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:99%;"></iframe>';
	$('#main').tabs('add', {
		title : title,
		iconCls : '',
		content : content,
		closable : true
	});
	  //禁止windows自带的右键点击事件
    document.oncontextmenu = function(){return false;};
    //右键点击事件
    $(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});
		var subtitle =$(this).children("span").text();
      $('#main').data("currtab",subtitle);
		return false;
	});
}


$(document).ready(function() {
	//addTab('项目管理','./pro-list.html','icon-user');		//初始化第一个面板
	//$('#main').load("pro-list.html");//初始化中央区域
	if (self != top) {
		top.location = self.location;
	}
	$("#left h3").click(function(){
		$(this).addClass("ll").siblings().removeClass("ll");
		$(this).parent().parent().siblings().each(function(){
			$(this).find(".panel-body h3").each(function(){
				$(this).removeClass("ll");
			});
		});
	})
	tabCloseEven();	
	var auditTodo = '${param.auditTodo}';
	if(auditTodo != null && auditTodo == 'T'){
		var auditType = '${param.auditType}';
		auditType = parseInt(auditType);
		switch(auditType){
			case 3: //会员审核
  				addTabBase('会员认证审核','${ctx}/auditApprove/toMemberAuditList.do');
  				break;
			case 8: //服务费设置审核
  				addTabBase('费用设置审核','${ctx}/feeSet/toFeeSetAudit.do');
  				break;
  			case 9: //资金结算审核
  				addTabBase('资金结算审核','${ctx}/auditApprove/toAuditCashVoucherList.do');
  				break;
			default:
  				break;
		}
	}
	 
});  


function logout(){
	$.messager.confirm('提示', '您确定工作已经保存，并退出该系统?', function(r){
				if (r){					
					 toLogout();
				}
			});
}

function toLogout(){ 			
		var url = '<%=basePathT%>/LogoutServlet'; 
		$.ajax({
						type : "post",
						async : false,
						url : url,
						data : '',
						dataType: "json",
					    success:function(data){
					    	var result = data;//jQuery.parseJSON(data);
					    	if(result.flag=='T'){ 
					    			var main = '<%=basePathT%>/login.jsp';
					    			if(window.parent){
					    				window.parent.location.href = main;  
					    			}else{
					    				window.location.href = main; 
					    			}
						    }else{
					    		$.messager.alert('提交结果', result.msg, 'info');
					    	}    
						},
					    error:function(data){
					    	$.messager.alert('提交结果', 'error', 'error');
					    }
					}); 
}

	//修改密码
	function updatePwd(){
		addTab2('修改密码','uf88/common/update-pwd.do')
	}



function tabCloseEven() {
	
	var defaultTitle = "待办任务";
	//关闭当前
	$('#mm-tabclose').click(function() {
		var tt = $('#main').data("currtab");
		$('#main').tabs('select', tt);
		if (tt == defaultTitle) {
			$.messager.alert('信息提示', "不能关闭默认tab页", 'info', function() {
				return false;
			});
		} else {
			$('#main').tabs('close', tt);
		}
	})
	//全部关闭
	$('#mm-tabcloseall').click(function() {
		var tt = $('#main').data("currtab");
		$('#main').tabs('select', tt);

		$('.tabs-inner span').each(function(i, n) {
			var t = $(n).text();
			if (t != defaultTitle) {
				$('#main').tabs('close', t);
			}
		});
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function() {
		var tt = $('#main').data("currtab");
		$('#main').tabs('select', tt);

		$('.tabs-inner span').each(function(i, n) {
			var t = $(n).text();
			if (t != tt && t != defaultTitle) {
				$('#main').tabs('close', t);
			}
		});
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function() {
		var tt = $('#main').data("currtab");
		$('#main').tabs('select', tt);

		var nextall = $('.tabs-selected').nextAll();
		if (nextall.length == 0) {
			$.messager.alert('信息提示', "右侧没有可以关闭的tab页", 'info', function() {
				return false;
			});
		}
		nextall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			if (t != defaultTitle) {
				$('#main').tabs('close', t);
			}
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function() {
		var tt = $('#main').data("currtab");
		$('#main').tabs('select', tt);

		var prevall = $('.tabs-selected').prevAll();
		if (prevall.length <= 0) {
			$.messager.alert('信息提示', "左侧没有可以关闭的tab页", 'info', function() {
				return false;
			});
		}
		prevall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			if (t != defaultTitle) {
				$('#main').tabs('close', t);
			}
		});
		return false;
	});
}


</script>
	</head>
	<body class="easyui-layout">
		  
			<div id="top" region="north" border="false"  >
				<div class="topbg">
		         	<div >
		                
		               		<img style="margin-left: 10px;margin-top: 15px;display: block;float: left;" src="${ctx}/staticsource/images/admin/logo2.png"/>
		               
		           	</div>
		            <div class="top_weblcom" > 
		               <span >欢迎，<%=auth.getUserName() %>,用户类型：<%=auth.getUsertype() %></span><span class="ser">|</span>
		               <a class="exit" href="javascript:void(0);" onclick="javascript:logout()">退出</a>
		            </div>   
	            </div>
			</div>
		<div region="west" hide="true" split="true" id="p2p-west" style="width:180px; overflow: auto;" title="主菜单" >
			<div class="easyui-accordion" id="left" fit="true" border="false"> 
				<%if(auth.getUsertype().equals("学生")){%>
					<div title="导航菜单" style="overflow: auto;" iconCls="icon-system" >
						<h3 onClick="addTab(this,'${ctx}/stuscore/stuscoreDetailOwner.do');">查看个人成绩</h3>
						<h3 onClick="addTab(this,'${ctx}/stuPingjiaTeacher/stuPingjiaTeacherIndex.do');">填写评价信息</h3>
					</div>
				<%}%>
				<%if(auth.getUsertype().equals("老师")){%>
					<div title="导航菜单" style="overflow: auto;" iconCls="icon-system" >	
					<h3 onClick="addTab(this,'${ctx}/teacher/teacherDetailOwner.do');">查看个人信息</h3>
						<h3 onClick="addTab(this,'${ctx}/teacher/teacherDetailOwner.do');">查看评价信息</h3>
						<h3 onClick="addTab(this,'${ctx}/stuscore/stuscoreIndex.do');">查看学生成绩</h3>
					</div>
				<%}%>
				<%if(auth.getUsertype().equals("领导")){%>
					<div title="导航菜单" style="overflow: auto;" iconCls="icon-system" >							
						<h3 onClick="addTab(this,'${ctx}/stuscore/stuscoreIndex.do?uflag=99');">学生成绩查询</h3>
						<h3 onClick="addTab(this,'${ctx}/teacherscore/teacherscoreIndex.do?uflag=99');">教师成绩查询</h3>
						<h3 onClick="addTab(this,'${ctx}/stuscore/stuscoreSum.do');">学生成绩统计</h3>
						<h3 onClick="addTab(this,'${ctx}/teacherscore/teacherscoreSum.do');">教师成绩统计</h3> 
					</div>
				<%}%>
				
				<%if(auth.getUsertype().equals("管理员")){%>
					<div title="学生管理" style="overflow: auto;" iconCls="icon-system" >	 		 
						<h3 onClick="addTab(this,'${ctx}/student/studentIndex.do');">学生管理</h3> 
					</div>
					<div title="教师管理" style="overflow: auto;" iconCls="icon-system" >	 		 
						<h3 onClick="addTab(this,'${ctx}/teacher/teacherIndex.do');">教师管理</h3> 
					</div>
					<div title="评价管理" style="overflow: auto;" iconCls="icon-system" >			 
						<h3 onClick="addTab(this,'${ctx}/question/questionIndex.do');">评价管理</h3> 
					</div>
					<div title="成绩管理" style="overflow: auto;" iconCls="icon-system" >	 		 
						<h3 onClick="addTab(this,'${ctx}/stuscore/stuscoreIndex.do');">学生成绩管理</h3>
						<h3 onClick="addTab(this,'${ctx}/teacherscore/teacherscoreIndex.do');">教师成绩管理</h3> 
						<h3 onClick="addTab(this,'${ctx}/stuscore/stuscoreSum.do');">学生成绩统计</h3>
						<h3 onClick="addTab(this,'${ctx}/teacherscore/teacherscoreSum.do');">教师成绩统计</h3>  
					</div>
					<div title="课程管理" style="overflow: auto;" iconCls="icon-system" >			 
						<h3 onClick="addTab(this,'${ctx}/subjects/subjectsIndex.do');">课程管理</h3> 
					</div>
					<div title="系部管理" style="overflow: auto;" iconCls="icon-system" >			 
						<h3 onClick="addTab(this,'${ctx}/club/clubIndex.do');">系部管理</h3> 
					</div>
					<div title="年级管理" style="overflow: auto;" iconCls="icon-system" >			 
						<h3 onClick="addTab(this,'${ctx}/grade/gradeIndex.do');">年级管理</h3> 
					</div>
					<div title="班级管理" style="overflow: auto;" iconCls="icon-system" >			 
						<h3 onClick="addTab(this,'${ctx}/classInfo/classInfoIndex.do');">班级管理</h3> 
					</div>
				<%}%>
 
		</div>
	</div>
	<div region="center" title="" style="overflow: auto;" >
		<div id="main" class="easyui-tabs" fit="true"  border="false" style="background:#fff;">
			<div class="main" title="欢迎" style="position:relative; background:#fff;">
  				<div class="welcomeBg">
  					
  				</div>
			</div>
		</div>
	</div>
    <div region="south" border="false" class="bottom" style="background:#385390;">
    </div>
    <div id="ccc" region="center" title="">
		<div id="main"></div>
	</div>
	<div id="mm" class="easyui-menu" style="width: 150px;">
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
	</div>
	</body>
</html>
