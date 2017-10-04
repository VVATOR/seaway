<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" tagdir="/WEB-INF/tags" %>



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="static/styles/style-battlefield.css"/>
<link rel="stylesheet" type="text/css" href="static/styles/style.css" />
<script src="static/field_random.js"></script>
</head>
<body>

<m:menu-top/>
<button type="button" onclick="inactivateCheckboxes();">inactivateCheckboxes!</button>

<button type="button" onclick="activateCheckboxes();">activateCheckboxes!</button>

<button type="button" onclick="fillFieldRandom(10);">random set the ships !</button>


	<h1>Create field</h1>

table>(tr>td*10)*10

table>(tr>(td>input[type="checkbox" name="$""])*10)*10

table>(tr>(td>input[type="checkbox" name="item-$"])*10)*10


<form action="BattleController" method="post">
	<table>
		<thead>
		<th></th>
		<c:forEach begin="1" end="10" varStatus="colH">
			<th>${colH.index}</th>
		</c:forEach>
		</thead>
		<tbody>
				<c:forEach begin="1" end="10" varStatus="row">
				  	<tr>
				  		<c:forEach begin="1" end="10" varStatus="column">
				  			<c:if test="${column.index eq 1}">
								<td>&#${row.index+96};</td>
							</c:if>
							<td>
				<input type="checkbox" name="fill"  class="checkbox field-position" value="${row.index*10 + column.index}" id="item-${row.index}-${column.index}" />
<%-- 				${row.index*10 + column.index} --%>
				<label for="item-${row.index}-${column.index}" />
				
	<%-- 			<td><input type="checkbox" name="item-${row.index}-${column.index}" />item-${row.index}-${column.index} </td> --%>			
				</td>
			</c:forEach>
		</tr>
	</c:forEach>
	</table>					
	<input type="hidden" name="action" value="PLAY"/>
	<input type="hidden" name="userId" value="${current_user.id}"/>
	<input type="hidden" name="game" value="${game}"/>${game}	
	<input type="submit" value="PLAY"/>
</form>
			





</body>
</html>