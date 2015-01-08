<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Balance</title>
<link type="text/css" rel="Stylesheet" href="css/bank.css" />
<script>
function setTab(m,n){
	var tli=document.getElementById("menu"+m).getElementsByTagName("li");
	var mli=document.getElementById("main"+m).getElementsByTagName("ul");
	for(i=0;i<tli.length;i++){
   	tli[i].className=i==n?"hover":"";
   	mli[i].style.display=i==n?"block":"none";
	}
}
</script>
</head>
<body class="keBody">
<h1 class="keTitle">Account Balance</h1>
<div class="kePublic-white">
<div align="center">

<div id="tabs1">
<div class="menu1box">
   <ul id="menu1">
    <li class="hover" onmouseover="setTab(1,0)"><div class="tab">Checking</div></li>
    <li onmouseover="setTab(1,1)"><div class="tab">Saving</div></li>
    <li onmouseover="setTab(1,2)"><div class="tab">Card</div></li>
   </ul>
</div>
<div class="main1box">
   <div class="main" id="main1">
    <ul class="block"><li>
	<div align="center">
	<div class="axis"> </div> 
	<span class="blcl">Checking Balance</span>
	<div class="axis"> </div> 
	</div>
<table id="mytable" cellspacing="0">  
<caption>All Transactions </caption>  
  <tr>  
    <th scope="col">Date</th>  
    <th scope="col">Description</th>  
    <th scope="col">$Amount</th>  
    <th scope="col">$Available Balance</th>  
  </tr>  
 	<c:forEach items="${checkingTrans}" var="checking" varStatus="status">
		<c:choose>
		<c:when test="${status.index %2 == 0}">
			<tr>
				<td><c:out value="${checking.transDate}"></c:out></td>
				<td><c:out value="${checking.detail}"></c:out></td>
				<td><c:out value="${checking.amount}"></c:out></td>
				<td><c:out value="${checking.availableAmount}"></c:out></td>
			</tr> 
		</c:when>
		<c:otherwise>
			<tr>
				<td class="alt"><c:out value="${checking.transDate}"></c:out></td>
				<td class="alt"><c:out value="${checking.detail}"></c:out></td>
				<td class="alt"><c:out value="${checking.amount}"></c:out></td>
				<td class="alt"><c:out value="${checking.availableAmount}"></c:out></td>
			</tr> 		
		</c:otherwise>
		</c:choose>
	</c:forEach>
</table>  
    </li></ul>
    <ul><li>
	<div align="center">
	<div class="axis"> </div> 
	<span class="blcl">Saving Balance</span>
	<div class="axis"> </div> 
	</div>
<table id="mytable" cellspacing="0">  
<caption>All Transactions </caption>  
  <tr>  
    <th scope="col">Date</th>  
    <th scope="col">Description</th>  
    <th scope="col">$Amount</th>  
    <th scope="col">$Available Balance</th>  
  </tr>  
 	<c:forEach items="${savingTrans}" var="saving" varStatus="status">
		<c:choose>
		<c:when test="${status.index %2 == 0}">
			<tr>
				<td><c:out value="${saving.transDate}"></c:out></td>
				<td><c:out value="${saving.detail}"></c:out></td>
				<td><c:out value="${saving.amount}"></c:out></td>
				<td><c:out value="${saving.availableAmount}"></c:out></td>
			</tr> 
		</c:when>
		<c:otherwise>
			<tr>
				<td class="alt"><c:out value="${saving.transDate}"></c:out></td>
				<td class="alt"><c:out value="${saving.detail}"></c:out></td>
				<td class="alt"><c:out value="${saving.amount}"></c:out></td>
				<td class="alt"><c:out value="${saving.availableAmount}"></c:out></td>
			</tr> 		
		</c:otherwise>
		</c:choose>
	</c:forEach>
</table>  

    </li></ul>
    <ul><li>
	<div align="center">
	<div class="axis"> </div> 
	<span class="blcl">Credit Card Balance</span>
	<div class="axis"> </div> 
	</div>
<table id="mytable" cellspacing="0">  
<caption>All Transactions </caption>  
  <tr>  
    <th scope="col">Date</th>  
    <th scope="col">Description</th>  
    <th scope="col">$Amount</th>  
    <th scope="col">$Available Balance</th>  
  </tr>  
 	<c:forEach items="${creditCardTrans}" var="card" varStatus="status">
		<c:choose>
		<c:when test="${status.index %2 == 0}">
			<tr>
				<td><c:out value="${card.transDate}"></c:out></td>
				<td><c:out value="${card.detail}"></c:out></td>
				<td><c:out value="${card.amount}"></c:out></td>
				<td><c:out value="${card.availableAmount}"></c:out></td>
			</tr> 
		</c:when>
		<c:otherwise>
			<tr>
				<td class="alt"><c:out value="${card.transDate}"></c:out></td>
				<td class="alt"><c:out value="${card.detail}"></c:out></td>
				<td class="alt"><c:out value="${card.amount}"></c:out></td>
				<td class="alt"><c:out value="${card.availableAmount}"></c:out></td>
			</tr> 		
		</c:otherwise>
		</c:choose>
	</c:forEach>
</table>  
    </li></ul>
   </div>
</div>
</div>

<div style="width:200px; margin-top:50px;">
	<input type="button" value="Back" class="login-submit" onclick="javascript:history.go(-1);" />
</div>
</div>
</div>
<%@ include file="footer.jsp" %> 
</body>
</html>