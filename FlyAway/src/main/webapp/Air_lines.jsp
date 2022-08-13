<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="java.util.ArrayList"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Airlines</title>
</head>
<body style="background-color:lightgreen;">
<%
	@SuppressWarnings("unchecked")
	List<String> flights=(List<String>)session.getAttribute("flight");
	if(flights!=null){
%>



<center>
<h1 >List of Airlines</h1>
<table border="2">
<tr>
	<th>Airlines</th>
	
	
</tr>



<%
	for(String flight:flights){
%>

<tr>
<td><%=flight%></td>


</tr>

</center>

<%
	}
%>

</table>
<%
	}
	else{
	
%>

		<h2>Nothing</h2>
		<%
	}
	%>

</body>
</html>