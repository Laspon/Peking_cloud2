package awd.cloud.suppers.interfaces.service.kss;

import awd.cloud.suppers.interfaces.utils.PagerResult;
import awd.cloud.suppers.interfaces.utils.ResponseMessage;

import java.util.Map;

public interface LshjService {

    public ResponseMessage<PagerResult<Map<String, Object>>> getLshj(Map<String, Object> map);

    public ResponseMessage<String> saveLshj(Map<String, Object> map);

    public ResponseMessage<String> updateLshjById(String id ,Map<String, Object> map);
}
