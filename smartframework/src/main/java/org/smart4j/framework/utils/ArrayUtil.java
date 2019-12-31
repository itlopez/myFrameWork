package org.smart4j.framework.utils;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author ：lopez
 * @date ：Created in 2019/12/19 11:25
 * @description：
 * @modified By：
 */
public class ArrayUtil {

	public static boolean isNotEmpty(Object[] array) {
		return !ArrayUtils.isEmpty(array);
	}

	public static boolean isEmpty(Object[] array) {
		return ArrayUtils.isEmpty(array);
	}
}
