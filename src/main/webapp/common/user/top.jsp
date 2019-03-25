<%@page import="com.uf88.admin.utils.Auth"%> 
<%@page import="com.uf88.admin.utils.AuthTools"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% 
Auth loginUserT = AuthTools.getAuth(request);// AuthTools.getLoginUser(request);
String pathT = request.getContextPath();
String basePathT = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ pathT + "/";
long messageCount = 0; //SysMessageHelper.getInstance().getCountByUserId(auth.getUserId());
%>
 <div class="top">
   <%-- <p class="logo"><img src="${ctx}/staticsource/images/login/logo.jpg" /></p> --%>
  </div>
  <script type="text/javascript">
function logout(){
	if (confirm('您确定工作已经保存，并退出该系统?')){					
		var url = '<%=basePathT%>${ctx}/LogoutServlet'; 
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
}
</script>