<%@ tag language="java" pageEncoding="UTF-8"%>


<form action="CommandController" method="post">
	<input type="submit" name="action" value="SURRENDER" class="btn"/>	
<%-- 	<input type="hidden" name="userId" value="${current_user.id}" />	 --%>
	<input type="hidden" name="game" value="${game.id}" />	
</form>
