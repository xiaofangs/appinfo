function deletefiles(ids){
	  $.ajax({
		  url:"/AppInfo/dev/appversion/deleteFiles",
		  type:"post",
		  dataType:"json",
		  data:{
			  id:ids
		  },
	     success:function(date){
	    	 if(date.result=="fail"){
	    		 alert("删除文件失败");
	    	 }else{
	    		 location.href="/AppInfo/dev/appversion/toUpdate?appId="+date.result;
	    	 }
	    	 
	     },
	     error:function(data){
	    	 alert("删除文件失败");
	     }
	  });
}