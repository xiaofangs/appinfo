package cn.appsys.controller.developer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.appsys.pojo.AppCategory;
import cn.appsys.service.developer.AppCategoryService;

@Controller
@RequestMapping("/dev/category")
public class AppCategoryController {
	@Resource
	private AppCategoryService appCategoryService;
	
	@RequestMapping(value="/appinfoCatagory")
	@ResponseBody
	public Object SelectByCategory(@RequestParam(value="parentId",required=false)Integer parentId){
		 List<AppCategory> category=appCategoryService.SelectByParentId(parentId);
		 return category;
	}

}
