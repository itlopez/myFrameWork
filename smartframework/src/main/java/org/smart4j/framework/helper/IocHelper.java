package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.utils.ArrayUtil;
import org.smart4j.framework.utils.CollectionUtil;
import org.smart4j.framework.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author ：lopez
 * @date ：Created in 2019/12/19 11:19
 * @description：依赖注入助手类
 * @modified By：
 */
public final class IocHelper {

	static {
		//获取所有的Bean 类与 Bean 实例之间的映射关系
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if (CollectionUtil.isNotEmpty(beanMap)) {
			//遍历Bean map
			for (Map.Entry<Class<?>, Object> beanEntity : beanMap.entrySet()) {
				// 类
				Class<?> beanClass = beanEntity.getKey();
				//当前类实例
				Object objInstance = beanEntity.getValue();
				//当前类所有的字段
				Field[] beanFileds = beanClass.getDeclaredFields();
				if (ArrayUtil.isNotEmpty(beanFileds)) {
					//遍历字段
					for (Field beanField : beanFileds) {
						//字段的注解有 Inject
						if (beanField.isAnnotationPresent(Inject.class)) {
							// 得到字段的类型
							Class<?> beanFieldClass = beanField.getType();
							//字段实例有注册到bean 容器中
							Object beanFieldInstance = beanMap.get(beanFieldClass);
							if (beanFieldInstance != null) {
								//设置字段的实例
								ReflectionUtil.setFiled(objInstance, beanField, beanFieldInstance);
							}
						}
					}
				}
			}
		}
	}
}
