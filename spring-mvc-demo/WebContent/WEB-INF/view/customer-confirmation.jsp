<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>

	<title> Customer Confirmation Page</title>
</head>

<body>

The Customer is confirmed as : ${customer.firstName} ${customer.lastName}

<br><br>

The number of Free Passes is : ${customer.freePasses }

<br><br>

Postal Zip Code is : ${customer.postalCode }

<br><br>

Course Code is : ${customer.courseCode }

</body>






</html>