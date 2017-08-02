<style>
    .yysNewsPer{width:222px;overflow:hidden;float:left;background-color:#1483F9;}
    .yysNewsPer2{margin-left:37px;}
    .yysNewsPics{background-color:#fff;}
    .yysNewsPics img{border:0;width:222px;height:150px;}
    .yysNewsTitle{padding:10px 8px 0 8px;text-align:center;}
    .yysNewsTitle,.yysNewsTitle a:link,.yysNewsTitle a:hover,.yysNewsTitle a:active,.yysNewsTitle a:visited{font-size:16px;color:#f8f8f8;font-weight:600;line-height:26px;}
    .yysNewsTitle a:hover{color:#ffff00;}
    .yysNewsName{font-size:16px;color:#f8f8f8;font-weight:bold;text-align:center;padding:15px 0 10px 0;border-bottom:1px solid #f8f8f8;width:80%;margin:0 auto;}
    .yysNewsContent{color:#f0f0f0;padding:8px 8px 18px 8px;line-height:22px;font-size:14px;}
</style>
<#list htmlValue as data>
    <#if data_index == 0>
        <div class="${confMap.className}Per">
            <#else>
                <div class="${confMap.className}Per ${confMap.className}Per2">
    </#if>
    <div class="${confMap.className}Pics"><a href="${data.link}" target="_blank"><img src="${data.img}"></a></div>
    <div class="${confMap.className}Name">${data.author}</div>
    <div class="${confMap.className}Title"><a href="${data.link}" target="_blank">${data.title}</a></div>
    <div class="${confMap.className}Content">${data.content}</div>
    </div>
</#list>