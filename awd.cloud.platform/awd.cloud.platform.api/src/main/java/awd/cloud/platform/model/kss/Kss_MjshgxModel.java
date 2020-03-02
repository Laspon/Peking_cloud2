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


public class Kss_MjshgxModel implements Model{	
	
	//columns START
	
	private java.lang.String id;

	
	private java.lang.String jsbh;
	
	private java.lang.String jh;
	
	private java.lang.String gx;
	
	private java.lang.String gxrxm;
	
	private java.lang.String gxrzzmm;
	
	private java.lang.String gxrlxdh;
	
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
	
	private java.lang.String gxrgzdw;
	//columns END

	 

	public Kss_MjshgxModel(){
	}
	public Kss_MjshgxModel(String id) {
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
	public java.lang.String getJh() {
		return this.jh;
	}
	
	public void setJh(java.lang.String value) {
		this.jh = value;
	}
	public java.lang.String getGx() {
		return this.gx;
	}
	
	public void setGx(java.lang.String value) {
		this.gx = value;
	}
	public java.lang.String getGxrxm() {
		return this.gxrxm;
	}
	
	public void setGxrxm(java.lang.String value) {
		this.gxrxm = value;
	}
	public java.lang.String getGxrzzmm() {
		return this.gxrzzmm;
	}
	
	public void setGxrzzmm(java.lang.String value) {
		this.gxrzzmm = value;
	}
	public java.lang.String getGxrlxdh() {
		return this.gxrlxdh;
	}
	
	public void setGxrlxdh(java.lang.String value) {
		this.gxrlxdh = value;
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
	
	public java.lang.String getGxrgzdw() {
		return this.gxrgzdw;
	}
	
	public void setGxrgzdw(java.lang.String value) {
		this.gxrgzdw = value;
	}
	 
}

