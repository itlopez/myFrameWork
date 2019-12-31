package org.smart4j.framework.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author ：lopez
 * @date ：Created in 2019/12/19 11:31
 * @description：
 * @modified By：
 */
public class Request {

	/**
	 * 请求方法
	 */
	private String requestMethod;
	/**
	 * 请求路径
	 */
	private String requestPath;

	public Request(String requestMethod, String requestPath) {
		this.requestMethod = requestMethod;
		this.requestPath = requestPath;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}
