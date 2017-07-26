<#if confMap.lineNumber??>
    <table width='100%' align=''  border='0' bordercolor='' cellspacing='0' cellpadding='0' style='border-collapse:collapse;'>
        <#list htmlValue as data>
            <#if (data_index) % confMap.lineNumber?int == 0>
                <tr>
                    <td>
                        <table width="100%" border="0" align="center" style="" bordercolor='' cellspacing='0' cellpadding='0' class="modalTable">
                            <tbody>
                                <tr>
                                    <#list confMap.confAlphaList as alpha>
                                        <#if alpha_index lt 3>
                                            <#if alpha_index == 0 || alpha_index == 2>
                                                <td rowspan="2">
                                            <#else>
                                                <td>
                                            </#if>

                                            <#if alpha == "t">
                                                <div class="${confMap.className}title">
                                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                                </div>
                                            <#elseif alpha == "p">
                                                <div class="${confMap.className}pic">
                                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title='${data.dataList[0]}'></a>
                                                </div>
                                            <#elseif alpha == "s">
                                                <div class="${confMap.className}content">${data.dataList[1]}</div>
                                            <#elseif alpha == "a">
                                                <div class="${confMap.className}author">${data.dataList[3]}</div>
                                            <#elseif alpha == "l">
                                                <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                            <#elseif alpha == "d">
                                                <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                            <#else>
                                            </#if>

                                            </td>

                                        <#else>
                                            </tr>
                                            <tr><td>
                                                <#if alpha == "t">
                                                    <div class="${confMap.className}title">
                                                        <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                                    </div>
                                                <#elseif alpha == "p">
                                                    <div class="${confMap.className}pic">
                                                        <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title='${data.dataList[0]}'></a>
                                                    </div>
                                                <#elseif alpha == "s">
                                                    <div class="${confMap.className}content">${data.dataList[1]}</div>
                                                <#elseif alpha == "a">
                                                    <div class="${confMap.className}author">${data.dataList[3]}</div>
                                                <#elseif alpha == "l">
                                                    <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                                <#elseif alpha == "d">
                                                    <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                                <#else>
                                                </#if>
                                            </td></tr>
                                        </#if>
                                    </#list>
                            </tbody>
                        </table>
                    </td>
            <#else>
                <td>
                        <table width="100%" border="0" align="center" style="" bordercolor='' cellspacing='0' cellpadding='0' class="modalTable yysNewsPer">
                            <tbody>
                                <tr>
                                    <#list confMap.confAlphaList as alpha>
                                        <#if alpha_index lt 3>
                                            <#if alpha_index == 0 || alpha_index == 2>
                                                <td rowspan="2">
                                            <#else>
                                                <td>
                                            </#if>

                                            <#if alpha == "t">
                                                <div class="${confMap.className}title">
                                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                                </div>
                                            <#elseif alpha == "p">
                                                <div class="${confMap.className}pic">
                                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title='${data.dataList[0]}'></a>
                                                </div>
                                            <#elseif alpha == "s">
                                                <div class="${confMap.className}content">${data.dataList[1]}</div>
                                            <#elseif alpha == "a">
                                                <div class="${confMap.className}author">${data.dataList[3]}</div>
                                            <#elseif alpha == "l">
                                                <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                            <#elseif alpha == "d">
                                                <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                            <#else>
                                            </#if>

                                            </td>

                                        <#else>
                                            </tr>
                                            <tr><td>
                                                <#if alpha == "t">
                                                    <div class="${confMap.className}title">
                                                        <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                                    </div>
                                                <#elseif alpha == "p">
                                                    <div class="${confMap.className}pic">
                                                        <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title='${data.dataList[0]}'></a>
                                                    </div>
                                                <#elseif alpha == "s">
                                                    <div class="${confMap.className}content">${data.dataList[1]}</div>
                                                <#elseif alpha == "a">
                                                    <div class="${confMap.className}author">${data.dataList[3]}</div>
                                                <#elseif alpha == "l">
                                                    <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                                <#elseif alpha == "d">
                                                    <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                                <#else>
                                                </#if>
                                            </td></tr>
                                        </#if>
                                    </#list>
                            </tbody>
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
                        <table width="100%" border="0" align="center" style="" bordercolor='' cellspacing='0' cellpadding='0' class="modalTable">
                            <tbody>
                                <tr>
                                    <#list confMap.confAlphaList as alpha>
                                        <#if alpha_index lt 3>
                                            <#if alpha_index == 0 || alpha_index == 2>
                                                <td rowspan="2">
                                            <#else>
                                                <td>
                                            </#if>

                                            <#if alpha == "t">
                                                <div class="${confMap.className}title">
                                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                                </div>
                                            <#elseif alpha == "p">
                                                <div class="${confMap.className}pic">
                                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title='${data.dataList[0]}'></a>
                                                </div>
                                            <#elseif alpha == "s">
                                                <div class="${confMap.className}content">${data.dataList[1]}</div>
                                            <#elseif alpha == "a">
                                                <div class="${confMap.className}author">${data.dataList[3]}</div>
                                            <#elseif alpha == "l">
                                                <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                            <#elseif alpha == "d">
                                                <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                            <#else>
                                            </#if>

                                            </td>

                                        <#else>
                                            </tr>
                                            <tr><td>
                                                <#if alpha == "t">
                                                    <div class="${confMap.className}title">
                                                        <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                                    </div>
                                                <#elseif alpha == "p">
                                                    <div class="${confMap.className}pic">
                                                        <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title='${data.dataList[0]}'></a>
                                                    </div>
                                                <#elseif alpha == "s">
                                                    <div class="${confMap.className}content">${data.dataList[1]}</div>
                                                <#elseif alpha == "a">
                                                    <div class="${confMap.className}author">${data.dataList[3]}</div>
                                                <#elseif alpha == "l">
                                                    <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                                <#elseif alpha == "d">
                                                    <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                                <#else>
                                                </#if>
                                            </td></tr>
                                        </#if>
                                    </#list>
                            </tbody>
                        </table>
        </div>
    </#list>
</#if>