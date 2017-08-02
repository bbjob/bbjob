<#if confMap.lineNumber??>
    <table width='100%' align=''  border='0' bordercolor='' cellspacing='0' cellpadding='0' style='border-collapse:collapse;'>
        <#list htmlValue as data>

        <#if (data_index) % confMap.lineNumber?int == 0>
            <#if (data_index) / confMap.lineNumber?int == 0>
                <tr class="cwwtr14070_1">
            <#else>
                <tr>
            </#if>
                <td class="cwwtd">
                    <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" style="border-collapse:collapse" class="modeTable">
                        <tr>
                            <#list confMap.confAlphaList as alpha>
                                <#if alpha == "t">
                                    <td>
                                    <div class="${confMap.className}title">
                                        <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                    </div>
                                    </td>
                                <#elseif alpha == "p">
                                    <td>
                                    <div class="${confMap.className}pic">
                                        <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title='${data.dataList[0]}'></a>
                                    </div>
                                    </td>
                                <#elseif alpha == "s">
                                    <td>
                                    <div class="${confMap.className}content">${data.dataList[1]}</div>
                                    </td>
                                <#elseif alpha == "a">
                                    <td>
                                    <div class="${confMap.className}content">作者：${data.dataList[3]}</div>
                                    </td>
                                <#elseif alpha == "l">
                                    <td>
                                    <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                    </td>
                                <#elseif alpha == "d">
                                    <td>
                                    <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                    </td>
                                <#else>
                                </#if>
                            </#list>
                        </tr>
                    </table>
                </td>
        <#else>
                    <td class="cwwtd">
                        <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" style="border-collapse:collapse" class="modeTable">
                            <tr>
                                <#list confMap.confAlphaList as alpha>
                                    <#if alpha == "t">
                                        <td>
                                        <div class="${confMap.className}title">
                                            <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                        </div>
                                        </td>
                                    <#elseif alpha == "p">
                                        <td>
                                        <div class="${confMap.className}pic">
                                            <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title='${data.dataList[0]}'></a>
                                        </div>
                                        </td>
                                    <#elseif alpha == "s">
                                        <td>
                                        <div class="${confMap.className}content">${data.dataList[1]}</div>
                                        </td>
                                    <#elseif alpha == "a">
                                        <td>
                                        <div class="${confMap.className}content">作者：${data.dataList[3]}</div>
                                        </td>
                                    <#elseif alpha == "l">
                                        <td>
                                        <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                        </td>
                                    <#elseif alpha == "d">
                                        <td>
                                        <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                        </td>
                                    <#else>
                                    </#if>
                                </#list>
                            </tr>
                        </table>
                    </td>
        </#if>
        <#if (data_index + 1) == data?size>
            </tr>
        </#if>
    </#list>

    </table>
<#else>
    <#list htmlValue as data>
        <#if data_index != 0>
            <div class="${confMap.className}line"></div>
        </#if>
        <div>
            <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" style="border-collapse:collapse" class="modeTable">
                <tr>
                    <#list confMap.confAlphaList as alpha>
                        <#if alpha == "t">
                            <td>
                                <div class="${confMap.className}title">
                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                </div>
                            </td>
                        <#elseif alpha == "p">
                            <td>
                                <div class="${confMap.className}pic">
                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title='${data.dataList[0]}'></a>
                                </div>
                            </td>
                        <#elseif alpha == "s">
                            <td>
                                <div class="${confMap.className}content">${data.dataList[1]}</div>
                            </td>
                        <#elseif alpha == "a">
                            <td>
                                <div class="${confMap.className}content">作者：${data.dataList[3]}</div>
                            </td>
                        <#elseif alpha == "l">
                            <td>
                                <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                            </td>
                        <#elseif alpha == "d">
                            <td>
                                <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                            </td>
                        <#else>
                        </#if>
                    </#list>
                </tr>
            </table>
        </div>
    </#list>
</#if>

