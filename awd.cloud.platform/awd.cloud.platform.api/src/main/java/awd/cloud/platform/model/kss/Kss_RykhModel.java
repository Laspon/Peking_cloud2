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


public class Kss_RykhModel implements Model{	
	
	//columns START
	
	private java.lang.String id;

	
	private java.lang.String rybh;
	
	private java.lang.String jsbh;
	
	private java.lang.String khxdm;
	
	private java.lang.String khr;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date khsj;
	
	private java.lang.String khmk;
	
	private java.lang.String khmkid;
	
	private java.lang.String khmkcontent;
	
	private java.lang.String jkflx;
	
	private java.math.BigDecimal jkfs;
	
	private java.math.BigDecimal cygljkfs;
	
	private java.math.BigDecimal fxpgjkfs;
	
	private java.lang.String sftg;
	
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

	 

	public Kss_RykhModel(){
	}
	public Kss_RykhModel(String id) {
		this.id = id;
	}
	

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}
	
	public java.lang.String getRybh() {
		return this.rybh;
	}
	
	public void setRybh(java.lang.String value) {
		this.rybh = value;
	}
	public java.lang.String getJsbh() {
		return this.jsbh;
	}
	
	public void setJsbh(java.lang.String value) {
		this.jsbh = value;
	}
	public java.lang.String getKhxdm() {
		return this.khxdm;
	}
	
	public void setKhxdm(java.lang.String value) {
		this.khxdm = value;
	}
	public java.lang.String getKhr() {
		return this.khr;
	}
	
	public void setKhr(java.lang.String value) {
		this.khr = value;
	}
	
	public java.util.Date getKhsj() {
		return this.khsj;
	}
	
	public void setKhsj(java.util.Date value) {
		this.khsj = value;
	}
	
	public java.lang.String getKhmk() {
		return this.khmk;
	}
	
	public void setKhmk(java.lang.String value) {
		this.khmk = value;
	}
	public java.lang.String getKhmkid() {
		return this.khmkid;
	}
	
	public void setKhmkid(java.lang.String value) {
		this.khmkid = value;
	}
	public java.lang.String getKhmkcontent() {
		return this.khmkcontent;
	}
	
	public void setKhmkcontent(java.lang.String value) {
		this.khmkcontent = value;
	}
	public java.lang.String getJkflx() {
		return this.jkflx;
	}
	
	public void setJkflx(java.lang.String value) {
		this.jkflx = value;
	}
	public java.math.BigDecimal getJkfs() {
		return this.jkfs;
	}
	
	public void setJkfs(java.math.BigDecimal value) {
		this.jkfs = value;
	}
	public java.math.BigDecimal getCygljkfs() {
		return this.cygljkfs;
	}
	
	public void setCygljkfs(java.math.BigDecimal value) {
		this.cygljkfs = value;
	}
	public java.math.BigDecimal getFxpgjkfs() {
		return this.fxpgjkfs;
	}
	
	public void setFxpgjkfs(java.math.BigDecimal value) {
		this.fxpgjkfs = value;
	}
	public java.lang.String getSftg() {
		return this.sftg;
	}
	
	public void setSftg(java.lang.String value) {
		this.sftg = value;
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

