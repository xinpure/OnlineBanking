<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
<link type="text/css" rel="Stylesheet" href="css/bank.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body class="keBody">
<h1 class="keTitle">Admin Login</h1>
<div class="kePublic-white">
<div class="menuHolder" style="float:left;">
  <div class="menuWindow">
    <ul class="p1">
      <li class="s1"><a href="">Menu</a>
        <ul class="p2">
          <li class="s2"><a href="index.jsp"><span>Index</span></a></li>
          <li class="s2"><a href="user-login.jsp"><span>User</span></a></li>
          <li class="s2"><a href="about-us.jsp"><span>About Us</span></a></li>
          <li class="s2"><a href="contact-us.jsp"><span>Contact</span></a></li>
          <li class="s2"><a href="our-business.jsp"><span>Business</span></a></li>
        </ul>
      </li>
    </ul>
  </div>
</div>
<div style="float:center;">
<!--action="admin-panel.jsp"   -->
	<form:form class="login" onsubmit="return validateLogin()">   
	<h1>Admin Login</h1>
    <input type="text" name = "username" id="username" class="login-input" placeholder="Username" onfocus="clearTD('usernameTD')" autofocus>
    <div id="usernameTD"></div>
    <input type="password" name = "password" id="password" class="login-input" placeholder="Password" onfocus="clearTD('passwordTD')">
    <div id="passwordTD"></div>
    ${loginStatus}
    <input type="submit" value="Login" class="login-submit">
  </form:form>
</div >
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>