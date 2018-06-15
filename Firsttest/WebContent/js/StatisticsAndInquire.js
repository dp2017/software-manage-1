function ge(el)
{
	var element = document.getElementById(el);
	return element;
}

function SetDisplayValue(b,a)
{
	var c=ge(b);
	if(c)
	{
		if(c.style)
		{
			c.style.display=a;
		}
	}
}

function AddRowEx(divid,divindex,divcount){
	
	try{
		if(!ge(divindex)||!ge(divcount)||ge(divindex).value==ge(divcount).value)
		{return;}
		var curID=parseInt($("#"+divindex).val());
		var copyID=curID+1;
		var curTrID=divid+"_"+curID.toString();
		var copyTrID=divid+"_"+copyID.toString();
		var copyHtml="";
		if($("#"+copyTrID).html()!=null)
		{
			$("#"+copyTrID).show();
		}
		else
		{
			var cloneObj=$("#"+curTrID).clone();
			if(curID==1)
			{
				if(cloneObj.find("td:first")!=null)
				{
					cloneObj.find("td:first").remove();
				}
				if(cloneObj.find("span:first")!=null)
				{
					cloneObj.find("span:first").remove();
				}
				var logicalTd=$("#hidden_logical_"+divid).html();
				if(logicalTd!="")
				{
					var reg=/{key}/g;
					logicalTd=logicalTd.replace(reg,copyTrID);
					cloneObj=cloneObj.prepend(logicalTd);
				}
			}
			copyHtml=$("<div></div>").append(cloneObj).html();
			var reg1=eval("/"+curTrID+"/g");
			copyHtml=copyHtml.replace(reg1,divid+"_"+copyID.toString());
			if(copyHtml!=""){$("#"+curTrID).after(copyHtml);}
		}
		var objvalue=ge(copyTrID+"_value1");
		if(objvalue!=null)
		{
			objvalue.value="";
		}
		objvalue=ge(copyTrID+"_value2");
		if(objvalue!=null){objvalue.value="";}
		ge(divindex).value=copyID.toString();
		var obj=ge(copyTrID+"_sel");
		if(!obj){obj=ge(copyTrID+"_sel1");}
		if(obj)
		{
			obj.options[copyID-1].selected=true;
			obj.onchange();
		}
	}catch(e)
	{}
}

function AddRow(h,c,b)
{
	try{
		if(ge(c).value==ge(b).value){return;}
		if(!ge(c)||!ge(b)||ge(c).value==ge(b).value){return;}
		else
		{
			var g=parseInt(ge(c).value);
			g++;
			var f=h+"_"+g;
			SetDisplayValue(f,"");
			ge(c).value=g;
			var a=ge("txt_"+g+"_sel");
			if(a)
			{
				a.options[g-1].selected=true;
				a.onchange();
			}
		}
	}catch(d)
	{return;}
}

function DeleteRow(h,c,b)
{
	try{
		if(ge(c).value=="1"){return;}
		else
		{
			var g=parseInt(ge(c).value);
			var f=h+"_"+g;var a=ge(f+"_value1");
			if(a!=null)
			{
				a.value="";
			}
			a=ge(f+"_value2");
			if(a!=null)
			{
				a.value="";
			}
			SetDisplayValue(f,"none");
			f;
			g--;
			ge(c).value=g;
		}
	}catch(d)
	{return;}
}


function AddRowSaveID(h,c,b,f)
{
	try{
		if(ge(c).value==ge(b).value){return;}
		else
		{
			var g=parseInt(ge(c).value);
			g++;
			var a=h+"_"+g;ge(a).style.display="";
			ge(c).value=g;
			if(ge(f))
			{
				if(ge(f).value.indexOf(a+",")<0)
				{
					ge(f).value+=a+",";
				}
			}
		}
	}catch(d)
	{return;}
}

function DeleteRowSaveID(d,a,h,b)
{
	try{
		if(ge(a).value=="1"){return;}
		else
		{
			var j=parseInt(ge(a).value);
			var g=d+"_"+j;
			var c=ge(g+"_value1");
			if(c!=null){c.value="";}
			c=ge(g+"_value2");
			if(c!=null){c.value="";}
			SetDisplayValue(g,"none");
			j--;
			ge(a).value=j;
			if(ge(b))
			{
				ge(b).value=ge(b).value.replace(g+",","");
			}
		}
	}catch(f)
	{return;}
}