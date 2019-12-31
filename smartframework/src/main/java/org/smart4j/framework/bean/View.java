package org.smart4j.framework.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lopez
 * @date ：Created in 2019/12/19 11:56
 * @description：
 * @modified By：
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class View {

	private String path;

	private Map<String, Object> model;

	public View(String path) {
		this.path = path;
		model = new HashMap<String, Object>();
	}

	public View addModel(String key, Object value) {
		model.put(key, value);
		return this;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, Object> getModel() {
		return model;
	}


}
