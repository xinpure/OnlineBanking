
function validateMoney()
{
	var cm=document.getElementById("money");
	var ca=document.getElementById("account");
	
	var cmTD=document.getElementById("moneyTD");
	var caTD=document.getElementById("accountTD");

	if(ca.value=="")
	{
		caTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter the way you transfor</font>";
		return false;
	}

	if(!(ca.value=="from checking to saving" || ca.value=="from saving to checking" || ca.value=="from checking to credit card" || ca.value=="from saving to credit card"))
	{
		caTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter the valid way</font>";
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

