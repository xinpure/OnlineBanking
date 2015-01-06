
function validateLogin()
{
	var cid=document.getElementById("username");
	var cacc=document.getElementById("account");
	
	var cidTD=document.getElementById("usernameTD");
	var caccTD=document.getElementById("accountTD");

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

	return true;
}

//clear
function clearTD(pa)
{	
	document.getElementById(pa).innerHTML="";
}

