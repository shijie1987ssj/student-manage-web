package com.uf88.admin.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：</b>Club:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public class Club implements Serializable {
	private static final long serialVersionUID = 1L;
		/**	 *	 */	private String clubname;	public String getClubname() {	    return this.clubname;	}	public void setClubname(String clubname) {	    this.clubname=clubname;	}	@Override	public String toString() {	StringBuffer sb = new StringBuffer();	sb.append("Club ["); 	sb.append("'clubname':'" + this.getClubname() + "'");	sb.append("]");	return sb.toString();	}
}

