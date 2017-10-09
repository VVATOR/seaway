<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="m" tagdir="/WEB-INF/tags"%>



<div class="menu-top">
	<ul>
		<li><div>User: ${current_user.login}</div></li>
		<li>
			<form action="CommandController" method="post">
				<input type="submit" name="action" value="LOGOUT" class="btn" />
			</form>
	    </li>
	    <li>User: ${current_user.login}</li>
	</ul>


	
</div>