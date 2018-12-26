package cn.appsys.mapper.backenduser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.BackendUser;

public interface BackendUserMapper {
	BackendUser BackUserLogin(@Param("userCode")String userCode);

}
