
function validateForget()
{
	var cid=document.getElementById("username");
	var cmail=document.getElementById("email");
	var cssn=document.getElementById("ssn");
	
	var cidTD=document.getElementById("usernameTD");
	var cmailTD=document.getElementById("emailTD");;
	var cssnTD=document.getElementById("ssnTD");
	
	if(cid.value=="")
	{
		cidTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter username</font>";
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

