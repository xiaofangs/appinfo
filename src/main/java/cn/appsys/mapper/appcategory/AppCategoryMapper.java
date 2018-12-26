package cn.appsys.mapper.appcategory;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;

public interface AppCategoryMapper {
	List<AppCategory> SelectByParentId(@Param("parentId")Integer parentId);
	

}
