package com.uf88.admin.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 描述：</b>TeacherQuery:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月23日 22时33分42秒 星期日
 * @version:1.0
 */
public class TeacherQuery implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 教师编号
	 */
	private Integer teacherid;
	/**
	 * 教师姓名
	 */
	private String teachername;
	/**
	 * 年龄
	 */
	private Integer teacherage;
	/**
	 * 性别
	 */
	private String teachersex;
	/**
	 * 密码
	 */
	private String teacherpass;
	/**
	 * 授课班级，外键
	 */
	private String teacherclass;
	/**
	 * 所在院系，外键
	 */
	private String teacherclub;
	/**
	 * 所带课程，外键
	 */
	private String subject;
	/**
	 * 毕业院校
	 */
	private String school;
	/**
	 * 教师邮箱
	 */
	private String teacheremail;
	/**
	 * 是否评价
	 */
	private String pingjia;
	/**
	 * 教师编号
	 */
	private String teacheridStr;

	public Integer getTeacherid() {
		return this.teacherid;
	}

	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}

	public String getTeachername() {
		return this.teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public Integer getTeacherage() {
		return this.teacherage;
	}

	public void setTeacherage(Integer teacherage) {
		this.teacherage = teacherage;
	}

	public String getTeachersex() {
		return this.teachersex;
	}

	public void setTeachersex(String teachersex) {
		this.teachersex = teachersex;
	}

	public String getTeacherpass() {
		return this.teacherpass;
	}

	public void setTeacherpass(String teacherpass) {
		this.teacherpass = teacherpass;
	}

	public String getTeacherclass() {
		return this.teacherclass;
	}

	public void setTeacherclass(String teacherclass) {
		this.teacherclass = teacherclass;
	}

	public String getTeacherclub() {
		return this.teacherclub;
	}

	public void setTeacherclub(String teacherclub) {
		this.teacherclub = teacherclub;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getTeacheremail() {
		return this.teacheremail;
	}

	public void setTeacheremail(String teacheremail) {
		this.teacheremail = teacheremail;
	}

	public String getPingjia() {
		return this.pingjia;
	}

	public void setPingjia(String pingjia) {
		this.pingjia = pingjia;
	}

	public String getTeacheridStr() {
		return teacheridStr;
	}

	public void setTeacheridStr(String teacheridStr) {
		this.teacheridStr = teacheridStr;
	}
}
