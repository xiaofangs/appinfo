package cn.appsys.mapper.devuser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

public interface DevUserMapper {
	//����devCode��ȡ�û���¼
	public DevUser getLoginUser(@Param("devCode")String devCode);

}
