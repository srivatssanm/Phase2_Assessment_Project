<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList" import="java.util.List" import="java.util.Iterator"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Details</title>


</head>
<body style="background-color:Aqua;">
<center>
<h2>Flights Available</h2>
<table border=2 >
            <thead>
                <tr>
                    <th>Airline</th>
                    <th>Price</th>
                    
                </tr>
            </thead>
            
            <tbody>
                <c:forEach items="${details}" var="i">
                <tr>
                    <td>${i.key}</td>
                    <td>${i.value}</td>
                    
                </tr>
                </c:forEach>   
            </tbody>
        </table>
        <p><br>
        <p>
        
        <form method=post action="Airline_valid">
<p>Enter Airline: <input type="text" name="airline" required></p><br>
<p>No. of Persons: <input type="number" name="nop" required></p><br>

<input type="submit" value="Submit">


</form>
</center>
</body>
</html>