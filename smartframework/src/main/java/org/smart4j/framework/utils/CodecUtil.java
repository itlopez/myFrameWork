package org.smart4j.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author ：lopez
 * @date ：Created in 2019/12/19 12:46
 * @description：
 * @modified By：
 */
public class CodecUtil {

	private static final Logger logger = LoggerFactory.getLogger(CodecUtil.class);

	/**
	 * 将 URL 编码
	 */
	public static String encodeURL(String str) {
		String target;
		try {
			target = URLEncoder.encode(str, "UTF-8");
		} catch (Exception e) {
			logger.error("编码出错！", e);
			throw new RuntimeException(e);
		}
		return target;
	}

	/**
	 * 将 URL 解码
	 */
	public static String decodeURL(String str) {
		String target;
		try {
			target = URLDecoder.decode(str, "UTF-8");
		} catch (Exception e) {
			logger.error("解码出错！", e);
			throw new RuntimeException(e);
		}
		return target;
	}

}
