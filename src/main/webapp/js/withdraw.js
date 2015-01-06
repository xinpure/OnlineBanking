
function validateMoney()
{
	var cm=document.getElementById("money");
	var ca=document.getElementById("account");
	
	var cmTD=document.getElementById("moneyTD");
	var caTD=document.getElementById("accountTD");

	if(ca.value=="")
	{
		caTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter account</font>";
		return false;
	}

	if(!(ca.value=="checking" || ca.value=="saving"))
	{
		caTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter valid account (checking or saving)</font>";
		return false;
	}
	
	if(cm.value=="")
	{
		cmTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter money</font>";
		return false;
	}

	if(isNaN(cm.value))
	{
		cmTD.innerHTML="<font style='color:red; font-size:18px'>*Money must be number</font>";
		return false;
	}

	return true;
}

//clear
function clearTD(pa)
{	
	document.getElementById(pa).innerHTML="";
}

