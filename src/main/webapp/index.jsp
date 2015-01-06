<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Marlabs Bank</title>
<link type="text/css" rel="Stylesheet" href="css/bank.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/welcome.js"></script>
</head>
<body class="keBody">
<h1 class="keTitle">Welcome to Marlabs Bank</h1>
<div class="kePublic">
<div id="LoopDiv">
<input id="S_Num" type="hidden" value="8" />
<div id="starsIF" class="imageflow">
<img src="images/welcomeBusiness.jpg" longdesc="./our-business.jsp" width="280" height="300" alt="our business" />
<img src="images/welcomeContact.jpg" longdesc="./contact-us.jsp" width="280" height="300" alt="contact us" />
<img src="images/welcomeAbout.jpg" longdesc="./about-us.jsp" width="280" height="300" alt="about us" />
<img src="images/welcomeUser.jpg" longdesc="./login" width="280" height="300" alt="user account" />
<img src="images/welcomeAdmin.jpg" longdesc="./adminLogin" width="280" height="300" alt="admin account" />
</div>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>