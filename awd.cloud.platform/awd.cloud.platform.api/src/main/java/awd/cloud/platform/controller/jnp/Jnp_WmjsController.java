/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package awd.cloud.platform.controller.jnp;

import awd.cloud.platform.api.KssServerApis;
import awd.cloud.platform.api.KssService;
import awd.cloud.platform.model.kss.Kss_WmjsModel;
import awd.cloud.platform.service.PublicService;
import awd.cloud.platform.utils.*;
import awd.framework.common.utils.OpenAPI;
import awd.framework.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("/v4/jnp/wmjs")
@Api(tags = "jnp-wmjs",description = "Wmjs")
public class Jnp_WmjsController extends PublicService {

	@Autowired
	private KssService kssService;

	@Autowired
	private KssServerApis kssServerApis;


	/**
	 * @api {get} /v4/jnp/wmjs/wmjsQuery 文明监室查询
	 * @apiVersion 0.4.0
	 * @apiName wmjsQuery
	 * @apiGroup g_jnp
	 * @apiPermission any
	 * @apiDescription 文明监室查询
	 *
	 * @apiParam {String} appcode 											 应用代码（必填）
	 * @apiParam {String} jsbh 												 监所编号(必填；最大字段长度：9)
	 * @apiParam {String} json 											     查询参数集(必填)


	 * @apiSuccess {String} jsh 											 监室号
	 * @apiSuccess {String} wmjs         				                     是否是文明监室(字典:SHFO)
	 * @apiSuccess {String} wmjsString        				                 是否是文明，监室字典转换后
	 * @apiSuccess {String}message         				                     返回信息
	 * @apiSuccess {String}result         				                     返回结果
	 * @apiSuccess {String}total         				                     返回数量
	 * @apiSuccess {String}date         				                     返回数据
	 * @apiSuccess {String}page         				                     返回页数
	 * @apiSuccess {String}status         				                     返回状态
	 * @apiSuccess {String}timestamp         				                 时间戳
	 *
	 *
	 * @apiSuccessExample {json} 返回 (成功):
	 * HTTP/1.1 200 OK
	 * {
	 *   "message": "查询成功",
	 *   "result": {
	 *     "total": 238,
	 *     "data": [
	 *       {
	 *         "wmjs": "0",
	 *         "wmjsString": "否"
	 *       }
	 *     ],
	 *     "page": "1"
	 *   },
	 *   "status": 200,
	 *   "timestamp": 1576465329780
	 * }

	 * @apiUse QueryError
	 *
	 * @apiExample 请求参数:
	 *  appcode:"应用代码(必填)",
	 *  jsbh:"监所编号(必填; 最大字段长度：9)",
	 *  json:{
	 *     "jsh":"监室号(最大字段长度:4)",
	 *     "page":"当前页",
	 *     "pagesize":"一页数据数量"
	 *       }
	 *
	 */
	@OpenAPI
	@ApiOperation("文明监室查询")
	@GetMapping("/wmjsQuery")
	@HystrixCommand
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
	public ResponseMessage<Map<String, Object>> wmjs_query(HttpServletRequest request, @RequestParam(name = "appcode") String appcode, @RequestParam(name = "jsbh") String jsbh, String json) {
		//接口id
		String interfaceId = "/v4/jnp/wmjs/wmjsQuery";
		String state = request.getParameter("state");

		try {
			//通过校验获取查询参数
			ResponseMessage<Map<String, Object>> maps = this.userAuthorizatio(request, json, interfaceId);
			if (maps.getStatus() != 200) {
				return ResponseMessage.error(maps.getMessage());
			}
			//查询参数
			QueryParam param = new QueryParam();
			if(!StringUtils.isNullOrEmpty(jsbh)) {
				param.and("jsbh", TermType.eq, jsbh);
			}

			if (!StringUtils.isNullOrEmpty(maps.getResult().get("jsh"))) {
				param.and("jsh", TermType.eq, maps.getResult().get("jsh"));
			}
			DefaultQueryParam.addDefaultQueryParam(request, param, state);
			ResponseMessage<PagerResult<Map<String, Object>>> result = kssServerApis.jsQueryForPage(param);
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
		}catch (Exception e){
			e.printStackTrace();
			return ResponseMessage.error("查询失败！");
		}
	}



	@ApiOperation("新增")
	@PostMapping
	@HystrixCommand
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
	@OpenAPI
	public ResponseMessage<String> wmjs_save( @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, @RequestParam(name = "user")String user,@RequestBody Kss_WmjsModel data) {
		return kssService.wmjs_save(data);
	}




	@ApiOperation("根据id更新")
	@PutMapping(path = {"/{id:.+}"})
	@HystrixCommand
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
	@OpenAPI
	public ResponseMessage<String> wmjs_updateByKey(@PathVariable String id, @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, @RequestParam(name = "user")String user,@RequestBody Kss_WmjsModel data) {
		return kssService.wmjs_updateByKey(id, data);
	}


	@OpenAPI
	public ResponseMessage<Kss_WmjsModel> wmjs_getByKey(@PathVariable String id, @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, @RequestParam(name = "user")String user) {
		return kssService.wmjs_getByKey(id);
	}



	@OpenAPI
	public ResponseMessage<Integer> wmjs_deleteByKey(@PathVariable String id, @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, @RequestParam(name = "user")String user) {
		return kssService.wmjs_deleteByKey(id);
	}
}
