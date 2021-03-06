/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */


package awd.cloud.platform.webs.charts.modal.jls;

import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import awd.bj.base.model.Model;

/**
 * @author 
 * @version 1.0
 * @since 1.0
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotosModel implements Model{
	
	//alias
	public static final String TABLE_ALIAS = "Photos";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_JSBH = "监所编号";
	public static final String ALIAS_RYBH = "人员编号";
	public static final String ALIAS_YWZP = "有无照片(YWZP)";
	public static final String ALIAS_PHOTO = "图片";
	public static final String ALIAS_TYPE = "图片类型";
	public static final String ALIAS_PHOTOURL = "照片URL";
	public static final String ALIAS_BZ = "备注";
	public static final String ALIAS_STATE = "删除状态(YWSTATE)";
	public static final String ALIAS_SCBZ = "上传标志(SHFO)";
	public static final String ALIAS_OPERATOR = "操作人";
	public static final String ALIAS_CREATOR = "创建人";
	public static final String ALIAS_CREATETIME = "创建时间";
	public static final String ALIAS_UPDATOR = "更新人";
	public static final String ALIAS_UPDATETIME = "更新时间";
	
	//columns START
	
	private java.lang.String id;

	
	private java.lang.String jsbh;
	
	private java.lang.String rybh;
	
	private java.lang.String ywzp;
	
	private byte[] photo;
	
	private java.lang.String type;
	
	private java.lang.String photourl;
	
	private java.lang.String bz;
	
	private java.lang.String state;
	
	private java.lang.String scbz;
	
	private java.lang.String operator;
	
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
	//开始生成字典的String属性
	private java.lang.String jsbhString;
	
		
	private java.lang.String ywzpString;
		
	private java.lang.String stateString;
		
	private java.lang.String scbzString;
	//字典的get方法生成结束


	public PhotosModel(){
	}

	public PhotosModel(String jsbh, String creator) {
		this.jsbh = jsbh;
		this.creator = creator;
	}

	public PhotosModel(String id) {
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
	public java.lang.String getYwzp() {
		return this.ywzp;
	}
	
	public void setYwzp(java.lang.String value) {
		this.ywzp = value;
	}
	public byte[] getPhoto() {
		return this.photo;
	}
	
	public void setPhoto(byte[] value) {
		this.photo = value;
	}
	public java.lang.String getType() {
		return this.type;
	}
	
	public void setType(java.lang.String value) {
		this.type = value;
	}
	public java.lang.String getPhotourl() {
		return this.photourl;
	}
	
	public void setPhotourl(java.lang.String value) {
		this.photourl = value;
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
	public java.lang.String getScbz() {
		return this.scbz;
	}
	
	public void setScbz(java.lang.String value) {
		this.scbz = value;
	}
	public java.lang.String getOperator() {
		return this.operator;
	}
	
	public void setOperator(java.lang.String value) {
		this.operator = value;
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
	
	//开始生成字典的getString方法
	public String getJsbhString() {
		return this.jsbhString;
	}
		
	public java.lang.String getYwzpString() {
		return this.ywzpString;
	}

	public void setYwzpString(java.lang.String value) {
		this.ywzpString = value;
	}
		
	public java.lang.String getStateString() {
		return this.stateString;
	}

	public void setStateString(java.lang.String value) {
		this.stateString = value;
	}
		
	public java.lang.String getScbzString() {
		return this.scbzString;
	}

	public void setScbzString(java.lang.String value) {
		this.scbzString = value;
	}
	//字典的get方法生成结束
	 
}

