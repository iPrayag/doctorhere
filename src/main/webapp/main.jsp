<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<html>
<body>
<!-- 
<h1>welcome ${name}</h1>
 -->
<h1>welcome <%= request.getAttribute("name") %>.</h1>
<a href="/doctorhere/logout">Logout</a>
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
