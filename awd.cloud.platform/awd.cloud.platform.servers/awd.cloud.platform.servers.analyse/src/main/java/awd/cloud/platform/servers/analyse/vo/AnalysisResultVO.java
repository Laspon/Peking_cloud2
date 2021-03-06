package awd.cloud.platform.servers.analyse.vo;

import com.ace.cache.annotation.Cache;

import awd.cloud.platform.servers.analyse.utils.CacheUtils;
import awd.framework.common.model.Model;

public class AnalysisResultVO implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5148822862831335377L;

	private String jsbh;
	private String dz;
	private String count;

	public String getJsbh() {
		return jsbh;
	}

	public void setJsbh(String jsbh) {
		this.jsbh = jsbh;
	}

	public String getDz() {
		return dz;
	}

	public void setDz(String dz) {
		this.dz = dz;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getDzString() {
		return CacheUtils.get().getDictionarys("XZQH", this.dz);
	}

	public String getJsbhString() {
		return CacheUtils.get().getJsbhString( this.jsbh);
	}
}
