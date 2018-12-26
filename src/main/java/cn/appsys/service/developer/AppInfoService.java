package cn.appsys.service.developer;





import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;
import cn.appsys.util.Page;

public interface AppInfoService {
	Page<AppInfo> SelectByAll(String softwareName,
			Integer status,
			Integer flatformId,
			Integer categoryLevel1,
			Integer categoryLevel2,
			Integer categoryLevel3,
			Integer pageCurr,
			Integer pageSize);
	Integer SelectCount(String softwareName,
			Integer status,
			Integer flatformId,
			Integer categoryLevel1,
			Integer categoryLevel2,
			Integer categoryLevel3);
	Integer CheckedAPKName(String APKName);
	Integer AppInfoAdd(AppInfo appinfo);
	AppInfo SelectById(Integer id);
	Integer UpdateAppInfo(AppInfo appinfo);
	Integer DeletePic(Integer id);
	Integer UpdateVersion(Integer id,Integer versionId);
	AppInfo VeiwAppInfo(Integer id);
	Integer deleteAppInfo(Integer id);





}
