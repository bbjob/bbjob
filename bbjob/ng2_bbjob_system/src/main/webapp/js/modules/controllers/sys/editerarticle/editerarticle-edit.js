/****
 * 编辑写稿的list
 * 
 * *****/
(function() {
    'use strict';
    
    angular
    .module('custom', ['ngFileUpload'])
    .controller('editerarticleEditCtrl', editerarticleEditCtrl);
    editerarticleEditCtrl.$inject = ['$rootScope','$scope', '$http','$state','$filter','toaster','SweetAlert', 'NgTableParams','ngDialog','EditerarticleeditService','Upload','$stateParams'];

	function editerarticleEditCtrl($rootScope,$scope, $http,$state,$filter,toaster,SweetAlert,ngTableParams,ngDialog,EditerarticleeditService,Upload,$stateParams) {
		
		$scope.id=$stateParams.id; //修改时的id
		$scope.savetype=$stateParams.type; //类型0新增1修改
		
		$scope.editisOriginal = {'非原创':0,'原创':1};
		$scope.editStatus = {'新增':0,'已审核':1,'已发布':2,'已弃用':3,'已删除':4};
		$scope.editorContentShow=true;
		//时间初始化--
		$scope.nowDate=new Date();
		$scope.nowstr=$filter("date")($scope.nowDate, "yyyy-MM-dd HH:mm:ss");
		$scope.nowstr2=$scope.nowstr+' +0800';
		$scope.dateOpts = {
			    dateFormat: 'Y-m-d H:i:S',
			    defaultDate: $scope.nowstr2
		};
		$scope.datePostSetup = function(fpItem) {
		    console.log('flatpickr', fpItem);
		}
		//时间初始化--
		
		//新增/修改主体初始化
		$scope.typeTile=$scope.savetype==1?'-编辑操作':'-新增操作';
		$scope.editinfo={};
		$scope.editinfo.articleType=0;

		$scope.index = 0; // 第几个上传框
		/******************************************************富文本编辑相关**********************************************************************/
		$scope.config = {
				enableAutoSave: false,//自动保存
				maximumWords:100000, //最大字符
				initialFrameHeight:450,  //初始化编辑器高度,默认320
				autoHeightEnabled:false, //是否自动长高,默认true
				autoFloatEnabled:true,//是否保持toolbar的位置不动,默认true
				toolbars: [[
				            'fullscreen', 'source', '|', 'undo', 'redo', '|',
				            'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
				            'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
				            'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
				            'directionalityltr', 'directionalityrtl', 'indent', '|',
				            'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
				            'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
				            'insertimage', 'scrawl','insertframe', 'insertcode', 'template', '|',
				            'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
				            'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
				            'preview', 'searchreplace', 'help','pagebreak','autoQMTButton'
				        ]]
	    }
		
		init();
		//初始化访问方法
		function init(){
			if($scope.savetype==0){
				$scope.editinfo.entryDate=$scope.nowstr;
				$scope.editinfo.keyWorddAry=[];
				$scope.editinfo.isOriginal = 1;
				$scope.iseditFlag=false; //编辑默认true 标示只读
				$scope.isAddflag=true; //是否是添加true
				$scope.editinfo.arcticleContent = "<p style='text-indent:2em'><strong>通信世界网消息</strong>（CWW）</p>";
			}
			//修改
			else{
				$http({
	  		        method  : 'GET',
	  		        url     : 'manage/editerarticle/info.json?id='+$scope.id
	  		    }).success(function(data, status, headers, config) {
	  				var obj2 = eval(data);
	  				if(status === 200){
	  					$scope.editinfo= data;
	  					if(null!=$scope.editinfo&&null!=$scope.editinfo.entryDate){
	  						//初始化一些参数
	  						$scope.nowstr=$filter("date")($scope.editinfo.entryDate, "yyyy-MM-dd HH:mm:ss")+' +0800';
	  						$scope.editinfo.entryDate=$filter("date")($scope.editinfo.entryDate, "yyyy-MM-dd HH:mm:ss");
	  						$scope.dateOpts = {
	  								dateFormat: 'Y-m-d H:i:S',
	  								defaultDate: $scope.nowstr
	  						};
	  					}
	  					var keywordd=$scope.editinfo.keyWordd;
	  					$scope.editinfo.keyWorddAry=[];
	  					if(null!=keywordd&&angular.isDefined(keywordd)){
	  						$scope.editinfo.keyWorddAry=keywordd.split(",");
	  					}
	  					var appAndPc=$scope.editinfo.free1;
	  					if(null!=appAndPc&&angular.isDefined(appAndPc)){
	  						if(appAndPc.indexOf("pc")!=-1){$scope.editinfo.ispc="pc";}
	  						if(appAndPc.indexOf("app")!=-1){$scope.editinfo.isapp="app";}
	  					}
	  					$scope.iseditFlag=true; //编辑默认true 标示只读
	  					$scope.isAddflag=false; //是否是添加true
	  					$scope.title = '编辑';
	  				}else{
	  					toaster.pop('error', "提示","服务我未响应数据！");
	  				}
	  			}).error(function(data, status, headers, config){
	  				toaster.pop('error', "提示", "服务器繁忙！");
	  			});
			}
		}
		
		//摘要保存
		$scope.aisave=function(){
			var changeinfo=$scope.editinfo;
			var imgList = changeinfo.imgList;
			var pic1 = "";
			if (imgList !== undefined && imgList !== null) {
				for (var i = 0;i < imgList.length;i++) {
					if (imgList[i] !== null && imgList[i] !== '' ) {
						pic1 = pic1 + imgList[i] + ';'
					}
				}
			}

			changeinfo.pic1 = pic1;

			if(null==changeinfo.articleTitle||undefined==changeinfo.articleTitle||""==null==changeinfo.articleTitle){
				toaster.pop('error', "提示", "请输入标题！");
				return;
			}
			else if(null==changeinfo.entryDate||undefined==changeinfo.entryDate||""==null==changeinfo.entryDate){
				toaster.pop('error', "提示", "请输入录入时间！");
				return;
			}
			else if(0!==changeinfo.isOriginal&&(null==changeinfo.isOriginal||undefined==changeinfo.isOriginal||""==changeinfo.isOriginal)){
				toaster.pop('error', "提示", "请选择是否原创！");
				return;
			}
//			else if(null==changeinfo.subTitle||undefined==changeinfo.subTitle||""==null==changeinfo.subTitle){
//				toaster.pop('error', "提示", "请输入副标题！");
//				return;
//			}
			else if(3==changeinfo.articleType&&(null==changeinfo.free2||undefined==changeinfo.free2||""==null==changeinfo.free2)){
				toaster.pop('error', "提示", "请输入外链链接！");
				return;
			}
			var metastr='';
			for ( var tagValue in $scope.editinfo.keyWorddAry) {
				if (metastr.length > 0) {
					metastr = metastr + ',' + $scope.editinfo.keyWorddAry[tagValue].text;
				} else {
					metastr = metastr + ''+  $scope.editinfo.keyWorddAry[tagValue].text;
				}
			}
			if(metastr!=''){
				changeinfo.keyWordd=metastr;
			}
			//时间格式化hour不修改存储时bug修复
			if (angular.isString(changeinfo.entryDate)) {  
				changeinfo.entryDate= new Date(changeinfo.entryDate.replace(/-/g, "/"));  
            }  
			if($scope.savetype==1){
		    	if(1==changeinfo.arcticleStatus || changeinfo.arcticleStatus == 2){
		    		toaster.pop('error', "提示", "已审核发布的文章，请到发布管理修改！");
		    		ngDialog.close();
		    		return;
		    	}
		    			
				POSTBodyMethod('manage/editerarticle/update.json', changeinfo, "修改成功", "修改失败");
			}
				
			else if($scope.savetype==0){
				
				POSTBodyMethod('manage/editerarticle/add.json', changeinfo, "保存成功", "保存失败");
			}
		}
		
		
		/**********************************************图片操作***********************************************************************/
		//图片点击上传
		$scope.addPic=function(index){
			var inputId = "uppic" + index;
			$scope.index = index;
			document.getElementById(inputId).click();
			angular.element(document.querySelector('#' + inputId)).off('change').on('change',uploadpic);
		}
		/*********************************************************图片上传****************************************************************/
		//上传
		 function uploadpic(evt){
			// var fi=document.getElementById("uppic");
			 var file = evt.currentTarget.files[0];
			 $scope.upload(file);
		 };

       $scope.upload = function (file) {
           Upload.upload({
               //服务端接收
               url: 'upload/imageUp',
               //上传的同时带的参数
               data: {u:1},
               file: file
           }).progress(function (evt) {
               //进度条
               var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
               console.log('progess:' + progressPercentage + '%' + evt.config.file.name);
           }).success(function (data, status, headers, config) {
               //上传成功
			   var index = $scope.index;

               console.log('file ' + config.file.name + 'uploaded. Response: ' + data);
               if(angular.isDefined(data)&&angular.isDefined(data.url)){
				   if ($scope.editinfo.imgList === undefined || $scope.editinfo.imgList === null) {
					   $scope.editinfo.imgList = [];
				   }

				   $scope.editinfo.imgList[index]=data.url;
               }
           }).error(function (data, status, headers, config) {
               //上传失败
               console.log('error status: ' + status);
           });
       };
		
		$scope.isshow = function(type){
			if(type==3)$scope.editorContentShow=false;
			else if(type==0){$scope.editorContentShow=true;$("#editorContent").show();};
		}
		
		$scope.ready = function(editor){
			if($scope.savetype==1&&$scope.editinfo.articleType==3){
				$scope.editorContentShow=false;
				$("#editorContent").hide();
			}
//			console.log('editor: ' + $scope.editorContentShow);
	    }
		
		
		//封装post
		function POSTMethod(url,params,successmessage,errormessage){
			$http({
  		        method  : 'POST',
  		        url     : url,
  		        data    : $.param(params),  // pass in data as strings
  		        headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  // set the headers so angular passing info as form data (not request payload)
  		    }).success(function(data, status, headers, config) {
  				var obj2 = eval(data);
  				if(obj2.statusCode==200){
  					toaster.pop('success', "提示", successmessage);
  				}else{
  					toaster.pop('error', "提示",errormessage);
  				}
  			}).error(function(data, status, headers, config){
  				toaster.pop('error', "提示", "服务器繁忙！");
  			});
		}
		
		//封装postBody
		function POSTBodyMethod(url,params,successmessage,errormessage,messsageShow){
			$http({
  		        method  : 'POST',
  		        url     : url,
  		        data    : params
  		    }).success(function(data, status, headers, config) {
  				if(status === 200){
  					var maps = data;
  					

					toaster.pop('success', "提示", successmessage);
					window.history.back();

  				}else{
  					toaster.pop('error', "提示",errormessage);
  				}
  			}).error(function(data, status, headers, config){
  				toaster.pop('error', "提示", "服务器繁忙！");
  			});
		}
		
	}
	
	
	/****************相应的实现类**************************/
	angular
	.module('custom')
	.service('EditerarticleeditService', EditerarticleeditService);
	EditerarticleeditService.$inject = [ '$rootScope','$resource','HttpServiceUtil'];
	function EditerarticleeditService($rootScope,$resource,HttpServiceUtil){
		//日志
		var loglists = $resource($rootScope.server.basePath+"sysset/mainIndex/operLogList.json");
		this.getLogLists=function(params){
			if(loglists){
				var filter=params.filter();
				var search={};
				angular.copy(filter, search);
				search.page=params.page();
				search.size=params.count();
				return loglists.get(search).$promise.then(function(pageData){
					params.total(pageData.data.total);
					return pageData.data.rows;
				});
			}
		}
	}
	
})();
