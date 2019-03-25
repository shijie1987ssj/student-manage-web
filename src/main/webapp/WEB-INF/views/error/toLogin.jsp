<%@ page contentType="text/html;charset=UTF-8"%> 
<%@page import="com.uf88.admin.utils.Auth"%> 
<%@page import="com.uf88.admin.utils.AuthTools"%> 
<%
Auth loginUserT = AuthTools.getAuth(request);// AuthTools.getLoginUser(request);
String pathT = request.getContextPath();
String basePathT = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ pathT + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/import.jsp" %>
<script> 
    $(function () { 
	  	var msg = '${msgtxt}';
	  	if(msg!='')
	  		alert(msg);
		var url = '<%=login_url%>';
		
		if (!(window.parent.parent == window)
				&& !(window.parent.parent == window.parent)) {
			window.parent.parent.location.href = url;
		} else if (!(window.parent.parent == window)) {
			window.parent.location.href = url;
		} else {
			window.location.href = url;
		}

	});
</script>

</head>
<body style="background: #fff;">
</body>
</html>
