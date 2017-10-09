<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="static/styles/style.css" />
<script src="static/field_random.js">
	
</script>

</head>
<body onload="statusEnymyFieldFill()">

	<h1>wait of the enimy...</h1>


	<input type="text" id="enemyId" value="${enemy.id}" />
	<input type="text" id="gameId" value="${param.game}" />
	<input type="text" id="current_user" value="${current_user.id}" />


${enemy.login}

	<div id="content">
		<img src="./static/images/loader.gif" alt="wait of the enimy..." />
	</div>
</body>
</html>