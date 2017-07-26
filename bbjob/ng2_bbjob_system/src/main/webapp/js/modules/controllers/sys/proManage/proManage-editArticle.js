(function() {
	'use strict';

	angular.module('app.colArt', []);

})();

/****
 * 专题-文章
 * 
 * *****/
(function() {
    'use strict';
    
    angular
    .module('app.colArt', [])
    .controller('proManageArticleCtrl', proManageArticleCtrl);
    
    proManageArticleCtrl.$inject = ['$scope', '$http','$state','$stateParams','toaster','SweetAlert', 'NgTableParams','ngDialog','ProManageArticleService'];

	function proManageArticleCtrl($scope, $http,$state,$stateParams,toaster,SweetAlert,ngTableParams,ngDialog,ProManageArticleService) {
		
		$scope.colId=$stateParams.colId;//传过来的subject
		//传递的查询条件(左侧定义查询)
		$scope.selffilters = { status: null, time:null};
		$scope.selffilters.colId=$scope.colId;
		$scope.newselffilters = { channelId:null,columnId:null,articleTitle: null};
		$scope.newselffilters.colId=$scope.colId;
		$scope.colName = $stateParams.colName;
		$scope.parentId = $stateParams.parentId;

		/**********************************************数据load************************************************************************/
		var self = this; //把controller 定义为变量self
	    self.tableParams = new ngTableParams({
            page: 1,            // show first page
            count: 10,          // count per page
            filter: {id:null,titleAll:null,arcticleStatus:null}
        }, {
            total: 0,           // length of data
            counts: [10,20,50,100], // hide page counts control
            getData: function(params) {
               var result=ProManageArticleService.getLists(params,$scope.selffilters);
            	return result;             
            }
        });
	    //未关联查询
	    $scope.newtableParams = new ngTableParams({
	    	page: 1,            // show first page
	    	count: 10,          // count per page
	    	filter: {id:null,titleAll:null,arcticleStatus:null}
	    }, {
	    	total: 0,           // length of data
	    	counts: [10,20,50,100], // hide page counts control
	    	getData: function(params) {
	    		var result=ProManageArticleService.getarticleLists(params,$scope.newselffilters);
	    		return result;             
	    	}
	    });
	    /**********************************************查询************************************************************************/
		//左侧状态查询
		$scope.statusSearch=function (status){
			$scope.selffilters.status=status;
			self.tableParams.reload();
		}
		/**********************************************新增************************************************************************/
		
		//新增
		$scope.addArticle=function() {
				//初始化一些参数
				$scope.editinfo={};
				$scope.savetype=0; //存储类型 区分 0保存
				$scope.editinfo.keyWorddAry=[];
				$scope.editisOriginal = {'非原创':0,'原创':1};
				$scope.editinfo.isTop=0;
				$scope.iseditFlag=true; //编辑默认true 标示只读
				$scope.title = '专题-文章新增';
				ngDialog.open({
					className: 'ngdialog-theme-default',
					showClose: true,
					template: '<div ng-include="\'views/operative/colArtManage/addnewarticle.html\'"></div>',
					plain: true,
					width: '80%',
					scope:$scope
				});
		};


		//弹窗关闭
		$scope.aipublish=function(){
			ngDialog.close();
		}
		
		//弹窗关闭
		$scope.dialogClosed=function(){
			ngDialog.close();
		}
		
		/**********************************************顶部操作************************************************************************/
		//删除
		$scope.delArticle= function() {
			var ids=getselectedIds();
			if(null==ids){
				toaster.pop('error', "提示", "您没有选择要删除的相应的数据！");
				return;
			}
			SweetAlert.swal({   
	              title: '你是否要删除选中的文章?',   
	              type: 'warning',   
	              showCancelButton: true,   
	              confirmButtonColor: '#DD6B55',   
	              confirmButtonText: '是的',   
	              cancelButtonText: '取消',   
	              closeOnConfirm: true,   
	              closeOnCancel: true 
	            }, function(isConfirm){  
	              if (isConfirm) {  
	            	  POSTMethod('manage/proManage/delColArticle.json', {ids:ids}, "删除成功", "删除失败",0);
	              } else {     
	               // SweetAlert.swal('取消操作', '你取消了操作', 'error');   
	              } 
	        });
		};

		//返回
		$scope.goback= function() {
			$state.go('app.subjects');
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
					if(ids==null)ids=data[i].artColId;
					else ids+=","+data[i].artColId;
				}
			}
			return ids;
		}
		
		/******************************************************新增系列操作*************************************************************************/
		//查询
		$scope.newSearch=function (){
			$scope.newtableParams.reload();
		}
		//全选操作(新增)
		$scope.newselAllflag=false;
		$scope.newselAll= function() {
			$scope.newselAllflag=!$scope.newselAllflag;
			var data=$scope.newtableParams.data;
			for(var i=0;i<$scope.newtableParams.data.length;i++){
				$scope.newtableParams.data[i].$selected=$scope.newselAllflag;
			}
		};

		//存储选中
		$scope.newsaveChange= function() {
			var ids=getnewselectedIds();
			if(null==ids){
				toaster.pop('error', "提示", "您没有选择要新增的的相应的数据！");
				return;
			}
			SweetAlert.swal({   
	              title: '你是否要新增选中的文章?',   
	              type: 'warning',   
	              showCancelButton: true,   
	              confirmButtonColor: '#DD6B55',   
	              confirmButtonText: '是的',   
	              cancelButtonText: '取消',   
	              closeOnConfirm: true,   
	              closeOnCancel: true 
	            }, function(isConfirm){  
	              if (isConfirm) {  
	            	  POSTMethod('manage/proManage/addColArticles.json', {colId:$scope.colId,ids:ids}, "新增成功", "新增失败",1);
	              } else {     
	               // SweetAlert.swal('取消操作', '你取消了操作', 'error');   
	              } 
	        });
		};

		$scope.backPage = function () {

			$state.go('app.proManage',{id: $scope.colId, parentId: $scope.parentId});
		};

		//获取选中的(新增)
		function getnewselectedIds(){
			var ids = null;
			var data = $scope.newtableParams.data;
			for(var i = 0;i < data.length;i++){
				if(data[i].$selected){
					if(ids == null){
						ids = data[i].id;
					}
					else ids+=","+data[i].id;
				}
			}
			return ids;
		}
		
		
		/*******************************************************************************************************************************/
		
		//封装post
		function POSTMethod(url,params,successmessage,errormessage,type){
			$http({
  		        method  : 'POST',
  		        url     : url,
  		        data    : $.param(params),  // pass in data as strings
  		        headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  // set the headers so angular passing info as form data (not request payload)
  		    }).success(function(data, status, headers, config) {
  				var obj2 = eval(data);
  				if(status === 200){
  					self.tableParams.reload();
  					$scope.newtableParams.reload();
  					toaster.pop('success', "提示", successmessage);
  					if(type==1){
  						SweetAlert.swal({   
  							title: '你是否要继续操作?',   
  							type: 'warning',   
  							showCancelButton: true,   
  							confirmButtonColor: '#DD6B55',   
  							confirmButtonText: '是的',   
  							cancelButtonText: '取消',   
  							closeOnConfirm: true,   
  							closeOnCancel: true 
  						}, function(isConfirm){  
  							if (isConfirm) {  
  								
  							} else {     
  								$scope.dialogClosed(); 
  							} 
  						});
  					}
  					
  				}else{
  					toaster.pop('error', "提示",errormessage);
  				}
  			}).error(function(data, status, headers, config){
  				toaster.pop('error', "提示", "服务器繁忙！");
  			});
		}
		
		//封装postBody
		function POSTBodyMethod(url,params,successmessage,errormessage){
			$http({
  		        method  : 'POST',
  		        url     : url,
  		        data    : params
  		    }).success(function(data, status, headers, config) {
  				var obj2 = eval(data);
  				if(status === 200){
  					self.tableParams.reload();
  					toaster.pop('success', "提示", successmessage);
  					$scope.dialogClosed();
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
	.module('app.colArt')
	.service('ProManageArticleService', ProManageArticleService);
	ProManageArticleService.$inject = [ '$rootScope','$resource'];
	function ProManageArticleService($rootScope,$resource){
		var url1 = $rootScope.server.basePath+"manage/proManage/getArtByColPage.json";
		var url2 = $rootScope.server.basePath+"manage/proManage/selNotinColArticle.json";
		var lists = $resource(url1);
		this.getLists=function(params,selffilters){
			if(lists){
				var filter=params.filter();
				var search={};
				angular.copy(filter, search);
				search.page=params.page();
				search.size=params.count();
				search.colId=selffilters.colId;
				return lists.get(search).$promise.then(function(pageData){
					params.total(pageData.total);
		           return pageData.list;
				});
				
			}
		}
		
		//未在关联中的数据
		var articleLists = $resource(url2);
		this.getarticleLists=function(params,selffilters){
			if(articleLists){
				var filter=params.filter();
				var search={};
				angular.copy(filter, search);
				search.page=params.page();
				search.size=params.count();
				search.colId=selffilters.colId;
				search.articleTitle=selffilters.articleTitle; 
				search.channelId=selffilters.channelId;
				search.columnId=selffilters.columnId;
				return articleLists.get(search).$promise.then(function(pageData){
					params.total(pageData.total);
					return pageData.rows;
				});
				
			}
		}
	}
	
})();
