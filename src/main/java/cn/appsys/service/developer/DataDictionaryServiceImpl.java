package cn.appsys.service.developer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.mapper.datadictionary.DataDictionaryMapper;
import cn.appsys.pojo.DataDictionary;

@Service("DataDictionaryService")
@Transactional
public class DataDictionaryServiceImpl implements DataDictionaryService {
	@Resource
	private DataDictionaryMapper dataDictionaryMapper;

	@Override
	@Transactional(readOnly=true)
	public List<DataDictionary> SelectByTypecode(String typecode) {
		return dataDictionaryMapper.SelectByTypecode(typecode);
	}

}
