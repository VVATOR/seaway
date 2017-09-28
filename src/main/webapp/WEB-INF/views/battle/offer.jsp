<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Offer to buttle</title>
</head>
<body>

	<h1>Offer to battle</h1>
	
	
	<form action="OfferController" method="get">		
		<input type="hidden" name="game" value="${game}" />	
	    <input type="submit" name="action" value="verify"/>
		<input type="submit" name="action" value="reject"/>
	</form>


</body>
</html>