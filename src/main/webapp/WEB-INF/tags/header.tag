<%@ tag language="java" pageEncoding="UTF-8"%>


${current_user.login}
<form action="LogoutController" method="post">
	<input type="submit" value="logout" class="btn"/>
</form>
