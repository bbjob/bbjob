/*********选择和取消选择所有的checkbox********/
function selAll(id1,id2)
{
	for(i=0;i<id2.length;i++)
	{
		if(id1.checked==true)
		{
			id2[i].checked=true
		}else{
			id2[i].checked=false
		}
	}
}
/*******************************************/
/*********控制一系列栏目显示与隐藏********/
function itemShow(itemName,showId,num,bgItemName,clsName)       //(itemName+num)系列栏目名称，showID需要显示的编号
{
	var clsNameArr=new Array(2)
	if(clsName.indexOf("|")<=0){
		clsNameArr[0]=clsName
		clsNameArr[1]=""
	}else{
		clsNameArr[0]=clsName.split("|")[0]
		clsNameArr[1]=clsName.split("|")[1]
	}
	
	for(i=1;i<=num;i++)
	{
		if(document.getElementById(itemName+i)!=null)
			document.getElementById(itemName+i).style.display="none"
		if(document.getElementById(bgItemName+i)!=null)
			document.getElementById(bgItemName+i).className=clsNameArr[1]
		if(i==showId)
		{
			if(document.getElementById(itemName+i)!=null)
				document.getElementById(itemName+i).style.display="inline"
			else
				alert("未找到您请求的内容!")
			if(document.getElementById(bgItemName+i)!=null)
				document.getElementById(bgItemName+i).className=clsNameArr[0]
		}
	}
}
/*******************************************/

/*********建立动态层********/
function createDiv(newName,vis,htmlTxt)
{
	var newDiv=document.createElement("div");
	newDiv.id=newName;
	newDiv.style.visibility = vis;
	newDiv.setAttibute = ("name",newName);
	newDiv.style.position = "absolute";
	newDiv.style.width = "100";
	newDiv.style.backgroundColor = "#cccccc";
	newDiv.innerHTML=htmlTxt;
	document.body.appendChild(newDiv);
}	
/*******************************************/

/*********选择select框********/
function sltChk(obj,val)
{
	for(var i=0;i<obj.length;i++)
	{
		if(obj.options[i].value==val)
			obj.options[i].selected=true;
	}
}
/*******************************************/


/*********选择单选、复选框********/
function chbChk(obj,val)
{
	if(val=='False')
		val="0"
	else if(val=='True')
		val="1"
	var arr=val.split(",");
	for(var i=0;i<obj.length;i++)
	{
		for(var j=0;j<arr.length;j++)
		{
			if(obj[i].value==arr[j])
				obj[i].checked=true;
		}
	}
}
/*******************************************/

/*********根据地址显示图片（需要层之类的容器）********/
function showPic(id,src,vis,width,height)
{
	var txt=""
	var arr=new Array()
	if(src!=null && src!="")
	{
		arr=src.split(".")
		if(arr[1].toLowerCase()=="swf")
		{
			txt+="<object id =\"mymovie\" classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0\" width=\""+width+"\" height=\""+height+"\">"
			txt+="<param name=\"movie\" value=\"../../"+src+"\">"
			txt+="<param name=\"quality\" value=\"high\">"
			txt+="<embed name=\"mymovie\" src=\""+src+"\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" width=\""+width+"\" swLiveConnect=\"true\"><\/embed>"
			txt+="<\/object>"       
		}else{
			txt="<img src='../../"+src+"' border=0 width="+width+" height=\""+height+"\">"
		}
		id.innerHTML=txt
		id.style.visibility=vis
	}
}
/*******************************************/

/*********复制表单内容到剪贴板********/
function copyToClipBoard(obj)
{
	var clipBoardContent="";
	clipBoardContent+=obj.value;
	window.clipboardData.setData("Text",clipBoardContent);
    //alert("复制成功");
}
/*******************************************/

/*********iframe自适应高********/
function iframeHeight(iframeName) {
	var pTar = null;
	if (document.getElementById){
		pTar = document.getElementById(iframeName);
	}
	else{
		document.getElementById('pTar = ' + iframeName + ';');
	}
	if (pTar && !window.opera){
		pTar.style.display="block"
		if (pTar.contentDocument && pTar.contentDocument.body.offsetHeight)
		{
			pTar.height = pTar.contentDocument.body.offsetHeight+FFextraHeight;
		}else if (pTar.Document && pTar.Document.body.scrollHeight)
		{
			pTar.height = pTar.Document.body.scrollHeight;
		}
	}
}
/*******************************************/

/*******获取showModalDialog的返回值**********/
function getShowModalDialog(url,width,height)
{
	var result = window.showModalDialog(url,self,'center:1;status:0;help:1;resized:0;unadorned:1;dialogwidth:'+width+'px;dialogheight:'+height+'px')
	if(result=="" || result == null)
	{
		return false
	}else{
		return result
	}
}
/*******************************************/

/*******用户上传图片及显示**********/
function showUploadPic(uploadUrl,textBoxID,showDivID)
{
	var result = getShowModalDialog(uploadUrl,350,120);
	if(result!=false)
	{
		document.getElementById(textBoxID).value = result
		if(showDivID!="" && showDivID!=null)
			document.getElementById(showDivID).innerHTML = "<img src='"+result+"' onload='javascript:if(this.width)>400{this.width=400}'>";
	}
}
function sc(id1,id2)
{
	var pic = document.getElementById(id1);
	if(pic.value != "" && pic.value != null)
	{
		document.getElementById(id2).innerHTML = "<img src='"+pic.value+"' onload='javascript:if(this.width)>400{this.width=400}'>"
	}
}
/*******************************************/

/*******设置地址成绝对地址**********/
function setRemoteUrl(url,pageUrl)
{	
	var rgx,matches,mc,picUrl,picUrl2,splitUrlArr
	var pUrl,sUrl,hUrl,psplitUrlArr,newUrl
	var k
	
	/*
	pageUrl = "http://www.cww.net.cn";
	pageUrl = "http://www.cww.net.cn/";
	pageUrl = "http://www.cww.net.cn/ad.sf/ttt";
	pageUrl = "http://www.cww.net.cn/?ter=ater";
	pageUrl = "http://www.cww.net.cn/te.r/erer/?ter";
	pageUrl = "http://www.cww.net.cn/eras/rrr.htm";
	pageUrl = "http://www.cww.net.cn/erer/ter.htm?erer=asdf";
	*/
	
	rgx = /^(http[s]?\:\/\/)([^\?]+?)(?:([\/][^\/]*?)(?:\?.*)?$|$)/
	if((matches = rgx.exec(pageUrl)) != null)
	{
		hUrl = matches[1];
		pUrl = matches[2];
		sUrl = matches[3];
		if(sUrl.indexOf(".") < 0)
			pUrl = pUrl + sUrl;
		if(pUrl.lastIndexOf("/") != (pUrl.length-1))
			pUrl = pUrl+"/";
	}else{
		return url;
	}
	
	picUrl = url.replace("&amp;","&")
	if(picUrl.indexOf("http://") == 0)
	{
		//*** http://xxx.com/x.jpg
		picUrl = picUrl
	}else if(picUrl.substring(0,2) == "./"){
		//*** ./x.jpg
		picUrl = hUrl + pUrl + picUrl.substring(2,picUrl.length)
	}else if(picUrl.substring(0,1) == "/"){
	//*** /x.jpg
		picUrl = hUrl + pUrl.split("/")[0] + picUrl
	}else if(picUrl.substring(0,3) == "../"){
		//*** ../../asdf/tt/x.jpg
		splitUrlArr = picUrl.split("../")
		psplitUrlArr = pUrl.split("/")
		if(splitUrlArr.length >= psplitUrlArr.length)
		{
			picUrl = hUrl + psplitUrlArr[0] + "/" + splitUrlArr[splitUrlArr.length-1]
		}else{
			newUrl = ""
			for(k = 0;k<psplitUrlArr.length-splitUrlArr.length;k++)
				newUrl = newUrl + psplitUrlArr[k] + "/"
			picUrl = hUrl + newUrl + splitUrlArr[splitUrlArr.length-1]
		}
	}else{
		//*** asdf/x.jpg
		picUrl = hUrl + pUrl + picUrl
	}
	
	return picUrl
	
}
/*******************************************/

function len(str)
{
	var num = 0;
	if(str == "" || str == null)
	{
		return 0;	
	}
	var specialStr = Array("&quot;","&amp;","&lt;","&gt;","&nbsp;","&acute;","&copy;","&middot;","&divide;","&deg;","&ldquo;","&rdquo;","&rsquo;");
	var specialKw = Array("\"","&","<",">"," ","'","","","","","“","”","‘","’");
	
	for(var i = 0;i<specialStr.length;i++)
	{
		str = str.replace(specialStr,specialKw);	
	}
	
	var sArr = str.split("");
	for(var i =0;i<sArr.length;i++)
	{
		if(sArr[i].charCodeAt(0)<299)
			num++;
		else
			num += 2;
	}
	
	return num;
}

/*
function createObject()
{
	if (window.XMLHttpRequest)
	{
		var objXMLHttp = new XMLHttpRequest();
	}else{
		var MSXML = ['MSXML2.XMLHTTP.5.0', 'MSXML2.XMLHTTP.4.0', 'MSXML2.XMLHTTP.3.0', 'MSXML2.XMLHTTP', 'Microsoft.XMLHTTP'];
		for(var n = 0; n < MSXML.length; n ++)
		{
			try
			{
				var objXMLHttp = new ActiveXObject(MSXML[n]);   
				break;
			}
			catch(e)
			{
			}
		}
		
		// mozilla某些版本没有readyState属性
		if (objXMLHttp.readyState == null)
		{
			objXMLHttp.readyState = 0;
			objXMLHttp.addEventListener("load", function ()
			{
				objXMLHttp.readyState = 4;
				if (typeof objXMLHttp.onreadystatechange == "function")
				{
					objXMLHttp.onreadystatechange();
				}
			},  false);
		}
		return objXMLHttp;
	}
}
*/
function refreshAD(url,tp,tm,first)
{
	//return false;
	var timemap;
	var matches,matches2,id;
	
	if(url.indexOf("|%$*|"))
	{
		var urlArr = url.split("|%$*|")
	}else{
		var urlArr = new Array(url);
	}
	//alert(window.location)
	//tp = "img"
	
	var rndNum = parseInt(Math.random()*tm*15000)+tm*10000;
	var script;// = ActiveXObject("");
	var dt = new Date();
	var hour = dt.getHours();
	if(first == 1)
	{
		var re = /\&rndNum=([a-z0-9]+)\|([0-9]+)/ig
		var re2 = /a11.asp\?id=([0-9]+)$/ig
		for(var i = 0;i<urlArr.length;i++)
		{
			if((matches = re.exec(urlArr[i])) != null)
			{
				timemap = parseInt(Math.random() * matches[2]);
				urlArr[i] = urlArr[i].replace(re,"&" + matches[1] + "=" + timemap)
				tm = 24000
			}
			if((matches2 = re2.exec(urlArr[i])) != null)
			{
				id = parseInt(matches2[1]);
				if((id == 65 || id == 66 || id == 67) && (hour >= 23 || hour < 7))
				{
					tm = tm * 2
					}
			}
			script = document.createElement(tp);
			script.src = urlArr[i];
			script.type = "text/javascript";
			script.width = "1";
			script.height = "1"
			document.body.appendChild(script);
			//alert(rndNum)
		}
		if(tp == "script" || tp == "img")
		{
			rndNum = parseInt(Math.random()*tm*20000)+tm*10000;
			/*
			script = document.createElement("script");
			script.type = "text/javascript";
			script.src = "/count/stat.asp?userid=43";
			//script.src = "/t.js";
			//document.write("<script src='" + "/count/mystat.asp?userid=43" + "' type='text/javascript' language='javascript'></" + "script>");
			document.body.appendChild(script);
			*/
		}
	}
	var timeout = setTimeout(function(){refreshAD(url,tp,tm,1)},rndNum)
}


//cookie操作
function setCookie(name,value)//两个参数，一个是cookie的名子，一个是值
{
    var Days = 30; //此 cookie 将被保存 30 天
    var exp  = new Date();    //new Date("December 31, 9998");
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString() + ";path=/";
}

function getCookie(name)//取cookies函数        
{
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
     if(arr != null) return unescape(arr[2]); return null;

}

function delCookie(name)//删除cookie
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}