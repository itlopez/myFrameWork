package org.smart4j.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：lopez
 * @date ：Created in 2019/12/18 19:51
 * @description：反射工具类
 * @modified By：
 */
public class ReflectionUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

	/**
	 * 创建实例
	 * @param cls
	 * @return
	 */
	public static Object newInstance(Class<?> cls) {
		Object instance;
		try {
			instance = cls.newInstance();
		} catch (Exception e) {
			LOGGER.error("new install failure ", e);
			throw new RuntimeException(e);
		}
		return instance;
	}

	/**
	 * 调用方法
	 * @param obj
	 * @param method
	 * @param args
	 * @return
	 */
	public static Object invokeMethod(Object obj, Method method, Object... args) {
		Object result;
		try {
			method.setAccessible(true);
			result = method.invoke(obj, args);
		} catch (InvocationTargetException in){
			in.getCause().printStackTrace();
			throw new RuntimeException(in);
		} catch (Exception e) {
			LOGGER.error("invoke method failure", e);
			throw new RuntimeException(e);
		}
		return result;
	}

	/**
	 * 设置成员变量的值
	 * @param obj
	 * @param field
	 * @param value
	 */
	public static void setFiled(Object obj, Field field, Object value) {
		try {
			field.setAccessible(true);
			field.set(obj, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
