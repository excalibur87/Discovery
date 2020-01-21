<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Interstellar</title>
</head>
<body>

	<div align="center">
		<h1>Welcome to my Interstellar System</h1>
		<h2>The fastest path to ${destination} is:</h2>
		<table style="width: 80%; text-align: center;" >

			<tr>
				<th style="width: 10%">Origin</th>
				<th style="width: 80%">Path</th>
			</tr>

			<c:forEach items="${path}" var="route">
				<tr>
					<td><c:out value="${origin}" /></td>
					<td><c:out value="${route.pName}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>