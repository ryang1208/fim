myapp.controller('{clsname}Controller', function ($scope, $timeout) {
	
	//1、定义页面数据模型
    $scope.queryEntity = {};
    $scope.tempEntity = {};
    $scope.modalEntity = {};
    //下拉赋值
{setselect}
    //2、重置表单验证信息
    function formValidateReset() {
       //设置验证
{setPristine};
    }
    
    //重置查询条件
    $scope.reset = function(){
    	$scope.queryEntity = {};
    }
    
   //  全选与反选
    $scope.selectAll = function(){
	   if($("#{flclsname}_SelectAll").is(':checked')){
		   $("input[type='checkbox']").each( function() {
		   $(this).prop('checked', true);
		 		  }); 
	   }else{
		   $(":checkbox").prop("checked", false);
	   }
    };
    
    //3、数据初始化
    //3.1、初始化日期控件
	$("[forType='date']").datepicker({
	    language:  'zh-CN',
	    weekStart: 1,	
	    autoclose: true,
	    clearBtn: true,	    
	    todayHighlight: true,
	    format: 'yyyymmdd'
	});
	
    //4、定义方法
    //4.1、查询指令
    $scope.find = function () {
        $scope.isQuery = true;
        findByCondition{clsname}(function(result){
        	$scope.listEntitys = result;
            $scope.$apply();
            $timeout(function() {
                $scope.isQuery = false;
            }, 1000);
        }{jspcondition});
    };
    
    //4.2、初始化新增页面的参数
    $scope.initAddParam = function () {
        $scope.modalEntity = {};
        formValidateReset();
    };
    
    //4.3、初始化修改页面的参数
    $scope.initUpdateParam = function (entity,index) {
         $scope.tempEntity = angular.copy(entity);
         $scope.tempEntity.recordIndex = index;
         $scope.modalEntity = angular.copy($scope.tempEntity);
         formValidateReset();
    };
    
    //4.4、保存
    $scope.save = function (entity) {
        var index = entity.recordIndex;
        //增加
        if (index == undefined) {
        	add{clsname}(function(result){
    			layer.msg("保存成功!",{icon:1});
    			$("#my{flclsname}Modal").modal("hide");
    			$scope.find($scope.queryEntity);
    		},entity);
        //修改
        } else {
        	update{clsname}(function (result) {
        		$scope.listEntitys.splice(index, 1, entity);  
        		$scope.$apply();
        		layer.msg("保存成功!",{icon:1});
    			$("#my{flclsname}Modal").modal("hide");
        	},entity);
        }
        //关闭窗口
        $("#my{flclsname}Modal").modal("hide");
    };
    
    //4.5、删除
    $scope.remove = function (entity,index) {
    	layer.confirm('确定要删除此数据吗？', {icon: 3}, function (count) {
    		delete{clsname}(entity.id);
            $scope.listEntitys.splice(index, 1);
            layer.close(count);
            $scope.$apply();
        });
    };
    
    //其他
{otherjss}
    
    //5.1、进入页面时调用查询方法
    $scope.find($scope.queryEntity);
});
