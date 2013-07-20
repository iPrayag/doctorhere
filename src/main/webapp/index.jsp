<%@ taglib prefix="bs" uri="http://efsavage.com/twitter-bootstrap" %>
<html>
<body>
<form action="/doctorhere/login" method="post">
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
	<bs:button size="large" name="login" type="submit" style="primary">Login</bs:button>
</div>
</form>
</body>
</html>
