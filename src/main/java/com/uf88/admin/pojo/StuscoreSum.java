package com.uf88.admin.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：</b>Teacherscore:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分10秒 星期三
 * @version:1.0
 */
public class StuscoreSum implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer sumnum;
	private String stuclub;
	private String stuclass;
	private Integer maxscore;
	private Integer minscore;
	private Integer avgscore;
	private Integer pass;
	private Integer nopass;
	private Integer gradec;
	private Integer gradeb;
	private Integer gradea;

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("  [");
		sb.append("]");
		return sb.toString();
	}

	public Integer getSumnum() {
		return sumnum;
	}

	public void setSumnum(Integer sumnum) {
		this.sumnum = sumnum;
	}

	public Integer getMinscore() {
		return minscore;
	}

	public void setMinscore(Integer minscore) {
		this.minscore = minscore;
	}

	public Integer getMaxscore() {
		return maxscore;
	}

	public void setMaxscore(Integer maxscore) {
		this.maxscore = maxscore;
	}

	public Integer getGradec() {
		return gradec;
	}

	public void setGradec(Integer gradec) {
		this.gradec = gradec;
	}

	public Integer getGradea() {
		return gradea;
	}

	public void setGradea(Integer gradea) {
		this.gradea = gradea;
	}

	public Integer getNopass() {
		return nopass;
	}

	public void setNopass(Integer nopass) {
		this.nopass = nopass;
	}

	public Integer getGradeb() {
		return gradeb;
	}

	public void setGradeb(Integer gradeb) {
		this.gradeb = gradeb;
	}

	public Integer getAvgscore() {
		return avgscore;
	}

	public void setAvgscore(Integer avgscore) {
		this.avgscore = avgscore;
	}

	public Integer getPass() {
		return pass;
	}

	public void setPass(Integer pass) {
		this.pass = pass;
	}

	public String getStuclub() {
		return stuclub;
	}

	public void setStuclub(String stuclub) {
		this.stuclub = stuclub;
	}

	public String getStuclass() {
		return stuclass;
	}

	public void setStuclass(String stuclass) {
		this.stuclass = stuclass;
	}
}
