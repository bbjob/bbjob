function ReBuild(html)
{
	var datas,dataHTML
	//<STRONG><P style="TEXT-INDENT: 2em">通信世界网讯(CWW)</P></STRONG>
	
	//去掉html标签
	dataHtml = html;
	//判断角标
	//	dataHtml=dataHtml.replace(/<sup(.*?)>([^>]+)<\/sup>/gmi,"@jb@");
	var pattern = /<strong[^<>]*>[\s]*(<p[^<>]*>)/gmi;
	if(pattern.test(dataHtml))
		dataHtml = dataHtml.replace(pattern,"$1")
	var pattern = /<(?!(?:img|br|\/p|b|strong|\/b|\/strong)\b)\/??[^>]*>/gmi;
	if(pattern.test(dataHtml))
		dataHtml = dataHtml.replace(pattern,"")
	var pattern = /(<\/p>)[\s]*<\/strong>/gmi;
	if(pattern.test(dataHtml))
		dataHtml = dataHtml.replace(pattern,"$1")
	pattern = /^(&nbsp;|\s|　)*(<strong>|<b>)*(&nbsp;|\s|　)*/gmi
	if(pattern.test(dataHtml))
		dataHtml = dataHtml.replace(pattern,"$2")
	pattern = /<\/p>|\r\n/gmi
	dataHtml = dataHtml.replace(pattern,"<BR>")
	
	datas = dataHtml.split("<BR>")
	dataHtml = ""
	pattern = /^(&nbsp;|\s|　)*([\s\S]*?)(&nbsp;|\s|　)*$/
	
	for(i in datas)
	{
		if (datas[i].replace("&nbsp;","")!="")
		{
			if(pattern.test(datas[i]))
				datas[i] = datas[i].replace(pattern,"$2")
			dataHtml = dataHtml+"<P style=\"text-indent:2em;\">"+datas[i]+"</P>";			
		}
	}
	
	pattern = /<p[^<>]*>(<img [^<>]+>)<\/p>/gmi
	if(pattern.test(dataHtml))
	{
		dataHtml = dataHtml.replace(pattern,"<P style=\"text-align:center\">$1</P>")
	}
	//dataHtml=dataHtml.replace(/英特尔®/g,"<sup>®<\sup>");
	return dataHtml;
}