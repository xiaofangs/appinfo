function changePic(id){
	var changePic=$("#changePic");
	$.ajax({
		url:"/AppInfo/dev/appinfo/changePic",
		type:"post",
		dataType:"json",
		data:{
			appinfo:id
		},
		success:function(date){
			if(date.result=="error"){
//				changePic.html("");
//				var files="<input id='middle-name'"+
//				"class='form-control col-md-7 col-xs-12' type='file'"+
//				"name='uploadfiles'>";
//				changePic  .html(files);
//			}else{
				alert("删除图片失败");
			}
		}
	});
	
}

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
		function valuesChange() {
			$("input[name='appinfojude']").val(1);
		}