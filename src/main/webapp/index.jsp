<%@ taglib prefix="bs" uri="http://efsavage.com/twitter-bootstrap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<form action="<c:url value="/login"/>" method="post">
<div>Login</div>
<div>
	<label>Username</label>
	<input name="username" type="text"/>
</div>
<div>
	<label>Password</label>
	<input name="password" type="password"/>
</div>
<div>
	<button name="login" type="submit">Login</button>
</div>
</form>
</body>
</html>
