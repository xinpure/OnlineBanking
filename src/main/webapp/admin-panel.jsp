<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Panel</title>
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
<h1 class="keTitle">Admin Panel</h1>
<div class="kePublic-white">
	<div id="order_nav">
	    <ul class="list not_ie">
	      <li>
	        <div class="ico _1"><a href="register"></a></div>
	        <p><span>Add User</span></p>
	      </li>
	      <li>
	        <div class="ico _2"><a href="view-user.jsp"></a></div>
	        <p><span>View User</span></p>
	      </li>
	      <li>
	        <div class="ico _3"><a href="open-account.jsp"></a></div>
	        <p><span>Open Account</span></p>
	      </li>
	      <li>
	        <div class="ico _4"><a href="freeze-user.jsp"></a></div>
	        <p><span>Freeze/Release Account</span></p>
	      </li>
	      <li>
	        <div class="ico _5"><a href="sheets.jsp"></a></div>
	        <p><span>Create Sheet</span></p>
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