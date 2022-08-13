<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
  border:1px solid black;
}
</style>
</head>
<body style="background-color:Aqua;">
<center>
<table style="width:60%">

<form method=post action="Details">
<tr>
<h3>Selected Airline: <%=session.getAttribute("airline") %></h3>
</tr>
<tr>
<td>Enter Firstname:</td> <td> <input type="text" name="fname" required></td><br/>
</tr>
<tr>
<td>Enter Lastname:</td> <td> <input type="text" name="lname" required></td><br/>
</tr>
<tr>
<td>Enter DOB:</td> <td> <input type="date" name="dob" required></td><br/>
</tr>
<tr>
<td>Enter Gender:</td> <td> <input type="radio" name="gender" value="male"> Male <input type="radio" name="gender" value="female"> Female <input type="radio" name="gender" value="other"> Other </td><br>
</tr>
<tr>
<td>Enter Contact:</td> <td> <input type="number" name="contact" required></td><br/>
</tr>
<tr>
<td>Enter MailID:</td> <td> <input type="text" name="mail" required></td><br/>
</tr>
</table>
<% String b = request.getParameter("airline");

session.setAttribute("airline",b);
String a = request.getParameter("nop");
session.setAttribute("nop",a);%>
<input type="submit" value="Submit">
</form>
</center>
</body>
</html>