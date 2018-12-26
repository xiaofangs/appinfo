package cn.appsys.mapper.devuser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

public interface DevUserMapper {
	//根据devCode获取用户记录
	public DevUser getLoginUser(@Param("devCode")String devCode);

}
