
function validateMoney()
{
	var cd=document.getElementById("account");
	var cex=document.getElementById("expire");
	var cCVN=document.getElementById("CVN");
	
	var cdTD=document.getElementById("accountTD");
	var cexTD=document.getElementById("expireTD");
	var cCVNTD=document.getElementById("CVNTD");

	if(cd.value=="")
	{
		cdTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter credit card number</font>";
		return false;
	}

	if(isNaN(cd.value))
	{
		cdTD.innerHTML="<font style='color:red; font-size:18px'>*Credit card must be number</font>";
		return false;
	}
	
	if(cex.value=="")
	{
		cexTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter expire</font>";
		return false;
	}

	if(isNaN(cex.value)||cex.value.length!=4)
	{
		cexTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter valid expire (MMYY)</font>";
		return false;
	}
	if(cCVN.value=="")
	{
		cCVNTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter CVN</font>";
		return false;
	}

	if(isNaN(cCVN.value)||cCVN.value.length!=3)
	{
		cCVNTD.innerHTML="<font style='color:red; font-size:18px'>*Please enter valid CVN</font>";
		return false;
	}

	return true;
}

//clear
function clearTD(pa)
{	
	document.getElementById(pa).innerHTML="";
}

