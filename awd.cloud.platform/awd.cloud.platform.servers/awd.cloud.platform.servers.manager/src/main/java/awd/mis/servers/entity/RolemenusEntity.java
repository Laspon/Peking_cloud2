/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package awd.mis.servers.entity;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import awd.framework.common.entity.SimpleGenericEntity;
import awd.mis.servers.entity.UsermenuEntity.SaveGroup;
import awd.mis.servers.tools.CacheUtils;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RolemenusEntity extends SimpleGenericEntity<String> {
	// alias
	public static final String TABLE_ALIAS = "角色菜单";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_ROLECODE = "角色代码";
	public static final String ALIAS_MENU = "菜单代码";
	public static final String ALIAS_CREATOR = "创建人";
	public static final String ALIAS_CREATETIME = "创建时间";
	public static final String ALIAS_UPDATOR = "更新人";
	public static final String ALIAS_UPDATETIME = "更新时间";

	// date formats
	public static final String FORMAT_CREATETIME = DATE_FORMAT;
	public static final String FORMAT_UPDATETIME = DATE_FORMAT;

	// 保存组（不需要id验证）
	public static interface SaveGroup {
	};

	// 新增组（需要id验证）
	public static interface UpdateGroup {
	};

	// 所有组
	@GroupSequence({ SaveGroup.class, UpdateGroup.class })
	public interface All {
	}

	// columns START

	@NotNull(message = "角色代码不能为空", groups = SaveGroup.class)
	@Length(max = 4, message = "角色代码最大长度4位", groups = SaveGroup.class)
	private java.lang.String rolecode;
	@NotNull(message="应用编号不能为空",groups=SaveGroup.class)
    @Length(max=50,message="应用编号最大长度9位" ,groups=SaveGroup.class)
	private java.lang.String jsbh;
	@NotNull(message = "菜单代码不能为空", groups = SaveGroup.class)
	@Length(max = 10, message = "菜单代码最大长度10位", groups = SaveGroup.class)
	private java.lang.String menu;
	@NotNull(message = "创建人不能为空", groups = SaveGroup.class)
	@Length(max = 50, message = "创建人最大长度50位", groups = SaveGroup.class)
	private java.lang.String creator;

	@NotNull(message = "创建时间不能为空")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")  
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createtime;

	@Length(max = 50, message = "更新人最大长度50位", groups = SaveGroup.class)
	private java.lang.String updator;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")  
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date updatetime;

	// columns END

	public RolemenusEntity() {
	}

	public RolemenusEntity(java.lang.String id) {
		super.setId(id);
	}

	public java.lang.String getRolecode() {
		return this.rolecode;
	}
	
	public java.lang.String getRolecodeString() {
		return CacheUtils.get().getRole(this.rolecode);
	}

	public void setRolecode(java.lang.String value) {
		this.rolecode = value;
	}

	public java.lang.String getMenu() {
		return this.menu;
	}
	
	public java.lang.String getMenuString() {
		return CacheUtils.get().getMenu(this.menu);
	}

	public void setMenu(java.lang.String value) {
		this.menu = value;
	}

	public java.lang.String getCreator() {
		return this.creator;
	}

	public void setCreator(java.lang.String value) {
		this.creator = value;
	}


	public java.util.Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(java.util.Date value) {
		this.createtime = value;
	}

	public java.lang.String getUpdator() {
		return this.updator;
	}

	public void setUpdator(java.lang.String value) {
		this.updator = value;
	}


	public java.util.Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(java.util.Date value) {
		this.updatetime = value;
	}

	public java.lang.String getJsbh() {
		return jsbh;
	}

	public void setJsbh(java.lang.String jsbh) {
		this.jsbh = jsbh;
	}
	
	

}
