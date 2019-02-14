myapp.controller('{clsname}Controller', function ($scope, $timeout) {
	$scope.{flclsname}Service = new com.quantdo.{projectName}.service.{clsname}Service();

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
    
    //  全选反选
    $('#{flclsname}_SelectAll').on('click', function (e) {
    	if($("#{flclsname}_SelectAll").is(':checked')){
 		   $("#{flclsname}_dynamic-table input[name='traderList_checkData']").each( function() {
 			   $(this).prop('checked', true);
 			  }); 
 	   }else{
 		   $("#{flclsname}_dynamic-table input[name='traderList_checkData']").each( function() {
 			   $(this).prop('checked', false);
 		   });
 	   }
     });
    
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
    //4.2、初始化新增页面的参数
    $scope.initAddParam = function () {
        $scope.modalEntity = {};
        formValidateReset();
    };
    
    //4.3、初始化修改页面的参数
    $scope.initUpdateParam = function (entity,index) {
    	$("#my{flclsname}Modal").modal("show");
         $scope.tempEntity = angular.copy(entity);
         $scope.tempEntity.recordIndex = index;
         $scope.modalEntity = angular.copy($scope.tempEntity);
         formValidateReset();
         $scope.$apply();
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
        		layer.msg("保存成功!",{icon:1});
    			$("#my{flclsname}Modal").modal("hide");
    			$scope.find($scope.queryEntity);  
        		$scope.$apply();
        	},entity);
        }
        //关闭窗口
        $("#my{flclsname}Modal").modal("hide");
    };
    
    //4.5、删除
    $scope.remove = function (entity,index) {
    	layer.confirm('确定要删除此数据吗？', {icon: 3}, function (count) {
    		delete{clsname}(entity.id);
            layer.close(count);
            $scope.find($scope.queryEntity);
            $scope.$apply();
        });
    };
    
    $scope.{flclsname}Service.findByCondition(function(result){
    	$scope.dataset = new Array();
    	var con = result;
    	$scope.result = con;
    	for(var i=0;i<con.length;i++){
    		operate = "<a href='javascript:void(0)' id='"+i+"&1'>修改</a>"+"  "+" <a href='javascript:void(0)' id='"+i+"&2'>删除</a>";
			var dataArr = [{jTableCode},operate
			];
			$scope.dataset.push(dataArr);
    	}
			$scope.getTable();
			$('#{flclsname}_dynamic-table tbody').find('a').click(function(id){
				var index = $(this).attr("id").split("&")[0];
            	var operStatus = $(this).attr("id").split("&")[1]+"";
            	var content = $scope.result;
            	if(operStatus == 1){
            		 $scope.initUpdateParam(content[index],index);
            	}else{
            		$scope.remove(content[index],index);
            	}
		    });
    }{jspcondition});
    
   
    
    $scope.find = function(){
		$scope.dataset = new Array();
		$scope.{flclsname}Service.findByCondition(function(result){
			var con = result;
			$scope.result = con;
			for(var i=0;i<con.length;i++){
				operate = "<a href='javascript:void(0)' id='"+i+"&1'>修改</a>"+"  "+" <a href='javascript:void(0)' id='"+i+"&2'>删除</a>";
				var dataArr = [{jTableCode},operate
				];
				$scope.dataset.push(dataArr);
			}
			$scope.destroyTable();
			$scope.getTable();
			$('#{flclsname}_dynamic-table tbody').find('a').click(function(id){
				var index = $(this).attr("id").split("&")[0];
            	var operStatus = $(this).attr("id").split("&")[1]+"";
            	var content = $scope.result;
            	if(operStatus == 1){
            		 $scope.initUpdateParam(content[index],index);
            	}else{
            		$scope.remove(content[index],index);
            	}
		    });
		}{jspcondition});
	}
    
    $scope.destroyTable = function(){
    	var table = $('#{flclsname}_dynamic-table').DataTable();
    	table.destroy();
    }
    
    $scope.getTable = function(){
    	var table = $("#{flclsname}_dynamic-table").DataTable({
    		data : $scope.dataset,
    		columns :[
{jTableFields},
{ title: "操作" }  		          
    		],
    		scrollY: "380px",
    		scrollCollapse : true,
    		scrollX: true,
    	});
    };
    
    //其他
{otherjss}
    
    //5.1、进入页面时调用查询方法
//    $scope.find($scope.queryEntity);
});