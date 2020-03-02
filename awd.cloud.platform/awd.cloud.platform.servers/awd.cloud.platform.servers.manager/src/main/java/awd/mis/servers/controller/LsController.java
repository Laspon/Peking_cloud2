/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package awd.mis.servers.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ace.cache.annotation.Cache;
import com.ace.cache.annotation.CacheClear;

import awd.framework.common.controller.GenericEntityController;
import awd.framework.common.controller.message.ResponseMessage;
import awd.framework.common.entity.PagerResult;
import awd.framework.common.entity.param.QueryParamEntity;
import awd.framework.common.service.api.CrudService;
import awd.framework.common.utils.OpenAPI;
import awd.framework.expands.logging.AccessLogger;
import awd.mis.servers.entity.LsEntity;
import awd.mis.servers.service.LsService;
import awd.mis.servers.tools.CacheKeyGenerator;
import awd.mis.servers.tools.CachePageKeyGenerator;
import awd.mis.servers.tools.CacheKeyGenerator.ResultCacheResultParser;
import io.swagger.annotations.Api;


@RestController
@RefreshScope
@RequestMapping("/ls")
@AccessLogger("律师")
@Api(tags = "awd-ls", description = "提供律师信息管理功能")
public class LsController implements GenericEntityController<LsEntity, String, QueryParamEntity, LsEntity> {

	private LsService lsService;


	@Override
    public LsEntity modelToEntity(LsEntity model, LsEntity entity) {
        return model;
    }

    @Autowired
    public void setLsService(LsService lsService) {
        this.lsService = lsService;
    }
	 
	@Override
	public CrudService<LsEntity, String> getService() {
		return lsService;
	}

	@Override
	@OpenAPI
	public ResponseMessage<PagerResult<LsEntity>> list(HttpServletRequest arg0, QueryParamEntity arg1) {
		return GenericEntityController.super.list(arg0, arg1);
	}

	@Override
	@OpenAPI
	public ResponseMessage<String> saveOrUpdate(@RequestBody LsEntity data) {
		return GenericEntityController.super.saveOrUpdate(data);
	}

	@Override
	@OpenAPI
	public ResponseMessage updateByPrimaryKey(@PathVariable String id, @RequestBody LsEntity data) {
		return GenericEntityController.super.updateByPrimaryKey(id, data);
	}

	@Override
	@OpenAPI
	public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable String id) {
		return GenericEntityController.super.deleteByPrimaryKey(id);
	}

	@Override
	@OpenAPI
	public ResponseMessage<String> save(@RequestBody LsEntity data) {
		return GenericEntityController.super.save(data);
	}

	@Override
	@OpenAPI
	public ResponseMessage<LsEntity> getByPrimaryKey(@PathVariable String id) {
		return GenericEntityController.super.getByPrimaryKey(id);
	}
	
	

}
