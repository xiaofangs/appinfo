package cn.appsys.service.developer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.mapper.appcategory.AppCategoryMapper;
import cn.appsys.pojo.AppCategory;
@Service("AppCategoryService")
@Transactional
public class AppCategoryServiceImpl implements AppCategoryService {
	@Resource
	private AppCategoryMapper appCategoryMapper;

	@Override
	@Transactional(readOnly=true)
	public List<AppCategory> SelectByParentId(Integer parentId) {
		return appCategoryMapper.SelectByParentId(parentId);
	}

}
