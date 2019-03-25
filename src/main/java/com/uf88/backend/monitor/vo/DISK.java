package com.uf88.backend.monitor.vo;

import java.io.Serializable;

public class DISK implements Serializable{
	String devName;
	String type;
	String typeName;
	long size;
	long remain;
	long used;
	double rate;
	long reads;
	long writes;
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public long getRemain() {
		return remain;
	}
	public void setRemain(long remain) {
		this.remain = remain;
	}
	public long getUsed() {
		return used;
	}
	public void setUsed(long used) {
		this.used = used;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public long getReads() {
		return reads;
	}
	public void setReads(long reads) {
		this.reads = reads;
	}
	public long getWrites() {
		return writes;
	}
	public void setWrites(long writes) {
		this.writes = writes;
	}
	
}
