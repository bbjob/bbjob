<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<link media="all" href="${pageContext.request.contextPath}/upload/css/common.css" type="text/css" rel="stylesheet">
<link media="all" href="${pageContext.request.contextPath}/upload/css/style.css" type="text/css" rel="stylesheet">
<link media="all" href="${pageContext.request.contextPath}/upload/css/jquery-ui-1.10.1.custom.min.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/javascript/public.js" type="text/javascript"></script>
<script type="text/javascript">
var PATH = "${pageContext.request.contextPath}";
</script>
<body>

<button onclick="">开始上传</button>


<div class="yxbox">
    <h2><a href="#" class="fr" onclick="closeCont();">关闭</a>上传文件(超过1G文件上传同步较慢)</h2>
    <div class="pd15">
    	<form name="uploadForm" id="upload_form"  action="#" method="post" enctype="multipart/form-data">
    	<p class="mb20"><input type="file"  name="file" id="fileToUpload" title="请选择要上传的文件" onchange="fSubmit();"></p>
        <div class="br"  style="display:none;" id="progress_all">
        	<ul>
            	<li><h1><a href="#" class="fr" id="cancel">取消</a></h1>
                	<div class="process clearfix" id="process">
						<span class="progress-box">
							<span class="progress-bar" style="width: 0%;" id="progress_bar"></span>
						</span>
                        <span id="progress_percent">0%</span>
                    </div>
                    <div class="info" id="info">已上传：<span id="has_upload">0</span>MB  速度：<span id="upload_speed">0</span>KB/s</div>
                    <div class="info" id="success_info" style="display: none;"></div>
                </li>
            </ul>
        </div>
        </form>
    </div>
</div>
<div id="TB_overlayBG">&nbsp;</div>

<script type="text/javascript">
function showCont(){
	$("#TB_overlayBG").css({
		display:"block",height:$(document).height()
	});
	$(".yxbox").css({
		left:($("body").width()-$(".yxbox").width())/2-20+"px",
		top:($(window).height()-$(".yxbox").height())/2+$(window).scrollTop()+"px",
		display:"block"
	});
}
// 关闭弹框 
function closeCont(){
	$("#TB_overlayBG").hide();
	$(".yxbox").hide();
	window.location.reload();
}
function resetNavHeight() {
    var documentHeight;
    if (document.compatMode == 'BackCompat') {
        documentHeight = Math.max(document.body.clientHeight,
       	document.body.scrollHeight);
    } else {
        documentHeight = Math.max(document.documentElement.clientHeight,
        document.documentElement.scrollHeight);
    }
    $('.left').height(documentHeight - 48);
}

$(document).ready(function(){ 
	window.document.getElementById("fileToUpload").disabled = false;
});

function getProgress() {
	var now = new Date();
    $.ajax({
        type: "post",
        dataType: "json",
        url: PATH + "/fileStatus/upfile/progress",
        data: now.getTime(),
        success: function(data) {
        	$("#progress_percent").text(data.percent);
            $("#progress_bar").width(data.percent);
            $("#has_upload").text(data.mbRead);
            $("#upload_speed").text(data.speed);
        },
        error: function(err) {
        	$("#progress_percent").text("Error");
        }
    });
}

/**
 * 提交上传文件
 */
function fSubmit() {
	$("#process").show();
	$("#cancel").show();
	$("#info").show();
	$("#success_info").hide();
    //文件名
   	fileName = $("#fileToUpload").val().split('/').pop().split('\\').pop();
    //进度和百分比
    $("#progress_percent").text("0%");
    $("#progress_bar").width("0%");
    $("#progress_all").show();
    oTimer = setInterval("getProgress()", 1000);
    ajaxFileUpload();
    //document.getElementById("upload_form").submit();
    window.document.getElementById("fileToUpload").disabled = true;
}


/**
 * 上传文件
 */
function ajaxFileUpload() {
    $.ajaxFileUpload({
        url: PATH + '/userFile/upload',
        secureuri: false,
        fileElementId: 'fileToUpload',
        dataType: 'json',
        data: {
            name: 'file',
            id: 'id'
        },
        success: function(data, status) {
            if (typeof(data.status) != 'undefined') {
            	window.clearInterval(oTimer);
                if (data.status == 'success') {
                	$("#info").hide();
                	$("#success_info").show();
                	$("#success_info").text(fileName + "\t" +data.message);
                	$("#process").hide();
                	$("#cancel").hide();
                	$("#fileToUpload").val("");
                	window.document.getElementById("fileToUpload").disabled = false;
                	//上传进度和上传速度清0
                	$("#has_upload").text("0");
                    $("#upload_speed").text("0");
                    $("#progress_percent").text("0%");
                    $("#progress_bar").width("0%");
                } else{
                	$("#progress_all").hide();
                	$("#fileToUpload").val("");
                	if (typeof(data.message) != 'undefined') {
                		alert(data.message);
                	}
                	alert("上传错误！");
                }
            }
        },
        error: function(data, status, e) {
            alert(e);
        }
    })
    return false;
}

</script>
<iframe id="ifile" style="display:none"></iframe> 
</body>
</html>