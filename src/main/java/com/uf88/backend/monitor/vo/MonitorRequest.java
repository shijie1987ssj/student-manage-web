package com.uf88.backend.monitor.vo;

import java.io.Serializable;
import java.util.List;

public class MonitorRequest implements Serializable{
	String IP;
	double user;
	double sys;
	List<DISK> diskList;
	String diskDesc;
	long memAv;
	long memUsed;
	long memFree;
	long swapAv;
	long swapUsed;
	long swapFree;
	String  time;
	
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDiskDesc() {
		return diskDesc;
	}
	public void setDiskDesc(String diskDesc) {
		this.diskDesc = diskDesc;
	}
	public String getIP() {
		return IP;
	}
	
	public double getUser() {
		return user;
	}
	public void setUser(double user) {
		this.user = user;
	}
	public double getSys() {
		return sys;
	}
	public void setSys(double sys) {
		this.sys = sys;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	
	public List<DISK> getDiskList() {
		return diskList;
	}
	public void setDiskList(List<DISK> diskList) {
		this.diskList = diskList;
	}
	public long getMemAv() {
		return memAv;
	}
	public void setMemAv(long memAv) {
		this.memAv = memAv;
	}
	public long getMemUsed() {
		return memUsed;
	}
	public void setMemUsed(long memUsed) {
		this.memUsed = memUsed;
	}
	public long getMemFree() {
		return memFree;
	}
	public void setMemFree(long memFree) {
		this.memFree = memFree;
	}
	public long getSwapAv() {
		return swapAv;
	}
	public void setSwapAv(long swapAv) {
		this.swapAv = swapAv;
	}
	public long getSwapUsed() {
		return swapUsed;
	}
	public void setSwapUsed(long swapUsed) {
		this.swapUsed = swapUsed;
	}
	public long getSwapFree() {
		return swapFree;
	}
	public void setSwapFree(long swapFree) {
		this.swapFree = swapFree;
	}
	@Override
	public String toString() {
		return "MonitorRequest [IP=" + IP + ", user=" + user + ", sys=" + sys
				+ ", diskList=" + diskList + ", diskDesc=" + diskDesc
				+ ", memAv=" + memAv + ", memUsed=" + memUsed + ", memFree="
				+ memFree + ", swapAv=" + swapAv + ", swapUsed=" + swapUsed
				+ ", swapFree=" + swapFree + "]";
	}
	
	
	
	
}
