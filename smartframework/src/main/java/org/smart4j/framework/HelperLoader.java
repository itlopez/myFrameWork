package org.smart4j.framework;

import org.smart4j.framework.helper.BeanHelper;
import org.smart4j.framework.helper.ClassHelper;
import org.smart4j.framework.helper.ControllerHelper;
import org.smart4j.framework.helper.IocHelper;
import org.smart4j.framework.utils.ClassUtil;

/**
 * @author ：lopez
 * @date ：Created in 2019/12/19 11:41
 * @description：
 * @modified By：
 */
public final class HelperLoader {

	public static void init() {
		Class<?>[] classList = {ClassHelper.class, BeanHelper.class, IocHelper.class, ControllerHelper.class};
		for (Class<?> cls : classList) {
			ClassUtil.loadClass(cls.getName(), false);
		}
		try {
			//默认全部依赖注入,Class.forName()默认会加载static块代码
			Class.forName(IocHelper.class.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
