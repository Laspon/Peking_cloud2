/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package awd.cloud.platform.servers.analyse.model.kss;

import awd.framework.common.model.Model;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 
 * @version 1.0
 * @since 1.0
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class YzmxModel implements Model {
	
	//columns START
	
	private String id;


	private String jsbh;

	private String ypbh;

	private String yzbh;

	private Byte cs;

	private Short sl;

	private String fyjg;

	private String fyzysx;

	private String state;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createtime;

	private String creator;

	private String updator;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date updatetime;

	private String dw;
	//columns END



	public YzmxModel(){
	}
	public YzmxModel(String id) {
		this.id = id;
	}


	public void setId(String value) {
		this.id = value;
	}

	public String getId() {
		return this.id;
	}

	public String getJsbh() {
		return this.jsbh;
	}

	public void setJsbh(String value) {
		this.jsbh = value;
	}
	public String getYpbh() {
		return this.ypbh;
	}

	public void setYpbh(String value) {
		this.ypbh = value;
	}
	public String getYzbh() {
		return this.yzbh;
	}

	public void setYzbh(String value) {
		this.yzbh = value;
	}
	public Byte getCs() {
		return this.cs;
	}

	public void setCs(Byte value) {
		this.cs = value;
	}
	public Short getSl() {
		return this.sl;
	}

	public void setSl(Short value) {
		this.sl = value;
	}
	public String getFyjg() {
		return this.fyjg;
	}

	public void setFyjg(String value) {
		this.fyjg = value;
	}
	public String getFyzysx() {
		return this.fyzysx;
	}

	public void setFyzysx(String value) {
		this.fyzysx = value;
	}
	public String getState() {
		return this.state;
	}

	public void setState(String value) {
		this.state = value;
	}

	public java.util.Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(java.util.Date value) {
		this.createtime = value;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String value) {
		this.creator = value;
	}
	public String getUpdator() {
		return this.updator;
	}

	public void setUpdator(String value) {
		this.updator = value;
	}

	public java.util.Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(java.util.Date value) {
		this.updatetime = value;
	}

	public String getDw() {
		return this.dw;
	}

	public void setDw(String value) {
		this.dw = value;
	}
	 
}

