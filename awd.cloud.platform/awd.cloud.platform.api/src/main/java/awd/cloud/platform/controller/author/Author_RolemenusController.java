/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package awd.cloud.platform.controller.author;
import javax.servlet.http.HttpServletRequest;

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

import awd.cloud.platform.api.ManagerService;
import awd.cloud.platform.model.manager.Manager_RolemenusModel;
import awd.cloud.platform.utils.PagerResult;
import awd.cloud.platform.utils.QueryParam;
import awd.cloud.platform.utils.ResponseMessage;
import awd.framework.common.utils.OpenAPI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RefreshScope
@RequestMapping("/v4/author/rolemenus")
@Api(tags = "manager-rolemenus",description = "Rolemenus") 
public class Author_RolemenusController {
	
	@Autowired
    private ManagerService managerService;

	/**
	 * @api {get} /author/rolemenus rolemenus_query
	 * @apiVersion 0.4.0
	 * @apiName rolemenus_query
	 * @apiGroup g_base
	 * @apiPermission user
	 *
	 * @apiDescription Rolemenus分页查询.
	 *
	 * @apiParam {String} appcode 											应用代码
	 * @apiParam {String} jsbh 												监所编号
	 * @apiParam {String} user 												登录名
	 * @apiParam {String} page 												页码
	 * @apiParam {String} param 											请求参数
	 *
	 * @apiSuccess {String} id         				ID
	 * @apiSuccess {String} rolecode         				角色代码
	 * @apiSuccess {String} jsbh         				jsbh
	 * @apiSuccess {String} menu         				菜单代码
	 * @apiSuccess {String} creator         				创建人
	 * @apiSuccess {String} createtime         				创建时间
	 * @apiSuccess {String} updator         				更新人
	 * @apiSuccess {String} updatetime         				更新时间
	 *
	 * @apiUse QueryError
	 */
	@OpenAPI
	@ApiOperation("分页查询")
	@GetMapping
	@HystrixCommand
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
	public ResponseMessage<PagerResult<Manager_RolemenusModel>> rolemenus_query(HttpServletRequest request, @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, @RequestParam(name = "user")String user) {
		QueryParam queryParam = new QueryParam();
        ResponseMessage<PagerResult<Manager_RolemenusModel>> result= managerService.rolemenus_query(queryParam);
        if(result.getStatus()==200) {
            result.setMessage("查询成功");
            if(result.getResult()==null) {
                result.setMessage("未查询数据");
            }
        }
        return result;
	}
	
	
	/**
	 * @api {post} /author/rolemenus rolemenus_save
	 * @apiVersion 0.4.0
	 * @apiName rolemenus_save
	 * @apiGroup g_base
	 * @apiPermission user
	 *
	 * @apiDescription Rolemenus自定义查询.
	 *
	 * @apiParam {String} appcode 											应用代码
	 * @apiParam {String} jsbh 												监所编号	
	 * @apiParam {String} user  											登录名
	 * 
	 * @apiParam {String} id         				ID
	 * @apiParam {String} rolecode         				角色代码
	 * @apiParam {String} jsbh         				jsbh
	 * @apiParam {String} menu         				菜单代码
	 * @apiParam {String} creator         				创建人
	 * @apiParam {String} createtime         				创建时间
	 * @apiParam {String} updator         				更新人
	 * @apiParam {String} updatetime         				更新时间
	 *
	 * @apiSuccess {String} message         				成功信息
	 * @apiSuccess {String} result         					生成的主键信息
	 * @apiSuccess {String} status         					请求状态
	 * @apiSuccess {String} timestamp         				时间戳 
	 *
	 * @apiUse CreateError
	 */
	@ApiOperation("新增")
	@PostMapping
	@HystrixCommand
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
	@OpenAPI
	public ResponseMessage<String> rolemenus_save(@RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, @RequestParam(name = "user")String user,@RequestBody Manager_RolemenusModel data) {
		return managerService.rolemenus_save(data);
	}
	
	

	/**
	 * @api {patch} /author/rolemenus rolemenus_updateByKey
	 * @apiVersion 0.4.0
	 * @apiName rolemenus_updateByKey
	 * @apiGroup g_base
	 * @apiPermission user
	 *
	 * @apiDescription Rolemenus数据更新.
	 *
	 * @apiParam {String} appcode 											应用代码
	 * @apiParam {String} jsbh 												监所编号
	 * @apiParam {String} user 												登录名
	 *  
	 * @apiParam {String} id         				ID
	 * @apiParam {String} rolecode         				角色代码
	 * @apiParam {String} jsbh         				jsbh
	 * @apiParam {String} menu         				菜单代码
	 * @apiParam {String} creator         				创建人
	 * @apiParam {String} createtime         				创建时间
	 * @apiParam {String} updator         				更新人
	 * @apiParam {String} updatetime         				更新时间
	 *
	 * @apiSuccess {String} message         				成功信息
	 * @apiSuccess {String} result         					生成的主键信息
	 * @apiSuccess {String} status         					请求状态
	 * @apiSuccess {String} timestamp         				时间戳 
	 *
	 * @apiUse UpdateError
	 */
	@ApiOperation("根据id更新")
	@PutMapping(path = {"/{id:.+}"})
	@HystrixCommand
	@ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
	@OpenAPI
	public ResponseMessage rolemenus_updateByKey(@PathVariable String id, @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, @RequestParam(name = "user")String user,@RequestBody Manager_RolemenusModel data) {
		return managerService.rolemenus_updateByKey(id, data);
	}	

	/**
	 * @api {get} /author/rolemenus/{id} rolemenus_getByKey
	 * @apiVersion 0.4.0
	 * @apiName rolemenus_getByKey
	 * @apiGroup g_base
	 * @apiPermission user
	 *
	 * @apiDescription Rolemenus根据key获取信息.
	 *
	 * @apiParam {String} appcode 											应用代码
	 * @apiParam {String} jsbh 												监所编号
	 * @apiParam {String} user 												登录名
	 *
	 * @apiSuccess {String} id         				ID
	 * @apiSuccess {String} rolecode         				角色代码
	 * @apiSuccess {String} jsbh         				jsbh
	 * @apiSuccess {String} menu         				菜单代码
	 * @apiSuccess {String} creator         				创建人
	 * @apiSuccess {String} createtime         				创建时间
	 * @apiSuccess {String} updator         				更新人
	 * @apiSuccess {String} updatetime         				更新时间
	 *
	 * @apiUse QueryError
	 */
	@OpenAPI
	public ResponseMessage<Manager_RolemenusModel> rolemenus_getByKey(@PathVariable String id, @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, @RequestParam(name = "user")String user) {
		return managerService.rolemenus_getByKey(id);
	}
	
	
	/**
	 * @api {delete} /author/rolemenus/{id} rolemenus_deleteByKey
	 * @apiVersion 0.4.0
	 * @apiName rolemenus_deleteByKey
	 * @apiGroup g_base
	 * @apiPermission user
	 *
	 * @apiDescription Rolemenus数据删除.
	 *
	 * @apiParam {String} id 												数据编号
	 * @apiParam {String} appcode 											应用代码
	 * @apiParam {String} jsbh 												监所编号
	 * @apiParam {String} user 												登录名
	 * 
	 * @apiParam {String} id         				ID
	 * @apiParam {String} rolecode         				角色代码
	 * @apiParam {String} jsbh         				jsbh
	 * @apiParam {String} menu         				菜单代码
	 * @apiParam {String} creator         				创建人
	 * @apiParam {String} createtime         				创建时间
	 * @apiParam {String} updator         				更新人
	 * @apiParam {String} updatetime         				更新时间
	 *
	 * @apiSuccess {String} message         				成功信息
	 * @apiSuccess {String} result         					删除记录数
	 * @apiSuccess {String} status         					请求状态
	 * @apiSuccess {String} timestamp         				时间戳 
	 *
	 * @apiUse UpdateError
	 */
	@OpenAPI
	public ResponseMessage<Integer> rolemenus_deleteByKey(@PathVariable String id, @RequestParam(name = "appcode")String appcode, @RequestParam(name = "jsbh")String jsbh, @RequestParam(name = "user")String user) {
		
		return managerService.rolemenus_deleteByKey(id);
	}
}
