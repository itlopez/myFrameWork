package org.smart4j.framework.utils;
import org.apache.commons.lang3.StringUtils;

public final class StringUtil {

	public static boolean isEmpty(String str){
		if(str!=null)
		{
			str = str.trim();
		}
		return StringUtils.isEmpty(str);
	}

	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}

	public static String[] splitString(String str, String splitStr) {
		return str.split(splitStr);
	}
}
