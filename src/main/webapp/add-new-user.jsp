<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
<link type="text/css" rel="Stylesheet" href="./css/bank.css" />
<link type="text/css" rel="Stylesheet" href="css/datePicker.css" />
<script type="text/javascript" src="js/datePickerConfig.js"></script>
<script type="text/javascript" src="js/datePicker.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/addUser.js"></script>

<script type="text/javascript">
	function testDatePicker() {
		setInputControl("birth");
		if (datePicker != null) {
			datePicker.close();
			datePicker = null;
		} else {
			var d = new Date();
			datePicker = new Ecalendar(d.getFullYear(), d.getMonth(), d
					.getDate());

			//datePicker.setMinYear(2007);
			//datePicker.setMaxYear(2010);
			datePicker.setDisplayYearRange(24);

			var b = datePicker.showDate();

		}
	}
</script>

</head>
<body class="keBody">
	<h1 class="keTitle">Add User</h1>
	<div class="kePublic-white">

		<form:form modelAttribute="newUser" class="login1"
			onsubmit="return validateAdd()">
				<h1>Add User</h1>
				<form:input path="username" type="text" id="username"
					class="login1-input" placeholder="Username"
					onfocus="clearTD('usernameTD')" />
				<form:input path="password" type="password" id="password"
					class="login1-input" placeholder="Password"
					onfocus="clearTD('passwordTD')" />
				<div class="addDiv1" id="usernameTD"></div>
				<div class="addDiv2" id="passwordTD"></div>

				<form:input path="address" type="text" id="address"
					class="login1-input" placeholder="Address"
					onfocus="clearTD('addressTD')" />
				<form:input path="phoneNum" type="text" id="contact"
					class="login1-input" placeholder="Contact number"
					onfocus="clearTD('contactTD')" />
				<div class="addDiv1" id="addressTD"></div>
				<div class="addDiv2" id="contactTD"></div>

				<form:input path="email" type="text" id="email" class="login1-input"
					placeholder="Email" onfocus="clearTD('emailTD')" />
				<form:input path="birth" type="text" id="birth"
					onclick="testDatePicker()" class="login1-input"
					placeholder="Date of birth" onfocus="clearTD('birthTD')" />
				<div class="addDiv1" id="emailTD"></div>
				<div class="addDiv2" id="birthTD"></div>

				<form:input path="ssn" type="text" id="ssn" class="login1-input"
					placeholder="Social security number" onfocus="clearTD('ssnTD')" />
				<div class="addDiv1" id="ssnTD"></div>

				<div align="center">
					<input type="submit" value="Add" class="login1-submit"> <input
						type="button" value="Back" class="login1-submit"
						onclick="javascript:history.go(-1);">
				</div>
		</form:form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>