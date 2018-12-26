package cn.appsys.service.developer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.mapper.backenduser.BackendUserMapper;
import cn.appsys.pojo.BackendUser;

@Service("BackendUserService")
@Transactional
public class BackendUserServiceImpl implements BackendUserService {
    @Resource
	private BackendUserMapper backendUserMapper;
	@Override
	@Transactional(readOnly=true)
	public BackendUser BackUserLogin(String userCode,String password) {
		BackendUser backendUser=null;
		backendUser=backendUserMapper.BackUserLogin(userCode);
		if(!backendUser.getUserPassword().equals(password)){
			backendUser=null;
		}
		return backendUser;
	}

}
