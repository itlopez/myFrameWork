package org.smart4j.framework.utils;

public final class CastUtil {
	public static String castString(Object obj) {
		return CastUtil.castString(obj,"");
	}
	public static String castString(Object obj,String defaultValue){
		return obj !=null ? String.valueOf(obj) : defaultValue;
	}
	public static double castDouble(Object obj){
		return CastUtil.castDouble(obj,0);
	}
	public static double castDouble(Object obj, double defaultValue){
		double doubleValue = defaultValue;
		if(obj != null){
			String strValue = castString(obj);
			if(StringUtil.isNotEmpty(strValue)){
				try
				{
					doubleValue=Double.parseDouble(strValue);
				} catch(NumberFormatException ex){
					doubleValue = defaultValue;
				}
			}
		}
		return doubleValue;
	}
	public static int castInt(Object obj){
		return CastUtil.castInt(obj,0);
	}
	public static int castInt(Object obj,int defaultValue){
		int intValue = defaultValue;
		if(obj != null){
			String strValue = castString(obj);
			if(StringUtil.isNotEmpty(strValue)){
				try{
					intValue = Integer.parseInt(strValue);
				} catch(NumberFormatException ex){
					intValue = defaultValue;
				}
			}
		}
		return intValue;
	}
	public static boolean castBoolean(Object obj){
		return castBoolean(obj,false);
	}
	public static boolean castBoolean(Object obj,boolean defaultValue){
		boolean booleanValue = defaultValue;
		if(obj!=null)
		{
			String strValue = castString(obj);
			if(StringUtil.isNotEmpty(strValue)){
				try{
					booleanValue = Boolean.parseBoolean(strValue);
				}catch(NumberFormatException ex){
					booleanValue = defaultValue;
				}
			}
		}
		return booleanValue;
	}
	public static long castLong(Object obj){
		return castLong(obj,0);
	}
	public static long castLong(Object obj,long defaultValue){
		long longValue = defaultValue;
		if(obj!=null)
		{
			String strValue = castString(obj);
			if(StringUtil.isNotEmpty(strValue)){
				try{
					longValue = Long.parseLong(strValue);
				}catch(NumberFormatException ex){
					longValue = defaultValue;
				}
			}
		}
		return longValue;
	}
}
