<#assign quesType = Session["confMap"].quesType />
<#assign quesId = Session["confMap"].quesId />
<#assign surveyId = Session["confMap"].id />
<#assign ctx = Session["confMap"].ctx />

<script type="text/javascript">
    function getAnswer() {
        var surveyAnswer={
            'surveyId':	"${surveyId?js_string}",
            'answerDetail':[]
        };

        var sub = true;

        var quesType = "${quesType?js_string}",
            quesId = "${quesId?js_string}";

        var quesTypes = quesType.split(","),
            quesIds = quesId.split(",");

        if (quesTypes.length > 0) {
            for (var i = 0;i < quesTypes.length; i++) {
                if (quesTypes[i] === '1') {
                    var answer = $('input[name="'+quesIds[i]+'"]').filter(':checked').val();
                    if(answer == undefined){
                        if (sub == true) {
                            sub = false;
                            alert("请回答完调查问题");
                        }
                    }else{
                        var data={
                            'questionId': quesIds[i],
                            'answer': answer
                        };
                        surveyAnswer.answerDetail.push(data);
                    }
                } else if (quesTypes[i] === '2') {
                    var sel="";
                    $('input[name="'+quesIds[i]+'"]:checked').each(function(){
                        sel += $(this).val()+",";
                    });
                    if(sel==""){
                        if (sub == true) {
                            sub = false;
                            alert("请回答完调查问题");
                        }
                    }else{
                        sel = sel.substring(0,sel.length-1);
                        var sels=sel.split(",");
                        $.each(sels, function(idx, seldata) {
                            var data={
                                'questionId': quesIds[i],
                                'answer': seldata
                            };
                            surveyAnswer.answerDetail.push(data);
                        });
                    }
                } else if (quesTypes[i] === '3') {
                    var text = $('#'+quesIds[i]).val();
                    if(text.length <= 0){
                    }else{
                        var data={
                            'questionId': quesIds[i],
                            'answer': text
                        };
                        surveyAnswer.answerDetail.push(data);
                    }
                }
            }
        }

        if (sub) {
            $.ajax({
                url : "${ctx?js_string}" + 'manage/surveyInfo/saveQuest.json',
                type : 'post',
                data: JSON.stringify(surveyAnswer),
                headers : {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json'
                },
                dataType : 'json',
                success : function(data) {
                    // 操作成功
                    if (data['statusCode'] == '200') {
                        if(data.data>0){
                            alert("提交成功");
                        }
                        getSumCount();
                        getStatius();

                        $('#subAnsDiv').empty();
                        $('#subAnsDiv').append("<div style='margin-top: 15px;'>" + "已经参与投票" + "</div>");
                    } else {
                        alert('调查提交失败，请稍后再试！');
                    }
                }
            });
        }
    }

    function getSumCount() {
        var data={
            'surveyId': "${surveyId?js_string}"
        };

        $.ajax({
            url : "${ctx?js_string}" + 'manage/surveyInfo/getSumCount.json',
            type : 'get',
            data : $.param(data),
            dataType : 'json',
            success : function(data) {
                // 操作成功
                if (data['statusCode'] == '200') {
                    sumCount = data['data'];
                    $('#sum').empty();
                    $('#sum').append("参与人数：" + sumCount);
                }
            }
        });

    }

    function getStatius() {
        var data={
            'surveyId': "${surveyId?js_string}"
        };
        $.ajax({
            url : "${ctx?js_string}" + 'manage/surveyInfo/getItemCount.json',
            type : 'get',
            data : $.param(data),
            dataType : 'json',
            success : function(data) {
                if (data['statusCode'] == '200') {
                    var html="";
                    var data=data['data'];
                    if(data.length<=0){
                    }else{
                        $.each(data, function(idx, obj) {
                            html+='<div class="blocks">';
                            html+='<div class="">';
                            html+='<p class="title_a">'+(idx+1)+"."+obj.title+' </p>';
                            $.each(obj.surveyCountItem, function(idx, objItem) {
                                html+='<div class="row"><div class="col-sm-8">';
                                html+='<p class="">'+objItem.operName+"&nbsp;&nbsp;"+objItem.itemContent+'</p>';
                                html+='</div><div class="col-sm-4"><div class="  hidden-xs mt"></div>';
                                html+='<div class="col-xs-9 no-padding "><div class="progress progress-xs">';

                                html+='<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="'+objItem.proportion+'" aria-valuemin="0" aria-valuemax="100" style="width:'+objItem.proportion+'%">';
                                html+='<span class="sr-only">'+objItem.proportion+"%"+'</span> </div>';
                                html+='</div></div>';
                                html+='<div class="col-xs-2" style=" line-height:10px;">'+objItem.proportion+"%"+'</div>  ';
                                html+='</div></div>	';
                            });
                            html+='</div>';
                            html+='<div class="clearfix"></div>';
                            html+='</div>';
                        });
                        $('#questionList').empty();
                        $('#questionList').append(html);
                    }

                }
            }
        });
    }
</script>


<div class="modalTable">
    <div class="tip1">
        <#if confMap.surveyStatus == 0>
            正在进行
        <#elseif confMap.surveyStatus == 1>
            未开始
        <#elseif confMap.surveyStatus == 2>
            已结束
        </#if>
    </div>

    <div class="tip2">
        <div class="timeTitle">调查时间：</div>
        <div class="startTime">${confMap.startDate?string("yyyy-MM-dd")}</div>
        <div class="hr">--</div>
        <div class="endTime">${confMap.endDate?string("yyyy-MM-dd")}</div>
        <div id="sum">参与人数：${confMap.ansCount}</div>
    </div>

    <div class="clearfix"></div>
</div>

<div class="surModal">
    <div class="surTitle">参与调查区</div>
</div>

<#if confMap.surveyStatus == 0>
    <#if (htmlValue?size == 0)>
        <div style="margin-top:10px">暂无题目</div>
    <#else>
        <div id="questionList">
        <#list htmlValue as data>
            <#if data.questionType == 1>
                <div class="blocks">
                    <div>
                        <p class="title_a">${data_index + 1}.${data.title}</p>
                        <div>
                            <#list data.questionItem as chooseData>
                                <p>
                                    <input name="${chooseData.questionId}" type="radio" value="${chooseData.operName}">&nbsp;&nbsp;${chooseData.itemContent}
                                </p>
                            </#list>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            <#elseif data.questionType == 2>
                <div class="blocks">
                    <div>
                        <p class="title_a">${data_index + 1}.${data.title}</p>
                        <div>
                            <#list data.questionItem as chooseData>
                                <p>
                                    <input type="checkbox" name="${chooseData.questionId}" id="checkbox" value="${chooseData.operName}">
                                    <label for="checkbox"></label>&nbsp;&nbsp;${chooseData.itemContent}
                                </p>
                            </#list>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            <#elseif data.questionType == 3>
                <div class="blocks">
                    <div>
                        <p class="title_a">${data_index + 1}.${data.title}</p>
                        <div>
                            <textarea class="form-control" id="${data.id}" name="${data.id}" type="text" maxlength="80"></textarea>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </#if>
        </#list>
        </div>
        <center id="subAnsDiv">
            <button class="btn-info" type="button" onclick="getAnswer()">提交问卷</button>
        </center>

    </#if>

<#elseif confMap.surveyStatus == 2>
    <div id="questionList">
    <#list countValue as value>
        <div class="blocks">
            <div class="">
                <p class="title_a">${value_index + 1}.${value.title}</p>
                <#list value.surveyCountItem as item>
                    <div class="row">
                        <div class="col-sm-8">
                            <p class="">${item.operName}&nbsp;&nbsp;${item.itemContent}</p>
                        </div>
                        <div class="col-sm-4">
                            <div class="hidden-xs mt">
                            </div>
                            <div class="col-xs-9 no-padding">
                                <div class="progress progress-xs">
                                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="${item.proportion}" aria-valuemin="0" aria-valuemax="100" style="width:${item.proportion}%">
                                        <span class="sr-only">${item.proportion}%</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-2" style=" line-height:10px;">${item.proportion}%</div>
                        </div>
                    </div>
                </#list>
            </div>
            <div class="clearfix"></div>
        </div>
    </#list>
    </div>
</#if>





