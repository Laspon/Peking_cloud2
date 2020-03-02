/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package awd.mis.servers.dao;

import java.util.List;
import java.util.Map;

import awd.framework.common.dao.api.CrudDao;
import awd.framework.common.entity.Entity;
import awd.mis.servers.entity.ZirisEntity;

public interface ZirisDao extends CrudDao<ZirisEntity, String> {
	
	List<ZirisEntity> query(Entity queryEntity);

    int count(Entity queryEntity);
    
	/**
	 * 循环查找表字段是否含有rybh，有的话就自动生成jbxxList 方法，没有就不生成
	 */
	
    List<Map<String, Object>> jbxxlist(Entity queryEntity);
    
    int jbxxcount(Entity queryEntity);

}
