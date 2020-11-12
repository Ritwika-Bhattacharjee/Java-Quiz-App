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
}
#Register{
display: none;
width:50%;
margin:auto;
text-align: center;
}
#Login{
display: none;
width:50%;
margin:auto;
text-align: center;
}
h1{
background-color: black;
color: #34D7B3;
padding: 30px;
margin: 0px;
text-align: center;
}

#buttons{
margin-top: 30px;
text-align: center;
}

#but1, #but2{
background-color: black;
color: white;
padding: 20px;
border-radius: 15px;
cursor: pointer;
width: 30%;
font-size: 1.3em;
font-weight: bold;
}
#but1:hover, #but2:hover{
background-color: white;
color:black;
}

#ip{
width: 60%;
padding: 20px;
margin-top: 5px;
margin-bottom: 5px;
border: none;
border-radius: 10px;
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
</style>
</head>
<body>
<script>
function showlogin(){
	ele1 = document.getElementById("Login");
	ele1.style.display = "block";
	ele2 = document.getElementById("Register");
	ele2.style.display = "none";
}
function showregister(){
	ele1 = document.getElementById("Login");
	ele1.style.display = "none";
	ele2 = document.getElementById("Register");
	ele2.style.display = "block";
}
</script>
	
	<h1>Welcome to Online Java Quiz Application</h1>
	<div id="buttons">
	<button onclick="showlogin()" id="but1">Login</button>
	<button onclick="showregister()" id="but2">Register</button>
	</div>
	
	<div id="Register">
	<h3>Register Now!</h3>
	<form action="RegisterProcess" method="POST">
	<input name="name" type="text" placeholder="Enter your name..." id="ip"><br>
	<input name="uname" type="text" placeholder="Enter a Username..." id="ip"><br>
	<input name="password" type="password" placeholder="Enter a Password..." id="ip"><br>
	<input type="submit" value="Register" id="sub">
	</form>
	</div>
	
	<div id="Login">
	<h3>Login Here!</h3>
	<form action="LoginProcess" method="POST">
	<input name="uname" type="text" placeholder="Enter a Username..." id="ip"><br>
	<input name="password" type="password" placeholder="Enter a Password..." id="ip"><br>
	<input type="submit" value="Login" id="sub">
	</form>
	</div>
	
</body>
</html>