<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw Money</title>
<link type="text/css" rel="Stylesheet" href="css/bank.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/withdraw.js"></script>
<script type="text/javascript" src="js/dropDown.js"></script>
</head>
<body class="keBody">
<h1 class="keTitle">Withdraw Money</h1>
<div class="kePublic-white">
<div>
        <form:form action="withdraw" class="login" onsubmit="return validateMoney()">   
	<h1>Withdraw Money</h1>

   <input type="text" name="account" id="account" class="login-input" placeholder="Which account you withdraw" onfocus="clearTD('accountTD')" autofocus>
    <div id="accountTD"></div>
	<div id="btn_come_from_drop_down" class="select_normal"></div>
	<ul id="come_from_drop_down" class="area">
		<li class="active">checking</li>
		<li>saving</li>
	</ul>
    <input type="text" name="money" id="money" class="login-input" placeholder="How much money you withdraw" onfocus="clearTD('moneyTD')" autofocus>
    <div id="moneyTD"></div>
    <input type="submit" value="Withdraw" class="login-submit">
    <input type="button" value="Back" class="login-submit" onclick="javascript:history.go(-1);">
  </form:form>

</div>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>