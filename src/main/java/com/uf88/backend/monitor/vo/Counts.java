package com.uf88.backend.monitor.vo;

import java.io.Serializable;

public class Counts implements Serializable{
	long diskCount;
	long cpuCount;
	long memCount;
	long swapCount;
	
	public long getSwapCount() {
		return swapCount;
	}
	public void setSwapCount(long swapCount) {
		this.swapCount = swapCount;
	}
	public long getDiskCount() {
		return diskCount;
	}
	public void setDiskCount(long diskCount) {
		this.diskCount = diskCount;
	}
	public long getCpuCount() {
		return cpuCount;
	}
	public void setCpuCount(long cpuCount) {
		this.cpuCount = cpuCount;
	}
	public long getMemCount() {
		return memCount;
	}
	public void setMemCount(long memCount) {
		this.memCount = memCount;
	}
	
}
