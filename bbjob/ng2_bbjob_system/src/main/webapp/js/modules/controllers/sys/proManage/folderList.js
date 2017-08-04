(function() {
	'use strict';

	angular.module('app.fold', []);

})();


/****
 * 编辑写稿的list
 * 
 * *****/
(function() {
    'use strict';
	var channelId = "";
	var showTempNo = '';

    angular
    .module('app.fold')
    .controller('folderList', folderList);

	angular.module('app.fold').controller('chooseModelCtrl', chooseModelCtrl).directive('ckeditor', function() {
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
	function chooseModelCtrl() {
	}


    folderList.$inject = ['$rootScope','$scope', '$http','$state','toaster','SweetAlert', 'NgTableParams','ngDialog','$stateParams', 'folderListService'];

    
	function folderList($rootScope,$scope, $http,$state,toaster,SweetAlert,ngTableParams,ngDialog,$stateParams,folderListService) {
		$scope.editinfo = $stateParams.editinfo;
		$scope.savetype = $stateParams.savetype;
		$scope.editModelAttr = $stateParams.editModelAttr;
		$scope.artTypeSelected = $stateParams.artTypeSelected;
		$scope.contentSelected = $stateParams.contentSelected;

		$scope.folderfilters = {path: null, folderName: null, folder: null};
		var self = this; //把controller 定义为变量self

		self.folderTableParams = new ngTableParams({},{
			total: 0,           // length of data
			counts: [], // hide page counts control
			getData: function (params) {
				var result = folderListService.getFolderList(params, $scope.folderfilters);
		return result;
	}
		})


		$scope.folderBack = function () {
			var path = $scope.folderfilters.path;
			var url = 'modelFolderController/getParentPath.json?path=' + path;

			$http.get(url).success(function (data, status, headers, config) {
				if (status === 200) {
					$scope.folderfilters.path = data;
					self.folderTableParams.reload();
				}
			}).error(function () {
				toaster.pop('error', "查询基础信息失败", "请稍后再试");
			});
		};

		// 文件管理 新增文件夹
		$scope.addFolder = function () {
			$scope.saveType = 1;

			$scope.folderAttr = {
				name: ''
			}

			ngDialog.open({
				className: 'ngdialog-theme-default',
				showClose: true,
				template: '<div ng-include="\'views/operative/proManage/addFolder.html\'"></div>',
				plain: true,
				width: '70%',
				scope:$scope
			});

		}

		// 文件管理 新增文件
		$scope.addFile = function () {
			$scope.saveType = 1;

			$scope.fileAttr = {
				path: '',
				name: '',
				title: '',
				description: '',
				foundModal: '',
				foundModalNo: '',
				sampleModelSEL: [],
				TContent: ''
			}
			var url = 'modelFolderController/getSampleModelFolderList.json?';

			$http.get(url).success(function (data, status, headers, config) {
				if (status === 200) {
					var sampleList = data;

					for (var i = 0; i < sampleList.length; i++) {
						$scope.fileAttr.sampleModelSEL.push({'id': sampleList[i].fileName, 'name': sampleList[i].abPath});
					}

					ngDialog.open({
						className: 'ngdialog-theme-default',
						showClose: true,
						template: '<div ng-include="\'views/operative/proManage/addFile.html\'"></div>',
						plain: true,
						width: '70%',
						scope:$scope
					});
				}
			}).error(function () {
				toaster.pop('error', "查询基础信息失败", "请稍后再试");
			});
		};

		$scope.getChildFileList = function (info) {
			console.log(info);

			var path = info.abPath,
					type = info.fileType;

			if ('[文件夹]' !== type) {
				toaster.pop('error', "提示", "");
			} else {
				$scope.folderfilters.path = path;
				self.folderTableParams.reload();
			}
		};

		// 文件下載
		$scope.downLoadFile = function (info) {

			var path = info.abPath,
				fileType = info.fileType,
				fileName = info.fileName;

			window.location.href = "modelFolderController/filedownload.json?path="
					+ path + "&fileType=" + fileType +"&fileName=" + fileName;
		}


		// 文件管理 编辑操作
		$scope.editFolder = function (info) {
			$scope.saveType = 0;

			$scope.originalPath = info.abPath;

			var url = 'modelFolderController/getFileInfoByAbPath.json?path=' + info.abPath;

			$http.get(url).success(function (data, status, headers, config) {
				if (status === 200) {
					console.log(data);
					var fileInfo = data;

					$scope.fileAttr = {
						path: fileInfo.filePath,
						name: fileInfo.fileName,
						title: fileInfo.fileTitle,
						description: fileInfo.fileDesc,
						foundModal: '',
						foundModalNo: '',
						sampleModelSEL: [],
						TContent: fileInfo.conent,
						originalPath: $scope.originalPath
					}

					$scope.folderAttr = {
						name: fileInfo.fileName,
						originalPath: $scope.originalPath
					}

					if (info.fileType === '[文件夹]') {
						ngDialog.open({
							className: 'ngdialog-theme-default',
							showClose: true,
							template: '<div ng-include="\'views/operative/proManage/addFolder.html\'"></div>',
							plain: true,
							width: '70%',
							scope:$scope
						});
					} else {
						ngDialog.open({
							className: 'ngdialog-theme-default',
							showClose: true,
							template: '<div ng-include="\'views/operative/proManage/addFile.html\'"></div>',
							plain: true,
							width: '70%',
							scope:$scope
						});
					}

				}
			}).error(function () {
				toaster.pop('error', "查询基础信息失败", "请稍后再试");
			});


		};

		// 文件管理 删除操作
		$scope.delFolder = function (info) {
			console.log(info)

			SweetAlert.swal({
				title: '您确定要删除该目录或文件?',
				type: 'warning',
				showCancelButton: true,
				confirmButtonColor: '#DD6B55',
				confirmButtonText: '是的',
				cancelButtonText: '取消',
				closeOnConfirm: true,
				closeOnCancel: true
			}, function(isConfirm){
				if (isConfirm) {
					POSTMethodNotCloseD('modelFolderController/delFile.json', info, "删除成功", "删除失败");
				} else {
					// SweetAlert.swal('取消操作', '你取消了操作', 'error');
				}
			});
		};

		$scope.chooseFoundModel = function(filePath) {
			$scope.fileAttr.foundModal = filePath;

			var url = 'modelFolderController/getSampleModelContent.json?path=' + filePath;

			$http.get(url).success(function (data, status, headers, config) {
				if (status === 200) {
					// var sampleList = data.data;
					$scope.fileAttr.TContent = data;
					/*					$('#summernote').summernote('destroy');
					 $('#summernote').summernote("code", $scope.fileAttr.TContent);*/
				}
			}).error(function () {
				toaster.pop('error', "查询基础信息失败", "请稍后再试");
			});

			//	alert(fileName);
		};

		$scope.submitFolderInfo = function () {

			$scope.folderAttr.path = $scope.folderfilters.path;

			if ($scope.saveType === 1) {
				POSTMethodNotCloseD('modelFolderController/addFolder.json', $scope.folderAttr, "创建成功", "创建失败");
			} else {
				POSTMethodNotCloseD('modelFolderController/updateFile.json', $scope.folderAttr, "修改成功", "修改失败");
			}

		}

		$scope.submitFileInfo = function () {
			if ($scope.fileAttr.name === null || $scope.fileAttr.name === '') {
				toaster.pop('error', "提示", "文件名称不能为空");
				return;
			}

			console.log(CKEDITOR.instances.TContent.getData());

			$scope.fileAttr.path = $scope.folderfilters.path;

			$scope.fileAttr.TContent = CKEDITOR.instances.TContent.getData();

			if ($scope.saveType === 1) {
				POSTMethodNotCloseD('modelFolderController/addFile.json', $scope.fileAttr, "创建成功", "创建失败");
			} else {
				POSTMethodNotCloseD('modelFolderController/updateFile.json', $scope.fileAttr, "修改成功", "修改失败");
			}
			/*			var str = $('#summernote').code();

			 console.log(str)*/
		}

		$scope.backPage = function () {

			$state.go('app.proManageAdd',{editinfo: $scope.editinfo, savetype: $scope.savetype, editModelAttr: $scope.editModelAttr, artTypeSelected: $scope.artTypeSelected, contentSelected: $scope.contentSelected});
		}

		//封装post 不关闭Dialog
		function POSTMethodNotCloseD(url,params,successmessage,errormessage){
			$http({
				method  : 'POST',
				url     : url,
				data    : $.param(params),  // pass in data as strings
				headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  // set the headers so angular passing info as form data (not request payload)
			}).success(function(data, status, headers, config) {
				var obj2 = eval(data);
				if(status === 200){
					self.folderTableParams.reload();
					toaster.pop('success', "提示", successmessage);
				}else{
					toaster.pop('error', "提示",errormessage);
				}
			}).error(function(data, status, headers, config){
				toaster.pop('error', "提示", "服务器繁忙！");
			});
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

		// 获取会员组信息
		function getMemberGroup() {
			var url = 'manage/proManage/getMemberGroupList.json';
			$http.get(url).success(function (data, status, headers, config) {
				if (status === 200) {
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

		//封装postBody
		function POSTBodyMethod(url,params,successmessage,errormessage){
			$http({
				method  : 'POST',
				url     : url,
				data    : params
			}).success(function(data, status, headers, config) {
				var obj2 = eval(data);
				if(status === 200){
					$scope.groups = [];
					$scope.editModelAttr = {};
					toaster.pop('success', "提示", successmessage);
				}else{
					toaster.pop('error', "提示",errormessage);
				}
			}).error(function(data, status, headers, config){
				toaster.pop('error', "提示", "服务器繁忙！");
			});
		}

	}

	angular
			.module('app.fold')
			.service('folderListService', folderListService);
	folderListService.$inject = [ '$rootScope','$resource'];
	function folderListService($rootScope,$resource){

		var url1 = $rootScope.server.basePath + "modelFolderController/getModelFolderList.json";

		var folderList = $resource(url1);

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
