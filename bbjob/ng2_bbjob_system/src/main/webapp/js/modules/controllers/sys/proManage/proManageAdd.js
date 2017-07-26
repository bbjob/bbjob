(function() {
	'use strict';

	angular.module('app.proAdd', []);

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
    .module('app.proAdd')
    .controller('proManageAddCtrl', proManageAddCtrl);

    //自定义状态拦截器
    angular
    .module('app.proAdd').filter("statusfilter",function(){
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
			.module('app.proAdd').filter("isShowFilter",function(){
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
			.module('app.proAdd').filter("columnTypeFilter",function(){
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

	angular.module('app.proAdd').controller('chooseModelCtrl', chooseModelCtrl).directive('onFinishRenderFilters', function ($timeout) {
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

	function chooseModelCtrl() {
	}

    proManageAddCtrl.$inject = ['$rootScope','$scope', '$http','$state','toaster','SweetAlert', 'NgTableParams','ngDialog','$stateParams', 'proManageAddService'];

    
	function proManageAddCtrl($rootScope,$scope, $http,$state,toaster,SweetAlert,ngTableParams,ngDialog,$stateParams,proManageAddService) {
		$scope.timeSEL = [{'id': 0, 'title': 'YYYY/MM/DD'}, {'id': 1, 'title': 'YYYY:MM:DD HH:mm:ss'}];
		$scope.sortSEL = [{'id': 0, 'title': '时间倒序'}, {'id': 1, 'title': '时间顺序'},{'id': 2, 'title': '浏览量倒序'}, {'id': 3, 'title': '浏览量顺序'}];
		$scope.isShowSEL = [{'id':0,'title':'否'},{'id':1,'title':'是'}];
		$scope.editinfo = $stateParams.editinfo;

		$scope.savetype = $stateParams.savetype; //存储类型 区分 0保存
		$scope.selected = $stateParams.editinfo.selected;
		$scope.artTypeSelected = $stateParams.artTypeSelected;
		$scope.contentSelected = $stateParams.contentSelected;
		$scope.editModelAttr = $stateParams.editModelAttr;
		$scope.iseditFlag=true; //编辑默认true 标示只读
		$scope.channelId = $scope.editinfo.channelId;
		channelId = $scope.editinfo.id || "";

		var self = this; //把controller 定义为变量self
		getMemberGroup();

		self.folderTableParams = new ngTableParams({},{
			total: 0,           // length of data
			counts: [], // hide page counts control
			getData: function (params) {
				var result = proManageAddService.getFolderList(params, $scope.folderfilters);
				return result;
			}
		})

		$scope.addsave = function () {
			var changeinfo = $scope.editinfo;
			changeinfo['channelId'] = $scope.channelId;
			changeinfo['parentId'] = $scope.editinfo.parentId;
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

		$scope.isChecked = function(id) {
			return $scope.selected.indexOf(id) >= 0 ;
		}

		$scope.updateSelection = function($event, id){
			var checkbox = $event.target;
			var action = (checkbox.checked ? 'add' : 'remove');
			updateSelected(action,id,checkbox.name);
		}

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

		$scope.isArtTypeChecked = function(id) {
			return $scope.artTypeSelected.indexOf(id) >= 0;
		};

		$scope.updateArtTypeSelection = function($event, id) {
			var checkbox = $event.target;
			var action = (checkbox.checked ? 'add' : 'remove');
			updateArtTypeSelected(action,id,checkbox.name);
		};

		function updateArtTypeSelected(action,id,name) {
			if(action == 'add' && $scope.artTypeSelected.indexOf(id) == -1){
				$scope.artTypeSelected.push(id);
			}
			if(action == 'remove' && $scope.artTypeSelected.indexOf(id) != -1){
				var idx = $scope.artTypeSelected.indexOf(id);
				$scope.artTypeSelected.splice(idx,1);
			}
		}

		$scope.isContentChecked = function(id) {
			return $scope.contentSelected.indexOf(id) >= 0;
		};

		$scope.updateContentSelection = function($event, id) {
			var checkbox = $event.target;
			var action = (checkbox.checked ? 'add' : 'remove');
			updateContentSelected(action,id,checkbox.name);
		};

		function updateContentSelected(action,id,name) {
			if(action == 'add' && $scope.contentSelected.indexOf(id) == -1){
				$scope.contentSelected.push(id);
			}
			if(action == 'remove' && $scope.contentSelected.indexOf(id) != -1){
				var idx = $scope.contentSelected.indexOf(id);
				$scope.contentSelected.splice(idx,1);
			}
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
					template: '<div ng-include="\'views/operative/proManage/chooseModel.html\'"></div>',
					plain: true,
					width: '70%',
					scope:$scope,
					controller: "chooseModelCtrl"
				})
			}
		};

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
				template: '<div ng-include="\'views/operative/proManage/itemChoose.html\'"></div>',
				plain: true,
				width: '70%',
				scope:$scope
			});

		};

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

		};

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

			$state.go('app.folderList', {editinfo: $scope.editinfo, savetype: $scope.savetype, editModelAttr: $scope.editModelAttr, artTypeSelected: $scope.artTypeSelected, contentSelected: $scope.contentSelected});

/*			ngDialog.open({
				className: 'ngdialog-theme-default',
				showClose: true,
				template: '<div ng-include="\'jsp/views/operative/proManage/folder-list.html\'"></div>',
				plain: true,
				width: '70%',
				scope:$scope
			});*/
		};

		$scope.backPage = function () {

			$state.go('app.proManage',{parentId: $scope.editinfo.parentId});
		};

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

		//封装postBody
		function POSTBodyMethod(url,params,successmessage,errormessage){
			$http({
				method  : 'POST',
				url     : url,
				data    : params
			}).success(function(data, status, headers, config) {
				if(status==200){
					$scope.groups = [];
					$scope.editModelAttr = {};
					toaster.pop('success', "提示", successmessage);
					$state.go('app.proManage',{parentId: $scope.editinfo.parentId});
				}else{
					toaster.pop('error', "提示",errormessage);
				}
			}).error(function(data, status, headers, config){
				toaster.pop('error', "提示", "服务器繁忙！");
			});
		}

	}

	angular
			.module('app.proAdd')
			.service('proManageAddService', proManageAddService);
	proManageAddService.$inject = [ '$rootScope','$resource'];
	function proManageAddService($rootScope,$resource){
		var url1 = $rootScope.server.basePath + "modelFolderController/getModelFolderList.json"

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
