<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Panel</title>
<link type="text/css" rel="Stylesheet" href="css/bank.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script language="javascript">
$(function () {
 $('#order_nav li').hover(function () {
        $(this).addClass('on');
    },
	function () {
        $(this).removeClass('on');
    }
	);
});
</script>
</head>
<body class="keBody">
<h1 class="keTitle">User Panel - ${userID}</h1>
<div class="kePublic-white">
	<div id="order_nav">
	    <ul class="list not_ie">
	      <li>
	        <div class="ico _1"><a href="balance"></a></div>
	        <p><span>Account Balance</span></p>
	      </li>
	      <li>
	        <div class="ico _2"><a href="password"></a></div>
	        <p><span>Change Password</span></p>
	      </li>
	      <li>
	        <div class="ico _3"><a href="pay"></a></div>
	        <p><span>Paid by Credit Card</span></p>
	      </li>
	      <li>
	        <div class="ico _4"><a href="withdraw"></a></div>
	        <p><span>Withdraw Money</span></p>
	      </li>
	      <li>
	        <div class="ico _5"><a href="transfer"></a></div>
	        <p><span>Account Transfer</span></p>
	      </li>
	      <li>
	        <div class="ico _6"><a href="index.jsp"></a></div>
	        <p><span>Log Out</span></p>
	      </li>
	    </ul>
	</div>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>