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
                                    <#if alpha_index lt 2>
                                        <#if alpha_index == 0>
                                            <td rowspan="2" class="cww3021">
                                        <#else>
                                            <td class="cww3022">
                                        </#if>

                                        <#if alpha == "t">
                                            <div class="${confMap.className}title">
                                                <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                            </div>
                                            </td>
                                        <#elseif alpha == "p">
                                            <div class="${confMap.className}pic">
                                                <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default("409px")}' height='${confMap.picHeight?default("237px")}' title='${data.dataList[0]}'></a>
                                            </div>
                                            </td>
                                        <#elseif alpha == "s">
                                            <div class="${confMap.className}content">${data.dataList[1]}</div>
                                            </td>
                                        <#elseif alpha == "a">
                                            <div class="${confMap.className}content">作者：${data.dataList[3]}</div>
                                            </td>
                                        <#elseif alpha == "l">
                                            <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                            </td>
                                        <#elseif alpha == "d">
                                            <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                            </td>
                                        <#else>
                                        </#if>

                                    <#else>
                                        </tr>
                                        <#if alpha == "t">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}title">
                                                <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                            </div>
                                            </td></tr>
                                        <#elseif alpha == "p">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}pic">
                                                <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title='${data.dataList[0]}'></a>
                                            </div>
                                            </td></tr>
                                        <#elseif alpha == "s">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}content">${data.dataList[1]}</div>
                                            </td></tr>
                                        <#elseif alpha == "a">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}content">作者：${data.dataList[3]}</div>
                                            </td></tr>
                                        <#elseif alpha == "l">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                            </td></tr>
                                        <#elseif alpha == "d">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                            </td></tr>
                                        <#else>
                                        </#if>
                                    </#if>
                                </#list>
                        </table>
                    </td>
            <#else>
                        <td class="cwwtd">
                        <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" style="border-collapse:collapse" class="modeTable">
                            <tr>
                                <#list confMap.confAlphaList as alpha>
                                    <#if alpha_index lt 2>
                                        <#if alpha_index == 0>
                                            <td rowspan="2" class="cww3021">
                                        <#else>
                                            <td class="cww3022">
                                        </#if>

                                        <#if alpha == "t">
                                            <div class="${confMap.className}title">
                                                <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                            </div>
                                            </td>
                                        <#elseif alpha == "p">
                                            <div class="${confMap.className}pic">
                                                <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src="${data.dataList[2]?default('')}" border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title='${data.dataList[0]}'></a>
                                            </div>
                                            </td>
                                        <#elseif alpha == "s">
                                            <div class="${confMap.className}content">${data.dataList[1]}</div>
                                            </td>
                                        <#elseif alpha == "a">
                                            <div class="${confMap.className}content">作者：${data.dataList[3]}</div>
                                            </td>
                                        <#elseif alpha == "l">
                                            <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                            </td>
                                        <#elseif alpha == "d">
                                            <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                            </td>
                                        <#else>
                                        </#if>

                                    <#else>
                                        </tr>
                                        <#if alpha == "t">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}title">
                                                <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                            </div>
                                            </td></tr>
                                        <#elseif alpha == "p">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}pic">
                                                <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title='${data.dataList[0]}'></a>
                                            </div>
                                            </td></tr>
                                        <#elseif alpha == "s">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}content">${data.dataList[1]}</div>
                                            </td></tr>
                                        <#elseif alpha == "a">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}content">作者：${data.dataList[3]}</div>
                                            </td></tr>
                                        <#elseif alpha == "l">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                            </td></tr>
                                        <#elseif alpha == "d">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                            </td></tr>
                                        <#else>
                                        </#if>
                                    </#if>
                                </#list>
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
        <div>
            <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" style="border-collapse:collapse" class="modeTable">
                            <tr>
                                <#list confMap.confAlphaList as alpha>
                                    <#if alpha_index lt 2>
                                        <#if alpha_index == 0>
                                            <td rowspan="2" class="cww3021">
                                        <#else>
                                            <td class="cww3022">
                                        </#if>

                                        <#if alpha == "t">
                                            <div class="${confMap.className}title">
                                                <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                            </div>
                                            </td>
                                        <#elseif alpha == "p">
                                            <div class="${confMap.className}pic">
                                                <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default("")}' height='${confMap.picHeight?default("")}' title='${data.dataList[0]}'></a>
                                            </div>
                                            </td>
                                        <#elseif alpha == "s">
                                            <div class="${confMap.className}content">${data.dataList[1]}</div>
                                            </td>
                                        <#elseif alpha == "a">
                                            <div class="${confMap.className}content">作者：${data.dataList[3]}</div>
                                            </td>
                                        <#elseif alpha == "l">
                                            <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                            </td>
                                        <#elseif alpha == "d">
                                            <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                            </td>
                                        <#else>
                                        </#if>

                                    <#else>
                                        </tr>
                                        <#if alpha == "t">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}title">
                                                <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                            </div>
                                            </td></tr>
                                        <#elseif alpha == "p">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}pic">
                                                <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default("")}' height='${confMap.picHeight?default("")}' title='${data.dataList[0]}'></a>
                                            </div>
                                            </td></tr>
                                        <#elseif alpha == "s">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}content">${data.dataList[1]}</div>
                                            </td></tr>
                                        <#elseif alpha == "a">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}content">作者：${data.dataList[3]}</div>
                                            </td></tr>
                                        <#elseif alpha == "l">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                            </td></tr>
                                        <#elseif alpha == "d">
                                            <tr><td class="cww3023">
                                            <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                            </td></tr>
                                        <#else>
                                        </#if>
                                    </#if>
                                </#list>
            </table>
        </div>
    </#list>
</#if>
