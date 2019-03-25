package com.uf88.admin.web.AdminConst;

import java.util.LinkedHashMap;
import java.util.Map;

import com.uf88.uf88core.util.PropertiesUtils;

public class AdminConst {
	private static String UkeyCaPath;

	private static String UkeyCrlPath;

	private static String PwdSecretPfxPath;

	private static String PwdSecretPfxPassword;

	private static String PwdSecretServerRandomKey;

	private static String systemName;

	public static String getSystemName() {
		if (systemName == null) {
			systemName = PropertiesUtils.getValueByProperty("config/application.properties", "sys.name");
		}
		return systemName;
	}

	/**
	 * U盾CA证书
	 * 
	 * @return
	 */
	public static String getUkeyCaPath() {
		if (UkeyCaPath == null) {
			UkeyCaPath = PropertiesUtils.getValueByProperty("config/application.properties", "UkeyCaPath");
		}
		return UkeyCaPath;
	}

	/**
	 * U盾吊销列表
	 * 
	 * @return
	 */
	public static String getUkeyCrlPath() {
		if (UkeyCrlPath == null) {
			UkeyCrlPath = PropertiesUtils.getValueByProperty("config/application.properties", "UkeyCrlPath");
		}
		return UkeyCrlPath;
	}

	/**
	 * 密码控件验签PFX文件 路径
	 * 
	 * @return
	 */
	public static String getPwdSecretPfxPath() {
		if (PwdSecretPfxPath == null) {
			PwdSecretPfxPath = PropertiesUtils.getValueByProperty("config/application.properties", "PwdSecretPfxPath");
		}
		return PwdSecretPfxPath;
	}

	/**
	 * 密码控件验签PFX文件 密码
	 * 
	 * @return
	 */
	public static String getPwdSecretPfxPassword() {
		if (PwdSecretPfxPassword == null) {
			PwdSecretPfxPassword = PropertiesUtils.getValueByProperty("config/application.properties",
					"PwdSecretPfxPassword");
		}
		return PwdSecretPfxPassword;
	}

	/**
	 * 密码控件验签 ServerRandomKey
	 * 
	 * @return
	 */
	public static String getPwdSecretServerRandomKey() {
		if (PwdSecretServerRandomKey == null) {
			PwdSecretServerRandomKey = PropertiesUtils.getValueByProperty("config/application.properties",
					"PwdSecretServerRandomKey");
		}
		return PwdSecretServerRandomKey;
	}

	/**
	 * 登记类型
	 */
	public static enum LoginUserTypeEnum {
		stu("学生", 1), teach("老师", 2), leader("领导", 3), admin("管理员", 4);

		private String msg;
		private int code;
		private static LinkedHashMap<String, String> map;

		private LoginUserTypeEnum(String msg, int code) {
			this.msg = msg;
			this.code = code;
		}

		public static Map<String, String> getMap() {
			if (map == null) {
				map = new LinkedHashMap<String, String>();
				for (LoginUserTypeEnum obj : LoginUserTypeEnum.values()) {
					map.put(String.valueOf(obj.getCode()), obj.getMsg());
				}
			}
			return map;
		}

		public static String getName(int index) {
			for (LoginUserTypeEnum c : LoginUserTypeEnum.values()) {
				if (c.getCode() == index) {
					return c.msg;
				}
			}
			return null;
		}

		public String getMsg() {
			return msg;
		}

		public int getCode() {
			return code;
		}
	}

}
