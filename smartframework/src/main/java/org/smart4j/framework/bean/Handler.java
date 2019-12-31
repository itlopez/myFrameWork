package org.smart4j.framework.bean;

import java.lang.reflect.Method;

/**
 * @author ：lopez
 * @date ：Created in 2019/12/19 11:32
 * @description：
 * @modified By：
 */
public class Handler {

	private Class<?> controllerClass;

	private Method actionMethod;

	public Handler(Class<?> controllerClass, Method actionMethod) {
		this.controllerClass = controllerClass;
		this.actionMethod = actionMethod;
	}

	public Method getActionMethod() {
		return actionMethod;
	}

	public Class<?> getControllerClass() {
		return controllerClass;
	}
}
