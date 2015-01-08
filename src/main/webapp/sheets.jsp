<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Chart</title>
<link type="text/css" rel="Stylesheet" href="css/bank.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/exporting.js"></script>
<script type="text/javascript" src="js/highcharts.js"></script>

</head>
<body class="keBody">
<h1 class="keTitle">View Chart</h1>
<div class="kePublic-white">
<div>&nbsp;</div>
<div align="center">
<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
<div style="width:200px; margin-top:50px;">
	<input type="button" value="User Chart" class="login-submit" onclick="" />
</div>
<div style="width:200px; margin-top:50px;">
	<input type="button" value="Generate User File" class="login-submit" onclick="window.location.href='export'" />
</div>
<div style="width:200px; margin-top:50px;">
	<input type="button" value="Back" class="login-submit" onclick="javascript:history.go(-1);" />
</div>
</div>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>