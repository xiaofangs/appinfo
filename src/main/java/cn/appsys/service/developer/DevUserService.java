package cn.appsys.service.developer;


import cn.appsys.pojo.DevUser;

public interface DevUserService {
	//����devCode��ȡ�û���¼
	public DevUser getLoginUser(String devCode,String password);

}
