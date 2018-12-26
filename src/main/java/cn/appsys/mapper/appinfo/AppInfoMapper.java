package cn.appsys.mapper.appinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;

public interface AppInfoMapper {
	List<AppInfo> SelectByAll(@Param("softwareName")String softwareName,
			@Param("status")Integer status,
			@Param("flatformId")Integer flatformId,
			@Param("categoryLevel1")Integer categoryLevel1,
			@Param("categoryLevel2")Integer categoryLevel2,
			@Param("categoryLevel3")Integer categoryLevel3,
			@Param("pageCurr")Integer pageCurr,
			@Param("pageSize")Integer pageSize);
	Integer SelectCount(@Param("softwareName")String softwareName,
			@Param("status")Integer status,
			@Param("flatformId")Integer flatformId,
			@Param("categoryLevel1")Integer categoryLevel1,
			@Param("categoryLevel2")Integer categoryLevel2,
			@Param("categoryLevel3")Integer categoryLevel3);
	Integer CheckedAPKName(@Param("APKName")String APKName);
	Integer AppInfoAdd(AppInfo appinfo);
	AppInfo SelectById(@Param("id")Integer id);
	Integer UpdateAppInfo(AppInfo appinfo);
	Integer DeletePic(@Param("id")Integer id);
	Integer UpdateVersion(@Param("id")Integer id,@Param("versionId")Integer versionId);
	AppInfo VeiwAppInfo(@Param("id")Integer id);
	Integer deleteAppInfo(@Param("id")Integer id);


}
