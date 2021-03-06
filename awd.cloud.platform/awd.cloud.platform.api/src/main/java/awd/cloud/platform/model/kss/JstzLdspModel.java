package awd.cloud.platform.model.kss;

import awd.bj.kss.model.JstzModel;
import awd.bj.kss.model.LdspModel;
import awd.cloud.platform.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JstzLdspModel implements Model{
	private String sz;
	private String taskid;
	private LdspModel ldspEntity;
	private JstzModel jstzEntity;

	
	public JstzModel getJstzEntity() {
		return jstzEntity;
	}

	public void setJstzEntity(JstzModel jstzEntity) {
		this.jstzEntity = jstzEntity;
	}

	public String getSz() {
		return sz;
	}

	public void setSz(String sz) {
		this.sz = sz;
	}
	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public void setLdspEntity(LdspModel ldspEntity) {
		this.ldspEntity = ldspEntity;
	}




	public LdspModel getLdspEntity() {
		return ldspEntity;
	}

}
