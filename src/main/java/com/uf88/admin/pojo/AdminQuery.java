package com.uf88.admin.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
/**
 * 描述：</b>AdminQuery:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public class AdminQuery implements Serializable {
	private static final long serialVersionUID = 1L;
		/**	 *	 */	private String adminname;	/**	 *	 */	private String adminpassword;	public String getAdminname() {	    return this.adminname;	}	public void setAdminname(String adminname) {	    this.adminname=adminname;	}	public String getAdminpassword() {	    return this.adminpassword;	}	public void setAdminpassword(String adminpassword) {	    this.adminpassword=adminpassword;	}
}

