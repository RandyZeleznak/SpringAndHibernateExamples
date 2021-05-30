<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<title> ZSquared Security Demo Home Page</title>
</head>

<body>

	<h2>         ZSquared Security Demo Home Page</h2>
	<hr>
		<p>
			Welcome to the ZSquared Security Demo Home Page!
		</p>
		
		<!--    Add a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
			<input type="submit" value="logout"/>
		
		</form:form>
		
		
		

</body>

</html>