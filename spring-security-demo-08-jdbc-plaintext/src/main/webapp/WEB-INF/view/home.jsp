<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>	
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
		
		<hr>
		
		<!--  Display username and role -->
		<p>
			User: <security:authentication property="principal.username"/>
			<br><br>
			Role(s): <security:authentication property="principal.authorities"/>
		</p>
		<hr>
		
		<security:authorize access="hasRole('MANAGER')">
		<!--  Add a link to point to /leaders for managers -->
		<p>
		<a href="${pageContext.request.contextPath}/leaders"> Leadership meeting</a>
		             (Only for Managers)
		
		</p>
		</security:authorize>
		
		<hr>
		
		
		<security:authorize access="hasRole('ADMIN')">
		<!--  Add a link to point to /systems for admins -->
		<p>
		<a href="${pageContext.request.contextPath}/systems"> IT Admin meeting</a>
		             (Only for Admins)
		
		</p>
		</security:authorize>
		
		<hr>
		
		<!--    Add a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
			<input type="submit" value="logout"/>
		
		</form:form>
		
		
		

</body>

</html>