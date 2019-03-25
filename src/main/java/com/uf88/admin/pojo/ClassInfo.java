package com.uf88.admin.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：</b>ClassInfo:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public class ClassInfo implements Serializable {
	private static final long serialVersionUID = 1L;
		/**	 *	 */	private String classname;	public String getClassname() {	    return this.classname;	}	public void setClassname(String classname) {	    this.classname=classname;	}	@Override	public String toString() {	StringBuffer sb = new StringBuffer();	sb.append("ClassInfo ["); 	sb.append("'classname':'" + this.getClassname() + "'");	sb.append("]");	return sb.toString();	}
}

