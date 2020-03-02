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
import awd.mis.servers.tools.CacheUtils;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsappEntity extends SimpleGenericEntity<String> {
	// alias
	public static final String TABLE_ALIAS = "监所APP";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_JSBH = "角色代码";
	public static final String ALIAS_APPCODE = "应用代码";
	public static final String ALIAS_CREATOR = "创建人";
	public static final String ALIAS_CREATETIME = "创建时间";
	public static final String ALIAS_UPDATOR = "更新人";
	public static final String ALIAS_UPDATETIME = "更新时间";

	// date formats

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
	@Length(max = 9, message = "角色代码最大长度9位", groups = SaveGroup.class)
	private java.lang.String jsbh;
	@NotNull(message = "应用代码不能为空", groups = SaveGroup.class)
	@Length(max = 50, message = "应用代码最大长度50位", groups = SaveGroup.class)
	private java.lang.String appcode;
	@NotNull(message = "创建人不能为空", groups = SaveGroup.class)
	@Length(max = 50, message = "创建人最大长度50位", groups = SaveGroup.class)
	private java.lang.String creator;
	@NotNull(message = "创建时间不能为空", groups = SaveGroup.class)
	@Length(max = 11, message = "创建时间最大长度11位", groups = SaveGroup.class)
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")  
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createtime;
	@Length(max = 50, message = "更新人最大长度50位", groups = SaveGroup.class)
	private java.lang.String updator;
	@Length(max = 11, message = "更新时间最大长度11位", groups = SaveGroup.class)
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")  
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date updatetime;
	// columns END

	public JsappEntity() {
	}

	public JsappEntity(java.lang.String id) {
		super.setId(id);
	}

	public java.lang.String getJsbh() {
		return this.jsbh;
	}
	public java.lang.String getJsbhString(){
		return  CacheUtils.get().getJsbhString(this.jsbh);
	}

	public void setJsbh(java.lang.String value) {
		this.jsbh = value;
	}

	public java.lang.String getAppcode() {
		return this.appcode;
	}
	
	public java.lang.String getAppcodeString() {
		return CacheUtils.get().getApp(this.appcode);
	}
	public void setAppcode(java.lang.String value) {
		this.appcode = value;
	}

	public java.lang.String getCreator() {
		return this.creator;
	}

	public void setCreator(java.lang.String value) {
		this.creator = value;
	}

	public java.util.Date  getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(java.util.Date  value) {
		this.createtime = value;
	}
	

	public java.lang.String getUpdator() {
		return this.updator;
	}

	public void setUpdator(java.lang.String value) {
		this.updator = value;
	}

	public java.util.Date  getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(java.util.Date  value) {
		this.updatetime = value;
	}
	

}
