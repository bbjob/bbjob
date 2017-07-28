(function() {
	'use strict';

	angular.module('app.article', []);

})();

/****
 * 编辑写稿的list
 * 
 * *****/
(function() {
    'use strict';
    
    angular
    .module('app.article', ['ngFileUpload'])
    .controller('editerarticleCtrl', editerarticleCtrl);
    //自定义状态拦截器
    angular
    .module('app.article').filter("statusfilter",function(){
    	return function(input,uppercase){
    		var name="新增";
    		if(input==""){
				return name;
			}
    		else if(input==0){
    			name="新增";
    		}
    		else if(input==1){
    			name="已审核";
    		}
    		else if(input==2){
    			name="已发布";
    		}
    		else if(input==3){
    			name="已弃用";
    		}
//    		else if(input==4){
//    			name="已删除";
//    		}
    		return name;
    	}
    });
    //自定类型拦截器
    angular
    .module('app.article').filter("articleTypefilter",function(){
    	return function(input,uppercase){
    		var name="编辑";
    		if(input==""){
    			return name;
    		}
    		else if(input==3){
    			name="外链";
    		}
    		return name;
    	}
    });
  //自定数据来源拦截器
	angular
	.module('app.article').filter("articleSourcefilter",function(){
		return function(input,uppercase){
			var name="未知";
			if(input==""){
				return name;
			}
			else if(input==0){
				name="网络抓取";
			}
			else if(input==1){
				name="会员投稿";
			}
			else if(input==2){
				name="编辑写稿";
			}
			else if(input==3){
				name="采编OA";
			}
			return name;
		}
	});
    
    editerarticleCtrl.$inject = ['$rootScope','$scope', '$http','$state','$filter','toaster','SweetAlert', 'NgTableParams','ngDialog','EditerarticleService','Upload','$stateParams'];

	function editerarticleCtrl($rootScope,$scope, $http,$state,$filter,toaster,SweetAlert,ngTableParams,ngDialog,EditerarticleService,Upload,$stateParams) {
		
		//时间初始化--
		$scope.nowDate=new Date();
		$scope.nowstr=$filter("date")($scope.nowDate, "yyyy-MM-dd HH:mm:ss")+' +0800';
		$scope.dateOpts = {
			    dateFormat: 'Y-m-d H:i:S',
			    defaultDate: $scope.nowstr
		};
			 
		$scope.datePostSetup = function(fpItem) {
		    console.log('flatpickr', fpItem);
		}
		//时间初始化--
		
		$scope.ids=[];
		$scope.editinfos=[];
		
		//传递的查询条件(左侧定义查询)
		$scope.selffilters = { status: null, time:null,type:0};
		//状态筛选定义
		$scope.selStatus = [{key:'全部',value:null,icon:'fa-calendar-o'},{key:'新增',value:0,icon:'fa-dot-circle-o'},{key:'已审核',value:1,icon:'fa-dot-circle-o'},/*{key:'已发布',value:2,icon:'fa-dot-circle-o'},*/{key:'已弃用',value:3,icon:'fa-dot-circle-o'}/*,{key:'已删除',value:4,icon:'fa-dot-circle-o'}*/];
		/**********************************************数据load************************************************************************/
		var self = this; //把controller 定义为变量self
	    self.tableParams = new ngTableParams({
            page: 1,            // show first page
            count: 10,          // count per page
            filter: {id:null,titleAll:null,arcticleStatus:null,authorId:$stateParams.authorId}
        }, {
            total: 0,           // length of data
            counts: [10,20,50,100], // hide page counts control
            getData: function(params) {
            	$scope.ids=[];
        		$scope.editinfos=[];
               var result=EditerarticleService.getLists(params,$scope.selffilters);
            	return result;             
            }
        });
	    /**********************************************表格上查询组装数据************************************************************************/
	    //原创
	    self.isOriginalSEL=function(cloum){
	    	return [{'id':1,'title':'原创'},{'id':0,'title':'非原创'}];
	    }
	    //类型
	    self.aTypeSEL=function(cloum){
	    	return [{'id':0,'title':'编辑'},{'id':3,'title':'外链'}];
	    }
	    //文章来源 0爬虫  1会员投稿  2编辑写稿  3采编OA
	    self.articleSourceSEL=function(cloum){
	    	return [{'id':0,'title':'网络抓取'},{'id':1,'title':'会员投稿'},{'id':2,'title':'编辑写稿'},{'id':3,'title':'采编OA'}];
	    }
	  //费用
	    self.isFreeSEL=function(cloum){
	    	return [{'id':1,'title':'收费'},{'id':0,'title':'免费'}];
	    }
	    //状态
	    self.statusSEL=function(cloum){
	    	return [{'id':0,'title':'新增'},{'id':1,'title':'已审核'},{'id':2,'title':'已发布'},{'id':3,'title':'已弃用'}];
	    }
	    //置顶
	    self.topSEL=function(cloum){
	    	return [{'id':1,'title':'已置顶'},{'id':0,'title':'未置顶'}];
	    }
	    //加精
	    self.perfectSEL=function(cloum){
	    	return [{'id':1,'title':'已加精'},{'id':0,'title':'未加精'}];
	    }
	    
	    /**********************************************查询************************************************************************/
		//左侧状态查询
		$scope.statusSearch=function (status){
			self.tableParams.filter().arcticleStatus=status;
			self.tableParams.reload();
		}
		/**********************************************新增************************************************************************/
		
		//新增
		$scope.addEa=function() {
			$state.go('app.editerarticle-edit',{type:0,id:null});
//			var url=$state.href('app.editerarticle-edit',{type:0,id:null});
//			window.open(ctx+'jsp/index.jsp'+url,'_blank');
//			$scope.editorContentShow=true;
//				$scope.nowDate=new Date();
//				$scope.nowstr=$filter("date")($scope.nowDate, "yyyy-MM-dd HH:mm:ss");
//				$scope.nowstr2=$scope.nowstr+' +0800';
//				$scope.dateOpts = {
//					    dateFormat: 'Y-m-d H:i:S',
//					    defaultDate: $scope.nowstr2
//				};
//				//初始化一些参数
//				$scope.editinfo={};
//				$scope.editinfo.entryDate=$scope.nowstr;
//				$scope.editinfo.articleType=0;
//				$scope.savetype=0; //存储类型 区分 0保存
//				$scope.editinfo.keyWorddAry=[];
//				$scope.editinfo.isOriginal = 1;
//				$scope.editinfo.arcticleContent = "<p style='text-indent:2em'><strong>通信世界网消息</strong>（CWW）</p>";
//				$scope.editisOriginal = {'非原创':0,'原创':1};
//				$scope.editStatus = {'新增':0,'已审核':1,'已发布':2,'已弃用':3,'已删除':4};
//				$scope.iseditFlag=false; //编辑默认true 标示只读
//				$scope.isAddflag=true; //是否是添加true
//				$scope.title = '新增';
//				$scope.ccitems();
//				ngDialog.open({
//					className: 'ngdialog-theme-default',
//					showClose: true,
//					closeByDocument:false,//点击灰色区域不关闭
//					template: '<div ng-include="\'jsp/views/operative/editerarticle/edit-templet.html\'"></div>',
//					plain: true,
//					width: '65%',
//					scope:$scope
//				});
		};
		/**********************************************编辑************************************************************************/
		
		//编辑的弹出层
		$scope.edit= function(index) {
			$state.go('app.editerarticle-edit',{type:1,id:self.tableParams.data[index].idno});
//			var url=$state.href('app.editerarticle-edit',{type:1,id:self.tableParams.data[index].id});
//			window.open(ctx+'jsp/index.jsp'+url,'_blank');
//			$scope.editorContentShow=true;
//			$scope.savetype=1; //存储类型 区分 0保存
//			$http({
//  		        method  : 'GET',
//  		        url     : 'manage/editerarticle/info.json?id='+self.tableParams.data[index].id
//  		    }).success(function(data, status, headers, config) {
//  				var obj2 = eval(data);
//  				if(obj2.statusCode==200){
//  					$scope.editinfo=obj2.data;
//  					if(null!=$scope.editinfo&&null!=$scope.editinfo.entryDate){
//  						//初始化一些参数
//  						$scope.nowstr=$filter("date")($scope.editinfo.entryDate, "yyyy-MM-dd HH:mm:ss")+' +0800';
//  						$scope.editinfo.entryDate=$filter("date")($scope.editinfo.entryDate, "yyyy-MM-dd HH:mm:ss");
//  						$scope.dateOpts = {
//  								dateFormat: 'Y-m-d H:i:S',
//  								defaultDate: $scope.nowstr
//  						};
//  					}
//  					var keywordd=$scope.editinfo.keyWordd;
//  					$scope.editinfo.keyWorddAry=[];
//  					if(null!=keywordd&&angular.isDefined(keywordd)){
//  						$scope.editinfo.keyWorddAry=keywordd.split(",");
//  					}
//  					var appAndPc=$scope.editinfo.free1;
//  					if(null!=appAndPc&&angular.isDefined(appAndPc)){
//  						if(appAndPc.indexOf("pc")!=-1){$scope.editinfo.ispc="pc";}
//  						if(appAndPc.indexOf("app")!=-1){$scope.editinfo.isapp="app";}
//  					}
//  					$scope.editStatus = {'新增':0,'已审核':1,'已发布':2,'已弃用':3,'已删除':4};
//  					$scope.editisOriginal = {'非原创':0,'原创':1};
//  					$scope.selIndex=index;
//  					$scope.iseditFlag=true; //编辑默认true 标示只读
//  					$scope.isAddflag=false; //是否是添加true
//  					$scope.title = '编辑';
//  					$scope.ccitems();
//  				//日志
//				    $scope.logtableParams = new ngTableParams({
//				    	page: 1,            // show first page
//				    	count: 10,          // count per page
//				    	filter: {id:null,titleAll:null,arcticleStatus:null,srcId:$scope.editinfo.id}
//				    }, {
//				    	total: 0,           // length of data
//				    	counts: [10,20,50,100], // hide page counts control
//				    	getData: function(params) {
//				    		var result=EditerarticleService.getLogLists(params);
//				    		return result;             
//				    	}
//				    });
//  					ngDialog.open({
//  						className: 'ngdialog-theme-default',
//  		    	 		showClose: true,
//  		    	 		closeByDocument:false,//点击灰色区域不关闭
//  		    	 		template: '<div ng-include="\'jsp/views/operative/editerarticle/edit-templet.html\'"></div>',
//  		                plain: true,
//  		                width: '65%',
//  						scope:$scope
//  					});
//  				}else{
//  					toaster.pop('error', "提示","服务我未响应数据！");
//  				}
//  			}).error(function(data, status, headers, config){
//  				toaster.pop('error', "提示", "服务器繁忙！");
//  			});
		};
		
		//频道栏目组织数据
		$scope.ccitems=function(){
			if(angular.isDefined($scope.editinfo)&&angular.isDefined($scope.editinfo.vaclist)&&angular.isArray($scope.editinfo.vaclist)){
				//频道
					$http({ method  : 'GET', url : 'manage/channel/clist.json'
					}).success(function(data, status, headers, config) {
						var obj2 = eval(data);
						if(obj2.statusCode==200){
							for(var i=0;i<$scope.editinfo.vaclist.length;i++){
								$scope.editinfo.vaclist[i].channellist=[];
								$scope.editinfo.vaclist[i].channellist=obj2.data;
							}
						}
					}).error(function(data, status, headers, config){});
				//栏目
					for(var i=0;i<$scope.editinfo.vaclist.length;i++){
						$scope.channelColumnlistInit(i, $scope.editinfo.vaclist[i].channelId);
					}	
			}
		};
		
		//频道/栏目 查询
		$scope.channelColumnlist=[];
		$scope.channelColumnlistSearch= function(id) {
			$http({
				method  : 'GET',
				url     : 'manage/channel/cclist.json?status=1&channelId='+id
			}).success(function(data, status, headers, config) {
				var obj2 = eval(data);
				if(obj2.statusCode==200){
					$scope.channelColumnlist=obj2.data;
				}else{
					toaster.pop('error', "提示","服务我未响应数据！");
				}
			}).error(function(data, status, headers, config){
				toaster.pop('error', "提示", "服务器繁忙！");
			});
			
		};
		
		//
		$scope.channelColumnlistInit= function(index,id) {
			$http({ method  : 'GET', url     : 'manage/channel/cclist.json?status=1&channelId='+id
			}).success(function(data, status, headers, config) {
				var obj2 = eval(data);
				if(obj2.statusCode==200){
					$scope.editinfo.vaclist[index].channelColumnlist=[];
					$scope.editinfo.vaclist[index].channelColumnlist=obj2.data;
				}
			}).error(function(data, status, headers, config){
				toaster.pop('error', "提示", "服务器繁忙！");
			});
			
		};
		//频道选择
		$scope.channelChange= function(index,id) {
			$http({
				method  : 'GET',
				url     : 'manage/channel/cclist.json?status=1&channelId='+id
			}).success(function(data, status, headers, config) {
				var obj2 = eval(data);
				if(obj2.statusCode==200){
					$scope.editinfo.vaclist[index].channelColumnlist=obj2.data;
				}else{
					toaster.pop('error', "提示","服务我未响应数据！");
				}
			}).error(function(data, status, headers, config){
				toaster.pop('error', "提示", "服务器繁忙！");
			});
		};
		
		//添加栏目
		$scope.addacolumn=function(){
			var temp={id:null,free1:0,free2:0};
			if(angular.isDefined($scope.editinfo)&&angular.isDefined($scope.editinfo.vaclist)&&angular.isArray($scope.editinfo.vaclist)&&$scope.editinfo.vaclist.length>0){
				if(angular.isArray($scope.editinfo.vaclist[0].channellist)){
					temp.channellist=$scope.editinfo.vaclist[0].channellist;
				}
				$scope.editinfo.vaclist.push(temp);
				$scope.channelColumnlistInit($scope.editinfo.vaclist.length-1, temp.channellist[0].id);
			}else{
				$scope.editinfo.vaclist=[];
				//频道
				$http({ method  : 'GET', url : 'manage/channel/clist.json'
				}).success(function(data, status, headers, config) {
					var obj2 = eval(data);
					if(obj2.statusCode==200){
						temp.channellist=obj2.data;
						$scope.editinfo.vaclist.push(temp);
						$scope.channelColumnlistInit($scope.editinfo.vaclist.length-1, temp.channellist[0].id);
					}
				}).error(function(data, status, headers, config){});
			}
		}
		
		//摘要保存
		$scope.aisave=function(){
			var changeinfo=$scope.editinfo;
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
		
		
		//内容保存
		$scope.contentSave=function(){
			var changeinfo=$scope.editinfo;
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
			if($scope.savetype==1)
				POSTBodyMethod('manage/editerarticle/update.json', changeinfo, "修改成功", "修改失败");
			else if($scope.savetype==0)
				POSTBodyMethod('manage/editerarticle/add.json', changeinfo, "保存成功", "保存失败");
		}
		
		//弹窗关闭
		$scope.aipublish=function(){
			ngDialog.close();
		}
		
		//弹窗关闭
		$scope.dialogClosed=function(){
			ngDialog.close();
		}

		/**********************************************图片操作***********************************************************************/
		//图片点击上传
		$scope.addPic=function(){
			document.getElementById("uppic").click();
			angular.element(document.querySelector('#uppic')).off('change').on('change',uploadpic);
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
               console.log('file ' + config.file.name + 'uploaded. Response: ' + data);
               if(angular.isDefined(data)&&angular.isDefined(data.url)){
               	$scope.editinfo.pic1=data.url;
               }
           }).error(function (data, status, headers, config) {
               //上传失败
               console.log('error status: ' + status);
           });
       };
		/******************************************************富文本编辑相关**********************************************************************/
		$scope.config = {
				enableAutoSave: false,//自动保存
				maximumWords:100000, //最大字符
				toolbars: [[
				            'fullscreen', 'source', '|', 'undo', 'redo', '|',
				            'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
				            'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
				            'app.articlestyle', 'paragraph', 'fontfamily', 'fontsize', '|',
				            'directionalityltr', 'directionalityrtl', 'indent', '|',
				            'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
				            'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
				            'insertimage', 'scrawl','insertframe', 'insertcode', 'template', '|',
				            'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
				            'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
				            'preview', 'searchreplace', 'help','pagebreak','autoQMTButton'
				        ]]
	    }
		
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
		
		/**********************************************发布撤销退回************************************************************************/
		//操作 1审核2发布3弃用4删除
		$scope.changeEa= function(status) {
			var name = "删除";
			var ids = getselectedIds();
			SweetAlert.swal({
	              title: '你是否要'+name+'选中的文章?',   
	              type: 'warning',   
	              showCancelButton: true,   
	              confirmButtonColor: '#DD6B55',   
	              confirmButtonText: '是的',   
	              cancelButtonText: '取消',   
	              closeOnConfirm: true,   
	              closeOnCancel: true 
	            }, function(isConfirm){  
	              if (isConfirm) {  
	            	  POSTMethod('manage/editerarticle/somechange.json', {ids:ids,status:status,type:status}, name+"成功",  name+"失败");
	              } else {     
	               // SweetAlert.swal('取消操作', '你取消了操作', 'error');   
	              } 
	        });
		};
		
		//上传word
		$scope.upword= function() {
			toaster.pop('info', "提示", "上传功能敬请期待");
		};
		/******************************发布操作***********************************************/
		
		//发布频道、栏目选择
		$scope.publishCC= function() {
			$scope.iseditFlag=false;
			if ($scope.editinfos.length > 0) {
	    		for ( var index in $scope.editinfos) {
	    			if($scope.editinfos[index].arcticleStatus != 1){
	    				toaster.pop('error', "提示", "非审核通过状态，无法发布！");
	    				return;
	    			}
	    			if(null==$scope.editinfos[index].articleTitle||undefined==$scope.editinfos[index].articleTitle||""==null==$scope.editinfos[index].articleTitle){
	    				toaster.pop('error', "提示", "标题未完善，无法发布！");
	    				return;
	    			}
	    			if(null==$scope.editinfos[index].arcticleSummary||undefined==$scope.editinfos[index].arcticleSummary||""==null==$scope.editinfos[index].arcticleSummary){
	    				toaster.pop('error', "提示", "摘要未完善，无法发布！");
	    				return;
	    			}
	    			if($scope.editinfos[index].articleType != 3){
	    				if(null==$scope.editinfos[index].arcticleContent||undefined==$scope.editinfos[index].arcticleContent||""==null==$scope.editinfos[index].arcticleContent){
		    				toaster.pop('error', "提示", "文章内容为空，无法发布！");
		    				return;
		    			}
	    			}else{
	    				if(null==$scope.editinfos[index].free2||undefined==$scope.editinfos[index].free2 ||""==null==$scope.editinfos[index].free2){
		    				toaster.pop('error', "提示", "外链内容为空，无法发布！");
		    				return;
		    			}
	    			}
	    			
				}
			}
			var ids=getselectedAllIds(); //本次修改 获取发布及未发布全部 选中ID
			$scope.editinfo={};
			$scope.editinfo.vaclist=[];
			$scope.editinfo.free6=1;
			if(null==ids){
				toaster.pop('error', "提示", "您没有选择要发布的相应的数据(或状态不正确)！");
				return;
			}
			$scope.ccitems();
			ngDialog.open({
				className: 'ngdialog-theme-default',
				showClose: true,
				template: '<div ng-include="\'jsp/views/operative/articleinfo/ccedit-templet.html\'"></div>',
				plain: true,
				width: '65%',
				scope:$scope
			});
		};
		
		//频道栏目删除操作
	       $scope.delCC=function (index){
	    	   if(angular.isUndefined($scope.editinfo)||angular.isUndefined($scope.editinfo.vaclist)||$scope.editinfo.vaclist.length<=0){
	    		   return;
	    	   }
	    	   var temp=$scope.editinfo.vaclist[index];
	    	   if(angular.isUndefined(temp)&&null!=temp) return;
	    	   if(temp.id!=null){
	    		   //后台删除
	    		   POSTMethod('manage/articleinfo/delcc.json', {id:temp.id}, "删除成功", "删除失败",true,true);
	    	   }
			   $scope.editinfo.vaclist.splice(index, 1);
	       }
	       
	       //判断频道是否
	       function ccIsOK(type){
	    	   if(angular.isUndefined($scope.editinfo)||angular.isUndefined($scope.editinfo.vaclist)||$scope.editinfo.vaclist.length<=0){
					toaster.pop('error', "提示", "您没有选择要发布的频道/栏目！");
					return false;
				}
	    	   //for
	    	   for(var i=0;i<$scope.editinfo.vaclist.length;i++){
	    		   var tem=$scope.editinfo.vaclist[i];
	    		   if(tem.channelId==null||tem.columnId==null){
	    			   toaster.pop('error', "提示", "您有频道/栏目未进行选择！");
	    			   return false;
	    		   }
	    	   }
	    	   return true;
	       }

			//新发布发布
			$scope.publishNew= function() {
				$scope.iseditFlag=false;
				var ids=getselectedAllIds(); //本次修改 获取发布及未发布全部 选中ID
				if(null==ids){
					toaster.pop('error', "提示", "您没有选择要发布的相应的数据！");
					return;
				}
				//频道栏目检查
				if(!ccIsOK())return;
//				if(angular.isUndefined($scope.editinfo)||angular.isUndefined($scope.editinfo.vaclist)||$scope.editinfo.vaclist.length<=0){
//					toaster.pop('error', "提示", "您没有选择要发布的频道！");
//					return;
//				}
				SweetAlert.swal({   
		              title: '你是否要发布选中的文章?',   
		              text: '发布之后用户便能看到!',   
		              type: 'warning',   
		              showCancelButton: true,   
		              confirmButtonColor: '#DD6B55',   
		              confirmButtonText: '是的',   
		              cancelButtonText: '取消',   
		              closeOnConfirm: true,   
		              closeOnCancel: true 
		            }, function(isConfirm){  
		              if (isConfirm) {  
		            	  $scope.editinfo.ids=ids;
		            	  POSTBodyMethod('manage/articleinfo/publishs.json', $scope.editinfo, "发布成功", "发布失败",true,true);
		              } else {     
		               // SweetAlert.swal('取消操作', '你取消了操作', 'error');   
		              } 
		        });
			};
			
			//获取选中的all
			function getselectedAllIds(){
				var ids=null;
				var data=self.tableParams.data;
				for(var i=0;i<data.length;i++){
					if(data[i].$selected){
						if(ids==null)ids=data[i].id;
						else ids+=","+data[i].id;
					}
				}
				return ids;
			}
			
			//获取选中的all标题
			function getselectedAllNames(){
				var names=null;
				var data=self.tableParams.data;
				for(var i=0;i<data.length;i++){
					if(data[i].$selected){
						if(names==null)names=data[i].articleTitle;
						else names+=","+data[i].articleTitle;
					}
				}
				return names;
			}
			/******************************************复制连接功能*********************************************************/
			//发布频道、栏目选择
			$scope.copyURL= function() {
				var ids=getselectedAllIds(); //本次修改 获取发布及未发布全部 选中ID
				$scope.editinfo={};
				$scope.editinfo.vaclist=[];
				if(null==ids){
					toaster.pop('error', "提示", "您没有选择要复制链接的相应的数据(或状态不正确)！");
					return;
				}else if(ids.indexOf(",")!=-1){
					toaster.pop('error', "提示", "此操作只能选择一条数据！");
					return;
				}
				$http({
					method  : 'GET',
					url     : 'manage/copyurl/todo.json?type=0&id='+ids
				}).success(function(data, status, headers, config) {
					var obj2 = eval(data);
					if(obj2.statusCode==200&&obj2.data>0){
						$scope.channelColumnlist=obj2.data;
						toaster.pop('success', "提示","复制链接成功");
					}else{
						toaster.pop('error', "提示","复制链接失败！");
					}
				}).error(function(data, status, headers, config){
					toaster.pop('error', "提示", "服务器繁忙！");
				});
			};
			/******************************************发布选择弹窗*********************************************************/
			//频道栏目组织数据
			$scope.ccitems=function(){
				if(angular.isDefined($scope.editinfo)&&angular.isDefined($scope.editinfo.vaclist)&&angular.isArray($scope.editinfo.vaclist)){
					//频道
						$http({ method  : 'GET', url : 'manage/channel/clist.json'
						}).success(function(data, status, headers, config) {
							var obj2 = eval(data);
							if(obj2.statusCode==200){
								for(var i=0;i<$scope.editinfo.vaclist.length;i++){
									$scope.editinfo.vaclist[i].channellist=[];
									$scope.editinfo.vaclist[i].channellist=obj2.data;
								}
							}
						}).error(function(data, status, headers, config){});
					//栏目
						for(var i=0;i<$scope.editinfo.vaclist.length;i++){
							$scope.channelColumnlistInit(i, $scope.editinfo.vaclist[i].channelId);
						}	
				}
			};
			
			//频道/栏目 查询
			$scope.channelColumnlist=[];
			$scope.channelColumnlistSearch= function(id) {
				$http({
					method  : 'GET',
					url     : 'manage/channel/cclist.json?status=1&channelId='+id
				}).success(function(data, status, headers, config) {
					var obj2 = eval(data);
					if(obj2.statusCode==200){
						$scope.channelColumnlist=obj2.data;
					}else{
						toaster.pop('error', "提示","服务我未响应数据！");
					}
				}).error(function(data, status, headers, config){
					toaster.pop('error', "提示", "服务器繁忙！");
				});
				
			};
			
			//
			$scope.channelColumnlistInit= function(index,id) {
				$http({ method  : 'GET', url     : 'manage/channel/cclist.json?status=1&channelId='+id
				}).success(function(data, status, headers, config) {
					var obj2 = eval(data);
					if(obj2.statusCode==200){
						$scope.editinfo.vaclist[index].channelColumnlist=[];
						$scope.editinfo.vaclist[index].channelColumnlist=obj2.data;
					}
				}).error(function(data, status, headers, config){
					toaster.pop('error', "提示", "服务器繁忙！");
				});
				
			};
			//频道选择
			$scope.channelChange= function(index,id) {
				$http({
					method  : 'GET',
					url     : 'manage/channel/cclist.json?status=1&channelId='+id
				}).success(function(data, status, headers, config) {
					var obj2 = eval(data);
					if(obj2.statusCode==200){
						$scope.editinfo.vaclist[index].channelColumnlist=obj2.data;
					}else{
						toaster.pop('error', "提示","服务我未响应数据！");
					}
				}).error(function(data, status, headers, config){
					toaster.pop('error', "提示", "服务器繁忙！");
				});
			};

			//添加栏目
			$scope.addacolumn=function(){
				//if($scope.iseditFlag)return;
				var temp={id:null,free1:0,free2:0};
				if(angular.isDefined($scope.editinfo)&&angular.isDefined($scope.editinfo.vaclist)&&angular.isArray($scope.editinfo.vaclist)&&$scope.editinfo.vaclist.length>0){
					if(angular.isArray($scope.editinfo.vaclist[0].channellist)){
						temp.channellist=$scope.editinfo.vaclist[0].channellist;
					}
					$scope.editinfo.vaclist.push(temp);
					$scope.channelColumnlistInit($scope.editinfo.vaclist.length-1, temp.channellist[0].id);
				}else{
					$scope.editinfo.vaclist=[];
					//频道
					$http({ method  : 'GET', url : 'manage/channel/clist.json'
					}).success(function(data, status, headers, config) {
						var obj2 = eval(data);
						if(obj2.statusCode==200){
							temp.channellist=obj2.data;
							$scope.editinfo.vaclist.push(temp);
							$scope.channelColumnlistInit($scope.editinfo.vaclist.length-1, temp.channellist[0].id);
						}
					}).error(function(data, status, headers, config){});
				}
			}

		/******************************导出***********************************************/
		//导出
		$scope.exports= function() {
			var data=self.tableParams.data;
			if(data.length>0){
				var par=$.param(self.tableParams.filter());
				location.href=$rootScope.server.basePath+"manage/editerarticle/exportExcel.json?"+par;
			}else{
				toaster.pop('error', "提示", "没有要导出的数据");
			}
		};
		
		//全选操作
		$scope.selAllflag=false;
		$scope.selAll= function() {
			$scope.selAllflag=!$scope.selAllflag;
			var data=self.tableParams.data;
			for(var i=0;i<self.tableParams.data.length;i++){
				self.tableParams.data[i].$selected=$scope.selAllflag;
			}
		};
		
		//获取选中的
		function getselectedIds(){
			var ids=null;
			var data=self.tableParams.data;
			for(var i=0;i<data.length;i++){
				if(data[i].$selected){
					if(ids==null)ids=data[i].id;
					else ids+=","+data[i].id;
				}
			}
			return ids;
		}
		
		$scope.clickRow = function(row){
    		if (row.$selected == true) {
    			$scope.ids.push(row.id);
    			$scope.editinfos.push(row);
			} else {
				for ( var index in $scope.ids) {
		    		if ($scope.ids[index] === row.id) {
						//删除
		    			$scope.ids.splice(index, 1);
		    			$scope.editinfos.splice(row, 1);
						return;
					}
				}
			}
	    }
		
		//弹窗关闭
		$scope.aipublish=function(){
			ngDialog.close();
		}
		
		//弹窗关闭
		$scope.dialogClosed=function(){
			ngDialog.close();
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
  					self.tableParams.reload();
  					toaster.pop('success', "提示", successmessage);
  					ngDialog.close();
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
  				var obj2 = eval(data);
  				if(obj2.statusCode==200){
  					var maps=obj2.data;
  					
  					if(messsageShow){
  						self.tableParams.reload();
  						toaster.pop('success', "提示", successmessage);
  						$scope.dialogClosed();
  					}
  					
  					if(maps.status==1){
  						self.tableParams.reload();
  						toaster.pop('success', "提示", successmessage);
  						$scope.dialogClosed();
  					} // 4001 标题空 4002 内容空 4003 标题敏感 4004内容 4444错误数据
  					else if(maps.status==4001){
  						toaster.pop('error', "提示", "标题不能为空！");
  					}
  					else if(maps.status==4002){
  						toaster.pop('error', "提示", "内容不能为空！");
  					}
  					else if(maps.status==4003){
  						var word=maps.message;
  						var keys="";
  						for(var i=0;i<word.length;i++){
  							if(keys=="")
  								keys=word[i];
  							else 
  								keys+=","+word[i];
  						}
  						toaster.pop('error', "提示", "标题有敏感词汇["+keys+"]");
  					}
  					else if(maps.status==4005){
  						var word=maps.message;
  						var keys="";
  						for(var i=0;i<word.length;i++){
  							if(keys=="")
  								keys=word[i];
  							else 
  								keys+=","+word[i];
  						}
  						toaster.pop('error', "提示", "摘要有敏感词汇["+keys+"]");
  					}
  					else if(maps.status==4006){
  						var word=maps.message;
  						var keys="";
  						for(var i=0;i<word.length;i++){
  							if(keys=="")
  								keys=word[i];
  							else 
  								keys+=","+word[i];
  						}
  						toaster.pop('error', "提示", "标签有敏感词汇["+keys+"]");
  					}
  					else if(maps.status==4007){
  						var word=maps.message;
  						var keys="";
  						for(var i=0;i<word.length;i++){
  							if(keys=="")
  								keys=word[i];
  							else 
  								keys+=","+word[i];
  						}
  						toaster.pop('error', "提示", "副标题有敏感词汇["+keys+"]");
  					}
  					else if(maps.status==4004){
  						var word=maps.message;
  						var keys="";
  						for(var i=0;i<word.length;i++){
  							if(keys=="")
  								keys=word[i];
  							else 
  								keys+=","+word[i];
  						}
  						toaster.pop('error', "提示", "内容有敏感词汇["+keys+"]");
  					}
  					else if(maps.status==4444){
  						toaster.pop('error', "提示", "错误或未登录！");
  					}
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
	.module('app.article')
	.service('EditerarticleService', EditerarticleService);
	EditerarticleService.$inject = [ '$rootScope','$resource'];
	function EditerarticleService($rootScope,$resource){
		var url1 = $rootScope.server.basePath+"manage/editerarticle/page.json";

		var lists = $resource(url1);

		this.getLists=function(params,selffilters){
			if(lists){
				var filter=params.filter();
				var search={};
				angular.copy(filter, search);
				search.page=params.page();
				search.size=params.count();
				/*if(selffilters.status!=null&&selffilters.type==1){
					search.arcticleStatus=selffilters.status; //左侧状态切换查询
				}*/
				search.time=selffilters.time; //左侧时间
				return lists.get(search).$promise.then(function(pageData){
					params.total(pageData.total);
		           return pageData.list;
				});
				
			}
		}

	}
	
})();
