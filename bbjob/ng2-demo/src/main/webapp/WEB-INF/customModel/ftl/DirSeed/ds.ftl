<#assign webCastId = Session["confMap"].webCastId />
<#assign ctx = Session["confMap"].ctx />

<script type="text/javascript">
    var orderby = 1;
    var intervals;

    function orderbybtnChange() {
        if($("#orderbybtn").is(':checked')){
            orderby = 0;
            stop();
            getLivesListPage();
            run();
        }else{
            orderby= 1;
            stop();
            getLivesListPage();
            run();
        }
    }

    //定义主内容轮询初始化
    function run(){
        if(null==intervals||undefined==intervals){
            intervals =setInterval("getLivesListPage()", 6000);
        }
    }

    //定义主内容轮询结束
    function stop(){
        if(null != intervals && undefined != intervals){
            clearInterval(intervals);
            intervals = undefined;
        }
    }
    //自动刷新按钮的操作
    function autorefreshChange(){
        if($("#autorefresh").is(':checked')){
            run();
        }else{
            stop();
        }
    }

    function getLivesListPage() {
        var data={
            'castId': "${webCastId?js_string}",
            'ordertype':orderby
        };
        $.ajax({
            url : "${ctx?js_string}" + 'manage/liveitems/list.json',
            type : 'get',
            data : $.param(data),
            dataType : 'json',
            success : function(data) {
                // 操作成功
                if (data['statusCode'] == '200') {
                    var html="";
                    var data=data['data'];

                    $.each(data, function(idx, obj) {
                        html+="<div class='part6_date'> <em class='icon-circle listdot'></em>"+ obj.publishtimeStr +"</div>";
                        html+="<div class='part6_content'>"+obj.message+"</div>";
                        if(null!=obj.imageUrl)html+="<div class='part6_pic'> <img src='http://cww.cww.net.cn/"+ obj.imageUrl +"'></div>";
                    });
                    $('#livingContent').empty();
                    $('#livingContent').append(html);

                }
            }
        });
    }
</script>

<#if confMap.status == '1' || confMap.status == '3'>
    <#if confMap.status == '3'>
        <div class="${confMap.className}t1">直播回顾</div>
    <#else>
        <div class="${confMap.className}t1">直播进行中</div>
            <div class="pull-right" style="width:33%;margin-top: -5px;">
                浏览顺序：正序&nbsp;<label class="switch switch-lg">
                <input id="orderbybtn" onchange="orderbybtnChange()" checked="checked" type="checkbox" style="display:none;"> <span></span>
            </label>&nbsp;逆序
            </div>

            <div class="pull-right" style="width:33%;margin-top: -5px;">
                自动刷新：关闭&nbsp;<label class="switch switch-lg">
                <input id="autorefresh" onchange="autorefreshChange()" type="checkbox" style="display:none;"> <span></span>
            </label>&nbsp;开启
            </div>
    </#if>

    <div class="modalTable">
        <div class="innerStyle">
            <div id = "livingContent">
                <#list htmlValue as data>
                    <div class="${confMap.className}date"><em class="icon-circle listdot"></em>${data.publishtimeStr?default('')}</div>
                    <div class="${confMap.className}content">${data.message?default('')}</div>
                    <div class="${confMap.className}pic">
                        <img src="http://cww.cww.net.cn/${data.imageUrl?default('')}" border=0>
                    </div>
                </#list>
            </div>
        </div>
    </div>
<#else>
    <div class="${confMap.className}wTimeDesc"><em class="icon-circle listdot"></em>直播时长：</div>
    <div class="${confMap.className}wTime">${confMap.castTime?default('')}</div>
    <div style="clear: both">
    <div class="${confMap.className}wForDesc"><em class="icon-circle listdot"></em>直播预告：</div>
    <div class="${confMap.className}wFor">${confMap.free1?default('')}</div>
    <div style="clear: both">
    <div class="${confMap.className}wCastDesc"><em class="icon-circle listdot"></em>本次直播主要内容：</div>
    <div class="${confMap.className}wCast">${confMap.introduce?default('')}</div>
    <div style="clear: both">
</#if>
