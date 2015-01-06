
function validateLogin()
{
	var cid=document.getElementById("username");
	var cpwd=document.getElementById("password");
	
	var cidTD=document.getElementById("usernameTD");
	var cpwdTD=document.getElementById("passwordTD");
	
	if(cid.value=="")
	{
		cidTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter username</font>";
		return false;
	}

	if(cpwd.value=="")
	{
		cpwdTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter password</font>";
		return false;
	}

	return true;
}

//clear
function clearTD(pa)
{	
	document.getElementById(pa).innerHTML="";
}

