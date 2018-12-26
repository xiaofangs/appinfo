package cn.appsys.service.developer;

import java.util.List;

import org.apache.ibatis.annotations.Param;



import cn.appsys.pojo.AppVersion;

public interface AppVersionService {
	List<AppVersion> SelectByAppId(Integer appId);
	Integer InsertAppVersion(AppVersion appversion);
	AppVersion SelectById(Integer id);
	Integer AppVersionUpdate(AppVersion appversion);
	Integer DeleteAppVersion(Integer appId);
	Integer UpdatePic(Integer id);


}
