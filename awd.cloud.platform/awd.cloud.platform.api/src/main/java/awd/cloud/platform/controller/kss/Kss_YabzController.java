/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package awd.cloud.platform.controller.kss;
import javax.servlet.http.HttpServletRequest;

import awd.bj.kss.model.YabzModel;
import awd.cloud.platform.api.KssServerApis;
import awd.cloud.platform.service.PublicService;
import awd.cloud.platform.utils.*;
import awd.framework.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import awd.cloud.platform.api.KssService;
import awd.cloud.platform.model.kss.Kss_YabzModel;
import awd.framework.common.utils.OpenAPI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("/v4/kss/yabz")
@Api(tags = "kss-yabz",description = "Yabz") 
public class Kss_YabzController extends PublicService {
	
	@Autowired
    private KssService kssService;
	@Autowired
	private KssServerApis kssServerApis;

	@OpenAPI
	@ApiOperation("分页查询")
	@GetMapping
	@HystrixCommand
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
	public ResponseMessage<PagerResult<Kss_YabzModel>> yabz_query(HttpServletRequest request, @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, @RequestParam(name = "user")String user) {
		QueryParam queryParam = new QueryParam();
        ResponseMessage<PagerResult<Kss_YabzModel>> result= kssService.yabz_query(queryParam);
        if(result.getStatus()==200) {
            result.setMessage("查询成功");
            if(result.getResult()==null) {
                result.setMessage("未查询数据");
            }
        }
        return result;
	}
	
	

	@ApiOperation("新增")
	@PostMapping
	@HystrixCommand
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
	@OpenAPI
	public ResponseMessage<String> yabz_save( @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, @RequestParam(name = "user")String user,@RequestBody Kss_YabzModel data) {
		return kssService.yabz_save(data);
	}
	
	


	@ApiOperation("根据id更新")
	@PutMapping(path = {"/{id:.+}"})
	@HystrixCommand
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
	@OpenAPI
	public ResponseMessage<String> yabz_updateByKey(@PathVariable String id, @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, @RequestParam(name = "user")String user,@RequestBody Kss_YabzModel data) {
		return kssService.yabz_updateByKey(id, data);
	}	


	@OpenAPI
	public ResponseMessage<Kss_YabzModel> yabz_getByKey(@PathVariable String id, @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, @RequestParam(name = "user")String user) {
		return kssService.yabz_getByKey(id);
	}
	
	

	@OpenAPI
	public ResponseMessage<Integer> yabz_deleteByKey(@PathVariable String id, @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, @RequestParam(name = "user")String user) {
		return kssService.yabz_deleteByKey(id);
	}

	/**
	 * @api {get} /v4/kss/yabz/yabzList 预案编制查询
	 * @apiVersion 0.4.0
	 * @apiName yabzList
	 * @apiGroup g_kss
	 * @apiPermission any
	 * @apiDescription 预案编制查询
	 *
	 * @apiParam {String} appcode 												应用代码(必填)
	 * @apiParam {String} jsbh 												监所编号(必填;最大字段长度：9)
	 * @apiParam {String} json 												查询参数集
	 *
	 * @apiSuccess {String}id          				                        id
	 * @apiSuccess {String}jsbh          				                        监所编号
	 * @apiSuccess {String}jsbhString          				                监所编号（已转换）
	 * @apiSuccess {String}yadw          				                        预案单位
	 * @apiSuccess {String}yadwString       				                    预案单位（已转换）
	 * @apiSuccess {String}yalx          				                		预案类型
	 * @apiSuccess {String}yalxString          				                预案类型（已转换）
	 * @apiSuccess {String}yadj          				                        预案等级
	 * @apiSuccess {String}yadjString          				                预案等级（已转换）
	 * @apiSuccess {String}czfa				                        		处置方案
	 * @apiSuccess {String}bzcs   				                    			保障措施
	 * @apiSuccess {String}sxsj 				                        		生效时间
	 * @apiSuccess {String}xgry      				                			相关人员
	 * @apiSuccess {String}state          				                        状态
	 * @apiSuccess {String}stateString          				                状态(已转换)
	 * @apiSuccess {String}creator          				                    创建人
	 * @apiSuccess {String}createtime          				                创建时间
	 * @apiSuccess {String}updator          				                    修改人
	 * @apiSuccess {String}updatetime          				                修改时间

	 * @apiSuccess {String}message                                              返回信息
	 * @apiSuccess {String}result                                               返回结果
	 * @apiSuccess {String}total                                                返回总数
	 * @apiSuccess {String}data                                                 返回数据
	 * @apiSuccess {String}status                                               返回状态
	 * @apiSuccess {String}timestamp                                            时间戳
	 *
	 *  @apiSuccessExample {json} 返回 (成功):
	 *      HTTP/1.1 200 OK
	 *
	 * {
	 *   "message": "查询成功",
	 *   "result": {
	 *     "total": 7,
	 *     "data": [
	 *       {
	 *        	id: "11000011420191231000049"
	 * 			jsbh: "110000114"
	 * 			jsbhString: "北京市第一看守所"
	 * 			yadw: "02"
	 * 			yadwString: "预案单位2"
	 * 			yalx: "01"
	 * 			yalxString: "预案类型1"
	 * 			yadj: "02"
	 * 			yadjString: "预案等级2"
	 * 			czfa: ""
	 * 			bzcs: ""
	 * 			sxsj: "2019-12-31 10:48:16"
	 * 			xgry: ""
	 * 			state: "R2"
	 * 			stateString: "有效"
	 * 			creator: "管理员"
	 * 			createtime: "2019-12-31 10:48:35"
	 * 			updator: ""
	 * 			updatetime: null
	 *       }
	 *     ],
	 *     "page": "1"
	 *   },
	 *   "status": 200,
	 *   "timestamp": 1578447454182
	 * }
	 *
	 * @apiUse QueryError
	 *
	 * @apiExample 请求参数:
	 *    appcode:"应用代码（必填）",
	 *    jsbh:"监所编号(必填; 最大字段长度：9)(必填)",
	 *    json:{
	 *    		"yadw": "预案单位",
	 *          "kssj": "开始时间（格式:yyyy-MM-dd hh:mm:ss）",
	 *          "jssj": "结束时间（格式:yyyy-MM-dd hh:mm:ss）",
	 *          "page": "当前页数",
	 *          "rows": "一页数据量",
	 *          "sort": "id",
	 *          "order": "desc"
	 *         }
	 *
	 */
	//id,jsbh,jsbhString,yadw,yadwString,yalx,yalxString,yadj,yadjString,czfa,bzcs,sxsj,xgry
	@OpenAPI
	@ApiOperation("预案编制查询")
	@GetMapping("/yabzList")
	@HystrixCommand
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
	public ResponseMessage<Map<String,Object>> yabzList(HttpServletRequest request, @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, String json){
		String interfaceId = "/v4/kss/yabz/yabzList";
		String state = request.getParameter("state");
		try{
			ResponseMessage<Map<String,Object>> maps = this.userAuthorizatio(request,json,interfaceId);
			if (maps.getStatus() != 200){
				return ResponseMessage.error(maps.getMessage());
			}
			QueryParam queryParam = new QueryParam();
			if (!StringUtils.isNullOrEmpty(jsbh)){
				queryParam.and("jsbh", TermType.eq, jsbh);
			}
			if (!StringUtils.isNullOrEmpty(maps.getResult().get("yadw"))){
				queryParam.and("yadw",TermType.like,"%"+ maps.getResult().get("yadw")+"%");
			}
			if (!StringUtils.isNullOrEmpty(maps.getResult().get("kssj"))) {
				queryParam.and("sxsj", TermType.gte, maps.getResult().get("kssj"));
			}
			if (!StringUtils.isNullOrEmpty(maps.getResult().get("jssj"))) {
				queryParam.and("sxsj", TermType.lte, maps.getResult().get("jssj"));
			}
			DefaultQueryParam.addDefaultQueryParam(request, queryParam, state);
			System.err.println("param--" + JSON.toJSONString(queryParam));

			ResponseMessage<PagerResult<YabzModel>> result = kssServerApis.yabzList(queryParam);
			System.err.println("result" + JSON.toJSONString(result));
			//封装需要的数据
			Map<String, Object> maplist = new HashMap<String, Object>();
			maplist.put("entity", result.getResult().getData());
			maplist.put("interfaceId", interfaceId);
			maplist.put("total", result.getResult().getTotal());
			maplist.put("page", request.getParameter("page"));

			ResponseMessage<Map<String, Object>> list = this.kfzdShow(maplist);
			if (list.getStatus() == 200) {
				list.setMessage("查询成功");
				if (list.getResult() == null) {
					list.setMessage("未查询数据");
				}
			}
			return list;
		} catch (Exception e){
			e.printStackTrace();
			return ResponseMessage.error("查询失败！");
		}
	}

	/**
	 * @api {post} /v4/kss/yabz/yabzAdd 预案编制保存
	 * @apiVersion 0.4.0
	 * @apiName yabzAdd
	 * @apiGroup g_kss
	 * @apiPermission user
	 *
	 * @apiDescription 预案编制保存
	 *
	 * @apiParam {String} appcode 						    应用代码（必填）
	 * @apiParam {String} jsbh 							监所编号（必填）(最大长度:9)
	 * @apiParam {String} json 							保存参数集（必填）
	 *
	 * @apiSuccess {String} message         			    成功信息
	 * @apiSuccess {String} result         				生成的主键信息
	 * @apiSuccess {String} status         				代码
	 * @apiSuccess {String} timestamp         			    时间戳
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
	 * appcode:"应用代码(必填)",
	 * jsbh:"监所编号(必填; 最大长度:9)",
	 * json:{
	 *   "entity":[
	 *     {
	 *      "yadw": "预案单位（必填; 最大长度:10）",
	 *      "yalx": "预案类型（必填; 最大长度:4）",
	 *      "yadj": "预案等级（必填; 最大长度:4）",
	 *      "czfa": "处置方案",
	 *      "bzcs": "保障措施",
	 *      "sxsj": "生效时间（必填;格式:yyyy-MM-dd hh:mm:ss）",
	 *      "xgry": "相关人员",
	 *      "creator": "创建人(必填; 最大长度:50)"
	 *     }
	 *   ]
	 * }
	 *
	 */
	//{"yadw":".{1,10}","yalx":".{1,4}","yadj":".{1,4}","sxsj":"^(\\d{4})-([0-1]\\d)-([0-3]\\d)\\s([0-5]\\d):([0-5]\\d):([0-5]\\d)$","creator":".{1,30}"}
	@ApiOperation("预案编制保存")
	@PostMapping("/yabzlAdd")
	@HystrixCommand
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
	@OpenAPI
	public ResponseMessage<String> yabzlAdd(HttpServletRequest request, @RequestParam(name = "appcode") String appcode, @RequestParam(name = "jsbh") String jsbh, String json){
		String interfaceId = "/v4/kss/yabz/yabzlAdd";
		try{
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
			List<YabzModel> list = JSONArray.parseArray(map.get("entity").toString(),YabzModel.class);
			YabzModel yabzModel = list.get(0);
			yabzModel.setState("R2");
			yabzModel.setJsbh(jsbh);
			yabzModel.setCreatetime(new Date());

			ResponseMessage<String> result = kssServerApis.yabzSave(yabzModel);
			if (result.getStatus() == 200){
				result.setMessage("保存成功！");
			} else {
				result.setMessage("服务异常，保存失败！");
			}
			return result;
		} catch (Exception e){
			e.printStackTrace();
			return ResponseMessage.error("保存失败！");
		}
	}

	/**
	 * @api {post} /v4/kss/yabz/yabzUpdate 预案编制修改
	 * @apiVersion 0.4.0
	 * @apiName yabzUpdate
	 * @apiGroup g_kss
	 * @apiPermission user
	 *
	 * @apiDescription 预案编制修改
	 *
	 * @apiParam {String} appcode 						    应用代码（必填）
	 * @apiParam {String} jsbh 							监所编号（必填）(最大长度:9)
	 * @apiParam {String} json 							保存参数集（必填）
	 *
	 * @apiSuccess {String} message         			    成功信息
	 * @apiSuccess {String} result         				生成的主键信息
	 * @apiSuccess {String} status         				代码
	 * @apiSuccess {String} timestamp         			    时间戳
	 *
	 *
	 * @apiSuccessExample {json} 返回（成功）:
	 * HTTP/1.1 200 OK
	 * {
	 *   "message": "修改成功!",
	 *   "result": "修改成功",
	 *   "status": 200,
	 *   "timestamp": 1578886392184
	 * }
	 *
	 * @apiUse CreateError
	 *
	 * @apiExample 请求参数:
	 * appcode:"应用代码(必填)",
	 * jsbh:"监所编号(必填; 最大长度:9)",
	 * json:{
	 *   "entity":[
	 *     {
	 *      "id":"id(必填; 最大长度：23)",
	 *		"yadw": "预案单位（必填; 最大长度:10）",
	 *      "yalx": "预案类型（必填; 最大长度:4）",
	 *      "yadj": "预案等级（必填; 最大长度:4）",
	 *      "czfa": "处置方案",
	 *      "bzcs": "保障措施",
	 *      "sxsj": "生效时间（必填;格式:yyyy-MM-dd hh:mm:ss）",
	 *      "xgry": "相关人员",
	 *      "creator": "创建人(必填; 最大长度:50)"
	 *     }
	 *   ]
	 * }
	 *
	 */
	//{"id":".{1,23}","yadw":".{1,10}","yalx":".{1,4}","yadj":".{1,4}","sxsj":"^(\\d{4})-([0-1]\\d)-([0-3]\\d)\\s([0-5]\\d):([0-5]\\d):([0-5]\\d)$","creator":".{1,30}"}
	@ApiOperation("预案编制修改")
	@PostMapping("yabzUpdate")
	@HystrixCommand
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
	@OpenAPI
	public ResponseMessage<String> yabzUpdate(HttpServletRequest request, @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, String json){
		String interfaceId = "/v4/kss/yabz/yabzUpdate";
		try {
			//校验权限
			ResponseMessage<Map<String, Object>> maps =this.userAuthorizatio(request,json, interfaceId);
			if(maps.getStatus()!=200) {
				return ResponseMessage.error(maps.getMessage());
			}
			//数据类型校验
			Map<String, Object> map = JSONObject.parseObject(json, HashMap.class);
			map.put("interfaceId", interfaceId);
			ResponseMessage<String> msg = this.modelYz(map);
			if (msg.getStatus() != 200) {
				return ResponseMessage.error(msg.getMessage());
			}
			List<YabzModel> list = JSONArray.parseArray(map.get("entity").toString(),YabzModel.class);
			YabzModel yabzModel = list.get(0);
			yabzModel.setState("R2");
			yabzModel.setJsbh(jsbh);
			yabzModel.setCreatetime(new Date());

			ResponseMessage<String> result = kssServerApis.yabzUpdate(yabzModel.getId(),yabzModel);
			if (result.getStatus() == 200){
				result.setMessage("修改成功！");
			} else {
				result.setMessage("服务异常，修改失败！");
			}
			return result;
		} catch (Exception e){
			e.printStackTrace();
			return ResponseMessage.error("修改失败！");
		}
	}
}
