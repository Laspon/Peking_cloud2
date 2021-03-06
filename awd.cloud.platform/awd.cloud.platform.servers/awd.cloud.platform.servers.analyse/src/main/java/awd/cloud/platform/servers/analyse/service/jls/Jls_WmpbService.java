package awd.cloud.platform.servers.analyse.service.jls;

import awd.cloud.platform.servers.analyse.dao.jls.Jls_JbxxDao;
import awd.cloud.platform.servers.analyse.dao.jls.Jls_SzjdjlDao;
import awd.cloud.platform.servers.analyse.dao.jls.Jls_WmpbDao;
import awd.cloud.platform.servers.analyse.model.jls.JbxxModel;
import awd.framework.common.datasource.api.annotation.UseDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Jls_WmpbService {
    @Autowired
    private Jls_WmpbDao jls_WmpbDao;

    @UseDataSource("jls_ds")
    public List<Map<String, Object>> wmpbCount(String jsbh) {
        return  jls_WmpbDao.wmpbCount(jsbh);
    }


}
