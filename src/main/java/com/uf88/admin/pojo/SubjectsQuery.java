package com.uf88.admin.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
/**
 * 描述：</b>SubjectsQuery:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public class SubjectsQuery implements Serializable {
	private static final long serialVersionUID = 1L;
		/**	 *	 */	private String subjectname;	/**	 *	 */	private String clubname;	public String getSubjectname() {	    return this.subjectname;	}	public void setSubjectname(String subjectname) {	    this.subjectname=subjectname;	}	public String getClubname() {	    return this.clubname;	}	public void setClubname(String clubname) {	    this.clubname=clubname;	}
}

