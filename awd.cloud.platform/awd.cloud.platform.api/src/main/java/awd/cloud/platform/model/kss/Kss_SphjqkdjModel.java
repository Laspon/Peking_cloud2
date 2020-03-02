/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package awd.cloud.platform.model.kss;

import awd.cloud.platform.model.Model;
import javax.validation.constraints.NotNull;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 
 * @version 1.0
 * @since 1.0
 */


public class Kss_SphjqkdjModel implements Model{	
	
	//columns START
	
	private java.lang.String id;

	
	private java.lang.String jsbh;
	
	private java.lang.String rybh;
	
	private java.lang.String hjrid;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date hjkssj;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date hjjssj;
	
	private java.lang.String bhjrdd;
	
	private java.lang.String bhjrbx;
	
	private java.lang.String hjrdd;
	
	private java.lang.String hjrbx;
	
	private java.lang.String jsyy;
	
	private java.lang.String hjlx;
	
	private java.lang.String state;
	
	private java.lang.String creator;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createtime;
	
	private java.lang.String updator;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date updatetime;
	//columns END

	 

	public Kss_SphjqkdjModel(){
	}
	public Kss_SphjqkdjModel(String id) {
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
	public java.lang.String getRybh() {
		return this.rybh;
	}
	
	public void setRybh(java.lang.String value) {
		this.rybh = value;
	}
	public java.lang.String getHjrid() {
		return this.hjrid;
	}
	
	public void setHjrid(java.lang.String value) {
		this.hjrid = value;
	}
	
	public java.util.Date getHjkssj() {
		return this.hjkssj;
	}
	
	public void setHjkssj(java.util.Date value) {
		this.hjkssj = value;
	}
	
	
	public java.util.Date getHjjssj() {
		return this.hjjssj;
	}
	
	public void setHjjssj(java.util.Date value) {
		this.hjjssj = value;
	}
	
	public java.lang.String getBhjrdd() {
		return this.bhjrdd;
	}
	
	public void setBhjrdd(java.lang.String value) {
		this.bhjrdd = value;
	}
	public java.lang.String getBhjrbx() {
		return this.bhjrbx;
	}
	
	public void setBhjrbx(java.lang.String value) {
		this.bhjrbx = value;
	}
	public java.lang.String getHjrdd() {
		return this.hjrdd;
	}
	
	public void setHjrdd(java.lang.String value) {
		this.hjrdd = value;
	}
	public java.lang.String getHjrbx() {
		return this.hjrbx;
	}
	
	public void setHjrbx(java.lang.String value) {
		this.hjrbx = value;
	}
	public java.lang.String getJsyy() {
		return this.jsyy;
	}
	
	public void setJsyy(java.lang.String value) {
		this.jsyy = value;
	}
	public java.lang.String getHjlx() {
		return this.hjlx;
	}
	
	public void setHjlx(java.lang.String value) {
		this.hjlx = value;
	}
	public java.lang.String getState() {
		return this.state;
	}
	
	public void setState(java.lang.String value) {
		this.state = value;
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

