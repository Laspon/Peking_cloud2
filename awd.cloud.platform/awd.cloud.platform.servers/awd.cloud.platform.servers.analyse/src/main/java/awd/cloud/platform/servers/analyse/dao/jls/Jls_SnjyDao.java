package awd.cloud.platform.servers.analyse.dao.jls;

import awd.framework.common.dao.api.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface Jls_SnjyDao extends Dao {

    List<Map<String, Object>> snjyCount( @Param("jsbh")String jsbh,@Param("starttime")String starttime,
            @Param("endtime")String endtime);
    List<Map<String, Object>> snjyBym( @Param("jsbh")String jsbh);
}
