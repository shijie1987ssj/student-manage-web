<%@page import="com.uf88.admin.web.AdminConst.AdminConst"%> 
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.uf88.uf88core.util.StrUtil"%>
<%@ page import="com.uf88.admin.utils.AuthTools"%>
<%@ page import="com.uf88.admin.utils.Auth"%>    
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			Auth loginUser = AuthTools.getAuth(request);// AuthTools.getLoginUser(request);

			String appUrl = request.getParameter("appUrl");
			if (appUrl == null) {
				appUrl = "";
			}
			if (loginUser != null && appUrl == "") {
				response.sendRedirect(basePath + "/index.do");
			} else if (loginUser != null && appUrl != "") {
				response.sendRedirect(appUrl);
			} 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<title></title>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/meta.jsp"%>
<link rel="shortcut icon" href="${ctx}/favicon.ico" />
<link rel="stylesheet" href="${ctx }/staticsource/css/user/login.css"
	type="text/css" />
<link rel="stylesheet"
	href="${ctx }/staticsource/plugins/widget/css/widget-common.css"
	type="text/css" />
<!-- js import -->
<script type="text/javascript"
	src="${ctx}/staticsource/js/easyui-1.4.5/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="${ctx}/staticsource/js/jquery.form.js"></script>
<script type="text/javascript" src="${ctx}/staticsource/js/md5.js"></script>
 
<script type="text/javascript">
    var lno = ''; 
    var isUseUkey = false;
    var p2p_ctx = '<%=basePath %>' ;
    
	$(function() {
		if (self != top) {
			window.parent.location.href = "${ctx}";
			return;
		}
		$('#inputForm').attr("action", basePath + '/LoginServlet');
		$('#yzm').attr("src", basePath + '/common/image.jsp');
		$('#uname').blur(function() {
			//过滤用户名前后空格
			var uname = $("#uname").val();
			$("#uname").val(strTrim(uname));
		});

		$(".needSubmit").each(function(i) {
			$(this).bind('keypress', function(event) {
				if (event.keyCode == "13") {
					doSubmit();
				}
			});
		});
	});
	function strTrim(str) {
		return str.replace(/(^\s*)|(\s*$)/g, "");
	}
	function enterSubmit(frm, event) {
		var event = window.event ? window.event : event;
		if (event.keyCode == 13) {
			doSubmit();
		}
	}

	function doSubmit() {
		var userNameStr = $("#uname").val();
		if (userNameStr == "") {
			alert("请输入用户名。");
			$("#uname").focus();
			return;
		} else if ($("#upass").val() == "") {
			alert("请输入密码。");
			$("#upass").focus();
			return;
		} else {
			$("#username").val(userNameStr);
			$("#loginSubmit").removeAttr('onclick');
			var pass = $("#upass").val();

			var passwdTmp = pass.md5();
			$("#md5Pass").val(passwdTmp);
			
			var uflagV = $("#uflagShow").val();
			$("#uflag").val(uflagV);
 
			submitPageForm(); 
		}
	}

	function submitPageForm() { 
		var url = '${ctx}/LoginServlet';
		
		$("#inputForm").ajaxSubmit({
			url : url,
			type : "post",
			dataType : "json",
			success : function(data, textStatus, jqXHR) {
				var result = data;
				if (result.flag == 'T') {
					var appUrl = $("#appUrl").val();
					if (appUrl != "") {
						window.location.href = appUrl;
					} else {
						var main = p2p_ctx + 'index.do';
						window.location.href = main;
					}
				} else {
					alert(result.msg);
					$("#loginSubmit").click(function() {
						doSubmit();
					});
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('与服务器通信失败!');
				$("#loginSubmit").click(function() {
					doSubmit();
				});
			}
		});
	}
</script> 
</head>
<body>
	<div id="wrap">
		<!--头部 start-->
		<div id="top">
			<%@include file="/common/user/top.jsp"%>
		</div>
		<!--头部 end-->
		<!--主体 start-->
		<div class="login_main2">
			<div class="login_box" style="position: relative">
				<form id="inputForm" name="inputForm" method="post">  
					<input type="hidden" name="appUrl" id="appUrl" value="<%=appUrl%>" />
					<input type="hidden" name="password" id="md5Pass" value="" /> 
					<input type="hidden" name="uflag" id="uflag" value="" /> 
					<a style="position: absolute; top: 96px; display: block; left: 440px; cursor: pointer; margin-left: 10px; border: 0; text-indent: 0; width: 50px; height: 36px; line-height: 36px; text-align: center; border-radius: 3px; color: #0000FF; font-size: 14px; display: none;"	href="javascript:window.location.reload();" id="reflush">刷新</a>
					<ul class="login_ul">
						<li class="name_input">
							 <input type="text" class="input"
							id="uname" name="uname"
							onkeyup="this.value=this.value.replace(/[, ]/g,'')"
							onpaste="this.value=this.value.replace(/[, ]/g,'')"
							ondrop="this.value=this.value.replace(/[, ]/g,'')" tabindex="1"
							placeholder="用户名" />  <input type="hidden" id="username"
							name="username" />
						</li>
						<li class="line"></li>
						<li class="pass_input"><input type="password"
							onpaste="return false" ondrop="return false;"
							oncontextmenu="return false;" autocomplete="off" class="input"
							id="upass" name="userPass" tabindex="2" placeholder="密码"
							onkeydown='enterSubmit(this.form,event)' />
							<select id="uflagShow" tabindex="3">
								<option value="1">学生</option>
								<option value="2">教师</option>
								<option value="3">领导</option>
								<option value="4">后台管理</option>
							</select> 
							</li>
						<li class="line"></li> 
						<li class="pad28"> 
							<a href="javascript:;" class="loginSubmit enableClass"
							onclick="doSubmit()" id="loginSubmit" tabindex="4">登<span
								style="padding-left: 20px;">录</span></a>
								</li>
					</ul>
				</form>
			</div>
		</div>
		<div id="bottom">
			<%@include file="/common/user/bottom.jsp"%>
		</div>
	</div> 
</body>
</html>
