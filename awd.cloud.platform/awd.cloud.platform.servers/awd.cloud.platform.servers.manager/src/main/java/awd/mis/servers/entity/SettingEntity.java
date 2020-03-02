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
import awd.framework.common.utils.ApplicationContextHolder;
import awd.framework.expands.redisclient.RedisUtils;
import awd.mis.servers.tools.CacheUtils;



/**
 * @author 
 * @version 1.0
 * @since 1.0
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SettingEntity extends SimpleGenericEntity<String> {
	//alias
	public static final String TABLE_ALIAS = "应用设置";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_APPCODE = "应用编号";
	public static final String ALIAS_PROGROUP = "分组名称";
	public static final String ALIAS_PROTYPE = "属性类型";
	public static final String ALIAS_PRONAME = "属性名称";
	public static final String ALIAS_PROLIST = "属性值列表";
	public static final String ALIAS_PROVALUE = "属性值";
	public static final String ALIAS_CREATOR = "创建人";
	public static final String ALIAS_CREATETIME = "创建时间";
	public static final String ALIAS_UPDATOR = "更新人";
	public static final String ALIAS_UPDATETIME = "更新时间";
	
	//date formats
	public static final String FORMAT_TIMETS = TIMESTAMP_FORMAT;
	//保存组（不需要id验证）
	public static interface SaveGroup {};  
	//新增组（需要id验证）
	public static interface UpdateGroup {};
	//所有组
	@GroupSequence({SaveGroup.class, UpdateGroup.class})  
	public interface All {       
	} 

	//columns START

	@NotNull(message="应用编号不能为空",groups=SaveGroup.class)
    @Length(max=50,message="应用编号最大长度50位" ,groups=SaveGroup.class)
	private java.lang.String appcode;
	@NotNull(message="分组名称不能为空",groups=SaveGroup.class)
    @Length(max=50,message="分组名称最大长度50位" ,groups=SaveGroup.class)
	private java.lang.String progroup;
	@NotNull(message="属性类型不能为空",groups=SaveGroup.class)
    @Length(max=1,message="属性类型最大长度1位" ,groups=SaveGroup.class)
	private java.lang.String protype;
	@NotNull(message="属性名称不能为空",groups=SaveGroup.class)
    @Length(max=50,message="属性名称最大长度50位" ,groups=SaveGroup.class)
	private java.lang.String proname;
    @Length(max=4000,message="属性值列表最大长度4000位" ,groups=SaveGroup.class)
	private java.lang.String prolist;
    @Length(max=200,message="属性值最大长度200位" ,groups=SaveGroup.class)
	private java.lang.String provalue;
	@NotNull(message="创建人不能为空",groups=SaveGroup.class)
    @Length(max=50,message="创建人最大长度50位" ,groups=SaveGroup.class)
	private java.lang.String creator;
	@NotNull(message="创建时间不能为空",groups=SaveGroup.class)
    @Length(max=11,message="创建时间最大长度11位" ,groups=SaveGroup.class)
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")  
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createtime;
    @Length(max=50,message="更新人最大长度50位" ,groups=SaveGroup.class)
	private java.lang.String updator;
    @Length(max=11,message="更新时间最大长度11位" ,groups=SaveGroup.class)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")  
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date updatetime;
	//columns END


	public SettingEntity(){
	}

	public SettingEntity(
		java.lang.String id
	){
		super.setId(id);
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
	
	public java.lang.String getProgroup() {
		return this.progroup;
	}
	
	public void setProgroup(java.lang.String value) {
		this.progroup = value;
	}
	
	public java.lang.String getProtype() {
		return this.protype;
	}
	
	public void setProtype(java.lang.String value) {
		this.protype = value;
	}
	
	public java.lang.String getProname() {
		return this.proname;
	}
	
	public void setProname(java.lang.String value) {
		this.proname = value;
	}
	
	public java.lang.String getProlist() {
		return this.prolist;
	}
	
	public void setProlist(java.lang.String value) {
		this.prolist = value;
	}
	
	public java.lang.String getProvalue() {
		return this.provalue;
	}
	
	public void setProvalue(java.lang.String value) {
		this.provalue = value;
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
	
	
	
}

