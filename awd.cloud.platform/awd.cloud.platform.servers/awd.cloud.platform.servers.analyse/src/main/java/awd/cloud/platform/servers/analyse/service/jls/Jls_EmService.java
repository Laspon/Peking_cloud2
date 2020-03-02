package awd.cloud.platform.servers.analyse.service.jls;

import awd.cloud.platform.servers.analyse.dao.jls.Jls_EmDao;
import awd.cloud.platform.servers.analyse.vo.AnalysisJlsResultVO;
import awd.framework.common.datasource.api.annotation.UseDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Jls_EmService {
    @Autowired
    private Jls_EmDao jls_EmDao;

    @UseDataSource("jls_ds")
    public List<Map<String, Object>> emCount(String jsbh, String starttime,String endtime) {
        return  jls_EmDao.emCount(jsbh,starttime,endtime);
    }

    @UseDataSource("jls_ds")
    public List<AnalysisJlsResultVO> queryEmdjList(String starttime, String endtime){
        return jls_EmDao.queryEmdjNum(starttime, endtime);
    }
}
