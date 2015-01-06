<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Open Account</title>
<link type="text/css" rel="Stylesheet" href="css/bank.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/open.js"></script>
<script type="text/javascript" src="js/dropDown.js"></script>
</head>
<body class="keBody">
<h1 class="keTitle">Open Account</h1>
<div class="kePublic-white">
        <form action="" class="login" onsubmit="return validateOpen()">   
	<h1>Open Account</h1>
	<input type="text" id="account" class="login-input" placeholder="Which account you open" onfocus="clearTD('accountTD')" autofocus/>
	<div id="accountTD"></div>
	<div id="btn_come_from_drop_down" class="select_normal"></div>
	<ul id="come_from_drop_down" class="area">
		<li class="active">checking</li>
		<li>saving</li>
		<li>credit card</li>
	</ul>
    <input type="text" id="username" class="login-input" placeholder="Which user you open" onfocus="clearTD('usernameTD')">
    <div id="usernameTD"></div>
    <input type="text" id="money" class="login-input" placeholder="How much money you deposit" onfocus="clearTD('moneyTD')">
    <div id="moneyTD"></div>

    <input type="submit" value="Open" class="login-submit">
    <input type="button" value="Back" class="login-submit" onclick="javascript:history.go(-1);">
  </form>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>