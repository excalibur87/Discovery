<html>
<head>
<title>Interstellar</title>
<script src="js/jquery.min.js"></script>
<script src="js/fucntions.js"></script>
</head>
<body onload="loadData()">

	<div align="center">
		<h1>Welcome to my Interstellar System</h1>
		<h2>You are currently on Earth, choose a destination below</h2>
		<form action="route" method="post">
			<select id="sel_planet" name="sel_planet">
				<option value="0">- Select -</option>
			</select>
			<br/>
			<br/>
			<button type="submit" value="Submit">Submit</button>
		</form>
	</div>
</body>
</html>