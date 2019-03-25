package com.uf88.admin.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：</b>Leader:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public class Leader implements Serializable {
	private static final long serialVersionUID = 1L;
		/**	 *	 */	private String leadername;	/**	 *	 */	private String leaderpass;	public String getLeadername() {	    return this.leadername;	}	public void setLeadername(String leadername) {	    this.leadername=leadername;	}	public String getLeaderpass() {	    return this.leaderpass;	}	public void setLeaderpass(String leaderpass) {	    this.leaderpass=leaderpass;	}	@Override	public String toString() {	StringBuffer sb = new StringBuffer();	sb.append("Leader ["); 	sb.append("'leadername':'" + this.getLeadername() + "',"); 	sb.append("'leaderpass':'" + this.getLeaderpass() + "'");	sb.append("]");	return sb.toString();	}
}

