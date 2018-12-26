package cn.appsys.controller.developer;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.service.developer.AppInfoService;
import cn.appsys.service.developer.AppVersionService;

@Controller
@RequestMapping("/dev/appversion")
public class AppVersionController {
	@Resource
	private AppVersionService appVersionService;
	@Resource
	private AppInfoService appInfoService;

	@RequestMapping("/toInsert")
	public String toInsert(Integer appId, HttpServletRequest request) {
		List<AppVersion> appversion = appVersionService.SelectByAppId(appId);
		request.setAttribute("appinfoid", appId);
		request.setAttribute("appversion", appversion);
		return "/developer/VersionInsert";
	}

	@RequestMapping("/insert")
	public String Insert(AppVersion appversion,
			@RequestParam("apkupload") MultipartFile apkupload,
			HttpSession session, HttpServletRequest request) {
		Integer appid = appversion.getAppId();
		try {
			String path = request.getSession().getServletContext()
					.getRealPath("statics/uploadfiles/");
			if (!apkupload.isEmpty()) {
				String fileName = apkupload.getOriginalFilename();
				String puffix = FilenameUtils.getExtension(fileName);
				if (puffix.equalsIgnoreCase("apk")) {
					if (apkupload.getSize() > 500000000) {
						request.setAttribute("error", "文件大小不能超过500m");
						return "redirect:/dev/appversion/toInsert?appId="
								+ appid;
					}
					AppInfo appinfo = appInfoService.SelectById(appid);
					String filename = appinfo.getAPKName() + "-"
							+ appversion.getVersionNo() + "." + puffix;
					File file = new File(path, filename);
					apkupload.transferTo(file);
					String downloadLink = request.getContextPath()
							+ "/statics/uploadfiles/" + filename;
					String apkLocPath = path + "/" + filename;
					appversion.setApkLocPath(apkLocPath);
					appversion.setApkFileName(filename);
					appversion.setDownloadLink(downloadLink);
				} else {
					request.setAttribute("error", "文件后缀只能为apk");
					return "redirect:/dev/appversion/toInsert?appId=" + appid;
				}
				appversion.setCreatedBy(appid);
				appversion.setCreationDate(new Date());
				appversion.setModifyBy(appid);
				appversion.setModifyDate(new Date());
				appVersionService.InsertAppVersion(appversion);
				appInfoService.UpdateVersion(appid, appversion.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/dev/appversion/toInsert?appId=" + appid;
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer appId, HttpServletRequest request) {
		AppInfo appinfo = appInfoService.SelectById(appId);
		List<AppVersion> appversion = appVersionService.SelectByAppId(appId);
		AppVersion app = appVersionService.SelectById(appinfo.getVersionId());
		request.setAttribute("app", app);
		request.setAttribute("appversion", appversion);
		return "/developer/VersionUpdate";
	}

	@RequestMapping("/update")
	public String Update(AppVersion appversion,
			@RequestParam("apkupload") MultipartFile apkupload,
			HttpSession session, HttpServletRequest request) {
		AppVersion appVersion = appVersionService
				.SelectById(appversion.getId());
		Integer appid = appversion.getAppId();
		try {
			String path = request.getSession().getServletContext()
					.getRealPath("statics/uploadfiles/");
			if (!apkupload.isEmpty()) {
				String fileName = apkupload.getOriginalFilename();
				String puffix = FilenameUtils.getExtension(fileName);
				if (puffix.equalsIgnoreCase("apk")) {
					if (apkupload.getSize() > 500000000) {
						request.setAttribute("error", "文件大小不能超过500m");
						return "redirect:/dev/appversion/toUpdate?appId="
								+ appid;
					}
					AppInfo appinfo = appInfoService.SelectById(appid);
					String filename = appinfo.getAPKName() + "-"
							+ appversion.getVersionNo() + "." + puffix;
					File file = new File(path, filename);
					apkupload.transferTo(file);
					String downloadLink = request.getContextPath()
							+ "/statics/uploadfiles/" + filename;
					String apkLocPath = path + "/" + filename;
					appversion.setApkLocPath(apkLocPath);
					appversion.setApkFileName(filename);
					appversion.setDownloadLink(downloadLink);
				} else {
					request.setAttribute("error", "文件后缀只能为apk");
					return "redirect:/dev/appversion/toUpdate?appId=" + appid;
				}

			} else {
				appversion.setApkLocPath(appVersion.getApkLocPath());
				appversion.setApkFileName(appVersion.getApkFileName());
				appversion.setDownloadLink(appVersion.getDownloadLink());
			}
			appversion.setModifyBy(appid);
			appversion.setModifyDate(new Date());
			appversion.setCreatedBy(appVersion.getCreatedBy());
			appversion.setCreationDate(appVersion.getCreationDate());
			appVersionService.AppVersionUpdate(appversion);
			appInfoService.UpdateVersion(appid, appversion.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/dev/appinfo/appinfolist";
	}
	
	@RequestMapping("/uploadsfiles")
	public String uploadsfiles(){
		return "redirect:/dev/appinfo/appinfolist";
	}
	
	@RequestMapping("/deleteFiles")
	@ResponseBody
	public Object deleteFiles(Integer id,HttpServletRequest request){
		AppVersion appversion=appVersionService.SelectById(id);
		Map<String,Object> map=new HashMap<String,Object>();
		File file=new File(appversion.getApkLocPath());
		if(file.exists()){
			if(!file.delete()){
				map.put("result", "error");
			}
		}
		Integer result=appVersionService.UpdatePic(id);
		if(result>0){
			map.put("result",appversion.getAppId());
		}
		return map;
	}
	
	

}
