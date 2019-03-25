package com.uf88.admin.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 描述：</b>TeacherscoreQuery:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * 
 * @since：2018年09月19日 14时12分10秒 星期三
 * @version:1.0
 */
public class TeacherscoreQuery implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private Integer teacherid;
	/**
	 *
	 */
	private Integer teacherscore;

	private String showNoScore;

	private String showScore;

	public Integer getTeacherid() {
		return this.teacherid;
	}

	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}

	public Integer getTeacherscore() {
		return this.teacherscore;
	}

	public void setTeacherscore(Integer teacherscore) {
		this.teacherscore = teacherscore;
	}

	public String getShowNoScore() {
		return showNoScore;
	}

	public void setShowNoScore(String showNoScore) {
		this.showNoScore = showNoScore;
	}

	public String getShowScore() {
		return showScore;
	}

	public void setShowScore(String showScore) {
		this.showScore = showScore;
	}

}
