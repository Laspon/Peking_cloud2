/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package awd.cloud.platform.webs.charts.modal;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import awd.cloud.platform.webs.charts.utils.Model;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupsModel implements Model{
	private java.lang.String id;
	private java.lang.String jsbh;
	private java.lang.String jsbhString;
	private java.lang.String fgroup;
	private java.lang.String fgroupString;
	private java.lang.String groupname;
	private java.lang.String creator;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date createtime;
	private java.lang.String createtimeString;
	private java.lang.String updator;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date updatetime;
	private java.lang.String updatetimeString;
	// columns END

	public GroupsModel() {
	}

	public GroupsModel(java.lang.String id) {
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

	public java.lang.String getFgroup() {
		return this.fgroup;
	}

	public void setFgroup(java.lang.String value) {
		this.fgroup = value;
	}

	public java.lang.String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(java.lang.String value) {
		this.groupname = value;
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

	public java.lang.String getCreatetimeString() {
		return createtimeString;
	}

	public void setCreatetimeString(java.lang.String createtimeString) {
		this.createtimeString = createtimeString;
	}

	public java.lang.String getUpdatetimeString() {
		return updatetimeString;
	}

	public void setUpdatetimeString(java.lang.String updatetimeString) {
		this.updatetimeString = updatetimeString;
	}

	public java.lang.String getJsbhString() {
		return jsbhString;
	}

	public void setJsbhString(java.lang.String jsbhString) {
		this.jsbhString = jsbhString;
	}

	public java.lang.String getFgroupString() {
		return fgroupString;
	}

	public void setFgroupString(java.lang.String fgroupString) {
		this.fgroupString = fgroupString;
	}
	
	

}
