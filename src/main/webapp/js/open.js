
function validateOpen()
{
	var cid=document.getElementById("username");
	var cacc=document.getElementById("account");
	var cmon=document.getElementById("money");
	
	var cidTD=document.getElementById("usernameTD");
	var caccTD=document.getElementById("accountTD");
	var cmonTD=document.getElementById("moneyTD");

	if(cacc.value=="")
	{
		caccTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter account</font>";
		return false;
	}	

	if(!(cacc.value=="saving" || cacc.value=="checking" || cacc.value=="credit card"))
	{
		caccTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter valid account (checking or saving)</font>";
		return false;
	}

	if(cid.value=="")
	{
		cidTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter username</font>";
		return false;
	}

	if(cmon.value=="")
	{
		cmonTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter money</font>";
		return false;
	}
	if(isNaN(cmon.value))
	{
		cmonTD.innerHTML="<font style='color:red; font-size:18px'>*Money must be number</font>";
		return false;
	}

	return true;
}

//clear
function clearTD(pa)
{	
	document.getElementById(pa).innerHTML="";
}


