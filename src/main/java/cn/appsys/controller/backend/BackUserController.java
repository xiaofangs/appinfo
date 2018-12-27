package cn.appsys.controller.backend;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.AppCategoryService;
import cn.appsys.service.developer.AppInfoService;
import cn.appsys.service.developer.AppVersionService;
import cn.appsys.service.developer.BackendUserService;
import cn.appsys.service.developer.DataDictionaryService;
import cn.appsys.service.developer.DevUserService;
import cn.appsys.util.Page;

@Controller
@RequestMapping(value="/back")
public class BackUserController {
	@Resource
	private BackendUserService backendUserService;
	@Resource
	private DataDictionaryService dataDictionaryService;
	@Resource
	private AppCategoryService appCategoryService;
	@Resource
	private AppInfoService appInfoService;
	@Resource
	private AppVersionService appVersionService;
	
	
	@RequestMapping("/login")
	public String DevLogin(){
		return "/backend/backlogin";
	}
	
	@RequestMapping("/toLogin")
	public String DevToLogin(String devCode,String password,HttpSession session){
		BackendUser backendUser=backendUserService.BackUserLogin(devCode, password);
		if(backendUser!=null){
			session.setAttribute("backendUser", backendUser);
		}else{
			return "/backend/backlogin";
		}
		return "redirect:/back/toDevShow";
	}
	
	@RequestMapping("/toDevShow")
	public String toShowList(){
		 return "/backend/backShow";
	}
	
	
	@RequestMapping("/appinfo/backList")
	public String AppInfoList(@RequestParam(value="softwareName",required=false)String softwareName,
			@RequestParam(value="flatformId",required=false)Integer flatformId,
			@RequestParam(value="categoryLevel1",required=false)Integer categoryLevel1,
			@RequestParam(value="categoryLevel2",required=false)Integer categoryLevel2,
			@RequestParam(value="categoryLevel3",required=false)Integer categoryLevel3,
			@RequestParam(value="pageCurr",required=false)Integer pageCurr,
			HttpServletRequest request){
		   if(pageCurr==null){
			   pageCurr=1;
		   }
		    List<DataDictionary> dataFlatform=dataDictionaryService.SelectByTypecode("APP_FLATFORM");
		    List<AppCategory> category1=appCategoryService.SelectByParentId(null);
		    List<AppCategory> category2=null;
		    if(categoryLevel1!=null){
		    	category2=appCategoryService.SelectByParentId(categoryLevel1);
		    }
		    List<AppCategory> category3=null;
		    if(categoryLevel2!=null){
		    category3=appCategoryService.SelectByParentId(categoryLevel2);
		    }
		    Page<AppInfo> page=appInfoService.SelectByAll(softwareName, 1, flatformId, categoryLevel1, categoryLevel2, categoryLevel3, pageCurr, 5);
		    request.setAttribute("page",page);
		    request.setAttribute("dataFlatform",dataFlatform);
		    request.setAttribute("category1",category1);
		    request.setAttribute("category2",category2);
		    request.setAttribute("category3",category3);
		    request.setAttribute("categoryLevel1",categoryLevel1);
		    request.setAttribute("categoryLevel2",categoryLevel2);
		    request.setAttribute("categoryLevel3",categoryLevel3);
		    request.setAttribute("softwareName",softwareName);
		    request.setAttribute("flatformId",flatformId);
		    return "/backend/showMeun";
	}

	
	@RequestMapping("/loginout")
	public String LoginOut(HttpSession session){
		session.removeAttribute("backendUser");
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/AppShenHe")
	public String ShenHeAppInfo(Integer appinfoid,HttpServletRequest request){
		AppInfo appinfo=appInfoService.VeiwAppInfo(appinfoid);
		AppVersion app = appVersionService.SelectById(appinfo.getVersionId());
		request.setAttribute("app", app);
		request.setAttribute("appinfo",appinfo);
		return "/backend/backShenHe";
	}
	
	@RequestMapping("/ShenHe")
	public String ShenHeApp(Integer appinfoid,Integer jude,HttpServletRequest request){
		AppInfo appinfo=appInfoService.VeiwAppInfo(appinfoid);
		AppVersion app = appVersionService.SelectById(appinfo.getVersionId());
		if(jude==0){
			appinfo.setStatus(2);
			app.setPublishStatus(2);
		}else{
			appinfo.setStatus(3);
			app.setPublishStatus(3);
		}
		appInfoService.UpdateAppInfo(appinfo);
		appVersionService.AppVersionUpdate(app);
		return "redirect:/back/appinfo/backList";
	}
	
	

}
