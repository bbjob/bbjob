(function() {
	'use strict';

	angular.module('app.user', []);
	
})();


(function() {
	'use strict';

	angular.module('app.user')
	.controller('routesManagementCtrl',routesManagementCtrl);
	
	routesManagementCtrl.$inject = ['$rootScope', '$scope', '$state', '$stateParams', '$timeout',
							'toaster', 'SweetAlert', 'ngDialog', 'routesManagementService', 'NgTableParams', '$http'];

	function routesManagementCtrl($rootScope, $scope, $state, $stateParams, $timeout,
						toaster, SweetAlert, ngDialog, routesManagementService, ngTableParams, $http) {
		var self = this;// 把controller 定义为变量self
		$scope.ids = [];
		$scope.isEdit = false;
		
		$scope.functionNames = {};// 系统菜单
		
		// 查询表单数据
		$scope.selffilters = {
				functionId : '',
				stateName : '',
				stateTitle : '',
				stateUrl : '',
				controllerName : '',
				controllerNameAs : '',
				templateurl : '',
				resolve : ''
		};
		// 查询表单model
		$scope.search = function() {
			self.tableParams.reload();
		};

		$scope.resetSearchBar = function() {
			$scope.selffilters = {
					functionId : '',
					stateName : '',
					stateTitle : '',
					stateUrl : '',
					controllerName : '',
					controllerNameAs : '',
					templateurl : '',
					resolve : ''
			};
		};
		
		self.tableParams = new ngTableParams({
			page : 1, // show first page
			count : 10, // count per page
			filter : {}
		}, {
			total : 0, // length of data
			counts : [ 10, 20, 50, 100 ], // hide page counts control
			getData : function(params) {
				//多选step1
				$scope.ids = [];
				var result = routesManagementService.getLists(params,
						$scope.selffilters);
				return result;
			}
		});
		
		$scope.openDialog = function(type){
			if (type == 1) {
				$scope.isEdit = true;
				if ($scope.ids.length == 1) {
					for (var index in self.tableParams.data) {
						if (self.tableParams.data[index].functionId == $scope.ids[0]) {
							$scope.selffilters = self.tableParams.data[index];
						}
					}
				} else {
					toaster.pop('error', '请选择一条数据');
					return;
				}
			} else {
				$scope.isEdit = false;
				$scope.selffilters = {
						functionId : '',
						stateName : '',
						stateTitle : '',
						stateUrl : '',
						controllerName : '',
						controllerNameAs : '',
						templateurl : '',
						resolve : ''
				};
			}
			ngDialog
			.open({
				width : '55%',
				className : 'ngdialog-theme-default',
				template : '<div ng-include="\'views/operative/sys/user/sysRoutesManagement_add.html\'"> </div>',
				plain : true,
				scope : $scope,
				preCloseCallback : function() {
					$scope.selffilters = {
							functionId : '',
							stateName : '',
							stateTitle : '',
							stateUrl : '',
							controllerName : '',
							controllerNameAs : '',
							templateurl : '',
							resolve : ''
					};
					self.tableParams.reload();
				}
			});
		}
		
		$scope.save = function(){
			if (!$scope.isEdit) {
				$scope.add();
				return;
			}
			$scope.edit();
		}
		
		$scope.add = function(){
			var url = 'sys/addRoutes.json';
			$scope.httpMethod("POST", url, $scope.selffilters, $scope.onSuccess, $scope.onError);
		}
		
		$scope.edit = function(){
			var url = 'sys/editRoutes.json';
			$scope.httpMethod("POST", url, $scope.selffilters, $scope.onSuccess, $scope.onError);
		}
		
		$scope.del = function(){
			if ($scope.ids.length == 0) {
				toaster.pop('error', '请至少选择一条数据');
				return;
			}
			var url = 'sys/delRoutes.json';
			var data = {
					ids : $scope.ids
			}
			$scope.httpMethod("POST", url, data, $scope.onSuccess, $scope.onError);
		}
		
		$scope.delOnSuccess = function(data, status, headers, config){
			if (data == '') {
				toaster.pop('success', "操作成功");
				return;
			}
			toaster.pop('error', data);
		}
		
		
		//get和post请求
		$scope.httpMethod = function(methodType, newUrl, data, onReady, onError) {
			$http({
				method : methodType,
				url : newUrl,
				data : data
			}).success(onReady).error(onError);
		};

		$scope.onSuccess = function(data, status, headers, config){
			if (data == '') {
				ngDialog.close();
				self.tableParams.reload();
				toaster.pop('success', "操作成功");
				return;
			}
			toaster.pop('error', data);
		}
		
		$scope.onError = function(data, status, headers, config){
			toaster.pop('error', "获取数据失败");
		}
		
		//table 单击行
		$scope.clickRow = function(row) {
			if (row.$selected == true) {
				$scope.ids.push(row.functionId);
			} else {
				for ( var index in $scope.ids) {
					if ($scope.ids[index] === row.functionId) {
						// 删除
						$scope.ids.splice(index, 1);
						return;
					}
				}
			}
		}
		
		//关闭dialog
		$scope.close = function(){
			ngDialog.close();
		}	
		
		$scope.getFunctionNames = function(){
			var url = 'sys/functionNames.json';
			$scope.httpMethod("GET", url, null, $scope.getFunctionNamesOnSuccess, $scope.onError);
		}
		
		$scope.getFunctionNamesOnSuccess = function(data, status, headers, config){
			$scope.functionNames = data;
		}
		
		$scope.active = function(){
			$scope.getFunctionNames();
		}
		
		$scope.active();
	}
	
	angular.module('custom')
	.service('routesManagementService', routesManagementService);
	routesManagementService.$inject = ['$rootScope', '$resource'];
	function routesManagementService($rootScope, $resource) {
		var lists = $resource($rootScope.server.basePath + "sys/routes.json");
		this.getLists = function(params, selffilters) {
			if (lists) {
				var filter = params.filter();
				var search = {};
				angular.copy(filter, search);
				angular.copy(selffilters, search);
				search.page = params.page();
				search.size = params.count();
				return lists.get(search).$promise.then(function(pageData) {
					params.total(pageData.total);
					return pageData.list;
				});
			}
		}
	}
})();
