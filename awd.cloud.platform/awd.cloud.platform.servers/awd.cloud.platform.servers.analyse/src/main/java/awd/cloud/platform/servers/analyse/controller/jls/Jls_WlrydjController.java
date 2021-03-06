package awd.cloud.platform.servers.analyse.controller.jls;

import awd.cloud.platform.servers.analyse.model.jls.JbxxModel;
import awd.cloud.platform.servers.analyse.service.jls.Jls_JbxxService;
import awd.cloud.platform.servers.analyse.service.jls.Jls_JcjlService;
import awd.cloud.platform.servers.analyse.service.jls.Jls_WlrydjService;
import awd.framework.common.controller.message.ResponseMessage;
import awd.framework.common.utils.OpenAPI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.SysexMessage;

@RestController
@RequestMapping("/jls_wlrydj")
@RefreshScope
@Api(tags = "jls_wlrydj",description = "外来人员登记")
public class Jls_WlrydjController {
    @Autowired
    private Jls_WlrydjService jls_wlrydjService;


    @GetMapping("/wlrydjCount")
    @ApiOperation("业务动态")
    @OpenAPI
    public ResponseMessage<Map<String, Object>> zcrsCount( @RequestParam(value = "jsbh", required = false) String jsbh,
    		@RequestParam(value = "starttime", required = false) String starttime,
            @RequestParam(value = "endtime", required = false) String endtime) {
    	try {
	        Map<String, Object> result = new HashMap<String, Object>();
	        List<Map<String, Object>> list = jls_wlrydjService.wlrydjCount(jsbh,starttime,endtime);
	        result.put("wlrydj", list);
	        return ResponseMessage.ok(result);
    	}catch (Exception e){
			e.printStackTrace();
			return ResponseMessage.error("执行失败");
    	}
    }
}