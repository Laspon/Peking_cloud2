package awd.cloud.platform.model.jwp;

import awd.cloud.platform.utils.Model;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

public class HjyyModel implements Model {
    //columns START

    private String id;


    private String appcode;

    private String jsbh;

    private String jsh;

    private String rybh;

    private String yylx;
    private String yylxString;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date yysj;

    private String spr;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date spsj;

    private String spjg;

    private String spnr;

    private String state;

    private String creator;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createtime;

    private String updator;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date updatetime;
    //columns END



    public HjyyModel(){
    }
    public HjyyModel(String id) {
        this.id = id;
    }


    public void setId(String value) {
        this.id = value;
    }

    public String getId() {
        return this.id;
    }

    public String getAppcode() {
        return this.appcode;
    }

    public void setAppcode(String value) {
        this.appcode = value;
    }
    public String getJsbh() {
        return this.jsbh;
    }

    public void setJsbh(String value) {
        this.jsbh = value;
    }
    public String getJsh() {
        return this.jsh;
    }

    public void setJsh(String value) {
        this.jsh = value;
    }
    public String getRybh() {
        return this.rybh;
    }

    public void setRybh(String value) {
        this.rybh = value;
    }
    public String getYylx() {
        return this.yylx;
    }

    public void setYylx(String value) {
        this.yylx = value;
    }

    public java.util.Date getYysj() {
        return this.yysj;
    }

    public void setYysj(java.util.Date value) {
        this.yysj = value;
    }

    public String getSpr() {
        return this.spr;
    }

    public void setSpr(String value) {
        this.spr = value;
    }

    public java.util.Date getSpsj() {
        return this.spsj;
    }

    public void setSpsj(java.util.Date value) {
        this.spsj = value;
    }

    public String getSpjg() {
        return this.spjg;
    }

    public void setSpjg(String value) {
        this.spjg = value;
    }
    public String getSpnr() {
        return this.spnr;
    }

    public void setSpnr(String value) {
        this.spnr = value;
    }
    public String getState() {
        return this.state;
    }

    public void setState(String value) {
        this.state = value;
    }
    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String value) {
        this.creator = value;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date value) {
        this.createtime = value;
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

    public String getYylxString() {
        return yylxString;
    }

    public void setYylxString(String yylxString) {
        this.yylxString = yylxString;
    }
}
