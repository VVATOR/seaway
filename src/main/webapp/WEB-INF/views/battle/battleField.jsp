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
<body onload="addListener()">
 
<%-- <m:surrender/> --%>
<m:menu-top/>
<button type="button" onclick="inactivateCheckboxes();">inactivateCheckboxes!</button>
<button type="button" onclick="activateCheckboxes();">activateCheckboxes!</button>
<button type="button" onclick="listener();">activateCheckboxes!</button>

	<h1>BATTLE field</h1>

<input type="text" id="gameId" value="${game}"/>
<input type="text" id="current_user" value="${current_user.id}"/>

table>(tr>(td>input[type="checkbox" name="item-$"])*10)*10


Enemy
<table>
	<thead>
		<tr>
			<th>ENEMY</th>
			<th width="100px"></th>
			<th>YOUR</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
				<form action="" method="post">
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
								<input type="checkbox" class="checkbox field-position" id="item-${row.index * 10 + column.index}" 
								value="${row.index * 10 + column.index}"
								/>
								<label for="item-${row.index * 10 + column.index}"/>
							</td>
							<%-- <td><input type="checkbox" name="item-${row.index}-${column.index}" />item-${row.index}-${column.index} </td> --%>			
						</c:forEach>
					</tr>
				</c:forEach>
				</tbody>
				</table>					
<!-- 				<input type="hidden" name="action" value="PLAY"/> -->
<%-- 				<input type="hidden" name="game" value="${game.id}"/> --%>
<%-- 				<input type="hidden" name="user" value="${current_user.id}"/> --%>
<!-- 				<input type="submit" value="PLAY"/> -->
				</form>
			</td>
			<td></td>
			<td>
					<form action="" method="post">
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
<%-- 							<input type="checkbox" name="item-${row.index}-${column.index}" /> --%>
							<input type="checkbox" class="checkbox field-position" id="checkbox-item-${row.index * 10 + column.index}" />
							<label for="checkbox-item-${row.index * 10 + column.index}"/>
			 				</td>
				<%-- 			<td><input type="checkbox" name="item-${row.index}-${column.index}" />item-${row.index}-${column.index} </td> --%>			
						</c:forEach>
					</tr>
				</c:forEach>
				</table>					
				</form>
			</td>
		</tr>
	</tbody>
</table>


</body>
</html>