package com.uf88.admin.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：</b>Admin:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;
		/**	 *	 */	private String adminname;	/**	 *	 */	private String adminpassword;	public String getAdminname() {	    return this.adminname;	}	public void setAdminname(String adminname) {	    this.adminname=adminname;	}	public String getAdminpassword() {	    return this.adminpassword;	}	public void setAdminpassword(String adminpassword) {	    this.adminpassword=adminpassword;	}	@Override	public String toString() {	StringBuffer sb = new StringBuffer();	sb.append("Admin ["); 	sb.append("'adminname':'" + this.getAdminname() + "',"); 	sb.append("'adminpassword':'" + this.getAdminpassword() + "'");	sb.append("]");	return sb.toString();	}
}

