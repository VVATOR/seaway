<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

${message}
<hr />


	<h1>Authorisation</h1>
	<form action="LoginController" method="post">
		<input type="text" name="login" /> 
		<input type="password"	name="password" />
		<input type="submit" value="sign in"  class="btn"/>
	</form>


<a href="registration.jsp">Registration</a>

</body>
</html>