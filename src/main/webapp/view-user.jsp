<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
				<c:forEach items="${userList}" var="user">
					<c:choose>
						<c:when test="${user.userID eq param.userID}">
							<tr>
 								<form action="editUser" method="post">
									<div style="display: none;">
									<input type="text" size="15"
											value="${user.userID}" name="userID" >
									<input type="text" size="15"
											value="${user.available}" name="available" >
									</div>
									<td><input type="text" size="15"
											value="${user.username}" name="username" ></td>
									<td><input type="text" size="15"
											value="${user.password}" name="password" ></td>
									<td><input type="text" size="15"
											value="${user.address}" name="address" ></td>
									<td><input type="text" size="15"
											value="${user.phoneNum}" name="contact" ></td>
									<td><input type="text" size="15"
											value="${user.email}" name="email" ></td>
									<td><input type="text" size="15"
											value="${user.birth}" name="birth" ></td>
									<td><input type="text" size="15"
											value="${user.ssn}" name="ssn" ></td>
									<td style="width: 65px;"><input type="submit"
										value="Submit"></td>
								<td style="width: 70px;"><form:form action="removeUser"
										method="post">
										<input type="hidden" name="userID" value="${user.userID}">
										<input type="submit" value="Remove">
									</form:form></td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td><c:out value="${user.username}"></c:out></td>
								<td><c:out value="${user.password}"></c:out></td>
								<td><c:out value="${user.address}"></c:out></td>
								<td><c:out value="${user.phoneNum}"></c:out></td>
								<td><c:out value="${user.email}"></c:out></td>
								<td><c:out value="${user.birth}"></c:out></td>
								<td><c:out value="${user.ssn}"></c:out></td>
								<td style="width: 65px;"><form:form action="readUser"
										method="get">
										<input type="hidden" name="userID" value="${user.userID}">
										<input type="submit" value="Modify">
									</form:form></td>
								<td style="width: 70px;"><form:form action="removeUser"
										method="post">
										<input type="hidden" name="userID" value="${user.userID}">
										<input type="submit" value="Remove">
									</form:form></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</table>
			<div style="width: 200px; margin-top: 50px;">
				<input type="button" value="Back" class="login-submit"
					onclick="window.location.replace(" users")" />
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>