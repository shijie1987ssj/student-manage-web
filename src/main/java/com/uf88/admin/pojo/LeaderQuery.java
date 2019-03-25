package com.uf88.admin.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
/**
 * 描述：</b>LeaderQuery:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public class LeaderQuery implements Serializable {
	private static final long serialVersionUID = 1L;
		/**	 *	 */	private String leadername;	/**	 *	 */	private String leaderpass;	public String getLeadername() {	    return this.leadername;	}	public void setLeadername(String leadername) {	    this.leadername=leadername;	}	public String getLeaderpass() {	    return this.leaderpass;	}	public void setLeaderpass(String leaderpass) {	    this.leaderpass=leaderpass;	}
}

