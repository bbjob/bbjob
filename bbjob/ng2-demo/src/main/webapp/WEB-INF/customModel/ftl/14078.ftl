<style>
    .zjgdTitle{padding:0 10px;margin-top:20px;text-align:center;height:46px;width:452px;float:left;overflow:hidden;background:url(/mnt/ftl/20170517/images/images/zjgd_bg.jpg) center center no-repeat;}
    .zjgdTitle,.zjgdTitle a:link,.zjgdTitle a:hover,.zjgdTitle a:active,.zjgdTitle a:visited{font-size:18px;color:#555;font-weight:600;line-height:46px;}
    ..zjgdTitle a:hover{color:#ff3300;}
</style>

<#list htmlValue as data>
    <div class="${confMap.className}"><a href="${data.link}" target="_blank">${data.title}</a></div>
</#list>