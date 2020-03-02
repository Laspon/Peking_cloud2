/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package awd.mis.desktop.model;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsappModel implements Model {
	private java.lang.String id;
	private java.lang.String jsbh;
	private java.lang.String jsbhString;
	private java.lang.String appcode;
	private java.lang.String appcodeString;
	private java.lang.String creator;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")  
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createtime;
	private java.lang.String updator;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")  
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date updatetime;
	// columns END

	public JsappModel() {
	}

	public JsappModel(java.lang.String id) {
		this.id = id;
	}

	public void setId(java.lang.String value) {
		this.id = value;
	}

	public java.lang.String getId() {
		return this.id;
	}

	public java.lang.String getJsbh() {
		return this.jsbh;
	}

	public void setJsbh(java.lang.String value) {
		this.jsbh = value;
	}

	public java.lang.String getAppcode() {
		return this.appcode;
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

	public java.lang.String getJsbhString() {
		return jsbhString;
	}

	public void setJsbhString(java.lang.String jsbhString) {
		this.jsbhString = jsbhString;
	}

	public java.lang.String getAppcodeString() {
		return appcodeString;
	}

	public void setAppcodeString(java.lang.String appcodeString) {
		this.appcodeString = appcodeString;
	}
	
	

}
