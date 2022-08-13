<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flyaway Portal</title>
<style>
table, th, td {
  border:1px solid black;
}
</style>
</head>
<center>
<body style="background-color:Aqua;">
<h1>FlyAway (An Airline Booking Portal)</h1>
<table style="width:50%">

<form method=post action="Get_Data">
<tr>
<td><h3>Enter source: </h3></td> <td><input type="text" name="source" required></td><br />
</tr>
<tr>
<td><h3>Enter destination:</h3></td> <td><input type="text" name="destination" required></td><br />
</tr>
<tr>
<td><h3>Enter date:</h3></td> <td><input type="date" name="date" value="01-01-2000" required></td><br />
</tr>




</table>
<p>
<p>
<input type="submit" value="Submit"><br>
</form>
<a href="Login.jsp">Click Here to Admin Page</a>
</body>
</center>

</html>