package cn.appsys.controller.developer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.appsys.pojo.DataDictionary;
import cn.appsys.service.developer.DataDictionaryService;

@Controller
@RequestMapping("/dev/dataDictionary")
public class DataDictionaryController {
	@Resource
	private DataDictionaryService dataDictionaryService;
	
	@RequestMapping("/datadictionarylist")
	@ResponseBody
	public Object SelectByAll(String typeCode){
		List<DataDictionary> data=dataDictionaryService.SelectByTypecode(typeCode);
		return data;
	}

}
