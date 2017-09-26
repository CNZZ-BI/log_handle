<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script type="text/javascript">
$(function(){
	$("#login").click(function(){
		$.post({
			url:"${pageContext.request.contextPath}/sysadmin/login.do",
			data:$("form").serialize(),
			success:function(data){
				alert(data);
			}
			
			
			
			
		});
		
		

		
	});
});

</script>


</head>
<body>
	<form  method="post">
		用户名：<input  name="username" type="text"/> <br/><br/><br/>
		密码：	<input name="password" type="password"/><br/><br/><br/>
		<input id="login" type="button" value="login"/>
	</form>
	
</body>
</html>