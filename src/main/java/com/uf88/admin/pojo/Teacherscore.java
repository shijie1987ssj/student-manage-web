package com.uf88.admin.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：</b>Teacherscore:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分10秒 星期三 
 * @version:1.0
 */
public class Teacherscore implements Serializable {
	private static final long serialVersionUID = 1L;
		/**	 *	 */	private Integer teacherid;	/**	 *	 */	private Integer teacherscore;	public Integer getTeacherid() {	    return this.teacherid;	}	public void setTeacherid(Integer teacherid) {	    this.teacherid=teacherid;	}	public Integer getTeacherscore() {	    return this.teacherscore;	}	public void setTeacherscore(Integer teacherscore) {	    this.teacherscore=teacherscore;	}	@Override	public String toString() {	StringBuffer sb = new StringBuffer();	sb.append("Teacherscore ["); 	sb.append("'teacherid':'" + this.getTeacherid() + "',"); 	sb.append("'teacherscore':'" + this.getTeacherscore() + "'");	sb.append("]");	return sb.toString();	}
}

