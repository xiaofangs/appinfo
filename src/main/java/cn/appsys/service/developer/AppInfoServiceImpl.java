package cn.appsys.service.developer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.mapper.appinfo.AppInfoMapper;
import cn.appsys.pojo.AppInfo;
import cn.appsys.util.Page;

@Service("AppInfoService")
@Transactional
public class AppInfoServiceImpl implements AppInfoService {
	@Resource
	private AppInfoMapper appInfoMapper;

	@Transactional(readOnly=true)
	@Override
	public Page<AppInfo> SelectByAll(String softwareName, Integer status,
			Integer flatformId, Integer categoryLevel1, Integer categoryLevel2,
			Integer categoryLevel3, Integer pageCurr, Integer pageSize) {
		Page<AppInfo> page=new Page<AppInfo>();
		page.setPageSize(pageSize);
		page.setCount(this.SelectCount(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3));
		if(page.getPageCount()<=pageCurr&&page.getPageCount()>0){
			pageCurr=page.getPageCount();
		}else if(pageCurr<=0){
			pageCurr=1;
		}
		page.setPageCurr(pageCurr);
		List<AppInfo> pageList=appInfoMapper.SelectByAll(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3, (pageCurr-1)*pageSize, pageSize);
		page.setPageList(pageList);
	    return page;
	}
    @Transactional(readOnly=true)
	@Override
	public Integer SelectCount(String softwareName, Integer status,
			Integer flatformId, Integer categoryLevel1, Integer categoryLevel2,
			Integer categoryLevel3) {
		return appInfoMapper.SelectCount(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3);
	}
	@Override
	@Transactional(readOnly=true)
	public Integer CheckedAPKName(String APKName) {
		return appInfoMapper.CheckedAPKName(APKName);
	}
	@Override
	public Integer AppInfoAdd(AppInfo appinfo) {
		return appInfoMapper.AppInfoAdd(appinfo);
	}
	@Override
	@Transactional(readOnly=true)
	public AppInfo SelectById(Integer id) {
		return appInfoMapper.SelectById(id);
	}
	@Override
	public Integer UpdateAppInfo(AppInfo appinfo) {
		return appInfoMapper.UpdateAppInfo(appinfo);
	}
	@Override
	public Integer DeletePic(Integer id) {
		return appInfoMapper.DeletePic(id);
	}
	@Override
	public Integer UpdateVersion(Integer id, Integer versionId) {
		return appInfoMapper.UpdateVersion(id, versionId);
	}
	@Override
	@Transactional(readOnly=true)
	public AppInfo VeiwAppInfo(Integer id) {   
		return appInfoMapper.VeiwAppInfo(id);
	}
	@Override
	public Integer deleteAppInfo(Integer id) {
		return appInfoMapper.deleteAppInfo(id);
	}

}
