function defaultTextSetText(oInputElement, sText)
{
	oInputElement.isDefault=false;
	oInputElement.value=sText;
	oInputElement.style.color=g_aNormalTextColor[oInputElement.index];
}

var g_aUl=[];
var g_aFnOnItemSelect=[];
var g_iDropDownMaxIndex=0;

function setDropDown(oUl, fnOnItemSelect)
{
	var aLis=oUl.getElementsByTagName('li');
	var i;
	
	//
	g_aUl.push(oUl);
	g_aFnOnItemSelect.push(fnOnItemSelect);
	
	//
	oUl.style.display='none';
	
	for(i=0;i<aLis.length;i++)
	{
		aLis[i].className='';
		
		aLis[i].index=g_iDropDownMaxIndex;
		
		aLis[i].onmouseover=__dropDownOnMouseOverHandler__;
		aLis[i].onmouseout=__dropDownOnMouseOutHandler__;
		aLis[i].onmousedown=__dropDownOnMouseDownHandler__;
	}
	
	g_iDropDownMaxIndex++;
}

function __dropDownOnMouseOverHandler__(ev)
{
	this.className='active';
}

function __dropDownOnMouseOutHandler__(ev)
{
	this.className='';
}

function __dropDownOnMouseDownHandler__(ev)
{
	document.getElementById("account").value = (this.innerHTML);
	document.getElementById("accountTD").innerHTML= "";
	g_aFnOnItemSelect[this.index](this.innerHTML);
	g_aUl[this.index].style.display='none';
}

window.onload=function ()
{	
	var oUlDropDown=document.getElementById('come_from_drop_down');
	var oBtnComeFromDropDown=document.getElementById('btn_come_from_drop_down');
	
	setDropDown
	(
	 	oUlDropDown,
		function (sText)
		{
			defaultTextSetText(oInputComeFrom, sText);
		}
	);
	
	oBtnComeFromDropDown.onmousedown=function (ev)
	{
		var oEvent=window.event||ev;
		
		oEvent.cancelBubble=true;
		
		if(oUlDropDown.style.display === 'none')
		{
			this.className='select_active';
			oUlDropDown.style.display='block';
		}
		else
		{
			this.className='select_normal';
			oUlDropDown.style.display='none';
		}
	};
	
	document.onmousedown=function ()
	{
		oBtnComeFromDropDown.className='select_normal';
		oUlDropDown.style.display='none';
	};
}