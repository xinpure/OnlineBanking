<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Paid by Credit Card</title>
<link type="text/css" rel="Stylesheet" href="css/bank.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/card.js"></script>
<script language="javascript">
$(function () {
 $('#help').hover(function () {
	document.getElementById("cvnMode").style.visibility='visible';
    },
	function () {
        document.getElementById("cvnMode").style.visibility='hidden';
    }
	);
});
</script>
</head>
<body class="keBody">
<h1 class="keTitle">Paid by Credit Card</h1>
<div class="kePublic-white">
<div align="center">
<div class="axis"> </div> 
<span class="blcl">Credit Card Balance: </span>
<span class="blcr" id="card">$10,000.00 </span>
<div class="axis"> </div> 
</div>
<div>
        <form action="" class="login" onsubmit="return validateMoney()">   
	<h1>Paid by Credit Card</h1>
    <input type="text" id="account" class="login-input" placeholder="Credit card number" onfocus="clearTD('accountTD')" autofocus>
    <div id="accountTD"></div>
    <input type="text" id="expire" class="login-input" placeholder="Expire" onfocus="clearTD('expireTD')">
    <div id="expireTD"></div>
    <input type="text" id="CVN" class="login-input" placeholder="CVN" onfocus="clearTD('CVNTD')">
    <div id="CVNTD"></div>
<div id="help"></div>
<div id="cvnMode"></div>
    <input type="submit" value="Pay" class="login-submit">
    <input type="button" value="Back" class="login-submit" onclick="javascript:history.go(-1);">
  </form>
</div >
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>