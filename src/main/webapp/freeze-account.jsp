<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Freeze/Release Account</title>
<link type="text/css" rel="Stylesheet" href="css/bank.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/userFreeze.js"></script>
<script type="text/javascript" src="js/dropDown.js"></script>
</head>
<body class="keBody">
<h1 class="keTitle">Freeze/Release Account</h1>
<div class="kePublic-white"> 
        <form action="freezeReleaseAccount" method="post" class="login" onsubmit="return validateLogin()">   
	<h1>Freeze/Release Account</h1>
	<input type="text" id="account" class="login-input" placeholder="Which account you freeze" onfocus="clearTD('accountTD')" autofocus/>
	<div id="accountTD"></div>
	<div id="btn_come_from_drop_down" class="select_normal"></div>
	<ul id="come_from_drop_down" class="area">
		<li class="active">checking</li>
		<li>saving</li>
		<li>credit card</li>
	</ul>
    <input type="text" id="username" class="login-input" placeholder="Which user you freeze" onfocus="clearTD('usernameTD')">
    <div id="usernameTD"></div>

    <input type="submit" value="Freeze" class="login-submit">
    <input type="submit" value="Release" class="login-submit">
    <input type="button" value="Back" class="login-submit" onclick="javascript:history.go(-1);">
  </form>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>