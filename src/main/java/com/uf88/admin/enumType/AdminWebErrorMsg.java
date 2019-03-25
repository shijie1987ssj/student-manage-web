package com.uf88.admin.enumType;

public enum AdminWebErrorMsg {
	ERROR_CODE_CUSTOM("自定义错误",-1),
	ERROR_CODE_UNKNOW("未知错误",0),	
	ERROR_CODE_PARAM_IS_NULL("参数为空", 11),
	ERROR_CODE_PARAM_BIND("参数绑定错误", 12), 
	ERROR_CODE_PARAM_TYPE("参数类型错误", 13),
	ERROR_CODE_PARAM_FORMAT("参数格式错误", 14),
	ERROR_CODE_UNAUTHORIZED("没有权限", 21), 
	ERROR_CODE_PHONE_IS_USED("手机号已存在", 22),
	ERROR_CODE_MAIL_IS_USED("邮箱已存在", 23),
	ERROR_CODE_RESPONE_IS_NULL("返回报文为空", 31),
	ERROR_CODE_RESPONE_BODY_IS_NULL("返回报文内容为空", 31),
	ERROR_CODE_LOGOUT("尚未登录", 40),
	ERROR_CODE_NO_USER("找不到指定的用户", 41),
	ERROR_CODE_NO_ACCOUNT("找不到指定的账户", 42),
	ERROR_CODE_NO_PROJECT("找不到指定的产品", 43),
	ERROR_CODE_PARSDATE("时间格式转换异常",44),
	ERROR_CODE_LOGINERROR("用户名或者密码错误", 45),
	ERROR_CODE_CREATE_CACHE ("创建缓存失败", 51),
	ERROR_CODE_SIGN_INVALID ("报文校验失败", 61),
	ERROR_CODE_NETWORK ("网络通信错误", 62),
	
	APPLY_LIST_ERROR ("查询出让/受让申请错误", 101),
	DEAL_CERTIFICATE_LIST_ERROR ("生成交易凭证列表错误", 102),
	DEAL_SELLER_APPLY_ERROR ("生成转让申请书错误", 103),
	SUCCESS("成功", 1);
	
	// 成员变量
	private  String msg ;
	private  int code;

	// 构造方法
	private AdminWebErrorMsg(String msg, int code) {
		this.msg = msg;
		this.code = code;
	}

	public  String getMsg() {
		return msg;
	}

	public int getCode() {
		return code;
	}
}
