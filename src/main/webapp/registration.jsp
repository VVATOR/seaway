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


	<h1>Registration</h1>


	<form action="RegistrationController" method="post">

		<input type="text" name="login" /> 
		<input type="password" name="password" /> 
		<input type="text" name="name" /> 	
		<input type="submit" value="create account" />
	</form>

	<a href="authorisation.jsp">Sign in</a>


</body>
</html>