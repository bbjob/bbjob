(function() {
	'use strict';

	angular.module('app.model', []);
	
})();

/****
 * 专题管理的list
 * 
 * *****/
(function() {
    'use strict';
    var parentId = null;
	var channelId = '';
	var childClick = 0;
	var showTempNo = '';
	var breadlist = ['专题管理', '专题管理（新）'];
	var codeHtml = '';

    angular
    .module('app.model')
    .controller('proManageCtrl', proManageCtrl);

	angular.module('app.model').controller('chooseModelCtrl', chooseModelCtrl).directive('ckeditor', function() {
		return {
			require : '?ngModel',
			link : function(scope, element, attrs, ngModel) {
				var ckeditor = CKEDITOR.replace(element[0],  {
					fullPage: true,
					toolbarStartupExpanded:false,
					// height:150
				});
				if (!ngModel) {
					return;
				}
				ckeditor.on('instanceReady', function() {
					ckeditor.setData(ngModel.$viewValue);
				});
				ckeditor.on('pasteState', function() {
					scope.$apply(function() {
						ngModel.$setViewValue(ckeditor.getData());
					});
				});
				ngModel.$render = function(value) {
					ckeditor.setData(ngModel.$viewValue);
				};
			}
		};
	});
	angular.module('app.model').controller('chooseModelCtrl', chooseModelCtrl).directive('onFinishRenderFilters', function ($timeout) {
		return {
			restrict: 'A',
			link: function(scope, element, attr) {
				var modelNo = showTempNo.substr(0, 3),
					alpha = showTempNo.substr(3);

				for (var i = 0; i < alpha.length; i++) {
					var item = modelNo + "0" + (i+1);
					var node = document.getElementById(item);
					var nodeHtml = "";

					if (alpha[i] === "t") {
						nodeHtml = "<div>标题</div>";
					} else if (alpha[i] === "p") {
						nodeHtml = "<img src='app/img/user/12.jpg'>"
					} else if (alpha[i] === "s") {
						nodeHtml = "<div>摘要</div>";
					} else if (alpha[i] === "a") {
						nodeHtml = "<div>作者</div>";
					} else if (alpha[i] === "c") {
						nodeHtml = "<div>点击量</div>";
					} else if (alpha[i] === "l") {
						nodeHtml = "<div>浏览量</div>";
					} else if (alpha[i] === "d") {
						nodeHtml = "<div>时间</div>"
					} else {
						nodeHtml = "<div></div>"
					}
					node.innerHTML = nodeHtml;
				}

				// console.log(modelNo, alpha);

				/*			var node = document.getElementById("30101");

				console.log(node);
				console.log(showTempNo);
				node.innerHTML = "<div>标题</div>"*/
			}
		};
	});

    //自定义状态拦截器
    angular
    .module('app.model').filter("statusfilter",function(){
    	return function(input,uppercase){
    		var name = input;
    		if(input==0){
    			name="禁用";
    		}
    		else if(input==1){
    			name="启用";
    		}
    		return name;
    	}
    });

	angular
			.module('app.model').filter("isShowFilter",function(){
		return function(input,uppercase){
			var name = input;

			if(input==0){
				name="否";
			}
			else if(input==1){
				name="是";
			}
			return name;
		}
	});

	angular
			.module('app.model').filter("columnTypeFilter",function(){
		return function(input,uppercase){
			var name = input;
			if(input==0){
				name="内部栏目";
			}
			else if(input==1){
				name="外部链接";
			}
			return name;
		}
	});

    proManageCtrl.$inject = ['$rootScope','$scope', '$http','$state','toaster','SweetAlert', 'NgTableParams','ngDialog','proManageService','$stateParams'];

	function chooseModelCtrl() {
	}

    
	function proManageCtrl($rootScope,$scope, $http,$state,toaster,SweetAlert,ngTableParams,ngDialog,proManageService,$stateParams) {
		$scope.id = $stateParams.id;
		$scope.parentId = $stateParams.parentId;
		//传递的查询条件(左侧定义查询)
		$scope.selffilters = {id: null, status: null, time:null, type:0, flagBit: 1, parentId: $scope.parentId};
		$scope.folderfilters = {path: null, folderName: null};
		$scope.subjectArticlefilters = { status: null, time:null};
		$scope.istopSel = {'否':0,'是':1};
		//状态筛选定义
		$scope.selStatus = [{key:'全部',value:null,icon:'fa-calendar-o'},{key:'禁用',value:0,icon:'fa-dot-circle-o'},{key:'启用',value:1,icon:'fa-dot-circle-o'}];

		$scope.isShowSEL = [{'id':0,'title':'否'},{'id':1,'title':'是'}];
		$scope.timeSEL = [{'id': 0, 'title': 'YYYY/MM/DD'}, {'id': 1, 'title': 'YYYY:MM:DD HH:mm:ss'}];
		$scope.sortSEL = [{'id': 0, 'title': '时间倒序'}, {'id': 1, 'title': '时间顺序'},{'id': 2, 'title': '浏览量倒序'}, {'id': 3, 'title': '浏览量顺序'}];
		$scope.groups = [];
		$scope.breadlist = breadlist;
		$scope.saveType = 1;  // 0:修改  1:新增
		getMemberGroup();
		getChannelId();
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
                var result=proManageService.getLists(params,$scope.selffilters);
				$scope.groups = [];
            	return result;
            }
        });

		self.folderTableParams = new ngTableParams({},{
			total: 0,           // length of data
			counts: [], // hide page counts control
			getData: function (params) {
				var result = proManageService.getFolderList(params, $scope.folderfilters);
				return result;
			}
		})

	    /**********************************************数据load************************************************************************/
	    //未关联查询
//	    $scope.sujectArticletableParams = new ngTableParams({
//	    	page: 1,            // show first page
//	    	count: 10,          // count per page
//	    	filter: {id:null,titleAll:null,arcticleStatus:null}
//	    }, {
//	    	total: 0,           // length of data
//	    	counts: [10,20,50,100], // hide page counts control
//	    	getData: function(params) {
//	    		var result=proManageService.getsubjectArticlelists(params,$scope.subjectArticlefilters);
//	    		return result;             
//	    	}
//	    });
	    /**********************************************表格上查询组装数据************************************************************************/
	    //置顶
	    self.topSEL=function(cloum){
	    	return [{'id':1,'title':'已置顶'},{'id':0,'title':'未置顶'}];
	    }
	    //客户端
	    self.ispublicSEL=function(cloum){
	    	return [{'id':0,'title':'全部不显示'},{'id':1,'title':'PC'},{'id':2,'title':'APP'},{'id':3,'title':'全部显示'}];
	    }
	    //状态
	    self.statusSEL=function(cloum){
	    	return [{'id':1,'title':'启用'},{'id':0,'title':'禁用'}];
	    }
		self.isShowSEL = function (cloum) {
			return [{'id':0,'title':'否'},{'id':1,'title':'是'}];
		}
		self.columnTypeSEL = function (cloum) {
			return [{'id':0,'title':'内部栏目'},{'id':1,'title':'外部链接'}];
		}

	    //推荐
	    self.free3SEL=function(cloum){
	    	return [{'id':1,'title':'是'},{'id':0,'title':'否'}];
	    }
	    //左侧状态查询
	    $scope.doSomething=function (){
	    	console.log("-------------------------------1223-------------");
	    }
	    /**********************************************查询************************************************************************/
		//左侧状态查询
		$scope.statusSearch=function (status){
//			$scope.selffilters.status=status;
//			$scope.selffilters.type=1;
			self.tableParams.filter().status=status;
			self.tableParams.reload();
		}
//			$scope.selffilters.type=0;
		/**********************************************新增************************************************************************/

		$scope.selected = [];
		$scope.updateSelection = function($event, id){
			var checkbox = $event.target;
			var action = (checkbox.checked ? 'add' : 'remove');
			updateSelected(action,id,checkbox.name);
		}
		function updateSelected (action,id,name) {
			if(action == 'add' && $scope.selected.indexOf(id) == -1){
				$scope.selected.push(id);
			}
			if(action == 'remove' && $scope.selected.indexOf(id) != -1){
				var idx = $scope.selected.indexOf(id);
				$scope.selected.splice(idx,1);
			}
		}

		$scope.artTypeSelected = [];
		$scope.updateArtTypeSelection = function($event, id) {
			var checkbox = $event.target;
			var action = (checkbox.checked ? 'add' : 'remove');
			updateArtTypeSelected(action,id,checkbox.name);
		}
		function updateArtTypeSelected(action,id,name) {
			if(action == 'add' && $scope.artTypeSelected.indexOf(id) == -1){
				$scope.artTypeSelected.push(id);
			}
			if(action == 'remove' && $scope.artTypeSelected.indexOf(id) != -1){
				var idx = $scope.artTypeSelected.indexOf(id);
				$scope.artTypeSelected.splice(idx,1);
			}
		}

		$scope.contentSelected = [];
		$scope.updateContentSelection = function($event, id) {
			var checkbox = $event.target;
			var action = (checkbox.checked ? 'add' : 'remove');
			updateContentSelected(action,id,checkbox.name);
		}
		function updateContentSelected(action,id,name) {
			if(action == 'add' && $scope.contentSelected.indexOf(id) == -1){
				$scope.contentSelected.push(id);
			}
			if(action == 'remove' && $scope.contentSelected.indexOf(id) != -1){
				var idx = $scope.contentSelected.indexOf(id);
				$scope.contentSelected.splice(idx,1);
			}
		}

		//新增
		$scope.add = function() {
			$scope.editinfo = Object.assign({
				columnsName: '', // 栏目名称
				columnType: '',  // 栏目类型
				externalLinks: '', // 外链地址
				folder: '', // 文件夹
				tempTag: '', // 模板标签
				isShow: '', // 是否显示
				remarks: '', // 备注
				columnFile: '', //栏目文件
				status: '',
				channelId: $scope.channelId,
				parentId: parentId,
				selected: []
			});

			$state.go('app.proManageAdd',{editinfo: $scope.editinfo, savetype: 0});
			/*			var privObj = {};
			for (var i = 0; i < $scope.checkGroupList.length; i++) {
				privObj[$scope.checkGroupList[i]] = '';
			}

			//初始化一些参数
			$scope.editinfo = Object.assign({
				columnsName: '', // 栏目名称
				columnType: '',  // 栏目类型
				externalLinks: '', // 外链地址
				folder: '', // 文件夹
				tempTag: '', // 模板标签
				isShow: '', // 是否显示
				remarks: '', // 备注
				columnFile: '', //栏目文件
				status: ''
			}, privObj);
			$scope.savetype=0; //存储类型 区分 0保存
			$scope.selected = [];
			$scope.artTypeSelected = [];
			$scope.contentSelected = [];
			$scope.editModelAttr = {};
			$scope.iseditFlag=true; //编辑默认true 标示只读
			channelId = '';
			$scope.openDialogId = ngDialog.open({
				className: 'ngdialog-theme-default',
				showClose: true,
				template: '<div ng-include="\'jsp/views/operative/proManage/add.html\'"></div>',
				plain: true,
				width: '70%',
				scope:$scope
			});*/
		};

		$scope.TagAttrSet = function() {

			if ($scope.editModelAttr === undefined || $scope.editModelAttr === null || Object.keys($scope.editModelAttr).length === 0) {
				$scope.artTypeSelected = [];
				$scope.contentSelected = [];
				var url = 'manage/proManage/getModelAttributeByClumnId.json?ClumnId=' + channelId;
				$http.get(url).success(function (data, status, headers, config) {
					if (status === 200) {
						var data = data;

						if (data.length == 0) {
							$scope.editModelAttr = {
								articleNumber: '',
								articleType: '',
								lineNumber: '',
								timeType: 0,
								displayConent: '',
								sortType: 0,
								titleLength: '',
								titleLineNumber: '',
								prefixType: '',
								prefixContent: '',
								prefixPic: '',
								abstractLength: '',
								abstractLineNumber: '',
								picHeight: '',
								picWide: '',
								articleAuthor: '',
								childrenClomns: '0',
								original: '0',
								model: '',
								rotationType: '0',
								keyword: ''
							}
							$scope.artTypeSelected = [0, 1]

						} else {
							$scope.editModelAttr = data[0];

							var artTypeString = data[0].articleType;
							var contentString = data[0].displayConent;

							var artTypes = artTypeString.split(",");
							var contents = contentString.split(",");

							for (var i = 0;i < artTypes.length;i++) {
								if (!('' === artTypes[i])) {
									$scope.artTypeSelected.push(parseInt(artTypes[i]))
								}
							}

							for (var i = 0;i < contents.length;i++) {
								if (!('' === contents[i])) {
									$scope.contentSelected.push(parseInt(contents[i]))
								}
							}
						}

						$scope.openTagAttrSetDialog = ngDialog.open({
							className: 'ngdialog-theme-default',
							showClose: true,
							template:  '<div ng-include="\'views/operative/proManage/tagAttrSet.html\'"></div>',
							plain: true,
							width: '70%',
							scope:$scope
						});
					}
				}).error(function () {
					toaster.pop('error', "查询基础信息失败", "请稍后再试");
				});
			} else {
				$scope.openTagAttrSetDialog = ngDialog.open({
					className: 'ngdialog-theme-default',
					showClose: true,
					template:  '<div ng-include="\'views/operative/proManage/tagAttrSet.html\'"></div>',
					plain: true,
					width: '70%',
					scope:$scope
				});
			}
		};

		$scope.modalSave = function(value) {

			console.log(value);
		};

		$scope.QTClick = function() {
			$scope.openQTDialog = ngDialog.open({
				className: 'ngdialog-theme-default',
				showClose: true,
				template:  '<div ng-include="\'jsp/views/operative/proManage/qt.html\'"></div>',
				plain: true,
				width: '60%',
				scope:$scope
			});
		};

		$scope.qtSave = function(value) {

			console.log(value);
		};


		/******************************************复制连接功能*********************************************************/
		$scope.copyURL= function() {
			var ids=getselectedIds(); //本次修改 获取发布及未发布全部 选中ID
			if(!ids){
				toaster.pop('error', "提示", "您没有选择要复制链接的相应的数据(或状态不正确)！");
			}else if(ids.indexOf(",")!=-1){
				toaster.pop('error', "提示", "此操作只能选择一条数据！");
			}else{
				
				document.getElementById("fe_text").innerHTML="这里是用于复制的纯文本数据1:"+ids;
			}
			/*$http({
				method  : 'GET',
				url     : 'manage/copyurl/todo.json?type=1&id='+ids
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
			});*/
		};
		
		//模板配置弹出层
		$scope.editTemp= function(index) {
			var ids=getselectedIds();
			if(null==ids){
				toaster.pop('error', "提示", "您没有选择相应的数据！");
				return;
			}
			else if(ids.indexOf(",")!=-1){
				toaster.pop('error', "提示", "本操作只能选择一条数据！");
				return;
			}else{
				$http({ method  : 'GET', url : 'manage/proManage/templent.json?subjectId='+ids
				}).success(function(data, status, headers, config) {
					var obj2 = eval(data);
					if(obj2.statusCode==200){
						$scope.modelInfo=obj2.data;
						console.log($scope.modelInfo);
						ngDialog.open({
							className: 'ngdialog-theme-default',
							showClose: true,
							template: '<div ng-include="\'jsp/views/operative/proManage/muban-templet.html\'"></div>',
							plain: true,
							width: '70%',
							scope:$scope
						});
					}
				}).error(function(data, status, headers, config){});
				
			}
		};
		
		//模板配置弹出层
		$scope.editTempftl= function(index) {
			$scope.subjectId=null;
			 $scope.ftlfile={};
			var ids=getselectedIds();
			if(null==ids){
				toaster.pop('error', "提示", "您没有选择相应的数据！");
				return;
			}
			else if(ids.indexOf(",")!=-1){
				toaster.pop('error', "提示", "本操作只能选择一条数据！");
				return;
			}else{
				$http({ method  : 'GET', url : 'manage/proManage/isupftl.json?subjectId='+ids
				}).success(function(data, status, headers, config) {
					var obj2 = eval(data);
					if(obj2.statusCode==200){
						$scope.subjectId=ids;
						$scope.isupload=0;
						if(obj2.data==1)$scope.isupload=1;
						ngDialog.open({
							className: 'ngdialog-theme-default',
							showClose: true,
							template: '<div ng-include="\'jsp/views/operative/proManage/ftl-templet.html\'"></div>',
							plain: true,
							width: '50%',
							scope:$scope
						});
					}
				}).error(function(data, status, headers, config){});
				
			}
		};
		
		/*****************模板上传功能******************/
		// 选择按钮
		 $scope.uploadFiles = function(file, errFiles) {
			 if(null==file||undefined==file){
				 return;
			 }
			 else if(!file.name.endWith(".ftl")){
				 toaster.pop('error', "提示", "请上传正确的模板文件！");
				 return;
			 }
			 $scope.ftlfile.name = file.name;
	         $scope.ftlfile.file = file;
	    }
		 //移除文件
		 $scope.removeFtlFile = function() {
			 $scope.ftlfile={};
		 }
		 //下载文件
		 $scope.downFtl = function(name) {
			 window.open("manage/proManage/downtemplent.json?name="+name);
//			 window.open("ftl/default.ftl");
		 }

		 //endWith
		 String.prototype.endWith=function(str){
	            if(str==null||str==""||this.length==0||str.length>this.length)
	              return false;
	            if(this.substring(this.length-str.length)==str)
	              return true;
	            else
	              return false;
	            return true;
	        }



		//新增/修改保存
		$scope.addsave = function(type){

			var changeinfo = $scope.editinfo;
			changeinfo['channelId'] = $scope.channelId;
			changeinfo['parentId'] = parentId;
			changeinfo['memberGroup'] = $scope.selected;

			changeinfo['modelAttribute'] = $scope.editModelAttr;
			changeinfo['modelAttribute']['artTypeList'] = $scope.artTypeSelected;
			changeinfo['modelAttribute']['contentList'] = $scope.contentSelected;

			if($scope.savetype == 1){
				POSTBodyMethod('manage/proManage/update.json', changeinfo, "修改成功", "修改失败");
			} else if($scope.savetype == 0){
				POSTBodyMethod('manage/proManage/add.json', changeinfo, "保存成功", "保存失败");
			}

		}

		$scope.setTag = function() {

		}

		//弹窗关闭
		$scope.dialogClosed=function(){
			$scope.selected = [];
			$scope.artTypeSelected = [];
			$scope.contentSelected = [];
			ngDialog.close();
		}


		
		/**********************************************发布撤销退回(顶部操作)************************************************************************/
		//操作 1审核2发布3弃用4删除
		$scope.changeEa= function(status) {
			var name="";
			switch (status) {
				case 1: name="审核"; break;
				case 2: name="发布";break;
				case 3: name="弃用";break;
				case 4: name="删除";break;
			}
			var ids=getselectedIds();
			if(null==ids){
				toaster.pop('error', "提示", "您没有选择要发布的相应的数据！");
				return;
			}
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
	            	  POSTMethod('manage/proManage/somechange.json', {ids:ids,status:status,type:status}, name+"成功",  name+"失败");
	              } else {     
	               // SweetAlert.swal('取消操作', '你取消了操作', 'error');   
	              } 
	        });
		};
		
		//文章编辑
		$scope.editArticle2= function() {
			var ids=getselectedIds();
			if(null==ids){
				toaster.pop('error', "提示", "您没有选择相应的数据！");
				return;
			}
			else if(ids.indexOf(",")!=-1){
				toaster.pop('error', "提示", "本操作只能选择一条数据！");
				return;
			}else{
				$state.go('app.subjectarticle',{subjectId:ids,subjectTitle:getselectedNames()});
			}
			
		};
		
		//文章编辑
		$scope.editArticle= function() {
			var rows=getselectedRows();
			if(rows.length<=0){
				toaster.pop('error', "提示", "您没有选择相应的数据！");
				return;
			}
			else if(rows.length>1){
				toaster.pop('error', "提示", "本操作只能选择一条数据！");
				return;
			}else{
				$state.go('app.subjectarticle',{subject:rows[0]});
			}
			
		};
		
		//编辑跳页
		$scope.gotosubjectArticle= function() {
			$scope.dialogClosed();
			$state.go('app.subjectarticle',{subject:$scope.editinfo});
		};

		$scope.changeSelection = function(row){
			if (childClick === 1) {
				childClick = 0;
			} else {
				if (row.$selected == true) {
					$scope.groups.push(row);
				} else {
					for ( var index in $scope.groups) {
						if ($scope.groups[index].id === row.id) {
							//删除
							$scope.groups.splice(index, 1);
							return;
						}
					}
				}
			}
		};

		// 启用
		$scope.enable = function() {
			if ($scope.groups.length === 0) {
				toaster.pop('error', "提示", "请选中一行");
			} else if($scope.groups.length > 1) {
				toaster.pop('error', "提示", "请选中一行");
			} else {
				var changeinfo = $scope.groups[0];
				changeinfo['status'] = 1
				POSTBodyMethod('manage/proManage/update.json', changeinfo, "修改成功", "修改失败");
			}
		}

		// 禁用
		$scope.disable = function() {
			if ($scope.groups.length === 0) {
				toaster.pop('error', "提示", "请选中一行");
			} else if($scope.groups.length > 1) {
				toaster.pop('error', "提示", "请选中一行");
			} else {
				var changeinfo = $scope.groups[0];
				changeinfo['status'] = 0
				POSTBodyMethod('manage/proManage/update.json', changeinfo, "修改成功", "修改失败");
			}
		}


		/******************************导出***********************************************/
		//导出
		$scope.exports= function() {
			var data = self.tableParams.data;
			if(data.length>0){
				var par = $.param(Object.assign($scope.selffilters, self.tableParams.filter()));
				location.href = $rootScope.server.basePath+"manage/proManage/exportExcel.json?"+par;
			}else{
				toaster.pop('error', "提示", "没有要导出的数据");
			}
		};
		
		//关联文章导出
		$scope.exportsSA= function() {
			var data= $scope.sujectArticletableParams.data;
			if(data.length>0){
				var par=$.param($scope.subjectArticlefilters);
				location.href=$rootScope.server.basePath+"manage/subjectarcticle/exportExcel.json?"+par;
			}else{
				toaster.pop('error', "提示", "没有要导出的数据");
			}
		};

		// 查询该栏目下的所有文章
		$scope.getArticleByCol = function(index) {
			var colId = self.tableParams.data[index].id,
				parentId = self.tableParams.data[index].parentId,
				colName = self.tableParams.data[index].columnsName;

			$state.go('app.colArtManage',{colId: colId, colName: colName, parentId: parentId});
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
			var ids = null;
			var data = self.tableParams.data;
			for(var i = 0;i < data.length;i++){
				if(data[i].$selected){
					if(ids==null){
						ids = data[i].id;
					} else {
						ids+=","+data[i].id;
					}
				}
			}
			return ids;
		}
		//获取选中的
		function getselectedRows(){
			var rows=[];
			var data=self.tableParams.data;
			for(var i=0;i<data.length;i++){
				if(data[i].$selected){
					rows.push(data[i]);
				}
			}
			return rows;
		}
		
		//获取选中的名字
		function getselectedNames(){
			var names=null;
			var data=self.tableParams.data;
			for(var i=0;i<data.length;i++){
				if(data[i].$selected){
					if(names==null)names=data[i].title;
					else names+=","+data[i].title;
				}
			}
			return names;
		}
		
		/**************************专题文章列表操作类******************************/
		//专题文章关联全选操作
		$scope.selsubjectAAllflag=false;
		$scope.selsubjectAAll= function() {
			$scope.selsubjectAAllflag=!$scope.selsubjectAAllflag;
			for(var i=0;i< $scope.sujectArticletableParams.data.length;i++){
				 $scope.sujectArticletableParams.data[i].$selected=$scope.selsubjectAAllflag;
			}
		};
		
		//获取选中的
		function getsubjectAselectedIds(){
			var ids=null;
			var data= $scope.sujectArticletableParams.data;
			for(var i=0;i<data.length;i++){
				if(data[i].$selected){
					if(ids==null)ids=data[i].id;
					else ids+=","+data[i].id;
				}
			}
			return ids;
		}
		
		//删除专题
		$scope.del = function() {
			var ids = getselectedIds();
			if(null == ids){
				toaster.pop('error', "提示", "您没有选择要删除的相应的专题！");
				return;
			}
			SweetAlert.swal({   
				title: '你是否要删除选中的专题?',   
				type: 'warning',   
				showCancelButton: true,   
				confirmButtonColor: '#DD6B55',   
				confirmButtonText: '是的',   
				cancelButtonText: '取消',   
				closeOnConfirm: true,   
				closeOnCancel: true 
			}, function(isConfirm){  
				if (isConfirm) {  
					POSTMethod('manage/proManage/delproManage.json', {ids:ids}, "删除成功", "删除失败");
					self.tableParams.reload();
				} else {     
					// SweetAlert.swal('取消操作', '你取消了操作', 'error');   
				} 
			});
		};
		
		//删除专题文章
		$scope.delArticle= function() {
			var ids=getsubjectAselectedIds();
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
	            	  POSTMethod('manage/subjectarcticle/delsubjectarticle.json', {ids:ids}, "删除成功", "删除失败");
	            	  $scope.sujectArticletableParams.reload();
	              } else {     
	               // SweetAlert.swal('取消操作', '你取消了操作', 'error');   
	              } 
	        });
		};
		

		//置顶按钮事件 type 1 置顶 2加精 
		$scope.isTopClick=function(index){
			$scope.editinfo=self.tableParams.data[index];
			self.tableParams.data[index].isTop=!self.tableParams.data[index].isTop;
			var id=self.tableParams.data[index].id;
			var change=self.tableParams.data[index].isTop==true?1:0;
			POSTMethod('manage/proManage/istop.json', {id:self.tableParams.data[index].id,status:change}, "操作成功", "操作失败");
		}
		
		//置顶按钮事件 type 
		$scope.statusClick=function(index){
			$scope.editinfo=self.tableParams.data[index];
			self.tableParams.data[index].status=!self.tableParams.data[index].status;
			var id=self.tableParams.data[index].id;
			var change=self.tableParams.data[index].status==true?1:0;
			POSTMethod('manage/proManage/status.json', {id:self.tableParams.data[index].id,status:change}, "操作成功", "操作失败");
		}
		
		//推荐首页
		$scope.isFree3Click=function(index){
			$scope.editinfo=self.tableParams.data[index];
			self.tableParams.data[index].free3too=!self.tableParams.data[index].free3too;
			var id=self.tableParams.data[index].id;
			var change=self.tableParams.data[index].free3too==true?1:0;
			POSTMethod('manage/proManage/isfree3.json', {id:self.tableParams.data[index].id,status:change}, "操作成功", "操作失败");
		}

		// ---- 操作编辑事件 ----
		$scope.operEdit = function(channel) {
			//初始化一些参数
			$scope.editinfo = channel;
			$scope.editinfo['channelId'] = channel.channelId;
// 			$scope.savetype = 1; //存储类型 区分 0保存

/*			$scope.iseditFlag = true; //编辑默认true 标示只读
			$scope.selected = [];
			$scope.artTypeSelected = [];
			$scope.contentSelected = [];
			$scope.editModelAttr = {};
			channelId = channel.id;*/
			var url = 'manage/proManage/getSelectMemberGroupList.json?channelColumnsId=' + channel.id;
			$http.get(url).success(function (data, status, headers, config) {
				if (status == 200) {
					var dataArray = data;
					for (var i = 0; i < dataArray.length; i++) {
						$scope.selected.push(dataArray[i].memberGroupId)
					}
					$scope.editinfo['selected'] = $scope.selected

					$state.go('app.proManageAdd',{editinfo: $scope.editinfo, savetype: 1});
				}
			}).error(function () {
				toaster.pop('error', "查询基础信息失败", "请稍后再试");
			});
		}

		// ---- 操作查看子栏目事件
		$scope.opeOpenChild = function(channelId, channelName) {
			$scope.groups = [];

			childClick = 1;

			$scope.selffilters.parentId = channelId;
			parentId = channelId;

			breadlist.push(channelName);
			$scope.breadlist = breadlist;
			self.tableParams.reload();
		}

		// ---- 返回
		$scope.backPage = function() {
			$scope.groups = [];
			childClick = 0;

			var url = 'manage/proManage/getPrevParentId.json?parentId=' + parentId;
			$http.get(url).success(function (data, status, headers, config) {
				if (status == 200) {
					$scope.selffilters.parentId = data;
					parentId = data;

					if (breadlist.length > 2) {
						breadlist.pop();
					}
					$scope.breadlist = breadlist;

					self.tableParams.reload();
				}
			}).error(function () {
				toaster.pop('error', "查询基础信息失败", "请稍后再试");
			});
		}

		$scope.isChecked = function(id) {
			return $scope.selected.indexOf(id) >= 0 ;
		}

		$scope.isArtTypeChecked = function(id) {
			return $scope.artTypeSelected.indexOf(id) >= 0;
		}

		$scope.isContentChecked = function(id) {
			return $scope.contentSelected.indexOf(id) >= 0;
		}

		$scope.chooseModel = function() {
			// 0:标题  1:图片  2:摘要  3:作者  4:点击量  5:浏览量  6:时间
			if ($scope.contentSelected.length < 2) {
				toaster.pop('info', "提示", "请至少选择2个显示内容");
				return;
			} else if ($scope.contentSelected.length > 4) {
				toaster.pop('error', "提示", "没找到适合5种内容的模板!");
				return;
			} else {
				var showTemplate = $scope.editModelAttr.model,
					displayContent = $scope.editModelAttr.displayConent;

				showTempNo = showTemplate;
				var modelNo = null;
				if (showTemplate !== null && showTemplate !== '') {
					modelNo = showTemplate.substr(0, 3)
				}
				var	chooseModelObj = {
						modelNo: modelNo,
						displayContent: displayContent,
						item: '',
						itemObj: {}
					}

				$scope.chooseModelObj = chooseModelObj;

				ngDialog.open({
					className: 'ngdialog-theme-default',
					showClose: true,
					template: '<div ng-include="\'jsp/views/operative/proManage/chooseModel.html\'"></div>',
					plain: true,
					width: '70%',
					scope:$scope,
					controller: "chooseModelCtrl"
				})
			}
		}

		$scope.modelNoClick = function (item, order) {
			var modelNo = item.substr(0, 3);
			if (modelNo !== $scope.chooseModelObj.modelNo) {
				toaster.pop('error', "提示", "请设置已选中的显示模板");
				return;
			}

			$scope.chooseItem = item;
			$scope.chooseOrder = order;
			ngDialog.open({
				className: 'ngdialog-theme-default',
				showClose: true,
				template: '<div ng-include="\'jsp/views/operative/proManage/itemChoose.html\'"></div>',
				plain: true,
				width: '70%',
				scope:$scope
			});

		}

		$scope.setModelItem = function () {
			// // 0:标题  1:图片  2:摘要  3:作者  4:点击量  5:浏览量  6:时间

			var item = $scope.chooseItem,
				splitItem = item.substr(0, 3),
				order = $scope.chooseOrder,
				itemcode = $scope.chooseModelObj.item,
				eleNode = document.getElementById(item),
				alpha = '';
				// nELENode = document.createElement("div");
			var nodeHtml = '';
			if (itemcode === "0") {
				nodeHtml = "<div>标题</div>";
				alpha = 't';
			} else if (itemcode === "1") {
				nodeHtml = "<img src='app/img/user/12.jpg'>"
				alpha = 'p';
			} else if (itemcode === "2") {
				nodeHtml = "<div>摘要</div>";
				alpha = 's';
			} else if (itemcode === "3") {
				nodeHtml = "<div>作者</div>";
				alpha = 'a';
			} else if (itemcode === "4") {
				nodeHtml = "<div>点击量</div>";
				alpha = 'c';
			} else if (itemcode === "5") {
				nodeHtml = "<div>浏览量</div>";
				alpha = 'l';
			} else if (itemcode === "6") {
				nodeHtml = "<div>时间</div>"
				alpha = 'd';
			} else {
				nodeHtml = "<div></div>"
			}

			eleNode.innerHTML = nodeHtml;
			// document.getElementById(item).appendChild('标题');
			if ($scope.chooseModelObj.itemObj[splitItem] === undefined || $scope.chooseModelObj.itemObj[splitItem] == null) {
				$scope.chooseModelObj.itemObj[splitItem] = {};
				$scope.chooseModelObj.itemObj[splitItem][order] = alpha;
			} else {
				$scope.chooseModelObj.itemObj[splitItem][order] = alpha;
			}

		}

		$scope.setShowTemplate = function () {
			var item = $scope.chooseItem,
				splitItem = item.substr(0, 3),
				chooseModelObj = $scope.chooseModelObj.itemObj[splitItem];

			var index = 0;
			var alpha = '';
			if (splitItem.indexOf("2") === 0) {
				index = 2
			} else if (splitItem.indexOf("3") === 0) {
				index = 3
			} else if (splitItem.indexOf("4") === 0) {
				index = 4
			}

			for (var i = 1; i <= index; i++) {
				if (chooseModelObj[i] === null || chooseModelObj[i] === undefined) {
					toaster.pop('error', "提示", "模板与参数不匹配，请重新配置");
					return;
				}
				alpha += chooseModelObj[i];
			}

			$scope.editModelAttr.model = splitItem + alpha;

			showTempNo = splitItem + alpha;
		}

		$scope.onFolderClick = function () {
			$scope.folderName = '文件管理';

			ngDialog.open({
				className: 'ngdialog-theme-default',
				showClose: true,
				template: '<div ng-include="\'jsp/views/operative/proManage/folder-list.html\'"></div>',
				plain: true,
				width: '70%',
				scope:$scope
			});
		}

		$scope.chooseFoundModel = function(filePath) {
			$scope.fileAttr.foundModal = filePath;

			var url = 'modelFolderController/getSampleModelContent.json?path=' + filePath;

			$http.get(url).success(function (data, status, headers, config) {
				if (data.statusCode == '200') {
					// var sampleList = data.data;
					$scope.fileAttr.TContent = data.data;
/*					$('#summernote').summernote('destroy');
					$('#summernote').summernote("code", $scope.fileAttr.TContent);*/
				}
			}).error(function () {
				toaster.pop('error', "查询基础信息失败", "请稍后再试");
			});

			//	alert(fileName);
		}


		// 富文本编辑相关
		$scope.config = {
			enableAutoSave: false,//自动保存
			maximumWords:100000, //最大字符
			// initialFrameHeight:320,  //初始化编辑器高度,默认320
			autoHeightEnabled:false, //是否自动长高,默认true
			autoFloatEnabled:true,//是否保持toolbar的位置不动,默认true
			allowDivTransToP: false,
			toolbars: [[
				'fullscreen', 'source', '|', 'undo', 'redo', '|',
				'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
				'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
				'app.modelstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
				'directionalityltr', 'directionalityrtl', 'indent', '|',
				'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
				'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
				'insertimage', 'scrawl','insertframe', 'insertcode', 'template', '|',
				'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
				'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
				'preview', 'searchreplace', 'help','pagebreak','autoQMTButton'
			]]
		}

		/**************************封装的POST******************************/
		//封装post 不关闭Dialog
		function POSTMethodNotCloseD(url,params,successmessage,errormessage){
			$http({
				method  : 'POST',
				url     : url,
				data    : $.param(params),  // pass in data as strings
				headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  // set the headers so angular passing info as form data (not request payload)
			}).success(function(data, status, headers, config) {
				var obj2 = eval(data);
				if(obj2.statusCode==200){
					self.folderTableParams.reload();
					toaster.pop('success', "提示", successmessage);
				}else{
					toaster.pop('error', "提示",errormessage);
				}
			}).error(function(data, status, headers, config){
				toaster.pop('error', "提示", "服务器繁忙！");
			});
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
  				if(status == 200){
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
		
		//封装postBody
		function POSTBodyMethod(url,params,successmessage,errormessage){
			$http({
  		        method  : 'POST',
  		        url     : url,
  		        data    : params
  		    }).success(function(data, status, headers, config) {
  				var obj2 = eval(data);
  				if(status == 200){
					$scope.groups = [];
					$scope.editModelAttr = {};
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


		// 获取会员组信息
		function getMemberGroup() {
			var url = 'manage/proManage/getMemberGroupList.json';
			$http.get(url).success(function (data, status, headers, config) {
				if (status == 200) {
					var checkGroup = [],
						memberGroupData = data;

					for (var i = 0; i < memberGroupData.length; i++) {
						var modal = "priv" + i;
						memberGroupData[i].priv = modal;
						checkGroup.push(modal);
					}

					$scope.memberGroupList = memberGroupData;
					$scope.checkGroupList = checkGroup;

				}
			}).error(function () {
				toaster.pop('error', "查询基础信息失败", "请稍后再试");
			});
		}

		// 获取频道ID
		function getChannelId() {
			var url = 'manage/proManage/getChannelId.json?flagBit=1';
			$http.get(url).success(function (data, status, headers, config) {
				if (status == 200) {
					$scope.channelId = data;
				}
			}).error(function () {
				toaster.pop('error', "查询基础信息失败", "请稍后再试");
			});

		}

	}
	
	
	/****************相应的实现类**************************/
	angular
	.module('app.model')
	.service('proManageService', proManageService);
	proManageService.$inject = [ '$rootScope','$resource'];
	function proManageService($rootScope,$resource){
		var url1 = $rootScope.server.basePath+'manage/proManage/page.json';
		var url2 = $rootScope.server.basePath+'modelFolderController/getModelFolderList.json';
		var lists = $resource(url1);
		var folderList = $resource(url2);
		this.getLists=function(params,selffilters){
			if(lists){
				var filter=params.filter();
				var search={};
				angular.copy(filter, search);
				search.page=params.page();
				search.size=params.count();
				/*if(selffilters.status!=null&&selffilters.type==1){
					search.status=selffilters.status; //左侧状态切换查询
				}*/
				search.time=selffilters.time; //左侧时间
				search.flagBit = selffilters.flagBit; // 项目栏目ID
				search.parentId = selffilters.parentId;  // 上级ID

				return lists.get(search).$promise.then(function(pageData){
					params.total(pageData.total);
/*					var rows = pageData.data.rows;
					if (rows.length > 0) {
						parentId = rows[0].parentId;
					}*/
		           return pageData.list;
				});
				
			}
		}

		this.getFolderList = function(params, folderfilters) {
			if(folderList){
				var filter=params.filter();
				var search={};
				angular.copy(filter, search);
				search.path = folderfilters.path;
				search.folderName = folderfilters.folderName;
				return folderList.get(search).$promise.then(function(pageData){
					return pageData.data;
				});
			}
		}
	}
})();
