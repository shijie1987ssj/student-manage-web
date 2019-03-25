package com.uf88.admin.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 描述：</b>StudentQuery:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分09秒 星期三
 * @version:1.0
 */
public class StudentQuery implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 学生编号，主键
	 */
	private Integer stuid;
	/**
	 * 学生姓名
	 */
	private String stuname;
	/**
	 * 密码
	 */
	private String stupass;
	/**
	 * 年龄
	 */
	private Integer stuage;
	/**
	 * 性别
	 */
	private String stusex;
	/**
	 * 所在班级，外键
	 */
	private String stuclass;
	/**
	 * 所在院系，外键
	 */
	private String stuclub;
	/**
	 * QQ号
	 */
	private Integer stuqq;
	/**
	 * 电话号码
	 */
	private String stutelephone;
	/**
	 * 邮箱
	 */
	private String stuemail;
	/**
	 * 所在年级，外键
	 */
	private String stugrade;

	/**
	 * 学生编号
	 */
	private String stuidStr;

	public Integer getStuid() {
		return this.stuid;
	}

	public void setStuid(Integer stuid) {
		this.stuid = stuid;
	}

	public String getStuname() {
		return this.stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getStupass() {
		return this.stupass;
	}

	public void setStupass(String stupass) {
		this.stupass = stupass;
	}

	public Integer getStuage() {
		return this.stuage;
	}

	public void setStuage(Integer stuage) {
		this.stuage = stuage;
	}

	public String getStusex() {
		return this.stusex;
	}

	public void setStusex(String stusex) {
		this.stusex = stusex;
	}

	public String getStuclass() {
		return this.stuclass;
	}

	public void setStuclass(String stuclass) {
		this.stuclass = stuclass;
	}

	public String getStuclub() {
		return this.stuclub;
	}

	public void setStuclub(String stuclub) {
		this.stuclub = stuclub;
	}

	public Integer getStuqq() {
		return this.stuqq;
	}

	public void setStuqq(Integer stuqq) {
		this.stuqq = stuqq;
	}

	public String getStuemail() {
		return this.stuemail;
	}

	public void setStuemail(String stuemail) {
		this.stuemail = stuemail;
	}

	public String getStugrade() {
		return this.stugrade;
	}

	public void setStugrade(String stugrade) {
		this.stugrade = stugrade;
	}

	public String getStuidStr() {
		return stuidStr;
	}

	public void setStuidStr(String stuidStr) {
		this.stuidStr = stuidStr;
	}

	public String getStutelephone() {
		return stutelephone;
	}

	public void setStutelephone(String stutelephone) {
		this.stutelephone = stutelephone;
	}

}
