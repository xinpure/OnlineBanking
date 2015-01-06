<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="com.banking.domain.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View User</title>
<link type="text/css" rel="Stylesheet" href="css/bank.css" />
</head>
<body class="keBody">
<h1 class="keTitle">View User</h1>
<div class="kePublic-white">
<div>
<% String username=request.getParameter("username"); %>
<form class="form-wrapper cf">
        <input type="text" placeholder="Search here..." required>
        <button type="submit">Search</button>
    </form>
</div>
<div align="center">
<table id="mytable1" cellspacing="0">  
<caption1>Users </caption1>  
  <tr>  
    <th scope="col">Username</th>  
    <th scope="col">Password</th>  
    <th scope="col">Address</th>  
    <th scope="col">Contact</th> 
    <th scope="col">Email</th>  
    <th scope="col">Birth</th>  
    <th scope="col">SSN</th> 
    <th scope="col">Edit</th> 
    <th scope="col">Remove</th> 
  </tr>  
	<c:forEach items="&(userList)" var="user">
	<c:out value ="$(user.username)"/>
  <c:when test="${user.username.equals(username)}" >
  <tr>  
    <form action="" method="post">
    <td>1</td>  
    <td><input type="text" size="15" value="2" name="password"></td>  
    <td><input type="text" size="15" value="3" name="address"></td>  
    <td><input type="text" size="15" value="4" name="contact"></td>  
    <td><input type="text" size="15" value="5" name="email"></td>
    <td><input type="text" size="15" value="6" name="birth"></td>
    <td><input type="text" size="15" value="7" name="ssn"></td>  
	<td style="width:65px;"><input type="hidden" name="username" value="$(user.username)" />
	<input type="submit" value="Submit">					
	</td></form>
	<td style="width:70px;"><form action="" method="post">
	<input type="hidden" name="username" value="$(user.username)">
	<input type="submit" value="Remove">					
	</form></td>
  </tr>  
  </c:when>
  <c:otherwise>
  <tr>  
    <td>$(user.username)</td>  
    <td>$(user.password)</td>  
    <td>$(user.address)</td>  
    <td>$(user.phoneNum)</td>  
    <td>$(user.email)</td>
    <td>$(user.birth)</td>
    <td>$(user.ssn)</td>
    <td style="width:65px;"><form action=view-user.jsp method="post">
	<input type="hidden" name="username" value="$(user.username)">
	<input type="submit" value="Modify">					
	</form></td>
	<td style="width:70px;"><form action="" method="post">
	<input type="hidden" name="username" value="$(user.username)">
	<input type="submit" value="Remove">					
	</form></td>
  </tr>  
  </c:otherwise>
  </c:forEach>
</table>  
<div style="width:200px; margin-top:50px;">
	<input type="button" value="Back" class="login-submit" onclick="javascript:history.go(-1);" />
</div>
</div>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>