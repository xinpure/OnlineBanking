<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer Money</title>
<link type="text/css" rel="Stylesheet" href="css/bank.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/transfer.js"></script>
<script type="text/javascript" src="js/dropDown.js"></script>
</head>
<body class="keBody">
<h1 class="keTitle">Transfer Money</h1>
<div class="kePublic-white">
<div align="center">
<div class="axis"> </div> 
<div>
<span class="blcl">Checking Balance: </span>
<span class="blcr" id="checking">$10,000.00 </span>
</div> 
<div>
<span class="blcl">Saving Balance: </span>
<span class="blcr" id="saving">$10,000.00 </span>
</div> 
<div>
<span class="blcl">Credit Card Balance: </span>
<span class="blcr" id="card">$10,000.00 </span>
</div> 
<div class="axis"> </div> 
</div>
<div>
        <form action="" class="login" onsubmit="return validateMoney()">   
	<h1>Transfer Money</h1>
    <input type="text" id="account" class="login-input" placeholder="Which way you transfer" onfocus="clearTD('accountTD')" autofocus>
    <div id="accountTD"></div>
<div style="position:absolute; top:79px; left:0px">
	<div id="btn_come_from_drop_down" class="select_normal"></div>
	<ul id="come_from_drop_down" class="area">
		<li class="active">from checking to saving</li>
		<li>from saving to checking</li>
		<li>from ckecking to credit card</li>
		<li>from saving to credit card</li>
	</ul>
</div>
    <input type="text" id="money" class="login-input" placeholder="How much money you transfer" onfocus="clearTD('moneyTD')">
    <div id="moneyTD"></div>

    <input type="submit" value="Transfer" class="login-submit">
    <input type="button" value="Back" class="login-submit" onclick="javascript:history.go(-1);">
  </form>
</div >
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>