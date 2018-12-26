package cn.appsys.mapper.appversion;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppVersion;

public interface AppVersionMapper {
	List<AppVersion> SelectByAppId(@Param("appId")Integer appId);
	Integer InsertAppVersion(AppVersion appversion);
	AppVersion SelectById(@Param("id")Integer id);
	Integer AppVersionUpdate(AppVersion appversion);
	Integer DeleteAppVersion(@Param("appId")Integer appId);
	Integer UpdatePic(@Param("id")Integer id);

}
