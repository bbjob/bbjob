<div class="KinSlideshow" style="visibility:hidden;">
    <#list htmlValue as data>
        <a href="${data.dataList[6]?default('javascript:void(0)')}" title='${data.dataList[0]}' target='_blank'>
            <img src="${data.dataList[2]?default('/mnt/ftl/customModel/images/picNotFund.jpg')}" border=0 width='${confMap.picWide?default(600)}' height='${confMap.picHeight?default(300)}' title='${data.dataList[0]}'>
        </a>
    </#list>
</div>
