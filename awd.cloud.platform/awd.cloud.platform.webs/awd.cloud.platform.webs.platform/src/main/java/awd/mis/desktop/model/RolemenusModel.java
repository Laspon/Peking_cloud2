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
public class RolemenusModel implements Model {

	private java.lang.String id;
	private java.lang.String jsbh;
	private java.lang.String rolecode;
	private java.lang.String rolecodeString;
	private java.lang.String menu;
	private java.lang.String menuString;
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

	public RolemenusModel() {
	}

	public RolemenusModel(java.lang.String id) {
		this.id = id;
	}

	public void setId(java.lang.String value) {
		this.id = value;
	}

	public java.lang.String getId() {
		return this.id;
	}

	public java.lang.String getRolecode() {
		return this.rolecode;
	}

	public void setRolecode(java.lang.String value) {
		this.rolecode = value;
	}

	public java.lang.String getMenu() {
		return this.menu;
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


	public java.lang.String getRolecodeString() {
		return rolecodeString;
	}

	public void setRolecodeString(java.lang.String rolecodeString) {
		this.rolecodeString = rolecodeString;
	}

	public java.lang.String getMenuString() {
		return menuString;
	}

	public void setMenuString(java.lang.String menuString) {
		this.menuString = menuString;
	}

	public java.lang.String getJsbh() {
		return jsbh;
	}

	public void setJsbh(java.lang.String jsbh) {
		this.jsbh = jsbh;
	}
	
	

}
