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
margin-bottom: 20px;
}
#but1{
background-color: black;
color: white;
padding: 20px;
border-radius: 15px;
cursor: pointer;
width: 20%;
font-weight: bold;
margin-left: 40%;
text-align: center;
}
#but1:hover{
background-color: white;
color:black;
}
#card{
background-color: black;
color: white;
width: 40%;
margin: auto;
padding: 40px;
border: 4px solid white;
}
</style>
</head>
<body>
<h2>${quizname}</h2>

<form action="ResultProcess" method="POST">
<% ArrayList<Integer> qid = (ArrayList<Integer>)request.getAttribute("qid"); %>
<% ArrayList<String> questions = (ArrayList<String>)request.getAttribute("questions"); %>
<% ArrayList<String> opa = (ArrayList<String>)request.getAttribute("opa"); %>
<% ArrayList<String> opb = (ArrayList<String>)request.getAttribute("opb"); %>
<% ArrayList<String> opc = (ArrayList<String>)request.getAttribute("opc"); %>
<% ArrayList<String> opd = (ArrayList<String>)request.getAttribute("opd"); %>
<% int i = 0; %>

	<% for(String ques : questions) 
    { %>
    	<div id="card">
    	<p>Q<%= i+1 %>. <%= ques %> </p><br>
    	<p><input type="radio" name="<%= qid.get(i) %>" value="A">A. <%= opa.get(i) %></p>
    	<p><input type="radio" name="<%= qid.get(i) %>" value="B">B. <%= opb.get(i) %></p>
    	<p><input type="radio" name="<%= qid.get(i) %>" value="C">C. <%= opc.get(i) %></p>
    	<p><input type="radio" name="<%= qid.get(i) %>" value="D">D. <%= opd.get(i) %></p>
    	<br>
    	</div>
    	
    	<% i++; %>
    <%} %>

<br>
<input type="text" value="${quizname}" style="display: none;" name="quizname">
<input type="submit" value="Submit Quiz" id="but1">
</form>

</body>
</html>