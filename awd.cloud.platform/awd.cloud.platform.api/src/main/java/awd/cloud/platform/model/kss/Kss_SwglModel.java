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


public class Kss_SwglModel implements Model{	
	
	//columns START
	
	private java.lang.String id;

	
	private java.lang.String rybh;
	
	private java.lang.String jsbh;
	
	private java.lang.String jsh;
	
	private java.lang.String swqk;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date swrq;
	
	private java.lang.String cbr;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date dcrq;
	
	private java.lang.String dcjgou;
	
	private java.lang.String dcjguo;
	
	private java.lang.String jyclyj;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date clsj;
	
	private java.lang.String clfs;
	
	private java.lang.String jlr;
	
	private java.lang.String bz;
	
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

	 

	public Kss_SwglModel(){
	}
	public Kss_SwglModel(String id) {
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
	public java.lang.String getJsh() {
		return this.jsh;
	}
	
	public void setJsh(java.lang.String value) {
		this.jsh = value;
	}
	public java.lang.String getSwqk() {
		return this.swqk;
	}
	
	public void setSwqk(java.lang.String value) {
		this.swqk = value;
	}
	
	public java.util.Date getSwrq() {
		return this.swrq;
	}
	
	public void setSwrq(java.util.Date value) {
		this.swrq = value;
	}
	
	public java.lang.String getCbr() {
		return this.cbr;
	}
	
	public void setCbr(java.lang.String value) {
		this.cbr = value;
	}
	
	public java.util.Date getDcrq() {
		return this.dcrq;
	}
	
	public void setDcrq(java.util.Date value) {
		this.dcrq = value;
	}
	
	public java.lang.String getDcjgou() {
		return this.dcjgou;
	}
	
	public void setDcjgou(java.lang.String value) {
		this.dcjgou = value;
	}
	public java.lang.String getDcjguo() {
		return this.dcjguo;
	}
	
	public void setDcjguo(java.lang.String value) {
		this.dcjguo = value;
	}
	public java.lang.String getJyclyj() {
		return this.jyclyj;
	}
	
	public void setJyclyj(java.lang.String value) {
		this.jyclyj = value;
	}
	
	public java.util.Date getClsj() {
		return this.clsj;
	}
	
	public void setClsj(java.util.Date value) {
		this.clsj = value;
	}
	
	public java.lang.String getClfs() {
		return this.clfs;
	}
	
	public void setClfs(java.lang.String value) {
		this.clfs = value;
	}
	public java.lang.String getJlr() {
		return this.jlr;
	}
	
	public void setJlr(java.lang.String value) {
		this.jlr = value;
	}
	public java.lang.String getBz() {
		return this.bz;
	}
	
	public void setBz(java.lang.String value) {
		this.bz = value;
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

