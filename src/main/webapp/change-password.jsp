<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<link type="text/css" rel="Stylesheet" href="css/bank.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/password.js"></script>
</head>
<body class="keBody">
<h1 class="keTitle">Change Password</h1>
<div class="kePublic-white">
<div>
	<form action="" class="login" onsubmit="return validateLogin()">   
	<h1>Change Password</h1>
    <input type="password" id="old-password" class="login-input" placeholder="Old Password" onfocus="clearTD('old-passwordTD')" autofocus>
    <div id="old-passwordTD"></div>
    <input type="password" id="new-password" class="login-input" placeholder="New Password" onfocus="clearTD('new-passwordTD')">
    <div id="new-passwordTD"></div>
    <input type="password" id="repeat-password" class="login-input" placeholder="Repeat Password" onfocus="clearTD('repeat-passwordTD')">
    <div id="repeat-passwordTD"></div>
    <input type="submit" value="Change" class="login-submit">
    <input type="button" value="Back" class="login-submit" onclick="javascript:history.go(-1);">
    <p class="login-help"><a href="forget-password.jsp">Forgot password?</a></p>
  </form>
</div >
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>