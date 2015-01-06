<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget Password</title>
<link type="text/css" rel="Stylesheet" href="css/bank.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/forget.js"></script>
</head>
<body class="keBody">
<h1 class="keTitle">Forget Password</h1>
<div class="kePublic-white">
<div>
	<form action="" class="login" onsubmit="return validateForget()">   
	<h1>Forget Password</h1>
    <input type="text" id="username" class="login-input" placeholder="Username" onfocus="clearTD('usernameTD')" autofocus>
    <div id="usernameTD"></div>
    <input type="text" id="email" class="login-input" placeholder="Email" onfocus="clearTD('emailTD')">
    <div id="emailTD"></div>
    <input type="text" id="ssn" class="login-input" placeholder="Social security number" onfocus="clearTD('ssnTD')">
    <div id="ssnTD"></div>
    <input type="submit" value="Submit" class="login-submit">
    <input type="button" value="Back" class="login-submit" onclick="javascript:history.go(-1);">
  </form>
</div >
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>