package awd.cloud.suppers.interfaces.service.jls.imp;

import awd.cloud.suppers.interfaces.api.JlsServersApi;
import awd.cloud.suppers.interfaces.service.jls.CsjkqkService;
import awd.cloud.suppers.interfaces.utils.DefaultQueryParam;
import awd.cloud.suppers.interfaces.utils.PagerResult;
import awd.cloud.suppers.interfaces.utils.QueryParam;
import awd.cloud.suppers.interfaces.utils.ResponseMessage;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("csjkqkService")
public class SimpleCsjkqkService implements CsjkqkService {

    @Autowired
    private JlsServersApi jlsServersApi;

    @Override
    public ResponseMessage<PagerResult<Map<String, Object>>> getCsjkqk() {
        QueryParam queryParam = new QueryParam();

        DefaultQueryParam.addDefaultQueryParam(null, queryParam, "");

        System.err.println("queryParam---" + JSON.toJSONString(queryParam));

        ResponseMessage<PagerResult<Map<String, Object>>> list = jlsServersApi.queryCsjkqk(queryParam);

        System.err.println("list.getIncludes()---" + JSON.toJSONString(list.getIncludes()));
        System.err.println("list---" + JSON.toJSONString(list));

        return list;
    }

    @Override
    public ResponseMessage<String> saveCsjkqk(Map<String, Object> map) {
        return jlsServersApi.saveCsjkqk(map);
    }

    @Override
    public ResponseMessage<String> updateCsjkqkById(String id, Map<String, Object> map) {
        return jlsServersApi.updateCsjkqkById(id,map);
    }
}
