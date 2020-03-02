/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package awd.cloud.platform.controller.kss;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import awd.bj.kss.model.JtjyModel;
import awd.cloud.platform.api.KssServerApis;
import awd.cloud.platform.service.PublicService;
import awd.cloud.platform.utils.DefaultQueryParam;
import awd.cloud.platform.utils.PagerResult;
import awd.cloud.platform.utils.QueryParam;
import awd.cloud.platform.utils.ResponseMessage;
import awd.cloud.platform.utils.TermType;
import awd.framework.common.utils.OpenAPI;
import awd.framework.common.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RefreshScope
@RequestMapping("/v4/kss/jtjy")
@Api(tags = "kss-jtjy",description = "Jtjy") 
public class Kss_JtjyController extends PublicService{
	@Autowired
	private KssServerApis kssServerApis;
	
	/**
	 * @return
	 * @api {get} /v4/kss/jtjy/jtjyQuery 集体教育查询
	 * @apiVersion 0.4.0
	 * @apiName jtjyQuery
	 * @apiGroup g_kss
	 * @apiPermission any
	 * @apiDescription 集体教育查询
	 * @apiParam {String} appcode 											应用代码(必填)
	 * @apiParam {String} jsbh 												监所编号(必填;最大字段长度：9)
	 * @apiParam {String} json 												查询参数集
	 *
	 * @apiSuccess {String}id												id
	 * @apiSuccess {String}jsbh												监所编号
	 * @apiSuccess {String}jsbhString										监所名称
	 * @apiSuccess {String}cjrs										                    参加人数
	 * @apiSuccess {String}sj										                    教育时间
	 * @apiSuccess {String}jyr											 主讲人
	 * @apiSuccess {String}fw											 范围
	 * @apiSuccess {String}nr										                     内容
	 * @apiSuccess {String}xs										                     教育形式
	 * 
	 *
	 *
	 *
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
	 * "data":  [
	 *         id: "11000011420200214000044"
	 *		   jsbh: "110000114"
	 *		   jsbhString: "北京市第一看守所"
	 *		   cjrs: 1
	 *		   sj: "2020-02-14 15:23:55"
	 *		   jyr: "主讲人"
	 *	   	   fw: "0,110000114"
	 *		   nr: "教育内容"
	 *		   xs: "教育形式"
	 * ],
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
	 *    "sj_start":"开始时间(非必填,格式(2019-12-12))",
	 *    "sj_end":"结束时间(非必填,格式(2019-12-12))",
	 * }
	 */
    
    @OpenAPI
	@ApiOperation("集体教育查询")
	@GetMapping("/jtjyQuery")
	@HystrixCommand
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
	public ResponseMessage<Map<String, Object>> jtjyQuery(HttpServletRequest request, @RequestParam(name = "appcode") String appcode, @RequestParam(name = "jsbh") String jsbh, String json) {
		String interfaceId = "/v4/kss/jtjy/jtjyQuery";
		String state = "R2";
		//通过校验获取查询参数
		try {
			ResponseMessage<Map<String, Object>> maps = this.userAuthorizatio(request, json, interfaceId);
			if (maps.getStatus() != 200) {
				return ResponseMessage.error(maps.getMessage());
			}
			//查询参数
			QueryParam qParam = new QueryParam();
	        DefaultQueryParam.addDefaultQueryParam(request, qParam, state);
	        if(!StringUtils.isNullOrEmpty(maps.getResult().get("sj_start"))) {
	        	qParam.and("sj", TermType.gte, maps.getResult().get("sj_start")+" 00:00:00");
	        }
	        if(!StringUtils.isNullOrEmpty(maps.getResult().get("sj_end"))) {
	        	qParam.and("sj", TermType.lte, maps.getResult().get("sj_end")+" 23:59:59");
	        }
	        qParam.and("jsbh", jsbh);
	        ResponseMessage<PagerResult<JtjyModel>> result=kssServerApis.jtjyQueryForPage(qParam);
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
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.error("查询失败！");
		}
	}
    
    /**
	 * @api {post} /v4/kss/jtjy/jtjySave 
	 * @apiVersion 0.4.0
	 * @apiName jtjySave
	 * @apiGroup g_kss
	 * @apiPermission any
	 * @apiDescription 集体教育保存
	 *
	 * @apiParam {String} appcode 											应用代码(必填)
	 * @apiParam {String} jsbh 												监所编号(必填;最大字段长度：9)
	 * @apiParam {String} json 												保存参数集(必填)
	 *
	 * @apiSuccess {String}result         				                     返回结果
	 * @apiSuccess {String}page         				                     返回页数
	 * @apiSuccess {String}status         				                     返回状态
	 * @apiSuccess {String}timestamp         				                 时间戳
	 *
	 * @apiSuccessExample {json} 返回 (成功):
	 * HTTP/1.1 200 OK
	 * {
	 *   "message": "保存成功!",
	 *   "result": "11000011420191214000011",
	 *   "status": 200,
	 *   "timestamp": 1576308305534
	 * }
	 *
	 * @apiUse CreateError
	 *
	 * @apiExample 请求参数:
	 * appcode:"应用代码（必填）",
	 * jsbh:"监所编号(必填; 最大字段长度：9)",
	 * json:{
	 *   "entity":[{
	 *      "creator":"操作人(必填; 最大字段长度：30)",
	 *      "sj":"检查时间(必填; 格式(2019-10-10 10:10:10))",
	 *      "jyr":"主讲人(必填; 最大字段长度：30)",
	 *      "cjrs":"参加人数(必填; 最大字段长度：4)",
	 *      "fw":"范围(必填;)",
	 *      "xs":"教育形式(必填;最大字段长度：20)",
	 *      "nr":"教育内容(必填;)",
	 *   }]
	 * }
	 *
	 */
	@ApiOperation("集体教育保存")
	@PostMapping("jtjySave")
	@HystrixCommand
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
	@OpenAPI
	public ResponseMessage<String> jtjySave(HttpServletRequest request, @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, String json) {

		String interfaceId = "/v4/kss/jtjy/jtjySave";

		//通过校验获取查询参数
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
			if(msg.getStatus()!=200) {
				return ResponseMessage.error(msg.getMessage());
			}
			List<JtjyModel> jtjyModel = JSONArray.parseArray(map.get("entity").toString(), JtjyModel.class);
			jtjyModel.get(0).setState("R2");
			jtjyModel.get(0).setJsbh(jsbh);
			jtjyModel.get(0).setCreatetime(new Date());
			ResponseMessage<String> jsswsq = kssServerApis.jtjySave(jtjyModel.get(0));
			if(jsswsq.getStatus() == 200){
				jsswsq.setMessage("保存成功!");
			}else{
				jsswsq.setMessage("服务异常,保存失败!");
			}
			return jsswsq;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.error("保存失败！");
		}
	}
	
    /**
	 * @api {post} /v4/kss/jtjy/jtjyUpdate 
	 * @apiVersion 0.4.0
	 * @apiName jtjyUpdate
	 * @apiGroup g_kss
	 * @apiPermission any
	 * @apiDescription 集体教育修改
	 *
	 * @apiParam {String} appcode 											应用代码(必填)
	 * @apiParam {String} jsbh 												监所编号(必填;最大字段长度：9)
	 * @apiParam {String} json 												保存参数集(必填)
	 *
	 * @apiSuccess {String}result         				                     返回结果
	 * @apiSuccess {String}page         				                     返回页数
	 * @apiSuccess {String}status         				                     返回状态
	 * @apiSuccess {String}timestamp         				                 时间戳
	 *
	 * @apiSuccessExample {json} 返回 (成功):
	 * HTTP/1.1 200 OK
	 * {
	 *   "message": "保存成功!",
	 *   "result": "11000011420191214000011",
	 *   "status": 200,
	 *   "timestamp": 1576308305534
	 * }
	 *
	 * @apiUse CreateError
	 *
	 * @apiExample 请求参数:
	 * appcode:"应用代码（必填）",
	 * jsbh:"监所编号(必填; 最大字段长度：9)",
	 * json:{
	 *   "entity":[{
	 *   	"id":"id(必填; 最大字段长度：23)",
	 *      "updator":"操作人(必填; 最大字段长度：30)",
	 *      "sj":"检查时间(必填; 格式(2019-10-10 10:10:10))",
	 *      "jyr":"主讲人(必填; 最大字段长度：30)",
	 *      "cjrs":"参加人数(必填; 最大字段长度：4)",
	 *      "fw":"范围(必填;)",
	 *      "xs":"教育形式(必填;最大字段长度：20)",
	 *      "nr":"教育内容(必填;)",
	 *   }]
	 * }
	 *
	 */
	@ApiOperation("集体教育修改")
	@PostMapping("jtjyUpdate")
	@HystrixCommand
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
	@OpenAPI
	public ResponseMessage<String> jtjyUpdate(HttpServletRequest request, @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, String json) {

		String interfaceId = "/v4/kss/jtjy/jtjyUpdate";

		//通过校验获取查询参数
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
			if(msg.getStatus()!=200) {
				return ResponseMessage.error(msg.getMessage());
			}
			List<JtjyModel> jtjyModel = JSONArray.parseArray(map.get("entity").toString(), JtjyModel.class);
			jtjyModel.get(0).setState("R2");
			jtjyModel.get(0).setJsbh(jsbh);
			jtjyModel.get(0).setUpdatetime(new Date());
			ResponseMessage<String> jsswsq = kssServerApis.jtjyUpdate(jtjyModel.get(0).getId(),jtjyModel.get(0));
			if(jsswsq.getStatus() == 200){
				jsswsq.setMessage("保存成功!");
			}else{
				jsswsq.setMessage("服务异常,保存失败!");
			}
			return jsswsq;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.error("保存失败！");
		}
	}
}
