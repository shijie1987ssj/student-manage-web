package com.uf88.admin.utils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {

	public static void setLong2Session(HttpServletRequest request, String key,
			Long value) {
		request.getSession().setAttribute(key, value);
	}

	public static void setString2Session(HttpServletRequest request,
			String key, String value) {
		request.getSession().setAttribute(key, value);
	}

	public static void setIntegerSession(HttpServletRequest request,
			String key, Integer value) {
		request.getSession().setAttribute(key, value);
	}

	public static Long getLongFromSession(HttpServletRequest request,
			String key, Long defaultValue) {
		Long ret = defaultValue;

		if (request.getSession().getAttribute(key) != null) {
			ret = Long.valueOf((String) request.getSession().getAttribute(key));
		}

		return ret;
	}

	public static String getStringFromSession(HttpServletRequest request,
			String key, String defaultValue) {
		String ret = defaultValue;

		if (request.getSession().getAttribute(key) != null) {
			ret = (String) request.getSession().getAttribute(key);
		}

		return ret;
	}

	public static Integer getIntegerFromSession(HttpServletRequest request,
			String key, Integer defaultValue) {
		Integer ret = defaultValue;

		if (request.getSession().getAttribute(key) != null) {
			ret = (Integer) request.getSession().getAttribute(key);
		}
		return ret;
	}

	public static Auth getLoginUser(HttpServletRequest request) {
		return AuthTools.getAuth(request);
	}

	public static void removeLoginUser(HttpServletRequest request) {
		AuthTools.removeAuth(request);
	}
 

	public static String getCode() {
		String result = "";
		for (int i = 0; i < 6; i++) {
			int intVal = (int) (Math.random() * 26.0D + 97.0D);
			result = result + (char) intVal;
		}
		return result;
	}

	public static String getNumCode() {
		int intVal = (int) ((Math.random() * 9.0D + 1.0D) * 100000.0D);
		String result = String.valueOf(intVal);
		return result;
	}

	public static String getBankAmount() {
		// int intVal = (int)(Math.random() * 4.0D + 1.0D);
		double doubleVal = Math.random() * 4.0D + 1.0D;
		DecimalFormat df = new DecimalFormat("#.00");
		String result = String.valueOf(df.format(doubleVal));
		return result;
	}
	
	public static  boolean checkRoleIn(String rolesStr,String role){
		String[] roles=rolesStr.split(",");
		boolean bl=false;
		if(roles.length>0){
			for(String r:roles){
				if(role.equals(r)){
					bl=true;
					break;
				}
			}
		}		
		return bl;
	}
	
}
