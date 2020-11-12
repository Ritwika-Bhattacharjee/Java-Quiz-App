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
text-align: center;

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
padding: 10px;
border-radius: 10px;
cursor: pointer;
width: 30%;
font-weight: bold;
}
#but1:hover, #but2:hover{
background-color: white;
color:black;
}
#content{
font-weight: bold;
padding-top: 10px;
padding-bottom: 10px;
text-align: left;
font-size: 1.2em;
width: 30%;
margin: auto;
}

</style>
</head>
<body>
<h1>Student Home Page ${name} </h1>
<h3>Attempt a Quiz</h3>
<form action="QuizProcess" method="POST">
<div id="content">
<% ArrayList<String> quiznames = (ArrayList<String>)request.getAttribute("quiznames"); %>
 
    <% for(String quiz : quiznames) 
    { %>
        <input type="radio" name="quiz" value = "<%= quiz %>" id="ele"> <%= quiz %> <br>
    <%}
 
%>
</div>
<input type="submit" value="Attempt Quiz" id="but1">
</form>
<br>
<h3>View All Scores</h3>
<form action="MyMarksProcess" method="POST">
<input type="submit" value="Click Here to View All Marks" id="but2">
</form>
</body>

</html>