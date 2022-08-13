<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin login portal</title>
<style>
table, th, td {
  border:1px solid black;
}
</style>
</head>
<body style="background-color:Aqua;">
<center>
<table>
<form method=post action="Admin_Servlet">
<h1>Admin Login Page</h1>
<tr>
<td>Enter userid:</td> <td> <input type="text" name="userid" required></td><br>
</tr>
<tr>
<td>Enter Password:</td> <td> <input type="password" name="pword" required></td><br>
</tr>

</table>
<p>
<p>
<input type="submit" value="Submit">
</form>
</center>
</body>
</html>