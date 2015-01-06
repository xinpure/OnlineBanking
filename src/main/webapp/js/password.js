
function validateLogin()
{
	var copwd=document.getElementById("old-password");
	var cnpwd=document.getElementById("new-password");
	var crpwd=document.getElementById("repeat-password");

	var copwdTD=document.getElementById("old-passwordTD");
	var cnpwdTD=document.getElementById("new-passwordTD");
	var crpwdTD=document.getElementById("repeat-passwordTD");
	
	if(copwd.value=="")
	{
		copwdTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter old password</font>";
		return false;
	}

	if(cnpwd.value=="")
	{
		cnpwdTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter new password</font>";
		return false;
	}
	if(crpwd.value=="")
	{
		crpwdTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter repeat password</font>";
		return false;
	}

	if(crpwd.value!=cnpwd.value)
	{
		crpwdTD.innerHTML="<font style='color:red; font-size:18px'>*Repeat password not equal</font>";
		return false;
	}
	return true;
}

//clear
function clearTD(pa)
{	
	document.getElementById(pa).innerHTML="";
}

