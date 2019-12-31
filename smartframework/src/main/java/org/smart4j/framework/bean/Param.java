package org.smart4j.framework.bean;

import org.smart4j.framework.utils.CastUtil;

import java.util.Map;
import java.util.Objects;

/**
 * @author ：lopez
 * @date ：Created in 2019/12/19 11:55
 * @description：
 * @modified By：
 */
public class Param {

	private Map<String, Object> paramMap;

	public Param(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}

	public long getLong(String name) {
		return CastUtil.castLong(paramMap.get(name));
	}

	public Map<String, Object> getMap() {
		return paramMap;
	}

	public boolean isEmpty(){
		return Objects.isNull(paramMap);
	}

}
