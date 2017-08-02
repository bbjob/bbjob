

<#if confMap.lineNumber??>
    <table width='100%' align=''  border='0' bordercolor='' cellspacing='0' cellpadding='0' style='border-collapse:collapse;'>
        <#list htmlValue as data>

        <#if (data_index) % confMap.lineNumber?int == 0>
            <tr>
                <td>
                    <table width="100%" border="0" align="center" style="" bordercolor='' cellspacing='0' cellpadding='0' class="modalTable">
                        <tbody>
                            <#list confMap.confAlphaList as alpha>
                                <#if alpha_index gte 2>
                                         <tr>
                                             <td colspan="2">
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
                                                    <div class="${confMap.className}author">作者：${data.dataList[3]}</div>
                                                <#elseif alpha == "l">
                                                    <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                                <#elseif alpha == "d">
                                                    <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                                <#else>
                                                </#if>
                                             </td>
                                         </tr>
                                <#else>
                                        <#if alpha_index == 0>
                                            <tr>
                                        </#if>

                                        <#if alpha == "t">
                                            <td>
                                                <div class="${confMap.className}title">
                                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                                </div>
                                            </td>
                                        <#elseif alpha == "p">
                                            <td>
                                                <div class="${confMap.className}pic">
                                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title='${data.dataList[0]}'></a>                                        </div>
                                                </td>
                                        <#elseif alpha == "s">
                                            <td>
                                                <div class="${confMap.className}content">${data.dataList[1]}</div>
                                            </td>
                                        <#elseif alpha == "a">
                                            <td>
                                                <div class="${confMap.className}author">作者：${data.dataList[3]}</div>
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
                                    <#if alpha_index gte 2>
                                        </tr>
                                    </#if>
                                </#if>
                            </#list>
                        </tbody>
                    </table>
                </td>
        <#else>
                <td>
                     <table width="100%" border="0" align="center" style="" bordercolor='' cellspacing='0' cellpadding='0' class="modalTable yysNewsPer">
                        <tbody>
                            <#list confMap.confAlphaList as alpha>
                                <#if alpha_index gte 2>
                                         <tr>
                                             <td colspan="2">
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
                                                    <div class="${confMap.className}author">作者：${data.dataList[3]}</div>
                                                <#elseif alpha == "l">
                                                    <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                                <#elseif alpha == "d">
                                                    <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                                <#else>
                                                </#if>
                                             </td>
                                         </tr>


                                <#else>
                                        <#if alpha_index == 0>
                                            <tr>
                                        </#if>

                                        <#if alpha == "t">
                                            <td>
                                                <div class="${confMap.className}title">
                                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                                </div>
                                            </td>
                                        <#elseif alpha == "p">
                                            <td>
                                                <div class="${confMap.className}pic">
                                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title='${data.dataList[0]}'></a>                                        </div>
                                                </td>
                                        <#elseif alpha == "s">
                                            <td>
                                                <div class="${confMap.className}content">${data.dataList[1]}</div>
                                            </td>
                                        <#elseif alpha == "a">
                                            <td>
                                                <div class="${confMap.className}author">作者：${data.dataList[3]}</div>
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
                                    <#if alpha_index gte 2>
                                        </tr>
                                    </#if>
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
                     <table width="100%" border="0" align="center" style="" bordercolor='' cellspacing='0' cellpadding='0' class="modalTable">
                        <tbody>
                            <#list confMap.confAlphaList as alpha>
                                <#if alpha_index gte 2>
                                         <tr>
                                             <td colspan="2">
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
                                                    <div class="${confMap.className}author">作者：${data.dataList[3]}</div>
                                                <#elseif alpha == "l">
                                                    <div class="${confMap.className}content">浏览量：${data.dataList[4]}</div>
                                                <#elseif alpha == "d">
                                                    <div class="${confMap.className}content">时间：${data.dataList[5]}</div>
                                                <#else>
                                                </#if>
                                             </td>
                                         </tr>


                                <#else>
                                        <#if alpha_index == 0>
                                            <tr>
                                        </#if>

                                        <#if alpha == "t">
                                            <td>
                                                <div class="${confMap.className}title">
                                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" target="_blank">${data.dataList[0]}</a>
                                                </div>
                                            </td>
                                        <#elseif alpha == "p">
                                            <td>
                                                <div class="${confMap.className}pic">
                                                    <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'><img src='${data.dataList[2]}' border=0 width='${confMap.picWide?default(314)}' height='${confMap.picHeight?default(195)}' title='${data.dataList[0]}'></a>                                        </div>
                                                </td>
                                        <#elseif alpha == "s">
                                            <td>
                                                <div class="${confMap.className}content">${data.dataList[1]}</div>
                                            </td>
                                        <#elseif alpha == "a">
                                            <td>
                                                <div class="${confMap.className}author">作者：${data.dataList[3]}</div>
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
                                    <#if alpha_index gte 2>
                                        </tr>
                                    </#if>
                                </#if>
                            </#list>
                        </tbody>
                    </table>
    </#list>
</#if>

