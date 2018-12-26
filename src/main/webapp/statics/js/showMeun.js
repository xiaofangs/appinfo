function changeCategory(i){
	var categoryLevel=$("#categoryLevel"+i);
	var parentIds=$("#categoryLevel"+(i-1)).val();
	
	$.ajax({
		url:"/AppInfo/dev/appinfo/appinfoCatagory",
		type:"post",
		data:{
			parentId:parentIds
		},
		success:function(date){
			categoryLevel.html("");
			var $option="<option value=''>--请选择--</option>";
			for ( var int = 0; int < date.length; int++) {
				$option+="<option value=\""+date[int].id+"\">"
				+date[int].categoryName+"</option>";
			}
			categoryLevel.html($option);
		}
		
	})
	
}

$(".updateAppInfo").on("click",function(){
	var obj=$(this);
	var appinfoid=obj.attr("appinfoid");
	var status=obj.attr("status");
	var statusName=obj.attr("statusName");
	if(status==1||status==3){
		location.href="/AppInfo/dev/appinfo/appinfoToUpdate?appinfoid="+appinfoid;
	}else{
		alert("改APP应用状态为【"+statusName+"】,不可以进行修改");
	}
	
})

$(".versionupdate").on("click",function(){
	var obj=$(this);
	var status=obj.attr("status");
	var appinfoid=obj.attr("appinfoid");
	var versionid=obj.attr("versionid");
	var statusName=obj.attr("statusName");
	if(versionid==null){
		alert("改APP应用无版本信息,请先增加版本信息");
	}else if(status==1||status==3){
		location.href="/AppInfo/dev/appversion/toUpdate?appId="+appinfoid;
	}else{
		alert("改APP应用状态为【"+statusName+"】,不可以修改其版本，只可进行新增");
	}
})

$(".deleteAppInfo").on("click",function(){
	var obj=$(this);
	var appinfoid=obj.attr("appinfoid");
	var softwareName=obj.attr("softwareName");
	var jude=confirm("你确定删除APP应用【"+softwareName+"】及其所以版本吗？");
	if(jude==true){
	$.ajax({
		url:"/AppInfo/dev/appinfo/AppinfoDelete",
		type:"post",
		dataType:"json",
		data:{
			appinfoid:appinfoid
		},
		success:function(date){
			if(date.result=="seccesses"){
				alert("删除成功");
				/*location.href="/AppInfo/dev/appinfo/";*/
				location.reload();
			}else{
				alert("删除失败");
			}
		},
		error:function(dates){
			alert("删除失败");
		}
	});
	}
	
})

$(document).on("click",".saleSwichOpen,.saleSwichClose",function(){
	var obj = $(this);
	var appinfoid = obj.attr("appinfoid");
	var saleSwitch = obj.attr("saleSwitch");
	if("open" === saleSwitch){
		saleSwitchAjax(appinfoid,obj);
	}else if("close" === saleSwitch){
		if(confirm("你确定要下架您的APP应用【"+obj.attr("appsoftwarename")+"】吗？")){
			saleSwitchAjax(appinfoid,obj);
		}
	}
});

var saleSwitchAjax = function(appId,obj){
	$.ajax({
		type:"post",
		url:"/AppInfo/dev/appinfo/"+appId+"/sale.json",
		dataType:"json",
		success:function(data){
			/*
			 * resultMsg:success/failed
			 * errorCode:exception000001
			 * appId:appId
			 * errorCode:param000001
			 */
			if(data.errorCode === '0'){
				if(data.resultMsg === "success"){//操作成功
					if("open" === obj.attr("saleSwitch")){
						//alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【上架】操作成功");
						$("#appInfoStatus" + obj.attr("appinfoid")).html("已上架");
						obj.className="saleSwichClose";
						obj.html("下架");
						obj.attr("saleSwitch","close");
						$("#appInfoStatus" + obj.attr("appinfoid")).css({
							'background':'green',
							'color':'#fff',
							'padding':'3px',
							'border-radius':'3px'
						});
						$("#appInfoStatus" + obj.attr("appinfoid")).hide();
						$("#appInfoStatus" + obj.attr("appinfoid")).slideDown(300);
					}else if("close" === obj.attr("saleSwitch")){
						//alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【下架】操作成功");
						$("#appInfoStatus" + obj.attr("appinfoid")).html("已下架");
						obj.className="saleSwichOpem";
						obj.html("上架");
						obj.attr("saleSwitch","open");
						$("#appInfoStatus" + obj.attr("appinfoid")).css({
							'background':'red',
							'color':'#fff',
							'padding':'3px',
							'border-radius':'3px'
						});
						$("#appInfoStatus" + obj.attr("appinfoid")).hide();
						$("#appInfoStatus" + obj.attr("appinfoid")).slideDown(300);
					}
				}else if(data.resultMsg === "failed"){//删除失败
					if("open" === obj.attr("saleSwitch")){
						alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【上架】操作失败");
					}else if("close" === obj.attr("saleSwitch")){
						alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【下架】操作失败");
					}
				}
			}else{
				if(data.errorCode === 'exception000001'){
					alert("对不起，系统出现异常，请联系IT管理员");
				}else if(data.errorCode === 'param000001'){
					alert("对不起，参数出现错误，您可能在进行非法操作");
				}
			}
		},
		error:function(data){
			if("open" === obj.attr("saleSwitch")){
				alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【上架】操作成功");
			}else if("close" === obj.attr("saleSwitch")){
				alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【下架】操作成功");
			}
		}
	});
};
