<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" tagdir="/WEB-INF/tags" %>



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<m:menu-top/>


	<h1>Create field</h1>

table>(tr>td*10)*10

table>(tr>(td>input[type="checkbox" name="$""])*10)*10

table>(tr>(td>input[type="checkbox" name="item-$"])*10)*10


<form action="BattleController" method="post">
	<table>
	<c:forEach begin="0" end="10" varStatus="row">
	  	<tr>
			<c:forEach begin="0" end="10" varStatus="column">
				<td><input type="checkbox" name="fill" value="${row.index*10 + column.index}" />${row.index*10 + column.index}</td>
	<%-- 			<td><input type="checkbox" name="item-${row.index}-${column.index}" />item-${row.index}-${column.index} </td> --%>			
			</c:forEach>
		</tr>
	</c:forEach>
	</table>					
	<input type="hidden" name="action" value="BATTLE_CREATE"/>
	<input type="hidden" name="game" value="${game}"/>${game}
	<input type="hidden" name="userPlay" value="${current_user.id}"/>
	<input type="submit" value="PLAY"/>
</form>
			





</body>
</html>