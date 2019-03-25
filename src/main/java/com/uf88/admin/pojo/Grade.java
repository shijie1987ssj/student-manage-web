package com.uf88.admin.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：</b>Grade:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public class Grade implements Serializable {
	private static final long serialVersionUID = 1L;
		/**	 *	 */	private String gradename;	public String getGradename() {	    return this.gradename;	}	public void setGradename(String gradename) {	    this.gradename=gradename;	}	@Override	public String toString() {	StringBuffer sb = new StringBuffer();	sb.append("Grade ["); 	sb.append("'gradename':'" + this.getGradename() + "'");	sb.append("]");	return sb.toString();	}
}

