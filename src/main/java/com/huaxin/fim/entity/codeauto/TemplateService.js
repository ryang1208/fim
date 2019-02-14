Namespace.register("com.quantdo.{projectName}.service");
com.quantdo.{projectName}.service.{clsname}Service = function() {
//新增
this.add = function (callback, entity) {
	framework.service.request('{flclsname}Service', 'add', entity, function(errCode,
			errMsg, result) {
		if (errCode > 0) {
			console.error(errCode + ': ' + errMsg + '\n'
					+ JSON.stringify(result));
		}
		if (callback !== undefined || callback != null) {
			callback(result);
		}
	});
}
// 修改
this.update = function (callback, entity) {
	framework.service.request('{flclsname}Service', 'update', entity, function(errCode,
			errMsg, result) {
		if (errCode > 0) {
			console.error(errCode + ': ' + errMsg + '\n'
					+ JSON.stringify(result));
		}
		if (callback !== undefined || callback != null) {
			callback(result);
		}
	});
}
// 根据ID删除
this.delete = function(id) {
	framework.service.request('{flclsname}Service', 'delete', id, function(errCode,
			errMsg, result) {
		if (errCode > 0) {
			console.error(errCode + ': ' + errMsg + '\n' + JSON.stringify(result));
		}
	});
}
//条件查询
this.findByCondition = function(callback{vcondition}) {
	framework.service.request('{flclsname}Service', 'findByCondition'{vcondition}, function(
			errCode, errMsg, result) {
		if (errCode > 0) {
			alert(errCode + ': ' + errMsg + '\n' + JSON.stringify(result));
		}
		if (callback !== undefined || callback != null) {
			callback(result);
		}
	});
}
//查询所有
this.getAll = function(callback) {
	framework.service.request('{flclsname}Service', 'findAll', function(errCode, errMsg,
			result) {
		if (errCode > 0) {
			alert(errCode + ': ' + errMsg + '\n' + JSON.stringify(result));
		}
		if (callback !== undefined || callback != null) {
			callback(result);
		}
	});
}
// jtable后台分页方法
this.backPage{clsname} = function(entity, requestParams, orderType, orderway, callback){
	 framework.service.request('{flclsname}Service', 'backPaging{clsname}', entity, requestParams, orderType, orderway, function (errCode, errMsg, result) {	        
	    	if (errCode != 0) {            
	            layer.msg(errCode + ': ' + errMsg + '\n' + JSON.stringify(result),{icon: 2});
	    	}else if (callback !== undefined || callback != null) {
	            callback(result);
	        }
	    });	
}
// 导出
this.export{clsname} = function(entity){
	framework.file.export("{clsname}.xlsx",'excel',{
		entityKey:[{entityKey}],
		headerKey:[{headerKey}],
		styles:[{styles}],
		title:"{clsname}",
		dicMap:{},// 转换状态
		extendParams:{a:'1'}
	},"{flclsname}Service","backPaging{clsname}Export",entity,null);
}
//其他
{otherjsservices}
}