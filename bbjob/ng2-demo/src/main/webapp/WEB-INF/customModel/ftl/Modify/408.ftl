<#if confMap.lineNumber??>
    <table width='100%' align=''  border='0' bordercolor='' cellspacing='0' cellpadding='0' style='border-collapse:collapse;'>
        <#list htmlValue as data>

        <#if (data_index) % confMap.lineNumber?int == 0>
            <tr>
                <td>
                    <div class="modalTable">
                        <#list confMap.confAlphaList as alpha>
                            <#if alpha == "t">
                                <div class="${confMap.className}title_fl ${confMap.className}fl">
                                    <#if confMap.prefixType??>
                                        <#if confMap.prefixType == 0>
                                            ${confMap.prefixContent}
                                        <#else>
                                            <img src="${confMap.prefixPic?default('')}">
                                        </#if>
                                    </#if>
                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]?default('')}</a>
                                </div>
                            <#elseif alpha == "p">
                                <div class="${confMap.className}pic_fl ${confMap.className}fl">
                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" title="${data.dataList[0]?default('')}" target='_blank'><img src="${data.dataList[2]?default('/mnt/ftl/customModel/images/picNotFund.jpg')}" border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title="${data.dataList[0]?default('')}"></a>
                                </div>
                            <#elseif alpha == "s">
                                <div class="${confMap.className}content_fl ${confMap.className}fl">${data.dataList[1]?default('')}</div>
                            <#elseif alpha == "a">
                                <div class="${confMap.className}author_fl ${confMap.className}fl">作者：${data.dataList[3]?default('')}</div>
                            <#elseif alpha == "l">
                                <div class="${confMap.className}pv_fl ${confMap.className}fl">浏览量：${data.dataList[4]?default('')}</div>
                            <#elseif alpha == "d">
                                <div class="${confMap.className}date_fl ${confMap.className}fl">时间：${data.dataList[5]?default('')}</div>
                            <#else>
                            </#if>
                        </#list>
                    </div>
                </td>
        <#else>
                <td>
                    <div class="modalTable">
                        <#list confMap.confAlphaList as alpha>
                            <#if alpha == "t">
                                <div class="${confMap.className}title_fl ${confMap.className}fl">
                                    <#if confMap.prefixType??>
                                        <#if confMap.prefixType == 0>
                                            ${confMap.prefixContent}
                                        <#else>
                                            <img src="${confMap.prefixPic?default('')}">
                                        </#if>
                                    </#if>
                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]?default('')}</a>
                                </div>
                            <#elseif alpha == "p">
                                <div class="${confMap.className}pic_fl ${confMap.className}fl">
                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" title="${data.dataList[0]?default('')}" target='_blank'><img src="${data.dataList[2]?default('/mnt/ftl/customModel/images/picNotFund.jpg')}" border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title="${data.dataList[0]?default('')}"></a>
                                </div>
                            <#elseif alpha == "s">
                                <div class="${confMap.className}content_fl ${confMap.className}fl">${data.dataList[1]?default('')}</div>
                            <#elseif alpha == "a">
                                <div class="${confMap.className}author_fl ${confMap.className}fl">作者：${data.dataList[3]?default('')}</div>
                            <#elseif alpha == "l">
                                <div class="${confMap.className}pv_fl ${confMap.className}fl">浏览量：${data.dataList[4]?default('')}</div>
                            <#elseif alpha == "d">
                                <div class="${confMap.className}date_fl ${confMap.className}fl">时间：${data.dataList[5]?default('')}</div>
                            <#else>
                            </#if>
                        </#list>
                    </div>
                </td>
        </#if>
        <#if (data_index + 1) == data?size>
            </tr>
        </#if>
    </#list>

    </table>
<#else>
    <#list htmlValue as data>
        <div class="modalTable">
            <#list confMap.confAlphaList as alpha>
                <#if alpha == "t">
                    <div class="${confMap.className}title_fl ${confMap.className}fl">
                        <#if confMap.prefixType??>
                            <#if confMap.prefixType == 0>
                                ${confMap.prefixContent}
                            <#else>
                                <img src="${confMap.prefixPic?default('')}">
                            </#if>
                        </#if>
                        <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]?default('')}</a>
                    </div>
                <#elseif alpha == "p">
                    <div class="${confMap.className}pic_fl ${confMap.className}fl">
                        <a href="${data.dataList[6]?default('javascript:void(0)')}" title="${data.dataList[0]?default('')}" target='_blank'><img src="${data.dataList[2]?default('/mnt/ftl/customModel/images/picNotFund.jpg')}" border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title="${data.dataList[0]?default('')}"></a>
                    </div>
                <#elseif alpha == "s">
                    <div class="${confMap.className}content_fl ${confMap.className}fl">${data.dataList[1]?default('')}</div>
                <#elseif alpha == "a">
                    <div class="${confMap.className}author_fl ${confMap.className}fl">作者：${data.dataList[3]?default('')}</div>
                <#elseif alpha == "l">
                    <div class="${confMap.className}pv_fl ${confMap.className}fl">浏览量：${data.dataList[4]?default('')}</div>
                <#elseif alpha == "d">
                    <div class="${confMap.className}date_fl ${confMap.className}fl">时间：${data.dataList[5]?default('')}</div>
                <#else>
                </#if>
            </#list>
        </div>
    </#list>
</#if>

