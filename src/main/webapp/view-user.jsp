<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <%if("1".equals(username)) { %>
  <tr>  
    <form action="" method="post">
    <td>1</td>  
    <td><input type="text" size="15" value="2" name="password"></td>  
    <td><input type="text" size="15" value="3" name="address"></td>  
    <td><input type="text" size="15" value="4" name="contact"></td>  
    <td><input type="text" size="15" value="5" name="email"></td>
    <td><input type="text" size="15" value="6" name="birth"></td>
    <td><input type="text" size="15" value="7" name="ssn"></td>  
	<td style="width:65px;"><input type="hidden" name="username" value="1">
	<input type="submit" value="Submit">					
	</td></form>
	<td style="width:70px;"><form action="" method="post">
	<input type="hidden" name="username" value="1">
	<input type="submit" value="Remove">					
	</form></td>
  </tr>  
  <%}else {%>
  <tr>  
    <td>1</td>  
    <td>2</td>  
    <td>3</td>  
    <td>4</td>  
    <td>5</td>
    <td>6</td>
    <td>7</td>
    <td style="width:65px;"><form action=view-user.jsp method="post">
	<input type="hidden" name="username" value="1">
	<input type="submit" value="Modify">					
	</form></td>
	<td style="width:70px;"><form action="" method="post">
	<input type="hidden" name="username" value="1">
	<input type="submit" value="Remove">					
	</form></td>
  </tr>  
  <%}%> 
  <tr>  
    <td class="alt">11</td>  
    <td class="alt">2</td>  
    <td class="alt">3</td>  
    <td class="alt">4</td>  
    <td class="alt">5</td>
    <td class="alt">6</td>
    <td class="alt">7</td>
    <td class="alt"><form action=view-user.jsp method="post">
	<input type="hidden" name="username" value="11">
	<input type="submit" value="Modify">					
	</form></td>
	<td class="alt"><form action="" method="post">
	<input type="hidden" name="username" value="11">
	<input type="submit" value="Remove">					
	</form></td>
  </tr>  
  <tr>  
    <td>111</td>  
    <td>2</td>  
    <td>3</td>  
    <td>4</td> 
    <td>5</td>
    <td>6</td>
    <td>7</td>
    <td><form action=view-user.jsp method="post">
	<input type="hidden" name="username" value="111">
	<input type="submit" value="Modify">					
	</form></td>
	<td><form action="" method="post">
	<input type="hidden" name="username" value="111">
	<input type="submit" value="Remove">					
	</form></td>
  </tr>  
</table>  
<div style="width:200px; margin-top:50px;">
	<input type="button" value="Back" class="login-submit" onclick="javascript:history.go(-1);" />
</div>
</div>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>