/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package awd.mis.servers.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import awd.framework.common.dao.api.CrudDao;
import awd.framework.common.entity.Entity;
import awd.mis.servers.entity.ClassficEntity;

public interface ClassficDao extends CrudDao<ClassficEntity, String> {
	
	List<ClassficEntity> query(Entity queryEntity);

    int count(Entity queryEntity);

	List<ClassficEntity> selectChildNode(@Param("lx") String lx,@Param("parentid") String parentid);

	List<ClassficEntity> selectByParentIdandName(@Param("parentid") String parentid, @Param("name") String name);

	ClassficEntity selectByClassID(@Param("classid") String classid);


}
