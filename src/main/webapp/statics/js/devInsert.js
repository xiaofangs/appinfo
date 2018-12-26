function checkedAPKNames(){
	var APKNames=$("#APKName").val();
	$.ajax({
		url:"/AppInfo/dev/appinfo/checkedAPKName",
		type:"post",
		dataType:"json",
		data:{
			APKName:APKNames
		},
		success:function(date){
			if(APKNames==null||APKNames==''){
				alert("该APKName不能为空");
			}else if(date==false){
				alert("改APKName已存在，不可使用");
			}
		},
		error:function(date){
			alert("错误请求")
		}
	});
	
}

$(function(){
	var flatform=$("#flatformIds");
	var categoryLevel1=$("#categoryLevel1");
	$.ajax({
		url:"/AppInfo/dev/dataDictionary/datadictionarylist",
		type:"post",
		dataType:"json",
		data:{
			typeCode:"APP_FLATFORM"
		},
		success:function(date){
			flatform.html("");
			var $option="<option value=''>--请选择--</option>";
			for ( var int = 0; int < date.length; int++) {
				$option+="<option value='"+date[int].valueId+"'>"+date[int].valueName+"</option>"
			}
			flatform.html($option);
		}
	});
	$.ajax({
		url:"/AppInfo/dev/category/appinfoCatagory",
		type:"post",
		dataType:"json",
		success:function(date){
			categoryLevel1.html("");
			var $option="<option value=''>--请选择--</option>";
			for ( var int = 0; int < date.length; int++) {
				$option+="<option value='"+date[int].id+"'>"+date[int].categoryName+"</option>"
			}
			categoryLevel1.html($option);
		}
	});
	
	
})

function onChange(i){
	var categoryLevel=$("#categoryLevel"+i)
	var categoryLevels=$("#categoryLevel"+(i-1)).val();
	$.ajax({
		url:"/AppInfo/dev/category/appinfoCatagory",
		type:"post",
		data:{
			parentId:categoryLevels
		},
		dataType:"json",
		success:function(date){
			var $option="<option value=''>--请选择--</option>";
			for ( var int = 0; int < date.length; int++) {
				$option+="<option value='"+date[int].id+"'>"+date[int].categoryName+"</option>"
			}
			categoryLevel.html($option);
		}
	});
}