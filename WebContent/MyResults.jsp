<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-color: #34D7B3;
font-weight: bold;
}
h2{
background-color: black;
color: #34D7B3;
padding: 30px;
margin: 0px;
text-align: center;
}
table{
width: 50%;
margin: auto;
text-align: center;
margin-top: 40px;
}
th{
background-color: black;
color: #34D7B3;
padding: 10px;
font-size: 1.2em;
margin-bottom: 15px;
}
td{
font-size: 1.1em;
border-bottom: 1px solid black;
padding: 10px;
}
</style>
</head>
<body>
<h2>RESULTS</h2>
<table>

<tr>
<th>QUIZ NAME</th>
<th>MARKS SCORED</th>
</tr>

<% ArrayList<Integer> marks = (ArrayList<Integer>)request.getAttribute("marks"); %>
<% ArrayList<String> quiznames = (ArrayList<String>)request.getAttribute("quiznames"); %>

<% int i = 0; %>

	<% for(String quiz : quiznames) 
    { %>
    	
    	<tr>
    	<td> <%= quiz %> </td>
    	<td> <%= marks.get(i) %> </td>
    	</tr>
    	
    	<% i++; %>
    <%} %>

</table>
</body>
</html>