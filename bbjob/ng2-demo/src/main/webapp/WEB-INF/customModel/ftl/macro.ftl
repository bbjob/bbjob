<#macro picArtParent boardID extAttr>
    <@picArtList clumnId = "${boardID}" extAttr = "${extAttr}">
        <#if confMap.model?index_of("201") != -1>
            <#include "DIV/201.ftl" />
        </#if>

        <#if confMap.model?index_of("202") != -1>
            <#include "DIV/202.ftl" />
        </#if>

        <#if confMap.model?index_of("301") != -1>
            <#include "DIV/301.ftl" />
        </#if>

        <#if confMap.model?index_of("302") != -1>
            <#include "DIV/302.ftl" />
        </#if>

        <#if confMap.model?index_of("303") != -1>
            <#include "DIV/303.ftl" />
        </#if>

        <#if confMap.model?index_of("304") != -1>
            <#include "DIV/304.ftl" />
        </#if>

        <#if confMap.model?index_of("305") != -1>
            <#include "DIV/305.ftl" />
        </#if>

        <#if confMap.model?index_of("306") != -1>
            <#include "DIV/306.ftl" />
        </#if>

        <#if confMap.model?index_of("401") != -1>
            <#include "Modify/401.ftl" />
        </#if>

        <#if confMap.model?index_of("402") != -1>
            <#include "Modify/402.ftl" />
        </#if>

        <#if confMap.model?index_of("403") != -1>
            <#include "Modify/403.ftl" />
        </#if>

        <#if confMap.model?index_of("404") != -1>
            <#include "Modify/404.ftl" />
        </#if>

        <#if confMap.model?index_of("405") != -1>
            <#include "Modify/405.ftl" />
        </#if>

        <#if confMap.model?index_of("406") != -1>
            <#include "Modify/406.ftl" />
        </#if>

        <#if confMap.model?index_of("407") != -1>
            <#include "Modify/407.ftl" />
        </#if>

        <#if confMap.model?index_of("408") != -1>
            <#include "Modify/408.ftl" />
        </#if>

        <#if confMap.model?index_of("409") != -1>
            <#include "Modify/409.ftl" />
        </#if>

        <#if confMap.model?index_of("410") != -1>
            <#include "Modify/410.ftl" />
        </#if>

        <#if confMap.model?index_of("411") != -1>
            <#include "Modify/411.ftl" />
        </#if>

        <#if confMap.model?index_of("412") != -1>
            <#include "Modify/412.ftl" />
        </#if>

        <#if confMap.model?index_of("413") != -1>
            <#include "Modify/413.ftl" />
        </#if>

        <#if confMap.model?index_of("414") != -1>
            <#include "Modify/414.ftl" />
        </#if>

        <#if confMap.model?index_of("415") != -1>
            <#include "Modify/415.ftl" />
        </#if>

        <#if confMap.model?index_of("416") != -1>
            <#include "Modify/416.ftl" />
        </#if>

        <#if confMap.model?index_of("417") != -1>
            <#include "Modify/417.ftl" />
        </#if>

        <#if confMap.model?index_of("418") != -1>
            <#include "Modify/418.ftl" />
        </#if>

    </@picArtList>
</#macro>

<#macro CarouselFigure boardID extAttr>
    <@picArtList clumnId = "${boardID}" extAttr = "${extAttr}">
        <#include "Carousel/cf.ftl" />
    </@picArtList>
</#macro>

<#macro VideoOnline boardID extAttr>
    <@picArtList clumnId = "${boardID}" extAttr = "${extAttr}">
        <#include "Video/vo.ftl" />
    </@picArtList>
</#macro>


<#macro dirSeedParent webCastId extAttr>
    <@dirSeed webCastId = "${webCastId}" extAttr = "${extAttr}">
        <#include "DirSeed/ds.ftl" />
    </@dirSeed>
</#macro>

<#macro SurveyParent surveyId extAttr>
    <@survey surveyId = "${surveyId}" extAttr = "${extAttr}">
        <#include "Survey/sv.ftl">
    </@survey>
</#macro>

<#macro CommonLabelParent boardID extAttr>
    <@commonLabel clumnId = "${boardID}" extAttr = "${extAttr}">
    <#if confMap.flatBit = "1">
        <#if confMap.model?index_of("201") != -1>
            <#include "DIV/201.ftl" />
        </#if>

        <#if confMap.model?index_of("202") != -1>
            <#include "DIV/202.ftl" />
        </#if>

        <#if confMap.model?index_of("301") != -1>
            <#include "DIV/301.ftl" />
        </#if>

        <#if confMap.model?index_of("302") != -1>
            <#include "DIV/302.ftl" />
        </#if>

        <#if confMap.model?index_of("303") != -1>
            <#include "DIV/303.ftl" />
        </#if>

        <#if confMap.model?index_of("304") != -1>
            <#include "DIV/304.ftl" />
        </#if>

        <#if confMap.model?index_of("305") != -1>
            <#include "DIV/305.ftl" />
        </#if>

        <#if confMap.model?index_of("306") != -1>
            <#include "DIV/306.ftl" />
        </#if>

        <#if confMap.model?index_of("401") != -1>
            <#include "Modify/401.ftl" />
        </#if>

        <#if confMap.model?index_of("402") != -1>
            <#include "Modify/402.ftl" />
        </#if>

        <#if confMap.model?index_of("403") != -1>
            <#include "Modify/403.ftl" />
        </#if>

        <#if confMap.model?index_of("404") != -1>
            <#include "Modify/404.ftl" />
        </#if>

        <#if confMap.model?index_of("405") != -1>
            <#include "Modify/405.ftl" />
        </#if>

        <#if confMap.model?index_of("406") != -1>
            <#include "Modify/406.ftl" />
        </#if>

        <#if confMap.model?index_of("407") != -1>
            <#include "Modify/407.ftl" />
        </#if>

        <#if confMap.model?index_of("408") != -1>
            <#include "Modify/408.ftl" />
        </#if>

        <#if confMap.model?index_of("409") != -1>
            <#include "Modify/409.ftl" />
        </#if>

        <#if confMap.model?index_of("410") != -1>
            <#include "Modify/410.ftl" />
        </#if>

        <#if confMap.model?index_of("411") != -1>
            <#include "Modify/411.ftl" />
        </#if>

        <#if confMap.model?index_of("412") != -1>
            <#include "Modify/412.ftl" />
        </#if>

        <#if confMap.model?index_of("413") != -1>
            <#include "Modify/413.ftl" />
        </#if>

        <#if confMap.model?index_of("414") != -1>
            <#include "Modify/414.ftl" />
        </#if>

        <#if confMap.model?index_of("415") != -1>
            <#include "Modify/415.ftl" />
        </#if>

        <#if confMap.model?index_of("416") != -1>
            <#include "Modify/416.ftl" />
        </#if>

        <#if confMap.model?index_of("417") != -1>
            <#include "Modify/417.ftl" />
        </#if>

        <#if confMap.model?index_of("418") != -1>
            <#include "Modify/418.ftl" />
        </#if>
    </#if>

    </@commonLabel>
</#macro>


















