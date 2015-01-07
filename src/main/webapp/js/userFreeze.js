
function validateLogin()
{
	var cid=document.getElementById("username");
	var cacc=document.getElementById("account");
	var cac=document.getElementById("action");
	
	var cidTD=document.getElementById("usernameTD");
	var caccTD=document.getElementById("accountTD");
	var cacTD=document.getElementById("actionTD");

	if(cacc.value=="")
	{
		caccTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter account</font>";
		return false;
	}	

	if(!(cacc.value=="saving" || cacc.value=="checking" || cacc.value=="credit card"))
	{
		caccTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter valid account (checking, saving or credit card)</font>";
		return false;
	}

	if(cid.value=="")
	{
		cidTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter username</font>";
		return false;
	}
	if(cac.value=="")
	{
		cacTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter method</font>";
		return false;
	}

	if(!(cac.value=="freeze" || cac.value=="available"))
	{
		cacTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter valid method (freeze or available)</font>";
		return false;
	}
	
	return true;
}

//clear
function clearTD(pa)
{	
	document.getElementById(pa).innerHTML="";
}

