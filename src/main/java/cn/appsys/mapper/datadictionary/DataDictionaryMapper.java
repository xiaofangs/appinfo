package cn.appsys.mapper.datadictionary;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DataDictionary;

public interface DataDictionaryMapper {
	List<DataDictionary> SelectByTypecode(@Param("typecode")String typecode);

}
