package awd.cloud.suppers.interfaces.controller.kss;

import awd.cloud.suppers.interfaces.service.kss.YrzxService;
import awd.cloud.suppers.interfaces.utils.PagerResult;
import awd.cloud.suppers.interfaces.utils.ResponseMessage;
import awd.framework.common.utils.JSONUtil;
import awd.framework.common.utils.OpenAPI;
import awd.framework.expands.logging.AccessLogger;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("/kss/yrzx")
@AccessLogger("kss")
@Api(value = "kss",description = "一日作息")
public class YrzxController {

    @Autowired
    private YrzxService yrzxService;

    @OpenAPI
    @ApiOperation(value = "一日作息查询")
    @RequestMapping(value = "/getYrzx", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ResponseMessage<PagerResult<Map<String, Object>>> getYrzx(@RequestParam String json) {

        Map<String, Object> map = JSONUtil.toMap(json, Object.class);

        Map<String, Object> appcodeAndJsbhMap = Maps.newHashMap();
        appcodeAndJsbhMap.put("appcode", map.get("appcode"));//appcode
        appcodeAndJsbhMap.put("jsbh", map.get("jsbh"));//监所编号
        String appcodeAndJsbh = JSON.toJSONString(appcodeAndJsbhMap);//appcode和监所编号Json字符串

        Map<String, Object> param = (Map) map.get("param");//条件参数

        return yrzxService.getYrzx(param);
    }

    @OpenAPI
    @ApiOperation(value="保存数据,如果数据不存在则新增一条数据")
    @RequestMapping(value = "/saveYrzx",method = {RequestMethod.POST})
    public ResponseMessage<String> saveYrzx(@RequestParam String json){

        Map<String, Object> map = JSONUtil.toMap(json, Object.class);

        Map<String, Object> appcodeAndJsbhMap = Maps.newHashMap();
        appcodeAndJsbhMap.put("appcode", map.get("appcode"));//appcode
        appcodeAndJsbhMap.put("jsbh", map.get("jsbh"));//监所编号
        String appcodeAndJsbh = JSON.toJSONString(appcodeAndJsbhMap);//appcode和监所编号Json字符串

        Map<String, Object> param = (Map) map.get("param");//条件参数

        return yrzxService.saveYrzx(param);
    }

    @OpenAPI
    @ApiOperation(value="根据id更新")
    @RequestMapping(value = "/updateYrzxById",method = {RequestMethod.POST})
    public ResponseMessage<String> updateYrzxById(@RequestParam String json){

        Map<String, Object> map = JSONUtil.toMap(json, Object.class);

        Map<String, Object> appcodeAndJsbhMap = Maps.newHashMap();
        appcodeAndJsbhMap.put("appcode", map.get("appcode"));//appcode
        appcodeAndJsbhMap.put("jsbh", map.get("jsbh"));//监所编号
        String appcodeAndJsbh = JSON.toJSONString(appcodeAndJsbhMap);//appcode和监所编号Json字符串

        Map<String, Object> param = (Map) map.get("param");//条件参数
        String id = (String)map.get("id");

        return yrzxService.updateYrzxById(id,param);
    }
}
