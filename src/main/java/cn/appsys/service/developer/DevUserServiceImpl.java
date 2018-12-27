package cn.appsys.service.developer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.mapper.devuser.DevUserMapper;
import cn.appsys.pojo.DevUser;

@Service("DevUserService")
@Transactional
public class DevUserServiceImpl implements DevUserService {
    @Resource
	private DevUserMapper devUserMapper;
	@Override
	public DevUser getLoginUser(String devCode, String password) {
		DevUser devUser=null;
		devUser=devUserMapper.getLoginUser(devCode);
		if(devUser!=null){
		if(!devUser.getDevPassword().equals(password)){
			devUser=null;
		}
		}
		return devUser;
	}

}
