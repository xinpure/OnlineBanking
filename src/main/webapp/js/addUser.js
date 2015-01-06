
function validateAdd()
{
	var cid=document.getElementById("username");
	var cpwd=document.getElementById("password");
	var cad=document.getElementById("address");
	var cnum=document.getElementById("contact");
	var cmail=document.getElementById("email");
	var cbir=document.getElementById("birth");
	var cssn=document.getElementById("ssn");
	
	var cidTD=document.getElementById("usernameTD");
	var cpwdTD=document.getElementById("passwordTD");
	var cadTD=document.getElementById("addressTD");
	var cnumTD=document.getElementById("contactTD");
	var cmailTD=document.getElementById("emailTD");
	var cbirTD=document.getElementById("birthTD");
	var cssnTD=document.getElementById("ssnTD");
	
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
	if(!RegExp(/[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/).test(cpwd.value))
	{
		cpwdTD.innerHTML="<font style='color:red; font-size:18px'>*Password must contain both numbers and letters</font>";
		return false;
	}
	if(cpwd.value.length<6)
	{
		cpwdTD.innerHTML="<font style='color:red; font-size:18px'>*Password length must not less than six</font>";
		return false;
	}
	if(cad.value=="")
	{
		cadTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter address</font>";
		return false;
	}
	if(cnum.value=="")
	{
		cnumTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter contact number</font>";
		return false;
	}
	if(cnum.value.length!=10||isNaN(cnum.value))
	{
		cnumTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter valid contact number</font>";
		return false;
	}
	if(cmail.value=="")
	{
		cmailTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter Email</font>";
		return false;
	}
	if(!RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/).test(cmail.value))
	{
		cmailTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter valid Email</font>";
		return false;
	}
	if(cbir.value=="")
	{
		cbirTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter the date of birth</font>";
		return false;
	}
	if(inputCtrl.value!="")
	{
                var arr=checkInputDate(inputCtrl.value);
                if(arr==null)
                {
 			cbirTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter valid date of birth (YYYY-MM-DD)</font>";
			return false;
                }
	}
	if(cssn.value=="")
	{
		cssnTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter social security number</font>";
		return false;
	}
	if(cssn.value.length!=9||isNaN(cssn.value))
	{
		cssnTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter valid social security number</font>";
		return false;
	}
	return true;
}

//clear
function clearTD(pa)
{	
	document.getElementById(pa).innerHTML="";
}

