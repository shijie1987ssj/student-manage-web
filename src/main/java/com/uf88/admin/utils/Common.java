package com.uf88.admin.utils;

import com.uf88.uf88core.util.ConfigUtil;

public class Common {
	public static String getValueByProperty(String key) {
		return ConfigUtil.getInstance().getValueByProperty("/config/uct_client.properties", key);
	}

	public static String getValueByProperty(String key, String filePath) {
		String defaultPath = "/config/uct_client.properties";
		if (filePath == null) {
			filePath = defaultPath;
		}
		return ConfigUtil.getInstance().getValueByProperty(filePath, key);
	}
}
