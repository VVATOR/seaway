<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="m" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 
<link rel="stylesheet" type="text/css" href="static/styles/style.css" />
<script src="static/field_random.js"> </script>


</head>
<body>
	<m:menu-top/>

	<h1>Dashboard</h1>
	
	
	${user.id}-**${current_user}**
		<button type="button" onclick="showNewOffers();">Click Me!</button>

	<div class="panel">
		<div id="list-players">
			<div class="panel">
				<div class="panel-header">Gamers list:</div>
				<c:forEach items="${listPlayers}" var="player">
					<div class="player-item">${player.login}					
						<form action="OfferController"  method="post">
							<input type="hidden" name="player1" value="${player.id}" />	
							<input type="hidden" name="player2" value="${current_user.id}" />								
						 	<input type="submit" name="action" value="CREATE_WAIT"/>
						</form>
					</div>
				</c:forEach>
			</div>
		</div>
		
		<div class="flow" />

		<div id="list-player-games-history"> 
			<div class="panel">
				<div class="panel-header">Your Games history list:</div>
				<c:forEach items="${listGamesHistory}" var="game">
					<div class="player-item">${game}</div>
				</c:forEach>
			</div>
		</div>
		
		<div class="flow" />
		
		<div id="list-battle-offers">
			<div class="panel">
				<div class="panel-header">Battle offers list:</div>
				<c:forEach items="${listBattleOffirs}" var="offer">
					<div class="player-item">${offer.id} 
					<form action="OfferController"  method="post">
						<input type="hidden" name="game" value="${offer.id}" />	
					    <input type="submit" name="action" value="VERIFY"/>
						<input type="submit" name="action" value="REJECT"/>
					</form>
					
					</div>
				</c:forEach>
			</div>
		</div>		
		
		<div class="flow" />
		
		<div id="list-battles-active">
			<div class="panel">
				<div class="panel-header">Battle active list:</div>
				<c:forEach items="${listActiveGames}" var="game">
					<div class="player-item">${game.id} 
					<form action="OfferController"  method="post">
<%-- 						<input type="hidden" name="userId" value="${current_user.id}" />	 --%>
						<input type="hidden" name="game" value="${game.id}" />	
					    <input type="submit" name="action" value="PLAY"/>		
					    <input type="submit" name="action" value="SURRENDER"/>							    				
					</form>					
					</div> 
				</c:forEach>
			</div>
		</div>		
	</div>
</body>
</html>