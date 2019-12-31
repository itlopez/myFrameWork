package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Request;
import org.smart4j.framework.utils.ArrayUtil;
import org.smart4j.framework.utils.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ：lopez
 * @date ：Created in 2019/12/19 11:33
 * @description：通过ClassHelper加载所有Connoller类，通过反射获取所有带有Action注解的方法，进而获取Action注解中的请求方法和请求路径，封装Request对象和Handler对象的映射关系。
 * @modified By：
 */
public class ControllerHelper {

	//请求get:/customer对应是哪个类的那个方法
	private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

	static {
		//调用ClassHelper.getControllerClassSet()这个静态方法时，该类会被初始化，静态块、静态域会被初始化
		Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
		if (CollectionUtil.isNotEmpty(controllerClassSet)) {
			for (Class<?> controllerClass : controllerClassSet) {
				Method[] methods = controllerClass.getDeclaredMethods();
				for (Method method : methods) {
					if (method.isAnnotationPresent(Action.class)) {
						Action action = method.getAnnotation(Action.class);
						String mapping = action.value();
						if (mapping.matches("\\w+:/\\w*")) {
							String[] arrays = mapping.split(":");
							if (ArrayUtil.isNotEmpty(arrays) && arrays.length == 2) {
								String requestMethod = arrays[0];
								String requestPath = arrays[1];
								Request request = new Request(requestMethod, requestPath);
								Handler handler = new Handler(controllerClass, method);
								ACTION_MAP.put(request, handler);
							}
						}
					}
				}
			}
		}
	}

	public static Handler getHandler(String requestMethod, String requestPath) {
		Request request = new Request(requestMethod, requestPath);
		return ACTION_MAP.get(request);
	}
}
