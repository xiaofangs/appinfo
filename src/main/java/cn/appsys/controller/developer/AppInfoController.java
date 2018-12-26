package cn.appsys.controller.developer;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cn.appsys.service.developer.AppCategoryService;
import cn.appsys.service.developer.AppVersionService;
import cn.appsys.service.developer.DataDictionaryService;

import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;


import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.AppInfoService;
import cn.appsys.util.Page;

@Controller
@RequestMapping("/dev/appinfo")
public class AppInfoController {
	@Resource
	private AppInfoService appInfoService;
	@Resource
	private DataDictionaryService dataDictionaryService;
	@Resource
	private AppCategoryService appCategoryService;
	@Resource
	private AppVersionService appVersionService;
	
	@RequestMapping("/appinfolist")
	public String AppInfoList(@RequestParam(value="softwareName",required=false)String softwareName,
			@RequestParam(value="status",required=false)Integer status,
			@RequestParam(value="flatformId",required=false)Integer flatformId,
			@RequestParam(value="categoryLevel1",required=false)Integer categoryLevel1,
			@RequestParam(value="categoryLevel2",required=false)Integer categoryLevel2,
			@RequestParam(value="categoryLevel3",required=false)Integer categoryLevel3,
			@RequestParam(value="pageCurr",required=false)Integer pageCurr,
			HttpServletRequest request){
		   if(pageCurr==null){
			   pageCurr=1;
		   }
		    List<DataDictionary> dataStatus=this.SelectByTypecode("APP_STATUS");
		    List<DataDictionary> dataFlatform=this.SelectByTypecode("APP_FLATFORM");
		    List<AppCategory> category1=appCategoryService.SelectByParentId(null);
		    List<AppCategory> category2=null;
		    if(categoryLevel1!=null){
		    	category2=appCategoryService.SelectByParentId(categoryLevel1);
		    }
		    List<AppCategory> category3=null;
		    if(categoryLevel2!=null){
		    category3=appCategoryService.SelectByParentId(categoryLevel2);
		    }
		    Page<AppInfo> page=appInfoService.SelectByAll(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3, pageCurr, 5);
		    request.setAttribute("page",page);
		    request.setAttribute("dataStatus",dataStatus);
		    request.setAttribute("dataFlatform",dataFlatform);
		    request.setAttribute("category1",category1);
		    request.setAttribute("category2",category2);
		    request.setAttribute("category3",category3);
		    request.setAttribute("categoryLevel1",categoryLevel1);
		    request.setAttribute("categoryLevel2",categoryLevel2);
		    request.setAttribute("categoryLevel3",categoryLevel3);
		    request.setAttribute("softwareName",softwareName);
		    request.setAttribute("status",status);
		    request.setAttribute("flatformId",flatformId);
		    return "/developer/showMeun";
	}
	
	public List<DataDictionary> SelectByTypecode(String typecode){
		return dataDictionaryService.SelectByTypecode(typecode);
	}

	@RequestMapping(value="/appinfoCatagory")
	@ResponseBody
	public Object SelectByCategory(Integer parentId){
		 List<AppCategory> category=appCategoryService.SelectByParentId(parentId);
		 return category;
	}
	@RequestMapping("/appinfotoInsert")
	public String AppInfoToInsert(HttpServletRequest request){
		return "/developer/devInsert";
	}
	
	@RequestMapping("/checkedAPKName")
	@ResponseBody
	public Object CheckedAPKName(String APKName){
		boolean result=true;
		Integer juge=appInfoService.CheckedAPKName(APKName);
		if(juge>0){
			result=false;
		}
		return result;
	}
	
	@RequestMapping("/appinfoInsert")
	public String appinfoInsert(AppInfo appinfo,@RequestParam(value="uploadfiles",required=false)MultipartFile uploadfiles
			,HttpServletRequest request,HttpSession session){
		try {
		String path=request.getSession().getServletContext().getRealPath("statics/uploadfiles/");
		if(!uploadfiles.isEmpty()){
			String fileName=uploadfiles.getOriginalFilename();
			String suffix=FilenameUtils.getExtension(fileName);
			Integer fileSize=500000;
			if(uploadfiles.getSize()>fileSize){
				request.setAttribute("error","文件大小必须小于50KB");
				return "/developer/devInsert";
			}else if(!suffix.equalsIgnoreCase("jpg")&&!suffix.equalsIgnoreCase("jpeg")&&!suffix.equalsIgnoreCase("png")){
				request.setAttribute("error","文件类型必须为jpg或者jpen或者png");
				return "/developer/devInsert";
			}else{
				String filesName=appinfo.getAPKName()+"."+suffix;
				File target=new File(path,filesName);
				if(!target.exists()){
						target.mkdirs();
				}
				uploadfiles.transferTo(target);
				String logoPicPath=request.getContextPath()+"/statics/uploadfiles/"+filesName;
				String logoLocPath=path+File.separator+filesName;
				appinfo.setLogoLocPath(logoLocPath);
				appinfo.setLogoPicPath(logoPicPath);
				Date date=new Date();
				DevUser user=(DevUser)session.getAttribute("devUser");
				appinfo.setCreatedBy(user.getId());
				appinfo.setCreationDate(date);
				appinfo.setDevId(user.getId());
			}
			
		}
		appInfoService.AppInfoAdd(appinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/dev/appinfo/appinfolist";
		
	}
	
	@RequestMapping("/appinfoToUpdate")
	public String appinfoToUpdate(Integer appinfoid,HttpServletRequest request){
		AppInfo appinfo=appInfoService.SelectById(appinfoid);
		List<AppCategory> list=appCategoryService.SelectByParentId(null);
	    List<DataDictionary> dataFlatform=this.SelectByTypecode("APP_FLATFORM");
	    List<AppCategory> list2=appCategoryService.SelectByParentId(appinfo.getCategoryLevel1());
	    List<AppCategory> list3=appCategoryService.SelectByParentId(appinfo.getCategoryLevel2());
	    request.setAttribute("appinfo",appinfo);
		request.setAttribute("appcategory",list);
		request.setAttribute("appcategory2",list2);
		request.setAttribute("appcategory3",list3);
		request.setAttribute("dataFlatform",dataFlatform);
		return "/developer/devUpdate";
	}
	
	@RequestMapping("/appinfoUpdate")
	public String appinfoUpdate(@RequestParam(value="appinfojude",required=false)Integer appinfojude,AppInfo appinfo,HttpSession session,
			@RequestParam(value="uploadfiles",required=false)MultipartFile upload,
			HttpServletRequest request){
		AppInfo appinf=appInfoService.SelectById(appinfo.getId());
		try {
		String path=request.getSession().getServletContext().getRealPath("statics/uploadfiles/");
		if(!upload.isEmpty()){
			String fileName=upload.getOriginalFilename();
			String suffix=FilenameUtils.getExtension(fileName);
			Integer fileSize=50000000;
			if(upload.getSize()>fileSize){
				request.setAttribute("error","文件大小必须小于50KB");
				return "/developer/devUpdate";
			}else if(!suffix.equalsIgnoreCase("jpg")&&!suffix.equalsIgnoreCase("jpeg")&&!suffix.equalsIgnoreCase("png")){
				request.setAttribute("error","文件类型必须为jpg或者jpen或者png");
				return "/developer/devUpdate";
			}else{
				String filesName=appinfo.getAPKName()+"."+suffix;
				File target=new File(path,filesName);
				if(!target.exists()){
						target.mkdirs();
				}
				upload.transferTo(target);
				String logoPicPath=request.getContextPath()+"/statics/uploadfiles/"+filesName;
				String logoLocPath=path+File.separator+filesName;
				appinfo.setLogoLocPath(logoLocPath);
				appinfo.setLogoPicPath(logoPicPath);
			}
		}
		DevUser user=(DevUser)session.getAttribute("devUser");
		appinfo.setUpdateDate(new Date());
		appinfo.setModifyBy(user.getId());
		appinfo.setModifyDate(new Date());
		appinfo.setCreatedBy(appinf.getCreatedBy());
		appinfo.setCreationDate(appinf.getCreationDate());
		appinfo.setDevId(appinf.getDevId());
		if(appinfojude==0){
			appInfoService.UpdateAppInfo(appinfo);
		}else{
			appinfo.setStatus(1);
			appInfoService.UpdateAppInfo(appinfo);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/dev/appinfo/appinfolist";
	}
	@RequestMapping("/changePic")
	@ResponseBody
	public Object changePic(Integer appinfo){
		AppInfo appinfos=appInfoService.SelectById(appinfo);
		Map<String,String> map=new HashMap<String,String>();
		File file=new File(appinfos.getLogoLocPath());
		if(file.exists()){
			if(!file.delete()){
				map.put("result", "error");
			}
		}
	    Integer result=appInfoService.DeletePic(appinfo);
	    if(result>0){
	    	map.put("result","successes");
	    }else{
	    	map.put("result", "error");
	    }
		return map;
	}
	
	@RequestMapping("/viewAppInfo")
	public String ViewAppInfo(Integer appinfoid,HttpServletRequest request){
		AppInfo appinfo=appInfoService.VeiwAppInfo(appinfoid);
		List<AppVersion> appversion = appVersionService.SelectByAppId(appinfoid);
		request.setAttribute("appversion", appversion);
		request.setAttribute("appinfo",appinfo);
		return "/developer/devView";
	}
	
	@RequestMapping("/AppinfoDelete")
	@ResponseBody
	public Object AppInfoDelete(Integer appinfoid){
		Map<String,String> map=new HashMap<String,String>();
		List<AppVersion> appversion=appVersionService.SelectByAppId(appinfoid);
		for (AppVersion appVersion2 : appversion) {
			if(appVersion2.getApkLocPath()!=null&&appVersion2.getApkLocPath()!=""){
			  File file=new File(appVersion2.getApkLocPath());
			  if(file.exists()){
				file.delete();
			 }
			}
		}
		appVersionService.DeleteAppVersion(appinfoid);
		AppInfo appinfo=appInfoService.SelectById(appinfoid);
		if(appinfo.getLogoLocPath()!=null&&appinfo.getLogoLocPath()!=""){
			 File file=new File(appinfo.getLogoLocPath());
			  if(file.exists()){
				file.delete();
			 }
		}
		Integer result=appInfoService.deleteAppInfo(appinfoid);
			if(result>0){
				map.put("result", "seccesses");
			}else{
				map.put("result", "fail");
			}
		return map;
	}
	
	@RequestMapping("/{appid}/sale.json")
	@ResponseBody
	public Object DownUp(@PathVariable("appid")Integer appid,HttpSession session){
		Map<String,String> map=new HashMap<String,String>();
		map.put("errorCode", "0");
		try {
		AppInfo appinfo=appInfoService.SelectById(appid);
		AppVersion appversion=appVersionService.SelectById(appinfo.getVersionId());
		switch (appinfo.getStatus()) {
		 case 2:
		 case 5:
			 appinfo.setStatus(4);
			 appinfo.setOnSaleDate(new Date());
			 appversion.setPublishStatus(2);
		 break;
		 case 4:
			 appinfo.setStatus(5);
			 appinfo.setOffSaleDate(new Date());
			 appversion.setPublishStatus(3);
		 break;
		default:
			break;
		} 
		DevUser user=(DevUser)session.getAttribute("devUser");
		appinfo.setUpdateDate(new Date());
		appinfo.setModifyBy(user.getId());
		appinfo.setModifyDate(new Date());
		appVersionService.AppVersionUpdate(appversion);
		Integer result=appInfoService.UpdateAppInfo(appinfo);
		if(result>0){
			map.put("resultMsg", "success");
		}else{
			map.put("resultMsg", "failed");
		}
		} catch (Exception e) {
			map.put("errorCode", "1");
			e.printStackTrace();
		}
		return map;
	}
}

