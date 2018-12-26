package cn.appsys.service.developer;


import cn.appsys.pojo.BackendUser;

public interface BackendUserService {
	BackendUser BackUserLogin(String userCode,String password);

}
