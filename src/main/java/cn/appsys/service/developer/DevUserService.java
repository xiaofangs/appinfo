package cn.appsys.service.developer;


import cn.appsys.pojo.DevUser;

public interface DevUserService {
	//根据devCode获取用户记录
	public DevUser getLoginUser(String devCode,String password);

}
