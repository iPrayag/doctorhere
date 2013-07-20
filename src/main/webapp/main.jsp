<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="bs" uri="http://efsavage.com/twitter-bootstrap" %>
<html>
<body>

<div> 
<h3>welcome ${name}</h3>
<a href="/doctorhere/logout">Logout</a>
</div>

<form action="/doctorhere/problem" method="post">
<div>
    <label>Problem Title</label>
	<input name="title" type="text"/>
</div>

<div>
    <label>Description</label>
	<input name="description" type="text"/>
</div>

<div>
    <label>tag</label>
	<input name="tag" type="text"/>
</div>
<div>
	<input name="post" type="submit" value="Post"/>
</div>
</form>

</body>
</html>
