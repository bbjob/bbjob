<style>
    .hyzb #cwwtd{background-color:#fff;padding-bottom:25px;width:33%;vertical-align:top;border-top:3px solid #fff;padding-top:25px; background:none;}
    .hyzb #cwwtr14070_1 #cwwtd{border-top:0;}
    .hyzb #modeTable{width:326px;height:396px;overflow:hidden;background:url(images/perBG.png) center center no-repeat;background-color:#fff;}
    .hyzb #cww3041{text-align:center;vertical-align:top;padding-top:7px;height:195px;}
    .hyzb #cww3041 img{width:314px;height:195px;border:0;}
    .hyzb #cww3042{padding:25px 0 15px 0;vertical-align:top;height:56px;}
    .hyzb #cww3042,.hyzb #cww3042 a:link,.hyzb #cww3042 a:visited,.hyzb #cww3042 a:hover,.hyzb #cww3042 a:active{font-size:20px;line-height:28px;font-weight:600;color:#444;text-decoration:none;}
    .hyzb #cww3042 a:hover{color:#f30;}
    .hyzb #cww3043{color:#777;font-size:16px;vertical-align:top;line-height:30px;height:100px;}
    .hyzb #cww3042,.hyzb #cww3043{padding-left:16px;padding-right:12px;}
</style>
<table width='100%' align=''  border='0' bordercolor='' cellspacing='0' cellpadding='0' style='border-collapse:collapse;'>
    <#list htmlValue as data>

        <#if (data_index) % confMap.cols?int == 0>
            <tr id="cwwtr14070_1">
                <td background='' bgcolor='' id='cwwtd'>
                    <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" style="border-collapse:collapse" id="modeTable">
                        <tr>
                            <td id="cww3041"><a href='${data.link}' class='' title='${data.title}' target='_blank'><img src='${data.img}' border=0 width='314' height='195' title='${data.title}'></a></td>
                        </tr>
                        <tr>
                            <td id="cww3042"><a href='${data.link}' class='' title='${data.title}' target='_blank'>${data.title}</a></td>
                        </tr>
                        <tr>
                            <td id="cww3043">${data.content}</td>
                        </tr>
                    </table>
                </td>
                <#else>
                    <td background='' bgcolor='' id='cwwtd'>
                        <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" style="border-collapse:collapse" id="modeTable">
                            <tr>
                                <td id="cww3041"><a href='${data.link}' class='' title='${data.title}' target='_blank'><img src='${data.img}' border=0 width='314' height='195' title='${data.title}'></a></td>
                            </tr>
                            <tr>
                                <td id="cww3042"><a href='${data.link}' class='' title='${data.title}' target='_blank'>${data.title}</a></td>
                            </tr>
                            <tr>
                                <td id="cww3043">${data.content}</td>
                            </tr>
                        </table>
                    </td>
        </#if>

        <#if (data_index + 1) == data?size>
            </tr>
        </#if>

    </#list>
</table>