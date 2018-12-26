package cn.appsys.service.developer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.mapper.appversion.AppVersionMapper;
import cn.appsys.pojo.AppVersion;
@Service("AppVersionService")
@Transactional
public class AppVersionServiceImpl implements AppVersionService {
	@Resource
	private AppVersionMapper appVersionMapper;

	@Override
	@Transactional(readOnly=true)
	public List<AppVersion> SelectByAppId(Integer appId) {
		return appVersionMapper.SelectByAppId(appId);
	}

	@Override
	public Integer InsertAppVersion(AppVersion appversion) {
		return appVersionMapper.InsertAppVersion(appversion);
	}

	@Override
	public AppVersion SelectById(Integer id) {
		return appVersionMapper.SelectById(id);
	}

	@Override
	public Integer AppVersionUpdate(AppVersion appversion) {
		return appVersionMapper.AppVersionUpdate(appversion);
	}

	@Override
	public Integer DeleteAppVersion(Integer appId) {
		return appVersionMapper.DeleteAppVersion(appId);
	}

	@Override
	public Integer UpdatePic(Integer id) {
		return appVersionMapper.UpdatePic(id);
	}

}
