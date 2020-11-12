<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#quiz{
display:none;
}
#marks{
display:none;
}
body{
background-color: #34D7B3;
}
h1{
background-color: black;
color: #34D7B3;
padding: 30px;
margin: 0px;
text-align: center;
}
#but1, #but2{
background-color: black;
color: white;
padding: 15px;
border-radius: 15px;
cursor: pointer;
width: 30%;
font-size: 1.2em;
font-weight: bold;
}
#but1:hover, #but2:hover{
background-color: white;
color:black;
}
#sub{
background-color: black;
color: white;
padding: 10px;
border-radius: 10px;
cursor: pointer;
width: 20%;
font-weight: bold;
}
#sub:hover{
background-color: white;
color:black;
}
#buttons{
margin-top: 30px;
text-align: center;
}
#quiz{
width: 90%;
margin: auto;
margin-top: 30px;

}
#ip{
padding: 20px;
margin-top: 5px;
margin-bottom: 5px;
border: none;
border-radius: 10px;
width: 45%;
}

#marks{
width: 50%;
margin: auto;
}

table{
width: 100%;
text-align: center;
margin-top: 40px;
font-weight: bold;
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

<script>

function showQuiz(){
	ele1 = document.getElementById("quiz");
	ele2 = document.getElementById("marks");
	
	ele1.style.display="block";
	ele2.style.display="none";
}


function showMarks(){
	ele1 = document.getElementById("quiz");
	ele2 = document.getElementById("marks");
	
	ele1.style.display="none";
	ele2.style.display="block";
}

</script>

<h1>Welcome Admin ${name}</h1>
<div id="buttons">
<button onclick="showQuiz()" id="but1">Create a new Quiz</button>
<button onclick="showMarks()" id="but2">View Marks</button><br>
</div>

<div id="quiz">
<form action="CreateQuizProcess" method="POST">
<input type="text" name="quiztitle" placeholder="Give Your Quiz a Name" id="ip"><br><br>

<input name = "q1" type="text" placeholder="Enter Question 1..." id="ip"><br>
<input name = "opa1" type="text" placeholder="Enter Option A" id="ip">
<input name = "opb1" type="text" placeholder="Enter Option B" id="ip">
<input name = "opc1" type="text" placeholder="Enter Option C" id="ip">
<input name = "opd1" type="text" placeholder="Enter Option D" id="ip">
<input name = "ans1" type="text" placeholder="Enter Correct Option in terms of A,B,C,D" id="ip"><br><br>

<input name = "q2" type="text" placeholder="Enter Question 2..." id="ip"><br>
<input name = "opa2" type="text" placeholder="Enter Option A" id="ip">
<input name = "opb2" type="text" placeholder="Enter Option B" id="ip">
<input name = "opc2" type="text" placeholder="Enter Option C" id="ip">
<input name = "opd2" type="text" placeholder="Enter Option D" id="ip">
<input name = "ans2" type="text" placeholder="Enter Correct Option in terms of A,B,C,D" id="ip"><br><br>

<input name = "q3" type="text" placeholder="Enter Question 3..." id="ip"><br>
<input name = "opa3" type="text" placeholder="Enter Option A" id="ip">
<input name = "opb3" type="text" placeholder="Enter Option B" id="ip">
<input name = "opc3" type="text" placeholder="Enter Option C" id="ip">
<input name = "opd3" type="text" placeholder="Enter Option D" id="ip">
<input name = "ans3" type="text" placeholder="Enter Correct Option in terms of A,B,C,D" id="ip"><br><br>

<input name = "q4" type="text" placeholder="Enter Question 4..." id="ip"><br>
<input name = "opa4" type="text" placeholder="Enter Option A" id="ip">
<input name = "opb4" type="text" placeholder="Enter Option B" id="ip">
<input name = "opc4" type="text" placeholder="Enter Option C" id="ip">
<input name = "opd4" type="text" placeholder="Enter Option D" id="ip">
<input name = "ans4" type="text" placeholder="Enter Correct Option in terms of A,B,C,D" id="ip"><br><br>

<input name = "q5" type="text" placeholder="Enter Question 5..." id="ip"><br>
<input name = "opa5" type="text" placeholder="Enter Option A" id="ip">
<input name = "opb5" type="text" placeholder="Enter Option B" id="ip">
<input name = "opc5" type="text" placeholder="Enter Option C" id="ip">
<input name = "opd5" type="text" placeholder="Enter Option D" id="ip">
<input name = "ans5" type="text" placeholder="Enter Correct Option in terms of A,B,C,D" id="ip"><br><br>

<input type="submit" value="Create Quiz" id="sub">
</form>
</div>

<div id="marks">
<h3>Select the Student whose marks you want to view</h3>

<% ArrayList<String> names = (ArrayList<String>)request.getAttribute("names"); %>
<% ArrayList<String> usernames = (ArrayList<String>)request.getAttribute("usernames"); %>

<form action="AllResultsProcess" method="POST">
<% int i = 0; %>

	<table>
	<tr>
	<th>Name</th>
	<th>UserName</th>
	</tr>
		
	<% for(String user : usernames) 
    { %>
    	
		<tr>
		<td> <input type="radio" name="uname" value="<%= user %>"> <%= names.get(i) %> </td>
		<td> <%= user %></td>
		</tr>
    
    	<% i++; %>
    <%} %>
    </table>    
    
    <br>
    <input type="submit" value="View Results" id="sub">
</form>

</div>

</body>
</html>