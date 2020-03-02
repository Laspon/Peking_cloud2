package awd.cloud.platform.controller.kss;

import awd.bj.kss.model.ZrapModel;
import awd.cloud.platform.api.KssServerApis;
import awd.cloud.platform.service.PublicService;
import awd.cloud.platform.utils.DefaultQueryParam;
import awd.cloud.platform.utils.QueryParam;
import awd.cloud.platform.utils.ResponseMessage;
import awd.cloud.platform.utils.TermType;
import awd.framework.common.utils.DateTimeUtils;
import awd.framework.common.utils.OpenAPI;
import awd.framework.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author：张延
 * Date：2020-01-19 13:23
 * Description：<描述>
 */
@RestController
@RefreshScope
@RequestMapping("/v4/kss/zrap")
@Api(tags = "kss-zrap",description = "Zrap")
public class Kss_ZrapController extends PublicService {

    @Autowired
    private KssServerApis kssServerApis;



    /**
     * @api {get} /v4/kss/zrap/zrapList 值日安排查询
     * @apiVersion 0.4.0
     * @apiName ddgyList
     * @apiGroup g_kss
     * @apiPermission any
     * @apiDescription 值日安排查询
     * @apiParam {String} appcode 											应用代码(必填)
     * @apiParam {String} jsbh 												监所编号(必填;最大字段长度：9)
     * @apiParam {String} json 												查询参数集
     *
     * @apiSuccess {String}id												id
     * @apiSuccess {String}jsbh											    监所编号
     * @apiSuccess {String}jsbhString										监所编号（已转换）
     * @apiSuccess {String}apsj										        安排时间
     * @apiSuccess {String}week												星期
     * @apiSuccess {String}zbr1												值班人1
     * @apiSuccess {String}zbr2											    值班人2
     * @apiSuccess {String}zbr3												值班人3
     * @apiSuccess {String}zbr4												值班人4
     * @apiSuccess {String}zbr5												值班人5
     * @apiSuccess {String}bz												备注
     * @apiSuccess {String}state											状态
     * @apiSuccess {String}stateString										状态（已转换）
     * @apiSuccess {String}creator											创建人
     * @apiSuccess {String}updator											跟新人
     * @apiSuccess {String}createtime										创建时间
     * @apiSuccess {String}updatetime										跟新时间
     * @apiSuccess {String}jsh												监室号
     * @apiSuccess {String}message                                           返回信息
     * @apiSuccess {String}result                                            返回结果
     * @apiSuccess {String}total                                             返回总数
     * @apiSuccess {String}data                                              返回数据
     * @apiSuccess {String}status                                            返回状态
     * @apiSuccess {String}timestamp                                         时间戳
     * @apiSuccessExample {json} 返回 (成功):
     * HTTP/1.1 200 OK
     * {
     * "message": "查询成功",
     * "result": {
     * "total": 1,
     * "data": [{
     *       "apsj": "2019-12-30",
     *       "bz": "",
     *       "createtime": "2019-12-30 11:09:09",
     *       "creator": "管理员",
     *       "id": "11000011420191230000731",
     *       "jsbh": "110000114",
     *       "jsbhString": "北京市第一看守所",
     *       "jsh": "1018",
     *       "state": "R2",
     *       "stateString": "有效",
     *       "updatetime": "2020-01-09 13:23:26",
     *       "updator": "管理员",
     *       "week": "1",
     *       "zbr1": "1",
     *       "zbr2": "张三",
     *       "zbr3": "李四",
     *       "zbr4": "王五",
     *       "zbr5": "赵六"
     * "page": "1"
     * },
     * "status": 200,
     * "timestamp": 1576826568061
     * }
     * @apiUse QueryError
     * @apiExample 请求参数:
     * appcode:"应用代码（必填）",
     * jsbh:"监所编号(必填; 最大字段长度：9)",
     * json:{
     *     "jsh":"监室号(必填；最大字段长度：4)",
     *     "apsj":"安排时间(必填；格式:yyyy-MM-dd hh:mm:ss)"
     * }
     */
    @OpenAPI
    @ApiOperation("值日安排查询")
    @GetMapping("/zrapList")
    @HystrixCommand
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
    public ResponseMessage<Map<String, Object>> zrapList(HttpServletRequest request, @RequestParam(name = "appcode") String appcode, @RequestParam(name = "jsbh") String jsbh, String json) {
        String interfaceId = "/v4/kss/zrap/zrapList";
        String state = "R2";
        //通过校验获取查询参数
        try {
            ResponseMessage<Map<String, Object>> maps = this.userAuthorizatio(request, json, interfaceId);
            if (maps.getStatus() != 200) {
                return ResponseMessage.error(maps.getMessage());
            }
            // 领取状态(WPLQZT)
            //查询参数
            QueryParam qParam=new QueryParam();

            if(!StringUtils.isNullOrEmpty(jsbh)) {
                qParam.and("jsbh", TermType.eq, jsbh);
            }

            DefaultQueryParam.addDefaultQueryParam(request, qParam, state);

            //值日表状态
            String jsh= (String) maps.getResult().get("jsh");
            if(StringUtils.isNullOrEmpty(jsh)) {
                return ResponseMessage.error("请输入jsh");
            }
            String apsj= (String) maps.getResult().get("apsj");
            if(StringUtils.isNullOrEmpty(apsj)) {
                return ResponseMessage.error("请输入apsj");
            }
            ZrapModel zrapModel=new ZrapModel();
            zrapModel.setApsj(DateTimeUtils.formatDateString(apsj, "yyyy-MM-dd "));
            zrapModel.setJsh(jsh);

            ResponseMessage<List<Map<String, Object>>> result = kssServerApis.findZrap(zrapModel);

            System.err.println("result" + JSON.toJSONString(result));


            //封装需要的数据
            Map<String, Object> maplist = new HashMap<String, Object>();
            maplist.put("entity", result.getResult());
            maplist.put("interfaceId", interfaceId);
            maplist.put("total", result.getResult().size());
            maplist.put("page", request.getParameter("page"));

            ResponseMessage<Map<String, Object>> list = this.kfzdShow(maplist);

            if (list.getStatus() == 200) {
                list.setMessage("查询成功");
                if (list.getResult() == null) {
                    list.setMessage("未查询数据");
                }
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseMessage.error("查询失败！");
        }
    }


    /**
     * @api {post} /v4/kss/zrap/zrapAdd 值日安排保存
     * @apiVersion 0.4.0
     * @apiName zrapAdd
     * @apiGroup g_kss
     * @apiPermission user
     *
     * @apiDescription 值日安排保存
     *
     * @apiParam {String} appcode 						应用代码（必填）
     * @apiParam {String} jsbh 							监所编号（必填）(最大长度:9)
     * @apiParam {String} json 							保存参数集
     *
     * @apiSuccess {String} message         			成功信息
     * @apiSuccess {String} result         				生成的主键信息
     * @apiSuccess {String} status         				代码
     * @apiSuccess {String} timestamp         			时间戳
     *
     *
     * @apiSuccessExample {json} 返回（成功）:
     * HTTP/1.1 200 OK
     * {
     *   "message": "保存成功!",
     *   "result": "保存成功",
     *   "status": 200,
     *   "timestamp": 1578886392184
     * }
     *
     * @apiUse CreateError
     *
     * @apiExample 请求参数:
     *
     *   "appcode":"应用代码(必填)",
     *   "jsbh":"监所编号(必填; 最大字段长度:9)",
     *   json{
     *      "entity":[{
     *         "jsh":"监室号(必填；最大字段长度:4)",
     *         "week":"星期(必填; 最大字段长度:50)",
     *         "apsj":"安排时间(必填; 格式:yyyy-MM-dd)",
     *         "zbr1":"值班人1(最大字段长度:50)",
     *         "zbr2":"值班人2(最大字段长度:50)",
     *         "zbr3":"值班人3(最大字段长度:50)",
     *         "zbr4":"值班人4(最大字段长度:50)",
     *         "zbr5":"值班人5(最大字段长度:50)",
     *         "creator":"创建人(最大字段长度:50)"
     *        }]
     *   }
     *
     */
    //{"jsh":"\\d{1,4}","week":"\\d{1,50}","apsj":"\\d{4}-\\d{2}-\\d{2}","zbr1":".{0,50}","zbr2":".{0,50}","zbr3":".{0,50}","zbr4":".{0,50}","zbr5":".{0,50}","creator":".{1,50}"}
    @ApiOperation("值日安排保存")
    @PostMapping("/zrapAdd")
    @HystrixCommand
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
    @OpenAPI
    public ResponseMessage<Integer> zrapAdd(HttpServletRequest request, @RequestParam(name = "appcode") String appcode, @RequestParam(name = "jsbh") String jsbh, String json){
        //接口id
        String interfaceId = "/v4/kss/zrap/zrapAdd";
        try {
            //校验权限
            ResponseMessage<Map<String, Object>> maps = this.userAuthorizatio(request, json, interfaceId);
            if (maps.getStatus() != 200) {
                return ResponseMessage.error(maps.getMessage());
            }
            //数据类型校验
            Map<String, Object> map = JSONObject.parseObject(json, HashMap.class);
            map.put("interfaceId", interfaceId);
            ResponseMessage<String> msg = this.modelYz(map);
            if (msg.getStatus() != 200) {
                return ResponseMessage.error(msg.getMessage());
            }
            System.err.println(map.get("entity").toString());

            ZrapModel zrapModel = JSONArray.parseArray(map.get("entity").toString(), ZrapModel.class).get(0);
            zrapModel.setState("R2");
            zrapModel.setJsbh(jsbh);
          //  zrapModel.setCreator(users.getUsername());
            zrapModel.setCreatetime(new Date());
            zrapModel.setApsj(new Date());

            ResponseMessage<Integer> result = kssServerApis.addZrap(zrapModel);

            System.err.println("result--" + JSON.toJSONString(result));

            if (result.getStatus() == 200) {
                result.setMessage("保存成功!");
            } else {
                result.setMessage("服务异常,保存失败!");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseMessage.error("保存失败！");
        }
    }

}
