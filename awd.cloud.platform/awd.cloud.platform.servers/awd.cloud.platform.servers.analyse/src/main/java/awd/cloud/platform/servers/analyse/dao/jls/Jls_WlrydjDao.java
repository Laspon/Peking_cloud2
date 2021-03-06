package awd.cloud.platform.servers.analyse.dao.jls;

import awd.cloud.platform.servers.analyse.model.jls.JbxxModel;
import awd.framework.common.dao.api.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface Jls_WlrydjDao extends Dao {

    List<Map<String, Object>> wlrydjCount( @Param("jsbh")String jsbh,@Param("starttime")String starttime,
            @Param("endtime")String endtime);

}
