package com.uf88.backend.monitor.vo;

/**
 * 返回状态
 * @author：
 * @since：
 * @version:1.0
 */
public enum RespDtoStatusEnum {
	SUCCESS("000000","成功"),
	FAIL("000009","失败");
	//构造函数
	private RespDtoStatusEnum(String code,String msg){ 
		this.msg = msg;
		this.code=code;  
	} 
	/**
	 * 描述
	 */
  	private String code;
  	private String msg;
	public String getMsg() {
		return msg;
	}
	public String getCode() {
		return code;
	}
	
}
