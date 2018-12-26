package cn.appsys.service.developer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DataDictionary;

public interface DataDictionaryService {
	 List<DataDictionary> SelectByTypecode(@Param("typecode")String typecode);

}
