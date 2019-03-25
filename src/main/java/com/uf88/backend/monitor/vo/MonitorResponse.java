package com.uf88.backend.monitor.vo;
import java.io.Serializable;

public class MonitorResponse implements Serializable{
	
	private String code;
	private String message;
	private MonitorResponse response;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MonitorResponse getResponse() {
		return response;
	}

	public void setResponse(MonitorResponse response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "MonitorResponse [code=" + code + ", message=" + message
				+ ", response=" + response + "]";
	}

	

}
