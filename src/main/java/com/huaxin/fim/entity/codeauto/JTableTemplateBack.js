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
        	$scope.{flclsname}Service.add(function(result){
    			layer.msg("保存成功!",{icon:1});
    			$("#my{flclsname}Modal").modal("hide");
    			$scope.find($scope.queryEntity);
    		},entity);
        //修改
        } else {
        	$scope.{flclsname}Service.update(function (result) {
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
    		$scope.{flclsname}Service.delete(entity.id);
            layer.close(count);
            $scope.find($scope.queryEntity);
            $scope.$apply();
        });
    };
    
    // JTable后台分页
	// 查询
    $scope.find = function(){
    	var table = $('#{flclsname}_dynamic-table').DataTable();
        table.draw();
        $("#{flclsname}_SelectAll").prop('checked', false);
    }
    
    $scope.{flclsname}Query = function ( opts ) {
        return function ( request, drawCallback, settings ) {        	
            var ajax          = false;
            var requestStart  = request.start;
            var drawStart     = request.start;
            var requestLength = request.length;
            var requestEnd    = requestStart + requestLength;
            var page = drawStart/requestLength + 1;
            // 获取settings中默认排序内容
            var orderBy = settings.aaSorting[0][0];
            var orderT = settings.aaSorting[0][1];
            $scope.orderType = getOrderType(orderBy);
            if(orderT == "asc"){
                $scope.orderWay = 1;
            }else{
                $scope.orderWay = 2;
            }
                request.start = requestStart;
                var requestParams = {
                    "pageNo":page,
                    "pageSize":requestLength
                }
                // 后台分页
                $scope.{flclsname}Service.backPage{clsname}($scope.queryEntity, requestParams, $scope.orderType, $scope.orderWay, function(result){
                    var con = result.content;
                    $scope.result = con;
                    var tempArray = new Array();
                    for(var i = 0; i<con.length;i++){
                    	var box = "<input type='checkbox' id ='"+con[i].id+"'name='{flclsname}_checkData' ng-click='checkData()'>";
                    	operate = "<a href='javascript:void(0)' id='"+i+"&1'>修改</a>"+"  "+" <a href='javascript:void(0)' id='"+i+"&2'>删除</a>";
                        var tempArr = [box,(i+1),{jTableCode},operate
                        ];
                        tempArray.push(tempArr);
                    }
                    var json = {
                        "draw":request.draw,
                        "recordsTotal":result.totalRecord,
                        "recordsFiltered":result.totalRecord,
                        "data":tempArray,
                        "column":[con.length-1] // 操作列在哪一列就写几（从0开始数） 
                    }
                    drawCallback( json );
                    $('#{flclsname}_dynamic-table tbody').find('a').click(function(id){
        				var index = $(this).attr("id").split("&")[0];
                    	var operStatus = $(this).attr("id").split("&")[1]+"";
                    	var content = $scope.result;
                    	if(operStatus == 1){// 修改
                    		 $scope.initUpdateParam(content[index],index);
                    	}else{// 删除
                    		$scope.remove(content[index],index);
                    	}
        		    });
                });
        }
    };

	
  //初始化
    $(document).ready(function() {
    	//会话列表初始化
    	var table = $('#{flclsname}_dynamic-table').DataTable( {
        	columns :[
        	        { title: "<input type='checkbox' id='{flclsname}_SelectAll' style='width:13px;height:13px;' />"},
        	        { title: "序号" },
        	        {jTableFields},
      				{ title: "操作" }
      		],
            "processing": true,
            "bFilter": false,
            "aaSorting" : [[1, "asc"]], // 默认的排序方式，按日期降序
            "aoColumnDefs": [
                { "bSortable": false, "aTargets": [] },
                {
                    "aTargets": [1],
                    "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                        
                    }
                }                
            ],
            "ajax": $scope.{flclsname}Query({}),
            "dom": 'rt<"bottom"ipl>'
    } );
    //  全选反选
        $('#{flclsname}_SelectAll').on('click', function (e) {
        	if($("#{flclsname}_SelectAll").is(':checked')){
     		   $("#{flclsname}_dynamic-table input[name='{flclsname}_checkData']").each( function() {
     			   $(this).prop('checked', true);
     			  }); 
     	   }else{
     		   $("#{flclsname}_dynamic-table input[name='{flclsname}_checkData']").each( function() {
     			   $(this).prop('checked', false);
     		   });
     	   }
         });
    });
    
    // orderType
    function getOrderType(orderByParam){
    	return orderByParam;
    }
    
    // 导出报表
	$scope.exportExcel = function() {
		export{clsname}($scope.queryEntity);
	}
    //其他
{otherjss}
    
});